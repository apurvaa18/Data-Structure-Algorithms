// File: Createmaxnumber.java

import java.util.Arrays;

public class Createmaxnumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int get_from_nums1 = Math.min(nums1.length, k);
        int[] ans = new int[k];

        for (int i = Math.max(k - nums2.length, 0); i <= get_from_nums1; i++) {
            int[] res1 = solve(nums1, i);
            int[] res2 = solve(nums2, k - i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;

            while (pos1 < res1.length && pos2 < res2.length) {
                if (compare(res1, pos1, res2, pos2))
                    res[tpos++] = res1[pos1++];
                else
                    res[tpos++] = res2[pos2++];
            }
            while (pos1 < res1.length)
                res[tpos++] = res1[pos1++];
            while (pos2 < res2.length)
                res[tpos++] = res2[pos2++];

            if (!compare(ans, 0, res, 0))
                ans = res;
        }

        return ans;
    }

    public boolean compare(int[] nums1, int start1, int[] nums2, int start2) {
        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
            if (nums1[start1] > nums2[start2]) return true;
            if (nums1[start1] < nums2[start2]) return false;
        }
        return start1 != nums1.length;
    }

    public int[] solve(int[] nums, int k) {
        int[] res = new int[k];
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
                len--;
            }
            if (len < k)
                res[len++] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Createmaxnumber obj = new Createmaxnumber();
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int k = 5;
        int[] result = obj.maxNumber(nums1, nums2, k);
        System.out.println("Output: " + Arrays.toString(result));
        // Expected: [9, 8, 6, 5, 3]
    }
}
