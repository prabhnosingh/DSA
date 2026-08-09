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
    
    //intuition 2: BFS (using doubly linked list)
        //run normal bfs and track if we want to add values left to right or right to left
        //for left to right, add values normally to doubly linkedlist using addLast
        //for right to left, add values to doubly linkedlist using addFirst

        //TC: O(n)
        //SC: O(n/2) = O(n)
        //where n is the total number of nodes
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagLevelOrderList = new ArrayList<>();

        if(root == null) return zigzagLevelOrderList;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean leftToRight = true;

        while(!queue.isEmpty()){
            int currQueueSize = queue.size();

            //doubly linked list
            // LinkedList<Integer> currLevel = new LinkedList<>();
            Deque<Integer> currLevel = new ArrayDeque<>();
            for(int i = 0; i < currQueueSize; i ++){
                TreeNode currNode = queue.poll();
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);//O(1)

                if(leftToRight) currLevel.addLast(currNode.val);
                else currLevel.addFirst(currNode.val);


            }
            leftToRight = !leftToRight;
            // zigzagLevelOrderList.add(currLevel);
            zigzagLevelOrderList.add(new ArrayList<>(currLevel));
        } 
        return zigzagLevelOrderList;

    }

    // //Re-solving on 09 Aug 2026
    
    // //intuition 1: BFS
    //     //run normal bfs and track if we want to add values left to right or right to left
    //     //for left to right, add values normally
    //     //for right to left, add values using list.add(0, value)
    //     //TC: O(n^2) 
    //     //SC: O(n) 
    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    //     List<List<Integer>> zigzagLevelOrderList = new ArrayList<>();

    //     if(root == null) return zigzagLevelOrderList;

    //     Queue<TreeNode> queue = new ArrayDeque<>();
    //     queue.offer(root);

    //     boolean leftToRight = true;

    //     while(!queue.isEmpty()){
    //         int currQueueSize = queue.size();

    //         List<Integer> currLevel = new ArrayList<>();
    //         for(int i = 0; i < currQueueSize; i ++){
    //             TreeNode currNode = queue.poll();
    //             if(currNode.left != null) queue.offer(currNode.left);
    //             if(currNode.right != null) queue.offer(currNode.right); 

    //             if(leftToRight) currLevel.add(currNode.val);
    //             else currLevel.add(0, currNode.val); //costs O(k) because all existing (k)
    //             //elements must shift one position to the right


    //         }
    //         leftToRight = !leftToRight;
    //         zigzagLevelOrderList.add(currLevel);
    //     } 
    //     return zigzagLevelOrderList;

    // }




















/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 15 Nov 2025:

//     //intuition 1(bfs): Do a normal level order traversal. But while adding elements to the list, alternate 
//     //between adding from front(for right to left traversal) and adding from back (for left to right traversal).
        

//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> zigzagLevelOrderList = new ArrayList<>();
//         if(root == null) return zigzagLevelOrderList;
//         Queue<TreeNode> levelOrderQueue = new ArrayDeque<>();
//         boolean leftToRight = true;
//         levelOrderQueue.offer(root);

//         while(!levelOrderQueue.isEmpty()){
//             int currSize = levelOrderQueue.size();
//             List<Integer> currLevelList = new ArrayList<>();
//             for(int i = 0; i < currSize; i ++){
//                 TreeNode currNode = levelOrderQueue.poll();
//                 if(leftToRight){
//                     currLevelList.add(currNode.val);
//                 }
//                 else{
//                     currLevelList.add(0, currNode.val); //adding from the front for right to left traversal
//                 }

//                 if(currNode.left != null){
//                     levelOrderQueue.offer(currNode.left);
//                 }
//                 if(currNode.right != null){
//                     levelOrderQueue.offer(currNode.right);
//                 }

//             }

//             zigzagLevelOrderList.add(currLevelList);
//             leftToRight = !leftToRight;

//         }
//        return zigzagLevelOrderList;

//     }




















// /////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1: 
    // //For level 0 (root) go as left to right
    // //For level 1 go right to left
    // //For level 2 go left to right

    // //For even levels (level % 2 == 0) go left to right
    // //For odd levels (level % 2 != 0) go right to left

    // //Implement normal level order traversal while keeping track of boolean variable leftToRight
    // //if leftToRight is true, then noramlly add the currNode.val to the currLevelList else
    // //add from the front, i.e. list.add(0, currNode.val). Flip the leftToRight after each level (for loop)

    // public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    //     List<List<Integer>> zigzagLevelOrderList = new ArrayList<>();

    //     if(root == null){
    //         return zigzagLevelOrderList;
    //     }

    //     Queue<TreeNode> levelOrderQueue = new ArrayDeque<>();

    //     levelOrderQueue.offer(root);
    //     boolean leftToRight = true;
    //     while(!levelOrderQueue.isEmpty()){
    //         int currSize = levelOrderQueue.size();
    //         List<Integer> levelOrderList = new ArrayList<>();
            
    //         for(int i = 0; i < currSize; i ++){
    //             TreeNode currNode =  levelOrderQueue.poll();

    //             if(leftToRight){
    //                 levelOrderList.add(currNode.val);
    //             }
    //             else{
    //                 levelOrderList.add(0, currNode.val);
    //             }

    //             if(currNode.left != null){
    //                 levelOrderQueue.offer(currNode.left);                        
    //             }
    //             if(currNode.right != null){
    //                 levelOrderQueue.offer(currNode.right);                        
    //             }

    //         }
    //         zigzagLevelOrderList.add(levelOrderList);
    //         leftToRight = !leftToRight; 
    //     }

    //     return zigzagLevelOrderList;

    // }
}