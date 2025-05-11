import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        GenerateParenthesisSolver solver = new GenerateParenthesisSolver();

        int n = 3; // Number of pairs of parentheses
        List<String> result = solver.generateParenthesis(n);

        System.out.println("Generated Parentheses:");
        for (String s : result) {
            System.out.println(s);
        }
    }
}

class GenerateParenthesisSolver {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, "", n, res);
        return res;
    }

    private void dfs(int openP, int closeP, String s, int n, List<String> res) {
        if (openP == closeP && openP + closeP == n * 2) {
            res.add(s);
            return;
        }

        if (openP < n) {
            dfs(openP + 1, closeP, s + "(", n, res);
        }

        if (closeP < openP) {
            dfs(openP, closeP + 1, s + ")", n, res);
        }
    }
}
