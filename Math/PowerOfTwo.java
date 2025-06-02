public class PowerOfTwo {
    public boolean isPowerOfTwo(int num) {
        for (int i = 0; i < 31; i++) {
            int ans = (int) Math.pow(2, i);
            if (ans == num) {
                return true;
            }
        }
        return false;
    }
}
