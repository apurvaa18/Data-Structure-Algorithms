public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;

        // Skip trailing spaces
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }

        int start = end;
        // Count characters in the last word
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }

        return end - start;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        String input = "Hello World   ";
        System.out.println(lengthOfLastWord(input)); // Output: 5
    }
}
