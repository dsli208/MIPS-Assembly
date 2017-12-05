.data

a: .word 10
br: .word 50

.text

main:
lw $t0, a
lw $t1, br

mult $t0, $t1
mflo $t2

move $a0, $t2
li $v0, 1
syscall
