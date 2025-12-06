class Solution {
    //Solving on 06 Dec 2025:
    
    //intuition 2 (DP): 
    //Have a dp array that stores minimum number of coins that add up to the amount of that particular index.
    //To compute a dp[i], go through all the available coins in coins array.
        //dp[i] = Math.min(1 + dp[i - coins[j]])  

    public int coinChange(int[] coins, int amount) {
        //dp[i] will give the minimum number of coins that add upto sum i
        //therefore we will need dp array of size amount + 1

        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];

        //initializing each element in dp array with "amount + 1"
            //this works because "amount" is the max number of coins possible to form a sum of "amount" -> when
                //each coin is of value 1 => "1 * amount = amount"
        for(int i = 0; i < amount + 1; i ++){
            dp[i] = amount + 1;
        }

        dp[0] = 0;
        for(int i = 1; i <= amount; i ++){
            for(int coin : coins){
                int remAmount = i - coin;

                if(remAmount >= 0){
                    dp[i] = Math.min(dp[i], 1 + dp[remAmount]);
                }
        
            }
        }

        //in case a certain amount is not possible to form with given coins, the value of that in dp will be amount + 1
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 06 Dec 2025:
    
    // //intuition 1 (DP):
    // //Have a hashmap to know if you have a particular coin or not. 
    // //Have 2 dp arrays, one for modulus and one for division.
    // //In modulus array, store the modulus of each coin with amount
    // //In division array, store the division of each coin with amoung

    // //Go from left to right. If some coin have modulus 0, store its correspoding division in
    //     //minCoinNums = Math.min(minCoinNums, currCoinNums)
    // //Keep going right to find more samller number of coins.
    // //If you encounter some non-zero modulus, look in hashset if we have a coin with non-zero 
    //     //modulus, if yes, consider 1 + currDivision as probable ans 
    // public int coinChange(int[] coins, int amount) {
        
    //     if(amount == 0){
    //         return 0;
    //     }

    //     int cLen = coins.length;

    //     int[] mod = new int[cLen];
    //     int[] div = new int[cLen];
    //     HashSet<Integer> coinSet = new HashSet<>();
    //     int minCoinsNum = Integer.MAX_VALUE;

    //     for(int i = 0; i < cLen; i ++){
    //         coinSet.add(coins[i]);
    //         mod[i] = amount % coins[i];
    //         div[i] = amount / coins[i];
    //     }

    //     for(int i = 0; i < cLen; i ++){
    //         if(mod[i] == 0){
    //             minCoinsNum = Math.min(minCoinsNum, div[i]);
    //         } 
    //         else{
    //             if(coinSet.contains(mod[i])){
    //                 int currCoinsNum = div[i] + 1;
    //                 minCoinsNum = Math.min(minCoinsNum, currCoinsNum);
    //             }
    //         }
    //     }
    //     return minCoinsNum == Integer.MAX_VALUE ? -1 : minCoinsNum;



    // }
}