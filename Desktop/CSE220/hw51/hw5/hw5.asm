.text

match_glob:
	li $v0, -200
	li $v1, -200
	jr $ra

save_perm:
	li $v0, -200
	jr $ra

construct_candidates:
	li $v0, 4
	li $t3, 65
	sb $t3, 0($a0)
	li $t3, 66
	sb $t3, 1($a0)
	li $t3, 67
	sb $t3, 2($a0)
	li $t3, 68
	sb $t3, 3($a0)
	
	jr $ra
	
permutations:
	li $v0, -200
	li $v1, -200
	jr $ra

.data
