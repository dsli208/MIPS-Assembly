##############################################################
# Homework #3
# name: David S. Li
# sbuid: 110328771
##############################################################
.text

##############################
# FUNCTIONS
##############################

indexOf:
    #arguments: $a0 char[] str, $a1 char ch, $a2 int startIndex
    
    # Start at the specified index, and loop through the char[] until we find the first occurrence or reach null
    
    add $a0 $a0 $a2 # Add to the address, to get to the specified char index
    
    while_indexOf: # Looping through the string/char[]
    	lb $t0 0($a0)
    	beqz $t0 indexOfError # null character?  Bad index or reached the end of the char[] without finding ch
    	beq $a1 $t0 foundIndexOf # check to see if we have found the specified character, breaking from the loop if we do...
    	# if not, check the next character ...
    	
    	addi $a0 $a0 1 # first increment the String pointer
    	addi $a2 $a2 1 # and then the index...
    	
    	b while_indexOf # redo the loop in its new iteration
    
    #return $v0: an int, the index of (the first occurence of) ch in str (-1) if ch is not found
    foundIndexOf:
    	move $v0 $a2 # move our index variable to $v0 is the character is found (first occurring index)
    	jr $ra
    
    indexOfError: # if the character is not found, or if there is an error
    	li $v0 -1
    	jr $ra

replaceAllChar:
    #arguments: $a0 char[] str, $a1 char[] pattern, $a2 char replacement
    
    # save original $a0 and $a1 addresses before continuing - stack pointer
    addi $sp $sp -12
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $ra 8($sp)
    
    # saving the addresses
    move $s0 $a0
    move $s1 $a1
    
    # check to make sure our char[] arguments are NOT null
    lb $t0 0($a0)
    lb $t1 0($a1)
    # We have a replaceCharError if either char[] is null/empty
    beqz $t0 replaceCharError
    beqz $t1 replaceCharError
    # else, prepare the replacement counter
    li $t2 0
    
    while_replaceAllChar_outer:
    
    # at each step, load a char from $a0 to compare
    lb $t0 0($a0)
    beqz $t0 done_replaceAllChar # done if we have fully iterated through the char[] str
    
    # not done? We have a character, determine if we should replace it
    
    while_replaceAllChar_inner:
    	lb $t1 0($a1) # check to see if we are at the end of the $a0 string
    	beqz $t1 done_replaceAllChar_nullFound
    	beq $t0 $t1 done_replaceAllChar_charFound
    	addi $a1 $a1 1
    	b while_replaceAllChar_inner
    	
    	done_replaceAllChar_charFound:
    	# Store the replacement char ($a2) to the char index loaded in the current $a0 address
    	sb $a2 0($a0)
    	move $a1 $s1 # Restore original $a1 address
    	addi $a0 $a0 1 # Increment to the next char in the char[]
    	addi $t2 $t2 1
    	b while_replaceAllChar_outer
    	
    	done_replaceAllChar_nullFound:
    	# We have iterated through the $a1 char[], no matching chars were found
    	move $a1 $s1 # Restore the original $a1 address
    	addi $a0 $a0 1
    	b while_replaceAllChar_outer
    	
    done_replaceAllChar:
    	move $v0 $s0 # restore the original $a0 address
    	move $v1 $t2 # load in the number of swaps performed
    	
    	# restore stack pointer to original position
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	#return: $v0: char[] str (address), $v1: int for number of times replacement occurred (-1 if there was an error)
    	jr $ra
    
    replaceCharError:
    	move $v0 $s0
    	li $v1 -1
    	
    	# restore stack pointer to original position
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	
    	jr $ra

