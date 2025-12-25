class Solution {
    //Solving on 25 Dec 2025:

    //intuition 1: (1D DP: LIS (Longest Increasing Subsequence) pattern)
        //We sort the given envelopes in the ascending order of widths and if any two widths match, we sort the
            //envelopes in descending order of heights. 
        //After sorting, we take the heights of envelopes and find longest increasing subsequence amoung them.
        
        //This works because, by sorting the envelopes with ascending order of widths, we make sure that widths
            //are not of our concern going forward. And if any two widths are equal we sort by increasing (descending)
            //heights to make sure that only 1 envelope (with the largest height) gets picked for sequence in
            //order to avoid considering putting same width envelope into other same width envelopes based on just
            //increasing heights (ascending). Then by running LIS on heights we make sure that only smaller height
            //envelopes are put (russian dolled) inside the big envelopes.  
        
        //For running the LIS on heights we will use patience sort (O(nlogn)) with a dpLIS array to maintain
            //smallest possible tail for LIS of length i+1 at dp[i]. We will use binary search for finding lower
            //bound of any heigth in dpLIS

        //For sorting envelopes we will use piorityqueue(minHeap) with custom comparator
    public int maxEnvelopes(int[][] envelopes) {
        //dpLIS[i] represents smallest possible tail of LIS of length i + 1
        //maximum LIS can be of length envelopes.length
        //Therefore, we need a 1D dpLIS array of length envelopes.length

        int envsLen = envelopes.length;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[0] == b[0]){ //same widths
                return b[1]-a[1]; //sort based on decreasing heights
            }
            return a[0]-b[0]; //sort based on increasing widths
        });

        for(int[] env : envelopes){
            minHeap.offer(env);
        }

        for(int i = 0; i < envsLen; i ++){
            envelopes[i] = minHeap.poll();
        }

        int[] heights = new int[envsLen];

        //filling heights array
        for(int i = 0; i < envsLen; i ++){
            heights[i] = envelopes[i][1];
        }

        int maxEnvs = findLISOnHeights(heights);

        return maxEnvs;

    } 

    private int findLISOnHeights(int[] heights){
        int hLen = heights.length;

        int[] dpLIS = new int[hLen];
        dpLIS[0] = heights[0];

        int currLISLength = 1;

        for(int i = 1; i < hLen; i ++){
            int currHeight = heights[i];

            int lbIdxInDpLIS = findLBInDpLIS(dpLIS, currHeight, currLISLength);

            if(lbIdxInDpLIS == -1 ){ //no lb found -> LIS length increases
                dpLIS[currLISLength ++] = currHeight;
            }
            else{
                dpLIS[lbIdxInDpLIS] = currHeight;
            }
        }

        return currLISLength;


    }

    private int findLBInDpLIS(int[] dpLIS, int currHeight, int currLISLength){
        int start = 0; 
        int end = currLISLength - 1;

        int currLB = -1;
        while(start <= end){
            int mid = start + ((end - start) / 2);
            if(dpLIS[mid] >= currHeight){ //LB found
                currLB = mid;
                end = mid - 1; //searching for more smaller LB
            }
            else{
                start = mid + 1;
            }

        }

        return currLB;
       

    }









































////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 22 Dec 2025:

    // //intuition 3: (DP : Longest increasing subsequence (LIS) pattern) - O(nlogn) - binary search
    //     //After sorting based on width, we are only left with height. -> Find LIS on height 

    //     //LIS on heights help us in not increasing the currSize when there is a smaller height after larger height.
    //     //Small height will replace larger height in LIS array, leaving LIS of the same size.
    //     //If a larger height is being entered and it does not have any height greater than equal to itself 
    //         //(i.e. no lower bound), that means that all previous envelopes (sorted in ascending order of width)
    //         //have smaller widths and heights, therefore, append this to LIS, increasing the size of LIS.
    //     //Eg: If there are two envelopes e1 : [smallW, largeH] and e2 : [largeW, smallH], while formulating LIS, smallH
    //         //will replace largeH (as largeH >= smallH), leaving LIS of size 1 only, which is our answer. This
    //         //is true as e1 cannot fit into e2 as e1's height is larger than e2's height
    // public int maxEnvelopes(int[][] envelopes) {
    //     //dpLIS[i] represents a smallest tail envelope in the longest increasing subsequence of length i+1 
    //     //dp[envelopes.length - 1] will represent the  smallest tail evelope in the LIS of length envelopes.length,
    //         //which is maximum possible length
    //     //Therefore, we need a 2D DP array of size envelopes.length x 2

    //     //sorting the envelopes in ascending order of width and descending order of height (for equal widths)
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> { //-> learn how to do this in-place with custom sorting
    //         if(a[0] != b[0]){
    //             return a[0] - b[0];
    //         }
    //         return b[1] - a[1];
    //     });

    //     int envLength = envelopes.length;
    //     for(int[] env : envelopes){
    //         minHeap.offer(env);
    //     }
        
    //     int[] heights = new int[envLength]; 
    //     for(int i = 0; i < envLength; i ++){
    //         int[] env = minHeap.poll();
    //         heights[i] = env[1];
    //     }

    //     int[] dpHeightLIS = new int[envLength];

    //     dpHeightLIS[0] = heights[0];
    //     int currSize = 1;

    //     for(int i = 1; i < envLength; i ++){
    //         int lowerBoundIdx = findLowerBoundIdx(heights[i], dpHeightLIS, currSize);

    //         if(lowerBoundIdx == -1){
    //             dpHeightLIS[currSize ++] = heights[i];
    //         } 
    //         else{
    //             dpHeightLIS[lowerBoundIdx] = heights[i];
    //         }
    //     }
    //     return currSize;
    // } 

    // private int findLowerBoundIdx(int currHeight, int[] dpHeightLIS, int currSize){
    //     int start = 0; 
    //     int end = currSize - 1;

    //     int currLowerBound = -1;

    //     while(start <= end){
    //         int mid = (start + end) / 2;
    //         if(dpHeightLIS[mid] >= currHeight){
    //             currLowerBound = mid;
    //             end = mid - 1;
    //         }
    //         else{
    //             start = mid + 1;
    //         }
    //     }
    //     return currLowerBound;
    // }









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