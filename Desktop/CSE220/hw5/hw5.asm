# CSE 220, Homework 5
# David S. Li
# 110328771

.text

match_glob:
	# $a0 is seq, $a1 is pat
	addi $sp $sp -20
	sw $s0 0($sp) # original address, char[] seq
	sw $s1 4($sp) # original address, char[] pat
	sw $s2 8($sp) # address of seq to increment
	sw $s3 12($sp) # address of pat to increment
	sw $ra 16($sp)
	
	move $s0 $a0
	move $s1 $a1
	
	move $a0 $s1
	la $a1 astSequence
	jal equals
	beqz $v0 matchAst
	
	move $a0 $s0
	move $a1 $s1
	jal equalsIgnoreCase # FUNCTION NOT YET FULLY IMPLEMENTED, REMOVE THIS WHEN YOU ARE FINISHED IMPLEMENTING IT
	beqz $v0 identicalSeqPat
	
	move $a0 $s0
	jal length
	move $t8 $v0
	move $a0 $s1
	jal length
	move $t9 $v0
	#xor $t2 $t0 $t1 # Bug here, way to fix it?
	li $t3 1
	bnez $t8 notEmptySeq
	li $t3 0
	
	notEmptySeq:
	li $t4 1
	bnez $t9 notEmptyPat
	li $t4 0
	
	notEmptyPat:
	xor $t2 $t3 $t4
	
	bnez $t2 noMatchPossible
	
	lb $a0 0($s0) # seq[0]
	jal toLower
	move $t8 $v0
	lb $a0 0($s1)
	jal toLower
	move $t9 $v0
	
	beq $t8 $t9 equalChars
	
	lb $t2 0($s1)
	li $t3 42
	bne $t2 $t3 noMatchPossible
	
	# (pat[0] == '*')
	move $s2 $s0 # Problem: $a0 increments, but $a1 doesn't seem to increment
	addi $s3 $s1 1
	move $a0 $s2
	move $a1 $s3
	jal match_glob
	li $t4 1
	beq $v0 $t4 match1Found
	addi $s2 $s0 1
	move $s3 $s1
	move $a0 $s2
	move $a1 $s3
	jal match_glob
	addi $v1 $v1 1
	lw $s0 0($sp) # original address, char[] seq
	lw $s1 4($sp) # original address, char[] pat
	lw $s2 8($sp) # address of seq to increment
	lw $s3 12($sp) # address of pat to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	
	match1Found:
	lw $s0 0($sp) # original address, char[] seq
	lw $s1 4($sp) # original address, char[] pat
	lw $s2 8($sp) # address of seq to increment
	lw $s3 12($sp) # address of pat to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	
	matchAst:
	move $a0 $s0
	jal length
	move $v1 $v0
	li $v0 1
	lw $s0 0($sp) # original address, char[] seq
	lw $s1 4($sp) # original address, char[] pat
	lw $s2 8($sp) # address of seq to increment
	lw $s3 12($sp) # address of pat to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	
	identicalSeqPat:
	li $v0 1
	li $v1 0
	lw $s0 0($sp) # original address, char[] seq
	lw $s1 4($sp) # original address, char[] pat
	lw $s2 8($sp) # address of seq to increment
	lw $s3 12($sp) # address of pat to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	
	noMatchPossible:
	li $v0 0
	li $v1 0
	lw $s0 0($sp) # original address, char[] seq
	lw $s1 4($sp) # original address, char[] pat
	lw $s2 8($sp) # address of seq to increment
	lw $s3 12($sp) # address of pat to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	
	equalChars:
	addi $a0 $s0 1
	addi $a1 $s1 1
	# Do we need to do anything with the $v-registers
	jal match_glob
	lw $s0 0($sp) # original address, char[] seq
	lw $s1 4($sp) # original address, char[] pat
	lw $s2 8($sp) # address of seq to increment
	lw $s3 12($sp) # address of pat to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
		
	
