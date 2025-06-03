public class IsomorphicStrings {
    public static void main(String[] args) {
        IsomorphicStringsSolver solver = new IsomorphicStringsSolver();

        // Sample input
        String s = "egg";
        String t = "add";

        boolean result = solver.isIsomorphic(s, t);

        System.out.println("Are the strings isomorphic? " + result);
    }
}

class IsomorphicStringsSolver {
    public boolean isIsomorphic(String s, String t) {
        int[] indexS = new int[200]; // Tracks indices for characters in s
        int[] indexT = new int[200]; // Tracks indices for characters in t

        int len = s.length();

        if (len != t.length()) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false;
            }

            indexS[s.charAt(i)] = i + 1;
            indexT[t.charAt(i)] = i + 1;
        }

        return true;
    }
}