countOccurrences:
    # Arguments: $a0: char[] str, $a1: char[] searchChars
    
    # Stack pointer - save the original copies before they are potentially modified
    addi $sp $sp -12
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $ra 8($sp)
    
    move $s0 $a0
    move $s1 $a1
    
    # check to make sure neither $a0 or $a1 is an empty string
    lb $t0 0($a0)
    lb $t1 0($a1)
    beqz $t0 countOccurrences_error
    beqz $t1 countOccurrences_error
    
    # neither $a0 or $a1 is empty?  Start looping through the strings:
    li $t2 0
    while_countOccurrences_outer:
    	lb $t0 0($a0) # load character at the current position
    	beqz $t0 done_countOccurrences# null - end of str
    	
    	# compare char in $t0 to each char in searchChars:
    	while_countOccurrences_inner:
    		lb $t1 0($a1) # load character from searchChars
    		beqz $t1 done_countOccurrences_nullChar # null character - end of searchChars - $t0 is not a search char, next char in str
    		# if the above does not execute, we have a char to compare with
    		beq $t0 $t1 done_countOccurrences_charFound
    		# if the above does not execute, the chars do not match
    		addi $a1 $a1 1
    		b while_countOccurrences_inner
    		
    		done_countOccurrences_nullChar:
    		move $a1 $s1 # reset the searchChars pointer position
    		addi $a0 $a0 1
    		b while_countOccurrences_outer
    		
    		done_countOccurrences_charFound:
    		addi $t2 $t2 1
    		move $a1 $s1
    		addi $a0 $a0 1
    		b while_countOccurrences_outer
    		
    done_countOccurrences:
    	move $v0 $t2
    	# return stack pointer
    	lw $s0 0($sp)
    	lw $s1 4($sp)
    	lw $ra 8($sp)
    	addi $sp $sp 12
    # Return $v0: number of times searchChars occurs/appears in str
    	jr $ra
    
    countOccurrences_error:
    li $v0 0
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $ra 8($sp)
    addi $sp $sp 12
    
    jr $ra

