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

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root == null) return 0;
        height(root);
        return ans;

    }

    public int height(TreeNode root){
        if(root == null) return -1;

        int L = height(root.left);
        int R = height(root.right);

        ans = Math.max(ans, L + R + 2); // ans signifies diameter

        return 1 + Math.max(L, R);

    }
//****************************************************************************************** */  
        //recursive solution(beats 6%)
    //     if(root == null) return 0;

    //     int lhs = diameterOfBinaryTree(root.left);
    //     int rhs = diameterOfBinaryTree(root.right);

    //     return Math.max(height(root.left) + height(root.right) + 2, Math.max(lhs, rhs));


    // }

    // public int height(TreeNode root){
    //     if(root == null) return -1;

    //     int lhs = height(root.left);
    //     int rhs = height(root.right);

    //     return Math.max(lhs, rhs) + 1;

    // }
}