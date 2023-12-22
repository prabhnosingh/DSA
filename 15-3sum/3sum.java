class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        

        for(int i = 0; i < nums.length -2; i ++){

            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int first = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            int sum = 0;  
            while(left < right){

                int second = nums[left];
                int third = nums[right];
                sum = first + second + third;

                if(sum == 0){
                    ans.add(Arrays.asList(first, second, third));
                    left ++;
                    while(nums[left] == nums[left - 1] && left < right){
                        left ++;
                    }
                    
                }   

                else if(sum > 0){
                   right --;
                }
                else{
                    
                    left ++;
                }
            }
        }
    return ans;
























//////////////////////////////////////////////////////////////////////////////////////////////
    // int[] twoSum(int[] nums, int idx, int target){

    //     HashMap<Integer, Integer> map = new HashMap<>();

    //     int complement = 0; 
    //     for(int i = 0; i < nums.length; i ++){
    //         if(i == idx){
    //             continue;
    //         }
    //         complement = target - nums[i];

    //         if(map.containsKey(complement)){
    //             return new int[]{i, map.get(complement)};
    //         }
    //         map.put(nums[i], i);
    //     }   
    //     return new int[]{-1,-1};
    // }
    // public List<List<Integer>> threeSum(int[] nums) {
    //     HashSet<List<Integer>> set = new HashSet<>();
    //     List<List<Integer>> ans = new ArrayList<>();
     
    //   for(int i = 0; i < nums.length; i ++){

        
    //       int[] twoS = twoSum(nums, i, -nums[i]);
    //       if(twoS[0] != -1 && twoS[1] != -1){
    //         int[] temp = new int[3];
    //         temp[0] = nums[i];
    //         temp[1] = nums[twoS[0]]; 
    //         temp[2] = nums[twoS[1]];
    //         Arrays.sort(temp);
    //         set.add(Arrays.asList(temp[0], temp[1], temp[2]));
    //       }
        
         

    //   }
    //          ans.addAll(set);
    //   return ans;      























//*********************************************************************** */
        // beats 11.53%
        // int target = 0;
        // Arrays.sort(nums);
        // Set<List<Integer>> s = new HashSet<>();
        // List<List<Integer>> output = new ArrayList<>();

        // for(int i = 0; i < nums.length; i ++){
        //     int j = i + 1;
        //     int k = nums.length - 1;

        //     while(j < k){
        //         int sum = nums[i] + nums[j] + nums[k];

        //         if(sum == target){
        //             s.add(Arrays.asList(nums[i], nums[j], nums[k]));
        //             j ++;
        //             k --;
        //         }
        //         else if(sum < target){
        //             j ++;
        //         }
        //         else{
        //             k --;
        //         }
        //     }

        // }
        // output.addAll(s);
        // return output;
    

    }
}