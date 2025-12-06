class Solution {
    //intuition 1:
    public int smallestEqual(int[] nums) {
        int minIdx = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i ++){
            if(i % 10 == nums[i]){
                minIdx = Math.min(minIdx, i);
            }
        }
    return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}