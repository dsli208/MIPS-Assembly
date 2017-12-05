
##############################################################
# Homework #2 REGRADE SUBMISSION
# name: David S. Li
# sbuid: 110328771
##############################################################
.text

##############################
# PART 1 FUNCTIONS
##############################

char2digit:
    #Define your code here
	li $t0 48
	li $t1 57
	blt $a0 $t0, char2DigitError
	bgt $a0, $t1, char2DigitError
	addi $a0 $a0 -48
	move $v0 $a0
	jr $ra
	
	char2DigitError:
	li $v0 -1
	jr $ra

memchar2digit:
    #Define your code here
	lb $t0 0($a0)
	addi $t0 $t0 -48
	bltz $t0, memChar2DigitError
	li $t1 9
	bgt $t0 $t1, memChar2DigitError
	move $v0 $t0
    	jr $ra
    	
    	memChar2DigitError:
    	li $v0 -1
    	jr $ra

fromExcessk:
    #Define your code here
	bltz $a0, fromExcesskError
	bltz $a1, fromExcesskError
	li $v0 0
	sub $v1 $a0 $a1
    	jr $ra
	
	fromExcesskError:
	li $v0 -1
	move $v1 $a0
	jr $ra
printNbitBinary:
    #Define your code here
    	#Stack pointer
    	addi $sp $sp -12
    	sw $s0 0($sp)
	sw $s1 4($sp)  	
	sw $ra 8($sp)
    	move $s0 $a0
    	move $s1 $a1
    	# First, check to see if m is between 1 and 32
    	li $t0, 1
    	li $t1, 32
    	blt $s1 $t0, nBitBinaryError
    	bgt $s1 $t1, nBitBinaryError
	la $t0, buffer_32
	addi $t0 $t0 31
	
	# m is between 1 and 32, now do the given algorithm - shift left by (32 - m) bits
	sub $t1 $t1 $s1 # $t1 = 32 - m (for the given test case, (value = -23, m = 30), $t1 = 2)
	
	
	# shift $a0 or value, left by (32 - m) bits
	shift_bits_while:
	beqz $t1 while
	sll $s0 $s0 1
	addi $t1 $t1 -1
	j shift_bits_while
	
	while: # while loop, while (m, or $a1 > 0)
	beqz $s1, success # when (m == 0), terminate loop
	# (m > 0) if the above statement does not execute
	bltz $s0, print_1 # if (value < 0)
	
	# code for printing 0 here
	li $a0 48
	li $v0 11
	syscall
	sll $s0 $s0 1 # shift value left 1 bit
	addi $s1 $s1 -1 # m = m - 1
	j while # next iteration of loop
	print_1:
	li $a0 49
	li $v0 11
	syscall
	sll $s0 $s0 1 # shift value left 1 bit
	addi $s1 $s1 -1 # m = m - 1
	j while # next iteration of loop
	nBitBinaryError:
	lw $s1 4($sp)
	lw $s0 0($sp)
	addi $sp $sp 4
	
	li $v0, -1
    	jr $ra
    	
    	success:
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
	addi $sp $sp 12
	
    	li $v0, 0
    	jr $ra

##############################
# PART 2 FUNCTIONS
##############################

