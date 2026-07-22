class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Double.compare(euclidean(a), euclidean(b)));
        int[][] res = new int[k][2];
        for(int[] cord : points){
            pq.offer(cord);
        }

        int i=0;
        while(i < k){
            res[i] = pq.poll();
            i++;
        }
        return res;
    }

    public double euclidean (int[] cord){
        return (double) Math.sqrt((cord[0]*cord[0]) + (cord[1]*cord[1]));
    }

}
