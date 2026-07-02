class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        int removed = q1.poll();
        // q1.addAll(q2);
        // q2.clear();
        // swap the identities of the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return removed;
    }

    public int top() {
        int top = 0;
        while (!q1.isEmpty()) {
            top = q1.poll();
            q2.offer(top);
        }
        //   q1.addAll(q2);
        //   q2.clear();
        // swap the identities of the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return top;
    }

    public boolean empty() {
        return q1.isEmpty();
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