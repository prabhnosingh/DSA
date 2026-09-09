class Solution {

    //Solving on 08 Sept 2026

    //intuition 1:
        //The brute force way to solve would be to find all the increasing subsequences and
            //the find the number of subsequences that are of maximum length

            //this can be done via recursion where we have two options for any element, either
                //to include in the subsequence or to not to include in the subsequence
            //this will cost TC: O(2^n) SC: O(n) (recursive stack)

        
        //Probably optimization:
            //the problem talks about longest increasing subsequence
            //can be deploy LIS dp pattern here?

            //we can have a dp array where dp[i] indicates length of LIS ending at index i

            //Now we have two scenarios
                //1. multiple longest increasing subsequences end at same index
                //2. multiple longest increasing subsequences end at multiple different indices

            //for scenario 2 we should be fine, as we can just simply traverse over dp array to
                //find the number of LIS
            
            //for scenario 1 we need to find a way in which we can store multiple numbers to indicate
                //that multiple LISs are ending at a particular index

            //Can we make a dp array of array?
                //yes we can make a dp[][] in which dp[i] = [x,y] where x would mean the length of
                    //LIS and y would mean number of similar length LISs ending at index i 

            
            //Topic: DP
            //Pattern: 2D DP 
            //Sub-pattern: LIS

            //dp invariant:
                //dp[i][0] indicates the length of LIS ending at index i
                //dp[i][1] indicates the number of LISs ending at index i with length dp[i][0]

                //dp[n-1][0] will indicate the length of LIS ending at index n-1

                

                //therefore, we will need a dp array of size n x 2


            //recurrence relation:
                //each dp[i][0] state would depend on dp[j][0] when nums[j] < nums[i] such that
                    //dp[i][0] = 1 + dp[j][0]


            //base case:
                //dp[0][0] = 1


            //algorithm:
                //we can fill dp array:
                    //run a for loop for dp array from left to right and then a nested for loop 
                    //from i-1 till 0 from right to left to find the a state dp[j][0] (if any)
                    //such that nums[j] < nums[i]

                //each time we find same maxLength LIS being computed again for an index i
                    //we increment dp[i][1] by 1

                //we keep track of max length along the way

                //at last we traverse dp array and find the occurences of max length



    public int findNumberOfLIS(int[] nums) {
    
        int nLen = nums.length;
        if(nLen == 1) return 1;

        int[][] dp = new int[nLen][2];

        dp[0][0] = 1;
        dp[0][1] = 1;

        int maxLISLen = 1;

        for(int i = 1; i < nLen; i ++){
            int prevMax = 0;
            int count = 1;
            for(int j = i - 1; j >= 0; j --){
                
                if(nums[j] < nums[i]){
                    if(prevMax < dp[j][0]){
                        prevMax = dp[j][0];
                        count = dp[j][1]; //resetting count variable when a better length is found
                    }
                    else if(prevMax == dp[j][0]){
                        // count += 1; //we cannot simply do + 1 as we need to consider previous states
                            //count as well
                        count += dp[j][1];
                    }
                }    
            }

            dp[i][0] = 1 + prevMax;
            dp[i][1] = count;

            maxLISLen = Math.max(maxLISLen, dp[i][0]);

        }

        int LISCount = 0;
        for(int i = 0; i < nLen; i ++){
            if(dp[i][0] == maxLISLen) LISCount += dp[i][1];
        }

        return LISCount;



    }
}