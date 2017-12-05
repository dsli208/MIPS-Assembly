.text

lw $t0 4($a1) # argv - "array of strings"
sw $t0 fromBase
lw $t0 8($a1) #
sw $t0 toBase
lw $t0 0($a1)
sw $t0 integer

# Following macro

lw $t0 fromBase # address of the fromBase strings
li $t1 0 # counter for "strlen" function

strlen:
	
	lb $t2 0($t0) # Load the next character
	beqz $t2, strlen_exit
	addi $t0 $t0 1 
	addi $t1 $t1 1
	b strlen

strlen_exit:
	li $v0, 1
	move $a0, $t1
	syscall

.data

fromBase: .word 0
toBase: .word 0
integer: .word 0