package aa.tulybaev;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkPolinom(new char[]{'[', '[', '}', ']'}));
        System.out.println(checkPolinom(new char[]{'[', ')', '}', ']'}));
        System.out.println(checkPolinom(new char[]{'{', '{', '}', '}'}));
        System.out.println(checkPolinom(new char[]{'[', ']', '[', ']'}));
    }

    public static boolean checkPolinom(char[] arr) {
        Stack stack = new Stack();
        if (arr.length % 2 == 1) return false;
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (arr[i] == '}') {
                if (stack.getLast().equals('{')) {
                    continue;
                }
                else {
                    return false;
                }
            }
            if (arr[i] == ']') {
                if (stack.getLast().equals('[')) {
                    continue;
                }
                else {
                    return false;
                }
            }
            if (arr[i] == ')') {
                if (stack.getLast().equals('(')) {
                    continue;
                }
                else {
                    return false;
                }
            }
            stack.push(arr[i]);
        }
        return true;
    }
}