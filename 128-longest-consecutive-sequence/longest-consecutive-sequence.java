// class Solution {
//     public int longestConsecutive(int[] nums) {

        
//         Arrays.sort(nums);
       
//         PriorityQueue<Integer> mq= new PriorityQueue<Integer>(Collections.reverseOrder());
//         int m = 1;
    
//         if(nums.length==0){
//             return 0;
//         }

//         for(int i = 0; i < nums.length - 1; i ++){
            
//             if(nums[i] == nums[i+1]) continue;
       
        
//             else if(nums[i] == nums[i+1]-1){
//                 m ++;
//                 mq.add(m);
//             }
//             else{
//                 m=1;
//             }
//         }
//     int i = 1;
//     if(mq.peek() != null){ 
//         i = mq.poll();
//         }
//     return i;
//     }
    
// }

class Solution {
    public int longestConsecutive(int[] nums) {
       if (nums.length == 0) return 0;
       HashSet<Integer> hs = new HashSet<>();
       for(int num:nums) hs.add(num);
       int longest =1;
       for(int num: nums ){
           //check if the num is the start of a sequence by checking if left exists
           if(!hs.contains(num-1)){ // start of a sequence
                int count =1;
                while(hs.contains(num + 1)){ // check if hs contains next no.
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
                
           }
           if(longest > nums.length/2) break;

       }
       return longest;
    }
}
