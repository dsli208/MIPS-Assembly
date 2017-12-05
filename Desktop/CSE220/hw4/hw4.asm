##############################################################
# Homework #4
# name: David S. Li
# sbuid: 110328771
##############################################################

##############################################################
# DO NOT DECLARE A .DATA SECTION IN YOUR HW. IT IS NOT NEEDED
##############################################################

.text

##############################
# Part I FUNCTIONS
##############################

set_slot:
    # First, initialize arguments from the stack
    lw $t0 0($sp)
    lw $t1 4($sp)
    lw $t2 8($sp)
    # Load variables onto stack
    addi $sp $sp -24
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $ra 20($sp)
    
    move $s0 $a0
    move $s1 $a3
    move $s2 $t0
    move $s3 $t1
    move $s4 $t2
    
    # Check that num_rows and num_cols are not less than 0
    bltz $a1 set_slot_error
    bltz $a2 set_slot_error
    
    # first, check row and col are not less than 0
    bltz $s1 set_slot_error
    bltz $s2 set_slot_error
    
    # now check row and col, making sure they are less than num_rows - 1 and num_cols - 1 respectively
    # rows: 
    addi $t0 $a1 -1
    bgt $s1 $t0 set_slot_error
    # cols:
    addi $t0 $a2 -1
    bgt $s2 $t0 set_slot_error
    
    # check to make sure turn+num is valid
    li $t0 255
    bgt $s4 $t0 set_slot_error
    bltz $s4 set_slot_error
    
    # check to make sure c is valid
    checkC_set_slot:
    li $t0 82 #'R'
    beq $s3 $t0 valid_set_slot
    li $t0 89 #'Y'
    beq $s3 $t0 valid_set_slot
    li $t0 46 #'.'
    beq $s3 $t0 valid_set_slot
    # else, we have an invalid char
    b set_slot_error
    
    # All conditions are valid, so set the slot
    valid_set_slot:
    # First, get address
    move $t0 $s0 # $t0 = base_address
    
    # $s0 = starting address

    # $t1 = (row_size * row) = (num_cols * 2 * row)

    li $t1 2
    mult $t1 $a2
    mflo $t1
    mult $t1 $s1
    mflo $t1

    # $t0 = $s0 + $t1 --> $t0 = base_address + (num_cols * 2 * row)
    add $t0 $s0 $t1

    # $t1 = (2 * col)
    li $t1 2
    mult $s2 $t1
    mflo $t1

    # $t0 = $t0 (as calculated above) + $t1 = base_address + (num_cols * 2 * row) + (2 * col)
    add $t0 $t0 $t1
    
    # Now that we have our address, set the bytes accordingly
    # upper byte - c:
    sb $s3 0($t0)
    # lower byte - turn_num:
    addi $t0 $t0 1
    sb $s4 0($t0)
    
    # done
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $ra 20($sp)
    addi $sp $sp 24
    
    li $v0 0
    jr $ra
    
    set_slot_error:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $ra 20($sp)
    addi $sp $sp 24
    
    li $v0 -1
    jr $ra

