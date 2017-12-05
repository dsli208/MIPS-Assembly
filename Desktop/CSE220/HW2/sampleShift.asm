.data
buffer_32: .asciiz "                                "

.text
li $t0 -23
la $t3 buffer_32
sll $t0 $t0 2
li $t1 30
li $t4 49
while:
beqz $t1 done
#lb $t2 0($t0)
#beq $t2 $t4 print_1
bltz $t1 print_1
print_0:
li $t2 48
sb $t2 0($t3)
addi $t3 $t3 1
sll $t0 $t0 1
addi $t1 $t1 -1
j while
print_1:
li $t2 49
sb $t2 0($t3)
addi $t3 $t3 1
sll $t0 $t0 1
addi $t1 $t1 -1
j while
done:
move $a0 $t3
li $v0 4
syscall