package com.leetcode.solution.topic.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Calculator2_227 {

//    public int calculate(String s) {
//        ArrayList<Character> ops = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
//        Stack<Integer> stack = new Stack<>();
//        Stack<Character> op = new Stack<>();
//        StringBuilder str = new StringBuilder();
//        boolean hasNum = false;
//        for (int i = s.length()-1; i >=0; i--) {
//            char current = s.charAt(i);
//            System.out.println("val of I  = " + i + "val is = " + current);
//            if (hasNum && ops.contains(current)) {
//                stack.push(Integer.valueOf(str.reverse().toString()));
//                hasNum = false;
//                str.delete(0, str.length());
////                System.out.println(ops.indexOf(current) + " " + current + " i = " + i);
//
//                if (!op.isEmpty() && ((ops.indexOf(op.peek()) < 2 && ops.indexOf(current) < 2) ||
//                        (ops.indexOf(op.peek()) > 1 && ops.indexOf(current) > 1) ||
//                        ops.indexOf(op.peek()) > ops.indexOf(current))) {
//                    int val = calculator(stack.pop(), stack.pop(), op.pop());
//                    stack.push(val);
//                    op.push(current);
//                } else op.push(current);
//            } else {
//                hasNum = true;
//                if (current != ' ')
//                    str.append(current);
//                if (i == s.length() - 1) {
//                    stack.push(Integer.valueOf(str.toString()));
//                }
//            }
//        }
//        while (!stack.isEmpty() && !op.isEmpty()) {
//            int val = calculator(stack.pop(), stack.pop(), op.pop());
//            stack.push(val);
//        }
//        return stack.peek();
//    }

    public int calculate(String s) {
        ArrayList<Character> ops = new ArrayList<>(Arrays.asList('+', '-', '*', '/'));
        Stack<Integer> stack = new Stack<>();
        Stack<Character> op = new Stack<>();
        StringBuilder str = new StringBuilder();
        boolean hasNum = false;
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            System.out.println("val of I  = " + i + "val is = " + current);
            if (hasNum && ops.contains(current)) {
                stack.push(Integer.valueOf(str.reverse().toString()));
                hasNum = false;
                str.delete(0, str.length());
//                System.out.println(ops.indexOf(current) + " " + current + " i = " + i);
                if(op.isEmpty()){
                    op.push(current);
                    continue;
                }

                if (ops.indexOf(op.peek()) > 1) {
                    int val = calculator(stack.pop(), stack.pop(), op.pop());
                    stack.push(val);
                } else if (ops.indexOf(op.peek()) == 1) {
                    int val = stack.pop();
                    stack.push(-val);
                    op.pop();
                    op.push('+');
                }
                op.push(current);
            } else {
                hasNum = true;
                if (current != ' ')
                    str.append(current);
                if (i == s.length() - 1) {
                    stack.push(Integer.valueOf(str.toString()));
                }
            }
        }
        while (!stack.isEmpty() && !op.isEmpty()) {
            int val = calculator(stack.pop(), stack.pop(), op.pop());
            stack.push(val);
        }
        return stack.peek();
    }


    public int calculator(int a, int b, char c) {
        System.out.println(a + " " + b + " " + c);
        return switch (c) {
            case '+' -> b + a;
            case '-' -> b - a;
            case '*' -> b * a;
            case '/' -> b / a;
            default -> 0;
        };
    }
}
