class Solution {
    public int pivotIndex(int[] nums) {
        int pi = -1;
        for(int idx = 0; idx < nums.length; idx ++){
            int varL = idx - 1;
            int varR = idx + 1;
            int totalLeft = 0;
            int totalRight = 0;
            while(varL >= 0){
                totalLeft += nums[varL];
                varL --;
            }
            while(varR < nums.length){
                totalRight += nums[varR];
                varR ++;
            }
            if(totalRight == totalLeft){
                return idx;
            }
        }
        return pi;
    }
}