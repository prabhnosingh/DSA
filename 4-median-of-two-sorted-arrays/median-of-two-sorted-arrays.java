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

        // if(len2 == 0){
        //     mid = len1/2;
        //     if(mid !=0 ){
        //         if( mid == 1 || len1 % 2 == 0){
        //           median = (double)(nums1[mid] + nums1[mid - 1]) / 2;
        //      }
        //     else{
        //          median = nums1[mid];
        //         }
        //         return median;
        //       }
        //       else{
        //           return nums1[mid];
        //       }
        // }
        // else if(len1 == 0){
        //      mid = len2/2;
        //     if(mid !=0){
        //         if(mid == 1 || len2 % 2 == 0){
        //             median = (double)(nums2[mid] + nums2[mid - 1]) / 2;
        //      }
        //         else{
        //         median = nums2[mid];
        //      }
        //     return median;
        //     }
        //     else{
        //         return nums2[mid];
        //     }
            
        // }




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

// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int n1 = nums1.length;
//         int n2 = nums2.length;
//         int n = n1 + n2;
//         int[] new_arr = new int[n];

//         int i=0, j=0, k=0;

//         while (i<=n1 && j<=n2) {
//             if (i == n1) {
//                 while(j<n2) new_arr[k++] = nums2[j++];
//                 break;
//             } else if (j == n2) {
//                 while (i<n1) new_arr[k++] = nums1[i++];
//                 break;
//             }

//             if (nums1[i] < nums2[j]) {
//                 new_arr[k++] = nums1[i++];
//             } else {
//                 new_arr[k++] = nums2[j++];
//             }
//         }

//         if (n%2==0) return (float)(new_arr[n/2-1] + new_arr[n/2])/2;
//         else return new_arr[n/2];
//     }
// }
