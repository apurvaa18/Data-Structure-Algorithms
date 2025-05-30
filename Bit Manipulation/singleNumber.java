public class singleNumber {
    public int findSingle(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        singleNumber obj = new singleNumber();
        int[] input = {4, 1, 2, 1, 2};
        int result = obj.findSingle(input);

        System.out.println("The single number is: " + result);
    }
}
