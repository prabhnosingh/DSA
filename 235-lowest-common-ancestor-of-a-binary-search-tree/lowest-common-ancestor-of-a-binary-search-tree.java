/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // if(p == root || q == root){
        //     return root;
        // }

        // else if((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)){
        //     return root;
        // }

        // else if(p.val < root.val && q.val < root.val){
        //     return lowestCommonAncestor(root.left, p, q);
        // }
        // else if(p.val > root.val && q.val > root.val){
        //     return lowestCommonAncestor(root.right, p, q);
        // }
        // return null;
              
        // Recursive solution
        // if(p.val < root.val && q.val < root.val){
        //     return lowestCommonAncestor(root.left, p, q);
        // }
        // else if(p.val > root.val && q.val > root.val){
        //     return lowestCommonAncestor(root.right, p, q);
        // }
        // else{
        //     return root;
        // }

        // Iterative solution

        TreeNode cur = root;
        while(cur != null){

            if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            }
            else if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            }
            else{
                return cur;
            }
            
        }
        return null;

    }
}