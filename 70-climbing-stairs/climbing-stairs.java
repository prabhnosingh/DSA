class Solution {
    public int climbStairs(int n) {

        int one = 1;
        int two = 1;
        int temp = 0;
        int i = n - 1;
        while(i != 0){
            temp = one + two;
            two = one;
            one = temp;
            i--;
        }
        return one;

//*********************************************************** */        
        // int[] dp = new int[n + 1];
        // dp[n] = 1;
        // dp[n - 1] = 1;

        // for(int i = n - 2; i >= 0; i-- ){
        //     dp[i] = dp[i+1] + dp[i+2];
        // }
        // return dp[0];
    }
}