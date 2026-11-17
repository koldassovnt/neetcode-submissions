class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int total = 0;

        for (String op : operations) {
            if ("+".equals(op)) {
                int top  = stack.pop();
                int newTop = top + stack.peek();
                stack.push(top);
                stack.push(newTop);
                total += newTop;
            } else if ("C".equals(op)) {
                total -= stack.pop();
            } else if ("D".equals(op)) {
                int newScore = stack.peek() * 2;
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