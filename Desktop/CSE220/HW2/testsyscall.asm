.data
a: .word 50

.text

lw $t0 a
move $a0 $t0
li $v0 1
syscall

move $a0 $t0
li $v0 1
syscall