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
 // inuition 1: Have a global sum variable and use dfs helper function to find left leaf nodes and
 // add them together in sum variable.
class Solution {
    int sum = 0; 
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root, 1); // initially passing flag as 1 to cover scenarios where root only have 1 node
        return sum;
    }
    public void dfs(TreeNode root, int flag){ // flag is 0 for left and 1 for right
        if(root == null){
            return;
        }

        dfs(root.left, 0);
        if(root.left == null && root.right == null && flag == 0){ // leaf node encountered
            sum += root.val;
        } 

        dfs(root.right, 1);

    }
}