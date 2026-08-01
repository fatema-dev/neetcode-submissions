class Solution {
    private int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    private record Point (int x, int y){}
    public int orangesRotting(int[][] grid) {
        if(grid == null){
            return -1;
        }

        int ROW = grid.length;
        int COL = grid[0].length;
        int size = 0;
        Queue<Point> q = new LinkedList<>();

        for(int r=0; r < ROW; r++){
            for(int c=0; c < COL; c++){
                if(grid[r][c] == 2){
                    q.offer(new Point(r,c));
                }
                if(grid[r][c] == 1){
                    size++;
                }
            }
        }

        int min = 0;
        while(!q.isEmpty() && size > 0){
            int currSize = q.size();
            for(int i=0; i< currSize; i++){
                Point rotten = q.poll();
                int r = rotten.x;
                int c = rotten.y;
                for(int[] dir: dirs){
                     if(isValid(r+dir[0],c+dir[1],grid) && grid[r+dir[0]][c+dir[1]] == 1){
                        grid[r+dir[0]][c+dir[1]] = 2;
                        q.offer(new Point(r+dir[0], c+dir[1]));
                        size--;
                     }
                }
            }
            min++;
        }
        return (size > 0) ? -1 : min;
    }

    public boolean isValid(int r, int c, int[][] grid){
        return !(r <0 || c<0 || r >=grid.length || c >= grid[0].length);
    }
}
