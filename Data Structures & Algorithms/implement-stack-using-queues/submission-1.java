class MyStack {

    private final Queue<Integer> primaryQueue;
    private final Queue<Integer> secondaryQueue;

    public MyStack() {
        primaryQueue = new LinkedList<>();
        secondaryQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        if (!primaryQueue.isEmpty()) {
            secondaryQueue.add(x);
            queueShifting(primaryQueue, secondaryQueue);
        } else {
            primaryQueue.add(x);
            queueShifting(secondaryQueue, primaryQueue);
        }
    }

    private void queueShifting(Queue<Integer> from, Queue<Integer> to) {
        while(!from.isEmpty()) {
            to.add(from.poll());
        }
    }
    
    public int pop() {
        return !primaryQueue.isEmpty() ? primaryQueue.poll() : secondaryQueue.poll();
    }
    
    public int top() {
        return !primaryQueue.isEmpty() ? primaryQueue.peek() : secondaryQueue.peek();
    }
    
    public boolean empty() {
        return primaryQueue.isEmpty() && secondaryQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */