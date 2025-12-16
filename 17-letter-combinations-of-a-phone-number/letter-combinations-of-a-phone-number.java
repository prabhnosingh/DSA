class Solution {

    //Re-solving on 16 Dec 2025:

    //intuition 1(backtracking dfs):
        //Have a map for numbers and their alphabets. Then traverse over the digits recursively.  

        //Base case: when the length of currComb becomes equal to digits, add it to combinations.

    public List<String> letterCombinations(String digits) {
        List<String> combs = new ArrayList<>();
        HashMap<Character, String> digitsMap = new HashMap<>();

        digitsMap.put('2', "abc");
        digitsMap.put('3', "def");
        digitsMap.put('4', "ghi");
        digitsMap.put('5', "jkl");
        digitsMap.put('6', "mno");
        digitsMap.put('7', "pqrs");
        digitsMap.put('8', "tuv");
        digitsMap.put('9', "wxyz");


        dfs(digits, 0, combs, new StringBuilder(), digitsMap);
        return combs;

    }

    private void dfs(String digits, int currIdx, List<String> combs, StringBuilder currComb, HashMap<Character, String> digitsMap){
        
        if(currComb.length() == digits.length()){
            combs.add(new String(currComb));
            return;
        }

        char currNumChar = digits.charAt(currIdx);
        String currString = digitsMap.get(currNumChar);

        for(int i = 0; i < currString.length(); i ++){
            currComb.append(currString.charAt(i));
            
            dfs(digits, currIdx + 1, combs, currComb, digitsMap);

            //reverting the last added character
            currComb.setLength(currComb.length() - 1); //slightly more efficient as it involves less internal array copying 
                //than deleteCharAt
            // currComb.deleteCharAt(currComb.size() - 1);

        }

    }



    



















































    // ////////////////////////////////////////////////////////////////////////////////
    
    //intuition 1(Iterative): length of each combinatin will be equal to digits's length. Map every number to its corresponding 
    //characters as a String. Then for each digit in digits add the corresponding characters to the ans. It will be like
    //having a "ans" list of strings, then for 2 add "a", "b", "c" to the list. Then for 3 add "d" to all current strings in ans
    //"ad", "bd", "cd" and so on.

    // public List<String> letterCombinations(String digits) {
    //     HashMap<String, String> digitsMap = new HashMap<>();
    //     List<String> ans = new ArrayList<>();

    //     if(digits.length() == 0){
    //         return ans;
    //     }

    //     digitsMap.put("2", "abc");
    //     digitsMap.put("3", "def");
    //     digitsMap.put("4", "ghi");
    //     digitsMap.put("5", "jkl");
    //     digitsMap.put("6", "mno");
    //     digitsMap.put("7", "pqrs");
    //     digitsMap.put("8", "tuv");
    //     digitsMap.put("9", "wxyz");



    //     // System.out.println(digits.charAt(0));
    //     // System.out.println(digitsMap.get(2 + ""));
    //     // System.out.println(digitsMap.get(digits.charAt(0)));
    //     for(char ch : digitsMap.get(String.valueOf(digits.charAt(0))).toCharArray()){ //initializing ans with characters of 
    //     //first digit of digits
    //         ans.add(ch + "");
    //     }
    //     for(int currDigitsIdx = 1; currDigitsIdx < digits.length(); currDigitsIdx ++){
    //         List<String> tempAns = new ArrayList<>();
    //         for(char ch : digitsMap.get(String.valueOf(digits.charAt(currDigitsIdx))).toCharArray()){
    //             for(String s : ans){
    //                 s += ch;
    //                 tempAns.add(s);
    //             }
    //         }
    //         ans = tempAns;
    //     }
    //     return ans;

    // }


    ////////////////////////////////////////////////////////////////////////////////

    //intuition 2(Iterative without HashMap):
    // public List<String> letterCombinations(String digits) {
        
    //     List<String> ans = new ArrayList<>();

    //     if(digits.length() == 0){
    //         return ans;
    //     }
    //     ans.add("");

    //     String[] digitToChar = {
    //         "", "", "abc", "def", "ghi", "jkl", 
    //         "mno", "qprs", "tuv", "wxyz"
    //     };

    //     for(char digit : digits.toCharArray()){
    //         List<String> temp = new ArrayList<>();
    //         for(String currStr : ans){
    //             for(char ch : digitToChar[digit - '0'].toCharArray()){ //digit - '0' gives an integer as output
    //                 // currStr += ch; //don't use this as this updates currStr for next iterations as well
    //                 temp.add(currStr + ch);
    //             }
    //         }
    //         ans = temp;
    //     }
    //     return ans;
    // } 


    
    ////////////////////////////////////////////////////////////////////////////////

    // //intuition 3(dfs):
    // public List<String> letterCombinations(String digits) {
    //     List<String> ans = new ArrayList<>();

    //     if(digits.length() == 0){
    //         return ans;
    //     }
    //     String[] digitToChar = {
    //         "", "", "abc", "def", "ghi", "jkl", 
    //         "mno", "qprs", "tuv", "wxyz"
    //     };

    //     dfs(digits, 0, new StringBuilder(), digitToChar, ans);
    //     return ans;
    // }

    // private void dfs(String digits, int currDigitsIdx, StringBuilder currString, String[] digitToChar, List<String> ans){
    //     //we do not need an explicit check for currDigitsIdx as any string's length cannot exceed the length of digits,
    //     //therefore the out of bounds condition is automatically handled
    //     if(currString.length() == digits.length()){ //return when the currString length is same as length of digits
    //         ans.add(currString.toString());
    //         return;
    //     }

    //     for(char ch : digitToChar[digits.charAt(currDigitsIdx) - '0'].toCharArray()){
    //         currString.append(ch);
    //         dfs(digits, currDigitsIdx + 1, currString, digitToChar, ans);
    //         currString.deleteCharAt(currString.length() - 1); //removing the last added character

    //     }

    // }

}











