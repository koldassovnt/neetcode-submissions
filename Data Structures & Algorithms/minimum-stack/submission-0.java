class MinStack {

    private int[] stack = new int[10];
    private int topId = 0;
    private int[] minStack = new int[10];
    private int minId = 0;

    public MinStack() {
    }
    
    public void push(int val) {
        stack[topId] = val;
        calculateMinStack();

        topId++;
        if (topId == stack.length) {
            stack = incriseStackSizeAndGet(stack);
        }
    }

    private int[] incriseStackSizeAndGet(int[] old) {
        int[] newStack = new int[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            newStack[i] = old[i];
        }
        return newStack;
    }

    private void calculateMinStack() {
        if (minId == 0 && topId == 0) {
            minStack[minId] = stack[topId];
        } else {
            if (minStack[minId - 1] > stack[topId]) {
                minStack[minId] = stack[topId];
            } else {
                minStack[minId] = minStack[minId - 1];
            }
        }
        minId++;
        if (minId == minStack.length) {
            minStack = incriseStackSizeAndGet(minStack);
        }
    }
    
    public void pop() {
        minId--;
        topId--;
    }
    
    public int top() {
        return stack[topId - 1];
    }
    
    public int getMin() {
        return minStack[minId - 1];
    }

}