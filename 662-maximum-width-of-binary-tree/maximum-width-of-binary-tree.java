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

    //intuition 2: BFS (deque)
        //Do a level order traversal using a queue
        //The queue will take a pair (node, idx)
        //We will index each node using the below understanding:
            //In a full binary tree, the number of nodes double at each level
                //and since each parent node has two childs the range of node index
                //would double as wel
            //Therefore we can say for any node at idx Ci, the left child of that
                //node would be at 2Ci idx  and right child node of that node would be
                //at 2Ci + 1 idx
  
        //After implementing this indexing we would take the first and last index from
            //any level and compute the width using "idxLast - idxFirst  + 1"

    public int widthOfBinaryTree(TreeNode root) {
        
        int maxWidth = 0;
        if(root == null) return maxWidth;
        
        Deque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        queue.offer(new Pair<>(root, 0));

        while(!queue.isEmpty()){
            int currQueueSize = queue.size();
           
            Pair<TreeNode, Integer> headElm = queue.peekFirst();

            int firstIdx = 0;
            int lastIdx = 0;
            Pair<TreeNode, Integer> currElm = null;
            for(int i = 0; i < currQueueSize; i ++){
                currElm = queue.poll();
                TreeNode currElmNode = currElm.getKey();
                int currElmIdx = currElm.getValue();

                if(currElmNode.left != null){
                    queue.offer(new Pair<>(currElmNode.left, 2*currElmIdx));
                }
                if(currElmNode.right != null){
                    queue.offer(new Pair<>(currElmNode.right, (2*currElmIdx) + 1));
                }
            }

            maxWidth = Math.max(maxWidth, currElm.getValue() - headElm.getValue() + 1);
        }
        return maxWidth;
        
    }







///////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 09 Aug 2026

    // //intuition 1: BFS
    //     //Do a level order traversal using a queue
    //     //The queue will take a pair (node, idx)
    //     //We will index each node using the below understanding:
    //         //In a full binary tree, the number of nodes double at each level
    //             //and since each parent node has two childs the range of node index
    //             //would double as wel
    //         //Therefore we can say for any node at idx Ci, the left child of that
    //             //node would be at 2Ci idx  and right child node of that node would be
    //             //at 2Ci + 1 idx
  
    //     //After implementing this indexing we would take the first and last index from
    //         //any level and compute the width using "idxLast - idxFirst  + 1"

    // public int widthOfBinaryTree(TreeNode root) {
        
    //     int maxWidth = 0;
    //     if(root == null) return maxWidth;
        
    //     Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
    //     queue.offer(new Pair<>(root, 0));

    //     while(!queue.isEmpty()){
    //         int currQueueSize = queue.size();
           

    //         int firstIdx = 0;
    //         int lastIdx = 0;
    //         for(int i = 0; i < currQueueSize; i ++){
    //             Pair<TreeNode, Integer> currElm = queue.poll();
    //             TreeNode currElmNode = currElm.getKey();
    //             int currElmIdx = currElm.getValue();

    //             if(i == 0) firstIdx = currElmIdx;
    //             if(i == currQueueSize - 1) lastIdx = currElmIdx;

    //             if(currElmNode.left != null){
    //                 queue.offer(new Pair<>(currElmNode.left, 2*currElmIdx));
    //             }
    //             if(currElmNode.right != null){
    //                 queue.offer(new Pair<>(currElmNode.right, (2*currElmIdx) + 1));
    //             }
    //         }

    //         maxWidth = Math.max(maxWidth, lastIdx - firstIdx + 1);
    //     }
    //     return maxWidth;
        
    // }
}