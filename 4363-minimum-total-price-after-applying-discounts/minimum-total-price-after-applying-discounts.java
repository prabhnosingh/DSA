class Solution {

    //Solving on 08 Aug 2026

    //intuition 1:
        //for minimum total price, we would have to apply max discount on max price
        //sort both the arrays and apply max discount to max prices 

        //TC: nlogn + mlogm + m + n ==> O(nlogn) 
            //where n = prices array length and m = discounts array length
        //SC: O(1)
    public double minPrice(int[] prices, int[] discounts) {
        Arrays.sort(prices);
        Arrays.sort(discounts);

        double minPrice = 0;
        
        int priceCounter = prices.length - 1;
        for(int i = discounts.length - 1; i >= 0; i --){
            double currPrice = prices[priceCounter];
            minPrice += (currPrice * (100 - discounts[i])) / 100;
            prices[priceCounter] = 0;
            priceCounter -= 1;
            if(priceCounter == -1) break;
        }

        
        for(int i = priceCounter; i >= 0; i --){
            minPrice += (double) prices[i];
        }
        return minPrice;
            
    }
}