class Solution {

    //Solving on 02 Sept 2026

    //intuition 2: Bottom up tabulation approach
        //topic: DP
        //pattern: 1D DP
        //sub-pattern: Pick/Not pick

    //we observe that the ordering of the numbers does not matter

    //Why DP?
        //1. We need to find maximum of something
        //2. We need to make decisions on which numbers to take optimally and each decision
            //may influence future decisions. So we need to track all the states

    //dp invariant
        //dp[i] represents maximum points being able to retrieve from an array with 
            //numbers of value between [0....i]
        
        //dp[n] will represent maximum points being able to retrieve from an array with 
            //numbers of value between [0....n] where n is the max number in nums

        //therefore we need a dp array of size of dp[maxNum + 1]

    //recurrence relation:
        //option 1: if we choose number i to delete and earn then in our scenario we cannot earn 
            //anymore from i-1 and i+1, and since i+1 is not in consideration as we only checking 
            //up and until i for any given state, we only exclude i-1 state
        //option 2: if we choose to not choose the number i and instead choose i-1

        //therefore, a state of dp[i] = Math.max(dp[i-1], dp[i-2] + rewards for i)


        
    //base case:
        //for dp[0] = 0
        //for dp[1] = 0 if 1 not in nums or rewards for n

    
    //algorithm:
        //Since removing 1 occurence of number n will automatically remove n-1 and n+1 
        //so technically we can remove all the occurences of n and count it towards total points
            //all at once while making sure we do not choose n-1 and n+1
        
        //we can do so by having a hashmap where we store the points (n x freq of n) against 
            //each n
        
        //since we need smaller substates to achieve bigger state, we will traverse from left to right
            //to fill dp array
        


    
        //TC: O(maxNum)

    public int deleteAndEarn(int[] nums) {
        
        HashMap<Integer, Integer> rewardsMap = new HashMap<>();
        // Arrays.sort(nums);
        int maxNum = 0;

        for(int i = 0; i < nums.length; i ++){
            if(!rewardsMap.containsKey(nums[i])){
                rewardsMap.put(nums[i], 0);
            }

            rewardsMap.put(nums[i], rewardsMap.get(nums[i]) + nums[i]);

            maxNum = Math.max(maxNum, nums[i]);
        }

        int[] dp = new int[maxNum + 1];

        //base cases
        dp[0] = 0;
        dp[1] = rewardsMap.getOrDefault(1, 0);

        for(int i = 2; i < maxNum + 1; i ++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + rewardsMap.getOrDefault(i, 0));
        }



        return dp[maxNum];        


    }

   




///////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 02 Sept 2026

    // //intuition 1: Top down recursion approach with memoization
    //     //topic: DP
    //     //pattern: 1D DP
    //     //sub-pattern: Pick/Not pick

    // //we observe that the ordering of the numbers does not matter

    // //Why DP?
    //     //1. We need to find maximum of something
    //     //2. We need to make decisions on which numbers to take optimally and each decision
    //         //may influence future decisions. So we need to track all the states

    // //dp invariant
    //     //maxPoints(n) represents maximum points being able to retrieve from an array with 
    //         //numbers of value between [0....n]

    // //recurrence relation:
    //     //option 1: if we choose number n to delete and earn then in our scenario we cannot earn 
    //         //anymore from n-1 and n+1, and since n+1 is not in consideration as we only checking 
    //         //up and until n for any given state, we only exclude n-1 state
    //     //option 2: if we choose to not choose the number n and instead choose n-1

    //     //therefore, a state of maxPoints(n) depends on max(maxPoints(n-2) + reward (n*freq 
    //         //of n), maxPoints(n-1))

    //     //we also know that the states in recursion can be repeated, therefore, we can cache
    //         //them by storing the calculated values in a hashmap
        
    // //base case:
    //     //for maxPoints(0) we will have 0
    //     //for maxPoints(1) we will have 1 * freq of 1

    
    // //algorithm:
    //     //Since removing 1 occurence of number n will automatically remove n-1 and n+1 
    //     //so technically we can remove all the occurences of n and count it towards total points
    //         //all at once while making sure we do not choose n-1 and n+1
        
    //     //we can do so by having a hashmap where we store the points (n x freq of n) against 
    //         //each n
        


    


    // public int deleteAndEarn(int[] nums) {
        
    //     HashMap<Integer, Integer> rewardsMap = new HashMap<>();
    //     HashMap<Integer, Integer> calculatedVals = new HashMap<>();
    //     // Arrays.sort(nums);
    //     int maxNum = 0;

    //     for(int i = 0; i < nums.length; i ++){
    //         if(!rewardsMap.containsKey(nums[i])){
    //             rewardsMap.put(nums[i], 0);
    //         }

    //         rewardsMap.put(nums[i], rewardsMap.get(nums[i]) + nums[i]);

    //         maxNum = Math.max(maxNum, nums[i]);
    //     }


    //     return maxPoints(nums, maxNum, rewardsMap, calculatedVals);        


    // }

    // //for finding max points able to get by considering all the values in nums between 0,n
    // private int maxPoints(int[] nums, int n, HashMap<Integer, Integer> rewardsMap,
    //     HashMap<Integer, Integer> calculatedVals){
            

    //         // if(!rewardsMap.containsKey(n)) return 0;
    //         //the above statement is invalid as we still need to consider the states
    //             //of n-1 and n-2 even when n is non existent

    //         if(n == 0) return 0;
    //         if(n == 1) return rewardsMap.getOrDefault(1, 0);

    //         if(calculatedVals.containsKey(n)) return calculatedVals.get(n);

    //         int pick = maxPoints(nums, n - 2, rewardsMap, calculatedVals) + 
    //             rewardsMap.getOrDefault(n, 0);
    //         int notPick = maxPoints(nums, n - 1, rewardsMap, calculatedVals);
 

    //         calculatedVals.put(n, Math.max(pick, notPick));
 
    //         return  calculatedVals.get(n); 

    // }
}