# Helper functions for match_glob
equals:
	#$a0 is source string (seq), $a1 is string to compare to (pat in this case)
	addi $sp $sp -20
	sw $s0 0($sp) # original address of $a0
	sw $s1 4($sp) # original address of $a1
	sw $s2 8($sp) # address of $a0 to increment
	sw $s3 12($sp) # address of $a1 to increment
	sw $ra 16($sp)
	
	move $s0 $a0
	move $s1 $a1
	move $s2 $s0
	move $s3 $s1
	
	compareChar_equals:
	lb $t0 0($s2)
	lb $t1 0($s3)
	beq $t0 $t1 incNextChar_equals
	b notEqual_equals
	
	incNextChar_equals:
	beqz $t0 equal_equals
	addi $s2 $s2 1
	addi $s3 $s3 1
	b compareChar_equals
	
	notEqual_equals:
	lw $s0 0($sp) # original address of $a0
	lw $s1 4($sp) # original address of $a1
	lw $s2 8($sp) # address of $a0 to increment
	lw $s3 12($sp) # address of $a1 to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	
	li $v0 -1
	jr $ra
	
	equal_equals:
	lw $s0 0($sp) # original address of $a0
	lw $s1 4($sp) # original address of $a1
	lw $s2 8($sp) # address of $a0 to increment
	lw $s3 12($sp) # address of $a1 to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	
	li $v0 0
	jr $ra

equalsIgnoreCase:
	#$a0 is source string (seq), $a1 is string to compare to (pat in this case)
	addi $sp $sp -20
	sw $s0 0($sp) # original address of $a0
	sw $s1 4($sp) # original address of $a1
	sw $s2 8($sp) # address of $a0 to increment
	sw $s3 12($sp) # address of $a1 to increment
	sw $ra 16($sp)
	
	move $s0 $a0
	move $s1 $a1
	move $s2 $s0
	move $s3 $s1
	
	compareChar_equalsIgnoreCase:
	####### MODIFY THIS, TO ADD A PROVISION FOR CHARACTERS OF DIFFERENT CASES ####################
	lb $a0 0($s2)
	jal toLower
	move $t0 $v0
	lb $a0 0($s3)
	jal toLower
	move $t1 $v0
	beq $t0 $t1 incNextChar_equalsIgnoreCase
	b notEqual_equalsIgnoreCase
	
	incNextChar_equalsIgnoreCase:
	beqz $t0 equal_equalsIgnoreCase
	addi $s2 $s2 1
	addi $s3 $s3 1
	b compareChar_equalsIgnoreCase
	
	notEqual_equalsIgnoreCase:
	lw $s0 0($sp) # original address of $a0
	lw $s1 4($sp) # original address of $a1
	lw $s2 8($sp) # address of $a0 to increment
	lw $s3 12($sp) # address of $a1 to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	
	li $v0 -1
	jr $ra
	
	equal_equalsIgnoreCase:
	lw $s0 0($sp) # original address of $a0
	lw $s1 4($sp) # original address of $a1
	lw $s2 8($sp) # address of $a0 to increment
	lw $s3 12($sp) # address of $a1 to increment
	lw $ra 16($sp)
	addi $sp $sp 20
	
	li $v0 0
	jr $ra

length:
	# $a0 is the String to compare
	addi $sp $sp -8
	sw $s0 0($sp) # Reference to the starting address of the String
	sw $ra 4($sp)
	
	move $s0 $a0
	
	lb $t0 0($s0)
	beqz $t0 baseCase_length
	
	addi $a0 $s0 1
	jal length
	
	addi $v0 $v0 1
	
	lw $s0 0($sp) # Reference to the starting address of the String
	lw $ra 4($sp)
	addi $sp $sp 8
	
	jr $ra
	
	baseCase_length:
	lw $s0 0($sp) # Reference to the starting address of the String
	lw $ra 4($sp)
	addi $sp $sp 8
	
	li $v0 0
	jr $ra

