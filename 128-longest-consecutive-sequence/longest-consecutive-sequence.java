class Solution {
    public int longestConsecutive(int[] nums) {

        
        Arrays.sort(nums);
       
         PriorityQueue<Integer> mq= new PriorityQueue<Integer>(Collections.reverseOrder());
        int m=1;
    
        if(nums.length==0){
            return 0;
        }

        for(int i=0; i<nums.length-1; i++){
            
            if(nums[i]==nums[i+1]) continue;
       
        
            else if(nums[i]==nums[i+1]-1){
                m++;
                mq.add(m);
            }
            else{
                m=1;
            }
        }
    int i=1;
    if(mq.peek()!=null){ 
        i = mq.poll();
        }
    return i;
    }
    
}