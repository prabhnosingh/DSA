class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];

        for(int i = 0; i < nums.length; i ++){
            int complement = target - nums[i];

            if(map.containsKey(nums[i])){
                // return new int[]
                ans[0] = i;
                ans[1] = map.get(nums[i]);
                break;
            }
            map.put(complement, i);
        }
        return ans;


































        // int start = 0;
        // int end = 1;
        // int window = 1;

        // while(true){
        //     if(nums[start] + nums[end] == target){
        //         break;
        //     }

        //     else if(end == nums.length - 1){
        //         window ++;
        //         start = 0;
        //         end = window;
        //     }
            
        //     else{
        //         start ++;
        //         end ++;
        //     }
        // }

        // return new int[]{start, end};
        
//************************************************************************* */   
   //  beats 60 %
    // Map<Integer, Integer> map1= new HashMap<>();

    //    int[] result = new int[2];
    // //    int s=0;
    // //    int e=0;

    //     for(int i=0; i < nums.length; i++){
    //         int complement = target - nums[i];
    //         if(!map1.containsKey(complement)){
    //             map1.put(nums[i],i);
    //         }
    //         else{
    //             result[0] = map1.get(complement);
    //             result[1] = i;
    //         //    s = map1.get(complement);
    //         // e = i;
                

                
    //         }
    //     }
    //     // return new int[]{s,e};
    //     return result;
        
       
    }
  }

