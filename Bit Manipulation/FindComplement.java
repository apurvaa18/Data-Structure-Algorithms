public class FindComplement {
    public int findComplement(int num) {
        if (num == 0) return 1;

        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;

        return num ^ mask;
    }

    // Optional: Main method for testing
    public static void main(String[] args) {
        FindComplement solution = new FindComplement();
        int num = 5;
        System.out.println("Complement of " + num + " is: " + solution.findComplement(num)); // Output: 2
    }
}
