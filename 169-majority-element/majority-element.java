class Solution {
    public int majorityElement(int[] nums) {
        
    // Arrays.sort(nums);

    // return nums[nums.length/2];   
        
//******************************************************************** */
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int n = nums.length/2;

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() > n){
                return entry.getKey();
            }
        }
        return 0;


//********************************************************************* */        
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }
        
        // int n = nums.length/2;
        // for(int k : map.keySet()){  

            
        //      if(map.get(k) > n ){
        //        return k;
        //     }

           

        // }
        // return 0;

        //*******************************************************
        // HashMap<Integer, Integer> map = new HashMap<>();

        // for(int num : nums){
        //     map.put(num, map.getOrDefault(num, 0)+1);
        // }
        // // HashSet<Integer> set = new HashSet<>();
        
        // int maxCount = 0;
        // int MKey = nums[0];
        // int n = nums.length/2;
        // for(int k : map.keySet()){  

        //     if(map.get(k) > maxCount){
        //         maxCount = map.get(k);
        //         MKey = k;
        //     }

           

        // }
        // return MKey;
    }
}