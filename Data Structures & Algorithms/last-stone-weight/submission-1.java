class Solution {
  
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int x = pq.poll();
            int y = pq.poll();

            if(x == y){continue;}
            else if (x > y){
                pq.offer(x-y);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
        //if heap is empty, return 0 
    }
}
