import java.util.Arrays;

public class NextPermutation {

    public void nextPermutation(int[] nums) {
        int ind1 = -1;
        int ind2 = -1;
        // Step 1: Find the breaking point
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind1 = i;
                break;
            }
        }

        // Step 2: If no breaking point, reverse the array
        if (ind1 == -1) {
            reverse(nums, 0);
        } else {
            // Step 3: Find the next greater element and swap
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] > nums[ind1]) {
                    ind2 = i;
                    break;
                }
            }

            swap(nums, ind1, ind2);

            // Step 4: Reverse the suffix starting from ind1 + 1
            reverse(nums, ind1 + 1);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();

        int[] nums = {1, 2, 3};
        System.out.println("Before: " + Arrays.toString(nums));
        np.nextPermutation(nums);
        System.out.println("After:  " + Arrays.toString(nums));
    }
}
