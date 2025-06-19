public class Maximum69Number {

    public int maximum69Number(int num) {
        int[] arr = new int[4]; // Holds digits (at most 4 digits since max num is 9999)
        int i = 0;

        // Extract digits in reverse order
        int original = num;
        while (num > 0) {
            arr[i++] = num % 10;
            num /= 10;
        }

        boolean changed = false;
        num = 0;

        // Reconstruct number from highest digit, modifying the first 6 to 9
        for (i = i - 1; i >= 0; i--) {
            if (arr[i] == 6 && !changed) {
                arr[i] = 9;
                changed = true;
            }
            num = num * 10 + arr[i];
        }

        return num;
    }

    public static void main(String[] args) {
        Maximum69Number solution = new Maximum69Number();
        int input = 9669;
        int result = solution.maximum69Number(input);
        System.out.println("Maximum 69 Number: " + result); // Expected: 9969
    }
}
