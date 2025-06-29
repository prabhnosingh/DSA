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
    // preorder -> root -> left -> right
    // inorder -> left -> root -> right
    // intuition 1: Start with preorder[0](master root). Find the index of master root in inorder.
    // Divide the array in two subarrays, now the left subArray will be left child and right subArray
    // will be right child. The length of these left and right subArrays (in inorder) will determine how we split 
    // preoder array 

    //************Optimize this*********************
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if(preorder.length == 0 || inorder.length == 0){
    //         return null;
    //     }

    //     TreeNode root = new TreeNode(preorder[0]);

    //     //finding index of root in inorder array
    //     int mid = -1;
    //     for(int i = 0; i < inorder.length; i ++){
    //         if(inorder[i] == root.val){
    //             mid = i;
    //             break;
    //         }
    //     }

    //     int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid); // 0 to mid - 1(inclusive) is the left subtree
    //     int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1); // starting from 1 because there is 
    //     // root at '0' index
    //     root.left = buildTree(leftPreorder, leftInorder);

    //     int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
    //     int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);

    //     root.right = buildTree(rightPreorder, rightInorder);

    //     return root;
    // }









    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // inuition 2: use recursive approach to build left and right sub trees by dividing the arrays
    // public TreeNode buildTree(int[] preorder, int[] inorder){
    //     if(preorder.length == 0){
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(preorder[0]);

    //     int rootIdxInInorder = 0;
    //     for(int i = 0; i < inorder.length; i ++){
    //         if(preorder[0] == inorder[i]){
    //             rootIdxInInorder = i;
    //             break;
    //         }
    //     }

    //     int mid = rootIdxInInorder; //in inorder array, left of this index is the left subtree and right is right subtree
    //     int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
    //     int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid + 1);
    //     root.left = buildTree(leftPreorder, leftInorder);

    //     int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
    //     int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
    //     root.right = buildTree(rightPreorder, rightInorder);

    //     return root;
    // }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    // inuition 3(hashmap): use recursive approach to build left and right sub trees by dividing the arrays. Use HashMap to \
    //find the index of root(preorder[0])
    public TreeNode buildTree(int[] preorder, int[] inorder){
        if(preorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }
        int rootIdxInInorder = map.get(preorder[0]);

        int mid = rootIdxInInorder; //in inorder array, left of this index is the left subtree and right is right subtree
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid + 1);
        root.left = buildTree(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
        root.right = buildTree(rightPreorder, rightInorder);

        return root;
    }

}










