.text
li $t0 1
sll $t0 $t0 7
li $t1 128
or $t0 $t0 $t1

move $a0 $t0
li $v0 1
syscall