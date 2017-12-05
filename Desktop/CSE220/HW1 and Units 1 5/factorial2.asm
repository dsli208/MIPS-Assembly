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
	li $t0 1 # counter
	li $t1 1 # initial "product"
	
factorial_loop:
	bgt $t0 $a0 factorial_exit
	mult  $t0 $t1
	mflo $t1
	addi $t0 $t0 1
	addi $t1 $t1 1
	b factorial_loop
	
factorial_exit:
	move $v0, $t1
	jr $ra
