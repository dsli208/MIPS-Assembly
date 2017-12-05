.data
buffer: .asciiz "        "
a: .word 10
b: .word 16

.text
main:

lw $t0 a
lw $t1 b
div $t0 $t1
mfhi $t2
addi $t2 $t2 55

la $t3 buffer
addi $t3 $t3 5

sb $t2, 0($t3)

move $a0 $t3

li $v0 4
syscall

li $v0 10
syscall