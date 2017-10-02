package net.rayxiao;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 * <p>
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] tokens1 = {"2", "1", "+", "3", "*"};
        String[] tokens2 = {"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(tokens1));
        System.out.println(evalRPN(tokens2));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (st.empty()) {
                st.push(Integer.valueOf(tokens[i]));
            } else {
                if ("+".equals(tokens[i])) {
                    if (st.size() < 2) {
                        throw new RuntimeException("invalid operation:" + tokens[i]);
                    }
                    st.push(st.pop() + st.pop());
                } else if ("-".equals(tokens[i])) {
                    if (st.size() < 2) {
                        throw new RuntimeException("invalid operation:" + tokens[i]);
                    }
                    st.push(st.pop() - st.pop());

                } else if ("/".equals(tokens[i])) {
                    if (st.size() < 2) {
                        throw new RuntimeException("invalid operation:" + tokens[i]);
                    }
                    int t = st.pop();
                    st.push(st.pop()/t);
                } else if ("*".equals(tokens[i])) {
                    if (st.size() < 2) {
                        throw new RuntimeException("invalid operation:" + tokens[i]);
                    }
                    st.push(st.pop() * st.pop());
                }else{
                    st.push(Integer.valueOf(tokens[i]));

                }
            }
        }
        return st.pop();
    }

}

