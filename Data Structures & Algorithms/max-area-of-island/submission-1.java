//DFS Approach
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null){
            return 0;
        }

        int ROW = grid.length;
        int COL = grid[0].length;
        boolean[][] visited = new boolean[ROW][COL];
        int max = 0;

        for(int r=0; r < ROW; r++){
            for(int c=0; c < COL; c++){
                max = Math.max(max,dfs(r,c,grid,visited));
            }
        }
        return max;
    }

    public int dfs (int r, int c, int[][] grid, boolean[][] visited){
        if(r < 0 ||c < 0 || r >= grid.length || c >= grid[0].length || visited[r][c] || grid[r][c] == 0){
            return 0;
        }
        visited[r][c] = true;

        return 1 
        + dfs(r+1, c, grid, visited) 
        + dfs(r-1, c, grid, visited) 
        + dfs(r, c+1, grid, visited)
        + dfs(r, c-1, grid, visited);
}
}
