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
    
    ArrayList<Integer> ans = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {

        traverse(root);

        return ans.get(k - 1);

    }

    public void traverse(TreeNode root){
        if(root == null){
            return; 
        }

        traverse(root.left);
        ans.add(root.val);
        traverse(root.right);

    }










////////////////////////////////////////////////////////////////////    
    // beats 8.18 %
    // ArrayList<Integer> list = new ArrayList<>();
    // public int kthSmallest(TreeNode root, int k) {
        
    //     traverse(root);
    //     int n = list.size();
    //     int[] ans = new int[n];
        
    //     for(int i = 0; i < n; i ++) ans[i] = list.get(i);
    //     Arrays.sort(ans);

    //     return ans[k - 1];

    // }

    // public int traverse(TreeNode root){
    //     if(root == null){
    //         return -1;
    //     }

    //     list.add(root.val);

    //     traverse(root.left);
    //     traverse(root.right);
        
    //     return 1;
        
}