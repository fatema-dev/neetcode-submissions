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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return root;
        }

        if (key > root.val){
            root.right = deleteNode(root.right, key);
        } else if (key < root.val){
            root.left = deleteNode(root.left, key);
        } else { // if the value we found
            if (root.left == null){//left subtree is null, return right
                return root.right;
            } else if (root.right == null){//right subtree is null, return left
                return root.left;
            }
            // find the min from right subtree
            TreeNode curr = root.right;
            while(curr.left != null){
                curr = curr.left;
            }
            root.val = curr.val;
            root.right = deleteNode(root.right, root.val);
        }

        return root;
    }
}