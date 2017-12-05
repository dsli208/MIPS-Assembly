.data
testChar: .byte '9'
.text

la $t0 testChar
lb $t1 0($t0)
addi $t1 $t1 -48
move $a0 $t1
li $v0 1
syscall
li $v0 10
syscall