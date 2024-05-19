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

    int maxSum = Integer.MIN_VALUE;
    // int maxSum = 0;
    public int maxPathSum(TreeNode root) {

        maxPathCal(root, maxSum);
        return maxSum;
    }

    public int maxPathCal(TreeNode root, int currMaxSum){

        if(root == null){
            return 0;
        }


        int leftSum = maxPathCal(root.left, currMaxSum);
        int rightSum = maxPathCal(root.right, currMaxSum);


        int maxLeftRightZero = Math.max(Math.max(leftSum, rightSum), 0);
        currMaxSum = maxLeftRightZero + root.val;

        if(currMaxSum > maxSum){
            maxSum = currMaxSum;
        }


        int sumWithSplit = leftSum + rightSum + root.val;
        if(sumWithSplit > maxSum){
            maxSum = sumWithSplit;
        }

       
        return currMaxSum;
    }
}







































 // 73/96 testcases passed

//     int maxSum = Integer.MIN_VALUE;
//     // int maxSum = 0;
//     public int maxPathSum(TreeNode root) {
//         // if(root.val > max){
//         //     maxSum = root.val;
//         // }
//         // int maxSum = 0;
//         maxPathCal(root, maxSum);
//         return maxSum;
//     }

//     public int maxPathCal(TreeNode root, int currMaxSum){

//         if(root == null){
//             return 0;
//         }


//         int leftSum = maxPathCal(root.left, currMaxSum);
//         int rightSum = maxPathCal(root.right, currMaxSum);


//         if(currMaxSum > currMaxSum + root.val){
//             if(maxSum < currMaxSum + root.val){
//                 maxSum = currMaxSum + root.val;
//             }
//             currMaxSum = currMaxSum + root.val;
//         }

//         if(root.val > currMaxSum){
//             if(maxSum < root.val){
//                 maxSum = root.val;
//             }
//             currMaxSum = root.val;
//         }
        
//         if(leftSum + rightSum + root.val > currMaxSum){
//             if(maxSum < leftSum + rightSum + root.val){
//                 maxSum = leftSum + rightSum + root.val;
//             }
//             currMaxSum =  leftSum + rightSum + root.val;
//         }

//         if(leftSum + root.val > currMaxSum){
//             if(maxSum < leftSum + root.val){
//                 maxSum = leftSum + root.val;
//             }
//             currMaxSum =  leftSum + root.val;
//         }
//         if(rightSum + root.val > currMaxSum){
//             if(maxSum < rightSum + root.val){
//                 maxSum = rightSum + root.val;
//             }
//             currMaxSum = rightSum + root.val;
//         }
     
//         // if(currMaxSum > maxSum){
//         //     maxSum = currMaxSum;
//         // }

//         return currMaxSum;
//     }
// }