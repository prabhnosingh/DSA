/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

   //Re-solving on 16 Nov 2025

    //intuition 1: The main idea remains the same like a normal Binary tree:
        //if p and q are in differnt subtrees, return root
        //if p and q are in left subtree, return whichever is enountered first
        //if p and q are in right subtree, reutrn whichever is encountered first
    //But instead of going to each node, we can use BST properties to stop early and reduce TC
        //Basically, whenever root.val lies in-between p.val and q.val return root as there is a split
            //and it is guaranteed that root is LCA
        //If p and q are both smaller than root, traverse left sub tree and leave right sub tree
        //If p and q are both greater than root, tarverse right sub tree and leave left sub tree

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root == null){
            return null;
        }

        if(root.val == p.val || root.val == q.val){
            return root;
        }

        if((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)){
            return root;
        }

        if(root.val > p.val && root.val > q.val){ //p and q are in left subtree
            return lowestCommonAncestor(root.left, p, q);
        }

        if(root.val < p.val && root.val < q.val){ //p and q are in right subtree
            return lowestCommonAncestor(root.right, p, q);
        }

        return null;
        
    }



















































/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    //Re-solving on 09 Nov 2025

//     //intuition 1: If both p and q are smaller than root, then go left subtree 
//     // If both p and q are greater than root, then go right subtree
//     // If we find a root that is inbetween the range of p and q, return root. 
//     //
    
//     //TC: O(h): you visit at most one node per level 
//     //where h is height of tree : We only traverse down one path in the BST (either left or right) until
//     //a split point (LCA) is found
//         //height can be logn in case of balanced BST and h = n in case of skewed bst
//     //In a Binary Search Tree, each recursive call goes either left or right — never both.
//         //At each step, you compare root.val with p.val and q.val.
//         //Based on that comparison, you move only one level down (left or right).
//         //So, you make one recursive call per level of the tree until you reach the LCA.

//         //The total number of levels you can go down at max = height of the tree = h.

//     //SC: O(h): Recursive stack
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            
//         // if(root == null || root == p || root == q){
//         //     return root;
//         // }

//         if(root.val > p.val && root.val > q.val){
//             return lowestCommonAncestor(root.left, p, q);
//         }
        
//         else if(root.val < p.val && root.val < q.val){
//             return lowestCommonAncestor(root.right, p, q);
//         }

//         return root;

        
//     }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 09 Nov 2025

    // //intuition 1: if we find a root that is inbetween the range of p and q, return root
    // //
    
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            
    //     // if(root == null || root == p || root == q){
    //     if(root == null || (root.val >= p.val && root.val <= q.val) || (root.val >= q.val && root.val <= p.val) || root == q || root == p){
    //         return root;
    //     }

    //     // if((root.val < p.val && p.val < q.val) || (root.val < q.val && q.val < p.val)){
    //     //     return null;
    //     // }
    //     // if((root.val > p.val && p.val > q.val) || (root.val > q.val && q.val > p.val)){
    //     //     return null;
    //     // }
    
    //     TreeNode lstLCA =  lowestCommonAncestor(root.left, p, q);
    //     TreeNode rstLCA =  lowestCommonAncestor(root.right, p, q);


    //     if(lstLCA != null && rstLCA != null){
    //         return root;
    //     }
    //     return lstLCA != null ? lstLCA : rstLCA;

    // }
























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1 (clean version): If p.val(2) < node.val(6) and node.val(6) < q.val(8). The node element is the lowest
    // //common ancestor because after that there will be a split of nodes and the ancesotrs will change.

    // //If we find a node.val == p.val or node.val == q.val. In that case, the node is the lowest common
    // //ancestor because that is the lowest we can go

    // //if node.val is smaller than both p.val and q.val, go to right side. If node.val is greater than both p.val and q.val, 
    // //go to the left side. If node.val is in between p.val and q.val, return node.
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            

    //     if(p.val < root.val && q.val < root.val){
    //         return lowestCommonAncestor(root.left, p, q);
    //     }
    //     else if(p.val > root.val && q.val > root.val){
    //         return lowestCommonAncestor(root.right, p, q);
 
    //     }
    //     // else //in case of root.val == q.val || root.val == p.val || (root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)
    //     return root;

    // }

    

/////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    // //intuition 1: If p.val(2) < node.val(6) and node.val(6) < q.val(8). The node element is the lowest
    // //common ancestor because after that there will be a split of nodes and the ancesotrs will change.

    // //If we find a node.val == p.val or node.val == q.val. In that case, the node is the lowest common
    // //ancestor because that is the lowest we can go
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
    //     if(root.val == q.val || root.val == p.val){
    //         return root;
    //     }

    //     if((root.val > p.val && root.val < q.val) || (root.val > q.val && root.val < p.val)){
    //         return root;
    //     }

    //     if(p.val < root.val && q.val < root.val){
    //         return lowestCommonAncestor(root.left, p, q);
    //     }
    //     else if(p.val > root.val && q.val > root.val){
    //         return lowestCommonAncestor(root.right, p, q);
 
    //     }
    //     return root;

    // }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    




    ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    // TreeNode ans = null;
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //    traverse(root, p, q);
    //    return ans;
    // }

    // public void traverse(TreeNode root, TreeNode p, TreeNode q){
    //     if(p.val < root.val && q.val < root.val){
    //         traverse(root.left, p, q);
    //     }
    //     else if(p.val > root.val && q.val > root.val){
    //         traverse(root.right, p, q);
    //     }
    //     else{ // in the scenario where p.val = root.val || q.val == root.val || (p.val < root.val && q.val > root.val)
    //         ans = root;
    //         return;
    //     }
    // }

}