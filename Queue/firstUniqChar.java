class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        FirstUniqChar solution = new FirstUniqChar();
        String input = "leetcode";
        int result = solution.firstUniqChar(input);
        System.out.println("Index of first unique character: " + result); // Output: 0
    }
}
