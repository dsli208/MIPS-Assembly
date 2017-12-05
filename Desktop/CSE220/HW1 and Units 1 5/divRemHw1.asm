.data
a: .word 1101
br: .word 2
c: .word 10

# Sample program for converting to decimal
.text
main:
#li $t0, 0 # "Counter" variable
li $t0, 1 # "Exponent"
lw $t1, a # Loading the initial integer and the 10
lw $t2, c
li $t3, 0 # "Sum"
lw $t6, br
while:

beqz $t1, print
divu $t1, $t2 # Dividing, LO is quotient, HI is remainder
mfhi $t4 # Work with remainder first
mflo $t1 # But before the hi and lo values are erased, update the integer to divide by
mult $t0, $t4 # Multiply the power of 2 by the extracted digit...
mflo $t5 # And move that result from the low register ...
add $t3, $t3, $t5 # And add it to our decimal sum...
mult $t0, $t6 # Now multiply our power of 2 for the next extraction ...
mflo $t0
j while

print:
move $a0, $t3
li $v0, 1
syscall

li $v0, 10
syscall