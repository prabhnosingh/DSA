class Solution {
    public int findDuplicate(int[] nums) {

    //     int slow = 0;
    //     int fast = 0;

    //     while(true){
    //         slow = nums[slow];
    //         fast = nums[nums[fast]];
    //         if(slow == fast) break;
    //     }
       
    //    int slow2 = 0;
    //    while(true){

    //        slow = nums[slow];
    //        slow2 = nums[slow2];
    //        if(slow == slow2) break;
    //    }

    //    return slow;

//******************************************************************** */
        for(int num : nums){
            if(nums[Math.abs(num)] < 0){
                return Math.abs(num);
            }
            else{
                nums[Math.abs(num)] *= -1;
            }
        }
        return -1;


//******************************************************************** */      
        // int len = nums.length;
        // int[] freq = new int[len];

        // for(int i = 0; i < len; i++){
        //     if(freq[nums[i]] == 0) freq[nums[i]] ++;
        //     else return nums[i];
        // }
        // return 0;
//******************************************************************** */
    //    HashSet<Integer> set = new HashSet<>();
    //    int doubleNum = 0;

    //     for(int num : nums){
    //         if(set.contains(num)) {
    //         doubleNum = num;
    //         break;  
    //         }
    //         set.add(num);
    //     }
    //     return doubleNum;

        }
}