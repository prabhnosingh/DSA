class Solution {
    boolean flag = false;
    public boolean exist(char[][] board, String word) {
        String tempWord = "";
        boolean res = false;
        HashSet<List<Integer>> idxSet = new HashSet<>(); // for storing the index of the character already being used in a valid path to avoid using the same character twice
        
        for(int row = 0; row < board.length; row ++){
            for(int column = 0; column < board[0].length; column ++){
                res = dfs(board, word, tempWord, row, column, 0, idxSet);
                if(res){
                    return true;
                }
            }
        }
        
        
       
       
        return false;
    }

    private boolean dfs(char[][] board, String word, String tempWord, int row, int column, int startIdx, HashSet<List<Integer>> idxSet){
        boolean dfsRes = false;
        // System.out.println("row: " + row);
        // System.out.println("column: " + column);
        // System.out.println("*******");


        List<Integer> tempList = Arrays.asList(row, column);

        if(row == board.length || row < 0 || column == board[0].length || column < 0 || idxSet.contains(tempList) || word.charAt(startIdx) != board[row][column]){
            return false;
        }
       


        idxSet.add(tempList);
        // System.out.println(tempList);
        tempWord += board[row][column] + "";
        // System.out.println("Valid character found at -> row : " + row + " column : " + column);
   
        if(tempWord.equals(word)){
            // System.out.println("Supposed right word is : " + tempWord);
            flag = true;
            return true;
        }
        startIdx ++;
        
        
       
        
        // dfsRes = dfs(board, word, tempWord, row + 1, column, startIdx, idxSet) ||  // going down
        // // going up
        // dfs(board, word, tempWord, row - 1, column, startIdx, idxSet) ||

        // // tempWord = tempWord.replaceFirst(tempWord.charAt(tempWord.length() - 1) + "", ""); // removing the previously added character
        // // going right
        // dfs(board, word, tempWord, row, column + 1, startIdx, idxSet) ||

        // // going left
        // dfs(board, word, tempWord, row, column - 1, startIdx, idxSet);

        if(dfs(board, word, tempWord, row + 1, column, startIdx, idxSet)){
            return true;
        } 
        if(dfs(board, word, tempWord, row - 1, column, startIdx, idxSet)){
            return true;
        }

        // tempWord = tempWord.replaceFirst(tempWord.charAt(tempWord.length() - 1) + "", ""); // removing the previously added character
        // going right
        if(dfs(board, word, tempWord, row, column + 1, startIdx, idxSet)){
            return true;
        } 

        // going left
        if(dfs(board, word, tempWord, row, column - 1, startIdx, idxSet)){
            return true;
        }
       
       
       
       
        idxSet.remove(tempList); // removing the idx before returning so that the next call(new char search) can visit this idx
        return dfsRes;
    }
}