get_slot:
    lw $t0 0($sp)
    addi $sp $sp -24
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $ra 20($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    move $s3 $a3
    move $s4 $t0
    
    # make sure num_rows and num_cols are greater than 0
    bltz $a1 get_slot_error
    bltz $a2 get_slot_error
    
    # now make sure row and col are within range
    bltz $s3 get_slot_error
    bltz $s4 get_slot_error
    addi $t0 $s1 -1
    bgt $s3 $t0 get_slot_error
    addi $t0 $s2 -1
    bgt $s4 $t0 get_slot_error
    
    # if none of the branch statements above execute, we're good, get the slot
    
    # First, get address
    move $t0 $s0 # $t0 = base_address
    
    # FIX REGISTERS
    # $s0 = starting address

    # $t1 = (row_size * row) = (num_cols * 2 * row)

    li $t1 2
    mult $t1 $s2
    mflo $t1
    mult $t1 $s3
    mflo $t1

    # $t0 = $s0 + $t1 --> $t0 = base_address + (num_cols * 2 * row)
    add $t0 $s0 $t1

    # $t1 = (2 * col)
    li $t1 2
    mult $s4 $t1
    mflo $t1

    # $t0 = $t0 (as calculated above) + $t1 = base_address + (num_cols * 2 * row) + (2 * col)
    add $t0 $t0 $t1
    
    lb $v0 0($t0)
    addi $t0 $t0 1
    lb $v1 0($t0)
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $ra 20($sp)
    addi $sp $sp 24
    
    jr $ra
    
    get_slot_error:
    
    li $v0 -1
    li $v1 -1
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $ra 20($sp)
    addi $sp $sp 24
    
    jr $ra

clear_board:
    bltz $a1 clear_board_error
    bltz $a2 clear_board_error
    
    addi $sp $sp -28
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $s5 20($sp)
    sw $s6 24($sp)
    sw $ra 28($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    
    li $s3 0 # row
    li $s4 0 # col
    li $s5 46 # c
    li $s6 0 # turn_num
    
    while_row:
    	bge $s3 $s1 done_clear_board
    	while_col:
    	bge $s4 $s2 done_while_col
    	move $a0 $s0
    	move $a1 $s1
    	move $a2 $s2
    	move $a3 $s3
    	move $fp $sp
    	addi $sp $sp -12
    	sw $s4 0($sp)
    	sw $s5 4($sp)
    	sw $s6 8($sp)
    	#sw $ra 12($sp)
    	jal set_slot
    	#lw $t0 0($sp)
    	#lw $t1 4($sp)
    	#lw $t2 8($sp)
    	#addi $sp $sp 12
    	bltz $v0 clear_board_error2
    	move $sp $fp
    	addi $s4 $s4 1
    	b while_col
    	
    	done_while_col:
    	li $s4 0
    	addi $s3 $s3 1
    	b while_row
    	
    	#done_while_row:
    	#b while
    	
    done_clear_board:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $s6 24($sp)
    lw $ra 28($sp)
    addi $sp $sp 28
    
    li $v0 0
    jr $ra
    
    clear_board_error:
    li $v0 -1
    jr $ra
    
    clear_board_error2:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $s6 24($sp)
    lw $ra 28($sp)
    addi $sp $sp 28
    
    li $v0 -1
    jr $ra

##############################
# Part II FUNCTIONS
##############################

load_board:
    addi $sp $sp -16
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $ra 12($sp)
    
    move $s0 $a0
    move $s1 $a1
    
    # open the file
    move $a0 $s1
    li $a1 0
    li $v0 13
    syscall
    # for handling file errors
    bltz $v0 load_board_error
    
    move $s2 $v0 # store your file descriptor
    # now read the file, line by line...
    # read the first line
    # read num_rows
    move $a0 $s2
    move $a1 $t0 # ?
    li $a2 2
    li $v0 14
    syscall
    bltz $v0 load_board_error
    move $t2 $v0
    
    # get num_rows - int form
    
    lb $t4 0($t0)
    addi $t4 $t4 -48
    addi $t0 $t0 1
    lb $t5 0($t0)
    addi $t5 $t5 -48
    li $t6 10
    mult $t6 $t4
    mflo $t0
    add $t0 $t0 $t5
    
    # read num_cols
    move $a0 $s2
    move $a1 $t1 # ?
    li $a2 3
    li $v0 14
    syscall
    move $t3 $v0
    
    # get num_cols - int form
    lb $t4 0($t1)
    addi $t4 $t4 -48
    addi $t1 $t1 1
    lb $t5 0($t1)
    addi $t5 $t5 -48
    li $t6 10
    mult $t6 $t4
    mflo $t1
    add $t1 $t1 $t5
    
    # $t0 is num_rows, $t1 is num_cols
    while_load_hasNext:
    	
    	# first, load row
    	move $a0 $s2
    	move $a1 $t7 # ?
    	li $a2 2
    	li $v0 14
    	syscall
    	bltz $v0 load_board_error
    	move $t2 $v0
    
    	# get num_rows - int form
    	lb $t4 0($t2)
    	addi $t4 $t4 -48
    	addi $t2 $t2 1
    	lb $t5 0($t2)
    	beqz $t5 done_load
    	addi $t5 $t5 -48
    	li $t6 10
    	mult $t6 $t4
    	mflo $t2
    	add $t8 $t8 $t5 # $t8 = row
    	
    	# read num_cols
    	move $a0 $s2
    	move $a1 $t7 # ?
    	li $a2 2
    	li $v0 14
    	syscall
    	bltz $v0 load_board_error
    	move $t3 $v0
    
    	# get num_cols - int form
    	lb $t4 0($t3)
    	addi $t4 $t4 -48
    	addi $t3 $t3 1
    	lb $t5 0($t3)
    	addi $t5 $t5 -48
    	li $t6 10
    	mult $t6 $t4
    	mflo $t1
    	add $t1 $t1 $t5 # $t9 = col
    	
    	# now get c
    	move $a0 $s2
    	move $a1 $t7 # ?
    	li $a2 1
    	li $v0 14
    	syscall
    	bltz $v0 load_board_error
    	move $t2 $v0
    	
    	# Now store c to $t3
    	lb $t3 0($t2) # $t3 = c
    	
    	# Get turn_number
    	move $a0 $s2
    	move $a1 $t7 # ?
    	li $a2 4
    	li $v0 14
    	syscall
    	bltz $v0 load_board_error
    	move $t2 $v0
    	
    	li $t4 100
    	lb $t5 0($t2)
    	addi $t5 $t5 -48
    	mult $t4 $t5
    	mflo $t4
    	addi $t2 $t2 1
    	li $t5 10
    	lb $t6 0($t2)
    	addi $t6 $t6 -48
    	mult $t5 $t6
    	mflo $t5
    	add $t4 $t4 $t5
    	addi $t2 $t2 1
    	lb $t5 0($t2)
    	addi $t5 $t5 -48
    	add $t4 $t4 $t5 # $t4 = turn_number
    	
    	# Now we have all the necessary variables, let's move them and call set_slot
    	move $a0 $s0
    	move $a1 $t0
    	move $a2 $t1
    	move $a3 $t8
    	move $fp $sp
    	addi $sp $sp -12
    	sw $t9 0($sp)
    	sw $t3 4($sp)
    	sw $t4 8($sp)
    	jal set_slot
    	lw $t9 0($sp)
    	lw $t3 4($sp)
    	lw $t4 8($sp)
    	move $sp $fp
    	
    done_load:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $ra 12($sp)
    addi $sp $sp 16
    
    move $v0 $t8
    move $v1 $t9
    jr $ra
    
    load_board_error:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $ra 12($sp)
    addi $sp $sp 16
    
    li $v0 -1
    li $v1 -1
    jr $ra

save_board:
    addi $sp $sp -32
    # where to store copies of our arguments
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp) # where to store our file descriptor
    sw $s5 20($sp) # address of our buffer
    sw $s6 24($sp) # counter for # of pieces found
    sw $ra 28($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    move $s3 $a3
    
    li $s6 0
    
    move $a0 $a3
    li $a1 1
    li $v0 13
    syscall
    move $s4 $v0
    
    # Write the first line of the file rr + cc
    # Writing rr
    li $t0 10
    blt $a1 $t0 writeZero_firstLine_rr
    div $a1 $t0
    mflo $t1
    addi $t1 $t1 48
    b writeDigit_rr
    
    writeZero_firstLine_rr:
    li $t1 48
    
    writeDigit_rr:
    mfhi $t2
    addi $t2 $t2 48
    sb $t1 0($s5)
    addi $t3 $s5 1
    sb $t2 0($t3)
    addi $t3 $t3 1
    
    move $a0 $s4
    move $a1 $s5
    li $a2 2
    li $v0 15
    syscall
    bltz $v0 save_error
    
    
    # Writing cc
    blt $a2 $t0 writeZero_firstLine_cc
    div $a2 $t0
    mflo $t1
    addi $t1 $t1 48
    b writeDigit_cc
    
    writeZero_firstLine_cc:
    li $t1 48
    
    writeDigit_cc:
    mfhi $t2
    addi $t2 $t2 48
    sb $t1 0($s5) # how does the buffer work, are we constantly overwriting it?
    addi $t3 $s5 1
    sb $t2 0($t3)
    addi $t3 $t3 1
    sb $t0 0($t3) # store the newLine to the buffer
    
    move $a0 $s4
    move $a1 $s5
    li $a2 3
    li $v0 15
    syscall
    bltz $v0 save_error
    
    li $t0 0 # row = 0
    li $t1 0 # col = 0
    while_save_iterateRows:
    bge $t0 $s1 done_save_iterateRows
    
    while_save_iterateCols:
    beq $t1 $s2 done_save_iterateCols
    
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $t0
    move $fp $sp
    addi $sp $sp -4
    sw $t1 0($sp)
    jal get_slot
    lw $t1 0($sp)
    move $sp $fp
    
    li $t2 46
    beq $v0 $t2 done_save_iterateRows # right label?
    # if the above does not execute, keep going we are at a character
    addi $s6 $s6 1
    # store row in the String
    li $t3 10
    div $t0 $t3
    mflo $t4
    addi $t4 $t4 48
    mfhi $t5
    addi $t5 $t5 48
    sb $t4 0($s5)
    addi $t6 $s5 1
    sb $t5 0($t6)
    addi $t6 $t6 1
    
    # do the same thing for col
    div $t1 $t3
    mflo $t4
    addi $t4 $t4 48
    mfhi $t5
    addi $t5 $t5 48
    sb $t4 0($t6)
    addi $t6 $t6 1
    sb $t5 0($t6)
    addi $t6 $t6 1
    
    # store c
    sb $v0 0($t6)
    addi $t6 $t6 1
    
    # store turn_num
    li $t7 100
    div $v1 $t7
    mflo $t7
    mfhi $t8
    div $t8 $t3
    mflo $t8
    mfhi $t9
    
    addi $t7 $t7 48
    addi $t8 $t8 48
    addi $t9 $t9 48
    
    sb $t7 0($t6)
    addi $t6 $t6 1
    sb $t8 0($t6)
    addi $t6 $t6 1
    sb $t9 0($t6)
    addi $t6 $t6 1
    sb $t3 0($t6)
    
    # rrccpttt\n is stored in the String, let's write it to the File
    move $a0 $s4
    move $a1 $s5
    li $a2 9
    li $v0 15
    syscall
    bltz $v0 save_error
    
    addi $t1 $t1 1
    b while_save_iterateCols
    
    done_save_iterateCols:
    addi $t0 $t0 1
    b while_save_iterateRows
    
    done_save_iterateRows:
    move $v0 $s6
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp) 
    lw $s6 24($sp)
    lw $ra 28($sp)
    addi $sp $sp 32
    
    jr $ra
    
    save_error:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $s6 24($sp) 
    lw $ra 28($sp)
    addi $sp $sp 32
    
    li $v0 -1
    jr $ra

validate_board:
    addi $sp $sp -32
    sw $s0 0($sp) # board
    sw $s1 4($sp) # num_rows
    sw $s2 8($sp) # num_cols
    sw $s3 12($sp) # original address of bit vector
    sw $s4 16($sp) # bit vector to shift
    sw $s5 20($sp) # col
    sw $s6 24($sp) # row
#    sw $s7 28($sp) # diff
    sw $ra 28($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    
    li $s3 0
    move $s4 $s3
    
    bit0: # num_rows is less than 4
    li $t0 4
    blt $s1 $t0 lessThan4Rows
    ori $s4 $s4 0
    sll $s4 $s4 1
    b bit1
    
    lessThan4Rows:
    ori $s4 $s4 1
    sll $s4 $s4 1
    
    bit1:
    blt $s2 $t0 lessThan4Cols
    ori $s4 $s4 0
    sll $s4 $s4 1
    b bit2
    
    lessThan4Cols:
    ori $s4 $s4 2
    sll $s4 $s4 1
    
    bit2:
    mult $s1 $s2
    mflo $t0
    li $t1 255
    bgt $t0 $t1 greaterThan255
    ori $s4 $s4 0
    sll $s4 $s4 1
    b bit3
    
    greaterThan255:
    ori $s4 $s4 4
    sll $s4 $s4 1
    
    bit3:
    li $s5 0 # row
    li $s6 0 # col
    li $t8 0 # red
    li $t9 0 # yellow
    
    while_getPieces_row:
    li $s6 0
    bge $s5 $s1 done_getPieces
    
    while_getPieces_col:
    bge $s6 $s2 done_getPieces_col
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    li $t0 82
    beq $v0 $t0 incRedPiece
    li $t0 89
    beq $v0 $t0 incYellowPiece
    b done_getPieces_col
    
    incRedPiece:
    addi $t8 $t8 1
    b done_getPieces_col
    
    incYellowPiece:
    addi $t9 $t9 1
    b done_getPieces_col
    
    done_getPieces_col:
    addi $s6 $s6 1
    b while_getPieces_col
    
    done_getPieces_row:
    addi $s5 $s5 1
    b while_getPieces_row
    
    done_getPieces:
    sub $t7 $t8 $t9
    li $t5 -1
    li $t6 1
    blt $t7 $t5 invalid_getPieces
    bgt $t7 $t6 invalid_getPieces
    
    ori $s4 $s4 0
    sll $s4 $s4 1
    
    invalid_getPieces:
    ori $s4 $s4 8
    sll $s4 $s4 1
    
    bit4:
    li $s5 0 # row
    li $s6 0 # col
    li $t8 0 # turn of red
    li $t9 0 # turn of yellow
    
    while_getRed:
    while_getRed_row:
    li $s6 0
    bge $s5 $s1 valid_bit4
    
    while_getRed_col:
    bge $s6 $s2 done_getRed_col
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    
    li $t0 82
    beq $v0 $t0 while_getYellow
    
    addi $s6 $s6 1
    b while_getRed_col
    
    done_getRed_col:
    addi $s5 $s5 1
    b while_getRed_row
    
    while_getYellow:
    move $t8 $v1
    li $s5 0
    li $s6 0
    
    while_getYellow_row:
    li $s6 0
    bge $s5 $s1 valid_bit4
    while_getYellow_col:
    bge $s6 $s2 done_getYellow_row
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    
    li $t0 89
    beq $v0 $t0 determineValid_bit4
    
    addi $s6 $s6 1
    b while_getYellow_col
    
    done_getYellow_row:
    addi $s5 $s5 1
    b while_getYellow_row
    
    determineValid_bit4:
    li $t0 2
    div $t8 $t0
    mflo $t1
    mfhi $t2
    div $t9 $t0
    mflo $t1
    mfhi $t3
    # $t2 and $t3 are our remainders for red and yellow, respectively
    bne $t2 $t3 valid_bit4
    
    ori $s4 $s4 16
    sll $s4 $s4 1
    b bit5
    
    valid_bit4:
    ori $s4 $s4 0
    sll $s4 $s4 1
    
    bit5:
    li $s5 0
    li $s6 0
    
    while_bit5_col:
    li $s5 0
    bge $s6 $s2 done_bit5
    li $t9 1 # marker for "blank space"
    
    while_bit5_row:
    bge $s5 $s1 done_bit5_row
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    
    move $t1 $v0
    li $t2 46
    bne $t1 $t2 bit5_charFound
    addi $t9 $t9 -1
    addi $s5 $s5 1
    b while_bit5_row
    
    bit5_charFound:
    blez $t9 invalid_bit5
    addi $s5 $s5 1
    b while_bit5_row
    
    done_bit5_row:
    addi $s6 $s6 1
    b while_bit5_col
    
    done_bit5:
    ori $s4 $s4 0
    sll $s4 $s4 1
    b bit6
    
    invalid_bit5:
    ori $s4 $s4 32
    sll $s4 $s4 1
    
    bit6:
    li $s5 0
    li $s6 0
    
    while_bit6_col:
    li $s5 0
    bge $s6 $s2 done_bit6
    li $t9 0 # most recent turn number
    
    while_bit6_row:
    bge $s5 $s1 done_bit6_row
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    
    # should I put a provision for if bit 5 is '1'?  And how to handle if there are '.' above the inserted pieces?
    li $t3 46
    beq $v0 $t3 done_bit6_row
    move $t1 $v1
    #li $t2 46
    #bne $t1 $t2 bit6_charFound
    #addi $t9 $t9 -1
    ble $t1 $t9 invalid_bit6
    
    addi $s5 $s5 1
    b while_bit6_row
    
    #bit6_charFound:
    #blez $t9 invalid_bit6
    #addi $s5 $s5 1
    #b while_bit6_row
    
    done_bit6_row:
    addi $s6 $s6 1
    b while_bit6_col
    
    done_bit6:
    ori $s4 $s4 0
    sll $s4 $s4 1
    b bit6
    
    invalid_bit6:
    ori $s4 $s4 64
    sll $s4 $s4 1
    
    bit7:
    # Break this to two cases, starting with turn numbers don't start at 1
    li $t9 1
    li $s5 0
    li $s6 0
    
    li $t8 255
    findLowestTurnNum:
    bge $s6 $s2 verifyMinTurnNum
    move $a0 $s0
    move $a1 $s2
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    
    blt $v1 $t8 setMinTurnNum
    addi $s6 $s6 1
    b findLowestTurnNum
    
    setMinTurnNum:
    move $t8 $v1
    addi $s6 $s6 1
    b findLowestTurnNum
    
    verifyMinTurnNum:
    li $t0 2
    blez $t8 invalid_bit7
    bge $t8 $t0 invalid_bit7
    
    verifyDistinctTurnNums:
    li $s5 0
    li $s6 0
    li $t9 0
    
    while_verifyDistinctTurnNums_rows:
    bge $s5 $s1 valid_bit7
    li $s6 0
    
    while_verifyDistinctTurnNums_cols:
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -4
    sw $s6 0($sp)
    jal get_slot
    lw $s6 0($sp)
    move $sp $fp
    
    li $t0 46
    beq $v0 $t0 done_verifyDistinctTurnNums_col
    
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s5
    move $fp $sp
    addi $sp $sp -8
    sw $s6 0($sp)
    sw $v1 4($sp)
    jal hasSameTurnNumber
    lw $s6 0($sp)
    lw $v1 4($sp)
    move $sp $fp
    bnez $v0 invalid_bit7
    
    done_verifyDistinctTurnNums_col:
    addi $s6 $s6 1
    b while_verifyDistinctTurnNums_cols
    
    done_verifyDistinctTurnNums_row:
    addi $s5 $s5 1
    b while_verifyDistinctTurnNums_rows
    
    invalid_bit7:
    ori $s4 $s4 128
    b done_validate
    
    valid_bit7:
    ori $s4 $s4 0
    
    done_validate:
    move $v0 $s4
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp) # where to store our file descriptor
    lw $s5 20($sp) # address of our buffer
    lw $s6 24($sp) # counter for # of pieces found
    lw $ra 28($sp)
    addi $sp $sp 32
    
    jr $ra

hasSameTurnNumber: # Helper function for bit 7 in the above function
    lw $t0 0($sp)
    lw $t1 4($sp)
    
    addi $sp $sp -28
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $s5 20($sp)
    sw $ra 24($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    move $s3 $a3 # row
    move $s4 $t0 # col
    move $s5 $t1 # turn_number
    
    # maybe add provisions for arguments of row and col too great for the dimensions of board?
    b while_getTurnNum_col
    
    while_getTurnNum_row:
    li $s4 0
    bge $s3 $s1 valid_turnNumber
    while_getTurnNum_col:
    bge $s4 $s2 done_getTurnNum_col
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    move $fp $sp
    addi $sp $sp -4
    sw $s4 0($sp)
    jal get_slot
    lw $s4 0($sp)
    move $sp $fp
    
    beq $v1 $s5 badTurnNumber
    
    addi $s4 $s4 1
    b while_getTurnNum_col
    
    done_getTurnNum_col:
    addi $s3 $s3 1
    b while_getTurnNum_row
    
    valid_turnNumber:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $ra 24($sp)
    addi $sp $sp 28
    
    li $v0 0
    jr $ra
    
    badTurnNumber:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $ra 24($sp)
    addi $sp $sp 28
    
    li $v0 -1
    jr $ra
     
##############################
# Part III FUNCTIONS
##############################

display_board:
    bltz $a1 badDisplayBoard
    bltz $a2 badDisplayBoard
    
    addi $sp $sp -32
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp) # row
    sw $s4 16($sp) # col
    sw $s5 20($sp) # original address of String buffer
    sw $s6 24($sp) # address of String buffer to increment
    sw $ra 28($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    
    addi $s3 $s1 -1
    li $s4 0
    
    while_boardRows:
    bltz $s3 done_boardRows
    move $s6 $s5
    while_boardCols:
    bge $s4 $s2 done_boardCols
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    move $fp $sp
    addi $sp $sp -4
    sw $s4 0($sp)
    jal get_slot
    lw $s4 0($sp)
    move $sp $fp
    #sb $v0 0($s6)
    #addi $s6 $s6 1
    move $a0 $v0
    li $v0 11
    syscall
    addi $s4 $s4 1
    b while_boardCols
    
    done_boardCols:
    #move $a0 $s5
    #li $v0 4
    li $a0 10
    li $v0 11
    syscall
    addi $s3 $s3 -1
    li $s4 0
    b while_boardRows
    
    done_boardRows:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp) 
    lw $s4 16($sp) 
    lw $s5 20($sp) 
    lw $s6 24($sp) 
    lw $ra 28($sp)
    addi $sp $sp 32
    
    li $v0 0
    jr $ra
    
    badDisplayBoard:
    li $v0 -1
    jr $ra

drop_piece:
    lw $t0 0($sp)
    lw $t1 4($sp)
    # Error cases for this function below
    bltz $a1 dropPieceError1
    bltz $a2 dropPieceError1
    bltz $a3 dropPieceError1
    bge $a3 $a2 dropPieceError1
    li $t2 256
    bge $t1 $t2 dropPieceError1
    li $t2 82
    beq $t0 $t2 loadStackValues_drop_piece
    li $t2 89
    beq $t0 $t2 loadStackValues_drop_piece
    b dropPieceError1
    
    # None of the errors (except no available slots in 'col') have occurred, yet ... store copies to the stack
    loadStackValues_drop_piece:
    addi $sp $sp -32
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $s5 20($sp)
    sw $s6 24($sp) # row
    sw $ra 28($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    move $s3 $a3
    move $s4 $t0
    move $s5 $t1
    li $s6 0
    
    while_drop_piece:
    bge $s6 $s1 dropPieceError2
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s6
    move $fp $sp
    addi $sp $sp -4
    sw $s3 0($sp)
    jal get_slot
    # lw?
    move $sp $fp
    
    li $t0 46
    bne $v0 $t0 inc_while_drop_piece
    
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s6
    move $fp $sp
    addi $sp $sp -12
    sw $s3 0($sp)
    sw $s4 4($sp)
    sw $s5 8($sp)
    jal set_slot
    # lw statements?
    move $sp $fp
    bnez $v0 dropPieceError2
    b done_drop_piece
    
    inc_while_drop_piece:
    addi $s6 $s6 1
    b while_drop_piece
    
    done_drop_piece:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $s6 24($sp) 
    lw $ra 28($sp)
    addi $sp $sp 32
    
    li $v0 0
    jr $ra
    
    dropPieceError2:
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $s5 20($sp)
    lw $s6 24($sp) 
    lw $ra 28($sp)
    addi $sp $sp 32
    
    li $v0 -1
    jr $ra
    
    dropPieceError1: # for if any of the errors (save no available slots in 'col') occur
    li $v0 -1
    jr $ra

undo_piece:
    bltz $a1 undo_piece_error1
    bltz $a2 undo_piece_error1
    
    addi $sp $sp -36
    sw $s0 0($sp) # $s0 - $s2 are function args
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp) # row
    sw $s4 16($sp) # col
    sw $s5 20($sp) # max_turn_num
    sw $s6 24($sp) # max_turn_num_row
    sw $s7 28($sp) # max_turn_num_col
    sw $ra 32($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    addi $s3 $a1 -1
    li $s4 0
    li $s5 0
    li $s6 0
    li $s7 0
    
    while_undo_piece_col:
    addi $s3 $s1 -1
    bge $s4 $s2 done_undo_piece
    
    while_undo_piece_row:
    bltz $s3 done_undo_piece_col
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    move $fp $sp
    addi $sp $sp -4
    sw $s4 0($sp)
    jal get_slot
    # lw?
    li $t0 46
    beq $v0 $t0 done_undo_piece_row
    # if the above statement does not execute, we have found the topmost piece/char
    move $t9 $v0
    # is it greater than the highest turn num found?
    ble $v1 $s5 done_undo_piece_col
    # if the above statement doesn't execute, this turn num is greater than the previous, so change the $s5 - $s7 accordingly
    move $s5 $v1
    move $s6 $s3
    move $s7 $s4
    b done_undo_piece_col
    
    done_undo_piece_row:
    addi $s3 $s3 -1
    b while_undo_piece_row
    
    done_undo_piece_col:
    addi $s4 $s4 1
    b while_undo_piece_col
    
    done_undo_piece: # We've completed the loop, is there a valid max_turn_num?
    blez $s5 undo_piece_error2
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    # load c $t-registers, keep turn_num as is in the max slot
    li $t0 46
    
    move $fp $sp
    addi $sp $sp -12
    sw $s4 0($sp)
    sw $t0 4($sp)
    sw $s5 8($sp)
    jal set_slot
    move $sp $fp
    bnez $v0 undo_piece_error2
    
    move $v0 $t9
    move $v1 $s5
    
    lw $s0 0($sp) # $s0 - $s2 are function args
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp) # row
    lw $s4 16($sp) # col
    lw $s5 20($sp) # max_turn_num
    lw $s6 24($sp) # max_turn_num_row
    lw $s7 28($sp) # max_turn_num_col
    lw $ra 32($sp)
    addi $sp $sp 36
    
    jr $ra
    
    undo_piece_error1:
    li $v0 46
    li $v1 -1
    jr $ra
    
    undo_piece_error2:
    lw $s0 0($sp) # $s0 - $s2 are function args
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp) # row
    lw $s4 16($sp) # col
    lw $s5 20($sp) # max_turn_num
    lw $s6 24($sp) # max_turn_num_row
    lw $s7 28($sp) # max_turn_num_col
    lw $ra 32($sp)
    addi $sp $sp 36
    
    li $v0 46
    li $v1 -1
    jr $ra

