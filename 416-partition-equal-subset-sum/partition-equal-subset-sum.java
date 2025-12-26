class Solution {
    //Solving on 26 Dec 2025:

    //intuition 2 (2D DP): (DP on Sums pattern: 0/1 Knapsack(subset sum))
        //Forming two subsets that have equal sums, involves each subset having exact sum = totalSum / 2
        //Therefore, if totalSum is odd, return false
        //Now the problem reduces to finding a subset of numbers that sum up to totalSum / 2
        
        //Recurrence relation:
            //While forming a subset, we have two choices:
                //Pick the current number: If we pick the current number, it causes two actions.
                    //i. We cannot pick the same number ever again (because we can only choose a number once)
                        //=> i - 1 
                    //ii. Our current sum reduces by the value of number picked 
                        //=> j - nums[i-1]
                    
                    //This reduces our subproblem to finding a dp state to determine whether we can have a sum
                        //of j-nums[i-1] with first i-1 numbers from nums
                        //=> dp[i-1][j-nums[i-1]]
                
                //Not pick the current number: 
                    //If choose not to pick the current number then our available numbers reduce by 1.
                        //=> i-1
                    //And our sum remains unchanged
                        //=> j
                    
                    //This reduces our subproblem to finding a dp state to determine whether we can have a sum
                        //of j with first i-1 numbers from nums
                        //=> dp[i-1][j]
                
                //Now for any dp state dp[i][j], it will be possible to form a sum of j with first i numbers from 
                    //nums if either of the states from "choosing current number" or "not choosing current number" 
                    //gives true
                
            //Therefore, final recurrence is as follows:
            //=> dp[i][j] = dp[i-1][j] (not choosing the currNum) || dp[i-1][j-nums[i-1]] (choosing the currNum)
            
            //At any time if we get "j - nums[i-1]" < 0, then we can only go with not choosing the currNum as 
                //choosing the currNum will lead us to extra sum than required

            
        //Base cases:
            //Given 0 numbers, we can form 0 sum. Hence, dp[0][0] = true
            //Given 0 numbers, we can not form any non-zero sum. Hence, first row starting from col with 1
                // is all false
            //Given non-zero numbers, we can form a 0 sum by just choosing not to select any of the numbers.
                //Therefore, first col is all True



        
 
    public boolean canPartition(int[] nums) {
        //dp[i][j] represents whether we can compute a sum of j with first i numbers
        //dp[nums.length][totalSum/2] will represent whether we can compute a sum of totalSum/2 with all 
            //available nums
        //Therefore, we need a 2D DP matrix of size nums.length+1 x totalSum/2+1

        int totalSum = Arrays.stream(nums).sum();
        if(totalSum % 2 != 0){ //if totalSum is odd
            return false;
        }

        int rows = nums.length + 1;
        int cols = (totalSum/2) + 1;

        boolean[][] dp = new boolean[rows][cols];

        //base cases:
        
        //0 sum and 0 nums
        dp[0][0] = true;

        //filling first row: non-zero sum and 0 nums
        for(int j = 1; j < cols; j ++){
            int i = 0;
            dp[i][j] = false;
        }

        //filling first col: zero sum and non-zero nums
        for(int i = 1; i < rows; i ++){
            int j = 0;
            dp[i][j] = true;
        }


        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                int currNum = nums[i-1];
                boolean choose = false;
                boolean notChoose = false;
                
                if(j - currNum >= 0){ //we can choose the currNum
                    choose = dp[i-1][j - nums[i-1]];
                }

                notChoose = dp[i-1][j];

                dp[i][j] = choose || notChoose;
            }
        }

        return dp[rows-1][cols-1];

    }

























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 26 Dec 2025:

    // //intuition 1: (DP on Sums pattern: 0/1 Knapsack(subset sum))
    //     //For any two subsets to have equal sum, they must have a sum = totalSum / 2
    //     //So we calculate sum = totalSum / 2 and then iterate over the array. Now for every num
    //         //we have two choices: Either to pick the number or not pick the number.

    //     //"Partition into two equal subsets is equivalent to finding one subset whose sum is totalSum/2"
    //     //"We reduce the problem to checking whether a subset with sum totalSum/2 exists using '0/1
    //         //knapsack' DP, where each number is either taken or skipped exactly once"
    //         //Or, "From the given numbers, can I pick some of them to reach a target sum?"

    //     //Base case:    
    //         //We can compute 0 sum by choosing not to pick any number from nums. Hence, dp[0] = True
       
    //     //Recurrence relation:
    //         //
    //     //Eg: Input 1: nums = [1,5,11,5]
        
 
    // public boolean canPartition(int[] nums) {
    //     //d[i] reperesents whether we can form a sum 'i' using some of the numbers processed so far (true/false)
        
    //     // int totalSum = 0;

    //     // for(int num : nums){
    //     //     totalSum += num;
    //     // }

    //     int totalSum = Arrays.stream(nums).sum(); //slower than for loop but concise

    //     if(totalSum % 2 != 0){
    //         return false;
    //     }

    //     int targetSum = totalSum / 2;

    //     boolean[] dp = new boolean[targetSum + 1];

    //     //base case
    //     dp[0] = true;

    //     for(int num : nums){
    //         if(num > targetSum) return false; //if a single num is greater than targetSum, it is not possible to divide
    //             //the full array in two subsets of equal sum
    //         for(int sum = targetSum; sum >= num; sum --){ 
    //             if(dp[sum]){ //if a sum already exists, i.e., dp[sum] is already true, skip adding the current number (num)
    //                 continue;
    //             }
    //             if(dp[sum - num]){ //if a complement of sum (sum - num) exists, then consider adding the current number (num).
    //                 //By doing so, we mark that we can form a sum of 'sum' by adding num to the numbers encountered so far
    //                 dp[sum] = true;
    //             }
    //             if(dp[targetSum]){ //if a sum equal to target has been acheived return true
    //                 return true;
    //             }
    //         }
    //     }

    //     return false;

    // }
}