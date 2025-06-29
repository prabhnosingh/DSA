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
    // intuition 1: The last element of postorder will be the master root. The left of root in inorder will be left subtree
    // the right of root in inorder will be right subtree. Use HashMap to store the indices if inorder elements.
    // when you are specifying the start and end for recursive calls, set them like you are splitting inorder array
    //which is in left -> root -> right format 
    private HashMap<Integer, Integer> map;
    private int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        postOrderIdx = postorder.length - 1;
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }

        return build(postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] postorder, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = postorder[postOrderIdx --]; // 3
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal); // 1

        root.right = build(postorder, mid + 1, end); // (4 - 1, 1)
        root.left = build(postorder, start, mid - 1);
        return root;
    }
}