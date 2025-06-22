public class DivisorGame {

    public boolean divisorGame(int n) {
        // Return true if the number is even, false otherwise.
        return n % 2 == 0;
    }

    public static void main(String[] args) {
        DivisorGame solution = new DivisorGame();

        int n = 10; // You can change this value to test with other inputs
        boolean result = solution.divisorGame(n);

        System.out.println("Can Alice win with n = " + n + "? " + result);
    }
}
