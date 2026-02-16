class Solution {

    //Re-Solving on 15 Feb 2026

    //intuition 1: dp : 1D
        //base case:
            //if s.charAt(0) == 0 return 0
            //dp[0] = 1 //there is 1 way to decode an empty string
            //dp[1] = 1 
        
        //any state i starting from 2 should follow the below algo:
            //number of ways to decode i length of string depends on two states: 
                //ways to decode till last character (dp[i-1]) and,
                //ways to decode till last two characters (dp[i-2])
            
            //if the present character (s.charAt(i-1))is a valid one, i.e. is a non-zero character then 
                //consider dp[i-1] state to be added to the dp[i] state

            //if the present character (s.charAt(i-1)) combined with previous character (s.charAt(i-2))
                //forms a valid two digit number, i.e. lies between 10 - 26 (inclusive) then consider
                //dp[i-2] state to be added to the dp[i] state.

        //We add these two states because any new digit added can form a decoded version independently (only 
            //if valid) or in partnership with previous digit (only if valid)

        //During finding the number of ways to decode two digits act like a single entity that cannot be split and
            //should be considered as if a single number is being added.

        
    public int numDecodings(String s) { 
        //dp[i] represent the number of ways to decode a string of length i
        //dp[s.length] will represent the number of ways to decode a string of length s.length
        //Therefore, we need a dp array of length s.length + 1

        if(s.charAt(0) == '0') return 0;

        int sLen = s.length();
        
        if(sLen == 1) return 1;

        int[] dp = new int[sLen + 1];
        dp[0] = 1; //there is 1 way to decode an empty string, i.e. by doing nothing
        dp[1] = 1; //ensured to be non-zero

        for(int i = 2; i < sLen + 1; i ++){
            // int oneDigit = Integer.parseInt(s.substring(i-1, i));
            // int twoDigits = Integer.parseInt(s.substring(i-2, i));

            char currChar = s.charAt(i-1);
            char lastChar = s.charAt(i-2);

            int oneDigit = currChar - '0';

            int twoDigits = (lastChar - '0') * 10 + oneDigit;

            if(oneDigit != 0) dp[i] += dp[i-1];
            if(twoDigits >= 10 && twoDigits <= 26) dp[i] += dp[i-2];
        }

        return dp[sLen];

    }


























/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //The question is similar to "Climbing stairs" question with extra constraints

//     //Solving 04 Dec 2025:

//     //intuition 2 (DP):

//     // waysToDecod[i] = waysToDecode[i - 1] (if new single digit is valid) + waysToDecode[i - 2] (if last 2 digits are valid)
//         //single digit is valid means that the new ith digit is not a zero (1, 2, 3, .... 9)
//         //last 2 digits are valid means:
//             //If 2nd last char (at i-1) is a 1, then we accept any value in the last char (at i) as anything after 1 is 
//                 //a valid mapping (10, 11, 12, 13, ............. 19)
//             //But if 2nd last char (at i-2) is a 2, then we only accept values from "0123456" in the last char (at i - 1),
//                 //as anything more than that will lead to invalid mapping (27, 28, 29) 
//          //basically the last 2 digits should be in range of 10 and 26 inclusive        


//     //Move from left to right in the dp array:
//         //Fill 0 index with 1, because when the length of the string is 0 there is only 1 way to decode it, that is by doing
//             //nothing
//         //Fill the 1st index with 0 if the first number is 0 else fill 1st index with 1
//         //Now observe if next index (i) have a valid single digit number, if yes, add dp[i - 1] to dp[i]. dp[i] += dp[i - 1]
//             //if the addition of the ith digit result in a valid 2 digit number (from i - 1 to i inclusive), then 
//                 //add dp[i - 2] to dp. dp[i] +=  dp[i - 2]
//             //final value of dp[i] will be dp[i] = dp[i - 1] + dp[i - 2]
        
//     public int numDecodings(String s) {
        
//         //dp[i] represents the number of ways string until index i can be decoded
//         //dp[sLen] will represent the number of ways the whole string can be decoded

//         int sLen = s.length();
//         int[] dp = new int[sLen + 1];
        
//         dp[0] = 1;
        
//         if(s.charAt(0) == '0'){
//             dp[1] = 0;
//         }
//         else{
//             dp[1] = 1;
//         }

//         for(int i = 2; i <= sLen; i ++){
           
//            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
//            int twoDigits = Integer.parseInt(s.substring(i - 2, i));

//             //checking if oneDigit is valid
//             if(oneDigit >= 1){
//                 dp[i] += dp[i - 1];
//             }

//             //checking if twoDigits is valid
//             if(twoDigits >= 10 && twoDigits <= 26){
//                 dp[i] += dp[i - 2];
//             }


//         }

//         return dp[sLen];


//     }








// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //Solving 04 Dec 2025:

    // //intuition 1 (DP):

    // // waysToDecod[i] = waysToDecode[i - 1] (if new single digit is valid) + waysToDecode[i - 2] (if last 2 digits are valid)
    //     //single digit is valid means that the new ith digit is not a zero (1, 2, 3, .... 9)
    //     //last 2 digits are valid means:
    //         //If 2nd last char (at i) is a 1, then we accept any value in the last char (at i + 1) as anything after 1 is 
    //             //a valid mapping (10, 11, 12, 13, ............. 19)
    //         //But if 2nd last char (at i) is a 2, then we only accept values from "0123456" in the last char (at i + 1),
    //             //as anything more than that will lead to invalid mapping (27, 28, 29) 


    // //Move from left to right in the dp array:
    //     //Fill 0 index with 1, because when the length of the string is 0 there is only 1 way to decode it, that is by doing
    //         //nothing
    //     //Fill the 1st index with 0 if the first number is 0 else fill 1st index with 1
    //     //Now observe if next index (i) have a valid single digit number, if yes, add dp[i - 1] to dp[i]. dp[i] += dp[i - 1]
    //         //if the addition of the ith digit result in a valid 2 digit number (from i - 1 to i inclusive), then 
    //             //add dp[i - 2] to dp. dp[i] +=  dp[i - 2]
    //         //final value of dp[i] will be dp[i] = dp[i - 1] + dp[i - 2]
        
    // public int numDecodings(String s) {
        
    //     //dp[i] represents the number of ways string until index i can be decoded
    //     //dp[sLen] will represent the number of ways the whole string can be decoded

    //     int sLen = s.length();
    //     int[] dp = new int[sLen + 1];
        
    //     dp[0] = 1;
        
    //     if(s.charAt(0) == '0'){
    //         dp[1] = 0;
    //     }
    //     else{
    //         dp[1] = 1;
    //     }

    //     for(int i = 2; i <= sLen; i ++){
    //         if(s.charAt(i - 1) != '0'){
    //             dp[i] += dp[i - 1];
    //         }

    //         if(s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && "0123456".indexOf(s.charAt(i - 1)) != - 1)){
    //             dp[i] += dp[i - 2];
    //         }


    //     }

    //     return dp[sLen];


    // }















/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // // Solving 04 Dec 2025:

    // // intuition 2 (DP):




    // public int numDecodings(String s) {
    //     int sLen = s.length();
    //     int[] dp = new int[sLen + 1];

    //     dp[sLen] = 1;

    //     for(int i = sLen - 1; i >=0; i --){
    //         if(s.charAt(i) == '0'){
    //             dp[i] = 0;
    //         }
    //         else{
    //             dp[i] = dp[i + 1];
    //         }
    //         if(i + 1 < sLen && (s.charAt(i) == '1' || (s.charAt(i) == '2' && "0123456".indexOf(s.charAt(i + 1)) != -1))){
    //             dp[i] += dp[i + 2];
    //         }
    //     }
    //     return dp[0];
 
    // }
  

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