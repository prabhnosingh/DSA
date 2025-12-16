class Solution {
    //Solving on 16 Dec 2025:

    //intuition 1: Backtracking 
        //We have two options at each stage change the case of current character or skip it without changing the case.
        //Use dfs backtracking and toggle back the charcter to original case

        //“At index currIdx, what choices do I have?”
        //mutate
        
        //recurse
        
        //revert

        //"Backtracking works only if every recursive call leaves the state exactly as it found it."
    public List<String> letterCasePermutation(String s) {
        List<String> letterCasePerms = new ArrayList<>();

        char[] chArr = s.toCharArray();
        dfs(chArr, 0, letterCasePerms);

        return letterCasePerms;
    }

    //a -> 97
    //A -> 65
    private void dfs(char[] chArray, int currIdx, List<String> letterCasePerms){
        if(currIdx == chArray.length){ //all permutations compeleted
            letterCasePerms.add(new String(chArray));
            return;
        }

        //without mutation: no change branch
        dfs(chArray, currIdx + 1, letterCasePerms);

        //saving the state
        char tempChar = chArray[currIdx];

        if(Character.isLowerCase(chArray[currIdx])){
            chArray[currIdx] = Character.toUpperCase(chArray[currIdx]);
        }
        else if(Character.isUpperCase(chArray[currIdx])){
            chArray[currIdx] = Character.toLowerCase(chArray[currIdx]);
        }
        else return; //if the current character is a number

        //changing the case of current character and moving to next character (i + 1)
        dfs(chArray, currIdx + 1, letterCasePerms);

        //revertin: restoring the state
        // chArray[currIdx] = tempChar;

       
    }
}