.data 
n: .word -23
divisor: .word 2
buffer_32: .asciiz "                                "
.text

main:
lw $t0 n
lw $t1 divisor
la $t2 buffer_32
addi $t2 $t2 31
li $t4 0 # counter
while:
beqz $t0 done
div $t0 $t1
mflo $t0
mfhi $t3

addi $t3 $t3 49
sb $t3, 0($t2)
addi $t2 $t2 -1
addi $t4 $t4 1
j while

done: # binary addition
add $t2 $t2 $t4
lb $t5, 0($t2)
addi $t5 $t5 1

sb $t5, 0($t2)
move $a0 $t2
li $v0 4
syscall

li $v0 10
syscall
