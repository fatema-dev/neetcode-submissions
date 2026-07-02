class BrowserHistory {
    private Deque<String> backHistory;
    private Deque<String> forwardHistory;

    public BrowserHistory(String homepage) {
        this.backHistory = new ArrayDeque<>();
        this.forwardHistory = new ArrayDeque<>();
        backHistory.push(homepage);
    }
    
    public void visit(String url) { 
        backHistory.push(url);
        forwardHistory = new ArrayDeque<>();
    }
    
    public String back(int steps) {
      while(steps > 0 && backHistory.size() > 1){
            forwardHistory.push(backHistory.pop());
            steps--;
      }
        return backHistory.peek();
    }
    
    public String forward(int steps) {
        while (steps > 0 && !forwardHistory.isEmpty()){
            backHistory.push(forwardHistory.pop());
            steps--;
        }
        return backHistory.peek();
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */