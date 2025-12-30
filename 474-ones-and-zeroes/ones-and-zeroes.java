class Solution {
    //Solving on 28 Dec 2025:

    //Intuition 1 (brainstorming):
        //Basically we want the total of 1's and 0's in all the strings of substing
        //There are two options for each string in the strs array
            //1. we pick it for our subset:
                //In this case we reduce the number of 1's and 0's in currString from our m and n
            //2. we do not pick it for our subset:
                //In this case m and n remain the same
            //Base is when m and n become 0 or strs array is fully traversed
            //We do not traverse the branch if it is causing m or n go negative
        
    //Intuition 3 (2D DP: Bottom up solution: 0/1 Knapsack pattern / DP on sums/capacities):
        //For each string we pre-compute the zeroes and ones in that string 
        //Then we iterate over each string in strs (with pre-computed zeroOnes)

        //Recurrence relation:
            //For each string we have two options:
                //i. Choose the string to be added to the subset: 
                    //In this case we add 1 for adding current string. Given iz 0's and jo 1's in current 
                        //string, the subproblem now reduces to finding the max strings possible in subset
                        //given i-iz 0's and j-jo 1's, i.e. dp[i-iz][j-jo]. 
                        //=> 1 + dp[i-iz][j-jo]
                //ii. Do not choose the string to be added to the subset:
                    //In this case we do not reduce our available 0's and 1's
                    //=> dp[i][j]
                
                //Now, we take max of these two options to get largest subset possible
                //=> dp[i][j] = Math.max(dp[i][j], 1 + dp[i-iz][j-jo])
            
        //Base cases: ???

        //TC:
        //SC:
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j] represents max strings possible in subset given at most i 0's and j 1's
        //dp[m][n] will represents max strings possible in subset given at most m 0's and n 1's 
        //Therefore, we need a 2D DP matrix of size m+1 x n+1

        int[][] dp = new int[m+1][n+1];

        int[][] zeroOnes = new int[strs.length][2];
        int idx = 0;
        for(String str : strs){
            zeroOnes[idx ++] = findZeroOnes(str);
        }  

        for(int[] zeroOne : zeroOnes){ //technically iterating over strs array
            int zeroes = zeroOne[0];
            int ones = zeroOne[1];

            for(int i = m; i >= zeroes; i --){
                for(int j = n; j >= ones; j --){
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i-zeroes][j-ones]);
                }
            }
                
        }

        return dp[m][n];
        

    }

    private int[] findZeroOnes(String str){
        int[] zeroOnes = new int[2];        
        if(str.length() == 0){
            return zeroOnes;
        }

        for(int i = 0; i < str.length(); i ++){
            zeroOnes[str.charAt(i) - '0'] ++;
        }

        return zeroOnes;
    }











