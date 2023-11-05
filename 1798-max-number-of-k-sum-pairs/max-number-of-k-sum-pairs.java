class Solution {
    public int maxOperations(int[] nums, int k) {
        
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length - 1;

        int op = 0;
        while( end >= 0 && nums[end] >= k){
            end --;
        }
        int sum = 0;
        while(start < end ){

            sum = nums[start] + nums[end];
            if(sum == k){
                op ++;
                start ++;
                end --;
            }
            else{
                if(sum > k){
                    end --;
                }
                else{
                    start ++;
                }
           
            }
        }

        return op;

// beats 6.93%
        // int op = 0;
        // HashMap <Integer, Integer> map = new HashMap<>();
        // for(int num : nums){
        //    map.put(num, map.getOrDefault(num, 0) + 1);
        // }

        // for(int num1 : nums){
        //     // if (num1 >= k){
        //     //     continue;
        //     // }
        //     int complement = k - num1;
        //     if(complement == num1){
        //         if(map.get(num1) == 1){
        //             continue;
        //         }
        //     }
        //     if(map.containsKey(complement)){
        //         if(map.get(num1) > 0 && map.get(complement) > 0){
        //          map.put(num1, map.get(num1) - 1);
        //          map.put(complement, map.get(complement) - 1);
        //          op ++;
        //         } 
        //     } 
        // }
        // return op;
    }
}