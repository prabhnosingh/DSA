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
    // List<String> ans = new ArrayList<>();
    // public List<String> binaryTreePaths(TreeNode root) {
    //     // dfs(root, new StringBuilder());
    //     dfs(root, "");
    //     return ans;
    // }
    // public void dfs(TreeNode root, String path){ // try with string builder
    //     if(root == null){
    //         return;
    //     }
    //     path += root.val;

    //     if(root.left == null && root.right == null){ // leafNode encountered
    //         ans.add(path);
    //         return;
    //     }
    //     path += "->";
    //     dfs(root.left, path);
    //     dfs(root.right, path);
    // }

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // intuition 2 (stringbuilder): Use dfs to find leaf nodes, keep adidng root.val along the way in a stringBuilder 
    // object "path" and when a leaf node is encountered, add the "path" to "ans". Reset the path using setLength to 
    // previous length to 

    List<String> ans = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    public void dfs(TreeNode root, StringBuilder path){ // try with string builder -> this does not work as 
    // string builder object keeps adding the strings to one place only, resulting in output like this ->
    // ["1->2->5","1->2->53"]. There is a need of new string object every recursive call rather than a single object.

        if(root == null){
            return;
        }
        int len = path.length();
        path.append(root.val);

        if(root.left == null && root.right == null){ // leafNode encountered
            ans.add(path.toString());

        }
        else{
            path.append("->");
            dfs(root.left, path);
            dfs(root.right, path);
        }
        path.setLength(len); // resetting the length of path (stringBuilder) to the previous len
        //This removes the current node's value (and the "->" separator, if added) from the 
        //currentPath. This is important to avoid mixing paths when backtracking to different nodes.
        
    }
}