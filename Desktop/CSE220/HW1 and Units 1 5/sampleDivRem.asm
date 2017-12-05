.data

a: .word 1101
c: .word 10

newL: .asciiz "\n"
.text

main:

lw $t0, a
lw $t1, c
div $t0, $t1
mfhi $t2
mflo $t3

move $a0, $t2
li $v0, 1
syscall

la $a0, newL
li $v0, 4
syscall

move $a0, $t3
li $v0, 1
syscall