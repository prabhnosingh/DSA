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
    boolean ans = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {

        ans = areSame(p, q);
        if(ans == false){
            return ans;
        }
        else if(p != null && q != null){
           ans = isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        }
        return ans;
    }
    

    public boolean areSame(TreeNode rootP, TreeNode rootQ){
        
        if(rootP == null && rootQ == null) return true;
        if(rootP == null || rootQ == null) return false;

        if(rootP.val == rootQ.val){
            return true;
        }
        return false;
        // return (rootP.val == rootQ.val) ? true: false;
        
    }  

}   
