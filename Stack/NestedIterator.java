import java.util.*;

// Interface as provided by LeetCode or similar platforms
interface NestedInteger {
    boolean isInteger();
    Integer getInteger();
    List<NestedInteger> getList();
}

// Main implementation of NestedIterator
public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        // Initialize stack in reverse order for correct iteration
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            }
            stack.pop();
            List<NestedInteger> nestedList = top.getList();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }
        return false;
    }

    // Optional: Main method with mock implementation for testing
    public static void main(String[] args) {
        // Mock NestedInteger implementation for testing
        class NI implements NestedInteger {
            private Integer val;
            private List<NestedInteger> list;

            NI(int val) { this.val = val; }
            NI(List<NestedInteger> list) { this.list = list; }

            public boolean isInteger() { return val != null; }
            public Integer getInteger() { return val; }
            public List<NestedInteger> getList() { return list; }
        }

        List<NestedInteger> nestedList = Arrays.asList(
                new NI(Arrays.asList(new NI(1), new NI(1))),
                new NI(2),
                new NI(Arrays.asList(new NI(1), new NI(1)))
        );

        NestedIterator i = new NestedIterator(nestedList);
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        // Output: 1 1 2 1 1
    }
}