btof:
	addi $sp $sp -12
    	sw $s0 0($sp)
    	sw $s1 4($sp)
    	sw $ra 8($sp)
    	move $s0 $a0 # move $a0 to $s0
      	move $s1 $a0 # store a copy of the original address in $s1 in case you need it in the future
	# check for NaN
	move $s0 $s1
	lb $t1 0($s0)
	li $t2 78
	bne $t1 $t2 checkPosSpecial # branch if first char is not 'N'
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 97
	bne $t1 $t2 btofError
	li $v0 0
    	li $v1 2147483647 # decimal value for +Inf
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra
	
	checkPosSpecial:
	# check for +Inf
	move $s0 $s1
	lb $t1 0($s0)
	li $t2 43
	bne $t2 $t1 checkPos0
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 73
	bne $t2 $t1 getSign
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 110
	bne $t2 $t1 btofError
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 102
	bne $t2 $t1 btofError
	li $v0 0
    	li $v1 2139095040 # decimal value for +Inf
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra
	
	checkPos0:
	# check for +0.0
	move $s0 $s1
	lb $t1 0($s0)
	li $t2 43
	bne $t2 $t1 checkNegSpecial
	addi $s0 $s0 1
	lb $a0 0($s0)
	jal char2digit
	bnez $v0 getSign
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 46
	bne $t1 $t2 getSign
	addi $s0 $s0 1
	lb $a0 0($s0)
	jal char2digit
	bnez $v0 getSign
	li $v0 0
    	li $v1 0 # decimal value for +Inf
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra
	
	checkNegSpecial:
	# check for -Inf
	move $s0 $s1
	lb $t1 0($s0)
	li $t2 45
	bne $t2 $t1 getSign
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 73
	bne $t2 $t1 getSign
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 110
	bne $t2 $t1 btofError
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 102
	bne $t2 $t1 btofError
	li $v0 0
    	li $v1 -8388608 # decimal value for -Inf
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra
	
	# check for -0.0
	move $s0 $s1
	lb $t1 0($s0)
	li $t2 45
	bne $t2 $t1 getSign
	addi $s0 $s0 1
	lb $a0 0($s0)
	jal char2digit
	bnez $v0 getSign
	addi $s0 $s0 1
	lb $t1 0($s0)
	li $t2 46
	bne $t1 $t2 getSign
	addi $s0 $s0 1
	lb $a0 0($s0)
	jal char2digit
	bnez $v0 getSign
	li $v0 0
	li $v1 -2147483648
	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra

	
    	getSign:
    	move $s0 $s1
      	
    	lb $t0 0($s0)
    	
    	# Is the first char positive or negative?
    	
    	# Negative (-)?
    	li $t1 45
    	beq $t0 $t1 load1SignBit
    	
    	# if the above condition is not met, that means the number is positive
    	# load a 0 as the sign bit
    	li $t7 0
    	sll $t7 $t7 8
    	li $t2 0 # counter for number of decimal places
    	li $t1 43 # check to see if the character is a '+'
    	bne $t0 $t1 while_exponent # if not, we are already on a '0' or '1' digit, presumably
    	# if the above statement does not execute, we are presumed to be at '+', so increment to the next character
    	addi $s0 $s0 1
    	b while_exponent
    	load1SignBit:
    	# code for loading the 1 as the sign bit
    	li $t7 1
    	sll $t7 $t7 8
    	# increment along the "String" by 1
    	addi $s0 $s0 1
    	
    	while_exponent: # look for the first 1 or .
    	li $t1 46
    	lb $t0 0($s0)
    	beq $t0 $t1 while_expDot # if '.' is first
    	move $a0 $t0
    	# STORE RETURN ADDRESS BEFORE CALLING THIS FUNCTION
    	jal char2digit
    	addi $s0 $s0 1 # increment the String pointer
    	beqz $v0 while_exponent #is $v0 == 0?  Go to the next iteration, looking for a '.' or '1'
    	li $t1 1
    	beq $v0 $t1 while_expOne # is $v0 == 1?  Now look for the '.'
    	b btofError
    	
    	while_expOne: # looking for '.'
    	li $t4 49
    	lb $t0 0($s0)
    	li $t1 46
    	beq $t0 $t1 getBias # done, get the positive bias
    	addi $t2 $t2 1
    	addi $s0 $s0 1
    	move $a0 $t0
    	# STORE RETURN ADDRESS BEFORE CALLING THIS FUNCTION
    	jal char2digit
    	beqz $v0 while_expOne
    	li $t1 1
    	beq $v0 $t1 while_expOne
    	b btofError
    	
    	while_expDot: # at '.', looking for '1'
    	li $t4 46
    	addi $s0 $s0 1
    	addi $t2 $t2 1
    	lb $a0 0($s0)
    	jal char2digit
    	beqz $v0 while_expDot
    	li $t1 1
    	beq $v0 $t1 getBias
    	b btofError
    	
    	getBias: # get bias, based on our counter variable for decimal places, in $t2
    	addi $t2 $t2 127 # $t2 = (decimal places) + 127 = bias
    	
    	biasToBinary: # take the $t7, already shifted left by 8, and since 
    	or $t7 $t7 $t2 # OR the two binary values together
    	sll $t7 $t7 23 # shift it by 23, making room for the mantissa
    	move $s0 $s1
    	
    	getDiff_dotAndOne:
    	addi $t2 $t2 -127 # go back to the bias
    	li $t4 23 # counter for mantissa loop
    	li $t6 0
    	li $t3 1 # indicator as to whether '.' has been found
    	
    	find_first_one_signBit:
    	lb $t0 0($s0)
    	li $t1 43
    	beq $t0 $t1 addOne_signBit
    	li $t1 45
    	beq $t0 $t1 addOne_signBit
    	b find_first_one
    	
    	addOne_signBit:
    	addi $s0 $s0 1
    	
    	find_first_one:
    	lb $t0 0($s0)
    	li $t1 46
    	beq $t0 $t1 find_first_one_checkDot
    	b find_first_one_part2
    	
    	find_first_one_checkDot:
    	addi $s0 $s0 1
    	beqz $t3 btofError
    	li $t3 0
    	b find_first_one
    	
    	find_first_one_part2:
    	addi $s0 $s0 1
    	#beq $t0 $t1 find_first_one
    	move $a0 $t0
    	jal char2digit
    	beqz $v0 find_first_one
    	li $t1 1
    	beq $v0 $t1 find_mantissa_chars
    	b btofError
    	
    	find_mantissa_chars:
    	beqz $t4 done_btof
    	addi $t4 $t4 -1
    	lb $t0 0($s0)
    	li $t1 10
    	beq $t0 $t1 shift_left_loop # we are at a \n, the end of the input char[]
    	beqz $t0 shift_left_loop # for '\0'
    	li $t1 46
    	beq $t0 $t1 find_mantissa_chars_checkDot
    	b find_mantissa_chars_part2
    	
    	find_mantissa_chars_checkDot:
    	addi $s0 $s0 1
    	beqz $t3 btofError
    	li $t3 0
    	addi $t4 $t4 1
    	b find_mantissa_chars
    	
    	find_mantissa_chars_part2:
    	addi $s0 $s0 1
    	# beq $t0 $t1 find_mantissa_chars
    	move $a0 $t0
    	jal char2digit
    	bnez $v0 shift_1_mantissa
    	li $t5 0
    	or $t6 $t6 $t5
    	sll $t6 $t6 1
    	#addi $t4 $t4 -1
    	b find_mantissa_chars
    	shift_1_mantissa:
    	li $t5 1
    	bne $v0 $t5 btofError
    	or $t6 $t6 $t5
    	sll $t6 $t6 1
    	#addi $t4 $t4 -1
    	b find_mantissa_chars
    	
    	shift_left_loop:
    	
    	addi $t4 $t4 -1
    	sll $t6 $t6 1
    	beqz $t4 done_btof
    	b shift_left_loop
    	
    	done_btof:
    	or $t7 $t7 $t6
    	li $v0 0
    	move $v1 $t7
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra
    	
    	btofError:
    	li $v0 -1
    	li $v1 0
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    	jr $ra

