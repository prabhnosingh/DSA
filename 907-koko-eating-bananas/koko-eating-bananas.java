class Solution {

    //intuition 3: Binary search on answers (optimized)
        //maximum eating speed can be equal to maximum of piles as increasing speed after that
            //does not help, given that koko can only eat as much as a single pile contains in
            //one hour
        //The minimum eating speed can be 1

        //apply binary search on the range [minSpeed, maxSpeed] and check the valid speed check
            //for each speed

        //TC: O(h * log (maxSpeed))
        //SC: O(1)
    public int minEatingSpeed(int[] piles, int h) {

        int maxSpeed = 0;

        for(int pile : piles){
            maxSpeed = Math.max(maxSpeed, pile);
        }

        int left = 1; //minSpeed
        int right = maxSpeed;

        while(left < right){
            int mid = left + (right - left) / 2;
            System.out.println(mid + " = returns : " + isValidSpeed(piles, h, mid));
            if(isValidSpeed(piles, h, mid)){ //look for more smaller speed but keep the current 
                //mid as an option
                right = mid;
            }
            else{ //look for bigger speed and exclude current mid as an option
                left = mid + 1;
            }
        }

        return left;
        
    }

    //O(h)
    private boolean isValidSpeed(int[] piles, int h, int currSpeed){
        
        // int currPile = piles[0];
        for(int i = 0; i < piles.length; i ++){
           h -= ((piles[i]  - 1) / currSpeed) + 1;
           if(h < 0) return false;
        }

        return true;

    }

  























////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //intuition 1: Brute force
//         //Brute force way would be to start from speed 1 till maximum, sequentially and returning
//             //the first speed to satisfy the condition of eating all the bananas.
    
//     //intuition 2: Binary search on answers (TLE)
//         //maximum eating speed can be equal to maximum of piles as increasing speed after that
//             //does not help, given that koko can only eat as much as a single pile contains in
//             //one hour
//         //The minimum eating speed can be 1

//         //apply binary search on the range [minSpeed, maxSpeed] and check the valid speed check
//             //for each speed

//         //TC: O(h * log (maxSpeed))
//         //SC: O(1)
//     public int minEatingSpeed(int[] piles, int h) {

//         int maxSpeed = 0;

//         for(int pile : piles){
//             maxSpeed = Math.max(maxSpeed, pile);
//         }

//         int left = 1; //minSpeed
//         int right = maxSpeed;

//         while(left < right){
//             int mid = left + (right - left) / 2;
//             System.out.println(mid + " = returns : " + isValidSpeed(piles, h, mid));
//             if(isValidSpeed(piles, h, mid)){ //look for more smaller speed but keep the current 
//                 //mid as an option
//                 right = mid;
//             }
//             else{ //look for bigger speed and exclude current mid as an option
//                 left = mid + 1;
//             }
//         }

//         return left;
        
//     }

//     //O(h)
//     private boolean isValidSpeed(int[] piles, int h, int currSpeed){
        
//         int currPile = piles[0];
//         for(int i = 0; i < piles.length; i ++){
//             if(currSpeed >= currPile){ //koko will finish what ever is there and move to next pile in
//                 //next hour
//                 h -= 1;
//                 if(i+1 != piles.length) currPile = piles[i + 1]; //move to next pile
//             }
//             else{
//                 currPile -= currSpeed;
//                 h -= 1;
//                 i -= 1; //the pile is still remaining to be finsihed. stay on current pile
//             }

//             if(h < 0) return false;
//         }

//         return true;

//     }

  























// ////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1: We can apply Binary search here, what is the minimum and maximum threshold of eating speed here?
    // //maximum threshold is max pile size as piles.length <= h and that means it will be possible for koko to finish all 
    // //the piles if he goes at speed of max pile size and minimum threshold is 1 only as koko cannot eat 0 bananas per hour
    
    // //now we have to determine the speed by iterating over the range of [minSpeed, maxSpeed] and see if it works to have a
    // //particular speed and still be able to finish all the bananas in h hours.

    // //its "within" h hours, means koko can finish earlier than h hours as well.

    // // TC: O(n log(maxPile))
    // public int minEatingSpeed(int[] piles, int h) {

    //     int maxPile = 0;
    //     for(int pile : piles){
    //         maxPile = Math.max(maxPile, pile);
    //     }
        
    //     int minSpeed = maxPile;

    //     int left = 1;
    //     int right = maxPile;

    //     while(left <= right){
    //         int midSpeed = (left + right) / 2;

    //         if(canFinish(midSpeed, piles, h)){ //if midSpeed is a feasible speed, try to look for lower speed
    //             right = midSpeed - 1;
    //             minSpeed = Math.min(minSpeed, midSpeed);
    //         }
    //         else{
    //             left = midSpeed + 1;
    //         }
    //     }
    //     return minSpeed;
    // }

    // public boolean canFinish(int midSpeed, int[] piles, int h){
        
    //     int currHours = 0;
    //     for(int pile : piles){
    //         // if(midSpeed - pile >= 0){ //if the speed chosen was more than equal to pile, then it means that it is guaranteed
    //         // //for koko to finish that particular pile within that hour 
    //         //     currHours += 1;
    //         // }
    //         // else{ //if the speed chosen was less than the pile then that means that the koko will take more than 1 hour
    //         // //to finish the pile
    //         //     while(pile > 0){
    //         //         pile -= midSpeed;
    //         //         currHours ++;
    //         //     }
    //         // }

    //         // currHours += (int) Math.ceil ((double)pile / midSpeed);
    //         currHours += (pile + midSpeed - 1) / midSpeed; //more efficient than the above line, though similar function
    //         if(currHours > h){
    //             return false;
    //         }
    //     }

    //     return currHours <= h;
    // }



}