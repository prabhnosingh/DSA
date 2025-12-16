class Solution {
    //Re-sovling on 16 Dec 2025:

    //intuition 1: (dfs: Backtracking: decision tree on parentheses)
        //A parentheses is well formed if all the sub parentheses are closed.
        //At each level we will have two choices either to add a new opening parentheses (if n != 0)
            //or close a parenthesis. Maintain an opening and closing count and do not close a parentheses
            //if there is no open parentheses

        //1. What does one level of recursion represents?
            //A single parenthesis being processed
            //dfs(n-1) -> n-1 represents going one level deep in recursion
        //2. What are my choices at that level?
            //At each level, we have two choices:
                //1. Either to close a parentheses (if openCount is greater than closeCount)
                //2. Or, to open a parentheses (if n != 0)
        //3. When do I stop? (base case) 
            //when n == 0
    public List<String> generateParenthesis(int n) {
        List<String> combs = new ArrayList<>();
        HashMap<String, Integer> openCloseCount = new HashMap<>();

        openCloseCount.put("open", 0); //open count
        openCloseCount.put("close", 0); //close count

        dfs(n, new StringBuilder(), combs, openCloseCount);

        return combs;

    }

    private void dfs(int n, StringBuilder currComb, List<String> combs, HashMap<String, Integer> openCloseCount){
        if(n == openCloseCount.get("open") && n == openCloseCount.get("close")){
            combs.add(new String(currComb));
            return;
        }
        // else if(n == openCloseCount.get("open") || n == openCloseCount.get("close")){
        //     return;
        // }

        if(n != openCloseCount.get("open")){
            //open a parentheses    
            currComb.append('(');
            openCloseCount.put("open", openCloseCount.get("open") + 1);
            
            dfs(n, currComb, combs, openCloseCount);
            
            currComb.setLength(currComb.length() - 1);
            openCloseCount.put("open", openCloseCount.get("open") - 1);

        }

        if(n != openCloseCount.get("close") && openCloseCount.get("close") < openCloseCount.get("open")){
            currComb.append(')');
            openCloseCount.put("close", openCloseCount.get("close") + 1);

            dfs(n, currComb, combs, openCloseCount);
        
            currComb.setLength(currComb.length() - 1);
            openCloseCount.put("close", openCloseCount.get("close") - 1);
        
        }


        






        //close a parentheses

    }
}










