# Recitation 04/17/2017

# n! = n(n - 1)(n - 2) ...

# int factorial (int n)

.text

li $a0 5
jal factorial
move $a0 $v0
li $v0 1
syscall

li $v0 10
syscall

# arg $a0 = int n
# ret $v0 = int n!
factorial:
# Base cases: 0! = 1 and 1! = 1
	beqz $a0 factorial_zero_one
	
	addi $sp $sp -8
	sw $ra 0($sp) # STORE RETURN ADDRESS EVERY TIME RECURSION CALL IS USED
	sw $a0 4($sp)
	
	addi $a0 $a0 -1
	jal factorial
	
	lw $t0 4($sp)
	mul $v0 $v0 $t0
	lw $ra 0($sp)
	addi $sp $sp 8
	
	jr $ra
factorial_zero_one:
	li $v0 1
	jr $ra