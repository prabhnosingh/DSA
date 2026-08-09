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

    //Re-solving on 08 Aug 2026: 

    //intuition 1: DFS
        //find the height of left and right subtrees for each node and
            //return false if any of the node have |leftHeight - rightHeight| > 1
        //but this will cause repeated traversals

    //intuition 2: DFS
        //find the height of left and right sub trees and along the way 
            //validate whether any subtree violates Balanced binary tree condition

        //TC: O(n) : where n is the nodes in root
        //SC: O(h) : where h is the height of the root
    public boolean isBalanced(TreeNode root) {
        
        if(treeHeight(root) == -1) return false;
        return true;
    }

    private int treeHeight(TreeNode root){
        if(root == null) return 0;

        int leftSTHeight = treeHeight(root.left);
        int rightSTHeight = treeHeight(root.right);

        if(leftSTHeight == -1 || rightSTHeight == -1) return -1;

        if(Math.abs(leftSTHeight - rightSTHeight) > 1) return -1;


        return Math.max(leftSTHeight, rightSTHeight) + 1;
    }

















//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 08 Nov 2025: 

//     //intuition 2: While checking for height determine if left and right subtree have a height difference of more than 1. If 
//     //yes, return -1 and propagate it upwards. If -1 is received, it means that the tree in no height-balanced 


//     //TC: O(n) -> Each node visited once 
//     public boolean isBalanced(TreeNode root) {

//         if(recursiveHeight(root) == -1) return false;
//         return true;
//     }

//     public int recursiveHeight(TreeNode root){
//         if(root == null){
//             return 0;
//         }

//         int leftHeight = recursiveHeight(root.left);
//         if(leftHeight == -1){
//             return -1;
//         }

//         int rightHeight = recursiveHeight(root.right);
//         if(rightHeight == -1){
//             return -1;
//         }

//         if(Math.abs(leftHeight - rightHeight) > 1){
//             return -1;
//         }

//         return 1 + Math.max(leftHeight, rightHeight);


//     }



// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 07 Nov 2025: 

    // //intuition 1: Recursively check for the height of each node's left and right childrens and determine
    // //whether it is balanced or not. If anywhere the height of left and right children differ by more than 1
    // //return false from there.
    //O(n ^ 2) -> Height recalculated for every node
    // public boolean isBalanced(TreeNode root) {

    //     if(root == null){
    //         return true;
    //     }

    //     if(!isBalanced(root.left) || !isBalanced(root.right)){ //hypothesis (recursive assumption) -> Assumes
    //     //recursion gives correct result for subproblems
    //         return false;
    //     }

    //     if(Math.abs(recursiveHeight(root.left) - recursiveHeight(root.right)) > 1){ //induction (logic using 
    //     //recursive results) -> Combines recursive results to compute current answer
    //     // System.out.println(recursiveHeight(root.left));
    //     // System.out.println(recursiveHeight(root.right));
    //         return false;
    //     }

    //     return true;
    // }

    // public int recursiveHeight(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }

    //     int leftHeight = 1 + recursiveHeight(root.left);
    //     int rightHeight = 1 + recursiveHeight(root.right);

    //     return Math.max(leftHeight, rightHeight);
    // }















//////////////////////////////////////////////////////////////////////////////////////////////////////////
    // public boolean isBalanced(TreeNode root) {
    //     if(root == null){
    //         return true;
    //     }    

    //     boolean leftChild = isBalanced(root.left);
    //     if(!leftChild){
    //         return false;
    //     }
    //     boolean rightChild = isBalanced(root.right);
    //      if(!rightChild){
    //         return false;
    //     }
        

    //     int leftChildHeight = height(root.left);
    //     int rightChildHeight = height(root.right);

    //     if(Math.abs(leftChildHeight - rightChildHeight) > 1){
    //         return false;
    //     }
    //     return true;
      
    // }



    // public int height(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }

    //     int leftHeight = height(root.left) + 1;
    //     int rightHeight = height(root.right) + 1;

    //     return Math.max(leftHeight, rightHeight);

    // }


}