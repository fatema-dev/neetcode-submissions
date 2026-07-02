class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for(int std : students){
            q.offer(std);
        }

        int total = students.length;
        int res = total; //assume that all have not eaten
        for (int sandwich : sandwiches){
            int cnt = 0;
            while(q.peek() != sandwich && cnt < total){
                q.offer(q.poll());
                cnt++;
            }

            if(sandwich == q.peek()){
                q.poll();
                res--;//someone ate
            } else {
                break;
            }
        }
        return res;
    }
}