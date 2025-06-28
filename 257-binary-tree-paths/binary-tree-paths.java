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
// intuition 1: Use dfs to find leaf nodes, keep adidng root.val along the way in a string "path" and when a leaf
//node is encountered, add the "path" to "ans"
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }
    public void dfs(TreeNode root, String path){ // try with string builder
        if(root == null){
            return;
        }
        path += root.val;

        if(root.left == null && root.right == null){ // leafNode encountered
            ans.add(path);
            return;
        }
        path += "->";
        dfs(root.left, path);
        dfs(root.right, path);
    }
}