check_winner:
    addi $sp $sp -32
    sw $s0 0($sp) # $s0 - $s2 are argument registers
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp) # row
    sw $s4 16($sp) # col
    sw $s5 20($sp) # number in a row, default 1
    sw $s6 24($sp) # current piece char
    sw $ra 28($sp)
    
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    li $s3 0
    li $s4 0
    li $s5 1
    li $s6 46
    
    # First, iterate by ROWS
    while_check_winner_iterate_row:
    bge $s3 $s1 while_check_winner_iterate_col
    li $s4 0
    li $s5 1
    li $s6 46
    while_check_winner_iterate_row_col:
    bge $s4 $s2 while_check_winner_iterate_row_increment
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    move $fp $sp
    addi $sp $sp -8
    sw $s4 0($sp)
    sw $fp 4($sp)
    jal get_slot
    lw $fp 4($sp)
    move $sp $fp
    beq $v0 $s6 samePieceChar_row
    li $s5 1
    move $s6 $v0
    addi $s4 $s4 1
    b while_check_winner_iterate_row_col
    
    samePieceChar_row:
    addi $s5 $s5 1
    li $t0 4
    beq $s5 $t0 winner_found
    addi $s4 $s4 1
    b while_check_winner_iterate_row_col
    
    while_check_winner_iterate_row_increment:
    addi $s3 $s3 1
    b while_check_winner_iterate_row
    
    while_check_winner_iterate_col:
    bge $s4 $s2 no_winner_found
    li $s3 0
    li $s5 1
    li $s6 46
    while_check_winner_iterate_col_row:
    bge $s3 $s1 while_check_winner_iterate_col_increment
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    move $fp $sp
    addi $sp $sp -8
    sw $s4 0($sp)
    sw $fp 4($sp)
    jal get_slot
    lw $fp 4($sp)
    move $sp $fp
    beq $v0 $s6 samePieceChar_col
    li $s5 1
    move $s6 $v0
    addi $s3 $s3 1
    b while_check_winner_iterate_col_row
    
    samePieceChar_col:
    addi $s5 $s5 1
    li $t0 4
    beq $s5 $t0 winner_found
    addi $s3 $s3 1
    b while_check_winner_iterate_col_row
    
    while_check_winner_iterate_col_increment:
    addi $s4 $s4 1
    b while_check_winner_iterate_col
    
    winner_found:
    move $v0 $s6
    jr $ra
    
    no_winner_found:
    li $v0 46
    jr $ra

##############################
# EXTRA CREDIT FUNCTION
##############################


check_diagonal_winner:
    li $v0 82
    jr $ra
    
##############################################################
# DO NOT DECLARE A .DATA SECTION IN YOUR HW. IT IS NOT NEEDED
##############################################################
