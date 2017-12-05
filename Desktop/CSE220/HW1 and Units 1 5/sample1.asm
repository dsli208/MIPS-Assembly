.text
.globl main

main:

la $a0, str #load store architecture --> load and store are the only things that can touch things in the memory
#$a0 - argument register
li $v0, 4
syscall

# quit program
li $v0, 10
syscall

.data
i: .word 5 # i is initalized to "word" type, value of 5
str: .asciiz "Hello world!" #Ascii characters, null character at the end

#Pink things: assembly directives