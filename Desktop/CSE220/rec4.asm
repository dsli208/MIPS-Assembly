.data

a: .asciiz "11111"
br: .asciiz "10111"
buffer_32: .asciiz "                                "
.text

#li $t0 234234
#li $t1 35345

la $t0 br
la $t1 a

and $t3 $t1 $t0
#andi $t3 $t2 0xFFFF
addi $t3 $t3 27
la $t4 buffer_32
while:
lb $t2 0($t3)
beqz $t2 done
sb $t2 0($t4)
addi $t3 $t3 1
addi $t4 $t4 1
j while
# or
# xor
# nor
done:
move $a0 $t4
li $v0 4
syscall