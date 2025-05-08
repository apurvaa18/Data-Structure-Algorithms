public class MostWater {

    public static class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int left = 0;
            int right = height.length - 1;

            while (left < right) {
                maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }

            return maxArea;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {1,8,6,2,5,4,8,3,7};
        int result = solution.maxArea(height);
        System.out.println("Maximum water that can be contained: " + result);
    }
}
