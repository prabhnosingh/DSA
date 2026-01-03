class Solution {

    //re-solving - 03 Jan Oct 2026

    //intuition 1: Two pointers + HashMap
        //Track the curent window with two pointers and hashMap to track the feq of chars 
            //from string t.
        //First store the frequency of chars from t string in map
        //Traverse the string s from left to right while increasing the right pointer and 
            //every time a char from t encounters (map.containsKey) we decrement the freq
        //Once all the frequencies go <= 0, stop and shrink the window from left by adding 
            //in frequency for valid char encountered, until one of them becomes >0 (or 1).
            //In this scenario take the substring from left-1 to right (inclusive) and store
            //it as a probable answer.



    public String minWindow(String s, String t) {

        if(s.length() < t.length()) return "";

        if(t.length() == 0) return "";

        if(s.length() == 1 && t.length() == 1){
            if(s.charAt(0) == t.charAt(0)){
                return s;
            }
            else{
                return "";
            }
        
        } 

        if(s.equals(t)) return s;    

        HashMap<Character, Integer> map = new HashMap<>();

        for(Character ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        String minWinString = s + "#";

        int left = 0;
        int right = 0;

        int currSubStringLen = 0;
        //we have found all chars from t string when currSubStringLen == t.length()
        while(right < s.length()){

            char currChar = s.charAt(right ++);
            if(map.containsKey(currChar)){
                map.put(currChar, map.get(currChar) - 1);
                if(map.get(currChar) >= 0){ //negative means access elements
                    currSubStringLen += 1;
                }
            }

            if(currSubStringLen == t.length()){ //shrink the window
                while(currSubStringLen == t.length()){
                    char currCharLeft = s.charAt(left ++);
                    if(map.containsKey(currCharLeft)){
                        map.put(currCharLeft, map.get(currCharLeft) + 1);
                        if(map.get(currCharLeft) > 0){ //a valid element skipped out of curr window
                            currSubStringLen -= 1;
                        }
                    }
                }
                String tempStr = s.substring(left - 1, right);
                if(tempStr.length() < minWinString.length()){
                    minWinString = tempStr;
                }
            }
        }

        return minWinString.equals(s + "#") ? "" : minWinString;

    }























    ////////////////////////////////////////////////////////////////////////////////////////////////////// 
    // //re-solving - 18 Oct 2025

    // //intuition 2 (Two pointers (sliding window) + map): We start with two pointers left and right = 0. 
    // //Have a hashMap that stores the frequency of each character of t stirng. The idea is to keep expanding
    // //the window until the current substring have all the characters from the string t. After that, start
    // //shrinking the window until one of the character count goes down. When a character count goes down at left
    // //idx then our substring that had all the characters is left - 1 : right

    // //decrement count in map when expanding window
    // //increment count in map when shrinking window



    // public String minWindow(String s, String t) {

    //     HashMap<Character, Integer> charCount = new HashMap<>();
    //     for(char ch : t.toCharArray()){
    //         charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
    //     }

    //     int left = 0;
    //     int right = 0;
    //     int count = 0;  
    //     String minSubstring = s + "#"; 

    //     while(right < s.length()){
    //         char currentChar = s.charAt(right);
    //         if(charCount.containsKey(currentChar)){ //current character is in t string
    //             int currentCharFreq = charCount.get(currentChar);
    //             if(currentCharFreq > 0){ //the frequency of current character is not negative. If it is negative, then 
    //             //that means that the requirement is satisfied and we don't need to increase count
    //                 count += 1;
    //             }
    //             charCount.put(currentChar, currentCharFreq - 1); //decrementing the frequency by 1 (negative means,
    //                 //there are extra chars)
    //         }

    //         //if is not required
    //         //this means all the characters in t are now in current substring left : right + 1(excluded)
    //         while(count == t.length()){
    //             String currMinSubstring = s.substring(left, right + 1); 
    //             minSubstring = currMinSubstring.length() < minSubstring.length() ? currMinSubstring : minSubstring;

    //             if(charCount.containsKey(s.charAt(left))){ //current character is in t string
    //                 if(charCount.get(s.charAt(left)) == 0){ //only decrement count if the frequency is 0 as in case of
    //                 //negative frequency we don't decrease count as it is not a requirement
    //                     count --;
    //                 }
    //                 charCount.put(s.charAt(left), charCount.get(s.charAt(left)) + 1);
    //             }
    //             left += 1; //shrinking the window
    //         }
           

            


    //         right += 1;
    //     }

    //     // System.out.println(s.substring(left, right));

    //     return minSubstring.equals(s + "#") ? "" : minSubstring;


    // }












    // ////////////////////////////////////////////////////////////////////////////////////////////////////// 
    // //re-solving - 18 Oct 2025

    // //intuition 1 (brute force): look for all substrings of s and compare with t

    // //TLE
    // public String minWindow(String s, String t) {

    //     String minWindowString = s;
    //     boolean flag = false;
    //     for(int i = 0; i < s.length(); i ++){
    //         for(int j = i; j < s.length(); j ++){ //s.length() + 1 -> to cover the last character in s, as substring excludes the
    //         //index at second parameter
    //             String tempStr = s.substring(i, j + 1); 
    //             // System.out.println(tempStr);
    //             if(isValid(tempStr, t)){
    //                 if(tempStr.length() <= minWindowString.length()){
    //                     flag = true;
    //                     minWindowString = tempStr;
    //                 }
                    
    //             }
    //         }
    //     }
    //     return flag ? minWindowString : "";
    // }

    // public boolean isValid(String subStr, String t){
    //     if(subStr.length() < t.length()){
    //         return false;
    //     }

    //     // HashMap<Character, Integer> tFreqMap = new HashMap<>();
    //     int[] tFreqMap = new int[128];
    //     int[] subStrFreqMap = new int[128];

    //     for(char ch : t.toCharArray()){
    //         // tFreqMap.put(ch, tFreqMap.getOrDefault(ch, 0) + 1);
    //         tFreqMap[ch] ++; //ascii of 'A' is 65 and ascii of 'a' is 97
    //     }
    //     for(char ch : subStr.toCharArray()){
    //         subStrFreqMap[ch] ++; //ascii of 'A' is 65 and ascii of 'a' is 97
    //     }

    //     for(int i = 0; i < tFreqMap.length; i ++){
    //     //    System.out.println("tempStr");
    //         if(tFreqMap[i] == 0){
    //             continue;
    //         }

    //         if(tFreqMap[i] > subStrFreqMap[i]){
    //             return false;
    //         }
    //     }

    //     return true;



    // } 
}