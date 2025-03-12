package ca.bytetube._00_leetcode.stack;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 * @author dall.
 */
public class IsValid {

    public boolean isValid(String s) {
        Stack<Character> stack= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //1. When you meet the left character, push the left character into the stack
            if (c == '('|| c == '[' || c == '{') {
                stack.push(c);
            }else {//right brackets
                //If the stack is empty, the brackets are invalid
                if (stack.isEmpty()) return false;
                //If the stack is not empty, pop the top character of the stack to match the right character
                char left = stack.pop();
                //If the left and right characters do not match, the brackets are invalid
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
                //If the left and right characters match, continue scanning the next character
            }
        }
        //After all characters are scanned
        //The stack is empty, indicating that the brackets are valid
        return stack.isEmpty();
    }


    public boolean isValid1(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
        }

        return s.isEmpty();
    }
}
