.text

li $t0 0x40080000
li $t1 8
while:
beqz $t1 end
sll $t0 $t0 1
addi $t1 $t1 -1
b while

end:
li $v0 10
syscall