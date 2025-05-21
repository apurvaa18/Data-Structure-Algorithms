import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (String w : wordDict) {
                int start = i - w.length();
                if (start >= 0 && dp[start] && s.substring(start, i).equals(w)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    // Optional main method for testing
    public static void main(String[] args) {
        WordBreak solution = new WordBreak();
        List<String> wordDict = List.of("leet", "code");
        String s = "leetcode";
        boolean result = solution.wordBreak(s, wordDict);
        System.out.println("Can the word \"" + s + "\" be segmented? " + result);
    }
}

