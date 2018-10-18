/** InToPostfix.java
 *  Convert an infix expression into a postfix expression.
 *  Author: Yuhan Zeng (yuhzeng)
 *  Assignment: C343 Homework2
 */

import java.util.Stack;

public class InToPostfix {
    public static String InToPostfix(String str) {
        Stack stack = new Stack(); // Construct a new stack for storing the operators.
        String postfixStr = new String(); // Construct a new string for storing new postfix expression.
        String[] strArray = str.split(" "); // Convert the infix string to a string array.
        String op = new String(); // String op is used to represent the current operator.

        for (int i = 0; i < strArray.length; i++) {
            op = strArray[i];
            if (op.equals("(") || op.equals(")") || op.equals("+") ||
                op.equals("-") || op.equals("*") || op.equals("/")) { // If an operator, pop the stack until a lower priority is seen, and push the operator to stack.
                if (op.equals("(")) // If "(" is seen, push to stack.
                    stack.push(op);
                else if (op.equals(")")) { // If ")" is seen, pop the stack to "(".
                    while (!stack.peek().equals("(")) {
                        postfixStr += stack.pop();
                        postfixStr += " ";
                    }
                    stack.pop(); // "(" is popped but not output.
                } else if (op.equals("*") || op.equals("/")) {
                    while (!stack.isEmpty()) {
                        if (!stack.peek().equals("+") && !stack.peek().equals("-") && !stack.peek().equals("(")) {
                            postfixStr += stack.pop();
                            postfixStr += " ";
                        } else
                            break;
                    }
                    stack.push(op); // Push the operator * or / to stack.
                } else if (op.equals("+") || op.equals("-")) {
                    while (!stack.isEmpty() && !stack.peek().equals("(")) {
                        postfixStr += stack.pop();
                        postfixStr += " ";
                    }
                    stack.push(op); // Push the operator + or - to stack.
                }
            }
            else { // If an operand is seen, output it.
                postfixStr += strArray[i];
                postfixStr += " ";
            }
        }

        // When the input infix string is all evaluated, pop the stack to empty.
        while (!stack.isEmpty()) {
            postfixStr += stack.pop();
            postfixStr += " ";
        }
        return postfixStr;
    }

    // Several infix to postfix cases are tested in main().
    public static void main (String[] args) {
        String inStr1 = "( 3 + 5 ) * 6 + ( 4 / 2 )";
        String poStr1 = InToPostfix(inStr1);
        System.out.println(poStr1);

        String inStr2 = "5 * 9 / ( 3 + 2 ) - ( 6 / 1.5 )";
        String poStr2 = InToPostfix(inStr2);
        System.out.println(poStr2);
    }
}