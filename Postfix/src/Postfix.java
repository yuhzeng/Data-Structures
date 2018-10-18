/** Postfix.java
 *  Evaluate a postfix expression.
 *  Author: Yuhan Zeng (yuhzeng)
 *  Assignment: C343 Homework2
 */

import java.util.Scanner;
import java.util.Stack;

public class Postfix{
    public static double PostFix(String str) {
        Scanner scanner = new Scanner(str); // Convert the input string expression into a Scanner.
        Stack<Double> stack = new Stack<Double>(); // Construct a new stack for storing the operands.
        double result = 0; // Used to store the temporary result of each operation.
        double num1, num2 = 0; // Used to store the two operands of each operation.

        while (scanner.hasNext()) {
            if (scanner.hasNextDouble())
                stack.push(scanner.nextDouble()); // Push the next double to stack.
            else { // If the next token is not a double number, but an operator.
                num1 = stack.pop();
                num2 = stack.pop(); // Pop the first two operands from stack.
                switch (scanner.next()) {
                    case "+":
                        result = num2 + num1;
                        break;
                    case "-":
                        result = num2 - num1;
                        break;
                    case "*":
                        result = num2 * num1;
                        break;
                    case "/":
                        result = num2 / num1;
                        break;
                }
                stack.push(result); // Push the result back to stack.
            }
        }
        return stack.pop(); // Return the final result of the expression.
    }

    // main function used to test the postfix evaluation.
    public static void main(String[] args) {
            String str1 = "2 3 + 6 * 10 -";
            String str2 = "1.5 3 - 10 * 2 5 / +";
            System.out.println("Postfix evaluation of str1 should be 20.0: " + PostFix(str1));
            System.out.println("Postfix evaluation of str1 should be -14.6: " + PostFix(str2));
    }
}


