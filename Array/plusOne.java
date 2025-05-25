public class plusOne {
    public int[] addOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }

    // Main method for testing
    public static void main(String[] args) {
        plusOne obj = new plusOne();
        int[] input = {9, 9, 9};
        int[] result = obj.addOne(input);

        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num);
        }
        System.out.println();
    }
}
