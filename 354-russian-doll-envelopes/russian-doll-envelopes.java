class Solution {
    //Solving on 22 Dec 2025:

    //intuition 3: (DP : Longest increasing subsequence (LIS) pattern) - O(nlogn) - binary search
    public int maxEnvelopes(int[][] envelopes) {
        //dpLIS[i] represents a smallest tail envelope in the longest increasing subsequence of length i+1 
        //dp[envelopes.length - 1] will represent the  smallest tail evelope in the LIS of length envelopes.length,
            //which is maximum possible length
        //Therefore, we need a 2D DP array of size envelopes.length x 2

        //sorting the envelopes in ascending order of width and descending order of height (for equal widths)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> { //-> learn how to do this in-place with custom sorting
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int envLength = envelopes.length;
        for(int[] env : envelopes){
            minHeap.offer(env);
        }
        
        int[] heights = new int[envLength]; 
        for(int i = 0; i < envLength; i ++){
            int[] env = minHeap.poll();
            heights[i] = env[1];
        }

        int[] dpHeightLIS = new int[envLength];

        dpHeightLIS[0] = heights[0];
        int currSize = 1;

        for(int i = 1; i < envLength; i ++){
            int lowerBoundIdx = findLowerBoundIdx(heights[i], dpHeightLIS, currSize);

            if(lowerBoundIdx == -1){
                dpHeightLIS[currSize ++] = heights[i];
            } 
            else{
                dpHeightLIS[lowerBoundIdx] = heights[i];
            }
        }
        return currSize;
    } 

    private int findLowerBoundIdx(int currHeight, int[] dpHeightLIS, int currSize){
        int start = 0; 
        int end = currSize - 1;

        int currLowerBound = -1;

        while(start <= end){
            int mid = (start + end) / 2;
            if(dpHeightLIS[mid] >= currHeight){
                currLowerBound = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return currLowerBound;
    }









///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //intuition 2 (TLE): (DP : Longest increasing subsequence (LIS) pattern) - O(n^2)
        //Increasing subsequence here means, a subsequence of arrays in which each preceding int array have both
            //of its numbers strictly smaller than the succeding array in the subsequence.
        //In the problem statement, it is not explicitly mentioned that we need to find increasing subsequence.
        //Therefore, it does not need to follow the left to right order. So we will sort the matrix.
        //This is required because (in example 1) if we follow normal LIS algo, [2,3] would replace [5,4]
            //to start a new subsequence, but this is not what we require.
       
       
        //dp array nlogn aproach : After sorting, we will need to find the upper bound.
        //dp array n^2 apporach: After sorting, we fill our dp array by adding 1 to max dp value of all previous
            //strictly small envelopes 
    // public int maxEnvelopes(int[][] envelopes) {
    //     //dp[i] represent length of longest increasing subsequence possible that includes envelope at i index
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
          
    //         if(a[0] != b[0]){
    //             return a[0] - b[0];
    //         }

    //         return a[1] - b[1];
    //     });   
    //     int maxEnvelopes = 1;

    //     int envCount = envelopes.length;
    //     int[] dp = new int[envCount];

    //     for(int[] env : envelopes){
    //         minHeap.offer(env);
    //     }

    //     int idx = 0;
    //     while(!minHeap.isEmpty()){
    //         envelopes[idx ++] = minHeap.poll(); 
    //     }   

    //     dp[0] = 1;
    //     for(int i = 1; i < envCount; i ++){
    //         int prevMaxLIS = 0;
    //         int[] currEnv = envelopes[i];

    //         for(int j = i - 1; j >= 0; j --){
    //             int[] prevEnv = envelopes[j];
    //             if(currEnv[0] > prevEnv[0] && currEnv[1] > prevEnv[1]){
    //                 prevMaxLIS = Math.max(prevMaxLIS, dp[j]);
    //             }
    //         }

    //         dp[i] = 1 + prevMaxLIS;
    //         maxEnvelopes = Math.max(maxEnvelopes, dp[i]);
    //     }
    //     return maxEnvelopes;
    // } 





























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 22 Dec 2025:

    // //intuition 1 (did not work): Use a minHeap with custom comparator that sorts int[] arrays based on both 1st and 2nd element


    // public int maxEnvelopes(int[][] envelopes) {
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
    //         int returnVal = 0;
    //         if(a[0] < b[0] && a[1] < b[1]){ 
    //             return a[0] - b[0];
    //         }
    //         if(a[0] < b[0]){
    //             return a[0] - b[0];
    //         }

    //         if(a[1] < b[1]){

    //         }
    //     });    
    // }
}