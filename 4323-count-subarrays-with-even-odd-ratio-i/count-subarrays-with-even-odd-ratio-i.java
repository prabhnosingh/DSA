class Solution {
    //Solving on 01 Aug 2026

    //intuition 3 (prefix sum):
    


    //Intuition 2 (brute force):
        //running two for loops
    public int countRatioSubarrays(int[] nums, int a, int b) {

        int validSubArrays = 0;

        for(int start = 0; start < nums.length; start ++){
            int evenCount = 0;
            int oddCount = 0;

            for(int end = start; end < nums.length; end ++){
                if(nums[end] % 2 == 0) evenCount += 1;
                else oddCount += 1;

                if(oddCount > 0 && (long) evenCount * b <=  (long) oddCount * a){
                    validSubArrays += 1;
                }               
            }
        }
        return validSubArrays;
        
        
    }
    /////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 01 Aug 2026

    // //Intuition 1: Prefix sum
    //     //storing the number or ratio of odd/even numbers if a subarray was to start from that index
    // public int countRatioSubarrays(int[] nums, int a, int b) {

    //     int[][] oddEvenCountArr = new int[nums.length][2];
        
    //     int validSubArrays = 0;
        
    //     //counting total even and odd numbers in nums
    //     int totalOdds = 0;
    //     int totalEvens = 0;
    //     for(int num : nums){
    //         if(num % 2 == 0){
    //             totalEvens += 1;
    //         }
    //         else{
    //             totalOdds += 1;
    //         }
    //     }

    //     if(totalOdds == 0) return 0;
        
    //     oddEvenCountArr[0][0] = totalEvens;
    //     oddEvenCountArr[0][1] = totalOdds;

    //     for(int i = 1; i < nums.length; i ++){
    //         if(nums[i - 1] % 2 == 0){
    //             totalEvens -= 1;
    //             if(totalEvens >= 0) oddEvenCountArr[i][0] = totalEvens;
    //         }
    //         else{
    //             totalOdds -= 1;
    //             if(totalOdds >= 0) oddEvenCountArr[i][1] = totalOdds;
    //         }
    //     }

    //     for(int i = 0; i < nums.length; i ++){
    //         int currEven = oddEvenCountArr[i][0];
    //         int currOdd = oddEvenCountArr[i][1];
    //         if(currOdd == 0) break;
    //         if((currEven / currOdd) <= (a/b)) validSubArrays += currEven*currOdd;
    //     }

    //     return validSubArrays;
        
        
    // }
}