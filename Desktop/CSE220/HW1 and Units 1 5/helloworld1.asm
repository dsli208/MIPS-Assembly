.data
hello_world: .ascii "Hello world!"

.text
main:
li $v0, 4
la $a0, hello_world
syscall