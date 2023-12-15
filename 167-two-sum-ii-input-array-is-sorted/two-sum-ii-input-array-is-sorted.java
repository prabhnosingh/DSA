class Solution {
    public int[] twoSum(int[] numbers, int target) {
       
        if(numbers.length == 2){
            return new int[]{1,2};
        }

        int start = 0;
        int end = numbers.length - 1;

        while(start < end){
            int sum = numbers[start] + numbers[end];
            if(sum == target){
                return new int[]{start + 1, end + 1};
            }
            else if(sum < target){
                start ++;
            }
            else{
                end --;
            }

        }
        return new int[]{0,0};






















/////////////////////////////////////////////////////////////////////////   
       // int start = 0;
        // int end = numbers.length - 1;

        // while(start < end){

        //     int sum = numbers[start] + numbers[end];

        //     if(sum == target){
        //         return new int[] {start + 1, end + 1};
        //     }
        //     else if(sum < target){ 
        //         start ++;
        //     }
        //     else{
        //         end --;
        //     }

        // }
        // return new int[0];
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
///////////////////////////////////////////////////////////////////////////////       
        // int start=0, end= numbers.length-1;
        // while(start!=end){
        //     int sum= numbers[start]+ numbers[end];
        //     if(sum==target){
        //         int[] arr= {start+1, end+1};
        //         return arr;

        //     }
        //     else if(sum> target){
        //         end--;

        //     }
        //     else{
        //         start++;
        //     }
        // }
        // return new int[0];
        
    }
}