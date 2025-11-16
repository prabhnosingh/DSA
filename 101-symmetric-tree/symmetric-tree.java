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

    //intuition 1 (recursive): Have a helper function that takes two roots as parameters and compares whether both 
    //of them are symmetric. For them to be semmetric below conditions should be true:
        //root1.val == root2.val
        //root1.left.val == root2.right.val && root1.right.val == root2.left.val
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return compareNodes(root.left, root.right);
        
    }

    private boolean compareNodes(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }

        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }
        
        if(root1.val != root2.val){
            return false;
        }

        return compareNodes(root1.left, root2.right) && compareNodes(root1.right, root2.left);
    }

























//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 15 Nov 2025:

    // //intuition 1 (recursive): Have a helper function that takes two roots and compares them.
    // //compare root1.left with root2.right and root1.right with root2.left
    // public boolean isSymmetric(TreeNode root) {
        
    //     return isSameTree(root.left, root.right);
    // }

    // private boolean isSameTree(TreeNode root1, TreeNode root2){
        
    //     if(root1 == null && root2 == null) return true;

    //     if((root1 != null && root2 == null) || (root1 == null && root2 != null)){
    //         return false;
    //     }   

    //     if(root1.val != root2.val){
    //         return false;
    //     }
        
       

    //     return((isSameTree(root1.left, root2.right)) && (isSameTree(root1.right, root2.left)));
    // }




















///////////////////////////////////////////////////////////////////////////////////////////////////
    // recursively
    // public boolean isSymmetric(TreeNode root) {
    //     return isSameTree(root.left,root.right);     
    // }

    // public boolean isSameTree(TreeNode root1, TreeNode root2){
    //     if(root1 == null && root2 == null){
    //         return true;
    //     }

    //     else if(root1 != null && root2 != null){
    //         if(root1.val != root2.val) return false;
    //     }
    //     else{ // in case one of the root is null and other is not
    //         return false;
    //     }

    //     return(isSameTree(root1.left, root2.right) && isSameTree(root1.right, root2.left));
    // }
    ///////////////////////////////////////////////////////////////////////////////////////////////
    // // iteratively using stack
    // public boolean isSymmetric(TreeNode root) {
    //     // TreeNode root1 = root.left;
    //     // TreeNode root2 = root.right;

    //     Stack<TreeNode> stack1 = new Stack<>(); 
    //     Stack<TreeNode> stack2 = new Stack<>();

    //     if(root.left == null && root.right == null){
    //         return true;
    //     }
    //     else if(root.left != null && root.right != null){

    //         stack1.push(root.left);
    //         stack2.push(root.right);

    //         while(!stack1.isEmpty() && !stack2.isEmpty()){
                
    //             TreeNode tempNode1 = stack1.pop();
    //             TreeNode tempNode2 = stack2.pop();

    //             if(tempNode1.val != tempNode2.val){
    //                 return false;
    //             }

    //             if(tempNode1.left != null && tempNode2.right != null){
    //                 stack1.push(tempNode1.left);
    //                 stack2.push(tempNode2.right);
    //             }
    //             else if(tempNode1.left == null && tempNode2.right == null){} // do nothing
    //             else{ // in case one in null and other is not
    //                 return false;
    //             }

    //             if(tempNode1.right != null && tempNode2.left != null){
    //                 stack1.push(tempNode1.right);
    //                 stack2.push(tempNode2.left);

    //             }
    //             else if(tempNode1.right == null && tempNode2.left == null){} // do nothing
    //             else{ // in case one in null and other is not
    //                 return false;
    //             }

    //         }
    //         if(stack1.isEmpty() && stack2.isEmpty()){
    //             return true;
    //         }
    //         else{ // in case one stack gets empty first and the other one is still not empty
    //             return false;    
    //         }
            
    //     }
    //     else{ // in case where one of the root's child is null and the other is not
    //         return false;
    //     }
    // }


////////////////////////////////////////////////////////////////////////////////////
    
    // iteratively using queue (copied)
    // public boolean isSymmetric(TreeNode root) {
    //     if(root==null) return true;
    //     Queue<TreeNode> q=new LinkedList<>();
    //     q.offer(root.left);
    //     q.offer(root.right);

    //     while(!q.isEmpty()){
    //         int levelSize=q.size();

    //         for(int i=0;i<levelSize;i++){
    //             TreeNode left=q.poll();
    //             TreeNode right=q.poll();

    //             if(left==null && right==null) continue;

    //             if(left==null || right==null) return false;

    //             if(left.val!=right.val) return false;





    //             q.offer(left.left);
    //             q.offer(right.right);
    //             q.offer(left.right);
    //             q.offer(right.left);   
    //         }
    //     }
    //     return true;
    // }
}