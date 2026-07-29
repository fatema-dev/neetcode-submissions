class Solution {
    public record Point(int x, int y) {}
    public record Step(int row, int col, int length) {}
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        Queue<Step> q = new LinkedList<>();
        q.offer(new Step(0,0,1));
        HashSet<Point> hs = new HashSet<>();
        hs.add(new Point(0,0));
        int[][] directions = {
            {1,0}, {-1,0}, {0,1}, {0,-1}, 
            {1,1}, {1,-1},{-1,1}, {-1,-1}
            };

        while (!q.isEmpty()){
            Step curr = q.poll();
            int r = curr.row;
            int c = curr.col;
            int len = curr.length;

            if(r < 0 || c < 0 || r >= N || c >= N || grid[r][c] == 1){
                continue;
            }
            if(r == N -1 && c== N-1){
                return len;
            }
            for(int[] dir : directions){
                if(!hs.contains(new Point(r+dir[0], c+dir[1]))){
                    hs.add(new Point(r+dir[0], c+dir[1]));
                    q.offer(new Step(r+dir[0], c+dir[1], len + 1));
                }
            }

        } 
        return -1;
    }
}