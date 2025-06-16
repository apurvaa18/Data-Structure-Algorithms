public class KItemsWithMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= (numOnes + numZeros)) {
            return Math.min(numOnes, k);
        } else {
            int rem = k - (numOnes + numZeros);
            return numOnes - rem;
        }
    }

    // Optional: for quick testing
    public static void main(String[] args) {
        KItemsWithMaximumSum solution = new KItemsWithMaximumSum();
        int result = solution.kItemsWithMaximumSum(3, 2, 1, 4);
        System.out.println("Maximum Sum: " + result); // Output should be 3
    }
}

