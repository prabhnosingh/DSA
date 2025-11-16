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

    //Re-solving on 16 Nov 2025:

    //intution 1 (recursive): There will be three scenarios:
        //p and q exist in different subtrees starting from root -> In this case return root
        
        //both p and q exist in left subtree starting from root -> In this case return whatever is 
        //encountered first out of p and q 

        //and, both p and q exist in right subtree starting from root -> In this case return whatever
        //is encountered first out of p and q

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p , q);

        if(leftLCA != null && rightLCA != null){
            return root;
        }
        if(leftLCA == null){
            return rightLCA;
        }

        if(rightLCA == null){
            return leftLCA;
        }
        return null;
    }


















































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 09 Nov 2025:
    // //intution 1: Look recursively in lst and rst of root for both p and q. If p or q is encountered in any of the subtree, return
    // //p or q, else return null. Now there will be below scenarios:
    //     //both lst and rst return non-null. this means that both lst and rst have p or q in them. In this case lca is root.
    //     //lst is null and rst is not null, in this case lca is value returned by rst
    //     //lst is not null and rst is null, in this case lca is value returned by lst

    // //TC: O(n) where n is no. of nodes : Each node in the binary tree is visited once in the recursion
    // //SC: O(h) where h is the height of the tree: In worst case (a skewed tree), h = n. 
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     //base case
    //     if(root == null){
    //         return null;
    //     }

    //     if(root == p || root == q){
    //         return root;
    //     }

    //     TreeNode lstLCA = lowestCommonAncestor(root.left, p, q);
    //     TreeNode rstLCA = lowestCommonAncestor(root.right, p, q);

    //     if(lstLCA != null && rstLCA != null){
    //         return root;
    //     }

    //     else if(lstLCA != null){
    //         return lstLCA;
    //     }
        
    //     else if(rstLCA != null){
    //         return rstLCA;
    //     }

    //     return null; //to cover the case when boht lstLCA and rstLCA are null. This could happen in a subtree of a subtree....

    // }
























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intution 1: Look if node.val == p.val or node.val == q.val, in such case return node.
    // //Then go with left subtree and then right subtree. If both return non-null, then return root.
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     //base case
    //     if(root == null){
    //         return null;
    //     }
    //     //base case
    //     // if(root.val == p.val || root.val == q.val){
    //     //     return root;
    //     // }
    //     if(root == p || root == q){
    //         return root;
    //     }

    //     //hypothesis (recursive assumption)
    //     //assumes the recursion correctly finds LCA of p and q in the left and right subtrees
    //     TreeNode leftAncestor = lowestCommonAncestor(root.left, p, q);
    //     TreeNode rightAncestor = lowestCommonAncestor(root.right, p, q); 

    //     //induction (combining logic)
    //     if(leftAncestor != null && rightAncestor != null){ //this condition is when there was one
    //     //number (from p and q) found on either side (left or right) of the tree.
    //         return root;
    //     }
    //     //when one of the ancestor's is null
    //     else if(leftAncestor != null){
    //         return leftAncestor;
    //     }
    //     else if(rightAncestor != null){
    //         return rightAncestor;
    //     }
    //     //the control will come here when both rightAncestor and leftAncestor are null.  
    //     return null;
    // }
}