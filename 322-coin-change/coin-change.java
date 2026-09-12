class Solution {

    //Re-solving on 11 Sept 2026:
    
    //intuition 2: Tabulation

        //looks like a dp question because:
            //1. we are being asked to find minimum number of coins
            //2. The problem has optimal substructure: the optimal answer for the current state
                //depends on optimal annwers of smaller states.
            //3. The same (currIdx, currAmount) states are reached repeatedly, giving overlapping
                //subproblems
            
        //Tabulation (bottom-up approach):
            //at any state we have two options, either to choose a coin or not with the 
                //option of same coin being able to be chosen multiple times

            //dp invariant:
                //dp[currIdx][currAmount] represents the minimum number of coins needed to 
                    //make currAmount when coins from currIdx...n-1 indices are available
                
                //dp[0][amount] will represent the minimum number of coins needed to make
                    //amount when coins from 0...n-1 indices are available

                //in order to compute dp[0][amount] we need to compute the substates 
                    //like dp[1][amount-x]....dp[n-1][amount-x]

                    //therefore, we will run the for loop from right to left for rows and left to 
                        //right for cols

                //now dp array can go till dp[n][amount-x], therefore, we need a dp array of
                    //size n+1 x amount + 1

            //recurrence relation:
                //if we choose to pick the same coin then we reduce the amount by coin[i], keep 
                    //the index same and add + 1 to the coin total as 1 coin was used. This makes
                    //dp[currIdx][currAmount] state depend on dp[currIdx][currAmount-coins[currIdx]]
                    
                    // -> dp[currIdx][currAmount] = 1 + dp[currIdx][currAmount - coins[currIdx]]  

                //if we choose to not to pick the same coin then we keep the amount same, move
                    //to the next coin and do not add anything to the option

                    //in this case the current state will depend on a sub state as per below relation:
                    //-> dp[currIdx][currAmount] = dp[currIdx + 1][currAmount] 

            //base case:
                //when the amount is 0 we need 0 coins
                    //therefore, first column of the matrix should be 0 
                    
                //when the currIdx is coins.length 
                    //in this case we cannot form any amount except 0 as there is no coin to 
                        //choose from
                    //therefore, dp[coins.length] row starting from 1 will be INF

                //when currAmount < coins[currIdx], that means that it is not possible for the
                    //state dp[currIdx][currAmount] to make the amount, therefore, we fill it with INF

            //TC: exponential O(2^(coins.length + amount)/minCoin) without memoization
            //TC: O(coins.length x amount) with memoization
            //SC: O(coins.length x amount) for dp array + O(coins.length) for recursive stack


    public int coinChange(int[] coins, int amount) {
        
        if(amount == 0) return 0;
        int rows = coins.length + 1;
        int cols = amount + 1;

        int[][] dp = new int[rows][cols];

        //base cases
        //filling first column as 0 for amount == 0
        for(int row = 0; row < rows; row ++){
            int col = 0;

            dp[row][col] = 0;
        }

        //filling last row with INF for row == coins.length
        for(int col = 1; col < cols; col ++){
            int row = rows - 1;
            dp[row][col] = Integer.MAX_VALUE;
        }

        for(int row = rows - 2; row >= 0; row --){
            for(int col = 1; col < cols; col ++){
                int currCoin = coins[row];
                int currAmount = col;

                int pick = Integer.MAX_VALUE;
                int notPick = Integer.MAX_VALUE;
                if(currCoin > currAmount){ //not possible to make currAmount, so the only option is to
                    //not pick the currCoin
                   notPick = dp[row + 1][currAmount];
                }
                else{
                    pick = dp[row][currAmount - currCoin];
                    notPick = dp[row + 1][currAmount];
                }


                if(pick != Integer.MAX_VALUE) pick += 1;

                dp[row][col] = Math.min(pick, notPick);

            }
        }

        return dp[0][amount] == Integer.MAX_VALUE ? -1 : dp[0][amount];
    }

    













    // //intuition 1: 

    //     //looks like a dp question because:
    //         //1. we are being asked to find minimum number of coins
    //         //2. The problem has optimal substructure: the optimal answer for the current state
    //             //depends on optimal annwers of smaller states.
    //         //3. The same (currIdx, currAmount) states are reached repeatedly, giving overlapping
    //             //subproblems
            
    //     //recursion (top-down approach):
    //         //at any state we have two options, either to choose a coin or not with the 
    //             //option of same coin being able to be chosen multiple times

    //         //dp invariant:
    //             //recurse(idx, x) represents the minimum number of coins needed to 
    //                 //make x amount when coins from idx...n-1 indices are available

    //         //recurrence relation:
    //             //if we choose to pick the same coin then we reduce the amount by coin[i], keep 
    //                 //the index same and add  +1 to the coin total as 1 coin was used

    //             //if we choose to not to pick the same coin then we keep the amount same, move
    //                 //to the next coin and do not add anything to the option

    //         //base case:
    //             //when the amount becomes == 0 
    //                 //return 0; -> the amount has been successfully formed and now 0 coins are 
    //                     //needed
    //             //or, when the amount becomes < 0 
    //                 //return Integer.MAX_VALUE; -> the amount is impossible to form, so we would
    //                     //need infinite coins
    //             //or, when the currIdx becomes equal to coins.length
    //                 //return Integer.MAX_VALUE; -> the currIdx reached last of coins array without
    //                     //ever forming the amount, hence the amount is impossible to form, so we
    //                     //would need infinite coins
    //                 //or "this recursive path cannot form the amount, so return Integer.MAX_VALUE as a 
    //                     //sentinel for an impossible state"

    //         //memoization:
    //             //we can store the states to avoid repeated calcualtion in a dp array
    //             //dp[currIdx][currAmount] will denote, min number of coins needed to form
    //                 //currAmount using coins from currIdx...n-1
    //             //currIdx can be at max coins.length and currAmount can be at max amount
    //             //therefore, we need a dp array of size coins.length + 1 x amount + 1

    //         //TC: exponential O(2^(coins.length + amount)/minCoin) without memoization
    //         //TC: O(coins.length x amount) with memoization
    //         //SC: O(coins.length x amount) for dp array + O(coins.length) for recursive stack


    // public int coinChange(int[] coins, int amount) {
        
    //     if(amount == 0) return 0;
    //     int[][] dp = new int[coins.length + 1][amount + 1];

    //     // for currIdx = coins.length we cannot form any amount but 

    //     int numCoins = recurse(coins, 0, amount, dp);
       
    //     return numCoins == Integer.MAX_VALUE ? -1 : numCoins;
    // }

    // private int recurse(int[] coins, int currIdx, int currAmount, int[][] dp){
    //     if(currAmount == 0) return 0; //valid solution

    //     if(currAmount < 0) return Integer.MAX_VALUE; //not a valid solution
    //     if(currIdx == coins.length) return Integer.MAX_VALUE; //last of array is reached without currAmount
    //         //reaching 0, therefore, it is impossible to have a valid solution

    //     if(dp[currIdx][currAmount] != 0) return dp[currIdx][currAmount];


    //     //picking the same coin
    //     int option1 = recurse(coins, currIdx, currAmount - coins[currIdx], dp);
        
    //     //not picking the current coin denomination
    //     int option2 = recurse(coins, currIdx + 1, currAmount, dp);

    //     dp[currIdx][currAmount] = Math.min(option1 == Integer.MAX_VALUE ? Integer.MAX_VALUE : option1 + 1, 
    //         option2);
    //     return dp[currIdx][currAmount];

    // }






























/////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 16 Feb 2026:
    
//     //intuition 2: DP : 0/1 Knapsack : 1D DP
//         //we run two for loops, outer loop iterates over each coin and the internal loop runs
//             //from amount = coin till 'amount'. 
//         //This way we only consider the amount that is greater than equal to each coin.
//         //Now for each amount we choose the current coin which leaves total amount to be 
//             //amount - coin. This corresponds to dp[amount-coin] state.
        
//         //base case: 
//             //initialize the dp array with amount + 1 as this is the maximum possile upper
//                 //limit for number of coins (it will be 'amount' number of coins in case of
//                 //coin = 1)
        
//         //recurrence relation:  
//             //We will choose state from the minimum of picking the current coin and not
//                 // picking the current coin.
//             //pick : 1 + dp[i-currCoin]
//             //notPick : dp[i] //amount unchanged
//             //dp[i] = Math.min(dp[i], dp[i-currCoin]


//     public int coinChange(int[] coins, int amount) {
//         //dp[i] will represent minimum number of coins required to form i amount 
//         //dp[amount] will represent minimum number of coins required to form 'amount' amount
//         //therefore we will need a dp array of size amount + 1

//         int[] dp = new int[amount + 1];

//         //base case
//         for(int i = 0; i < amount + 1; i ++){
//             dp[i] = amount + 1;
//         }
//         dp[0] = 0; //0 coins required to form 0 amount


//         for(int currCoin : coins){
//             for(int j = currCoin; j < amount + 1; j ++){
//                 int pick = amount + 1;
//                 if(dp[j - currCoin] != amount + 1){
//                     pick = 1 + dp[j - currCoin];
//                 }
//                 int notPick = dp[j];
                
//                 dp[j] = Math.min(pick, notPick);

//             }
//         }

//         return dp[amount] == amount + 1 ? -1 : dp[amount];
//     }







// /////////////////////////////////////////////////////////////////////////////////////

    // //Re-solving on 16 Feb 2026:
    
    // //intuition 1: DP : 0/1 Knapsack : 2D DP
    //     //We can solve this by using a 2D dp matrix with columns as amount starting from 
    //         //0 to 'amount' and rows with the index of coins from coins array

    //     //Base cases:
    //         //we need 0 coins to form 0 amount, so dp[0][0] = 0
    //         //for 0 coins and non-zero amount, we need +INF coins to form that amount
    //             //thefore fill first row from 1st column with +INF
    //         //for non-zero coins and 0 amount, we need 0 coins to form 0 amount
    //             //therefore fill first col from 1st row with 0
        
    //     //Recurrence relation:
    //         //Now for every coin we have two options, either to include in current sum
    //             //or skip.
    //         //We can only include current coin (i) if the it is less than equal to current
    //             //amount (j)
    //         //Inclusion:
    //             //now as a new coin has been included, the amount decreases relatively 
    //                 //as per denomination of the coin included, which us with an amount of
    //                 //amount - coin[i-1]. Now as coins are infinite, number of available coins
    //                 //remain same (i). This leaves us with a state of i, remAmount. Now
    //                 //we can get this state from dp[i][remAmount]
                
    //         //Exclusion:
    //             //if we totally skip the current coin, then the amount remains unchanged 
    //                 //and as we choose to skip the current coin (i) it leaves us with 1 
    //                 //less coin (i-1) to choose from. This leaves us with a state 
    //                 //of i-1, amount. We can get this state from dp[i-1][amount]

    //         //We will take minimum of both of these states in order to find minimum number
    //             //of coins

    // public int coinChange(int[] coins, int amount) {
    //     //dp[i][j] will represent minimum number of coins needed to form j amount
    //         //given first i coins from coins array
    //     //dp[coins.length][amount] will represent the minimum number of coins needed to form 
    //         //'amount' amount given all the coins in 'coins' array
    //     //Therefore, we need a 2D matrix of size coins.length + 1 x amount + 1


    //     int rows = coins.length + 1;
    //     int cols = amount + 1;
        
    //     int[][] dp = new int[rows][cols];

    //     //base cases
    //     //filling first row
    //     for(int j = 1; j < cols; j ++){
    //         int i = 0;
    //         dp[i][j] = Integer.MAX_VALUE;
    //     }

    //     //filling first col
    //     for(int i = 0; i < rows; i ++){
    //         int j = 0;

    //         dp[i][j] = 0;
    //     }


    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
    //             int currCoinVal = coins[i-1];
    //             int currAmount = j;


    //             if(currAmount < currCoinVal){ //not-pick
    //                 dp[i][j] = dp[i-1][j];
    //             }
    //             else{
    //                 int pick = Integer.MAX_VALUE;
    //                 if(dp[i][currAmount - currCoinVal] != Integer.MAX_VALUE){
    //                     pick = 1 + dp[i][currAmount - currCoinVal];
    //                 }
    //                 int notPick = dp[i-1][j];

    //                 dp[i][j] = Math.min(pick, notPick);
    //             }


    //         }
    //     }

    //     return dp[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dp[rows-1][cols-1];


    // }
























////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 11 Dec 2025:
    
    // //intuition 1(DP : 2D array):
    //     //We can solve this problem with a 2D DP matrix
    //     //Given all the coins and amount, we can find the minimum number of coins needed to form the final amount
    //         //at bottom right of the matrix.
    //     //At each step we have two options, either to pick the current coin or not pick the current coin
    //         //If we Pick current coin then min number of coins will be 1 + dp[i][j - coin[i - 1]] where i is 
    //             //the number of coins and j - coins[i - 1] is the remaining amount after picking current coin.
    //             //Here dp[i][j - coin[i - 1]] represent the min number of coins required to form "j - coin[i - 1]" amount.
    //         //If we don't pick the current coin and proceed with the previous coin, then min number of coins will be
    //             //dp[i-1][j]

    //     //Also if the current coin is bigger than the amount, we cannot pick that coin. In which case that state in 
    //         //dp is defined by notPick option
    //     //Our answer for current state will be the minimum of pick and notPick

    //     //Base case:
    //         //Fill first row and with INF and first col with 0 to avoid boundary checks
        
    //     //Recurrence relation:
    //         //dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j])

    // public int coinChange(int[] coins, int amount) {
    //     //dp[i][j] represents minimum number of coins required from i coins to form j amount.
    //     //This means, our answer will be at dp[coins.length][amount].
    //     //Therefore we need a matrix of coins.length+1 x amount+1 length

    //     if(amount == 0) return 0;

    //     int rows = coins.length + 1;
    //     int cols = amount + 1;

    //     int[][] dp = new int[rows][cols];

    //     //filling first column with 0s as we need minimum 0 coins to make 0 amount
    //     for(int i = 0; i < rows; i ++){
    //         dp[i][0] = 0;
    //     }

    //     for(int j = 0; j < cols; j ++){
    //         dp[0][j] = Integer.MAX_VALUE;
    //     }

    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){                
    //             if(j < coins[i - 1]){ //we cannot pick the coin
    //                 dp[i][j] = dp[i - 1][j];
    //                 continue;
    //             } 

    //             int pick = Integer.MAX_VALUE;
    //             if(dp[i][j - coins[i - 1]] != Integer.MAX_VALUE){
    //                 pick = 1 + dp[i][j - coins[i - 1]];
    //             }

    //             int notPick = dp[i - 1][j];

    //             dp[i][j] = Math.min(notPick, pick);
    //             // System.out.println(dp[i][j]);
    //         }
    //     }

    //     return dp[rows - 1][cols - 1] == Integer.MAX_VALUE ? -1 : dp[rows - 1][cols - 1];


    // }































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 07 Dec 2025:
    
//     //intuition 1(DP : 2D array):


//     //TC: O(coinsLen * amount)
//     //SC: O(coinsLen * amount)
//     public int coinChange(int[] coins, int amount) {
       
//        //dp[i][j] represents the fewest number of coins required from i coins to make j amount
//        //"dp[i][j] represents the fewest number of coins needed to make amount j using the first i coin types"
       
//        //dp[3][11] will represent the fewest number of coins required from 3 coins to make 11 amount
//        //Therefore, we will need a 2D matrix of size 4 x 12

//         int coinsLen = coins.length;

//         int[][] dp = new int[coinsLen + 1][amount + 1];
        
//         //given n coins, we need 0 coins to make an amount of 0, hence fill the first column dp[n][0] with zeroes
//         for(int i = 0; i < coinsLen + 1; i ++){
//             dp[i][0] = 0;
//         }

//         //given 0 coins, we need infinity coins to make an x amount (x being non-zero), hence fill the first row dp[0][n]
//             //with infinity (Integer.MAX_VALUE)
//         for(int j = 1; j < amount + 1; j ++){
//             dp[0][j] = Integer.MAX_VALUE; 
//         }

//         //We will have to fill all the cells in the dp matrix in order to get our answer at the last index dp[coinsLen][amount]

//         //We have two choices, either to pick or not pick the current coin
//             //If we pick the current coin (i-1th coin in coins), we have total of i coins and (j - coins[i - 1]) amount to make. So 
//                 //the recurrence relation in this case will be dp[i][j] = 1 (for choosing current coin) + dp[i][j - coins[i - 1]]
//             //If we do not pick the current coin (i), we will have i - 1 coins to make j amount. That means we need dp[i - 1][j]
//                 //number of coins to make j amount.
//         //We will chose the minimum from pick and not pick as a value for dp[i][j]
        
//         //"Pick → stay in the same row"
//         //"Not pick → go to previous row" 
//         //"If we pick coins[i-1], we stay on the same row because we can reuse the same coin type."
//             //Therefore, "dp[i][j] = 1 + dp[i][j - coins[i-1]]."


//         for(int i = 1; i < coinsLen + 1; i ++){
//             for(int j = 1; j < amount + 1; j ++){
//                 int pick = Integer.MAX_VALUE;
//                 if(j - coins[i - 1] >= 0){
//                     if(dp[i][j - coins[i - 1]] == Integer.MAX_VALUE){ //this check is important as without this 1 + max_value
//                     //goes out of bounds and instead become min_value. And while doing Math.min(pick, notPick), that min_value 
//                     //gets selected
//                         pick = Integer.MAX_VALUE; 
//                     }
//                     else{
//                         pick = 1 + dp[i][j - coins[i - 1]]; 
//                     }
//                     // i because we are picking the current coin for our calculations
//                     // j - coins[i - 1] because after picking current coin (at index i - 1 in coins array), we will be left
//                         //with "j - that_coin's_value" and dp[i][j - coins[i - 1]] will give us the minimum number of coins 
//                         //required acheive "j - coins[i - 1]" amount after chosing "i" coins. i here represents the number of coins
//                         //choosen from coins array from left to right
                        
//                 }
                
//                 //a coin will not be picked if coins[i - 1] > j
//                 int notPick = dp[i - 1][j];

//                 dp[i][j] = Math.min(pick, notPick);
//             }
//         }

//         return dp[coinsLen][amount] == Integer.MAX_VALUE ? - 1 : dp[coinsLen][amount];         
 


//     }































// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //This problem is an "Unbounded Knapsack" problem: "Unbounded knapsack is a DP problem where each item can be chosen
//         //unlimited times (i.e., infinite supply), unlike the 0/1 knapsack where each item can be chosen at most once."


//     //Solving on 06 Dec 2025:
    
//     //intuition 2 (DP : 1D : Bottom up): Clean version of intuition 2 
//     //The main problem is to find the minimum number of coins to form the sum "amount". If we subtract coin[0] from amount,
//         //then the subproblem is to find the minimum number of coins to form the sum "amount - coins[0]"

//     //Have a dp array that stores the minimum number of coins required to form the sum equal to the correspoding index of
//         //dp array.  
//     //"To compute dp[i], we will consider using each coin"
//     //The recurrence relation will be: dp[i] = Math.min(dp[i], 1 + dp[i - coin]) => 1 in "1 + dp[i - coin]" means current coin
//         //and dp[i - coin] represents minimum number of coins required for form the remaining sum "i - coin" after subtracting 
//         //current coin value  
    
//     //Pre-fill the dp array with "amount + 1" value as that is the upper bound (excluded) that any cell in dp array can have.
//         //This is possible when there is coin of value 1, and in that case amount * 1 = amount. 

//     //"Fill dp with amount + 1 (a value larger than any possible valid answer).":
//         //"Worst case: using coin = 1, amount coins are needed."
//         //"So amount + 1 is safe as “infinity”."


//     //TC: O(amount * coins.length) => quadratic
//     //SC: O(amoun) => linear
//     public int coinChange(int[] coins, int amount) {
//         //dp[i] will represent the minimum number of coins required to compute sum of "i" 
//         //Therefore, to get the minimum number of coins to form a sum of "amount" we need an array of size "amount + 1"

//         int[] dp = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0; //base case
//         for(int coin : coins){
//             for(int i = coin; i < amount + 1; i ++){
//                 dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
//             }
//         }
//         //in case if dp[amount] was not updated with any smaller value and is still "amount + 1", it is not possible to 
//             //make any combination with given coins that will give us the sum of "amount", hence return -1
//         return dp[amount] == amount + 1 ? - 1 : dp[amount];
//     }































// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    
    // //intuition 1 (DP): DID NOT WORK
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