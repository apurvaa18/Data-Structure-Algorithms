// File: maxDistance.java

import java.util.*;

public class maxDistance {
    public int maxDistance(List<List<Integer>> arrays) {
        int smallest = arrays.get(0).get(0);
        int biggest = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int currentFirst = arrays.get(i).get(0);
            int currentLast = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currentLast - smallest));
            maxDistance = Math.max(maxDistance, Math.abs(biggest - currentFirst));

            smallest = Math.min(smallest, currentFirst);
            biggest = Math.max(biggest, currentLast);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        maxDistance obj = new maxDistance();
        List<List<Integer>> arrays = new ArrayList<>();
        arrays.add(Arrays.asList(1, 2, 3));
        arrays.add(Arrays.asList(4, 5));
        arrays.add(Arrays.asList(1, 2, 3));

        int result = obj.maxDistance(arrays);
        System.out.println("Maximum distance: " + result);
        // Expected output: 4 (e.g., abs(5 - 1))
    }
}

