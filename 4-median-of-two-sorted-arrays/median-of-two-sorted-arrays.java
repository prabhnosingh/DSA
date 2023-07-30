class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        double median = 0.0;
        int mid = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;

        int[] nums = new int[len];
        int i = 0;
        int j = 0;
        int k = 0;

        while(k < len){

            if(i < len1 && j < len2){

                if(nums1[i] < nums2[j]){
                    nums[k++] = nums1[i++];
                      
                }
                else{
                    nums[k++] = nums2[j++];
                    }   
            }
            else if(i >= len1 && j < len2){
                nums[k++] = nums2[j++];

            }
            else if(i < len1 && j >= len2){
                nums[k++] = nums1[i++];
            }
        }


        mid = len/2;
    
        if(len % 2 == 0){
            median = (float)(nums[mid] + nums[mid-1])/2;  
        }
        else{
            median = nums[mid];
        }

        return median;
  
    }
}


