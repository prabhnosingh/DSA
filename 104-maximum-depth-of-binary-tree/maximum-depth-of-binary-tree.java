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
    //Re-solving on 05 Nov 2025:
    //intuition 1: BFS
        //track the depth at each level until no other node is available
        //use a queue to traverse the tree level by level 
        //increment dpeth after processing each complete level
    //intuition 2: DFS
        //search for depth in left and right subtree recursively and return the max
            //of both + 1 (for current node)
        //TC: O(n) : where n is the number of total nodes
        //SC: O(h) : where h is the height of the tree
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;

    }
        
}















////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 05 Nov 2025:

//     //intuition 1: Track the depth at each node recursively and return until a null node is encountered, in which
//     //case return currDepth - 1. For each node's recursive call return max of left and right recursive calls.

//     // int maxDepth;
//     public int maxDepth(TreeNode root) {
//         // maxDepth = 0;

//         return recurse(root);
//     }

//     private int recurse(TreeNode root){  
//         if(root == null){
//             return 0;
//         }

//         return 1 + Math.max(recurse(root.left), recurse(root.right));        
//     }

    
//     // public int maxDepth(TreeNode root) {
//     //     // maxDepth = 0;

//     //     return recurse(root, 1);
//     // }

//     // private int recurse(TreeNode root, int currDepth){  
//     //     if(root == null){
//     //         return currDepth - 1;
//     //     }

//     //     return Math.max(recurse(root.left, currDepth + 1), recurse(root.right, currDepth + 1));        
//     // }
// }















// ////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 04 Nov 2025:

//     //intuition 1: Track the depth at each node recursively and return until a leaf node is encountered 
//     //i.e. boht right and left nodes are null

//     int maxDepth;
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         maxDepth = 0;

//         return dfs(root, 0);
        
//     }

//     private int dfs(TreeNode root, int currDepth){
//         if(root == null){
//             return currDepth;
//         }
//         if(root.left == null && root.right == null){ //leaf node encountered
//             maxDepth = Math.max(maxDepth, currDepth);
//         }

//         return Math.max(Math.max(maxDepth, dfs(root.left, currDepth + 1)),
//          Math.max(maxDepth, dfs(root.right, currDepth + 1)));
//     }
// }


















////////////////////////////////////////////////////////////////////////////////////
//     // int maxDep = 0;
//     public int maxDepth(TreeNode root) {
//         if(root == null){
//             return 0;
//         }
//         // maxDep ++;
//         int leftDep = maxDepth(root.left) + 1;
//         int rightDep = maxDepth(root.right) + 1;
//         return Math.max(leftDep, rightDep);
//     }
// }

//////////////////////////////////////////////////////////////////

//BFS 

// class Solution {
//     public int maxDepth(TreeNode root){
//         if(root ==  null){
//             return 0;
//         }
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int depth = 0;
//         while(!queue.isEmpty()){
//             depth ++;
//             int size = queue.size();
//             while (size > 0){ // Traversing 1 level of tree at a time
                
//                 TreeNode tempNode = queue.remove();

//                 if(tempNode.left != null){
//                     queue.add(tempNode.left);
//                 }
                
//                 if(tempNode.right != null){
//                     queue.add(tempNode.right);
//                 }
//                 size --;
//             }
        
//     }
//     return depth;
// }
// }