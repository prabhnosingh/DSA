class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, List<Integer> currCombination, int[] candidates, int currTarget, int start){
        if(currTarget < 0){
            return;
        }
        else if(currTarget == 0){
            res.add(new ArrayList<>(currCombination));
            return;
        }
        else{
            for(int i = start; i < candidates.length; i ++){
                if(candidates[i] > currTarget){
                break;
                }
                if(i > start && candidates[i - 1] == candidates[i]) continue; // for skipping duplicates
                currCombination.add(candidates[i]);
                backtrack(res, currCombination, candidates, currTarget - candidates[i], i + 1);
                currCombination.remove(currCombination.size() - 1);
            }
        }
    }
}