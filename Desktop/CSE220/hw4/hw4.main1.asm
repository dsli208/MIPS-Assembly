.data
newline: .asciiz	"\n"
newBoard: .asciiz	"validate_board_0"
board: .space	50
foutF:  .asciiz	"correctText.txt"
num_rows: .word 5
num_cols: .word 5
row: .word 3
col: .word 2
row_2: .word 2
col_2: .word 3
c: .byte 89
turn_num: .word 10
fout:   .asciiz "validate_board_0"

##################################################################
# Constants
.eqv QUIT 10
.eqv PRINT_STRING 4
.eqv PRINT_INT 1
.eqv PRINT_CHAR 11

.text
.globl main

   
main:
    ##########################
    # clear_board
    ##########################

    la $a0, board
    lw $a1, num_rows
    lw $a2, num_cols
    jal clear_board
    
    move $a0, $v0
    li $v0, PRINT_INT
    syscall
    
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    ## DEBUG ALGORITHM FOR GET AND SET SLOT
    ##########################
    # set_slot
    ##########################
    
    la $a0, board
    lw $a1, num_rows
    lw $a2, num_cols
    lw $a3, row
    addi $sp, $sp, -12
    lw $t0, col
    la $t1, c
    lb	$t1	0($t1)
    lw $t2, turn_num
    
    sw $t0, 0($sp)
    sw $t1, 4($sp)
    sw $t2, 8($sp)
    jal set_slot
    
    
    addi $sp, $sp, 12
    move $a0, $v0
    li $v0, PRINT_INT
    syscall
    
    
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    ##########################
    # print_board
    ##########################
    la $a0 board
    lw $a1 num_rows
    lw $a2 num_cols
    jal display_board
    
    
    ##########################
    # get_slot
    ##########################
    
    la $a0, board
    lw $a1, num_rows
    lw $a2, num_cols
    lw $a3, row
    addi $sp, $sp, -4
    lw $t0, col
    sw $t0, 0($sp)
    jal get_slot
    addi $sp, $sp, 4
    move $a0, $v0
    move $t1, $v1
    li $v0, PRINT_INT
    syscall
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    move $a0, $t1
    li $v0, PRINT_INT
    syscall
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    ##########################
    # clear_board
    ##########################

    la $a0, board
    lw $a1, num_rows
    lw $a2, num_cols
    jal clear_board
    
    move $a0, $v0
    li $v0, PRINT_INT
    syscall
    
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    
    ##########################
    # get_slot
    ##########################
    
    la $a0, board
    lw $a1, num_rows
    lw $a2, num_cols
    lw $a3, row
    addi $sp, $sp, -4
    lw $t0, col
    sw $t0, 0($sp)
    jal get_slot
    addi $sp, $sp, 4
    move $a0, $v0
    move $t1, $v1
    li $v0, PRINT_INT
    syscall
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    move $a0, $t1
    li $v0, PRINT_INT
    syscall
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    ##########################
    # print_board
    ##########################
    la $a0 board
    lw $a1 num_rows
    lw $a2 num_cols
    jal display_board
    
    
    ##########################
    # load_board
    ##########################
    la	$a0, 	board
    la	$a1	fout
    jal	load_board
    
    move $t0 $v0	#row
    move $t1 $v1	#column
    move $a0	$v0
    li	$v0	1
    syscall
    	
    move $a0	$v1
    li	$v0	1
    syscall    
    
    ##########################
    # get_slot from what we have set
    ##########################
    
    la $a0, board
    move $a1, $t0
    move $a2, $t1
    li $a3, 1
    addi $sp, $sp, -4
    li $t0, 1
    sw $t0, 0($sp)
    jal get_slot
    move	$t0	$v0
    move	$t1	$v1
    
    addi $sp, $sp, 4
    
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
        
    
    move $a0 $t0
    li $v0, 1
    syscall
    
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    move $a0, $v1
    li $v0, PRINT_INT
    syscall
    
    la $a0, newline
    li $v0, PRINT_STRING
    syscall
    
    #Test save
#    la	$a0 board
#    li	$a1	77
#    li	$a2	22
#    la	$a3	foutF
#    jal save_board
    
    #################
    # drop_piece #
    
    la $a0 board
    lw $a1 num_rows
    lw $a2 num_cols
    lw $a3 col
    addi $sp $sp -8
    lw $t0 c
    lw $t1 turn_num
    sw $t0 0($sp)
    sw $t1 4($sp)
    jal drop_piece
    addi $sp $sp 8
    
    move $a0 $v0
    li $v0 PRINT_INT
    syscall
    
    ##########################
    # print_board
    ##########################
    la $a0 board
    lw $a1 num_rows
    lw $a2 num_cols
    jal display_board
    
####################################################################

    # Exit the program
    li	$v0, 10
    syscall

####################################################################
# End of MAIN program
####################################################################


####################################################################
# Student defined functions will be included starting here
####################################################################

.include "hw4.asm"
