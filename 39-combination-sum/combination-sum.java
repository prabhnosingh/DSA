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

        // not adding the same number again by doing 'start + 1' and removing the last number added  
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