# Fib(n) = Fib(n - 1) + Fib(n - 2)

# Fib(0) = 1, Fib(1) = 1, Fib(2) = 2, Fib(3) = 3, Fib(4) = 5, Fib(5) = 8

.text

main:
	li $a0 8
	jal fibonacci
	move $a0 $v0
	li $v0 1
	syscall
	
	# Exit
	li $v0 10
	syscall
	
# arg $a0 = n
# ret $v0 = fib(n)

fibonacci:

# def fib(n):
#	if (n == 0)
# 		return 1
# 	elif (n == 1)
#		return 1
	li $t0 1
	ble $a0 $t0 base_case
	
not_base_case:
#	return fib(n - 1) + fib(n - 2)
	addi $sp $sp -8
	sw $ra 0($sp)
	sw $s0 4($sp)
	# fib(n - 1)
	move $s0 $a0
	
	addi $a0 $a0 -1
	jal fibonacci # fib(n - 1)
	
	addi $a0 $s0 -2
	sw $v0 4($sp)
	
	jal fibonacci # fib(n - 2)
	lw $t0 4($sp)
	add $v0 $v0 $t0 # fib(n - 1) + fib(n - 2)
	
	lw $ra 0($sp)
	lw $s0 4($sp)
	addi $sp $sp 8
	jr $ra
	
base_case:

	li $v0 1
	jr $ra