.text

li $t0 5 # N (output -> N!, where N is at register $t0)
li $t1, 1 #sum (N!)
li $t2, 1 #i

factorial:
	bgt $t2 $t0 factorial_exit #Exit loop if i > n
	
	# Calculate (partially) the factorial sum at each step
	mult $t1 $t2 # Doing the actual multiplication
	mflo $t1 # Storing from lo back into $t1
	addi $t2 $t2 1
	j factorial # Branch back to the beginning of the "factorial" function
factorial_exit:
	
	li $v0, 1
	move $a0, $t1
	syscall
	
	li $v0, 10
	syscall
.data