class Solution {
    // // intuition 1: use 2D array to store index and number. Then sort the 2D array in descending order based on
    // // number value. Then sort the first K elements based on the index to retain original order of elements.
    // // Then add the first K elements to the ans.
    // public int[] maxSubsequence(int[] nums, int k) {
    //     int [] ans = new int[k];
    //     int [][] idxNumArr = new int[nums.length][2];

    //     for(int i = 0; i < nums.length; i ++){
    //         idxNumArr[i][0] = nums[i]; 
    //         idxNumArr[i][1] = i; 
    //     }

    //     Arrays.sort(idxNumArr, (x1, x2) -> Integer.compare(x2[0], x1[0])); // descending order

    //     Arrays.sort(idxNumArr, 0, k, (x1, x2) -> Integer.compare(x1[1], x2[1]));

    //     for(int i = 0; i < k; i ++){
    //         ans[i] = idxNumArr[i][0];
    //     }
    //     return ans;
    // }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // intuition 2: use min heap to keep track of k largest elements along with their indices. If heap's size becomes greater
    // than k then minimum element is removed. At last sort the k elements remaining in the heap with their respective indices.
    
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int i = 0; i < nums.length; i ++){
            pq.offer(new int[]{nums[i], i});
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[][] indices = pq.toArray(new int[0][0]);
        Arrays.sort(indices, Comparator.comparingInt(a -> a[1])); 
        // Comparator.compareInt(a -> a[1]) creates a comparator that sorts arrays(int[]) based on their second element (a[1])
        // means sort arrays in indices (eg: [20, 3]) according to there second(1st index) element (3 in this case)

        int[] result = new int[k];
        for(int i = 0; i < k; i ++){
            result[i] = nums[indices[i][1]];
        } 

        return result;
    }
}