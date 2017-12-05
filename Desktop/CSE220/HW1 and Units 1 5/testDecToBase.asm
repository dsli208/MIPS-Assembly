.data
errorMessage: .asciiz "Error\n"
decimal: .word 173
toBase: .word arg
buffer: .ascii "                               "
newline: .asciiz "\n"
arg: .asciiz "2"
numLowCons: .word 50
numHighCons: .word 57
letLowCons: .word 65
letHighCons: .word 70
.text
main:
li $t7, 1
lw $t0, decimal

lb $t1, arg

analyzeNum:
lw $t5, numLowCons
blt $t1, $t5, error
lw $t5, numHighCons
bgt $t1, $t5, analyzeLett
addi $t1 $t1 -48
j while

analyzeLett:
lw $t5, letLowCons
blt $t1, $t5, error
lw $t5, letHighCons
bgt $t1, $t5, error
addi $t1, $t1, -55
la $t4, buffer
addi $t4, $t4, 31

while:
	beqz $t0, end
	div $t0, $t1
	mfhi $t2  # remainder 7
	mflo $t0
	#lb $t6, 0($t2) # $t6 = Mem[7+0]
	#lb  $t6, 0($t2)
	sb $t2, 0($t4) # ???
	addi $t4, $t4, -1
	j while
error:
	la $a0, errorMessage
	li $v0, 4
	syscall
	
	li $v0, 10
	syscall
end:
move $a0, $s0
li $v0, 4
syscall

li $v0, 10
syscall
