class Solution {
    public int findMin(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        if(end+1 ==1){
            return nums[0];
        }            
       int min = nums[0];
        while(start <= end){
            int mid = start + (end - start)/2;

            if( mid > 0 && nums[mid] < nums[mid-1] ){
                return nums[mid];
            }

            if(nums[start] <= nums[mid] && nums[mid] > nums[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return nums[start];
        
        
        
        
        
        
        
        // int min = nums[0];
        // while(left <= right){
        //      int mid = left + (right-left)/2;
            
        //     if(nums[mid] < min){
        //         min = nums[mid];
        //         left = mid - 1;
        //     }
        //     else{
        //         right = mid+1;
        //     }
        // }
        // return min;
    }
}