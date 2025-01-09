class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> currSubset, int[] nums, int start){
        res.add(new ArrayList<>(currSubset));
        
        
        for(int i = start; i < nums.length; i ++){
            currSubset.add(nums[i]);
            backtrack(res, currSubset, nums, i + 1); // because we do not want to reuse the same element
            currSubset.remove(currSubset.size() - 1);
        }

    }
 
     
}
















// beats 2 %
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         List<Integer> subset = new ArrayList<>();
//         dfs(nums, 0, subset, res);
//         return res;
//     }
//     // subset will be the temporary set that will be added into res(result -> power set)

//     private void dfs(int[] nums, int i, List<Integer> subset, List<List<Integer>> res){
//         if(i == nums.length){
//             res.add(new ArrayList<>(subset));
//             System.out.println("subset that is added to res is: " + subset); 
//             // subset that is added to res is: [1, 2, 3]
//             // subset that is added to res is: [1, 2]
//             // subset that is added to res is: [1, 3]
//             // subset that is added to res is: [1]
//             // subset that is added to res is: [2, 3]
//             // subset that is added to res is: [2]
//             // subset that is added to res is: [3]
//             // subset that is added to res is: []
//             return;
//         }

//         // decision to include the nums[i] in the subset
//         subset.add(nums[i]);
//         dfs(nums, i + 1, subset, res);
        
//         // decision to not include the nums[i] in the subset
//         // System.out.println("Subset before removing: " + subset); // Subset before removing: [1, 2, 3] 
//         subset.remove(subset.size() - 1);
//         // System.out.println("Subset after removing: " + subset); // Subset after removing: [1, 2] -> subset.remove(2) -> here 2 is the index that is in this case number '3'.
//         dfs(nums, i + 1, subset, res);
//     }
// }