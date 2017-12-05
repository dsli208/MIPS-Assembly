.text

	li $t0 0x40080000
	
    	addi $sp $sp -8
    	sw $s0 0($sp)
    	sw $ra 4($sp)
    	
    	move $s0 $t0
    	# print the sign
    	bltz $s0 print_negativeSign
    	li $a0 43
    	li $v0 11
    	syscall
    	li $t2 0
    	b print_oneAndDot # replace this with your eventual label
    	
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
    	
    	search_loop: # look for either a '.' or a '1'
    	lb $t0 0($s0)
    	li $t1 46
    	addi $s0 $s0 1
    	beq $t0 $t1 search_for_one
    	addi $t0 $t0 -48
    	beqz $t0 search_loop
    	li $t1 1
    	beq $t0 $t1 search_for_dot # one has been found, branch
   	
    	search_for_one:
    	addi $t2 $t2 -1
    	lb $t0 0($s0)
    	li $t1 1
    	beq $t0 $t1 get_Mantissa
    	addi $s0 $s0 1
    	b search_for_one
    	
    	search_for_dot:
    	addi $s0 $s0 1
    	lb $t0 0($s0)
    	li $t1 46
    	beq $t0 $t1 get_Mantissa
    	addi $t2 $t2 1
    	b search_for_dot
    	
    	get_Mantissa:
    	addi $s0 $s0 1
    	lb $t0 0($s0)
    	beqz $t0 done_binary_product
    	li $t1 10
    	beq $t0 $t1 done_binary_product
    	addi $t0 $t0 -48
    	or $t7 $t7 $t0
    	sll $t7 $t7 1
    	b get_Mantissa
    	
    	done_binary_product:
    	move $a0 $t7
    	#jal printNbitBinary
    	li $v0 1
    	syscall
    	
    	#la $a0 times2
    	#li $v0 4
    	#syscall
    	
    	bgtz $t2 print_posSign
	b print_exp
	   	
    	print_posSign:
    	li $a0 43
    	li $v0 11
    	syscall
    	
    	print_exp:
    	move $a0 $t2
    	#jal fromExcessk
    	
    	lw $s0 0($sp)
    	lw $ra 4($sp)
    	addi $sp $sp 8
    	jr $ra