class Solution {

    //Solving on 08 Aug 2026

    //intuition 1: Brute force 
        //check for every divisor from 1 to maximum of nums
        //the first one to get is our answer
        //TC: O(maxNum * nums.length)
    
    //intuition 2: Binary search on answer 
        //the smallest divisor will exist in the range [1, maxNum]
        //we can run binary search on this range and find lower bound element
            //that satisfies the threshold
    
        //TC: O(nums.length * log maxNum)
    public int smallestDivisor(int[] nums, int threshold) {
        int maxNum = 0;
        for(int num : nums){
            maxNum = Math.max(maxNum, num);
        }

        int left = 1;
        int right = maxNum;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(isValidDivisor(nums, threshold, mid)){
                right = mid; //valid divisor found, now look towards left for smaller divisor but
                    //keep the current mid as an option
                
            }
            else{
                left = mid + 1; //not a valid divisor(mid), skip it and find towards right
                //currDivisor(mid) was smaller which led to larger results after division
                    //and hence the sum crossed the threshold. Therefore, we should look for
                    //larger divisor (towards right) so that the sum result can be smaller 
            }

        }
        return left;

    }

    //O(nums.length)
    private boolean isValidDivisor(int[] nums, int threshold, int currDivisor){
        int currSum = 0;

        for(int i = 0; i < nums.length; i ++){
            int divRes = ((nums[i] - 1) / currDivisor) + 1; //Subtract 1, divide, then add 1.
            currSum += divRes;
            if(currSum > threshold) return false;
        }
        return true;
    }
}