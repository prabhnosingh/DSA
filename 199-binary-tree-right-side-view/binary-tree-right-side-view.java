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

    //Re-solving on 16 Nov 2025:

    //intuition 1 (dfs): traverse right side first, keep track of maxLevelTraversed and update the ans list if a new max
    //level is reached 

    int maxLevelTraversed;
    public List<Integer> rightSideView(TreeNode root) {
        maxLevelTraversed = 0;
        List<Integer> rightSideViewList = new ArrayList<>();

        traverseTree(root, rightSideViewList, 1);

        return rightSideViewList;
    }

    private void traverseTree(TreeNode root, List<Integer> rightSideViewList, int currLevel){
        if(root == null){
            return;
        }

        if(currLevel > maxLevelTraversed){
            maxLevelTraversed = currLevel;
            rightSideViewList.add(root.val);
        }

        traverseTree(root.right, rightSideViewList, currLevel + 1);
        traverseTree(root.left, rightSideViewList, currLevel + 1);

    }




























    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 11 Nov 2025:

    // //intuition 1 (dfs): The basic idea is to add rightmost element at each level of the tree. We maintain a 
    // //global maxLevelTraversed to keep track of maximum level that has been already traversed and only add
    // //elements to ans list if currLevel becomes greater than max level, as if currLevel is less than the max
    // //level then it means that some other recursive call have already travesed that level and added the rightmost 
    // //element at that level to the ans list.

    // //Traverse the right side first and then left side to cover the right nodes first. 
    // //100% beat
    // //TC: O(n): Traversing one node ones only
    // //SC: O(h): h = height of tree (recursive stack)

    // int maxLevelTraversed;
    // public List<Integer> rightSideView(TreeNode root) {
    //     maxLevelTraversed = 0;
        
    //     List<Integer> rightSideViewList = new ArrayList<>();

    //     dfsTraversal(root, 1, rightSideViewList);

    //     return rightSideViewList;

    // }

    // private void dfsTraversal(TreeNode root, int currLevel, List<Integer> rightSideViewList){
    //     if(root == null){
    //         return;
    //     }


    //     if(currLevel > maxLevelTraversed){
    //         rightSideViewList.add(root.val);
    //         maxLevelTraversed = currLevel;
    //     }

    //     dfsTraversal(root.right, currLevel + 1, rightSideViewList);
    //     dfsTraversal(root.left, currLevel + 1, rightSideViewList);
    // }




//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 11 Nov 2025:

    // //intuition 1 (bfs): We can store all the elements in a queue for each level in right -> left order
    // //and add the front element for each level to our ans list   
    // //beats 70%
    // //TC: O(n): additional cost of poll and offer
    // //SC: O(breadht of tree) : For a complete binary tree, breadth = n/2 => O(n).

    // public List<Integer> rightSideView(TreeNode root) {
        
    //     List<Integer> rightSideViewList = new ArrayList<>();

    //     if(root == null){
    //         return rightSideViewList;
    //     } 
        
        
    //     Queue<TreeNode> queue = new ArrayDeque<>();       
    //     // Queue<TreeNode> queue = new LinkedList<>();
    //     queue.add(root);

    //     while(!queue.isEmpty()){
    //         int currSize = queue.size();

    //         for(int i = 0; i < currSize; i ++){
    //             TreeNode currNode = queue.poll();
    //             if(i == 0) rightSideViewList.add(currNode.val);

    //             if(currNode.right != null){
    //                 queue.offer(currNode.right);
    //             } 
    //             if(currNode.left != null){
    //                 queue.offer(currNode.left);
    //             } 
    //         }
    //     }

    //     return rightSideViewList;


    // }

























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // intiution: First we will sepearate all nodes at each level (depth) like "Binary Tree Level Order Traversal" and then 
    // retrieving the last element from each level-order list will give use the right-side-view.
    
    // recursive (self thought)
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<List<Integer>> levelOrderNodes = new ArrayList<>();
    //     List<Integer> ans = new ArrayList<>();
    //     levelOrderTraversal(root, 0, levelOrderNodes);

    //     for(List<Integer> currList : levelOrderNodes){
    //         if(currList.size() == 0) continue;
    //         ans.add(currList.get(currList.size() - 1));
    //     }
    //     return ans;
    // }

    // public void levelOrderTraversal(TreeNode root, int currLevel, List<List<Integer>> levelOrderNodes){

    //     if(root == null){
    //         return;
    //     }

    //     if(currLevel == levelOrderNodes.size()){
    //         List<Integer> tempList = new ArrayList<>();
    //         tempList.add(root.val);
    //         levelOrderNodes.add(tempList);
    //     }

    //     else{
    //         levelOrderNodes.get(currLevel).add(root.val);
    //     }

    //     levelOrderTraversal(root.left, currLevel + 1, levelOrderNodes);
    //     levelOrderTraversal(root.right, currLevel + 1, levelOrderNodes);



    // }
/////////////////////////////////////////////////////////////////////////////////////////////////

    // iterative: using Queue (self thought)
    // intiution: use Queue to traverse each level and then after every iteration (for loop), the very last element that 
    // polls from the queue is the rightmost element in that level, given we are adding elements to queue in order of
    // queue.add(root.left); queue.add(root.right); 

    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     if(root == null){
    //         return ans;
    //     }

    //     Queue<TreeNode> queue = new LinkedList<>();

    //     queue.offer(root);

    //     while(!queue.isEmpty()){
    //         int queueSize = queue.size();
    //         TreeNode lastNode = null;
    //         for(int i = 0; i < queueSize; i ++){
    //             TreeNode tempNode = queue.poll();
    //             if(tempNode != null){
    //                 lastNode = tempNode;
    //                 queue.offer(tempNode.left);
    //                 queue.offer(tempNode.right);

    //             }

    //             //////1
    //             // if(i == (queueSize - 1)){
    //             //////1
                
    //             // if(i == 0){
    //             //     ans.add(tempNode.val);
    //             // }

    //             //////1
    //             // if(tempNode.left != null){
    //             //     queue.offer(tempNode.left);
    //             // }
    //             // if(tempNode.right != null){
    //             //     queue.offer(tempNode.right);
    //             // }
    //             //////1
                
    //             // if(tempNode.right != null){
    //             //     queue.offer(tempNode.right);
    //             // }
    //             // if(tempNode.left != null){
    //             //     queue.offer(tempNode.left);
    //             // }
               
    //         }
    //         if(lastNode != null){
    //             ans.add(lastNode.val);
    //         }

    //     }
    //     return ans;
    // }
//////////////////////////////////////////////////////////////////////////////////////////
    // // dfs approach after taking a look at 100% beat solution
    // int maxLevelTraversed = 0;
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> ans = new ArrayList<>();
    //     rightTraversal(root, 1, ans);
    //     return ans;
    // }

    // public void rightTraversal(TreeNode root, int currLevel, List<Integer> ans){
    //     if(root == null){
    //         return;
    //     }

    //     if(currLevel > maxLevelTraversed){
    //         ans.add(root.val);
    //         maxLevelTraversed = currLevel;
    //     }

    //     rightTraversal(root.right, currLevel + 1, ans); // first traverse all the way to the right until a leaf node is 
    //     // encountered add the elements to ans as per "currLevel > maxLevelTraversed" condition
    //     rightTraversal(root.left, currLevel + 1, ans);

    // }
}



