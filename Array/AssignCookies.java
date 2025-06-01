import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int cookie = 0;

        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }

        return child;
    }

    public static void main(String[] args) {
        int[] greed = {1, 2, 3};
        int[] cookies = {1, 1};
        int result = findContentChildren(greed, cookies);
        System.out.println("Maximum number of content children: " + result);
    }
}
