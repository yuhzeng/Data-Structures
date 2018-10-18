/** PostToInfix_Expo.java
 *  Convert a postfix expression into an infix expression, including exponential operation.
 *  Author: Yuhan Zeng (yuhzeng)
 *  Assignment: C343 Homework2
 */

import java.util.Stack;

public class PostToInfix_Expo {
    public static String PostToInfix_Expo(String str) {
        Stack<String> stack = new Stack<String>(); // Construct a new stack for storing the operands.
        String[] strArray = str.split(" "); // Convert the infix string to a string array.
        String op = new String(); // String op is used to represent the current operand.
        String operand1, operand2 = new String();
        String tempStr = new String();

        for (int i = 0; i < strArray.length; i++) {
            op = strArray[i];
            if (op.equals("(") || op.equals(")") || op.equals("+") ||
                    op.equals("-") || op.equals("*") || op.equals("/")
                    || op.equals("^")) { // If an operator, pop the top two operands, and make up a parentheses string.
                operand1 = stack.pop();
                operand2 = stack.pop();
                tempStr = "(" + operand2 + op + operand1 + ")";
                stack.push(tempStr);
            }
            else { // If an operand is seen, push it to stack.
                stack.push(op);
            }
        }

        // When the input postfix string is all evaluated, pop the stack to empty.
        return stack.pop();
    }

    // Several infix to postfix cases are tested in main().
    public static void main (String[] args) {
        String poStr1 = "3 5 1 ^ + 6 * 4 2 / +";
        String inStr1 = PostToInfix_Expo(poStr1);
        System.out.println(inStr1);

        String poStr2 = "5 9 * 3 2 + 4 ^ / 6 1.5 / -";
        String inStr2 = PostToInfix_Expo(poStr2);
        System.out.println(inStr2);
    }
}