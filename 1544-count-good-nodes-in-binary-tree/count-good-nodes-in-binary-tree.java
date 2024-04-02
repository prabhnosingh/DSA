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
     

    public int goodNodes(TreeNode root) {
       int currMax = root.val;

       return dfs(root, currMax);

    }

    public int dfs(TreeNode root, int currMax){
        int res = 0;
        if(root == null){
            return 0;
        
        }

        if(root.val >= currMax){
            res ++;
            currMax = root.val;
        }

        res += dfs(root.left, currMax);
        res += dfs(root.right, currMax);
        return res;
    }
}