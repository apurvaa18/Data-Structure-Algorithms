import java.util.*;

public class PyramidTransition {

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String, List<Character>> map = new HashMap<>();
        HashSet<String> invalidBottoms = new HashSet<>();

        // Build the mapping from allowed transitions
        for (String s : allowed) {
            String base = s.substring(0, 2);
            char top = s.charAt(2);
            map.computeIfAbsent(base, k -> new ArrayList<>()).add(top);
        }

        return pyramidHelper(bottom, map, invalidBottoms);
    }

    private boolean pyramidHelper(String bottom, HashMap<String, List<Character>> map, HashSet<String> invalidBottoms) {
        if (bottom.length() == 2) {
            return map.containsKey(bottom);
        }

        if (invalidBottoms.contains(bottom)) return false;

        List<String> potentialBottoms = new ArrayList<>();
        getPotentialBottoms("", bottom, 0, map, potentialBottoms);

        for (String b : potentialBottoms) {
            if (pyramidHelper(b, map, invalidBottoms)) {
                return true;
            }
        }

        invalidBottoms.add(bottom);
        return false;
    }

    private void getPotentialBottoms(String prefix, String bottom, int idx, HashMap<String, List<Character>> map, List<String> potentialBottoms) {
        if (idx == bottom.length() - 1) {
            potentialBottoms.add(prefix);
            return;
        }

        String pair = bottom.substring(idx, idx + 2);
        if (!map.containsKey(pair)) return;

        for (char c : map.get(pair)) {
            getPotentialBottoms(prefix + c, bottom, idx + 1, map, potentialBottoms);
        }
    }

    public static void main(String[] args) {
        PyramidTransition pt = new PyramidTransition();

        String bottom = "BCD";
        List<String> allowed = Arrays.asList("BCG", "CDE", "GEA", "FFF");

        boolean canBuild = pt.pyramidTransition(bottom, allowed);
        System.out.println("Can build pyramid? " + canBuild);  // Output: true or false
    }
}

