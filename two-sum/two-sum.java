class Solution {
    public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map1= new HashMap<>();

       int[] result = new int[2];
    //    int s=0;
    //    int e=0;

        for(int i=0; i<nums.length; i++){
            int complement = target - nums[i];
            if(!map1.containsKey(complement)){
                map1.put(nums[i],i);
            }
            else{
                result[0] = map1.get(complement);
                result[1] = i;
            //    s = map1.get(complement);
            // e = i;
                

                
            }
        }
        // return new int[]{s,e};
        return result;
        
       
    }
  }

