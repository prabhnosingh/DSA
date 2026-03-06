class Solution {

//      Pattern	Loop?
//      Position based decisions	❌ No
//      Choosing next element	✅ Yes
//      Subsets / combinations	✅ Yes
//      String index decisions	❌ No

//If each recursion level represents one position → NO for-loop

    //Solving on 06 Mar 2026:

    //intuition 1: Backtracking
        //We can recursively traverse all the indices of the string 
        //at each step we have an option to either make the alphabet 
            //uppercase or lowercase
        //if the letter is a number we just continue
        //after each traversal we reverse the change of changing the case as
            //part of backtracking


        
    public List<String> letterCasePermutation(String s) {
        
        List<String> perms = new ArrayList<>();

        dfs(s.toCharArray(), perms, 0);

        return perms;
       
    }

    private void dfs(char[] charArray, List<String> perms, int currIdx){

        if(currIdx == charArray.length){ //the whole string traversed
            perms.add(new String(charArray));    
            return;  
        }

        dfs(charArray, perms, currIdx + 1); //for skipping current element from any operation

        char currChar = charArray[currIdx];
        
        if(Character.isLowerCase(currChar)){
            charArray[currIdx] = Character.toUpperCase(currChar);
        }
        else if (Character.isUpperCase(currChar)){
            charArray[currIdx] = Character.toLowerCase(currChar);
        }   
        else { // in case currChar is a digit
            return;
        }

        dfs(charArray, perms, currIdx + 1); //traversing all permutations after changing the case

        charArray[currIdx] = currChar;
    }


























//////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 16 Dec 2025:

    // //intuition 1: Backtracking 
    //     //We have two options at each stage change the case of current character or skip it without changing the case.
    //     //Use dfs backtracking and toggle back the charcter to original case. 
    //     //Numbers should only be backtracked through "no change branch" as there is no case to change in numbers
    //     //Letters → 2 choices Digits → 1 choice

    //     //“At index currIdx, what choices do I have?”
    //     //mutate
        
    //     //recurse
        
    //     //revert

    //     //"Backtracking works only if every recursive call leaves the state exactly as it found it."
    // public List<String> letterCasePermutation(String s) {
    //     List<String> letterCasePerms = new ArrayList<>();

    //     char[] chArr = s.toCharArray();
    //     dfs(chArr, 0, letterCasePerms);

    //     return letterCasePerms;
    // }

    // //a -> 97
    // //A -> 65
    // private void dfs(char[] chArray, int currIdx, List<String> letterCasePerms){
    //     if(currIdx == chArray.length){ //all permutations compeleted
    //         letterCasePerms.add(new String(chArray));
    //         return;
    //     }

    //     //without mutation: no change branch
    //     dfs(chArray, currIdx + 1, letterCasePerms);

    //     //saving the state
    //     char tempChar = chArray[currIdx];

    //     if(Character.isLowerCase(chArray[currIdx])){
    //         chArray[currIdx] = Character.toUpperCase(chArray[currIdx]);
    //     }
    //     else if(Character.isUpperCase(chArray[currIdx])){
    //         chArray[currIdx] = Character.toLowerCase(chArray[currIdx]);
    //     }
    //     else return; //if the current character is a number

    //     //changing the case of current character and moving to next character (i + 1)
    //     dfs(chArray, currIdx + 1, letterCasePerms);

    //     //revertin: restoring the state
    //     chArray[currIdx] = tempChar;

       
    // }
}