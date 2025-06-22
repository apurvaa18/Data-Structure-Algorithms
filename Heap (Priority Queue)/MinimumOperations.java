import java.util.*;

public class MinimumOperations {

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int a : nums) {
            if (a > 0) {
                set.add(a);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        MinimumOperations solution = new MinimumOperations();

        int[] nums = {1, 5, 0, 3, 5};
        int result = solution.minimumOperations(nums);

        System.out.println("Minimum operations needed: " + result);
    }
}