toLower:
	# $a0 is the input char
	addi $sp $sp -4
	sw $ra 0($sp)

	li $t0 65
	li $t1 90
	
	# if ($a0 >= 65 && $a0 <= $t1) --> UPPERCASE
	blt $a0 $t0 notUppercase
	bgt $a0 $t1 notUppercase
	
	addi $v0 $a0 32
	
	lw $ra 0($sp)
	addi $sp $sp 4
	jr $ra
	
	notUppercase:
	
	lw $ra 0($sp)
	addi $sp $sp 4
	move $v0 $a0
	jr $ra
	
save_perm:
	addi $sp $sp -12
	sw $s0 0($sp) # dst - original address
	sw $s1 4($sp) # seq - original address
	sw $ra 8($sp)
	
	move $s0 $a0
	move $s1 $a1
	
	while_save_perm:
	# iterate two chars, moving them to dst
	lb $t0 0($s1)
	bgez $t0 noNegative_1
	lw $t1 negOne
	mult $t0 $t1
	mflo $t0
	noNegative_1:
	sb $t0 0($s0)
	addi $s1 $s1 1
	addi $s0 $s0 1
	lb $t0 0($s1)
	bgez $t0 noNegative_2
	lw $t1 negOne
	mult $t0 $t1
	mflo $t0
	noNegative_2:
	sb $t0 0($s0)
	addi $s1 $s1 1
	addi $s0 $s0 1
	
	# now we have added the pair, if at null, return, else add a hyphen and get the next pair
	li $t0 45
	lb $t1 0($s1)
	bgez $t1 noNegative_3
	lw $t2 negOne
	mult $t2 $t1
	mflo $t1
	noNegative_3:
	beqz $t1 done_save_perm
	sb $t0 0($s0)
	addi $s0 $s0 1
	b while_save_perm
	
	done_save_perm:
	li $t0 10
	sb $t0 0($s0)
	addi $v0 $s0 1
	lw $s0 0($sp) # dst - original address
	lw $s1 4($sp) # seq - original address
	lw $ra 8($sp)
	addi $sp $sp 12
	jr $ra

construct_candidates:
	# $a0 is char[] cand, $a1 is char[] seq, and $a2 is int n
	addi $sp $sp -16
	sw $s0 0($sp) # char[] cand
	sw $s1 4($sp) # char[] seq
	sw $s2 8($sp) # int n
	sw $ra 12($sp)
	
	move $s0 $a0
	move $s1 $a1
	move $s2 $a2
	
	li $t0 2
	div $s2 $t0
	mflo $t0
	mfhi $t1
	beqz $t1 else_construct_candidates # (n % 2 == 0), ELSE CASE
	
	# (n % 2 != 0)
	li $t0 0 # contains char seq[i - 1]
	li $t1 0
	li $t2 0 # counter
	
	while_construct_candidates:
	bge $t2 $s2 done_construct_candidates
	move $t0 $t1
	lbu $t1 0($s1)
	addi $t2 $t2 1
	addi $s1 $s1 1
	b while_construct_candidates
	
	done_construct_candidates:
	la $t3 dnaChars
	lb $t4 0($t3)
	beq $t1 $t4 aChar
	addi $t3 $t3 1
	lb $t4 0($t3)
	beq $t1 $t4 cChar
	addi $t3 $t3 1
	lb $t4 0($t3)
	beq $t1 $t4 tChar
	# else, gChar
	li $t5 67
	sb $t5 0($s0)
	li $v0 1
	lw $s0 0($sp) # char[] cand
	lw $s1 4($sp) # char[] seq
	lw $s2 8($sp) # int n
	lw $ra 12($sp)
	addi $sp $sp 16
	jr $ra
	
	aChar:
	li $t5 84
	sb $t5 0($s0)
	li $v0 1
	lw $s0 0($sp) # char[] cand
	lw $s1 4($sp) # char[] seq
	lw $s2 8($sp) # int n
	lw $ra 12($sp)
	addi $sp $sp 16
	jr $ra
	
	cChar:
	li $t5 71
	sb $t5 0($s0)
	li $v0 1
	lw $s0 0($sp) # char[] cand
	lw $s1 4($sp) # char[] seq
	lw $s2 8($sp) # int n
	lw $ra 12($sp)
	addi $sp $sp 16
	jr $ra
	
	tChar:
	li $t5 65
	sb $t5 0($s0)
	li $v0 1
	lw $s0 0($sp) # char[] cand
	lw $s1 4($sp) # char[] seq
	lw $s2 8($sp) # int n
	lw $ra 12($sp)
	addi $sp $sp 16
	jr $ra
	
	else_construct_candidates:
	la $t2 dnaChars
	while_else_construct_candidates:
	lb $t3 0($t2)
	beqz $t3 done_else_construct_candidates
	sb $t3 0($s0)
	addi $t2 $t2 1
	addi $s0 $s0 1
	b while_else_construct_candidates
	
	done_else_construct_candidates:
	li $v0 4
	lw $s0 0($sp) # char[] cand
	lw $s1 4($sp) # char[] seq
	lw $s2 8($sp) # int n
	lw $ra 12($sp)
	addi $sp $sp 16
	jr $ra
	
