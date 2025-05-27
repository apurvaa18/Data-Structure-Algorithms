public class ReverseWords {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder res = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            res.append(words[i]);
            if (i != 0) {
                res.append(" ");
            }
        }

        return res.toString();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        String input = "  the sky   is blue ";
        System.out.println(reverseWords(input));  // Output: "blue is sky the"
    }
}
