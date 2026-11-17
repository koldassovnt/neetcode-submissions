class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();

        for (String op : operations) {
            if ("+".equals(op)) {
                Integer second  = stack.pop();
                Integer first = stack.pop();
                Integer third = second + first;
                stack.push(first);
                stack.push(second);
                stack.push(third);
            } else if ("C".equals(op)) {
                stack.pop();
            } else if ("D".equals(op)) {
                Integer prev = stack.peek();
                stack.push(prev * 2);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int total = 0;
        while(!stack.isEmpty()) {
            total += stack.pop();
        }
        
        return total;
    }
}