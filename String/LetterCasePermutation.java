import java.util.*;

public class LetterCasePermutation {

    // Helper recursive method
    void recurse(char[] str, int pos, List<String> result) {
        if (pos == str.length) {
            result.add(new String(str));
            return;
        }

        if (Character.isLetter(str[pos])) {
            // Toggle to lowercase and recurse
            str[pos] = Character.toLowerCase(str[pos]);
            recurse(str, pos + 1, result);

            // Backtrack to original uppercase and recurse
            str[pos] = Character.toUpperCase(str[pos]);
            recurse(str, pos + 1, result);
        } else {
            // If it's a digit, continue without change
            recurse(str, pos + 1, result);
        }
    }

    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        recurse(S.toCharArray(), 0, result);
        return result;
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        LetterCasePermutation obj = new LetterCasePermutation();
        String input = "a1b2";

        List<String> permutations = obj.letterCasePermutation(input);
        System.out.println("Letter Case Permutations of \"" + input + "\":");
        for (String s : permutations) {
            System.out.println(s);
        }
    }
}
