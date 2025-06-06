import java.util.Stack;
import java.util.Map;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (char c : s.toCharArray()) {
            if (mapping.containsValue(c)) {
                stack.push(c);
            } else if (mapping.containsKey(c)) {
                if (stack.isEmpty() || mapping.get(c) != stack.pop()) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();
        System.out.println(solution.isValid("()[]{}"));  // true
        System.out.println(solution.isValid("([)]"));    // false
        System.out.println(solution.isValid("{[]}"));    // true
    }
}
