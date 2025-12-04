class Solution {

    //Solving 03 Dec 2025:

    //intuition 2 (DP):
    public int numDecodings(String s) {
        int sLen = s.length();
        int[] dp = new int[sLen + 1];

        dp[sLen] = 1;

        for(int i = sLen - 1; i >=0; i --){
            if(s.charAt(i) == '0'){
                dp[i] = 0;
            }
            else{
                dp[i] = dp[i + 1];
            }
            if(i + 1 < sLen && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1))){
                dp[i] += dp[i + 2];
            }
        }
        return dp[0];
 
    }
  

///////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving 03 Dec 2025:

    // //intuition 1 (Backtracking - TLE): 
    //     //If there are leading zeros, the string is simply not a valid encoding, return 0.
    //     //If any intermediate substring contains leading 0s, then that substring is not a
    //         //valid encoding.
    //     //If any substring goes beyond 26, like 39, 28, 79, etc., then that substring is not 
    //         //a valid encoding.

    //     //Basically we have to find the number of valid substrings.
    //     //Use backtracking solution to find all the valid substring combinations. Store the
    //         //combinations in a list of list and return the size of that list
    // public int numDecodings(String s) {
    //     List<List<String>> allCombinations = new ArrayList<>();

    //     findCombinations(s, 0, allCombinations, new ArrayList<>());
    //     return allCombinations.size();
    // }
    
    // private void findCombinations(String s, int currIdx, List<List<String>> allCombinations, List<String> currCombination){
    //     if(currIdx == s.length()){
    //         allCombinations.add(new ArrayList<>(currCombination));
    //         return;
    //     }

    //     // System.out.print("currTempSubstring inserting to currComb :");
    //     for(int i = currIdx; i < s.length(); i ++){

    //         String currTempSubstring = s.substring(currIdx, i + 1);
    //         if(!isValidSubstring(currTempSubstring)){ //only add valid substrings to the currCombination
    //             return;
    //         }
    //         System.out.print(currTempSubstring + ", ");
    //         currCombination.add(currTempSubstring);
            
    //         findCombinations(s, i + 1, allCombinations, currCombination);

    //         // currCombination.remove(currCombination.size() - 1);
    //         currCombination.removeLast();
            
    //     }
    //     System.out.println();

    //     // currCombination.removeLast();
    // }


    // private boolean isValidSubstring(String s){
    //     if(s.length() == 0 || s.length() > 2){
    //         return false;
    //     }

    //     if(s.charAt(0) == '0'){
    //         return false;
    //     }

    //     if(Integer.parseInt(s) > 26){
    //     // if(Integer.valueOf(s) > 26){
    //         return false;
    //     }

    //     return true;
    // }
}