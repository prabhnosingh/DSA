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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return ans;
        q.add(root);

        while(q.size() != 0){
            int iterations = q.size();

            // if(iterations == 1) ans.add(q.peek().avl);
            
            for(int i = 0; i < iterations; i ++){
            
                TreeNode n = q.remove();
                TreeNode l = n.left;
                TreeNode r = n.right;
                
                if(l != null){
                    q.add(l);

                }
                if(r != null){
                    q.add(r);
                 
                }   
                if(i == iterations - 1){
                    ans.add(n.val);
                }      
                
            }
        }
        return ans;
    }
}