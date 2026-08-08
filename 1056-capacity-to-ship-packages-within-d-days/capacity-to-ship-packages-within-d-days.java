class Solution {

    //Solving on 07 Aug 2026

    //intuition 1: 
        //Minimum capacity of the ship to start from will be maximum weight but that
            //might not a valid answer given the constraint of days.
        //We can start from maximum_weight and go until total_weight and then run 
            //binary search on that range to find the least ship capacity that will satisfy
            //the days requirement
    public int shipWithinDays(int[] weights, int days) {
        
        //finding max weight
        int maxWeight = Integer.MIN_VALUE;
        int totalWeight = 0;
        for(int weight : weights){
            maxWeight = Math.max(maxWeight, weight);
            totalWeight += weight;
        }

        int left = maxWeight;
        int right = totalWeight;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(isValidWeight(weights, mid, days)){
                right = mid; //look towards left for less weight but keep mid as an option 
            }
            else{
                left = mid + 1; //current mid is not a valid weight and hence look towards right
                //while excluding mid 
            }
        }

        return left;

    }

    //checking if the weight will even work for the given days
    public boolean isValidWeight(int[] weights, int currWeight, int days){
        
        int tempWeight = currWeight;
        for(int i = 0; i < weights.length; i ++){
            int w = weights[i];
            if(tempWeight < w){ //it does not make sense to subtract w from tempWeight if it is bigger
                tempWeight = currWeight;
                i -= 1;
                days -= 1;
            }
            else{
                tempWeight -= w;

                if(tempWeight == 0){ //weight is full for 1 day
                    days -= 1;
                    // if(days == 0) break;
                    tempWeight = currWeight;
                }
            }

            if(days == 0){
                if(i == weights.length - 1) return true;
                return false;
            } 
        }
        return true; //days never went to 0. so technically the "weight" is acceptable
    }   
























/////////////////////////////////////////////////////////////////////////////////////////////////////
    // public int shipWithinDays(int[] weights, int days) {
        
    //     int totalWeight = 0;
    //     int maxWeight = 0;
        

    //     for(int weight : weights){
    //         totalWeight += weight;
    //         maxWeight = Math.max(maxWeight, weight);
    //     }
    //     int leastCapacity = totalWeight;

    //     //applying binary search

    //     int left = maxWeight, right = totalWeight;

    //     while(left <= right){
    //         int mid = (left + right) / 2;

    //         if(isValidMaxWeight(weights, mid, days)){
    //             right = mid - 1;
    //             leastCapacity = Math.min(leastCapacity, mid);
    //         }

    //         else{
    //             left = mid + 1;
    //         }
        
    //     }
    //     return leastCapacity;

    // }

    //   public boolean isValidMaxWeight(int[] weights, int capacity,  int days){
        
    //     int currCap = 0;
    //     int currDays = 1;
    //     for(int weight : weights){
    //         currCap += weight;
    //         if(currCap > capacity){
    //             currDays ++;
    //             currCap = weight;
    //         }
    //     }

    //     if(currDays <= days){
    //         return true;
    //     }
    //     return false;

    // }

    // public boolean isValidMaxWeight(int[] weights, int maxWeight, int days){
    //     int currWeight = 0;
    //     int currDays = 1;
    //     int i = 0;
    //     for(i = 0; i < weights.length; i ++){
    //         currWeight += weights[i];

    //         if(currWeight >= maxWeight){
    //             currDays += 1;
    //             if(currWeight != maxWeight){
    //                 currWeight = weights[i];
    //             }
    //             else{
    //                 currWeight = 0;
    //                 currDays -= 1;
    //             }
    //         }

    //         if(currDays == days){
    //             break;
    //         }

    //     }


    //     return i == weights.length ? true : false;
    // }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //intuition 1 (Brute force): Compare all possible combination and consider the minimum. All possible combinations
    //will start by considering capacity from maxWeight of a single pacakage and go till sum of all the pacakages.
    
    //We chose maxWeight of a single pacakage because that is the least capacity that a ship can have to possibly ship the
    //max weight pacakage. 
    
    //The first capacity to ship all the packages within the allowed days is our answer. (Can later be optimized by 
    //applying binary search)

    //TLE

    // public int shipWithinDays(int[] weights, int days) {
        
    //     int maxCapacity = 0;
    //     int maxWeight = Integer.MIN_VALUE;
    //     int minCapacity = Integer.MAX_VALUE;
    //     for(int weight : weights){
    //         maxCapacity += weight;
    //         maxWeight = Math.max(maxWeight, weight);
    //     }
 
    //     for(int i = maxWeight; i <= maxCapacity; i ++){
    //         int currDays = 1;
    //         int currCapacity = 0;
    //         for(int j = 0; j < weights.length; j ++){
    //             currCapacity += weights[j];

    //             if(currCapacity > i){ //curr capacity became equal to or greater than the max capacity allowed (i) for
    //             //this round
    //                 currDays ++;
    //                 currCapacity = weights[j]; //to consider the weight that was added extra over the next day
            
    //             }

         
                
    //         }
    //         if(currDays <= days){ //after iterating over the entire array considering maxCapacity
    //         //if the currDays == days, then consider updating minCapacity
    //             minCapacity = Math.min(minCapacity, i);
    //             // break;
    //         }
    //     }
    //     return minCapacity;

    // }

    ////////////////////////////////////////////////////////////////////////////////////////////
    
    //intuition 2: Applying binary search to intuition 1

    //TC: O(n * log(sum(weights)))
    // public int shipWithinDays(int[] weights, int days) {

    //     int maxWeight = 0;
    //     int totalWeight = 0;
    //     int minCapacity = Integer.MAX_VALUE;
        
    //     for(int weight : weights){
    //         maxWeight = Math.max(maxWeight, weight);
    //         totalWeight += weight;
    //     }

    //     int left = maxWeight;
    //     int right = totalWeight;
    //     while(left <= right){
    //         int midCap = (left + right) / 2;

    //         if(canShip(midCap, weights, days)){ //if the weight at mid can be shipped within the secified dates then try 
    //         //with lower cap
    //             right = midCap - 1;
    //             minCapacity = Math.min(minCapacity, midCap);
    //         }
    //         else{
    //             left = midCap + 1;
    //         }

    //     }
    //     return minCapacity;
    // }

    // public boolean canShip(int capacity, int[] weights, int days){
        
    //     int currCap = 0;
    //     int currDays = 1;
    //     for(int weight : weights){
    //         currCap += weight;
    //         if(currCap > capacity){
    //             currDays ++;
    //             currCap = weight;
    //         }
    //     }

    //     if(currDays <= days){
    //         return true;
    //     }
    //     return false;

    // }

}