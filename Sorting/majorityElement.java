import java.util.HashMap;

public class majorityElement {
    public int findMajority(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int res = 0;
        int majority = 0;

        for (int n : nums) {
            hash.put(n, 1 + hash.getOrDefault(n, 0));
            if (hash.get(n) > majority) {
                res = n;
                majority = hash.get(n);
            }
        }

        return res;
    }

    // Main method for testing
    public static void main(String[] args) {
        majorityElement obj = new majorityElement();
        int[] input = {2, 2, 1, 1, 1, 2, 2};
        int result = obj.findMajority(input);

        System.out.println("The majority element is: " + result);
    }
}
