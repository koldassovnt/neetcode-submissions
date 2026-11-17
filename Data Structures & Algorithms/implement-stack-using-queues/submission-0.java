class MyStack {

    private final Queue<Integer> queue0;
    private final Queue<Integer> queue1;

    //0 - queue0, 1 - queue1
    private int primaryQueue = 0;

    public MyStack() {
        queue0 = new LinkedList<>();
        queue1 = new LinkedList<>();
    }
    
    public void push(int x) {
        if (primaryQueue == 0) {
            queue1.add(x);
            queueShifting(queue0, queue1);
            primaryQueue = 1;
        } else {
            queue0.add(x);
            queueShifting(queue1, queue0);
            primaryQueue = 0;
        }
    }

    private void queueShifting(Queue<Integer> from, Queue<Integer> to) {
        while(!from.isEmpty()) {
            to.add(from.poll());
        }
    }
    
    public int pop() {
        return primaryQueue == 0 ? queue0.poll() : queue1.poll();
    }
    
    public int top() {
        return primaryQueue == 0 ? queue0.peek() : queue1.peek();
    }
    
    public boolean empty() {
        return queue0.isEmpty() && queue1.isEmpty();
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