class Solution {

    //Solving on 25 Aug 2026

    //intuitoin 4: bottom-up approach
        //Topic: DP
        //Pattern: 1D DP
        //Sub-pattern: Prefix DP / String Partitioning


        //To find if s[i, s.length() - 1] is successfully possible to segment we need to find if 
            //s[i, j] and s[j+1, s.length() - 1] can successfully be segmented

        //The sub-problem to solve is: Given that a substring s[i,j] is present in wordDict, does 
            //s[j + 1, s.length()-1] segment successfully

        //dp invariant
            //Therefore, dp invariant is as follows:
            //dp[i] represent whether substring starting from index i till s.length() - 1 can successfully
                //be segmented
            //dp[0] will represent whether the whole string s can successfully be segmented
            //Therefore, we will need a boolean dp array of length s.length+1
        
        //base case 
            //[s.length(), s.length() - 1] means no character (empty) and an empty substring is considered
                //successfully segmented
            //dp[s.length()] = true

        //recurrence relation
            //The question at dp[i] is, is there any ending index j such that:
                //s[i...j] is present in wordDict and s[j+1....n-1] is segmentable
            //And since dp[j+1] represents whether s[j+1....n -1] can successfully be segmentable
                //dp[i] = dp[j+1] when s[i...j] is present in the wordDict 
            
        //pseudo code
            //we will run two nexted for-loops:
                //outer loop will keep track of startingIdx starting from n-1 towards 0 (right to left)
                //innter loop will keep track of endingIdx starting from each startingIdx towards n (left 
                    //to right)
            
            //for each word match, assign dp[i] = d[j+1]
        

        //TC: O(n^2):
            //O(n) : There are only n unique states (dfs(0), dfs(1), ... dfs(n-1)) 
            //and for every state we try upto n ending indices
        //SC: O(n + n) = O(n) : Size of recursive stack + size of memo
    public boolean wordBreak(String s, List<String> wordDict) {
        
        int n = s.length();

        boolean[] dp = new boolean[n+1];
        HashSet<String> wordDictSet = new HashSet<>(wordDict);

        dp[n] = true; //base case

        for(int startingIdx = n-1; startingIdx >= 0; startingIdx --){
            for(int endingIdx = startingIdx; endingIdx < n; endingIdx ++){
                String currWord = s.substring(startingIdx, endingIdx + 1);
                if(wordDictSet.contains(currWord)){
                    dp[startingIdx] = dp[startingIdx] || dp[endingIdx + 1];
                    //s[startingIdx, endingIdx] is found in the wordDict, now see if s[endingIdx+1, n-1] is
                        //segmentable
                }
                if(dp[startingIdx]) {
                    break; //if staringIdx can successfully be segmented then there is no
                    //need to traverse rest of the characters
                }
            }
        }

        return dp[0];

    }







///////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 25 Aug 2026

//     //intuitoin 3: (dfs + memoization) - top-down approach
//         //Topic: DP
//         //Pattern: 1D DP
//         //Sub-pattern: Prefix DP / String Partitioning
//         //Equivalent top-down pattern: DFS + Memoization on Index

//         //Brute force way to solve this would be to start constructing substrings out of s and
//             //see if that matches with any word in wordDict
//         //In recursive call pass the starting index and explore all the ending indices using a 
//             //for loop. Construct a substring based on starting and ending index at each stage
//             //and see if that substring is present in the wordDict, if yes, proceed with next 
//             //index. If the starting index reaches length of the string s, return true. This
//             //means that the last substring is also present in the wordDict
        
//         //Base case:
//             //If currStartIdx reaches s.length(), all characters before it have already been consumed
//                 //as a valid dictionary words. Therefore, the entire string have been successfully segmented

//         //We can use an int array of size s.length() to mark all the starting indices that
//             //can successfully be segemented as 1 and all the starting indices that CANNOT
//             //be successfully segmented as -1 to avoid re-traversing the same branches
//         //memo[i] = whether s[i....n-1] can be successfully segmented

//         //sub-problem - if a substring present till index i is present in wordDict, can remaining 
//             //substring be segmented successfully 

        

//         //TC: O(n^2):
//             //O(n) : There are only n unique states (dfs(0), dfs(1), ... dfs(n-1)) 
//             //and for every state we try upto n ending indices
//         //SC: O(n + n) = O(n) : Size of recursive stack + size of memo
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         int[] memo = new int[s.length()];
//         HashSet<String> wordDictSet = new HashSet<>(wordDict);
//         return dfs(s, 0, wordDictSet, memo);

//     }   

//     private boolean dfs(String s, int currStartIdx, HashSet<String> wordDictSet, int[] memo){
        
//         if(currStartIdx == s.length()){
//             return true;
//         } 

//         else if(memo[currStartIdx] == -1) return false; //this means that I have tried every possible
//             //ending index starting from currStartIdx, and none led to a valid complete segmentation
//         else if(memo[currStartIdx] == 1) return true;

        

//         //generates every candidate word starting from currStartIdx
//         for(int currEndIdx = currStartIdx; currEndIdx < s.length(); currEndIdx ++){ 

//             // if(memo[currEndIdx]) return true;

//             String currWord = s.substring(currStartIdx, currEndIdx + 1);

//             //the below code means that if current prefix is a dictionary word AND remaining suffix can
//                 //also be segmented then whole substring starting from currStartIdx can be segmented
//             if(wordDictSet.contains(currWord)){
//                 if(dfs(s, currEndIdx + 1, wordDictSet, memo)) {
//                     memo[currStartIdx] = 1;
//                     return true;
//                 }
//             }
//         }

        
//         //this comes into play when all the combinations of ending idx have been tried without ever reaching
//             //at s.length() index (base case). So this implies that the branch taken above is not correct and 
//             //does not result in successful segmentation
//         //If none of the possible ending indices lead to a successful segmentation, then the suffix starting at
//             //currStartIdx cannot be segmented
//         memo[currStartIdx] = -1;
//         return false;

//     }







// ///////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 25 Aug 2026

//     //intuitoin 2: (removing currWordSb and only using startIdx) - TLE
//         //Topic: DP
//         //Pattern: 1D DP
//         //Sub-pattern: Prefix DP / String Partitioning
//         //Equivalent top-down pattern: DFS + Memoization on Index

//         //Brute force way to solve this would be to start constructing substrings out of s and
//             //see if that matches with any word in wordDict
//         //In recursive call pass the starting index and explore all the ending indices using a 
//             //for loop. Construct a substring based on starting and ending index at each stage
//             //and see if that substring is present in the wordDict, if yes, proceed with next 
//             //index. If the starting index reaches length of the string s, return true. This
//             //means that the last substring is also present in the wordDict


        

//         //TC: O(): 
//         //SC: O(n) : Size of recursive stack
//     public boolean wordBreak(String s, List<String> wordDict) {
        
//         return dfs(s, 0, wordDict);

//     }   

//     private boolean dfs(String s, int currStartIdx, List<String> wordDict){
        
//         if(currStartIdx == s.length()){
//             return true;
//         } 

//         //generates every candidate word starting from currStartIdx
//         for(int currEndIdx = currStartIdx; currEndIdx < s.length(); currEndIdx ++){ 

//             String currWord = s.substring(currStartIdx, currEndIdx + 1);

//             if(wordDict.contains(currWord)){
//                 if(dfs(s, currEndIdx + 1, wordDict)) return true;
//             }
//         }

        
//         //this comes into play when all the combinations of ending idx have been tried without ever reaching
//             //at s.length() index (base case). So this implies that the branch taken above is not correct
//         return false;

//     }







// ///////////////////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1: 
    //     //Topic: DP
    //     //Pattern: 1D DP
    //     //Sub-pattern: Prefix DP / String Partitioning
    //     //Equivalent top-down pattern: DFS + Memoization on Index

