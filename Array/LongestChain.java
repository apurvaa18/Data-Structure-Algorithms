import java.util.Arrays;
import java.util.Comparator;

public class LongestChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));

        int[] prev = pairs[0];
        int res = 1;

        for (int i = 1; i < pairs.length; i++) {
            int[] cur = pairs[i];
            if (cur[0] > prev[1]) {
                res++;
                prev = cur;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        LongestChain solution = new LongestChain();

        int[][] pairs = {{1, 2}, {2, 3}, {3, 4}};
        int result = solution.findLongestChain(pairs);

        System.out.println("Longest chain length: " + result);  // Expected: 2
    }
}
