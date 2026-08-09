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

    //Re-solving on 09 Aug 2026
    //intuition 1: BFS
        //have a queue to store the values at each level and then polling the
            //elements one by one while adding the children back to the queue
            //at the same time
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root == null) return levelOrder;
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int currLevel = -1;

        while(!queue.isEmpty()){
            int currQueueSize = queue.size();
            currLevel += 1;
            levelOrder.add(new ArrayList<>());

            for(int i = 0; i < currQueueSize; i ++){
                TreeNode currNode = queue.poll();

                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);

                levelOrder.get(currLevel).add(currNode.val);
            }
        }

        return levelOrder;
    }





















    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 05 Nov 2025
    // //intuition 1: Use queue. Pop the elements for the size of the queue (use for loop for this). Push left and
    // //right (non-null) children of the popped node. Add these to a arraylist within for loop and after finishing
    // //the for loop, add this list to main ans list.

    // //TC: O(N)
    // //SC: O(N/2) : At max in the worst case, the queue holds all nodes of the last level of the tree. For a 
    // //complete binary tree, that’s roughly N/2 ≈ O(N) nodes.
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> levelOrderList = new ArrayList<>();
    //     if(root == null){
    //         return levelOrderList;
    //     }
    //     Queue<TreeNode> levelOrderQueue = new ArrayDeque<>();

    //     levelOrderQueue.offer(root);

    //     while(!levelOrderQueue.isEmpty()){
    //         int currSize = levelOrderQueue.size();

    //         List<Integer> eachLevelList = new ArrayList<>(); 
    //         for(int i = 0; i < currSize; i ++){
    //             TreeNode currNode = levelOrderQueue.poll();
    //             eachLevelList.add(currNode.val);    
    //             if(currNode.left != null) levelOrderQueue.offer(currNode.left);
    //             if(currNode.right != null) levelOrderQueue.offer(currNode.right);
    //         }

    //         levelOrderList.add(eachLevelList);


    //     }

    //     return levelOrderList;
    // }





















    // /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // self thought
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     if(root == null){
    //         return ans;
    //     }
    //     Queue<TreeNode> q = new LinkedList<>();
    //     q.offer(root);
    //     while(!q.isEmpty()){
    //         int qSize = q.size();
    //         List<Integer> tempList = new ArrayList<>();
    //         for(int i = 0; i < qSize; i ++){
    //             TreeNode tempNode = q.poll();
    //             if(tempNode != null){
    //                 tempList.add(tempNode.val);
    //                 q.offer(tempNode.left);
    //                 q.offer(tempNode.right);
    //             }
    //         }
    //         if(tempList.size() > 0){
    //             ans.add(tempList);
    //         }
    //     }
    //     return ans;


        
    // }
//////////////////////////////////////////////////////////////////////////////////

    // //after seeing other solution
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     List<List<Integer>> ans = new ArrayList<>();
    //     level(root, 0, ans);
    //     return ans;
    // }
    // public void level(TreeNode root, int currLevel, List<List<Integer>> ans){
    //     if(root == null){
    //         return;
    //     }

    //     if(currLevel == ans.size()){
    //         List<Integer> tempList = new ArrayList<>();
    //         tempList.add(root.val);
    //         ans.add(tempList); //adding new list to the ans

    //         // ans.add(new ArrayList<>(Arrays.asList(root.val))); // when this line is executed, the code give only 90% beat. 
    //         // When the same line is expanded (as above), the code gives 100% beat.
    //     }   
    //     else{ // in case ans have increased in size while level is still lesser (level starts from 0, which is master root)
    //         ans.get(currLevel).add(root.val);
    //     }

    //     level(root.left, currLevel + 1, ans);
    //     level(root.right, currLevel + 1, ans);

    // }
}