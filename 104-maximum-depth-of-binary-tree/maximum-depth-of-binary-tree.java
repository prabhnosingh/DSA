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
    int depth = 1;
    public int maxDepth(TreeNode root) {
        
        //recursive DFS
        // if(root == null){
        //     return 0;
        // }

        

        // int l = maxDepth(root.left);
        // int r = maxDepth(root.right);
        // return 1 + Math.max(l, r);
//***************************************************** */

        //Iterative BFS using a Queue

        if(root == null){
            return 0;
        }
        int height = 0;
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()){

            height ++;
            int size = q.size();

            while(size-- > 0){
                TreeNode temp = q.poll();

                if(temp.left != null){
                    q.add(temp.left);
                }

                if(temp.right != null){
                    q.add(temp.right);
                }
            }

        }
        return height;
    }
}