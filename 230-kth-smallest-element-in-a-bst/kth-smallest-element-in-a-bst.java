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
    //intuition 1: traverse through the whole tree and add elements in a list, then sort and return the kth smallest
    //intuition 2: Use BST's properties (left < root < right) to optimize
    List<Integer> list = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        dfs(root);

        // Arrays.sort 
        return list.get(k - 1);

    }
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }
}