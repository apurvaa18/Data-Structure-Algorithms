import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {

    public String longestNiceSubstring(String s) {
        int[] sub = longestNiceSubstring(s, 0, s.length());
        return s.substring(sub[0], sub[1]);
    }

    private int[] longestNiceSubstring(String s, int left, int right) {
        Set<Character> charSet = getCharSet(s, left, right);

        for (int i = left; i < right; i++) {
            char c = s.charAt(i);
            if (!charSet.contains(Character.toLowerCase(c)) || !charSet.contains(Character.toUpperCase(c))) {
                int[] prefix = longestNiceSubstring(s, left, i);
                int[] suffix = longestNiceSubstring(s, i + 1, right);
                return (prefix[1] - prefix[0] >= suffix[1] - suffix[0]) ? prefix : suffix;
            }
        }

        return new int[]{left, right};
    }

    private Set<Character> getCharSet(String s, int left, int right) {
        Set<Character> charSet = new HashSet<>();
        for (int i = left; i < right; i++) {
            charSet.add(s.charAt(i));
        }
        return charSet;
    }

    public static void main(String[] args) {
        LongestNiceSubstring solution = new LongestNiceSubstring();
        String input = "YazaAay";
        String result = solution.longestNiceSubstring(input);
        System.out.println("Longest Nice Substring: " + result); // Expected: "aAa"
    }
}