replaceAllSubstr:
    # First things first, decrement the stack pointer and store saved versions of your original addresses
    addi $sp $sp -24
    sw $s0 4($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $ra 20($sp)
    
    # Storing your saved addresses
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    move $s3 $a3
    move $s4 $t0
    
    # first, check $a2 and $a3, making sure that they are NOT empty
    # first $a2
    lb $t1 0($a2)
    li $t2 10 # check for \n, in addition to null
    beqz $t1 replaceAllSubstr_error
    beq $t1 $t2 replaceAllSubstr_error
    
    # now do the same thing for $a3
    lb $t1 0($a3)
    li $t2 10 # check for \n, in addition to null
    beqz $t1 replaceAllSubstr_error
    beq $t1 $t2 replaceAllSubstr_error
    
    # Now let's ensure that the String, if modified, WON'T cause a length problem
    
    # First count the occurrences of the searchChars in str, since THIS IS OUR FUNCTION CALL
    # Load arguments properly
    move $a0 $a2
    move $a1 $a3
    jal countOccurrences
    # countOccurrences execution, then return here:
    # start restoring your original argument forms
    move $a0 $s0
    move $a1 $s1
    move $a2 $s2
    move $a3 $s3
    move $t0 $s4
    
    # Now get the amount of extra chars per insertion
    li $t2 0 # counter variable for our length
    while_checkReplaceStrLen:
    lb $t1 0($t0)
    beqz $t1 done_checkReplaceStrLen # need to have a provision for \n terminators?
    addi $t2 $t2 1 # increment counter
    addi $t0 $t0 1 # increment pointer in $t0
    b while_checkReplaceStrLen
    
    done_checkReplaceStrLen:
    move $t0 $s4 # Reset pointer in $t0, using saved address $s3
    addi $t2 $t2 -1 # Because for each replacement, we replace one existing character, and insert (n - 1) other characters
    
    # Now, get length of str
    li $t3 0 # counter for strLen
    while_getStrLen:
    lb $t1 0($a2)
    beqz $t1 done_getStrLen
    addi $t3 $t3 1
    addi $a2 $a2 1
    b while_getStrLen
    
    done_getStrLen:
    move $a2 $s2
    
    # Now we have what we need to check if dstLen is valid: occurrences ($v0), extra insertions per occurrence ($t2), and original strLen ($t3)
    # So find our modified string length using this formula: $t4 = $t3 + $v0 * $t2
    mult $v0 $t2
    mflo $t4
    add $t4 $t4 $t3
    addi $t4 $t4 1 # add 1 to account for the newly inserted \0
    
    # check $t4 <= dstLen ($a1)
    bgt $t4 $a1 replaceAllSubstr_error
    
    # if the above statement does not execute, our modified String is within dstLen
    
    # Now iterate through the str, determing where to place the replaceStr
    move $a2 $s2 # make sure our String pointer in $a2 is reset before starting
    li $t2 0 # initialize counter for loop
    while_writeToDst:
    lb $t1 0($a2)
    beqz $t1 copyToDst # label not written yet
    
    # is it a searchChar?  Loop through to find if it is...
    while_searchSearchChars:
    lb $t3 0($a3)
    beqz $t3 done_searchSearchChars_null
    beq $t1 $t3 done_searchSearchChars_found
    addi $a3 $a3 1
    b while_searchSearchChars
    
    done_searchSearchChars_null:
    move $a3 $s3 # reset String pointer for $a3
    # not a search char, so print the char at the index
    sb $t1 0($a0)
    addi $a0 $a0 1
    addi $t2 $t2 1
    addi $a2 $a2 1
    b while_writeToDst
    
    done_searchSearchChars_found:
    move $a3 $s3
    # since this is a search char, we have to print the replaceStr instead of the searchChar
    while_insertReplaceStr:
    lb $t3 0($t0)
    beqz $t3 done_insertReplaceStr
    sb $t3 0($a0)
    addi $t0 $t0 1
    addi $a0 $a0 1
    addi $t2 $t2 1
    
    b while_insertReplaceStr
    
    done_insertReplaceStr:
    addi $a2 $a2 1
    move $t0 $s4
    b while_writeToDst
    
    copyToDst:
    # actually, rename that ^ for the stuff that was intended to be copied is already there!
    li $t1 0
    sb $t1 0($a0)
    
    move $v1 $v0
    move $v0 $s0
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $ra 20($sp)
    addi $sp $sp 24
    
    jr $ra
    
    replaceAllSubstr_error:
    move $v0 $a0
    li $v1 -1
    
    lw $s0 0($sp)
    lw $s1 4($sp)
    lw $s2 8($sp)
    lw $s3 12($sp)
    lw $s4 16($sp)
    lw $ra 20($sp)
    addi $sp $sp 24
    
    jr $ra

split:
    # stack pointer
    addi $sp $sp -32
    sw $s0 0($sp)
    sw $s1 4($sp)
    sw $s2 8($sp)
    sw $s3 12($sp)
    sw $s4 16($sp)
    sw $s5 20($sp)
    sw $s6 24($sp)
    sw $ra 28($sp)
    
    # original address copies
    move $s0 $a0
    move $s1 $a1
    move $s2 $a2
    move $s3 $a3
    
    move $s4 $a2 # this will be our copy of the address that we are "working on"
    move $s5 $a0 # version of dst[] to work on
    
    lb $t1 0($s2) # check to see that str is not empty
    beqz $t1 split_error
    
    # initialize some variables: 
    li $s6 1 # this will serve as a "check variable for dstLen/$a1
    
    # Check for a starting delimiter
    sw $s4 0($s5)
    addi $s5 $s5 4
    bne $t1 $s3 while_split
    # if the above line does not execute, starting delimiter
    sb $0 0($s4)
    addi $s4 $s4 1
    sw $s4 0($s5)
    addi $s5 $s5 4
    addi $s6 $s6 1
    
    # Now start to find indices of the delimiter/$a3 until we get a -1
    while_split:
    move $a0 $s4
    move $a1 $a3
    li $a2 0
    jal indexOf
    
    # Restore variables...
    
    
    # After returning from indexOf ...
    bltz $v0 done_split
    
    # check to see we are not at our limit, dstLen
    beq $s6 $s1 split_error # label not defined yet
    
    add $s4 $s4 $v0
    li $t1 0
    sb $0 0($s4)
    addi $s4 $s4 1
    sw $s4 0($s5) # Storing into dst[]
    addi $s6 $s6 1
    addi $s5 $s5 4
    
    # Check for ending delimiter
    lb $t1 0($s4)
    bnez $t1 while_split
    # After the previous character, we have passed the null terminator
    sw $s4 0($s5)
    addi $s5 $s5 4
    #addi $s6 $s6 1
    
    
    done_split:
    move $v0 $s6
    li $v1 0
    
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

    split_error:
    move $v0 $s6
    li $v1 -1
    
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
