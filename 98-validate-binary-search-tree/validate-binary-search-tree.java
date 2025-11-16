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

    // //Re-solving on 16 Nov 2025:

    //intuition 1 (dfs): Have a helper function that takes max and min values 
    //Check if left ST's any element is not greater than the max of root
    //Check if right ST's any element is not smaller than the min of root  
    
    public boolean isValidBST(TreeNode root) {  
        return traverseBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        // return traverseBST(root, Integer.MIN_VALUE - 1, Integer.MAX_VALUE + 1); //+1/-1 to consider the case where both root
        //node and left/right node could be same boundary values for integers
    }

    private boolean traverseBST(TreeNode root, long minVal, long maxVal){
        if(root == null){
            return true;
        }   

        
        if(root.val <= minVal) return false;
            // System.out.println(root.val);
        if(root.val >= maxVal) return false;
        
        
        // if(root.left != null){  
        //     if(root.val <= root.left.val){
        //         return false;
        //     }
        // }
        // if(root.right != null){
        //     if(root.val >= root.right.val){
        //         return false;
        //     }
        // }

        boolean isLSTBST = traverseBST(root.left, minVal, root.val);
        boolean isRSTBST = traverseBST(root.right, root.val, maxVal);

        return isLSTBST && isRSTBST;
    }
        
        










































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // // //Re-solving on 11 Nov 2025:

    // //intuition 1 (recursion Top to bottom): Use a helper function and keep track of max and min for each node.
    // //Pass max/min for each node depending on the root being traversed (left or right).
    //     //root.left should be smaller than root.val (max for left child)  
    //     //root.right should be greater than root.val (min for right child)
    // //Use Long.MIN_VALUE and Long.MAX_VALUE to handle Integer.MAX/MIN_VALUE being the root node

    // //beats 100%: TC: O(n) Each node is visited once, with only constant work per node. SC: O(h)


    // //Top to bottom: You start at the root with a global range (Long.MIN_VALUE to Long.MAX_VALUE) and pass updated
    // //constraints down the tree. Each node validates itself based on its parent’s range.
    
    // public boolean isValidBST(TreeNode root) {
        
    //     return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    
    // }

    // private boolean isValidBSTHelper(TreeNode root, long min, long max){
    //     if(root == null){
    //         return true;
    //     }

    //     if(root.val >= max){ //for left child
    //         return false;
    //     }
    //     if(root.val <= min){ //for right child
    //         return false;
    //     }

    //     boolean isLeftBSTValid = isValidBSTHelper(root.left, min, root.val); //for left BST, the max value allowed is root.val
    //     boolean isRightBSTValid = isValidBSTHelper(root.right, root.val, max); //for right BST, the min value allowed is root.val

    //     return (isLeftBSTValid && isRightBSTValid);
    // }





///////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    // //Re-solving on 11 Nov 2025:

    // //intuition 1 (recursion Bottom to Top) (beats 3.21%): For a tree with 3 nodes (root, root.left, and root.right) to 
    // //be a valid BST it's children should be following the below rules:
    //     //left node should be less than root node
    //     //right node should be greater than root node
    // //But the thing is that subtrees can be valid in independence but we need to make sure that they are 
    // //valid wrt to their parent as well. -> For this, return the max (from left subtree) and min (from right subtree)
    // //of each subtree towards upwards, so that it can be compared with root node and then decided if it is valid or not.


    // //beats 3.21%: Checks max and min for each of the node: TC: O(n^2) SC: O(h)
    // //For each node, maxOfTree() and minOfTree() traverse potentially all nodes in its subtree.

    //bottom to top: You recursively compute the min and max of each subtree first (from children upward), then 
    //compare them at the parent level — hence bottom-to-top.

    // long max;
    // long min;
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }
    //     if(root.left == null && root.right == null){
    //         return true;
    //     }

    //     max = Long.MIN_VALUE;
    //     min = Long.MAX_VALUE;

    //     long leftBSTMax = maxOfTree(root.left);
    //     long rightBSTMin = minOfTree(root.right);
        
    //     if(root.val <= leftBSTMax || root.val >= rightBSTMin){
    //         return false;
    //     }
        
    //     // if(root.val != Integer.MAX_VALUE && root.val != Integer.MIN_VALUE){
    //     //     if(root.val <= leftBSTMax || root.val >= rightBSTMin){
    //     //         return false;
    //     //     }
    //     // }
    //     // else{
    //     //     if(root.val < leftBSTMax || root.val > rightBSTMin){
    //     //         return false;
    //     //     }
    //     // }
      

    //     return (isValidBST(root.left) && isValidBST(root.right));

    // }

    // private long minOfTree(TreeNode root){
    //     if(root == null){
    //         return min;
    //     }

    //     if(root.val < min){
    //         min = root.val;
    //     }

    //     return Math.min(minOfTree(root.left), minOfTree(root.right));
    // }

    // private long maxOfTree(TreeNode root){
    //     if(root == null){
    //         return max;
    //     }

    //     if(root.val > max){
    //         max = root.val;
    //     }

    //     return Math.max(maxOfTree(root.left), maxOfTree(root.right));
    // }  

































////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1 (dfs): recursively check in left and right subtrees with root
    // //being verfied at each step and if a condition is not satisfied, then return false 
    
    // // after seeing this solution: https://leetcode.com/problems/validate-binary-search-tree/solutions/5622933/video-check-range-of-each-node/
    // //intuition 2 (dfs): node.left should not be greater than its max(which is node) and node.right should not be
    // // lesser than its min(which is node)
    // public boolean isValidBST(TreeNode root) {
    //     return traverse(root, Long.MIN_VALUE, Long.MAX_VALUE);
    // }

    // public boolean traverse(TreeNode root, long min, long max){

    //     if(root == null){
    //         return true;
    //     }


    //     if(root.val >= max){ // for left child
    //         return false;
    //     } 
        
    //     if(root.val <= min){ // for right child
    //         return false;
    //     }
    //     // if(root.val > max || root.val < min){ 
    //     //if (!(root.val > minimum && root.val < maximum)) return false;
             
    //     return(traverse(root.left, min, root.val) // root.left should not be greater than root.val  
    //     && traverse(root.right, root.val, max)); // root.right should not be lesser than root.val
    // }
}