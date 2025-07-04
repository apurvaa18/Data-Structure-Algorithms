public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];

        // Multiply digits and store results in reverse order
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }

        // Handle carries
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }

        // Build result string
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);

        // Trim leading zeros
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings solution = new MultiplyStrings();

        String num1 = "123";
        String num2 = "456";

        String result = solution.multiply(num1, num2);
        System.out.println("Product: " + result);  // Expected: 56088
    }
}
