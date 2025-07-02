public class FillCups {

    public int fillCups(int[] A) {
        int max = 0, sum = 0;
        for (int a : A) {
            max = Math.max(a, max);
            sum += a;
        }
        return Math.max(max, (sum + 1) / 2);
    }

    public static void main(String[] args) {
        FillCups solution = new FillCups();

        int[] A = {1, 4, 2}; // Example input
        int result = solution.fillCups(A);

        System.out.println("Minimum seconds to fill cups: " + result); // Expected: 4
    }
}
