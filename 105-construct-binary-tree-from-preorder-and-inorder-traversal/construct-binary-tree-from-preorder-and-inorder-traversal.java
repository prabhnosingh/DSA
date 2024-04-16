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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[0]);
        // Integer rootValue = preorder[0]; // Ensure this matches the type in inorder
        // int mid = Arrays.asList(inorder).indexOf(rootValue);
        int rootValue = preorder[0];

        // Find the index of root value in the inorder array
        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootValue) {
                mid = i;
                break;
            }
        }
        // if(mid == -1){
        //     root.left = buildTree(Arrays.copyOfRange(preorder, 0, 0), Arrays.copyOfRange(inorder, 0, 0));
        // }
        // else{
        //     root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        // }
        //     root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
            root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length));
        return root;
    }

}