print_parts:
    	addi $sp $sp -16
    	sw $s0 0($sp)
    	sw $s1 4($sp)
    	sw $s2 8($sp)
    	sw $ra 12($sp)
    	move $s0 $a0
    	move $s2 $a0
    	
    	#print the sign bit
    	bltz $s0 print_negative_sign
    	li $s1 1
    	li $a0 48
    	li $v0 11
    	syscall
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	li $s1 0
    	li $a0 43
    	li $v0 11
    	syscall
    	
    	la $a0 newl
    	li $v0 4
    	syscall
    	
    	li $t0 8
    	sll $s0 $s0 1
    	li $t1 0
    	j while_exp
    	
    	print_negative_sign:
    	li $s1 -1
    	li $a0 49
    	li $v0 11
    	syscall
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	li $a0 45
    	li $v0 11
    	syscall
    	
    	
    	la $a0 newl
    	li $v0 4
    	syscall
    	
    	li $t0 8 # $t0 = 8
    	sll $s0 $s0 1
    	li $t1 0
    	li $t2 0 # the loaded bit for each iteration of the loop
    	
    	
    	while_exp: # getting the exponent
    	beqz $t0 done_exp
    	addi $t0 $t0 -1
    	bltz $s0 or_1 # we are at a '1' in $s0
    	# if the above statement does not execute, we are at a '0', presumably
    	li $t2 0
    	sll $t1 $t1 1
    	sll $s0 $s0 1
    	or $t1 $t1 $t2
    	
    	b while_exp
    	
    	or_1: # if $s0 < 0, meaning we are at a '1'
    	li $t2 1
    	sll $t1 $t1 1
    	sll $s0 $s0 1
    	or $t1 $t1 $t2
    	
    	b while_exp
    	
    	done_exp: # we are done getting the exponent
    	move $t2 $t1
    	move $a0 $t1
    	li $a1 8
    	jal printNbitBinary
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	move $a0 $t2
    	li $v0 1
    	syscall
    	
    	la $a0 newl
    	li $v0 4
    	syscall

	li $t0 23 # $t0 = 23
	li $t1 0
    	li $t2 0 # sum from all '1' exponents
    	
	while_mantissa:
	beqz $t0 done_mantissa
	addi $t0 $t0 -1
	bltz $s0 or_1_mantissa
	li $t2 0
	sll $t1 $t1 1
	sll $s0 $s0 1
	or $t1 $t1 $t2
	
	
	b while_mantissa
	
	or_1_mantissa:
	li $t2 1
	sll $t1 $t1 1
	sll $s0 $s0 1
	or $t1 $t1 $t2
	
	b while_mantissa
	
	done_mantissa:
	move $t2 $t1
	move $a0 $t1
	li $a1 23
	jal printNbitBinary
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	move $a0 $t2
    	li $v0 1
    	syscall
    	
    	
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $s2 8($sp)
    	lw $ra 12($sp)
    	addi $sp $sp 16
    	
    	jr $ra

