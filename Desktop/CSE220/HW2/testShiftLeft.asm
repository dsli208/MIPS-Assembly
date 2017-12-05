.text

li $t0 0x40080000
li $t1 8
sll $t0 $t0 1
while:
beqz $t1 done
sll $t0 $t0 1
addi $t1 $t1 -1
b while
done:
move $a0 $t0
li $v0 1
syscall
