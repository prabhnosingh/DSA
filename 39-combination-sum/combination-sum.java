// class Solution {
//      public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<>();
//         backtrack(res, new ArrayList<>(), candidates, target, 0);
//         return res;
//     }

//     private void backtrack(List<List<Integer>> res, List<Integer> currCombination, int[] nums, int currTarget, int start){

//         if(currTarget < 0) return;
//         else if(currTarget == 0){
//             res.add(new ArrayList<>(currCombination));
//         }
//         else{
//             for(int i = start; i < nums.length; i ++){
//                 currCombination.add(nums[i]);
//                 backtrack(res, currCombination, nums, currTarget - nums[i], i); // not i + 1 because same element can be reused
//                 currCombination.remove(currCombination.size() - 1); // remove the last added number in currCombination, because it will be either causing currTarget to become neagative(< 0) or currTarget to be zero
//             }
//         }
//     }

   
// }













// Beats 5%
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        int start = 0;
        dfs(res, candidates, target, start, combination);
        return res;
    }

    private void dfs(List<List<Integer>> res, int[] candidates, int target, int start, List<Integer> combination){
        if(helperSum(combination) == target){
            // res.add(combination); -> this does not work as we are storing 'combination' in 'res' and any change in it after that results in a change 
            // in the value stored in 'res'. Therefore, we need to store a copy of 'combination' in that particular instance, as done below.
            res.add(new ArrayList<>(combination));
            System.out.println(combination);
            return;
        }

        if(helperSum(combination) > target || start == candidates.length){
            return;
        }

        combination.add(candidates[start]);
        // adding the same candidate
        dfs(res, candidates, target, start, combination);

        // not adding the same number again by doing 'start + 1' and removing the last number added from the combination 
        combination.remove(combination.size() - 1);
        dfs(res, candidates, target, start + 1, combination);
    }


    private int helperSum(List<Integer> list){
        int sum = 0;
        for(int n : list){
            sum += n;
        }
        return sum;
    }
}