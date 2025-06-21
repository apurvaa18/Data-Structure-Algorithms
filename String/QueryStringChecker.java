public class QueryStringChecker {

    // Convert an integer to binary string
    static String binary(int n) {
        StringBuilder s = new StringBuilder();
        while (n > 0) {
            int r = n % 2;
            s.insert(0, r);
            n = n / 2;
        }
        return s.toString();
    }

    // Check if all binary representations from 1 to n are in the string
    public boolean queryString(String s, int n) {
        for (int i = 1; i <= n; i++) {
            String str = binary(i);
            if (!s.contains(str)) return false;
        }
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        QueryStringChecker checker = new QueryStringChecker();

        String s = "0110";
        int n = 3;

        boolean result = checker.queryString(s, n);
        System.out.println("Does the string \"" + s + "\" contain all binary representations from 1 to " + n + "? " + result);
    }
}
