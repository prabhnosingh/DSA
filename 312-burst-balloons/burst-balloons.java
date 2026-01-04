class Solution {
    //Solving on 03 Jan 2025:

    //intuition 1: (2D DP: Partition DP (interval) pattern)
        //Brute force way will be by trying all the combinations and then going down each branch 
            //and then trying all combinations and so on. TC: O(n^n);

        //DP way: We will be looking at which balloon gives max coins in total if it is popped at last as
            //only then its neighbors will be fixed

        //Recurrence relation:
            //Given an interval i, j:
                //If k is the balloon that is popped at last, then all other balloons in subarrays (i,k) and
                    //(k,j) are already gone. So when k bursts its neighbors are fixed, i.e. i and j
                    //Therefore, coins gained by bursting kth balloon with be => nums[i] + nums[k] + nums[j]

                //Plus the left side total coins, which is => dp[i][k] 
                //Plus the right side total coins, which is => dp[k][j]
                
                //Therefore, total coins gained by bursting kth ballon at last will be 
                    //=> nums[i] * nums[k] * nums[j] + dp[i][k] + dp[k][j]
                
                //now for the interval i, j we traverse for all the k indices and choose
                    //the maximum of all. dp[i][j] = Math.max(nums[i] * nums[k] * nums[j] + 
                    //dp[i][k] + dp[k][j]) for all k within i,j

        //Base case:
            //If there are no balloons between i and j, i.e. j = i + 1 or i = j + 1 (adjacent boundaries).
                //=> |i-j| = 1
            //This represents that the interval is empty, hence there are 0 coins earned

        //Filling dp array:
            //As dp[i][j] depends on smaller intervals dp[i][k] and dp[k][j], we must fill by increasing
                //interval length
            //In interval DP we fill all ranges of a fixed length. So we choose:
                //len = j - i (distance between boundaries)
                //pick a left boundary i
                //then the right boundary is forced:
                //j = i + len

        
    public int maxCoins(int[] nums) {
        //dp[i][j] represents maximum coins possible to collect by popping balloons within 
            //subarray starting from i index and ending at j index where i and j are not included
        //dp[0][nums.length + 1] will represent maximum coins possible to collect by popping 
            //all balloons within nums array.
        //Therefore, we need a 2D matrix of size nums.length+2 x nums.length+2
        
        //dp[i][j] = maximum coins obtainable by bursting all balloons strictly between i and j

        int[] numsNew = new int[nums.length + 2];
        for(int i = 0; i < nums.length + 2; i ++){
            if(i == 0 || i == nums.length + 1){
                numsNew[i] = 1; //adding 1 on both the boundaries 
                continue;
            }
            numsNew[i] = nums[i-1];
        }

        int[][] dp = new int[numsNew.length][numsNew.length];


        for(int len = 2; len < numsNew.length; len ++){ //starting from len = 2 as len = 1 would have given 
            //adjacent indices, which would have led to 0 coins
            for(int i = 0; i + len < numsNew.length; i ++){
                int j = i + len; //i = 0, len = 2, j = 2 => means 1 balloon to be popped between 0 and 2
                    //at index 1

                //now we have our interval's left and right boundaries. we now check for all k's between
                    //i and j

                for(int k = i + 1; k < j; k ++){
                    int kCoins = numsNew[i] * numsNew[k] * numsNew[j];
                    kCoins += dp[i][k] + dp[k][j];
                    dp[i][j] = Math.max(dp[i][j], kCoins);
                }


            }
        }

        return dp[0][nums.length + 1];













        
    }   
}