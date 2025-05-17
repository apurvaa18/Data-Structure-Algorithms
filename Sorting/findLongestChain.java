// File: findLongestChain.java

import java.util.Arrays;
import java.util.Comparator;

public class findLongestChain {
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
        findLongestChain obj = new findLongestChain();
        int[][] pairs = { {1, 2}, {2, 3}, {3, 4} };
        int result = obj.findLongestChain(pairs);
        System.out.println("Length of longest chain: " + result);
        // Expected output: 2
    }
}
