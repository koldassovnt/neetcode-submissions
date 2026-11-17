class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;

        for (String op : operations) {
            if ("+".equals(op)) {
                Integer top  = stack.pop();
                Integer newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                total += newTop;
            } else if ("C".equals(op)) {
                total -= stack.pop();
            } else if ("D".equals(op)) {
                Integer newScore = stack.peek() * 2;
                stack.push(newScore);
                total += newScore;
            } else {
                int val = Integer.parseInt(op);
                stack.push(val);
                total += val;
            }
        }

        return total;
    }
}