class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : s.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            char lastOpener = stack.pop();
            if (ch == ']' && lastOpener != '[') {
                return false;
            }
            if (ch == ')' && lastOpener != '(') {
                return false;
            }
            if (ch == '}' && lastOpener != '{') {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
