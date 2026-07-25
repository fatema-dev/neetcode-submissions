class Solution {
    static int[] adjx = {0, 0, 1, -1};
    static int[] adjy = {1, -1, 0, 0};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (color == image[sr][sc])
            return image;
        int ROW = image.length;
        int COL = image[0].length;

        boolean[][] vis = new boolean[ROW][COL];
        int startColor = image[sr][sc];

        dfs(sr, sc, startColor, color, image, vis);

        return image;
    }

    private void dfs(int row, int col, int startColor, int color, int[][] image, boolean[][] vis) { 
        //always check boundaries before reading
        if (!isValid(row, col, vis)) {
            return;
        }

        if(image[row][col] != startColor){
            return;
        }  

        if(image[row][col] == startColor){
            image[row][col] = color;
            vis[row][col] = true;
        }

        for (int i = 0; i < 4; i++) {
            dfs(row + adjx[i], col + adjy[i], startColor, color, image, vis);
        }
    }

    private boolean isValid(int row, int col, boolean[][] vis) {
        if (row < 0 || col < 0 || row >= vis.length || col >= vis[0].length) {
            return false;
        }
        if (vis[row][col]) {
            return false;
        }
        return true;
    }
}
