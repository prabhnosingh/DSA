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
    
    //Re-solving on 08 Aug 2026:

    //intuition 1: 
        //run a recursive call in isSameTree and compare p and q at all the levels
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;



        if(p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }





















   
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 09 Nov 2025:

//     //intuition 2 (recursive): compare each node of p with q in recursive manner. Return false if at any step
//     //both of them does not match
//     public boolean isSameTree(TreeNode p, TreeNode q) {

//         if(p == null && q == null){
//             return true;
//         }

//         if((p != null && q == null) || (p == null && q != null)){
//             return false;
//         }

//         if(p.val != q.val){
//             return false;
//         }
//         // else{
//         //     return true;
//         // }

//         return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

//     }

   
    
// ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 09 Nov 2025:

    // //intuition 1: Construct pre order array for both the trees and compare both arrays. This will work
    // //but feels like it is not the optimal one, but lets proceed with this as of now

    //DOES NOT WORK AND THIS MUCH EFFORT IS NOT NEEDED
    // public boolean isSameTree(TreeNode p, TreeNode q) {

    //     List<Integer> preorderOfP = new ArrayList<>();
    //     List<Integer> preorderOfQ = new ArrayList<>();

    //     traverseTree(p, preorderOfP);
    //     traverseTree(q, preorderOfQ);

    //     int pIdx = 0;
    //     int qIdx = 0;

    //     while(pIdx < preorderOfP.size() && qIdx < preorderOfQ.size()){
    //         if(preorderOfP.get(pIdx ++) != preorderOfQ.get(qIdx ++)){
    //             return false;
    //         }
    //     } 

    //     if(pIdx != qIdx){
    //         return false;
    //     }

    //     return true;


    // }

    // private void traverseTree(TreeNode root, List<Integer> preorderList){
    //     if(root == null){
    //         preorderList.add(Integer.MIN_VALUE); //to signify a null value in an integer array
    //         return;
    //     }
    //     preorderList.add(root.val);
    //     traverseTree(root.left, preorderList);
    //     traverseTree(root.right, preorderList);
    // }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    // public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p == null && q == null){
        //     return true;
        // }
        // else if((p == null && q != null) || (p != null && q == null)){
        //     return false;
        // }
        // else{
        //     if(p.val == q.val){
        //         return true;
        //     }
        //     else{
        //         return false;
        //     }
        // }

        // return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));



////////////////////////////////
//BFS -> BFS is more suited in scenarios where we just want to traverse the nodes at each level before moving down the depth of the tree. It is not good in comparing the trees as it does not take null values into account.
        // if(p == null && q == null){
        //     return true;
        // }
        // else if((p == null && q != null) || (p != null && q == null)){
        //     return false;
        // }

        // Queue<TreeNode> pQueue = new LinkedList<>();
        // Queue<TreeNode> qQueue = new LinkedList<>();

        // pQueue.add(p);
        // qQueue.add(q);
        
        // int pQueueSize = pQueue.size();
        // int qQueueSize = qQueue.size();

        // while(!pQueue.isEmpty() || !qQueue.isEmpty()){
        //     if(pQueueSize != qQueueSize) return false;

        //     for(int i = 0; i < qQueueSize; i ++){
        //         TreeNode tempPNode = pQueue.poll();
        //         TreeNode tempQNode = qQueue.poll();
        //         if((tempPNode != null && tempQNode == null) || (tempQNode != null && tempPNode == null)){
        //             System.out.println("flag1");
        //             return false;
        //         }
        //         if(tempPNode != null && tempQNode != null){
        //             if(tempPNode.val != tempQNode.val){
        //                 System.out.println(tempPNode.val + "   " + tempQNode.val);
        //                 System.out.println("flag2");
        //                 return false;
        //             }
                    
        //             // if(tempPNode.left != null){
        //                 pQueue.add(tempPNode.left);
        //             // }
        //             // if(tempPNode.right != null){
        //                 pQueue.add(tempPNode.right);
        //             // }

        //             // if(tempQNode.left != null){
        //                 qQueue.add(tempQNode.left);
        //             // }
        //             // if(tempQNode.right != null){
        //                 qQueue.add(tempQNode.right);
        //             // }
        //         }
        //     }

        // } 
        // return true;
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// DFS

    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     if(p == null && q == null){
    //         return true;
    //     }

    //     if(p == null || q == null){
    //         return false;
    //     } 
    //      if(p.val != q.val) {
    //         return false;
    //     }
        
    //     // isSameTree(p, q);
       
        

    //     return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    // }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //BFS using queue 
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     Queue<TreeNode> queue1 = new LinkedList<>();
    //     Queue<TreeNode> queue2 = new LinkedList<>();
    //     if(p == null && q == null){
    //         return true;
    //     }
    //     queue1.offer(p);
    //     queue2.offer(q);
    //     while(!queue1.isEmpty() && !queue2.isEmpty()){
    //         int queue1Size = queue1.size();

    //         for(int i = 0; i < queue1Size; i ++){
    //             TreeNode tempNode1 = queue1.poll();
    //             TreeNode tempNode2 = queue2.poll();

    //             if(tempNode1 == null && tempNode2 == null){} // do nothing
    //             else if(tempNode1 == null || tempNode2 == null){ // in case one is null
    //                 return false;
    //             }
    //             else if(tempNode1.val != tempNode2.val){
    //                 return false;
    //             }
                

    //             if(tempNode1.left != null && tempNode2.left != null){
    //                 queue1.offer(tempNode1.left);
    //                 queue2.offer(tempNode2.left);
    //             }
    //             else if(tempNode1.left == null && tempNode2.left == null){}
    //             else{
    //                 return false;
    //             }
    //             if(tempNode1.right != null && tempNode2.right != null){
    //                 queue1.offer(tempNode1.right);
    //                 queue2.offer(tempNode2.right);
    //             }
    //             else if(tempNode1.right == null && tempNode2.right == null){}
    //             else{
    //                 return false;
    //             }
                
            
    //         }
    //     }
    //     return true;


    // }
/////////////////////////////////////////////////////////////////////////   

    //BFS using queue after seeing some other cleaner solution
    // public boolean isSameTree(TreeNode p, TreeNode q) {
    //     Queue<TreeNode> queue = new LinkedList<>();

    //     if(p == null && q == null){
    //         return true;
    //     }

    //     queue.offer(p);
    //     queue.offer(q);

    //     while(!queue.isEmpty()){
    //         int queueSize = queue.size();

    //         for(int i = 0; i < queueSize; i ++){
    //             TreeNode tempNode1 = queue.poll();
    //             TreeNode tempNode2 = queue.poll();

    //             if(tempNode1 == null && tempNode2 == null){
    //                 continue; // to skip adding null.left, null.right to queue, which would have otherwise given error "Cannot read field "left" because "<local6>" is null" 
    //             } 
    //             else if(tempNode1 == null || tempNode2 == null){
    //                 return false;
    //             }    
    //             else if(tempNode1.val != tempNode2.val){
    //                 return false;
    //             }

    //             queue.offer(tempNode1.left);
    //             queue.offer(tempNode2.left);
    //             queue.offer(tempNode1.right);
    //             queue.offer(tempNode2.right);
    //         }
    //     }
    //     return true;

    // }



}