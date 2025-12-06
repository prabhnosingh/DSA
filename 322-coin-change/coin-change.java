class Solution {

    //This problem is an "Unbounded Knapsack" problem: "Unbounded knapsack is a DP problem where each item can be chosen
        //unlimited times (i.e., infinite supply), unlike the 0/1 knapsack where each item can be chosen at most once."


    //Solving on 06 Dec 2025:
    
    //intuition 2 (DP : 1D : Bottom up): Clean version of intuition 2 
    //The main problem is to find the minimum number of coins to form the sum "amount". If we subtract coin[0] from amount,
        //then the subproblem is to find the minimum number of coins to form the sum "amount - coins[0]"

    //Have a dp array that stores the minimum number of coins required to form the sum equal to the correspoding index of
        //dp array.  
    //"To compute dp[i], we will consider using each coin"
    //The recurrence relation will be: dp[i] = Math.min(dp[i], 1 + dp[i - coin]) => 1 in "1 + dp[i - coin]" means current coin
        //and dp[i - coin] represents minimum number of coins required for form the remaining sum "i - coin" after subtracting 
        //current coin value  
    
    //Pre-fill the dp array with "amount + 1" value as that is the upper bound (excluded) that any cell in dp array can have.
        //This is possible when there is coin of value 1, and in that case amount * 1 = amount. 

    //"Fill dp with amount + 1 (a value larger than any possible valid answer).":
        //"Worst case: using coin = 1, amount coins are needed."
        //"So amount + 1 is safe as “infinity”."


    //TC: O(amount * coins.length) => quadratic
    //SC: O(amoun) => linear
    public int coinChange(int[] coins, int amount) {
        //dp[i] will represent the minimum number of coins required to compute sum of "i" 
        //Therefore, to get the minimum number of coins to form a sum of "amount" we need an array of size "amount + 1"

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; //base case
        for(int coin : coins){
            for(int i = coin; i < amount + 1; i ++){
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        //in case if dp[amount] was not updated with any smaller value and is still "amount + 1", it is not possible to 
            //make any combination with given coins that will give us the sum of "amount", hence return -1
        return dp[amount] == amount + 1 ? - 1 : dp[amount];
    }































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 06 Dec 2025:
    
    // //intuition 2 (DP): 
    // //Have a dp array that stores minimum number of coins that add up to the amount of that particular index.
    // //To compute a dp[i], go through all the available coins in coins array.
    //     //dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]])  

    // public int coinChange(int[] coins, int amount) {
    //     //dp[i] will give the minimum number of coins that add upto sum i
    //     //therefore, we will need dp array of size "amount + 1"

    //     if(amount == 0) return 0;
    //     int[] dp = new int[amount + 1];

    //     //initializing each element in dp array with "amount + 1"
    //         //this works because "amount" is the max number of coins possible to form a sum of "amount" -> when
    //             //each coin is of value 1 => "1 * amount = amount"
        
    //     // for(int i = 0; i < amount + 1; i ++){
    //     //     dp[i] = amount + 1;
    //     // }
    //     Arrays.fill(dp, amount + 1);

    //     dp[0] = 0;
    //     // for(int i = 1; i <= amount; i ++){ //(beats 78.37%)
    //     //     for(int coin : coins){
    //     //         int remAmount = i - coin;

    //     //         if(remAmount >= 0){
    //     //             dp[i] = Math.min(dp[i], 1 + dp[remAmount]);
    //     //         }
        
    //     //     }
    //     // }
    //     for(int coin : coins){ //(beats 94.55%)
    //         for(int i = coin; i <= amount; i ++){
    //             int remAmount = i - coin;
                
    //             //by changing the order of for loops, we don't need the below if condition as remAmount will never go 
    //                 //negative as amount (i) starts from coin itself 
    //             // if(remAmount >= 0){
    //                 dp[i] = Math.min(dp[i], 1 + dp[remAmount]);
    //             // }
        
    //         }
    //     }

    //     //in case a certain amount is not possible to form with given coins, the value of that in dp will be "amount + 1"
    //     return dp[amount] == amount + 1 ? -1 : dp[amount];
    // }





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