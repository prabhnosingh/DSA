class Solution {
    public int maxOperations(int[] nums, int k) {
        
        // Arrays.sort(nums);

        // int start = 0;
        // int end = nums.length - 1;

        // int op = 0;
        // while(nums[end] >= k){
        //     end --;
        // }
        // while(start < end ){
        //     if(nums[start] + nums[end] == k){
        //         op ++;
        //         start ++;
        //         end --;
        //     }
        //     else{
        //         if(nums[end] > )
        //       int s = start + 1;
        //       while(s < end){
        //           if(nums[s] + nums[end]){

        //           }
        //       }
        //     }
        // }

        // return op;
        int op = 0;
        HashMap <Integer, Integer> map = new HashMap<>();
        for(int num : nums){
           map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int num1 : nums){
            // if (num1 >= k){
            //     continue;
            // }
            int complement = k - num1;
            if(complement == num1){
                if(map.get(num1) == 1){
                    continue;
                }
            }
            if(map.containsKey(complement)){
                if(map.get(num1) > 0 && map.get(complement) > 0){
                 map.put(num1, map.get(num1) - 1);
                 map.put(complement, map.get(complement) - 1);
                 op ++;
                } 
            } 
        }
        return op;
    }
}