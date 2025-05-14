public class IndexFirstOccurrence {
    public int strStr(String haystack, String needle) {
        for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    // Optional: for testing the method
    public static void main(String[] args) {
        IndexFirstOccurrence solution = new IndexFirstOccurrence();
        String haystack = "hello";
        String needle = "ll";

        int result = solution.strStr(haystack, needle);
        System.out.println("First index of occurrence: " + result);
    }
}
