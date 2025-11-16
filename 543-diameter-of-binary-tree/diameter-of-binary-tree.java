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

    //intuition 1 (solving without global variable): At any node, the diameter will be left height + right height. 
    //Maintain a global diameter variable that will keep track of max(leftHeight + rightHeight) till now

    //Diameter of a binary tree is the longest path between two nodes

    //Beats 100%: Only calling heightOfBinaryTree once and storing diameter in global var
    //TC: O(3n) = O(n) : n = number of nodes in the tree
        //3n because of 3 operations per node: visiting the node, computing left height, computing right height
    //SC: O(h) : h = height of tree
    
    public int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;

        Pair<Integer, Integer> ans = heightOfBinaryTree(root, diameter);
        return ans.getValue();
    }
    private Pair<Integer, Integer> heightOfBinaryTree(TreeNode root, int diameter){
        //base case
        if(root == null){
            return new Pair(0, 0);
        }

        //hypothesis
        Pair<Integer, Integer> leftSTHeight = heightOfBinaryTree(root.left, diameter);
        Pair<Integer, Integer> rightSTHeight = heightOfBinaryTree(root.right, diameter);
        
        diameter = Math.max(Math.max(diameter, leftSTHeight.getKey() + rightSTHeight.getKey()), Math.max(leftSTHeight.getValue(), rightSTHeight.getValue())); 
       
        // induction
        return new Pair((1 + Math.max(leftSTHeight.getKey(), rightSTHeight.getKey())), diameter);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //Re-solving on 11 Nov 2025:

    //intuition 1: At any node, the diameter will be left height + right height. 
    //Maintain a global diameter variable that will keep track of max(leftHeight, rightHeight) till now

    //Diameter of a binary tree is the longest path between two nodes
    
    //beats (6.83%) : uncessary calls to the diameterOfBinaryTree and calls to heightOfBinaryTree for every node

    //TC: O(nxn) = O(n^2) : n = number of nodes in tree
    //For each node we compute height (O(n)) again
    //SC: O(h): h = height of the tree

    // public int diameterOfBinaryTree(TreeNode root) {
    //     if(root == null){
    //         return 0;
    //     }

    //     int leftHeight = heightOfBinaryTree(root.left);
    //     int rightHeight = heightOfBinaryTree(root.right);

    //     int diameter = leftHeight + rightHeight;

    //     int leftDiameter = diameterOfBinaryTree(root.left);
    //     int rightDiameter = diameterOfBinaryTree(root.right);

    //     return Math.max(diameter, Math.max(leftDiameter, rightDiameter));
    
    // }


    // private int heightOfBinaryTree(TreeNode root){
    //     //base case
    //     if(root == null){
    //         return 0;
    //     }

    //     //hypothesis
    //     int leftSTHeight = heightOfBinaryTree(root.left);
    //     int rightSTHeight = heightOfBinaryTree(root.right);

         
    //     // induction
    //     return 1 + Math.max(leftSTHeight, rightSTHeight);
    // }


////////////////////////////////////////////////////////////////////////////////
    
   
    // //Re-solving on 11 Nov 2025:

    // //intuition 1: At any node, the diameter will be left height + right height. 
    // //Maintain a global diameter variable that will keep track of max(leftHeight + rightHeight) till now

    // //Diameter of a binary tree is the longest path between two nodes

    // //Beats 100%: Only calling heightOfBinaryTree once and storing diameter in global var
    // //TC: O(3n) = O(n) : n = number of nodes in the tree
    //     //3n because of 3 operations per node: visiting the node, computing left height, computing right height
    // //SC: O(h) : h = height of tree
    // int diameter;
    // public int diameterOfBinaryTree(TreeNode root) {
    //     diameter = 0;

    //     heightOfBinaryTree(root);
    //     return diameter;
    // }
    // private int heightOfBinaryTree(TreeNode root){
    //     //base case
    //     if(root == null){
    //         return 0;
    //     }

    //     //hypothesis
    //     int leftSTHeight = heightOfBinaryTree(root.left);
    //     int rightSTHeight = heightOfBinaryTree(root.right);

    //     diameter = Math.max(diameter, leftSTHeight + rightSTHeight); 
    //     // induction
    //     return 1 + Math.max(leftSTHeight, rightSTHeight);
    // }






















//////////////////////////////////////////////////////////////////////////////////////////
    // int maxDiameter = -1;
    // public int diameterOfBinaryTree(TreeNode root) {
    //     dfs(root);
    //     return maxDiameter;
    // }

    // public int dfs(TreeNode root){
    //     if(root == null){
    //         return 0;
    //     }

    //     int leftLen = dfs(root.left);
    //     int rightLen = dfs(root.right);

    //     int currDiameter = leftLen + rightLen;

    //     maxDiameter = Math.max(maxDiameter, currDiameter);
        
    //     return Math.max(leftLen, rightLen) + 1;
    // }
}