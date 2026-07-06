/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return isBalancedRec(root) >= 0;
    }
    private int isBalancedRec(TreeNode root){
        if (root == null){
            return 0;
        }
        int lth = isBalancedRec(root.left);
        if(lth == -1) return -1;
        int rth = isBalancedRec(root.right);
        if(rth == -1) return -1;

        if(Math.abs(lth - rth) > 1){
            return -1;
        }

        return 1 + Math.max(lth, rth);
    }
}