    //     //Brute force way to solve this would be to start constructing substrings out of s and
    //         //see if that matches with any word in wordDict
    //     //If a single word matches in the wordDict, then we have two options:
    //         //keep on looking for other words from the index where the previous word ends, or 
    //             //keep appending to the substring and look for that.
    //         //If the index is reached till end while matching
    //         //every word/sub-word with wordDict, return true

    //     //TC: O(2^n) : For each index we are having a choice of choose or not choose
    //     //SC: O(n) : Size of recursive stack
    // public boolean wordBreak(String s, List<String> wordDict) {
        
    //     StringBuilder sb = new StringBuilder();
    //     // sb.append(s.charAt(0));
    //     return dfs(s, sb, 0, wordDict);

    // }   

    // private boolean dfs(String s, StringBuilder currWordSb, int currStartIdx, List<String> wordDict){
        
    //     if(currStartIdx == s.length()){
    //         if(currWordSb.length() == 0) return true;
    //         //if currWordSb.length() == 0 then that would mean that the last substring of s is also 
    //             //present in the wordDict
    //         else return false;
    //     } 

    //     // Boolean res = true;

    //     //currWordSb.length() check as in the scenario where none of the substrings match with 
    //         //wordDict then currStartIdx will naturally reach end of the string but will 
    //         //currWordSb non-null
    //     // if(currEndIdx == s.length()) return false;
    //     currWordSb.append(s.charAt(currStartIdx));
    //     if(wordDict.contains(currWordSb.toString())){
    //         // boolean res = true;
            
    //         StringBuilder newCurrWordSb = new StringBuilder();
    //         if(dfs(s, currWordSb, currStartIdx + 1, wordDict) ||  //exploring current path
    //         dfs(s, newCurrWordSb, currStartIdx + 1, wordDict)) return true; //exploring new path

    //         return false;
    //         // if(!) return false; 
    //     }
    //     else{
    //         // currWordSb.append(s.charAt(currStartIdx + 1));
    //         if(!dfs(s, currWordSb, currStartIdx + 1, wordDict)) return false;
    //     }

    //     return true;

    // }
}