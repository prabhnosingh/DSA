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
    
    public boolean isValidBST(TreeNode root) {
        
        // if((root.val == Integer.MAX_VALUE || root.val == Integer.MIN_VALUE) && root.right == null && root.left == null) return true;        

        return verify(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

           public boolean verify(TreeNode root, long leftBoundary, long rightBoundary){
            
            if(root == null){
                return true;
            }
            // if(root.left != null && root.left.val == root.val) return false;
            // if(root.right != null && root.right.val == root.val) return false;


            // if(root.val == leftBoundary || root.val == rightBoundary) return false;
            // if(root.val == Integer.MIN_VALUE) return true;

            if(!(leftBoundary < root.val && root.val < rightBoundary)){
                return false;
            }

            boolean isLeftGood = verify(root.left, leftBoundary, root.val);
            boolean isRightGood = verify(root.right, root.val, rightBoundary);
            return isLeftGood && isRightGood;
        }
}