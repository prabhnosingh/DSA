class Solution {

    //Solving on 02 Mar 2026:

    //intuition 2 : recursion + memoization
        //Try out all ways
        //Recurrence:
            //Express f(idx, target)
                //till index idx in how many ways can we form the target 
            //Explore all possibilities
                //take it:
                    //idx while target reduces by arr[idx] => f(idx, target-arr[idx])
                        //if we choose arr[idx] to be part of one way then we find, in 
                            //how many ways we can form the remaining target till index
                            //idx
                    //we can only take if target >= arr[idx] 
                //not take it:
                    //idx moves while target remains same => f(idx-1, target)
                        //if we choose not to include arr[idx] to be part of on way
                            //then we find, in how many ways we can form the target
                            //till index idx-1 
            //Sum all possibilities and return
                //return take + notTake 

            //base case:
                //idx == -1

        
        //memoization: we can memoize any repeated states. In this problem we can represent
            //a state with amount and idx
        //Go with HashMap of key as string (target + idx) and value as ways to form the target


    public int change(int amount, int[] coins) {
        HashMap<String, Integer> memo = new HashMap<>();
        return recurs(coins.length-1, amount, coins, memo);
    }

    public int recurs(int idx, int target, int[] coins, HashMap<String, Integer> memo){
        if(idx == -1) return 0; //negative base case
        if(target == 0) return 1; //positive base case

        String key = idx + "_" + target;

        if(memo.containsKey(key)) return memo.get(key);
        
        int pick = 0;
        int notPick = 0;
        if(coins[idx] <= target){
            pick = recurs(idx, target - coins[idx], coins, memo);
            notPick = recurs(idx-1, target, coins, memo);

        }
        else{ //not pick only
            notPick = recurs(idx-1, target, coins, memo); 
        }   

        memo.put(key, pick + notPick);
        return pick + notPick;
    }



    // //Solving on 02 Mar 2026:

    // //intuition 1 (TLE): recursion
    //     //Try out all ways
    //     //Recurrence:
    //         //Express f(idx, target)
    //             //till index idx in how many ways can we form the target 
    //         //Explore all possibilities
    //             //take it:
    //                 //idx while target reduces by arr[idx] => f(idx, target-arr[idx])
    //                     //if we choose arr[idx] to be part of one way then we find, in 
    //                         //how many ways we can form the remaining target till index
    //                         //idx
    //                 //we can only take if target >= arr[idx] 
    //             //not take it:
    //                 //idx moves while target remains same => f(idx-1, target)
    //                     //if we choose not to include arr[idx] to be part of on way
    //                         //then we find, in how many ways we can form the target
    //                         //till index idx-1 
    //         //Sum all possibilities and return
    //             //return take + notTake 

    //         //base case:
    //             //idx == -1


    // public int change(int amount, int[] coins) {
    //     return recurs(coins.length-1, amount, coins);
    // }

    // public int recurs(int idx, int target, int[] coins){
    //     if(idx == -1) return 0; //negative base case
    //     if(target == 0) return 1; //positive base case
    //     int pick = 0;
    //     int notPick = 0;
    //     if(coins[idx] <= target){
    //         pick = recurs(idx, target - coins[idx], coins);
    //         notPick = recurs(idx-1, target, coins);

    //     }
    //     else{ //not pick only
    //         notPick = recurs(idx-1, target, coins); 
    //     }

    //     return pick + notPick;
    // }



























////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 12 Dec 2025:

//     //intuition 1 (DP: 2D)
//         //If you have 0 coins and x amount to make, there are 0 ways to do so.
//         //If you have x coins and 0 amount to make, there is 1 way to do so. That is by not selecting any coin.
//             //Doing nothing is one way
//         //dp[0][0] is 1

//         //Recurrence relation: 
//             //We have two choices, either to pick the current coin or not pick it.
//                 //if we pick the current coin we can reuse the coin again but the remaning amount reduces by coin's value
//                     //dp[i][j - coins[i - 1]]
//                 //if we do not pick the current coin we can keep the amount unchanged and total combinations from previous
//                     //i with same amount => dp[i - 1][j]

//             //Therefore, total number of combinations are dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j]

//     public int change(int amount, int[] coins) {
//         //dp[i][j] represents the number of ways to form j amount of money with i coins

//         int rows = coins.length + 1;
//         int cols = amount + 1;
        
//         int[][] dp = new int[rows][cols];

//         //given 0 coins, we have 0 ways to make any non-zero amount
//         for(int j = 1; j < cols; j ++){ 
//             dp[0][j] = 0;
//         }

//         //given x coins, we have 1 way to make 0 amount, by not choosing any coin
//         for(int i = 0; i < rows; i ++){
//             dp[i][0] = 1;
//         }

//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(coins[i - 1] > j){
//                     dp[i][j] = dp[i - 1][j]; //cannot choose current coin
//                 }
//                 else{
//                     int pick = dp[i][j - coins[i - 1]]; //number of combinations if we pick the coin
//                     int notPick = dp[i - 1][j]; //number of combinations if we don't pick the coin

//                     dp[i][j] = pick + notPick; //total number of ways to form j amount given i coins
//                 }
//             }
//         }

//         return dp[rows - 1][cols - 1];

//     }

// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 12 Dec 2025:

    // //intuition 1 (DP: 2D)
    //     //Given n coins we need number of combinations that can be made so that amount m 
    //         //adds up to amount, where m is the sum of all the coins in the combination
    //     //One of the subproblem is to find the number of combinations given n - 1 coins to 
    //         //form amount - 1 amount 
        
    //     //Found as a pattern: For first i coins and j amount, the combinations will be
    //         //dp[i-1][j] + "j / coin" because number of combinations will only increase
    //         //if the current amount is bigger than the coin denomination and the combinations
    //         //will increase at by the factor of amount/coin -> but how this logic be updated
    //         //to accomodate the case when coin = 1 and amount is 5, in this case your logic
    //         //will give 5 combinations but instead it is only 1


    // public int change(int amount, int[] coins) {
        
    // }
}