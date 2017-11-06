/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codinginterview1;

/**
 *
 * @author dsli
 */
// Applying as intern, graduating 2019

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class ElementarySchoolCalculator {


  public static void main(String[] args) {
    String expression = "6+9-12";
    System.out.println(calculateResult(expression));
  }
  
  public static int calculateResult(String exp) {
    // "Stack" structures used to keep track of numbers and operators as we parse them
    int numOperands = 0, numOperators = 0; // index at value - 1
    ArrayList<Integer> operands = new ArrayList<Integer>();
    ArrayList<Character> operators = new ArrayList<Character>();
    
    // First, iterate through the string and get each character
    for (int i = 0; i < exp.length(); i++) {
      char c = exp.charAt(i);
      // if we have a number, convert from ASCII to int value, making sure we get the WHOLE NUMBER
      if (c >= '0' && c <= '9') {
        int numValue = 0, conscNums = 0;
        
        while (c >= '0' && c <= '9') {
          numValue *= 10;
          int charValue = c - 48;
          numValue += charValue;
          
          if (i < exp.length() - 1 && exp.charAt(i + 1) >= '0' && exp.charAt(i + 1) <= '9') {
            i++;
            //System.out.println(c);
            c = exp.charAt(i);
          }
          else {
            //System.out.println("i = " + i);
            break;
          }
        }
        //System.out.println("broken");
        operands.add(numValue);
        numOperands++;
      }
      // else, we have an operator
      else {
        //System.out.println(c);
        operators.add(c);
        numOperators++;
      }
      
      // at the end of each iteration through, check to see if we can do some addition/subtraction
      if (operands.size() >= 2 && operators.size() >= 1) {
        // Getting the numbers to operate
        int num2 = operands.remove(numOperands - 1);
        numOperands--;
        int num1 = operands.remove(numOperands - 1);
        numOperands--;
        
        // Get the operation
        char operation = operators.remove(numOperators - 1);
        numOperators--;
        
        // Preparing to add/subtract, depending on the char operation
        int result = 0;
        if (operation == '+') {
          result = num1 + num2;
          //System.out.println(result);
        }
        else { // operation == '-'
          result = num1 - num2;
        }
        
        operands.add(result);
        numOperands++;
      }
      //System.out.println(operators.toString());
      //System.out.println(operands.toString());
      
    }
    
    return operands.get(0);
  }
}

/*
You are building an educational website and want to create a simple calculator for students to use. For now, the calculator will only allow addition and subtraction of positive integers.

Given an expression string using the "+" and "-" operators like "5+16-2", write a function to parse the string and evaluate the result.

Sample input/output:
"6+9-12" => 3
"1+2-3+4-5+6-7" => -2
*/
