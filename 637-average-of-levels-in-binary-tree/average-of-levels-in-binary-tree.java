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

    //Solving on 09 Aug 2026

    //intuition 1: BFS
        //run a level order traversal and compute avg for each level
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgOfLevelsList = new ArrayList<>();

        if(root == null) return avgOfLevelsList;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currQueueSize = queue.size();
            double currSum = 0;
            for(int i = 0; i < currQueueSize; i ++){
                TreeNode currNode = queue.poll();
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);

                currSum += currNode.val;
            }
            avgOfLevelsList.add(currSum/currQueueSize);
        }

        return avgOfLevelsList;

    }
}