print_binary_product:
    	addi $sp $sp -8
    	sw $s0 0($sp)
    	sw $ra 4($sp)
    	
    	move $s0 $a0
    	# print the sign
    	bltz $s0 print_negativeSign
    	li $a0 43
    	li $v0 11
    	syscall
    	li $t2 0
    	b print_oneAndDot
    	
    	print_negativeSign:
    	li $a0 45
    	li $v0 11
    	syscall
    	
    	print_oneAndDot:
    	li $a0 49
    	li $v0 11
    	syscall
    	
    	li $a0 46
    	li $v0 11
    	syscall
    	li $t2 0
    	
    	sll $s0 $s0 1
    	li $t0 8
    	while_getBias:
    	
    	beqz $t0 getBinaryBias
    	addi $t0 $t0 -1
    	bltz $s0 or_1_binProduct
    	li $t1 0
    	sll $t2 $t2 1
    	sll $s0 $s0 1
    	or $t2 $t2 $t1
    	
    	
    	b while_getBias
    	
    	or_1_binProduct:
    	li $t1 1
    	sll $t2 $t2 1
    	sll $s0 $s0 1
    	or $t2 $t2 $t1
    	
    	b while_getBias
    	
    	getBinaryBias:
    	move $a0 $t2
    	li $a1 127
    	jal fromExcessk
    	move $t2 $v1
    	li $t0 23
    	li $t3 0
    	
    	get_binary_product_mantissa:
    	beqz $t0 done_binary_product
    	addi $t0 $t0 -1
    	bltz $s0 get_binary_product_mantissa_1
    	li $t1 0
    	or $t3 $t3 $t1
    	sll $t3 $t3 1
    	sll $s0 $s0 1
    	
    	b get_binary_product_mantissa
    	
    	get_binary_product_mantissa_1:
    	li $t1 1
    	or $t3 $t3 $t1
    	sll $t3 $t3 1
    	sll $s0 $s0 1
    	#addi $s0 $s0 -1
    	b get_binary_product_mantissa
    	
    	done_binary_product:
    	move $a0 $t3
    	li $a1 23
    	jal printNbitBinary
    	
    	la $a0 times2
    	li $v0 4
    	syscall
    	
    	bgtz $t2 print_posSign
	b print_exp
	   	
    	print_posSign:
    	li $a0 43
    	li $v0 11
    	syscall
    	
    	print_exp:
    	move $a0 $t2
    	li $v0 1
    	syscall
    	
    	lw $s0 0($sp)
    	lw $ra 4($sp)
    	addi $sp $sp 8
    	jr $ra



#################################################################
# Student defined data section
#################################################################
.data

#place all data declarations here

space: .asciiz " "
buffer_32: .asciiz "                                "
newl: .asciiz "\n"
times2: .asciiz " x 2^"
.align 2  # Align next items to word boundary
