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

    //Re-Solving on 21 Nov 2025    
    
    //intuition 2 (prefix sum): Have a prefix sum hashmap that stores the complementatry sum till now
    //Have a helper function to traverse the tree
      
   
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixMap = new HashMap<>();

        prefixMap.put(0L, 1); //0 sum occurs with 1 frequency

        return traverseTree(root, targetSum, 0, prefixMap);
        
    }

    private int traverseTree(TreeNode root, int targetSum, long currSum, HashMap<Long, Integer> prefixMap){
        if(root == null) return 0;
        currSum += root.val;
        int countOfPrefixSum = 0;
        if(prefixMap.containsKey(currSum - targetSum)){
            countOfPrefixSum = prefixMap.get(currSum - targetSum);
        }
        prefixMap.put(currSum, prefixMap.getOrDefault(currSum, 0) + 1);

        countOfPrefixSum += traverseTree(root.left, targetSum, currSum, prefixMap);
        countOfPrefixSum += traverseTree(root.right, targetSum, currSum, prefixMap);

        prefixMap.put(currSum, prefixMap.get(currSum) - 1);
        return countOfPrefixSum;
    }


}





///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-Solving on 21 Nov 2025    
    
//     //intuition 2: prefix sum
    
//     //intuition 1: Have a helper function that can track currSum of the path being traversed
   
   
//     int ans = 0;
//     public int pathSum(TreeNode root, int targetSum) {
        
//         if(root == null){
//             return 0;
//         }

//         traverseTree(root, (long) targetSum);

//         pathSum(root.left, targetSum);
//         pathSum(root.right, targetSum);

//         return ans;
//     }

//     private void traverseTree(TreeNode root, long targetSum){
//         if(root == null){
//             return;
//         }

//         // currSum += root.val;

//         if(targetSum - root.val == 0){
//             ans += 1;
//         }
//         // else if(targetSum - root.val < 0){
//         //     return;
//         // }

//         traverseTree(root.left, targetSum - root.val);
//         traverseTree(root.right, targetSum - root.val);
//     }


// }























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 15 Nov 2025    
   
//     //intuition 3: Have hashMap named prefixMap that stores prefix sum during tree tarversal
//     //just like a prefix sum in array traversal. Have a helper function of type int. 
//     //In each recursive call:
//         //-Add the root to the current sum
//         //-Intialize count with number of times sum - target is encountered
//         //-Put sum into the hashmap while incrementing its frequency by 1
//         //-recursively call left and right children of the node and increment count with the 
//             //return value
//         //decrement the frequency of sum by 1 as the recursive calls for that sum have ended
//         //return count
   
   
    
//     public int pathSum(TreeNode root, int targetSum) {
//         HashMap<Long, Integer> prefixSumMap = new HashMap<>(); //sum -> frequency
//         prefixSumMap.put(0L, 1);

//         return dfsTraversal(root, targetSum, 0, prefixSumMap);    
//     }

//     private int dfsTraversal(TreeNode root, int targetSum, long currSum, HashMap<Long, Integer> prefixSumMap){
//         if(root == null) return 0;

//         currSum += root.val;

//         //if we already have encountered "someSum" that is equal to currSum - targetSum (currSum - "someSum" = targetSum),
//         //then that means recent additions to currSum indicate that we were able to find a sum that is equal to targetSum,
//         //and hence a new unique combination is found.
//         int countOfPrefixSum = prefixSumMap.getOrDefault(currSum - targetSum, 0);

//         prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

//         countOfPrefixSum += dfsTraversal(root.left, targetSum, currSum, prefixSumMap);
//         countOfPrefixSum += dfsTraversal(root.right, targetSum, currSum, prefixSumMap);

//         prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1); //decrementing currSum frequency to not consider
//         //the curreent currSum in some next iteration which could be in some other branch of the tree.
//         //Kind of backtracking

//         return countOfPrefixSum;
//     }

// }


//////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 14 Nov 2025:

//     //intuition 1 (did not work as expected): Have a helper function that takes each node 
//     //and return whether a path of sum equal to targetSum exists starting from that node.
//     //If yes return true 
//     //Count the number of trues and return the number
   
    
   
//     //intuition 2: Have a global variable targetSumCount to track the number of target sums
//     //achieved. Have a helper function that finds if target sum exists from a particular
//     //node, if yes increment to global targetSumCount
   
   
   
   
   
//     int targetSumCount = 0;
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null){
//             return 0;
//         }
       
//         doesTargetSumExist(root, targetSum, 0);

//         pathSum(root.left, targetSum);
//         pathSum(root.right, targetSum);

//         return targetSumCount;
//     }

//     private void doesTargetSumExist(TreeNode root, int targetSum, long currSum){
//         if(root == null){
//             return; 
//         }
//         // if(targetSum < currSum + root.val){ //pruning -> This does not work because of negative values
//         //     return;
//         // }

//         if(targetSum == currSum + root.val){ //currSum + root.val can go out of bounds of integer range
//         //therefore have currSum of long type
//             // System.out.println(root.val);
//             targetSumCount += 1;
//             // return; //this statement skips the scenarios where the next elements are zeroes and will
//             //contribute to targetSumCount uniquely
//         }
        

//         doesTargetSumExist(root.left, targetSum, currSum + root.val);
//         doesTargetSumExist(root.right, targetSum, currSum + root.val);
//     }

// }

//////////////////////////////////////////////////////////////////////////////////////////
//     /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
// class Solution {        

//     //Solving on 14 Nov 2025:

//     //intuition 1: Have a helper function that takes each node and return whether a path
//     //of sum equal to targetSum exists starting from that node. If yes return true
//     //Count the number of trues and return the number
//     int targetSumCount = 0;
//     public int pathSum(TreeNode root, int targetSum) {
//         if(root == null){
//             return 0;
//         }
        
//         targetSumCount += doesTargetSumExist(root, targetSum, 0, 0);
        
//         pathSum(root.left, targetSum);
//         pathSum(root.right, targetSum);

//         return targetSumCount;
//     }

//     private int doesTargetSumExist(TreeNode root, int targetSum, int currSum, int numberOfTargetSums){
//         if(root == null){
//             return numberOfTargetSums; 
//         }

//         if(targetSum == currSum + root.val){
//             numberOfTargetSums += 1;
//         }
//         //return true if either of the childs return true
//         return(doesTargetSumExist(root.left, targetSum, currSum + root.val, numberOfTargetSums) +
//         doesTargetSumExist(root.right, targetSum, currSum + root.val, numberOfTargetSums));
//     }
// }
