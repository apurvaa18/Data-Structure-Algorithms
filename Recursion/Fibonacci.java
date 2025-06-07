public class Fibonacci {
    public static int fib(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }

        return b;
    }

    public static void main(String[] args) {
        int n = 10;
        int result = fib(n);
        System.out.println("Fibonacci of " + n + " is: " + result);
    }
}
