class Solution {
    public int minEatingSpeed(int[] piles, int h) {
    


        // int max = piles[0];
        // for(int k=0; k<piles.length; k++){
        //     if(max < piles[k]){
        //         max = piles[k];
        //     }
        // }

        // int[] rates = new int[max];
        // for(int i = 1; i <= max; i++){
        //     rates[i-1] = i;
        // }
        // int k = Integer.MAX_VALUE;
        
        int left = 1;
        // int right = rates[max];
        int right = Integer.MAX_VALUE;

        while(left <= right){
            int mid = left + (right - left)/2;
            int totalHours = 0;
            
            if(canEatInTime(piles, mid, h)){
                right = mid-1;
            }
            else left = mid + 1;
                       
        }
        return left;
    }

            public boolean canEatInTime(int piles[], int k, int h){

                int hours = 0;
                for( int pile: piles){
                    int div = pile/k;
                    hours += div;
                    if(pile%k != 0){
                        hours++;
                    }
                }
             return hours <= h;
    }
}