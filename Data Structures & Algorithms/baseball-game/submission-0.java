class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i< operations.length; i++){
            if (operations[i].equals("+")){
                int top = stack.pop();
                int top2 = stack.peek();
                stack.push(top);
                stack.push(top+top2);
            } else if (operations[i].equals("C")){
                stack.pop();
            } else if (operations[i].equals("D")){
                stack.push(stack.peek()*2);
            } else {
                stack.push(Integer.parseInt(operations[i]));
            }
        }
        int total = 0;
        while (!stack.isEmpty()){
            total += stack.pop();
        }
        return total;
    }
}