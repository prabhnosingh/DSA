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
    //intuition 1: traverse through the whole tree and add elements in a list, then sort and return the kth smallest
    // List<Integer> list = new ArrayList<>();
    // public int kthSmallest(TreeNode root, int k) {

    //     dfs(root);

    //     // Collections.sort(list); // no need of sorting the list as in dfs inorder traversal is being used and in BST
                                      // this leads to already sorted list
    //     return list.get(k - 1);

    // }
    // public void dfs(TreeNode root){
    //     if(root == null){
    //         return;
    //     }
    //     dfs(root.left);
    //     list.add(root.val);
    //     dfs(root.right);
    // }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //intuition 2: Use BST's properties (left < root < right) to optimize. Traverse to the left most 
    //node(having left child as null), then start backtracking and decreasing k by 1 with each traversal
    //and return the node where k == 0
    int count = 0;
    int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        // globalK = k;
        traverse(root, k);
        return ans; 
        
    }

    public void traverse(TreeNode root, int k){
        if(root == null){
            return;
        }         
        traverse(root.left, k);
        count ++;
        if(k == count){
            ans = root.val;
            return;
        }
        traverse(root.right, k);

    }
}



