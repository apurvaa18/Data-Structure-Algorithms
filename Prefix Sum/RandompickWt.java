import java.util.*;

public class RandompickWt {

    static class Solution {
        private List<Integer> runningSums;
        private int totalSum;

        public Solution(int[] weights) {
            runningSums = new ArrayList<>();
            int runningSum = 0;
            for (int w : weights) {
                runningSum += w;
                runningSums.add(runningSum);
            }
            totalSum = runningSum;
        }

        public int pickIndex() {
            Random random = new Random();
            int target = random.nextInt(totalSum) + 1;
            int low = 0;
            int high = runningSums.size();

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (target > runningSums.get(mid)) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }

            return low;
        }
    }

    // Main method for testing the pickIndex function
    public static void main(String[] args) {
        int[] weights = {1, 3, 2, 4};
        Solution solution = new Solution(weights);

        System.out.println("Random index picks:");
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.pickIndex());
        }
    }
}
