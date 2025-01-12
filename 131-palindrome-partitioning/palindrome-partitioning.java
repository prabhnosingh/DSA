class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> currCombination = new ArrayList<>();
        dfs(res, currCombination, s, 0);
        return res;
    }
    

        private void dfs(List<List<String>> res, List<String> currCombination, String s, int start){
            
            if(start >= s.length()){
                res.add(new ArrayList<>(currCombination));
                return;
            }
            
            for(int i = start; i < s.length(); i ++){
                if(isPalindrome(s.substring(start, i + 1))){
                    currCombination.add(s.substring(start, i + 1));
                    dfs(res, currCombination, s, i + 1);
                    currCombination.remove(currCombination.size() - 1);
                }
            }
        }
   



        private boolean isPalindrome(String s){
            
            int start = 0;
            int end = s.length() - 1;
            
            if(end == -1) return false;

            while(start < end){
                if(s.charAt(start) != s.charAt(end)){
                    return false;
                }
                start ++;
                end --;
            }

            return true;
        }
}