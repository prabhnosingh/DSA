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

    //Solving on 08 Aug 2026

    //intuition 1: DFS
        //smaller problem - find maximum path sum in left and right subtrees
        //at each node we have two options:
            //either to split and have total sum as root.val + leftMax + rightMax
                //and use this value to update the global max
                //if leftMax or rightMax are negatives then we simply consider then as
                    //zeros as we don't want to decrease the sum
            //or, to not to split and have total sum as root.val + max(leftMax, rightMax)
                //this will be the value that we return to the parent node 

            
    private int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
    
        int rootSum = treeTraversal(root);
        maxPathSum = Math.max(maxPathSum, rootSum);

        return maxPathSum;
    }

    private int treeTraversal(TreeNode root){
        
        if(root == null) return 0;

        int leftMaxSum = Math.max(0, treeTraversal(root.left));
        int rightMaxSum = Math.max(0, treeTraversal(root.right));

        //split scenario
        maxPathSum = Math.max(maxPathSum, root.val + Math.max(leftMaxSum, 0) + 
            Math.max(rightMaxSum, 0));

        //return value to the parent
        return root.val + Math.max(leftMaxSum, rightMaxSum);

    }   

}