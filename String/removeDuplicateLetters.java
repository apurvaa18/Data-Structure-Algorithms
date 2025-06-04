// File: removeDuplicateLetters.java

import java.util.*;

public class removeDuplicateLetters {
    public String removeDuplicateLettersFromString(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        Stack<Character> stack = new Stack<>();
        Set<Character> visited = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (visited.contains(currentChar)) {
                continue;
            }

            while (!stack.isEmpty() && currentChar < stack.peek() &&
                    i < lastOccurrence.get(stack.peek())) {
                visited.remove(stack.pop());
            }

            visited.add(currentChar);
            stack.push(currentChar);
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        removeDuplicateLetters obj = new removeDuplicateLetters();
        String input = "cbacdcbc";
        String output = obj.removeDuplicateLettersFromString(input);
        System.out.println("Output: " + output);  // Expected: "acdb"
    }
}
