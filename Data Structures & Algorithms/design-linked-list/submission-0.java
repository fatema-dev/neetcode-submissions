class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    int length;

    public MyLinkedList() {
        this.head = new Node(0);
        length = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= length) {
            return -1;
        }

        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        length++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        Node tail = head.next;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = newNode;
        length++;
    }

    public void addAtIndex(int index, int val) {
        if (index > length || index < 0) {
            return;
        }
        Node newNode = new Node(val);
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        length++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= length) {
            return;
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        length--;
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