permutations:
	beqz $a3 error_permutations
	li $t0 2
	div $a3 $t0
	mfhi $t0
	bnez $t0 error_permutations
	
	addi $sp $sp -20
	sw $s0 0($sp) # char[] seq
	sw $s1 4($sp) # int n
	sw $s2 8($sp) # char[] res
	sw $s3 12($sp) # int length
	sw $ra 16($sp)
	
	move $s0 $a0
	move $s1 $a1
	move $s2 $a2
	move $s3 $a3
	
	bne $s1 $s3 else_permutations
	
	move $a0 $s0
	move $a1 $s3
	addi $a1 $a1 1
	jal add_null
	
	move $a0 $s2
	move $a1 $s0
	jal save_perm
	move $v1 $v0
	li $v0 0
	
	lw $s0 0($sp) # char[] seq
	lw $s1 4($sp) # int n
	lw $s2 8($sp) # char[] res
	lw $s3 12($sp) # int length
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	
	else_permutations:
	move $fp $sp
	addi $sp $sp -16
	sw $s4 0($sp) # int ncand
	sw $s5 4($sp) # int i
	sw $s6 8($sp) # char[] candidates
	sw $fp 12($sp)
	la $s6 candidates
	move $a0 $s6
	move $a1 $s0
	move $a2 $s1
	
	jal construct_candidates
	
	move $s4 $v0
	li $s5 0
	
	for_else_permutations:
	bge $s5 $s4 done_for_else_permutations
	add $t0 $s0 $s1
	#la $t1 candidates
	add $t2 $s6 $s5
	lb $t3 0($t2)
	sb $t2 0($t0)
	
	move $a0 $s0
	addi $a1 $s1 1
	move $a2 $s2
	move $a3 $s3
	jal permutations
	addi $s5 $s5 1
	b for_else_permutations
	
	done_for_else_permutations:
	li $v0 0
	lw $s4 0($sp)
	lw $s5 4($sp)
	lw $s6 8($sp)
	lw $fp 12($sp)
	move $sp $fp
	lw $s0 0($sp) # char[] seq
	lw $s1 4($sp) # int n
	lw $s2 8($sp) # char[] res
	lw $s3 12($sp) # int length
	lw $ra 16($sp)
	addi $sp $sp 20
	jr $ra
	# res is already in $v1
	
	error_permutations:
	li $v0 -1
	li $v1 0
	jr $ra

# add_null helper for the above function	
add_null:
	addi $sp $sp -4
	sw $ra 0($sp)
	add $t0 $a0 $a1
	sb $0 0($t0)
	lw $ra 0($sp)
	addi $sp $sp 4
	jr $ra

.data
astSequence: .asciiz "*"
dnaChars: .byte 'A', 'C', 'G', 'T', '\0'
candidates: .space 5
negOne: .word -1
