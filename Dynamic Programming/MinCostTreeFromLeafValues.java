import java.util.Stack;

public class MinCostTreeFromLeafValues {

    public int mctFromLeafValues(int[] arr) {
        /*
         * Remove small element i and the cost is arr[i] * Math.min(arr[i-1], arr[i+1]).
         * Minimum cost happens between smaller values of i-1 and i+1.
         *
         * Use stack to maintain decreasing order. When a bigger value `num` comes,
         * pop smaller values and accumulate cost as: small * min(num, stack.peek()).
         */

        if (arr == null || arr.length < 2) return 0;

        Stack<Integer> stack = new Stack<>();
        int result = 0;

        // Use MAX_VALUE as sentinel to avoid empty stack peek
        stack.push(Integer.MAX_VALUE);

        for (int num : arr) {
            while (stack.peek() <= num) {
                int small = stack.pop();
                result += small * Math.min(stack.peek(), num);
            }
            stack.push(num);
        }

        // Final cleanup
        while (stack.size() > 2) {
            result += stack.pop() * stack.peek();
        }

        return result;
    }

    public static void main(String[] args) {
        MinCostTreeFromLeafValues solution = new MinCostTreeFromLeafValues();

        int[] arr = {6, 2, 4};
        int cost = solution.mctFromLeafValues(arr);
        System.out.println("Minimum Cost Tree from Leaf Values: " + cost); // Output: 32
    }
}
