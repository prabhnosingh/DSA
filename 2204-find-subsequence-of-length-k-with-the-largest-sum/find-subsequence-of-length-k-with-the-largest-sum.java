class Solution {
    // intuition 1: use 2D array to store index and number. Then sort the 2D array in descending order based on
    // number value. Then sort the first K elements based on the index to retain original order of elements.
    // Then add the first K elements to the ans.
    public int[] maxSubsequence(int[] nums, int k) {
        int [] ans = new int[k];
        int [][] idxNumArr = new int[nums.length][2];

        for(int i = 0; i < nums.length; i ++){
            idxNumArr[i][0] = nums[i]; 
            idxNumArr[i][1] = i; 
        }

        Arrays.sort(idxNumArr, (x1, x2) -> Integer.compare(x2[0], x1[0])); // descending order

        Arrays.sort(idxNumArr, 0, k, (x1, x2) -> Integer.compare(x1[1], x2[1]));

        for(int i = 0; i < k; i ++){
            ans[i] = idxNumArr[i][0];
        }
        return ans;
    }
}