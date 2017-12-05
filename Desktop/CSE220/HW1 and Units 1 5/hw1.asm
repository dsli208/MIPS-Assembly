# Homework #1 REGRADE SUBMISSION
# name: David S. Li
# sbuid: 110328771
# CSE 220, Section 01

.data
.align 2
	numargs: .word 0
	integer: .word 0
	fromBase: .word 0
	toBase: .word 0
	ErrString: .asciiz "ERROR\n"
	buffer: .ascii "                               "
	newLine: .asciiz "\n"
	# Extra data vars
	numLowCons: .word 50
	numHighCons: .word 57
	letLowCons: .word 65
	letHighCons: .word 70
	resultString: .asciiz "The final converted result is "
# Helper macro for grabbing command line arguments
.macro load_args
	sw $a0, numargs
	lw $t0, 0($a1)
	sw $t0, integer
	lw $t0, 4($a1)
	sw $t0, fromBase
	lw $t0, 8($a1)
	sw $t0, toBase
.end_macro

.text
.globl main
main: 
	load_args() # only called once
	lw $t0, numargs
	move $t0, $a0
	bne $t0, 3, error # not 3 arguments, error

	# Check argument length - starting with fromBase
	lw $t0, fromBase
	lb $t1, 0($t0) #load the first character
	beqz $t1, error #If first character is null: length is 0, length != 1
	#attempt to load additional chars - done already below
	#addi $t0 $t0 1
	#lb $t5 0($t0)
	#bnez $t5, error # more than one character, ERROR
	checkFromBase:
		# if between 2 and 9
		analyzeNumFromBase:
			lw $t5, numLowCons
			blt $t1, $t5, error
			lw $t5, numHighCons
			bgt $t1, $t5, analyzeLettFromBase
			addi $t1 $t1 -48
			move $a0, $t1
			j checkOneCharFromBase
		analyzeLettFromBase: # or between A and F
			lw $t5, letLowCons
			blt $t1, $t5, error
			lw $t5, letHighCons
			bgt $t1, $t5, error
			addi $t1, $t1, -55
			move $a0, $t1
	checkOneCharFromBase:
	addi $t0, $t0, 1 #increment pointer to the next character
	lb $t1, 0($t0) #Load the next character
	bnez $t1, error #if not null, more than one character exists, not a valid argument, goes to error
	
	# Now repeat it, but with toBase 
	lw $t2, toBase
	lb $t3, 0($t2) #load the first character of toBase
	beqz $t3, error #if first character is null, 0 character argument ... illegal
	# attempt to load additional chars
	#addi $t2 $t2 1
	#lb $t4 0($t2)
	#bnez $t4 error # next character is not null? ERROR
	# If first character exists, is it in range?
	checkToBase:
		# if between 2 and 9
		analyzeNumToBase:
			lw $t5, numLowCons
			blt $t3, $t5, error
			lw $t5, numHighCons
			bgt $t3, $t5, analyzeLettToBase
			addi $t3 $t3 -48
			move $a1, $t3
			j checkOneCharToBase
		analyzeLettToBase: # or between A and F
			lw $t5, letLowCons
			blt $t3, $t5, error
			lw $t5, letHighCons
			bgt $t3, $t5, error
			addi $t3, $t3, -55
			move $a1, $t3
	checkOneCharToBase:
	addi $t2 $t2 1
	lb $t4, 0($t2) #Load the next character
	bnez $t4, error #if more than one character exists, not a valid argument, goes to error
	# Now check, given the value of fromBase, to make sure that the argument "integer" legally corresponds to the "fromBase" given
	lw $a2, integer
checkBaseLoop:
	lb $t4, 0($a2) #load each digit into $t4
	beqz $t4, convertToDecimal # If it's null, exit loop, otherwise check
	# if between 2 and 9
		analyzeNumCheckBase:
			li $t5, 48
			blt $t4, $t5, error
			li $t5, 57
			bgt $t4, $t5, analyzeLettCheckBase
			addi $t4 $t4 -48
			move $a3, $t4
			j compareToBase
		analyzeLettCheckBase: # or between A and F
			lw $t5, letLowCons
			blt $t4, $t5, error
			lw $t5, letHighCons
			bgt $t4, $t5, error
			addi $t4, $t4, -55
			move $a3, $t4
	compareToBase:
	bge $t4, $a0, error
	addi $a2 $a2 1
	b checkBaseLoop
convertToDecimal: 
	#Convert fromBase to Decimal
	li $t0, 1 # "Exponent"
	addi $a2 $a2 -1
	# li $t2, 10
	li $t3, 0 # "Sum"
	# fromBase is $a0
	while_toDecimal:
		lb $t1, 0($a2) # load the digits one by one
		
		beqz $t1, convertToToBase
		#divu $t1, $t2 # Dividing, LO is quotient, HI is remainder
		#mfhi $t4 # Work with remainder first
		#mflo $t1 # But before the hi and lo values are erased, update the integer to divide by
		# Convert that digit to an int
		
		analyzeNumToDec:
			li $t5, 48
			blt $t1, $t5, error
			lw $t5, numHighCons
			bgt $t1, $t5, analyzeLettToDec
			addi $t1 $t1 -48
			move $t4, $t1
			j multiply
		analyzeLettToDec: # or between A and F
			lw $t5, letLowCons
			blt $t1, $t5, error
			lw $t5, letHighCons
			bgt $t1, $t5, error
			addi $t1, $t1, -55
			move $t4, $t1
		multiply:
		mult $t0, $t4 # Multiply the power of 2 by the extracted digit...
		mflo $t5 # And move that result from the low register ...
		add $t3, $t3, $t5 # And add it to our decimal sum...
		mult $t0, $a0 # Now multiply our power of 2 for the next extraction ...
		mflo $t0
		addi $a2 $a2 -1 # Decrementing the pointer so we can load the next character
		j while_toDecimal
	#Convert decimal base to toBase
convertToToBase: 
	move $a0 $t3 # the decimal sum is moved to $a0, replacing the "from" base
	beqz $a0, load_zero # if the decimal is equal to zero, jump straight to printing 0, otherwise execute the below code (for convertToToBase)
	# $a1 is toBase, so $t6 not need be used
	la $t2, buffer
	addi $t2 $t2 31
	while_toToBase:
		beqz $a0, print_result
		divu $a0, $a1 # divide the integer by the corresponding base
		mflo $a0 # move the result from the low register
		mfhi $t1 # ... and move the remainder from the high ...
		
		#Work on the remainder
		li $t6 10
		numberToBaseDigit:
		bge $t1 $t6 letterToBaseDigit
		addi $t1 $t1 48
		j storeByte
		letterToBaseDigit:
		addi $t1 $t1 55
		storeByte:
		sb $t1, 0($t2)
		addi $t2 $t2 -1
		j while_toToBase
		
load_zero: # Special provision for if the integer argument is 0
	la $t2, buffer
	addi $t2 $t2 31
	li $t1 48 # load ASCII value of 0
	sb $t1, 0($t2)
	
print_result:
	#Print result and branch to end_program
	#move statement
	move $a0, $t2
	li $v0, 4
	syscall
	j end_program
error:
	la $a0, ErrString
	li $v0, 4
	syscall
end_program:
	li $v0, 10
	syscall
