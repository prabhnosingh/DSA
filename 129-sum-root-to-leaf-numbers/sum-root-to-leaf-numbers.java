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
    
    //intuition 1 (recursive-without using global variable): Keep track of current number and update new number 
    //by newNumber = currNumber * 10 + root.val
   
    public int sumNumbers(TreeNode root) {    
       return traverseTree(root, 0, 0);
    }

    private int traverseTree(TreeNode root, int currNumber, int sum){
        if(root == null){
            return sum;
        }

        currNumber = currNumber * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += currNumber;
            return sum;
        }

        return traverseTree(root.left, currNumber, sum) + traverseTree(root.right, currNumber, sum);

    }



































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
    // //intuition 1 (recursive-without using global variable): Start from root node and keep track of numbers encountered.
    // //currNumber = currNumber * 10 + newNumber
    // //Then when a leaf node is encountered, add the currNumber to the totalSum variable
   
    // public int sumNumbers(TreeNode root) {    
    //     return traverseTree(root, 0);
    // }

    // private int traverseTree(TreeNode root, int currNumber){
    //     //base case
    //     if(root == null){
    //         return 0;
    //     }

    //     currNumber = currNumber * 10 + root.val;
        
    //     //induction
    //     if(root.left == null && root.right == null){ //leaf node encountered
    //         return currNumber;
    //     }

    //     //hypothesis 
    //     //assume the recursive calls will correctly return the sum of numbers from left and right subtrees
    //     return traverseTree(root.left, currNumber) + traverseTree(root.right, currNumber);
    // }  


//////////////////////////////////////////////////////////////////////////////////////////////////// 
    // //intuition 1 (recursive): Start from root node and keep track of numbers encountered.
    // //currNumber = currNumber * 10 + newNumber
    // //Then when a leaf node is encountered, add the currNumber to the totalSum variable
    // int totalSum;
    // public int sumNumbers(TreeNode root) {
    //     totalSum = 0;
    //     traverseTree(root, 0);
    //     return totalSum;
    // }

    // private void traverseTree(TreeNode root, int currNumber){
    //     //base case
    //     if(root == null){
    //         return;
    //     }

    //     currNumber = currNumber * 10 + root.val;
       
    //     //induction
    //     if(root.left == null && root.right == null){ //leaf node encountered
    //         totalSum += currNumber;
    //         return;
    //     }

    //     //hypothesis
    //     traverseTree(root.left, currNumber);
    //     traverseTree(root.right, currNumber);

        

    // }   
}