////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 28 Dec 2025:

    // //Intuition 1 (brainstorming):
    //     //Basically we want the total of 1's and 0's in all the strings of substing
    //     //There are two options for each string in the strs array
    //         //1. we pick it for our subset:
    //             //In this case we reduce the number of 1's and 0's in currString from our m and n
    //         //2. we do not pick it for our subset:
    //             //In this case m and n remain the same
    //         //Base is when m and n become 0 or strs array is fully traversed
    //         //We do not traverse the branch if it is causing m or n go negative
        
    // //Intuition 2 (recursion: memoization: beats 5%):
    //     //There are two options for each string in the strs array
    //         //1. we pick it for our subset:
    //             //In this case we reduce the number of 1's and 0's in currString from our m and n and add 1 
    //                 //to our choose variable for selecting one string
    //         //2. we do not pick it for our subset:
    //             //In this case m and n remain the same
    //         //Base is strs array is fully traversed
    //         //We do not traverse the branch if it is causing m or n go negative

    //     //memoization: What is the repeated state that can be memoized?
    //         //"If a variable value is carried downward, it must appear in the memo key"
    //         //Create a hasmap to store key of string currIdx + zeroes + ones and store largest 
    //             //subset possible

    //     //Precomputing zeroOnes to avoid recomputing zeroOnes for the same string multiple times (beats 5%)

    // public int findMaxForm(String[] strs, int m, int n) {
    //     int[][] allZeroOnes = new int[strs.length][2];

    //     int i = 0;
    //     for(String str : strs){
    //         allZeroOnes[i ++] = findZeroOnes(str);
    //     }

    //     // return traverse(strs, 0, m, n, new HashMap<>(), allZeroOnes);
    //     return traverse(strs, 0, m, n, new ting, allZeroOnes);
    // }

    // private int traverse(String[] strs, int currIdx, int zeroes, int ones, HashMap<String, Integer> map, int[][] allZeroOnes){
    //     if(currIdx == strs.length){
    //         return 0;
    //     }
    //     String key = currIdx + "," + zeroes + "," + ones;

    //     if(map.containsKey(key)){
    //         return map.get(key);
    //     }


    //     int[] zeroOnes = allZeroOnes[currIdx];
    //     int choose = 0;
       

    //     if(!((zeroes - zeroOnes[0] < 0) || (ones - zeroOnes[1] < 0))){
    //         choose = 1 + traverse(strs, currIdx + 1, zeroes - zeroOnes[0], ones - zeroOnes[1], map, allZeroOnes);
    //     }
        
        
    //     //do not choose current string at currIdx, skip to next idx -> zeroes and ones remain same
    //     int doNotChoose = traverse(strs, currIdx + 1, zeroes, ones, map, allZeroOnes);

    //     int retVal = Math.max(choose, doNotChoose);
    //     map.put(key, retVal);
        
    //     return retVal;

    // } 

    // private int[] findZeroOnes(String str){
    //     int[] zeroOnes = new int[2];
    //     if(str.length() == 0){
    //         return zeroOnes;
    //     }

    //     for(int i = 0; i < str.length(); i ++){
    //         char currChar = str.charAt(i);
    //         zeroOnes[currChar - '0'] ++;
    //     }

    //     return zeroOnes;


    // }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 28 Dec 2025:

    // //Intuition 1 (brainstorming):
    //     //Basically we want the total of 1's and 0's in all the strings of substing
    //     //There are two options for each string in the strs array
    //         //1. we pick it for our subset:
    //             //In this case we reduce the number of 1's and 0's in currString from our m and n
    //         //2. we do not pick it for our subset:
    //             //In this case m and n remain the same
    //         //Base is when m and n become 0 or strs array is fully traversed
    //         //We do not traverse the branch if it is causing m or n go negative
        
    // //Intuition 1 (recursion: TLE):
    //     //There are two options for each string in the strs array
    //         //1. we pick it for our subset:
    //             //In this case we reduce the number of 1's and 0's in currString from our m and n and add 1 
    //                 //to our choose variable for selecting one string
    //         //2. we do not pick it for our subset:
    //             //In this case m and n remain the same
    //         //Base is when m and n become 0 or strs array is fully traversed
    //         //We do not traverse the branch if it is causing m or n go negative
    // public int findMaxForm(String[] strs, int m, int n) {
    //     return traverse(strs, 0, m, n);
    // }

    // private int traverse(String[] strs, int currIdx, int zeroes, int ones){
    //     if(currIdx == strs.length){
    //         return 0;
    //     }


    //     int[] zeroOnes = findZeroOnes(strs[currIdx]);
    //     int choose = 0;
    //     // System.out.println("zeroes : " + zeroes);
    //     // System.out.println("ones : " + ones);
    //     // System.out.println("strs[currIdx] : " + strs[currIdx] + ": 0s -> " + zeroOnes[0] + " and 1s -> " + zeroOnes[1]);
    //     // System.out.println("***************************");

    //     if(!((zeroes - zeroOnes[0] < 0) || (ones - zeroOnes[1] < 0))){
    //     // if(!((zeroes <= 0 && zeroOnes[0] > 0) || (ones <= 0 && zeroOnes[1] > 0))){
    //         //choose currrent string at currIdx -> reduce zeroes and ones
    //         choose = 1 + traverse(strs, currIdx + 1, zeroes - zeroOnes[0], ones - zeroOnes[1]);
    //     }
        
        
    //     //do not choose current string at currIdx, skip to next idx -> zeroes and ones remain same
    //     int doNotChoose = traverse(strs, currIdx + 1, zeroes, ones);

        
    //     return Math.max(choose, doNotChoose);

    // } 

    // private int[] findZeroOnes(String str){
    //     int[] zeroOnes = new int[2];
    //     if(str.length() == 0){
    //         return zeroOnes;
    //     }

    //     for(int i = 0; i < str.length(); i ++){
    //         char currChar = str.charAt(i);
    //         zeroOnes[currChar - '0'] ++;
    //     }

    //     return zeroOnes;


    // }
}