class Solution {

    //Re-solving on 18 Nov 2025: 

    //inuition 1: 
    //"Same letter cell may not be used more than once" -> Use a visited set
    //Horizontally or vertically means it could be solved with graph approach (having a directions array)
    
    //Traverse the board fully and go char by char to find if the word exists
    public boolean exist(char[][] board, String word) {
        
        int charIdxInWord = 0;
        int rows = board.length;
        int cols = board[0].length;
        // HashSet<Character> visitedSet = new HashSet<>();
        // boolean[][] visitedSet = new boolean[rows][cols];
        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col ++){
                // if(dfsBacktrack(board, word, 0, visitedSet, row, col)){
                if(dfsBacktrack(board, word, 0, row, col)){
                    return true;
                }
                // visitedSet = new boolean[rows][cols]; 
            }
        }
        return false;
    }

    // public boolean dfsBacktrack(char[][] board, String word, int charIdxInWord, boolean[][] visitedSet, int row, int col){
    public boolean dfsBacktrack(char[][] board, String word, int charIdxInWord, int row, int col){
        if(row < 0 || col < 0 || row == board.length || col == board[0].length) return false;

        // System.out.println(board[row][col]);
        char currChar = board[row][col];
        // if(word.charAt(charIdxInWord) != board[row][col] || visitedSet[row][col]){
        //     return false;
        // }
        if(word.charAt(charIdxInWord) != currChar){
            return false;
        }
        
        if(charIdxInWord == word.length() - 1) return true; //last char of word found
        // visitedSet[row][col] = true;
        board[row][col] = '#';

        //moving in all directions
        // boolean down = dfsBacktrack(board, word, charIdxInWord + 1, visitedSet, row + 1, col); //moving down
        // boolean up = dfsBacktrack(board, word, charIdxInWord + 1, visitedSet, row - 1, col); //moving up
        // boolean left = dfsBacktrack(board, word, charIdxInWord + 1, visitedSet, row, col - 1); //moving left
        // boolean right = dfsBacktrack(board, word, charIdxInWord + 1, visitedSet, row, col + 1); //moving right 
        //moving in all directions
        boolean down = dfsBacktrack(board, word, charIdxInWord + 1, row + 1, col); //moving down
        boolean up = dfsBacktrack(board, word, charIdxInWord + 1, row - 1, col); //moving up
        boolean left = dfsBacktrack(board, word, charIdxInWord + 1, row, col - 1); //moving left
        boolean right = dfsBacktrack(board, word, charIdxInWord + 1, row, col + 1); //moving right 

        // visitedSet[row][col] = false; //resetting visitedSet for row, col (backtracking)
        board[row][col] = currChar;
        return down || up || left || right; //return true if any of the direction gave true in return
    }

    
}


































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //intuition 1: start with all characters in the board one by one. Only choose chars that are
    //matching to the word.charAt[0] initially. Each valid character will lead to a new branch. After 
    //selecting each character there are 4 options, either to go right, left, up or down. Try each of 
    //the possible directions and match the char with the next char in the string word (keep track of 
    //what is the next character we are looking in string word by curr Idx).
    //use a char[] of word to match the chars 


    // public boolean exist(char[][] board, String word) {
    //     char[] wordCh = word.toCharArray();
    //     for(int row = 0; row < board.length; row ++){//passing each row and col in the dfs function
    //         for(int col = 0; col < board[0].length; col ++){
    //             //current index's calculation
    //             if(dfs(board, row, col, wordCh, 0, new HashSet<>())){
    //                 return true;
    //             }
    //         }
    //     }
    //     // return dfs(board, 0, 0, wordCh, 0);
    //     return false;
    // }

    // protected boolean dfs(char[][] board, int boardRow, int boardCol, char[] wordCh, int wordIdx, HashSet<List<Integer>> setIdx){

    //     if(wordIdx == wordCh.length){//return true when all the chars of wordCh have been traversed
    //     //i.e. all the chars in word have been found
    //         return true;
    //     }
    //     List<Integer> pair = Arrays.asList(boardRow, boardCol);


    //     if(setIdx.contains(new ArrayList<>(pair))){
    //         // System.out.println("Already contains: " + pair);
    //         return false; //return false if the (row, col) is already traversed 
    //     }
    //     // System.out.println("Set does not contains: " + pair);

    //     if(boardRow >= board.length || boardRow < 0){ //in case all the rows are traversed
    //         // System.out.println("Set 1: " + pair);
    //         return false;
    //     }
    //     if(boardCol >= board[0].length || boardCol < 0){ //in case all the columns are 
    //         // System.out.println("Set 2: " + pair);
    //     //traversed
    //         return false;
    //     }

    //     // System.out.println("Pair " + pair);
    //     // System.out.println("Current word Char is: " + wordCh[wordIdx]);
    //     char boardChar = board[boardRow][boardCol];
    //     // System.out.println("Current Board Char is: "+ boardChar);
    //     // System.out.println("");

    //     if(boardChar != wordCh[wordIdx]){
    //         // setIdx.remove(new ArrayList<>(Arrays.asList(boardRow, boardCol))); // removes a pair 
    //         //of indices from set
    //         return false;
    //         //if the character is not the one we were looking
    //     }
    //     setIdx.add(pair); //only add the pair to setIdx if the corresponding character is the one that is next in the wordCh
    //     // System.out.println(pair);
    //     // System.out.println(setIdx);
        
        
    //     boolean res = (
    //     //going right
    //     dfs(board, boardRow, boardCol + 1, wordCh, wordIdx + 1, setIdx)
    //     //going left
    //     || dfs(board, boardRow, boardCol - 1, wordCh, wordIdx + 1, setIdx)
    //     //going down
    //     || dfs(board, boardRow + 1, boardCol, wordCh, wordIdx + 1, setIdx)
    //     //going up
    //     || dfs(board, boardRow - 1, boardCol, wordCh, wordIdx + 1, setIdx)
    //     );

    //     //removing pair from the set to free up the indices in order to use them again
    //     setIdx.remove(pair);
    //     return res;
    // }

    //our program is traversing already traversed (row, col) of board. -> maybe use a hashset to store the 
    //already traversed (row, col) pair

