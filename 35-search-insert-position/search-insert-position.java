class Solution {

    //Solving on 06 Aug 2026

    //Intuition 1: Binary Search
        //find the lower bound 
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length; //[left, right) (exclusive)

        while(left < right){
            int mid = left + (right - left) / 2;

            int currNum = nums[mid];

            if(currNum >= target){
                right = mid; //preserve mid as it can be our answer
            }
            else{
                left = mid + 1;
            }
        }

        return left;
    }
}