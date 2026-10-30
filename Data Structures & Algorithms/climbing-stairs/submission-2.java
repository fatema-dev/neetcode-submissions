class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStairsRecursive(n, memo);
    }

    public int climbStairsRecursive(int n, int[] memo){
       if (n==0 || n==1){
        return 1;
       }

       if(memo[n] != -1){
        return memo[n];
       }

       return memo[n] = climbStairsRecursive(n-1, memo) + climbStairsRecursive(n-2, memo);
    }
}
