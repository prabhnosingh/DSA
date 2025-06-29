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
    // intuition 1: Use queue to store and retrieve accordingly
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int qSize = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for(int i = 0; i < qSize; i ++){
                TreeNode tempNode = queue.poll();
                if(tempNode != null){
                    tempList.add(tempNode.val);
                    queue.offer(tempNode.left);
                    queue.offer(tempNode.right);
                }
            }
            if(tempList.size() > 0){
                ans.add(0, tempList);   
            }
        }
        // return Collections.reverse(ans);
        return ans;

    }
}