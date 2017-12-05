.data
charBuffer: .asciiz "          "
.text

li $t0 50
la $t1 charBuffer
sb $t0 0($t1)
#addi $t2 $t2 49
#sb $t2 0($t1)
addi $t1 $t1 1
#lb $t2 0($t1)
li $t2 53
sb $t2 0($t1)
move $a0 $t1
li $v0 4
syscall