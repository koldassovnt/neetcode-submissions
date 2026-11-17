class BrowserHistory {

    private static class ListNode {
        String url;
        ListNode next;
        ListNode prev;

        public ListNode(String url) {
            this.url = url;
        }
    }

    private final ListNode head;
    private final ListNode tail;
    private ListNode curr;

    public BrowserHistory(String homepage) {
        head = new ListNode("dummy");
        tail = new ListNode("dummy");
        curr = new ListNode(homepage);
        
        head.next = curr;
        tail.prev = curr;
        curr.prev = head;
        curr.next = tail;
    }
    
    public void visit(String url) {
        ListNode next = new ListNode(url);
        curr.next = next;
        next.prev = curr;
        next.next = tail;
        tail.prev = next;
        curr = next;

    }
    
    public String back(int steps) {
        int i = 0;
        
        while (curr != head && i < steps) {
            curr = curr.prev;
            i++;
        }

        if (curr == head) {
            curr = head.next;
        }

        return curr.url;
    }
    
    public String forward(int steps) {
        int i = 0;
        
        while (curr != tail && i < steps) {
            curr = curr.next;
            i++;
        }

        if (curr == tail) {
            curr = tail.prev;
        }

        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */