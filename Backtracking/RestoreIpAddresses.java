import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String> ans = new ArrayList<>();
    String str;

    public List<String> restoreIpAddresses(String s) {
        str = s;
        magical("", 0, 0);
        return ans;
    }

    void magical(String path, int index, int dots) {
        if (dots > 4) return;
        if (dots == 4 && index >= str.length()) {
            ans.add(path.substring(0, path.length() - 1)); // remove trailing dot
            return;
        }

        for (int length = 1; length <= 3 && index + length <= str.length(); length++) {
            String num = str.substring(index, index + length);
            if (num.charAt(0) == '0' && length != 1) break; // no leading zeros unless single digit
            else if (Integer.parseInt(num) <= 255) {
                magical(path + num + ".", index + length, dots + 1);
            }
        }
    }

    // Optional main method for testing
    public static void main(String[] args) {
        RestoreIpAddresses solution = new RestoreIpAddresses();
        String input = "25525511135";
        List<String> result = solution.restoreIpAddresses(input);
        System.out.println(result);
    }
}
