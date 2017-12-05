.text 

li $a0 5
jal factorial # Function call (Factorial) - Returns here when done
# arg  $a0 : n --> a registers : ARGUMENT registers
# ret $v0 : n! --> v registers : RETURN registers --> Can return TWO things in MIPS

move $a0, $v0
li $v0, 1
syscall

li $v0, 10
syscall

factorial:
	addi $sp, $sp, -12
	sw $s0 0($sp)
	sw $s1 4($sp)
	sw $ra 8($s0)
	
	
	li $s0 1 # counter
	li $s1 1 # initial "product"
	
factorial_loop:
	bgt $s0 $a0 factorial_exit
	mult  $s0 $s1
	mflo $s1
	addi $s0 $s0 1
	jal garbage
	#addi $t1 $t1 1
	b factorial_loop
	
factorial_exit:
	move $v0, $s1
	
	lw $s0 0($sp)
	lw $s1 4($sp)
	lw $ra 8($sp)
	
	addi $sp $sp 12
	
	jr $ra
	
garbage:
	jr $ra