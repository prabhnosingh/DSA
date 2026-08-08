class Solution {
    //Solving on 08 Aug 2026

    //intuition 1:
        //Brute force will be to check every day starting from 1 till maximum bloomday and
            //return the first day to satisfy the making of m bouquets
        //O(bloomDay.length * maxBloomDay)
    
    //intuition 2:
        //Topic: Binary search
        //Pattern: Binary search on answer
        //Sub-pattern: Minimum feasible answer
        
        //The range of days to look in is [1, maxBoomDay]
        //We will run binary search on this range and find the lower bound (smallest day) which
            //makes m bouquets with k adjacent flowers per bouquet 
        //As currDay increases, the number of bloomed flowers can only increase.
            //Therefore:
            //F F F F T T T T
            //        ^
            //   minimum valid day

        //The answer will be -1 if m*k > bloomday.length as we can only have at max 
            //bloomday.length flowers

        //TC: O(bloomDay.length * log maxBloomDay)
        //SC:O(1)
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length) return -1;

        int maxBloomDay = 0;    
        int minBloomDay = Integer.MAX_VALUE;

        for(int bd : bloomDay){
            maxBloomDay = Math.max(maxBloomDay, bd);
            minBloomDay = Math.min(minBloomDay, bd);
        }

        int left = minBloomDay; //as any flower cannot bloom before minBloomDay
        int right = maxBloomDay; //whe don't we do right = maxBloomDay - 1;? is it because we want to 
            //include it in the range? -> yes
        
        while(left < right){
            int mid = left + (right - left) / 2;

            if(isValidBloomDay(bloomDay, m, k, mid)){
                right = mid; //currDay(mid) is good and able to make m bouquets with k flowers
                //so keep it and find smaller day towards left
            }
            else{
                left = mid + 1; //currDay(mid) is not good and not able to make m bouquets, so
                //we need bigger day, hence look towards right while excluding mid
            }
        }
        return left;

    }

    //O(bloomDay.length)
    private boolean isValidBloomDay(int[] bloomDay, int m, int k, int currDay){
        

        int currFlowers = 0;
        for(int i = 0; i < bloomDay.length; i ++){
            if(bloomDay[i] <= currDay){
                currFlowers += 1; //window continues
            }
            else{ //window breaks
                currFlowers = 0;
            }

            if(currFlowers == k){//requirement for 1 bouquet met
                m -= 1; //1 bouquet made
                currFlowers = 0; //currFlowers reset for next bouquet
            }

            if(m == 0) return true; //all bouquets complete
        }
        return false;

    }
}