class MyStack {

    private Queue<Integer> primaryQueue;
    private Queue<Integer> secondaryQueue;

    public MyStack() {
        primaryQueue = new LinkedList<>();
        secondaryQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        secondaryQueue.add(x);
        queueShifting(primaryQueue, secondaryQueue);
        Queue<Integer> tmp = primaryQueue;
        primaryQueue = secondaryQueue;
        secondaryQueue = tmp;
    }

    private void queueShifting(Queue<Integer> from, Queue<Integer> to) {
        while(!from.isEmpty()) {
            to.add(from.poll());
        }
    }
    
    public int pop() {
        return primaryQueue.poll();
    }
    
    public int top() {
        return primaryQueue.peek();
    }
    
    public boolean empty() {
        return primaryQueue.isEmpty();
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