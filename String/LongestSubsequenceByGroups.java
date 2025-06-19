import java.util.ArrayList;
import java.util.List;

public class LongestSubsequenceByGroups {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> result = new ArrayList<>();
        int lastGroup = -1;

        for (int i = 0; i < words.length; i++) {
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LongestSubsequenceByGroups solution = new LongestSubsequenceByGroups();

        String[] words = {"a", "b", "c", "d", "e"};
        int[] groups = {1, 1, 2, 2, 3};

        List<String> result = solution.getLongestSubsequence(words, groups);
        System.out.println("Longest Subsequence: " + result); // Output: [a, c, e]
    }
}
