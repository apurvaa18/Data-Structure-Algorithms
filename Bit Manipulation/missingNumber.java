// File: missingNumber.java

public class missingNumber {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        missingNumber obj = new missingNumber();
        int[] nums = {3, 0, 1};
        int result = obj.missingNumber(nums);
        System.out.println("Missing number is: " + result);
        // Expected output: 2
    }
}

