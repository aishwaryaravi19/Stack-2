// Time Complexity: O(n), where n is the string length
// Space Complexity : O(n), where n is the string length
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

//Iterate over the string.
// If the character is opening braces, push the corresponding closing braces to the stack.
// If it is closing braces, peek from stack and check if it's equal.
// If it's equal, pop from the stack else return false
class ValidParenthesis {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') stack.push(')');
            else if(c == '[') stack.push(']');
            else if(c == '{') stack.push('}');
            else if(stack.isEmpty() || c != stack.peek()) return false;
            else stack.pop();
        }
        return stack.isEmpty();
    }
}