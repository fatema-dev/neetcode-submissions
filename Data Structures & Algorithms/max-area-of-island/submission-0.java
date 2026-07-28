class Solution {
    private record Point(int x, int y) {}
    private int[] adjx ={0,0,1,-1};
    private int[] adjy ={1,-1,0,0};

    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null){
            return 0;
        }
        List<Integer> cells = new ArrayList<>();
        int cell = 0;

        //in the case no island exists 
        cells.add(cell);

        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];

        for(int r=0; r<ROW; r++){
            for(int c=0; c<COL; c++){
                if(!visited[r][c] && grid[r][c] == 1){
                    cells.add(bfs(r,c,grid,visited, cell));
                }
            }
        }
        return Collections.max(cells);

    }

    public int bfs(int row, int col, int[][] grid, boolean[][] visited, int cell){
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(row,col));
        visited[row][col] = true;
        cell++;

        while(!q.isEmpty()){
            Point curr = q.poll();
            int r = curr.x();
            int c = curr.y();

            for(int i=0; i < 4; i++){
                int adjr = r + adjx[i];
                int adjc = c + adjy[i];

                if(isValid(adjr,adjc,visited) && grid[adjr][adjc] == 1){
                    q.offer(new Point(adjr,adjc));
                    visited[adjr][adjc] = true;
                    cell++;
                }
            }
        }
        return cell;
    }

    public boolean isValid(int row, int col, boolean[][] visited){
        return !(row < 0 || col < 0 || row >= visited.length || col >= visited[0].length || visited[row][col]);
    }
}
