.data

.align 2
	numargs: .word 0
	integer: .word 0
	fromBase: .word 0
	toBase: .word 0
	ErrString: .asciiz "Error\n"
	buffer: .ascii "                               "
	newLine: .asciiz "\n"
	
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
	load_args() #only called once
	
	li $a0, 10
	li $v0, 1
	syscall 
	
	lw $a0, numargs
	li $v0, 1
	syscall
	
	la $a0, newLine
	li $v0, 4
	syscall
	
	lw $a0, integer
	li $v0, 4
	syscall
	
	la $a0, newLine
	li $v0, 4
	syscall
	
	lw $a0, fromBase
	li $v0, 4
	syscall
	
	la $a0, newLine
	li $v0, 4
	syscall
	
	lw $a0, toBase
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall
	
	
