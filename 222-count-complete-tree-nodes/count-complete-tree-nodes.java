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
    //intuition 1: use bfs (using queue) to calculate number of nodes
    // public int countNodes(TreeNode root) {
    //     int ans = 0;
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while(!queue.isEmpty()){
    //         int queueSize = queue.size();

    //         for(int i = 0; i < queueSize; i ++){
    //             TreeNode tempNode = queue.poll();
    //             if(tempNode != null){
    //                 ans ++;
    //                 queue.offer(tempNode.left);
    //                 queue.offer(tempNode.right);
    //             }

    //         }
    //     }
    //     return ans;
    // }

    ///////////////////////////////////////////////////////////////////////////
    //intuition 2 (DFS) after watching https://www.youtube.com/watch?v=jmEdQb6SxKU: find height of left subtree 
    // and right subtree. Compare them to see if they are equal,
    // if they are equal then that means that last level is full. ans -> 2^h - 1
    // if they are not equal, then divide the problem and call countNodes recursively on left and right subtree.

    public int countNodes(TreeNode root) {
        
        int leftHeight = traverseLeft(root); 
        int rightHeight = traverseRight(root); 
        
        if(leftHeight == rightHeight){
            return (int) Math.pow(2, leftHeight) - 1; // -1 for master root node, as at level 1, only 1 node(master node) can exist
        }
        else{
            return 1 + countNodes(root.left) + countNodes(root.right); // if leftHeight and rightHeight are not equal. 
        }
        //+1 for root node
    }

    public int traverseLeft(TreeNode root){
        if(root == null){
            return 0;
        }
        
        return traverseLeft(root.left) + 1;
     }
    public int traverseRight(TreeNode root){
        if(root == null){
            return 0;
        }
        return traverseRight(root.right) + 1;
     }
}