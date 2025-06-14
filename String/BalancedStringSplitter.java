public class BalancedStringSplitter {
    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') balance++;
            else if (c == 'R') balance--;
            if (balance == 0) count++;
        }
        return count;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        BalancedStringSplitter solution = new BalancedStringSplitter();
        String input = "RLRRLLRLRL";
        System.out.println("Max balanced splits: " + solution.balancedStringSplit(input)); // Output: 4
    }
}
