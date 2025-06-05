public class FindErrorNums {
    public int[] findErrorNums(int[] nums) {
        int[] temp = new int[nums.length];
        int[] ans = new int[2];

        for (int num : nums) {
            temp[num - 1]++;
        }

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 2) ans[0] = i + 1; // duplicate number
            if (temp[i] == 0) ans[1] = i + 1; // missing number
        }

        return ans;
    }

    // Optional: test method
    public static void main(String[] args) {
        FindErrorNums solution = new FindErrorNums();
        int[] input = {1, 2, 2, 4};
        int[] result = solution.findErrorNums(input);
        System.out.println("Duplicate: " + result[0] + ", Missing: " + result[1]);
    }
}
