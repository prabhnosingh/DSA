class Solution {
    //Re-solving on 15 Feb 2026:

    //intuition 1: DP : 1D DP
        //The target is that robber should have most money after going through the whole house
        //At any point the robber have two choices, either to rob the current house or not rob
            //the current house and take forward the current  money he has robbed.
        //This decision is made based on past two states:   
            //For any state i, i.e. for any house i, the robber have two options:
                //Either to rob i house, in which case the total will be dp[i-2] + nums[i]
                    //because no two adjacent houses can be robbed
                //Or, to not rob ith house, in which case the total will be dp[i-1]

        //We take the max of both of these choices 

    public int rob(int[] nums) {
        //dp[i] represents maximum money stolen till house i
        //dp[totalHouses - 1] will represent maximum money stolen till end of street
        //Therefore, we need a dp array of size totalHouses
        

        int totalHouses = nums.length;

        if(totalHouses == 1) return nums[0];

        int[] dp = new int[totalHouses];

        dp[0] = nums[0];
          
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < totalHouses; i ++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }

        return dp[totalHouses - 1];

    } 





























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 11 Dec 2025:

//     //intuition 1 (DP: Array): 
//         //We can use 1D DP array to solve this problem. 
//         //Basically to find the max robbed money till the last house (n), we need to know what was the collection
//             //till n-1 and n-2 houses. After that we have two decisions:
//                 //1. Rob the current house (n) including money robbed till (n-2) house and leave the n-1 house. In this
//                     //case we will have "n house money + money till n-2 house"
//                 //2. Do not rob the current house (n) and continue with collection till previous house (n-1) instead. 

        
//         //Recurrence relation:
//             //dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);

//     public int rob(int[] nums) {
//         //dp[i] will represent the maximum sum of money robbed till ith house(0 indexed) without alreting the police
        
//         int numsLen = nums.length;

//         int[] dp = new int[numsLen];

//         dp[0] = nums[0];
//         if(numsLen == 1){
//             return dp[0];
//         }    
//         dp[1] = Math.max(nums[0], nums[1]);

//         for(int i = 2; i < numsLen; i ++){
//             dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
//         }   

//         return dp[numsLen - 1];
//     }































// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Re-solving on 06 Dec 2025:

//     //intuition 1 (dp: space optmized): 
//     //Maintain a dp array that tracks the money stolen till now. At each step we have two choices, either to steal the 
//         //house or not steal the house in order to continue with the current money we have stolen. Eg: In case of 
//         //nums = [2, 1, 1, 2], after stealing nums[0] we have 2 money, now if we want to steal nums[1] we will have 1
//         //money and in that case we will have to drop nums[0] money (2) to avoid alarming the police, so in this case
//         //we will simply not steal the house nums[1] and keep the nums[0] money with us. So max money till now is 2.
//         //Now we move to nums[2] house, which have money 1. Now as we have not stolen house nums[1], it is safe to 
//         //steal from nums[2] house, so now we will have 2 + 1 = 3 money. Now we reach house nums[3], which have 2 money.
//         //Now we have two choices either drop the money that we just stole from nums[2] and steal the money from nums[3]
//         //to have a total of 2 + 2  = 4 money or keep the money from nums[2] (3) and do not steal the money from 
//         //nums[3], in which case we will have total of 3 money. We will go with stealing the nums[3] in order to 
//         //have max money stolen as 4.

//     //dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]) => dp[i-1] is when we do not want to rob the current house at i
//     //At last return dp[n-1]

//     //"The subproblem “max money up to index i” depends only on the previous two states(dp[i-1] and dp[i-2])"


//     //We cannot rob two adjacent houses. At every index i, we have two choices:
//         //1. Rob this house: we must skip the previous house, so total = dp[i - 2] + nums[i]
//         //2. Skip this house: total stays dp[i - 1]
    
//     //Therefore the recurrence is:
//         //dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    
//     //dp[i] stores the maximum amount that can be robbed from the houses [0..i].
//     //Final answer = dp[n - 1]
//     //Ex: nums = [2, 1, 1, 2]
//     //dp = [2, 2, 3, 4] -> answer = 4

//     public int rob(int[] nums) {
        
//         int nLen = nums.length;
//         if(nLen == 1) return nums[0];
    
//         int prevPrevRob = nums[0];
//         int prevRob = Math.max(nums[1], nums[0]);


//         int currRob = prevRob;
//         for(int i = 2; i < nLen; i ++){
//             currRob = Math.max(prevPrevRob + nums[i], prevRob);

//             prevPrevRob = prevRob;
//             prevRob = currRob;
            
//         }

//         return currRob;

//     }






// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-solving on 06 Dec 2025:

    // //intuition 1 (dp: array): 
    // //Maintain a dp array that tracks the money stolen till now. At each step we have two choices, either to steal the 
    //     //house or not steal the house in order and continue with the current money we have stolen. Eg: In case of 
    //     //nums = [2, 1, 1, 2], after stealing nums[0] we have 2 money, now if we want to steal nums[1] we will have 1
    //     //money and in that case we will have to drop nums[0] money (2) to avoid alarming the police, so in this case
    //     //we will simply not steal the house nums[1] and keep the nums[0] money with us. So max money till now is 2.
    //     //Now we move to nums[2] house, which have money 1. Now as we have not stolen house nums[1], it is safe to 
    //     //steal from nums[2] house, so now we will have 2 + 1 = 3 money. Now we reach house nums[3], which have 2 money.
    //     //Now we have two choices either drop the money that we just stole from nums[2] and steal the money from nums[3]
    //     //to have a total of 2 + 2  = 4 money or keep the money from nums[2] (3) and do not steal the money from 
    //     //nums[3], in which case we will have total of 3 money. We will go with stealing the nums[3] in order to 
    //     //have max money stolen as 4.

    // //dp[i] = Math.max(dp[i - 2] + nums[i], dp[i-1]) => dp[i-1] is when we do not want to rob the current house at i
    // //At last return dp[n-1]

    // //"The subproblem “max money up to index i” depends only on the previous two states(dp[i-1] and dp[i-2])"


    // //We cannot rob two adjacent houses. At every index i, we have two choices:
    //     //1. Rob this house: we must skip the previous house, so total = dp[i - 2] + nums[i]
    //     //2. Skip this house: total stays dp[i - 1]
    
    // //Therefore the recurrence is:
    //     //dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
    
    // //dp[i] stores the maximum amount that can be robbed from the houses [0..i].
    // //Final answer = dp[n - 1]





    ///////////////////////////////////////
    //pick = arr[i] + dp[i - 2]
    //not pick = dp[i - 1]

    //dp[i] = max(pick, not pick)
    ///////////////////////////////////////

    //in the recursive solution, at every decision we will have two options to choose from (pick or not pick) => TC: (2^n) 

    // public int rob(int[] nums) {
    //     //dp[i] will represent the max money stolen till index i ("till" is most important word in this statement)
    //     //max value of i can be nLen - 1. Therefore, to access nLen - 1 boxes, we need array of length nLen.
    //     int nLen = nums.length;
    //     if(nLen == 1) return nums[0];
    //     int[] dp = new int[nLen];

    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[1], nums[0]);

    //     for(int i = 2; i < nLen; i ++){
    //         dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
    //     }

    //     // return Math.max(dp[nLen - 1], dp[nLen - 2]);
    //     return dp[nLen - 1];


    // }
}