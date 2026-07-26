class Solution {
    int[] adjx = {1,-1,0,0};
    int[] adjy = {0,0,1,-1};
    
    public int numIslands(char[][] grid) {
        if(grid == null){
            return 0;
        }

        int islands = 0;
        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        
        for(int r=0; r <ROW; r++){
            for(int c=0; c< COL; c++){
                if(grid[r][c] == '1' && !visited[r][c]){
                    bfs(r,c,visited,grid);
                    islands++;
                }
            }
        }

        return islands;
    }

    public void bfs(int row, int col, boolean[][]visited, char[][] grid){
        Queue<int[]> q = new LinkedList<>();
        visited[row][col] = true;
        q.offer(new int[]{row, col});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for(int i=0; i < 4; i++){
                int adjr = r + adjx[i];
                int adjc = c + adjy[i];

                if(isValid(adjr, adjc, visited) && grid[adjr][adjc] == '1' && !visited[adjr][adjc]){
                    q.offer(new int[]{adjr, adjc});
                    visited[adjr][adjc] = true;
                }
            }
        }
    }

    public boolean isValid(int row, int col, boolean[][] visited){
        if(row < 0 || col < 0 || row >= visited.length || col >= visited[0].length || visited[row][col]){
            return false;
        }
        return true;
    }
    
}
