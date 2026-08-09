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

    //intuition 2: DFS
        //have a global arralist to store max values at each level, where
            //each index in the arraylist denotes a level
    public List<Integer> largestValues(TreeNode root) {

        List<Integer> largestValuesList = new ArrayList<>();

        dfs(root, 0, largestValuesList);

        return largestValuesList;    

    }

    private void dfs(TreeNode root, int currDepth, List<Integer> largestValuesList){
        if(root == null) return;

        if(currDepth >= largestValuesList.size()){
            largestValuesList.add(root.val);
        }
        else{
            largestValuesList.set(currDepth, Math.max(largestValuesList.get(currDepth), root.val));
        }

        dfs(root.left, currDepth + 1, largestValuesList);
        dfs(root.right, currDepth + 1, largestValuesList);

        // return currDepth
    }










///////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 09 Aug 2026

    // //intuition 1: BFS
    //     //Run a level order traversal and find the largest value along the way
    // public List<Integer> largestValues(TreeNode root) {
        
    //     List<Integer> largestValueList = new ArrayList<>();

    //     if(root == null) return largestValueList;

    //     Queue<TreeNode> queue = new ArrayDeque<>();
    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int currQueueSize = queue.size();
    //         int currMax = Integer.MIN_VALUE;
    //         for(int i = 0; i < currQueueSize; i ++){
    //             TreeNode currNode = queue.poll();

    //             if(currNode.left != null) queue.offer(currNode.left);
    //             if(currNode.right != null) queue.offer(currNode.right);

    //             currMax = Math.max(currMax, currNode.val);
    //         }

    //         largestValueList.add(currMax);
    //     }

    //     return largestValueList;

    // }
}