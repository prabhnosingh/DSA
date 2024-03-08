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
    int ans = 1;
    public boolean isBalanced(TreeNode root) {
        
        if(root == null) return true;
        height(root);
        return ans == 0 ? false : true;
    }

    public int height(TreeNode root){
        
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if(Math.abs(leftHeight - rightHeight) > 1){
           ans = 0;
           return ans; 
        }
        int h = 1 + Math.max(leftHeight, rightHeight);
        return h;     
    }
}