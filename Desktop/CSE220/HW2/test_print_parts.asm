.data
space: .asciiz " "
buffer_32: .asciiz "                                "
newl: .asciiz "\n

.text

	li $a0 0xC1F1C71C
	move $s0 $a0
    	addi $sp $sp -4
    	sw $s0 0($sp)
    	
    	#print the sign bit
    	bltz $s0 print_negative_sign
    	li $a0 48
    	li $v0 11
    	syscall
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	li $a0 43
    	li $v0 11
    	syscall
    	
    	li $t0 7
    	sll $s0 $s0 1
    	li $t1 0
    	j while_exp
    	
    	print_negative_sign:
    	li $a0 49
    	li $v0 11
    	syscall
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	li $a0 45
    	li $v0 11
    	syscall
    	
    	li $t0 7 # $t0 = 7
    	li $t2 0 # sum from all '1' exponents
    	
    	sll $s0 $s0 1
    	
    	while_exp:
    	beqz $t0, done_exp # base, terminating condition
    	li $t1 0 # counter for while_get_power2
    	
    	li $t3 1 # used for done_get_power2
    	bgtz $s0 shift_left_exp
    	
    	while_get_power2: # get the exponent value of 2 ^ n (n being the position of a '1' in the 8-bit exponent)
    	li $t4 2 # 2 to multiply by
    	beq $t1 $t0 done_get_power2
    	mult $t3 $t4 
    	mflo $t3 # $t3 = $t3 * 2
    	addi $t1 $t1 1
    	j while_get_power2
    	
    	done_get_power2:
    	add $t2 $t2 $t3 # add the sum from getting 2 ^ n (n is position of '1')
    	shift_left_exp:
    	addi $t0 $t0 -1
    	sll $s0 $s0 1
    	j while_exp
    	
    	done_exp: # we are done getting the exponent
    	#move $a0 $t2
    	#jal printNbitBinary
    	
    	while_mantissa:
    	beqz $t0, done_mantissa # base, terminating condition
    	li $t1 0 # counter for while_get_power2
    	addi $t5 $t0 -1
    	li $t3 1 # used for done_get_power2
    	bgtz $s0 shift_left_mantissa
    	
    	while_get_power2mantissa: # get the exponent value of 2 ^ n (n being the position of a '1' in the 8-bit exponent)
    	li $t4 2 # 2 to multiply by
    	beq $t1 $t5 done_get_power2mantissa
    	mult $t3 $t4 
    	mflo $t3 # $t3 = $t3 * 2
    	addi $t1 $t1 1
    	j while_get_power2mantissa
    	
    	done_get_power2mantissa:
    	add $t2 $t2 $t3 # add the sum from getting 2 ^ n (n is position of '1')
    	shift_left_mantissa:
    	addi $t0 $t0 -1
    	sll $s0 $s0 1
    	j while_mantissa
    	
    	done_mantissa: # we are done getting the exponent
    	move $a0 $t2
    	#li $a1 23
    	#jal printNbitBinary
    	li $v0 1
    	syscall
    	
    	
    	la $a0 space
    	li $v0 4
    	syscall
    	
    	move $a0 $t2
    	li $v0 1
    	syscall

