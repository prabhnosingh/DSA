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

    //Re-solving on 16 Nov 2025:

    //intuition 1 (recursive): Interchange the nodes of the tree by swapping them with each other
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }


        TreeNode tempNode = root.left;

        root.left = invertTree(root.right);
        root.right = invertTree(tempNode);

        return root;
    }





























//////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 15 Nov 2025:

    // //intuition 1 (recursive): Interchange the left node of each root with right node of that node.
    // public TreeNode invertTree(TreeNode root) {
    //     //base case
    //     if(root == null){
    //         return null;
    //     }

    //     // if(root.left == null && root.right == null){ //leaf node
    //     //     return root;
    //     // }
        
    //     TreeNode tempNode = root.left;
        
    //     //hypothesis
    //     root.left = invertTree(root.right);
    //     root.right = invertTree(tempNode);
        
    //     //induction
    //     return root;
        
    // }
    


















    
///////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
    // //Re-solving on 09 Nov 2025:

    // //intuition 1 (recursive): Recursively invert each subtree. Base case is a single node, in which case
    // //simply return that node. Invertion will be to swap left child with right child of node. To do this
    // //use a tempNode variable to help in storing root.left and then later using in swaping with root.right.
    // public TreeNode invertTree(TreeNode root) {

    //     //base case
    //     if(root == null){
    //         return null;
    //     }

    //     // TreeNode tempNode = root.left;
    //     // root.left = root.right;
    //     // root.right = tempNode;

    //     TreeNode tempNode = root.left;
    //     //hypothesis: invertTree correctly inverts the subtrees rooted at root.right and root.left
    //     root.left = invertTree(root.right);
    //     root.right = invertTree(tempNode);

    //     //induction: returning the root after combining left and right
    //     //using the hypothesis to build the full result
    //     return root;
    // }
    




    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // public TreeNode invertTree(TreeNode root) {
    //     if(root == null){
    //         return null;
    //     }
    //     invertTree(root.left);
    //     invertTree(root.right);
    //     TreeNode temp = root.left;
    //     root.left = root.right;
    //     root.right = temp; 
    //     return root;
    // }
}