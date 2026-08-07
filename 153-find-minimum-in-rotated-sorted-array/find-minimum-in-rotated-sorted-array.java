class Solution {

    //Solving on 06 Aug 2026

    //Intuition 1: Binary search
        //We can observe that the array after rotating leads to two different sorted arrays
        //Example in [4,5,6,7,0,1,2], [4,5,6,7] is first sorted array and [0,1,2] is second sorted array
        //We apply binary search and compare the element at mid with left and right elements
            //if nums[mid] > nums[right] 
                //then that means that the minimum lies in the second sub array
                //In this case we move left towards mid (left = mid + 1) - exclude the mid as 
                    //it can never be our answer (smaller element exist at nums[right])
            //if nums[mid] < nums[right] 
                //the minimum lies at mid or somewhere to the left of mid
                //In this case we move right towards mid (right = mid) - keep the mid as it can 
                    //be our answer
            
        
        //TC: O(log n)
        //SC: O(1)
    
    public int findMin(int[] nums) {
        
        int left = 0;
        int right = nums.length - 1;

        while(left < right){
            int mid = left + (right - left) / 2;

            int currNum = nums[mid];

            if(currNum > nums[right]){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];

    }
























///////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //Solving on 13 Sept 2025

    // //inutition 1: the array is divided in two parts. First part is where the elements of last part of original array are coming up and the other part (second
    // //half), where the elements of the first part of original array are coming up. Our aim is to look for ending of first part or starting of second part.

    // //1st region is from left to mid and 2nd region is from mid + 1 to right 
    // //The smallest element will lie in the region where there is unsorted elements (due to max element coming before min element).
    // //Apply binary search, compare if nums[mid] > nums[right], then it means that we are in the unsorted part as of now, and the min element lies in 
    // //the 2nd region (towards right) so make left = mid + 1 and if nums[mid] < nums[right], then that means that we are in sorted part and min element
    // //lies in region 1 so make right = mid - 1, until right becomes equal to left 
    // // 
    // public int findMin(int[] nums) {
    //     int left = 0;
    //     int right = nums.length - 1;
        
    //     while(left < right){
    //         // int mid = right - (right - left) / 2;
    //         int mid = (right + left) / 2;

    //         // if(nums[mid] > nums[left]){
    //         //     left = mid + 1;
    //         // }
    //         // else if(nums[left] < nums[right]){
    //         //     right = mid - 1;
    //         // }
    //         if(nums[mid] <= nums[right]){ //mid to right is sorted
    //             right = mid;
    //         }
    //         else{ //mid to right is unsorted
    //             left = mid + 1;
    //         }
    //     }
    //     return nums[left];
    // }
}