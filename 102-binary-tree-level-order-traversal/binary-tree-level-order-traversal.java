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


    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null) return ans;

        q.add(root);

        while(q.size() != 0){
            int iterations = q.size();
            List<Integer> l = new ArrayList<>();

            for(int i = 0; i < iterations; i ++){

                // if(q.peek() != null){
                //     q.add(q.peek().left);
                //     q.add(q.peek().right);
                //     l.add(q.remove().val);
                // }
                // else{
                //     q.remove();
                // }

                TreeNode node = q.remove();
                if(node != null){
                    q.add(node.left);
                    q.add(node.right);
                    l.add(node.val);
                }
                
                
            }
            if(l.size() != 0){
                ans.add(l);
            }

        }



        return ans;







    ////////////////////////////////////////////////////////////////////
    // beats 88.34% 
    // Queue<TreeNode> q = new LinkedList<>();
    // int iterations = q.size();

    // public List<Integer> makeList(int iterations){    
    //     List<Integer> l = new ArrayList<>();
    //     int i = 0;
    //     for(int j = 0; j < iterations; j ++){
    //         if(q.peek() == null) break;
    //         if(q.peek().left == null && q.peek().right == null){
    //             i = q.remove().val; 
    //         }
    //         else if(q.peek().left != null && q.peek().right == null){
    //             q.add(q.peek().left);
    //             i = q.remove().val;
    //         }
    //         else if(q.peek().left == null && q.peek().right != null){
    //             q.add(q.peek().right);
    //             i = q.remove().val;

    //         }   
    //         else{
    //             q.add(q.peek().left);
    //             q.add(q.peek().right);
    //             i = q.remove().val;
    //         }
    //         l.add(i);
    //     }
    //     // iterations = q.size();
    //     return l;

    // }

    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans = new ArrayList<>();

    //     if(root == null) return ans;
    //     q.add(root); 
    //     iterations ++;   
    //     while(iterations != 0){
    //         ans.add(makeList(iterations));
    //         iterations = q.size();
    //     }    
        


    //     return ans;
        
    }
}