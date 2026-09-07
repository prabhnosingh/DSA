class Solution {

    //Re-solving on 06 Sept 2026


        
    //intuition 3: (Tabulation) - 1D
        //Topic: DP
        //Pattern: 1D DP
        //Sub-pattern: pick/not pick
        
        //the problem looks a DP problem because: why DP? 
            //1. we need to find the max of something
            //2. final optimal state depends on previous optimal choices of elements
            //3. the same subproblems are evaluated repeatedly, so memoization can avoid
                //recomputation

        //Tabulation (bottoms up approach):
            

            //dp invariant:
                //dp[i] signifies the length of longest LIS that ends at index i
                //dp[n-1] signifies the length of longest LIS that ends at index n-1

                //therefore, we need a dp array of size n

                //our answer will be max(all dp[i]) states
               

            //recurrence relation:
                //any state dp[i] depends on previous states from i-1 till 0
                //the previous states can be any between dp[i-1] and dp[0] 
                //but we will choose the maximum of these in order to maximize 
                    //the length of LIS 

                //dp[i] = 1 + max(dp[i-1 ..... 0])
                

            //base case:
                //dp[0] = 1
            
                               
            //algorithm:
                //run a for loop from 0 to n-1 to fill the dp array
                //run a nested for loop from i - 1 till 0 to find the max previous state
                    //from dp array 
                    

    

            //TC:  O(n^2) 
            //SC: O(n)


        // Recursion to Tabulation
            //1. Base cases dp[n][anything] = 0
            //2. Write changing parameters (idx, prevIdx)    
                //idx = n-1 -> 0
                //prevIdx = idx-1 -> -1
            //3. Copy the recurrence

        
        //Printing the LIS
            //Have prevArr integer array of length nLen to store the index of previous 
                //numbers in the LIS
            //fill this prevArr everytime you encounter a number larger than the nums[i]
                //which has more length than prevMax
            //then at last, backtrack from the index of max of dp[i] and stop at index idx
                //when prev[idx] = idx



    public int lengthOfLIS(int[] nums) {
        
        int nLen = nums.length;
        if(nLen == 1) return 1;
        int[] dp = new int[nLen];

        int[] prevIdx = new int[nLen];

        int maxLen = 0;
        int maxIdx = 0;

        dp[0] = 1;

        for(int i = 1; i < nLen; i ++){
            int prevMax = 0;
            prevIdx[i] = i;
            for(int j = i - 1; j >= 0; j --){
                if(nums[i] > nums[j] && prevMax < dp[j]){
                    prevMax = dp[j];
                    prevIdx[i] = j; 
                }
            }

            dp[i] = 1 + prevMax;
            maxLen = Math.max(maxLen, dp[i]);
            maxIdx = Math.max(maxIdx, i);
        }

        String LIS = "";
        int idx = maxIdx;
        while(idx >= 0){
            LIS += nums[idx] + ", "; 
            if(prevIdx[idx] == idx) break;
            idx = prevIdx[idx];
        }

        System.out.println(LIS);

        // return dp[nLen - 1];
        return maxLen;
    }


















//////////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 06 Sept 2026


        
    // //intuition 2: (Tabulation) - space optimized
    //     //Topic: DP
    //     //Pattern: 2D DP
    //     //Sub-pattern: pick/not pick
        
    //     //the problem looks a DP problem because: why DP? 
    //         //1. we need to find the max of something
    //         //2. final optimal state depends on previous optimal choices of elements
    //         //3. the same subproblems are evaluated repeatedly, so memoization can avoid
    //             //recomputation

    //     //Tabulation (bottoms up approach):
            

    //         //dp invariant:
    //             //dp[idx][prevIdx + 1] represents maximum LIS length obtainable from indices
    //                 //idx....n-1, where prevIdx is the index of the last element already included 
    //                 //the subsequence

    //             //dp[0][0] will represent maximum length of LIS possible while choosing
    //                 //from 0...n-1 elments with no previous index (as prevIdx will be -1 
    //                 //in this case)

    //             //dp can go until n-1 and n state -> n for adjusting -1
    //             //therefore, we need a 2D dp array of size n x n+1

               

    //         //recurrence relation:
    //             //at each state we have two options
    //                 //either to pick the number at index i 
    //                     //pick = 1 + dp[idx+1][i]
                    
    //                 //or to not pick the number at index i
    //                     //notPick = 0 + dp[idx + 1][idx + 1]
    //                     //recursion -> recurse(idx + 1, idx)
    //                         //and since dp column stores prevIdx + 1
                
    //             //we take the max of both for current state of dp[i][j]

    //         //base case:
    //             //dp[nLen][anything] = 0; -> means maximum LIS length obtainable from nLen...nLen-1
    //                 //with previous number of LIS as anything is 0 as there is no number at 
    //                 //nLen
    //             //but java automatically intializes the last row as 0
                
                
    //         //algorithm:
    //             //run two for loops 
    //                 //one for currIdx from n-1 till 0
    //                 //and, another one for prevIdx from n-1 till -1
    //             //we run the for loops backward as we need forward states for 
    //                 //the current states
                    

    

    //         //TC: O(n^2)
    //         //SC: O(n x 2)


    //     // Recursion to Tabulation
    //         //1. Base cases dp[n][anything] = 0
    //         //2. Write changing parameters (idx, prevIdx)    
    //             //idx = n-1 -> 0
    //             //prevIdx = idx-1 -> -1
    //         //3. Copy the recurrence



    // public int lengthOfLIS(int[] nums) {

    //     if(nums.length == 1) return 1;
    //     int nLen = nums.length;

    //     //we can space optimize as to compute any state dp[idx] we only need next row
    //     int[] dpCurr = new int[nLen+1];
    //     int[] dpNext = new int[nLen+1];

    //     for(int idx = nLen - 1; idx >= 0; idx --){
    //         for(int prevIdx = idx - 1; prevIdx >= - 1; prevIdx --){ 
    //             int notPick = 0 + dpNext[prevIdx + 1];
                
    //             int pick = 0;
    //             if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
    //                 pick = 1 + dpNext[idx + 1];
    //             }

    //             dpCurr[prevIdx + 1] = Math.max(pick, notPick);
    //         }
    //         dpNext = dpCurr;
    //     }

    //     return dpCurr[0];

    
    // }



//////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 06 Sept 2026


        
//     //intuition 2: (Tabulation)
//         //Topic: DP
//         //Pattern: 2D DP
//         //Sub-pattern: pick/not pick
        
//         //the problem looks a DP problem because: why DP? 
//             //1. we need to find the max of something
//             //2. final optimal state depends on previous optimal choices of elements
//             //3. the same subproblems are evaluated repeatedly, so memoization can avoid
//                 //recomputation

//         //Tabulation (bottoms up approach):
            

//             //dp invariant:
//                 //dp[idx][prevIdx + 1] represents maximum LIS length obtainable from indices
//                     //idx....n-1, where prevIdx is the index of the last element already included 
//                     //the subsequence

//                 //dp[0][0] will represent maximum length of LIS possible while choosing
//                     //from 0...n-1 elments with no previous index (as prevIdx will be -1 
//                     //in this case)

//                 //dp can go until n-1 and n state -> n for adjusting -1
//                 //therefore, we need a 2D dp array of size n x n+1

               

//             //recurrence relation:
//                 //at each state we have two options
//                     //either to pick the number at index i 
//                         //pick = 1 + dp[idx+1][i]
                    
//                     //or to not pick the number at index i
//                         //notPick = 0 + dp[idx + 1][idx + 1]
//                         //recursion -> recurse(idx + 1, idx)
//                             //and since dp column stores prevIdx + 1
                
//                 //we take the max of both for current state of dp[i][j]

//             //base case:
//                 //dp[nLen][anything] = 0; -> means maximum LIS length obtainable from nLen...nLen-1
//                     //with previous number of LIS as anything is 0 as there is no number at 
//                     //nLen
//                 //but java automatically intializes the last row as 0
                
                
//             //algorithm:
//                 //run two for loops 
//                     //one for currIdx from n-1 till 0
//                     //and, another one for prevIdx from n-1 till -1
//                 //we run the for loops backward as we need forward states for 
//                     //the current states
                    

    

//             //TC: O(n^2)
//             //SC: O(n^2)


//         // Recursion to Tabulation
//             //1. Base cases dp[n][anything] = 0
//             //2. Write changing parameters (idx, prevIdx)    
//                 //idx = n-1 -> 0
//                 //prevIdx = idx-1 -> -1
//             //3. Copy the recurrence



//     public int lengthOfLIS(int[] nums) {

//         if(nums.length == 1) return 1;
//         int nLen = nums.length;

//         int[][] dp = new int[nLen+1][nLen+1];

//         for(int idx = nLen - 1; idx >= 0; idx --){
//             for(int prevIdx = idx - 1; prevIdx >= - 1; prevIdx --){ 
//                 int notPick = 0 + dp[idx + 1][prevIdx + 1];
                
//                 int pick = 0;
//                 if(prevIdx == -1 || nums[idx] > nums[prevIdx]){
//                     pick = 1 + dp[idx + 1][idx + 1];
//                 }

//                 dp[idx][prevIdx + 1] = Math.max(pick, notPick);
//             }
//         }

//         return dp[0][-1+1];

    
//     }



// //////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 06 Sept 2026

    // //intuition 1: Recursion (top down approach) 
    //     //Topic: DP
    //     //Pattern: 2D DP
    //     //Sub-pattern: pick/not pick

    //     //brute force:
    //         //brute force way would be to try all the subsequences and find the lengths which is
    //             //roughly TC: O(2^n) SC: O(mn)

        
    //     //the problem looks a DP problem because: why DP? 
    //         //1. we need to find the max of something
    //         //2. final optimal state depends on previous optimal choices of elements
    //         //3. the same subproblems are evaluated repeatedly, so memoization can avoid
    //             //recomputation

    //     //Recursion with memoization (top-down approach):
    //         //if we select a number at index i as the starting of a subsequence then the next 
    //             //number that can be choosen depends on the number at index i, so we need to 
    //             //track prev index as well

    //         //dp invariant:
    //             //recurse(currIdx, prevIdx) represents the maximum LIS length obtainable from
    //                 //indices currIdx...n-1, where prevIdx is the index of the last element
    //                 //already included in the subsequence.
               

    //         //recurrence relation:
    //             //at any index i we have two options:
    //                 //option 1: take the number at index i as part of the subsequence given that 
    //                     //it is greater than the prevIdx
                        
    //                     //In this case the LIS length increases by 1 and prevIdx updates to
    //                         //currIdx and currIdx increases by 1

    //                     //1 + recurse(currIdx + 1, currIdx)

    //                 //option 2: do not take the number at index i as part of the subsequence 

    //                     //In this case the LIS length remains the same (increases by 0) and
    //                         //prevIdx remains the same while currIdx increases by 1

    //                     //0 + recurse(currIdx + 1, prevIdx)

    //             //we can store the results computed in a hashmap with key as "currIdx + prevIdx"
    //             //TLE optimization: We can use a 2D matrix to store the computed values, instead
    //                 //of a hashmap

                
    //             //recurse(0, -1) will represent max LIS length obtainable from indices 
    //                 //0...n-1 with no previous index

    //         //base case:
    //             //if(currIdx == nums.length) return 0
                                           

    //         //LEARNING:
    //             //"Everything that can affect the future answer must be represented in the
    //                 //memoization state"

    //         //TC: O(n^2) we have currIdx x prevIdx states and each state does O(1) work
    //         //SC: O(n^2) memo + O(n) recursion stack = O(n^2)



    // public int lengthOfLIS(int[] nums) {

    //     if(nums.length == 1) return 1;
    //     int nLen = nums.length;

    //     // HashMap<String, Integer> computedLens = new HashMap<>();
    //     int[][] computedLens = new int[nLen][nLen + 1]; //nLen + 1 to accommodate -1 prevIdx 

    //     return recurse(nums, 0, -1, computedLens);
        
    //     // int ans = 0;
    //     // for(int i = 0; i < nLen; i ++){
    //     //     for(int j = 0; j < nLen + 1; j ++){
    //     //         ans = Math.max(ans, computedLens[i][j]);
    //     //     }
    //     // }
        
    //     // return ans;

    // }

    // private int recurse(int[] nums, int currIdx, int prevIdx, int[][] computedLens){ 

    //     if(currIdx == nums.length) return 0;
        
    //     // String key = currIdx + "" + prevIdx;

    //     if(computedLens[currIdx][prevIdx + 1] != 0) return computedLens[currIdx][prevIdx + 1];

    //     //pick
    //     int pick = 0;
    //     if(prevIdx == -1 || nums[currIdx] > nums[prevIdx]){ //only pick when either condition 
    //         //passes
    //         pick = 1 + recurse(nums, currIdx + 1, currIdx, computedLens);
    //     }

    //     //notPick
    //     int notPick = 0 + recurse(nums, currIdx + 1, prevIdx, computedLens);

    //     // computedLens.put(key, Math.max(pick, notPick));
    //     computedLens[currIdx][prevIdx + 1] = Math.max(pick, notPick);


    //     return  Math.max(pick, notPick);
    // }

























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 16 Feb 2026
   
//     //intuition 1 (brainstorming): 
//         //dp LIS array -> finding lower / upper bound with binary search 
//         //comparing last entry of LIS array with current traversal entry of nums and updating
//         //last bound found
//         //applying binary search on top of LIS array

//         // replacing the current traversing element with the lower bound in dpLIS array
//         //at last length of dpLIS array is the anwser
//         //lower bound is first greater element than the element being compared
        

//     //intuition 1: DP : 1D DP (LIS)
//         //Have a dpLIS int array to track the length of the increasing sequence
//         //Traverse nums array and find the lower bound (first greater than equal)
//             //of current element in dpLIS. 
//         //If there is no lower bound of currNum in dpLIS, append currNum to dpLIS at last and
//             //increase dpLIS length by 1
//         //At last return length of dpLIS

//     public int lengthOfLIS(int[] nums) {
        
//         int numsLen = nums.length;
//         int[] dpLIS = new int[numsLen];
//         dpLIS[0] = nums[0];

//         int dpLISLen = 1;
//         for(int i = 1; i < numsLen; i ++){
//             int currNum = nums[i];
//             // System.out.println(currNum);
//             int lowerBoundIdx = findLowerBoundInDpLIS(dpLIS, currNum, dpLISLen);
//             // System.out.println("lowerBoundIdx :" + lowerBoundIdx);
//             if(lowerBoundIdx == -1){ //no lower bound found
//                 //add currNum to dpLIS and increase dpLISLen by 1
//                 dpLIS[dpLISLen] = currNum;
//                 dpLISLen += 1;
//             }
//             else{
//                 dpLIS[lowerBoundIdx] = currNum;
//             }


//         }
//         // for(int i : dpLIS){
//         //     System.out.println(i);

//         // }
//         return dpLISLen;
//     }

//     private int findLowerBoundInDpLIS(int[] dpLIS, int num, int currDpLISLen){
//         int start = 0; 
//         int end = currDpLISLen-1;

//         int mid = 0;

//         int probableLowerBoundIdx = -1;
//         while(start <= end){
//             mid = (end - start)/2 + start;

//             if(dpLIS[mid] > num){
//                 probableLowerBoundIdx = mid;
//                 end = mid - 1;
//             }
//             else if(dpLIS[mid] < num){ 
//                 start = mid + 1;
//             }
//             else{
//                 return mid;
//             }
//         }
//         return probableLowerBoundIdx;
//     }   

























// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 25 Dec 2025:

//     //intuition 2(storing LIS state): (1D: DP: DP on lengths: LIS pattern)
//         //We maintain a DP array that will store the longest increasing subsequence found till now 
//             //while traversing the nums array. For each number currNum in nums, we find if a lower
//             //bound (first element greater than equal to) of currNum exists in the dp array. If we 
//             //find a lower bound of currNum in dp array, we replace it with currNum. This is done in
//             //order to add more increasing numbers in the future. 
//             //"This helps us greedily keep future extension options open."

//             //“Replacing a larger tail with a smaller value does not change the length of the subsequence,
//                 //but increases the chance of extending it later.”
//         //We find the lower bound idx with binary search (logn)
//         //base case: if nums is of length 1, LIS is of length 1. Have dp[0] = nums[0]

//         //Storing the LIS state:
//             //Every time we find a lowerBoundIdx that is less than currLISLength - 2, we store the current state 
//                 //of dpLIS in a list of list and then update the dpLIS[lowerBoundIdx] to currNum. At last return
//                 //the first list with length of currLISLength; 

//     public int lengthOfLIS(int[] nums) {
//         //dpLIS[i] represent smallest tail possible of increasing subsequence of length i + 1
//         //Length of dpLIS at the end of the algo will give us longest increasing subsequence for nums array
//         //Longest possible subsequence can be of length nums.length.
//         //Therefore, we need a 1D dp array of length nums.length

//         int numsLen = nums.length;
//         int[] dpLIS = new int[numsLen]; 

//         //NEW ARRAYS
//         //parent[i] = index of previous element in LIS ending at i (lets us bactrack the sequence)
//         int[] parent = new int[numsLen];
//         //lisIndex: maps dpLIS positions to indices in nums 
//         int[] lisIndex = new int[numsLen];

//     Arrays.fill(parent, -1);

//         //base case
//         dpLIS[0] = nums[0];
//         lisIndex[0] = 0;

//         int currLISLength = 1;
//         for(int i = 1; i < numsLen; i ++){
//             int currNum = nums[i];
//             int lowerBoundIdxInDpLIS = findLowerBoundIdxInDpLIS(dpLIS, currNum, currLISLength);

//             if(lowerBoundIdxInDpLIS == -1){ //no lower bound found in dpLIS. Add currNum at last of dpLIS,
//                 //increasing its size by 1
//                 parent[i] = lisIndex[currLISLength - 1];
//                 dpLIS[currLISLength] = currNum;
//                 lisIndex[currLISLength] = i;
//                 currLISLength++;
//             }
//             else{
//                 dpLIS[lowerBoundIdxInDpLIS] = currNum;
//                 lisIndex[lowerBoundIdxInDpLIS] = i;

//                 if (lowerBoundIdxInDpLIS > 0) {
//                     parent[i] = lisIndex[lowerBoundIdxInDpLIS - 1];
//                 }
//             }
        
//         }

//         // 🔹 RECONSTRUCT LIS
//         LinkedList<Integer> lis = new LinkedList<>();
//         int idx = lisIndex[currLISLength - 1];

//         while (idx != -1) {
//             lis.addFirst(nums[idx]);
//             idx = parent[idx];
//         }

//         for(int i = 0;i < lis.size(); i ++){
//             System.out.print(lis.get(i) + ", ");
//         }


//         return currLISLength;
//     }

 
//     private int findLowerBoundIdxInDpLIS(int[] dpLIS, int currNum, int currLISLength){
//         int start = 0;
//         int end = currLISLength - 1;
//         int lowerBoundIdx = -1;
//         while(start <= end){
//             int mid = start + ((end - start) / 2);

//             if(dpLIS[mid] >= currNum){ //probable lower bound found
//                 lowerBoundIdx = mid;
//                 end = mid - 1; //we want the first largest number's idx and since dpLIS is sorted in ascending order
//                     //we move towards left to find the first largest number
//             }
//             else{
//                 start = mid + 1;
//             }
//         }

//         return lowerBoundIdx;

//     }

// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 25 Dec 2025:

    // //intuition 1: (1D: DP: DP on lengths: LIS pattern)
    //     //We maintain a DP array that will store the longest increasing subsequence found till now 
    //         //while traversing the nums array. For each number currNum in nums, we find if a lower
    //         //bound (first element greater than equal to) of currNum exists in the dp array. If we 
    //         //find a lower bound of currNum in dp array, we replace it with currNum. This is done in
    //         //order to add more increasing numbers in the future. 
    //         //"This helps us greedily keep future extension options open."

    //         //“Replacing a larger tail with a smaller value does not change the length of the subsequence,
    //             //but increases the chance of extending it later.”
    //     //We find the lower bound idx with binary search (logn)
    //     //base case: if nums is of length 1, LIS is of length 1. Have dp[0] = nums[0]

    //     //Storing the LIS state:
    //         //Every time we find a lowerBoundIdx that is less than currLISLength - 2, we store the current state 
    //             //of dpLIS in a list of list and then update the dpLIS[lowerBoundIdx] to currNum. At last return
    //             //the first list with length of currLISLength; 

    // public int lengthOfLIS(int[] nums) {
    //     //dpLIS[i] represent smallest tail possible of increasing subsequence of length i + 1
    //     //Length of dpLIS at the end of the algo will give us longest increasing subsequence for nums array
    //     //Longest possible subsequence can be of length nums.length.
    //     //Therefore, we need a 1D dp array of length nums.length

    //     int numsLen = nums.length;
    //     int[] dpLIS = new int[numsLen]; 

    //     // List<List<Integer>> diffLISStates = new ArrayList<>();

    //     //base case
    //     dpLIS[0] = nums[0];
    //     int maxLISLength = 0;
    //     int currLISLength = 1;
    //     for(int i = 1; i < numsLen; i ++){
    //         int currNum = nums[i];
    //         int lowerBoundIdxInDpLIS = findLowerBoundIdxInDpLIS(dpLIS, currNum, currLISLength);

    //         if(lowerBoundIdxInDpLIS == -1){ //no lower bound found in dpLIS. Add currNum at last of dpLIS,
    //             //increasing its size by 1
    //             dpLIS[currLISLength ++] = currNum;
    //             maxLISLength = Math.max(maxLISLength, currLISLength);
    //         }
    //         else{
    //             // //storing the state for later access of actual LIS -> "You cannot reconstruct or “store dp states” of the
    //                 //actual LIS by saving snapshots of dpLIS"
    //             // List<Integer> prevLISState = new ArrayList<>();
    //             // for(int b = 0; b < currLISLength; b ++){
    //             //     prevLISState.add(dpLIS[b]);
    //             // }
    //             // diffLISStates.add(prevLISState);

    //             // if(lowerBoundIdxInDpLIS < currLISLength - 2){//reducing the size of dpLIS for new subsequence
    //             //     currLISLength = lowerBoundIdxInDpLIS + 1;
    //             // }
    //             dpLIS[lowerBoundIdxInDpLIS] = currNum;
    //         }
        
    //     }

    //     for(List<Integer> LISState : diffLISStates){
    //         if(LISState.size() == currLISLength){
    //             System.out.println(LISState);
    //         }
    //     }

    //     return currLISLength;
    // }

 
    // private int findLowerBoundIdxInDpLIS(int[] dpLIS, int currNum, int currLISLength){
    //     int start = 0;
    //     int end = currLISLength - 1;
    //     int lowerBoundIdx = -1;
    //     while(start <= end){
    //         int mid = start + ((end - start) / 2);

    //         if(dpLIS[mid] >= currNum){ //probable lower bound found
    //             lowerBoundIdx = mid;
    //             end = mid - 1; //we want the first largest number's idx and since dpLIS is sorted in ascending order
    //                 //we move towards left to find the first largest number
    //         }
    //         else{
    //             start = mid + 1;
    //         }
    //     }

    //     return lowerBoundIdx;

    // }



























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 22 Dec 2025:

    // //intuition 1: (1D DP: Longest Increasing Subsequence (LIS) pattern : Patience sort O(nlogn))
    //     //Maintain an LIS array while traversing nums array from left to right:
    //         //if lower bound of currNum (i.e. first element E to satisfy E >= currNum) is present 
    //             //in LIS array, then replace E with currNum.
    //             //“Replacing keeps subsequence length the same but makes its tail smaller, increasing
    //                 //the chance of extending it later.”
    //         //else, if no lower bound of currNum is present in the current LIS, add the currNum to the 
    //             //last of current LIS, increasing the size of LIS
    //         //Apply binary search in finding the lower bound of currNum

    //         //“dpLIS does not store the actual LIS.
    //         //It only stores the smallest possible tail for each subsequence length, which is sufficient
    //             //to compute the length of LIS.”

    // public int lengthOfLIS(int[] nums) {
    //     //dpLIS[i] represent tail element of longest subsequence of length i + 1
    //     //dpLIS[numsLen - 1] will represent tail element of longest subsequence of length numsLen (longest possible)
    //     //Therefore, we need 1D dp array of length nums.length  

    //     int numsLen = nums.length;
    //     int[] dpLIS = new int[numsLen];

    //     dpLIS[0] = nums[0];
    //     int currDPLISSize = 1;

    //     for(int i = 1; i < numsLen; i ++){
    //         int lowerBoundIdxInDPLIS = findLowerBoundIdx(nums[i], dpLIS, currDPLISSize);

    //         if(lowerBoundIdxInDPLIS == -1){ //no lower bound of nums[i] found in dpLIS
    //             dpLIS[currDPLISSize ++] = nums[i]; //increase size of dpLIS
    //         }
    //         else{ //replace the element in dpLIS at lower bound idx found with nums[i] 
    //             if(lowerBoundIdxInDPLIS < currDPLISSize - 1){
    //                 continue; //do not replace the dpLIS[lowerBoudIdxDPLIS] number if lower bound idx is less
    //                     //than currsize to maintain a valid LIS in dpLIS
    //             }
    //             dpLIS[lowerBoundIdxInDPLIS] = nums[i];
    //         }
    //     }
    //     return currDPLISSize;

    // }

    // private int findLowerBoundIdx(int currNum, int[] dpLIS, int currSize){
    //     int start = 0;
    //     int end = currSize - 1;

    //     int currLowerBoundIdx = -1;

    //     while(start <= end){
    //         int mid = (start + end) / 2;
    //         if(dpLIS[mid] >= currNum){
    //             currLowerBoundIdx = mid; 
    //             end = mid - 1; //find more smaller lowerbound of currNum 
    //         }
    //         else{
    //             start = mid + 1;
    //         }

    //     }
    //     return currLowerBoundIdx;
    // }
































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 21 Dec 2025:

//     //intuition 2: DP on lengths (Patience sorting idea) — O(n log n)
//         //Have an array named dpLIS. dpLIS[i] will be storing the smallest possbile tail of an increasing subsequence
//             //of length i+1. Using lowerbound concept, for every element check if there exists a lower bound (first >=) 
//             //of that element in dpLIS using binary search upto current size. If yes, replace  the lowerbound element 
//             //found with the current element. If there is no lower bound of the current element, insert the current
//             //element at the last of dpLIS (size + 1).

//         //Why “lower bound (≥)” and not “>”, because:
//             //-LIS is strictly increasing
//             //-Equal elements cannot extend the subsequence
//             //-So equal values must replace existing tail, instead of appending

//         //Conceptual clarifications:
//             //dpLIS stores optimal tails
//             //its length (currSize) equals LIS length
//             //The actual LIS sequence is not directly recoverable from this array
        
//         //TC: O(nlogn)
//         //SC: O(n)
//     public int lengthOfLIS(int[] nums) {
//         //dpLIS[i] represents smallest possible tail (last value) of an increasing subsequence of length i+1.
//         //Maximum possible length of LIS could be of length numsLen with smallest tail at index dpLIS[numsLen-1]
//         //Therefore, we need a dp 1D array of size numsLen.

//         int numsLen = nums.length;
//         int[] dpLIS = new int[numsLen];
//         dpLIS[0] = nums[0];
//         //forgot to put semicolon at above line : did not proof read your code
//         int currSize = 1;  
//         //currSize tracks how many elements have been inserted in the dpLIS

//         for(int i = 1; i < numsLen; i ++){
//             int lowerBoundIdx = findLowerBound(dpLIS, nums[i], currSize);

//             if(lowerBoundIdx == -1){//i.e. no lower bound element found in dpLIS. In this case add nums[i] 
//             //at currSize + 1 index in dpLIS
//                 dpLIS[currSize ++] = nums[i];
//             }
//             else{ //a lower bound element was found at lowerBoundIdx. In this case replace nums[i] with
//             //element at dpLIS[lowerBoundIdx]
//                 dpLIS[lowerBoundIdx] = nums[i];
//             }
//         }

//         return currSize;

//     }

//     //finding the index of first element that is greater than equal to num
//     private int findLowerBound(int[] dpLIS, int num, int currSize){
//         int start = 0;
//         int end = currSize - 1;

//         int lowerBoundIdx = -1;
//         while(start <= end){
//             int mid = (start + end) / 2;
//             //int mid = end - ((end - start) / 2);
//             if(dpLIS[mid] >= num){
//                 lowerBoundIdx = mid; //we have found a probable lowerBound index
//                 end = mid - 1; //we know that dpLIS is sorted array and if we have found an element at mid that is
//                 //greater than or equal to num, then there is a possibility that there could be some other element
//                 //that is greater than or equal to num on the left side of mid, so we do end = mid - 1
//             }
//             else{ //if(num > dpLIS[mid]), given that dpLIS is sorted array, look towards right
//                 start = mid + 1;
//             }
//         }
//         return lowerBoundIdx;
//     }




// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 21 Dec 2025:

    // //intuition 1: (1D DP : LIS pattern)
    //     //Store the LIS possible at each index in the corresponding index of dp array
    //     //For each index i, consider all previous indices j < i (till 0) and see if there is any number that is 
    //         //smaller than current num. If a smaller number is encountered at j, then take LIS possible at j
    //         //from dp[j] and take the max of all such small numbers. 
    //     //Recurrence relation: dp[i] = 1 + max(dp[j]) for all j < i where nums[j] < nums[i] 
    //     //Base case: for 1st element at 0 index, only LIS possible is of length 1 
    //     //Keep track of LIS encountered at each index since LIS can end at any position

    //     //TC: O(n^2)
    //     //SC: O(n)
    // public int lengthOfLIS(int[] nums) {
    //     //dp[i] represents the length of longest increasing subsequence including num at i index
    //     //"dp[i] represents the length of longest increasing subsequence that ends at i index (including nums[i])"
    //     //We will be travelling till n-1 index where n is the length of nums    
    //     //Therefore, we need a 1D DP array of length n

    //     int numsLen = nums.length;
    //     int[] dp = new int[numsLen];
    //     int ansLIS = 1;

    //     dp[0] = 1;
    //     for(int i = 1; i < numsLen; i ++){
    //         int prevMaxLIS = 0;
    //         for(int j = i - 1; j >= 0; j --){
    //             if(nums[j] < nums[i]){
    //                 prevMaxLIS = Math.max(prevMaxLIS, dp[j]);
    //             }
    //         }
    //         // dp[i] = Math.max(dp[i-1], 1 + prevMaxLIS);
    //         dp[i] = 1 + prevMaxLIS;
    //         ansLIS = Math.max(dp[i], ansLIS);
    //     }

    //     return ansLIS;
    // }
}