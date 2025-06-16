import java.util.Arrays;

public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] array = new String[nums.length];

        // Convert all integers to strings
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator
        Arrays.sort(array, (a, b) -> (b + a).compareTo(a + b));

        // Handle edge case where all are zeros
        if (array[0].equals("0")) {
            return "0";
        }

        // Build the largest number
        StringBuilder largest = new StringBuilder();
        for (String str : array) {
            largest.append(str);
        }

        return largest.toString();
    }

    // Optional main method for testing
    public static void main(String[] args) {
        LargestNumber solution = new LargestNumber();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println("Largest Number: " + solution.largestNumber(nums)); // Output: 9534330
    }
}
