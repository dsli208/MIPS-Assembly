.data

a: .word 23
br: .word 30
c: .word 2
from_buffer_32: .asciiz "                                "
.text
la $t0 a
li $t1 0
lw $t2 c
lw $t3 br
shift_bits:
bge $t1 $t2 pre_while
sll $t0 $t0 1
addi $t1 $t1 1
j shift_bits
pre_while:
li $t1 0
while:
bge $t1 $t3, done
print_0:

print_1:

addi $t1 $t1 1
j while
done: