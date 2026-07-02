class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lastColumn = matrix[0].length-1;
        for(int row=0; row <matrix.length; row++){
            if(matrix[row][lastColumn] == target){
                return true;
            } else if (matrix[row][lastColumn] > target){
                while (lastColumn >= 0){
                    if(matrix[row][lastColumn] == target){
                        return true;
                    } else {
                        lastColumn--;
                        continue;
                    }
                }
                break;
            } else {
                continue;
            }
        }
        return false;
    }
}
