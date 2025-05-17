// File: hIndex.java

public class hIndex {
    public int hIndex(int[] citations) {
        int papers = citations.length;
        int[] citationBuckets = new int[papers + 1];

        for (int citation : citations) {
            citationBuckets[Math.min(citation, papers)]++;
        }

        int cumulativePapers = 0;
        for (int h = papers; h >= 0; h--) {
            cumulativePapers += citationBuckets[h];
            if (cumulativePapers >= h) {
                return h;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        hIndex obj = new hIndex();
        int[] citations = {3, 0, 6, 1, 5};
        int result = obj.hIndex(citations);
        System.out.println("H-Index: " + result);
        // Expected output: 3
    }
}
