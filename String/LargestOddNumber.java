public class LargestOddNumber {

    public String largestOddNumber(String num) {
        int i = num.length() - 1;

        // Traverse from end to find the last odd digit
        while (i >= 0) {
            char ch = num.charAt(i);
            if ((ch - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
            i--;
        }

        // No odd digit found
        return "";
    }

    public static void main(String[] args) {
        LargestOddNumber solution = new LargestOddNumber();

        String input = "5243862";
        String result = solution.largestOddNumber(input);
        System.out.println("Largest Odd Number: " + result);  // Expected: "5243861" or similar depending on input
    }
}

