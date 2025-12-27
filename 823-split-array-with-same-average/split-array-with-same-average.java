class Solution {

    //Solving on 26 Dec 2025:

    //intuition 1 (brainstorming): (Dp: DP on sums: 1/0 Knapsack pattern (subset sum)) 
        //Any two arrays that have an equal average, will have same average as the parent array.
        //So the problem reduces to finding a sub array (subset) that constitutes to the average of 
            //parent array.
        //But average can be a floating point number, how can we store any dp state for average
        //We need to convert average to  int value some how
        //We can compute the sum with given numbers and just calculate the average on the fly and see
            //if it matches with average of parent array. If we find sum for that we just return true;
        //Should we store averages in the dp array cells?

    //intuition 2: (DP: DP on sums: 1/0 Knapsack pattern (subset sum)): First fixing subset size and then
        //finding if subsetSum exists
        //Any two arrays that have an equal average, will have same average as the parent array.
        //So the problem reduces to finding a sub array (subset) that constitutes to the average of
            //parent array.
        //Now this means that subsetSum/subsetSize = totalSum/numSize
        //Solving this equation, it becomes subsetSum x numSize = totalSum x subsetSize
        //Now the problem reduces to finding a subset that has subsetSum = (totalSum x subsetSize) / numSize
            //In this equation we already have totalSum and numSize. subsetSum is just another variable that
                //we use in our dp matrix like other 0/1 knapsack problems. The numSize is the main thing
                //that we should be focusing on.
            //We will first find which subsetSizes lead the equation (totalSum x subsetSize) % numSize == 0
            //This way if any subsetSize is not giving 0 as modulus of this equation we immediately discard it as
                //we know that subsetSum can only be an integer and not a decimal number.
            //If we find a subsetSize that satisfies this equation then our problem reduces to finding if there
                //exists a subset of exact subsetSize that can form a sum of subsetSum.

            //We define a dp array of type HashSet that tracks the set of sums that are possible for any number
                //of elements defined by index of dp array

            //Transition for each number num:
                //update counts backwards (0/1 choice, use each num once)
                //for each existing sum in dp[c-1], add sum + num into dp[c]

            //At the end, for any k (1..n-1) where divisible, check if:
                //targetSum(k) is in dp[k]
                        
                    

    public boolean splitArraySameAverage(int[] nums) {
        //"dp[count] = set of sums you can make using exactly count elements"

        int n = nums.length;
        int totalSum = Arrays.stream(nums).sum();

        // @SuppressWarnings("unchecked")
        HashSet<Integer>[] dp = new HashSet[n + 1];
        for (int i = 0; i <= n; i++) dp[i] = new HashSet<>();
        dp[0].add(0);

        for (int num : nums) {
            for (int c = n - 1; c >= 1; c--) {
                for (int s : dp[c - 1]) {
                    dp[c].add(s + num);
                }
            }
        }

        for (int k = 1; k <= n - 1; k++) {
            if ((totalSum * k) % n != 0) continue;
            int target = (totalSum * k) / n;
            if (dp[k].contains(target)) return true;
        }
        return false;

    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 26 Dec 2025:

    // //intuition 1 (brainstorming): (Dp: DP on sums: 1/0 Knapsack pattern (subset sum)) 
    //     //Any two arrays that have an equal average, will have same average as the parent array.
    //     //So the problem reduces to finding a sub array (subset) that constitutes to the average of 
    //         //parent array.
    //     //But average can be a floating point number, how can we store any dp state for average
    //     //We need to convert average to  int value some how
    //     //We can compute the sum with given numbers and just calculate the average on the fly and see
    //         //if it matches with average of parent array. If we find sum for that we just return true;
    //     //Should we store averages in the dp array cells?

    // //intuition 1: (DP: DP on sums: 1/0 Knapsack pattern (subset sum))
    //     //Any two arrays that have an equal average, will have same average as the parent array.
    //     //So the problem reduces to finding a sub array (subset) that constitutes to the average of
    //         //parent array.
    //     //Now this means that subsetSum/subsetSize = totalSum/numSize
    //     //Solving this equation, it becomes subsetSum x numSize = totalSum x subsetSize
    //     //Now the problem reduces to finding a subset that has subsetSum = (totalSum x subsetSize) / numSize
    //         //In this equation we already have totalSum and numSize. subsetSum is just another variable that
    //             //we use in our dp matrix like other 0/1 knapsack problems. The numSize is the main thing
    //             //that we should be focusing on.
    //         //We will be storing numSize as our dp states. numSize will represent the number of elements (from
    //             //nums array) required to sum up to a particular "subsetSum".
        
    //     //At any time we find our equation satisfying, we return true
    //     //In our dp matrix, we will have columns representing subsetSum and rows representing count of numbers
    //         //available to select from nums array.

    //     //Recurrence relation:
    //         //For any number in nums there are two choices, either we choose it to be part of subset or leave it:
    //             //i. If we choose it:
    //                 //The sub problem reduces to finding a dp state to find the count of numbers required to form
    //                     //a sum of j - nums[i-1] with a reduction of total avaialable numbers to i-1
    //                 //=> 1 (for choosing the currNum) + dp[i-1][j-nums[i-1]]
                
    //             //ii. If we do not choose it:
    //                 //The sub problem reduces to finding a dp state to find the count of numbers required to form
    //                     //a sum of j with a reduction of total available numbers to i-1
    //                 //=> dp[i-1][j]
            
    //         //We take the minimum of both these decisions -> why?
        
    //     //Base cases:
    //         //Given 0 numbers we can have 0 numbers to form 0 sum. Hence, dp[0][0] = 0
    //         //Given 0 numbers we can have infinite count of numbers to form a non-zero sum, hence first row from 
    //             //1 index is all +INF
    //         //Given non-zero numbers and we can choose 0 numbers to form a sum of 0, hence first col start from 
    //             //1 index is all 0

    // public boolean splitArraySameAverage(int[] nums) {
    //     //dp[i][j] represents count of numbers required from first i numbers from nums to form j sum   
    //     //dp[nums.length + 1][totalSum/2 + 1] will represent the count of numbers requried from nums to form
    //         //a subset sum of totalSum/2. totalSum/2 because any subset that has average equal to parent 
    //         //array cannot have a sum of greater than totalSum/2
    //         //can this be upto totalSum?

    //     int numsLen = nums.length;

    //     int totalSum = Arrays.stream(nums).sum();
        
    //     int rows = numsLen + 1;
    //     int cols = (totalSum/2) + 1;

    //     int[][] dp = new int[rows][cols];


    //     //base cases
    //     //0 numbers and 0 sum
    //     dp[0][0] = 0;

    //     //filling first row
    //     //0 numbers and non-zero sum
    //     for(int j = 1; j < cols; j ++){
    //         int i = 0;
    //         dp[i][j] = Integer.MAX_VALUE;
    //     }

    //     //filling first col
    //     //non-zero numbers and 0 sum
    //     for(int i = 1; i < rows; i ++){
    //         int j = 0;
    //         dp[i][j] = 0;
    //     }


    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
                
    //             int currNum = nums[i - 1];
    //             int choose = Integer.MAX_VALUE;
    //             if(j - currNum >= 0){ //we do not have a choice to choose this num, we will have to go with not choosing it
    //                 choose = 1 + dp[i-1][j-currNum];
    //             }

    //             int notChoose = dp[i-1][j];

    //             dp[i][j] = Math.min(choose, notChoose);

    //             if(dp[i][j] != Integer.MAX_VALUE){
    //                 // System.out.println((((double)totalSum * dp[i][j]) / numsLen));
    //                 if((j * numsLen) == (totalSum * dp[i][j])){
    //                     return true;
    //                 }
    //             }
    //         }
    //     }
        
    //     return false;



    // }
}