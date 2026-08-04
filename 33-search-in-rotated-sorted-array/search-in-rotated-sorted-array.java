class Solution {

    //Solving on 04 Aug 2026

    //intuition 1 (binary search):
        //We can find the first index by traversing the array and finding the smallest element
            //but that would cost O(n)
        //find the smallest element using binary search

        //once a smallest element is found, the nums array can be divided into two sorted
            //subarrays. Then we can search target in either of them depending on smallest
            //element of each subarray -> if target > subarray1[0] and target < subarray2[0] 
            //target is in subarray1 and so on.
        
        
    public int search(int[] nums, int target) {

        //finding smallest element of nums
        int nLen = nums.length;
        int left = 0;
        int right = nLen-1; //can we do this as right = nLen - 1 and then while(left < right)?

        while(left < right){
            int mid = left + (right - left) / 2;
            int currMidNum = nums[mid];
            
            if(currMidNum > nums[right]){//can we use nums[left] as well here? 
                //it means that minimum lies in the second half
                left = mid + 1;
            }
            else{ //it means minimum lies in the first half of nums
                right = mid; 
            }
        }

        //minimum at left

        int[] subArray1 = Arrays.copyOfRange(nums, 0, left);
        int[] subArray2 = Arrays.copyOfRange(nums, left, nLen);

        int targetIdx = -1;

        if(subArray1.length != 0 && subArray1[0] <= target){
            targetIdx = findingTargetIdx(subArray1, target);
        }
        else {//if(subArray2[0] < target){
            targetIdx = findingTargetIdx(subArray2, target);
            if(targetIdx != -1) targetIdx += left; //to compensate the left rotation of array
        }
        // else{ //in case target is greater 
        //     return -1;
        // }
        
        return targetIdx;


    }

    public int findingTargetIdx(int[] arr, int target){
        
        int left = 0; 
        int right = arr.length;

        while(left < right){
            int mid = left + (right - left) / 2;

            if(arr[mid] < target){
                left = mid + 1;
            }
            else if(arr[mid] > target){
                right = mid;
            }
            else{
                return mid;
            }
        }
        
        return -1;

    }

























///////////////////////////////////////////////////////////////////////////////////////////////////////


    //intuition 1: There are two regions, 1st region is the region from back of the array and 2nd region is the region from the front of the array (now which
    //is towards the end of the array). The idea is to identify in which region does the target lie.
    // public int search(int[] nums, int target) {
    //     int left = 0;
    //     int right = nums.length - 1;

    //     while(left <= right){
    //         int mid = (right + left) / 2;
    //         if(nums[mid] == target){
    //             return mid;
    //         }
    //         if(nums[left] > target && nums[mid] > target){ //target lies in the second half
    //             left = mid + 1;
    //         }
    //         else{ //target lies in the second half
    //             right = mid - 1;
    //         }
    //     }
    //     return -1;
    // }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 2: First find the minimun element and then classify in which sorted region could the target lie. And then apply binary search on that 
    // //region 
    // public int search(int[] nums, int target) {
    //     int left = 0;
    //     int right = nums.length - 1;

    //     //finding minimum element
    //     while(left < right){
    //         int mid = (right + left) / 2;
        
    //         if(nums[mid] > nums[right]){ //min element lies in the second half
    //             left = mid + 1;
    //         }
    //         else{ //min element lies in the first half
    //             right = mid;
    //         }
    //     }
        
    //     int minElement = nums[left];
    //     // System.out.println("min element idx is : " + left);
    //     int ans = -1;
    //     if(minElement == target){
    //         return left;
    //     }

    //     else if(target > minElement && target <= nums[nums.length - 1]){ //target could lie in left + 1 to nums.length - 1 range
    //         ans = bsHelper(left + 1, nums.length - 1, nums, target);
    //     }
    //     else{ //target could lie in 0 to left - 1 range
    //         ans = bsHelper(0, left - 1, nums, target);

    //     }

    //     return ans;

    // }

    // public int bsHelper(int left, int right, int[] nums, int target){

    //     while(left <= right){
    //         int mid = (right + left) / 2;

    //         if(nums[mid] == target){
    //             return mid;
    //         }
    //         else if(nums[mid] > target){
    //             right = mid - 1;
    //         }
    //         else{
    //             left = mid + 1;
    //         }
    //     }
    //     return -1;

    // }
}