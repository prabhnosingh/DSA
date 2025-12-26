class Solution {
    //Solving on 26 Dec 2025:

    //intuition 1: (DP on Sum pattern: 0/1 Knapsack(subset sum))
        //For any two subsets to have equal sum, they must have a sum = totalSum / 2
        //So we calculate sum = totalSum / 2 and then iterate over the array. Now for every num
            //we have two choices: Either to pick the number or not pick the number.

        //"Partition into two equal subsets is equivalent to finding one subset whose sum is totalSum/2"
        //"We reduce teh problem to checking whether a subset with sum totalSum/2 exists using 0/1
            //knapsack DP, where each number is either taken or skipped exactly once"
 
    public boolean canPartition(int[] nums) {
        //d[i] reperesents whether we can form a sum 'i' using some of the numbers processed so far (true/false)
        
        // int totalSum = 0;

        // for(int num : nums){
        //     totalSum += num;
        // }

        int totalSum = Arrays.stream(nums).sum();

        if(totalSum % 2 != 0){
            return false;
        }

        int targetSum = totalSum / 2;

        boolean[] dp = new boolean[targetSum + 1];

        //base case
        dp[0] = true;

        for(int num : nums){
            if(num > targetSum) return false; //if a single num is greater than targetSum, it is not possible to divide
                //the full array in two subsets of equal sum
            for(int sum = targetSum; sum >= num; sum --){ 
                if(dp[sum]){ //if a sum already exists, i.e., dp[sum] is already true, skip adding the current number (num)
                    continue;
                }
                if(dp[sum - num]){ //if a complement of sum (sum - num) exists, then consider adding the current number (num).
                    //By doing so, we mark that we can form a sum of 'sum' by adding num to the numbers encountered so far
                    dp[sum] = true;
                }
                if(dp[targetSum]){ //if a sum equal to target has been acheived return true
                    return true;
                }
            }
        }

        return false;

    }
}