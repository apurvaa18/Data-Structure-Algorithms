public class MaxRepeating {

    public static int maxRepeating(String sequence, String word) {
        int count = 0;
        String repeated = word;
        while (sequence.contains(repeated)) {
            count++;
            repeated += word;
        }
        return count;
    }

    // Optional: main method to test the function
    public static void main(String[] args) {
        String sequence = "ababc";
        String word = "ab";
        int result = maxRepeating(sequence, word);
        System.out.println("Maximum repeating: " + result);
    }
}
