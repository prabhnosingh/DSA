class Solution {
    public int maxProfit(int[] prices) {

        int max = 0;
        int profit;
        int lsf = Integer.MAX_VALUE;
        for(int i = 0; i<prices.length; i++){
           if(prices[i] < lsf){
               lsf = prices[i];
           }
           profit = prices[i] - lsf;

           max = Math.max(max, profit);

        }

        return max;
    }
}