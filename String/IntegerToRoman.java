public class IntegerToRoman {
    public static void main(String[] args) {
        IntegerToRomanSolver solver = new IntegerToRomanSolver();

        // Sample input
        int num = 1994;

        String roman = solver.intToRoman(num);
        System.out.println("Integer " + num + " = Roman numeral " + roman);
    }
}

class IntegerToRomanSolver {
    public String intToRoman(int num) {
        final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        final String[] symbols = {"M", "CM", "D",  "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length && num > 0; ++i) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}
