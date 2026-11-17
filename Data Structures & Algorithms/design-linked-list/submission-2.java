class MyLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head;
    private ListNode tail;
    private int size = 0;

    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index >= size) {
            return -1;
        }
        return getPrev(index).next.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode prev = getPrev(index);
        ListNode newNode = new ListNode(val);
        ListNode next = prev.next;

        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = next;
        next.prev = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) {
            return;
        }

        ListNode prev = getPrev(index);
        ListNode next = prev.next.next;
        prev.next = next;
        next.prev = prev;

        size--;
    }

    private ListNode getPrev(int index) {
        if (index <= size / 2) {
            ListNode curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }
            return curr;
        } else {
            ListNode curr = tail;
            for (int i = 0; i < size - index + 1; i++) {
                curr = curr.prev;
            }
            return curr;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */