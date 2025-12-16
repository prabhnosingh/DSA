class Solution {
    //Re-sovling on 16 Dec 2025:

    //intuition 2(improved intuition 2): (dfs: Backtracking: decision tree on parentheses: constrained branching) 
        // A parentheses string is well-formed if:
            // 1) At any point, closing parentheses do not exceed opening ones
            // 2) Total number of '(' and ')' is exactly n each
        
        // We build the string one character at a time.
        // 1️⃣ What does one level of recursion represent?
            // Each recursion level represents adding one parenthesis character to the current combination.
        
        // 2️⃣ What are the choices at that level?
            // We have two possible choices:
                //i. Add '(' if openCount < n
                //ii. Add ')' if closeCount < openCount
            // These conditions ensure the string remains valid while being built.
        
        // 3️⃣ When do we stop?
            //When the length of the current combination becomes 2*n, meaning we have placed all parentheses correctly.
        
        // Backtracking invariant:
            // After each recursive call, restore the state so that other choices can be explored independently.

        //TC (exponential): O(Cn · n) = ~O(4^n / sqrt(n)) : "where Cn is the nth Catalan number"
            //"The number of valid sequences of n pairs of parentheses is the n-th Catalan number"
        //SC: O(2n)



    //intuition 2: (dfs: Backtracking: decision tree on parentheses: constrained branching) : Without using hashMap
        //A parentheses is well formed if all the sub parentheses are closed.
        //"A parentheses string is well-formed if at any point the number of closing parentheses does not exceed 
            //the number of opening ones, and both reach n at the end."
        //At each level we will have two choices either to add a new opening parentheses (if n != openCount)
            //or close a parenthesis (if n != openCount && closeCount < openCount).  Maintain an opening and
            //closing count and do not close a parentheses if there is more open parentheses than close parentheses

        //1. What does one level of recursion represents?
            //A single parenthesis being processed
            //currComb.append -> represents going one level deep in recursion
        //2. What are my choices at that level?
            //At each level, we have two choices:
                //1. Either to close a parentheses (if openCount is greater than closeCount)
                //2. Or, to open a parentheses (if n != openCount)
        //3. When do I stop? (base case) 
            //when n == openCount && n == closeCount or currComb.length() == n*2
            //"When we have placed exactly n opening and n closing parentheses, we have formed a valid combination."

        //TC: O(2^n) : For each step we have two decisions to make
        //SC: o(n)
    
    public List<String> generateParenthesis(int n) {
        List<String> combs = new ArrayList<>();
       

        dfs(n, new StringBuilder(), combs, 0, 0);

        return combs;

    }

    private void dfs(int n, StringBuilder currComb, List<String> combs, int openCount, int closeCount){
        if(currComb.length() == n*2){
            combs.add(new String(currComb));
            return;
        }


        if(n > openCount){
            //open a parentheses    
            currComb.append('(');
            openCount += 1;
            
            dfs(n, currComb, combs, openCount, closeCount);
            
            currComb.setLength(currComb.length() - 1);
            openCount -= 1;

        }

        if(n > closeCount && closeCount < openCount){
            //close a parentheses    
            currComb.append(')');
            closeCount += 1;

            dfs(n, currComb, combs, openCount, closeCount);
        
            currComb.setLength(currComb.length() - 1);
            closeCount -= 1;
        
        }
    }





////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Re-sovling on 16 Dec 2025:

    // //intuition 1: (dfs: Backtracking: decision tree on parentheses: constrained branching)
    //     //A parentheses is well formed if all the sub parentheses are closed.
    //     //At each level we will have two choices either to add a new opening parentheses (if n != openCount)
    //         //or close a parenthesis (if n != openCount && closeCount < openCount).  Maintain an opening and
    //         //closing count and do not close a parentheses if there is more open parentheses than close parentheses

    //     //1. What does one level of recursion represents?
    //         //A single parenthesis being processed
    //         //currComb.append -> represents going one level deep in recursion
    //     //2. What are my choices at that level?
    //         //At each level, we have two choices:
    //             //1. Either to close a parentheses (if openCount is greater than closeCount)
    //             //2. Or, to open a parentheses (if n != openCount)
    //     //3. When do I stop? (base case) 
    //         //when n == openCount && n == closeCount
    // public List<String> generateParenthesis(int n) {
    //     List<String> combs = new ArrayList<>();
    //     HashMap<String, Integer> openCloseCount = new HashMap<>();

    //     openCloseCount.put("open", 0); //open count
    //     openCloseCount.put("close", 0); //close count

    //     dfs(n, new StringBuilder(), combs, openCloseCount);

    //     return combs;

    // }

    // private void dfs(int n, StringBuilder currComb, List<String> combs, HashMap<String, Integer> openCloseCount){
    //     if(n == openCloseCount.get("open") && n == openCloseCount.get("close")){
    //         combs.add(new String(currComb));
    //         return;
    //     }
    //     // else if(n == openCloseCount.get("open") || n == openCloseCount.get("close")){
    //     //     return;
    //     // }

    //     if(n != openCloseCount.get("open")){
    //         //open a parentheses    
    //         currComb.append('(');
    //         openCloseCount.put("open", openCloseCount.get("open") + 1);
            
    //         dfs(n, currComb, combs, openCloseCount);
            
    //         currComb.setLength(currComb.length() - 1);
    //         openCloseCount.put("open", openCloseCount.get("open") - 1);

    //     }

    //     if(n != openCloseCount.get("close") && openCloseCount.get("close") < openCloseCount.get("open")){
    //         currComb.append(')');
    //         openCloseCount.put("close", openCloseCount.get("close") + 1);

    //         dfs(n, currComb, combs, openCloseCount);
        
    //         currComb.setLength(currComb.length() - 1);
    //         openCloseCount.put("close", openCloseCount.get("close") - 1);
        
    //     }
    // }
}










