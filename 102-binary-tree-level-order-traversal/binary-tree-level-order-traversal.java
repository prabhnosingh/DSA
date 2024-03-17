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

    Queue<TreeNode> q = new LinkedList<>();
    int iterations = q.size();

    public List<Integer> makeList(int iterations){    
        List<Integer> l = new ArrayList<>();
        int i = 0;
        for(int j = 0; j < iterations; j ++){
            if(q.peek() == null) break;
            if(q.peek().left == null && q.peek().right == null){
                i = q.remove().val; 
            }
            else if(q.peek().left != null && q.peek().right == null){
                q.add(q.peek().left);
                i = q.remove().val;
            }
            else if(q.peek().left == null && q.peek().right != null){
                q.add(q.peek().right);
                i = q.remove().val;

            }   
            else{
                q.add(q.peek().left);
                q.add(q.peek().right);
                i = q.remove().val;
            }
            l.add(i);
        }
        // iterations = q.size();
        return l;

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;
        q.add(root); 
        iterations ++;   
        while(iterations != 0){
            ans.add(makeList(iterations));
            iterations = q.size();
        }    
        


        return ans;
        
    }
}