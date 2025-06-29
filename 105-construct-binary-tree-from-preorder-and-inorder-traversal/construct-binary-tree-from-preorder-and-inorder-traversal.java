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
    // preorder -> root -> left -> right
    // inorder -> left -> root -> right
    // intuition 1: Start with preorder[0](master root). Find the index of master root in inorder.
    // Divide the array in two subarrays, now the left subArray will be left child and right subArray
    // will be right child. The length of these left and right subArrays (in inorder) will determine how we split 
    // preoder array 

    //************Optimize this*********************
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     if(preorder.length == 0 || inorder.length == 0){
    //         return null;
    //     }

    //     TreeNode root = new TreeNode(preorder[0]);

    //     //finding index of root in inorder array
    //     int mid = -1;
    //     for(int i = 0; i < inorder.length; i ++){
    //         if(inorder[i] == root.val){
    //             mid = i;
    //             break;
    //         }
    //     }

    //     int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid); // 0 to mid - 1(inclusive) is the left subtree
    //     int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1); // starting from 1 because there is 
    //     // root at '0' index
    //     root.left = buildTree(leftPreorder, leftInorder);

    //     int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
    //     int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);

    //     root.right = buildTree(rightPreorder, rightInorder);

    //     return root;
    // }









    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // inuition 2: use recursive approach to build left and right sub trees by dividing the arrays
    // public TreeNode buildTree(int[] preorder, int[] inorder){
    //     if(preorder.length == 0){
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(preorder[0]);

    //     int rootIdxInInorder = 0;
    //     for(int i = 0; i < inorder.length; i ++){
    //         if(preorder[0] == inorder[i]){
    //             rootIdxInInorder = i;
    //             break;
    //         }
    //     }

    //     int mid = rootIdxInInorder; //in inorder array, left of this index is the left subtree and right is right subtree
    //     int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
    //     int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid + 1);
    //     root.left = buildTree(leftPreorder, leftInorder);

    //     int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
    //     int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
    //     root.right = buildTree(rightPreorder, rightInorder);

    //     return root;
    // }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////
    // // inuition 3(hashmap): use recursive approach to build left and right sub trees by dividing the arrays. Use HashMap to \
    // //find the index of root(preorder[0])
    // public TreeNode buildTree(int[] preorder, int[] inorder){
    //     if(preorder.length == 0){
    //         return null;
    //     }
    //     TreeNode root = new TreeNode(preorder[0]);
    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     for(int i = 0; i < inorder.length; i ++){
    //         map.put(inorder[i], i);
    //     }
    //     int rootIdxInInorder = map.get(preorder[0]);

    //     int mid = rootIdxInInorder; //in inorder array, left of this index is the left subtree and right is right subtree
    //     int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
    //     int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid + 1);
    //     root.left = buildTree(leftPreorder, leftInorder);

    //     int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
    //     int[] rightInorder = Arrays.copyOfRange(inorder, mid + 1, preorder.length);
    //     root.right = buildTree(rightPreorder, rightInorder);

    //     return root;
    // }    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //95% beat but can still be optimized -> without using hasmap
    
    // inuition 4(hashmap): use recursive approach with helper function and hashmap to store inorder indexes but only once.
    // use start and end to determine if have reached extremes of a particular a subtree and return null.
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int preOrderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder){
        // map = new HashMap<>();
        // preOrderIndex = 0;
        for(int i = 0; i < inorder.length; i ++){
            map.put(inorder[i], i);
        }

        return build(preorder, 0, preorder.length - 1);
    }

    private TreeNode build(int[] preorder, int start, int end){
        if(start > end){ // start becomes greater than end when there are no more children to add to the root
            return null;
        }

        int rootVal = preorder[preOrderIndex ++];
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = build(preorder, start, mid - 1);//When you are specifying the start and end for recursive calls, set them 
        //like you are splitting inorder array which is in left -> root -> right format 
        root.right = build(preorder, mid + 1, end);
        return root;
    }

}




// Basically find the pattern and try to solve a single problem, like assume that there are only 3 nodes 
// (root, root.left and root.right) and then try to come up with a recursive solution.
// Just solve a subproblem and the rest will be taken care of recursion





