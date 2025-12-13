class Solution {

    //Solving on 12 Dec 2025:

    //intuition 1 (DP: 2D)
        //If you have 0 coins and x amount to make, there are 0 ways to do so.
        //If you have x coins and 0 amount to make, there is 1 way to do so. That is by not selecting any coin.
            //Doing nothing is one way
        //dp[0][0] is 1

    public int change(int amount, int[] coins) {
        //dp[i][j] represents the number of ways to form j amount of money with i coins

        int rows = coins.length + 1;
        int cols = amount + 1;
        
        int[][] dp = new int[rows][cols];

        //given 0 coins, we have 0 ways to make any non-zero amount
        for(int j = 1; j < cols; j ++){ 
            dp[0][j] = 0;
        }

        //given x coins, we have 1 way to make 0 amount, by not choosing any coin
        for(int i = 0; i < rows; i ++){
            dp[i][0] = 1;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(coins[i - 1] > j){
                    dp[i][j] = dp[i - 1][j]; //cannot choose current coin
                }
                else{
                    int pick = dp[i][j - coins[i - 1]];
                    int notPick = dp[i - 1][j];

                    dp[i][j] = pick + notPick;
                }
            }
        }

        return dp[rows - 1][cols - 1];

    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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