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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode (val);
        //edge case if root is empty
        if (root == null){
            root = node;
            return node;
        }
        TreeNode curr = root;
        TreeNode parent = root;
        while (curr != null){
            parent = curr;
            if (val > curr.val){
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        if (val > parent.val){
            parent.right = node;
        } else {
            parent.left = node;
        }
        return root;
    }
}