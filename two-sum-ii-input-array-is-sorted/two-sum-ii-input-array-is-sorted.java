class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int start=0, end= numbers.length-1;
        while(start!=end){
            int sum= numbers[start]+ numbers[end];
            if(sum==target){
                int[] arr= {start+1, end+1};
                return arr;

            }
            else if(sum> target){
                end--;

            }
            else{
                start++;
            }
        }
        return new int[0];
        
    }
}