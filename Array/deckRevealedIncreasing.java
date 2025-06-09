import java.util.*;

public class deckRevealedIncreasing {

    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck); // Sort the deck in increasing order

        int n = deck.length;
        int[] result = new int[n];
        Deque<Integer> indices = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            indices.add(i); // Initialize deque with indices 0 to n-1
        }

        for (int card : deck) {
            int idx = indices.poll(); // Get the next available index
            result[idx] = card; // Place the card in result
            if (!indices.isEmpty()) {
                indices.add(indices.poll()); // Move front index to end
            }
        }

        return result;
    }

    // Main method for testing
    public static void main(String[] args) {
        int[] input = {17, 13, 11, 2, 3, 5, 7};
        int[] output = deckRevealedIncreasing(input);
        System.out.println("Revealed Deck Order: " + Arrays.toString(output));
        // Expected Output: [2, 13, 3, 11, 5, 17, 7]
    }
}
