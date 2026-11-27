class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            char c = token.charAt(0);
            if (Character.isDigit(c) || (c == '-' && token.length() > 1)) {
                stack.push(Integer.parseInt(token));
            } else {
                int second = stack.pop();
                int first = stack.pop();

                switch (token) {
                    case "+" -> stack.push(first + second);
                    case "-" -> stack.push(first - second);
                    case "*" -> stack.push(first * second);
                    case "/" -> stack.push(first / second);
                }
            }
        }

        return stack.pop();
    }
}
