import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < Math.pow(2, n); i++) {
            list.add(i ^ (i >> 1));
            // XOR operation ensures only one bit changes at each step
        }

        return list;
    }

    // Optional: main method for testing
    public static void main(String[] args) {
        GrayCode solution = new GrayCode();
        int n = 2;
        List<Integer> result = solution.grayCode(n);
        System.out.println("Gray code for n = " + n + ": " + result);  // Output: [0, 1, 3, 2]
    }
}
