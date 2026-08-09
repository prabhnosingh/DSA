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

    //Re-solving on 08 Aug 2026

    //intuition 2: DFS (without global var)
        //smaller problem:
            //find the maximum downward path sum from each child that can be extended
                //through the current node to its parent
        //at each node we have two options:
            //either to split and have total sum as root.val + leftMax + rightMax
                //and use this value to update the max in an array
            //or, to not to split and have total sum as root.val + max(leftMax, rightMax)
                //this will be the value that we return to the parent node 
            //if leftMax or rightMax are negatives then we simply consider them as
                //zeros as we don't want to decrease the sum

        //TC: O(n) : where n is the total number of nodes in the tree
        //SC: O(h) : where h is the height of the tree
    // private int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        
        int[] maxPathSum = new int[1];
        maxPathSum[0] = Integer.MIN_VALUE;
        treeTraversal(root, maxPathSum);
        return maxPathSum[0];
    }

    private int treeTraversal(TreeNode root, int[] maxPathSum){
        
        if(root == null) return 0;

        int leftMaxSum = Math.max(0, treeTraversal(root.left, maxPathSum));
        int rightMaxSum = Math.max(0, treeTraversal(root.right, maxPathSum));

        //split scenario
        maxPathSum[0] = Math.max(maxPathSum[0], root.val + leftMaxSum + rightMaxSum);

        //return value to the parent
        return root.val + Math.max(leftMaxSum, rightMaxSum);

    }  




////////////////////////////////////////////////////////////////////////////////////////////////////// 
    // //intuition 1: DFS
    //     //smaller problem:
    //         //find the maximum downward path sum from each child that can be extended
    //             //through the current node to its parent 
    //     //at each node we have two options:
    //         //either to split and have total sum as root.val + leftMax + rightMax
    //             //and use this value to update the global max
    //         //or, to not to split and have total sum as root.val + max(leftMax, rightMax)
    //             //this will be the value that we return to the parent node 
    //         //if leftMax or rightMax are negatives then we simply consider them as
    //             //zeros as we don't want to decrease the sum

    //     //TC: O(n) : where n is the total number of nodes in the tree
    //     //SC: O(h) : where h is the height of the tree
    // private int maxPathSum = Integer.MIN_VALUE;
    // public int maxPathSum(TreeNode root) {
    
    //     int rootSum = treeTraversal(root);
    //     // maxPathSum = Math.max(maxPathSum, rootSum);

    //     return maxPathSum;
    // }

    // private int treeTraversal(TreeNode root){
        
    //     if(root == null) return 0;

    //     int leftMaxSum = Math.max(0, treeTraversal(root.left));
    //     int rightMaxSum = Math.max(0, treeTraversal(root.right));

    //     //split scenario
    //     maxPathSum = Math.max(maxPathSum, root.val + leftMaxSum + rightMaxSum);

    //     //return value to the parent (can be extended upward)
    //     return root.val + Math.max(leftMaxSum, rightMaxSum);

    // }   

}