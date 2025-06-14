import java.util.Arrays;

public class MaximumUnitsOnTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort by units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;
        for (int[] box : boxTypes) {
            int count = Math.min(box[0], truckSize);
            totalUnits += count * box[1];
            truckSize -= count;
            if (truckSize == 0) return totalUnits;
        }

        return totalUnits;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        MaximumUnitsOnTruck solution = new MaximumUnitsOnTruck();
        int[][] boxTypes = {{1, 3}, {2, 2}, {3, 1}};
        int truckSize = 4;
        System.out.println("Maximum Units: " + solution.maximumUnits(boxTypes, truckSize));
    }
}