////////////////////////////////////////////////////////////////////////////////////
    //cleaning up
    //TC: O(n * m * 4^wordLen) -> n, m being the dimensions of board
    // public boolean exist(char[][] board, String word) {
    //     char[] wordCh = word.toCharArray();
    //     for(int row = 0; row < board.length; row ++){//passing each row and col in the dfs function
    //         for(int col = 0; col < board[0].length; col ++){
    //             //current index's calculation
    //             if(dfs(board, row, col, wordCh, 0, new HashSet<>())){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // protected boolean dfs(char[][] board, int boardRow, int boardCol, char[] wordCh, int wordIdx, HashSet<List<Integer>> setIdx){

    //     if(wordIdx == wordCh.length){//return true when all the chars of wordCh have been traversed
    //     //i.e. all the chars in word have been found
    //         return true;
    //     }
    //     List<Integer> pair = Arrays.asList(boardRow, boardCol);
       
    //     if(boardRow >= board.length || boardRow < 0 //in case all the rows are traversed
    //     || boardCol >= board[0].length || boardCol < 0 //in case all the columns are traversed
    //     || setIdx.contains(new ArrayList<>(pair))
    //     || board[boardRow][boardCol] != wordCh[wordIdx] //if the character is not the one we
    //     //were looking
    //     ){ 
    //         return false;
    //     }

 
    //     setIdx.add(pair); //only add the pair to setIdx if the corresponding character is the 
    //     // one that is next in the wordCh

    //     boolean res = (
    //     //going right
    //     dfs(board, boardRow, boardCol + 1, wordCh, wordIdx + 1, setIdx)
    //     //going left
    //     || dfs(board, boardRow, boardCol - 1, wordCh, wordIdx + 1, setIdx)
    //     //going down
    //     || dfs(board, boardRow + 1, boardCol, wordCh, wordIdx + 1, setIdx)
    //     //going up
    //     || dfs(board, boardRow - 1, boardCol, wordCh, wordIdx + 1, setIdx)
    //     );

    //     //removing pair from the set to free up the indices in order to use them again
    //     //removing the idx before returning so that the next call(new char search) can visit this idx
    //     setIdx.remove(pair);
    //     return res;
    // }
////////////////////////////////////////////////////////////////////////////////////////////////////
//     //inuition 2: Optimizing wihout using HashSet. Use a 2D boolean array (matrix) to store true/false on the basis of 
//     //already visited or not
//     public boolean exist(char[][] board, String word) {
//         int rowLen = board.length;
//         int colLen = board[0].length;
//         int wordIdx = 0;
//         boolean res = false;
//         boolean[][] visitedIdx = new boolean[rowLen][colLen];

//         for(int row = 0; row < rowLen; row ++){
//             for(int col = 0; col < colLen; col ++){
//                 if(board[row][col] == word.charAt(wordIdx)){
//                     res = dfs(row, col, word, wordIdx, board, visitedIdx);
//                 }
//                 if(res){
//                     return true;
//                 }
//             }
//         }
//         return false;
        
//     }

//     private boolean dfs(int currRow, int currCol, String word, int wordIdx, char[][] board, boolean[][] visitedIdx){

//         boolean flag1 = false, flag2 = false, flag3 = false, flag4 = false;

//         if (currRow >= board.length || currRow < 0
//         || currCol >= board[0].length || currCol < 0
       
//         ){
//             return false;
//         }
//         if(board[currRow][currCol] == word.charAt(wordIdx)){
//             if(wordIdx == word.length() - 1){
//                 return true;
//             }
//             if (currCol > 0 && !visitedIdx[currRow][currCol - 1]) { // go left and check that it is not already visited
//                 visitedIdx[currRow][currCol] = true;
//                 flag1 = dfs(currRow, currCol - 1, word, wordIdx + 1, board, visitedIdx);
//                 visitedIdx[currRow][currCol] = false;
//             }

//             if (currCol < board[0].length - 1 && !visitedIdx[currRow][currCol + 1]) {// go right and check that it is not
//             //already visited
//                 visitedIdx[currRow][currCol] = true;
//                 flag2 = dfs(currRow, currCol + 1, word, wordIdx + 1, board, visitedIdx);
//                 visitedIdx[currRow][currCol] = false;
//             }

//             if (currRow > 0 && !visitedIdx[currRow - 1][currCol]) { // go up and check that it is not already visited
//                 visitedIdx[currRow][currCol] = true;
//                 flag3 = dfs(currRow - 1, currCol, word, wordIdx + 1, board, visitedIdx);
//                 visitedIdx[currRow][currCol] = false;
//             }

//             if (currRow < board.length - 1 && !visitedIdx[currRow + 1][currCol]) { // go down and check that it is not 
//             // already visited
//                 visitedIdx[currRow][currCol] = true;
//                 flag4 = dfs(currRow + 1, currCol, word, wordIdx + 1, board, visitedIdx);
//                 visitedIdx[currRow][currCol] = false;
//             }

//             if (flag1 || flag2 || flag3 || flag4){
//                 return true;
//             }


//         }
//         return false;

//     }
// }



