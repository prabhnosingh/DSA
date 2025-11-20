

//intuition 2 (using Tries): We input all the words from words array to trie to make full map 
//of characters. After that traverse the full matrix and backtrack if current trie does not have
//the current character from matrix in its children. 

//add the word to the ans list if we found that currTrie.word is not null. currTrie.word here
//signifies end of a word





class TrieNode{
    TrieNode[] children = new TrieNode[26];
    String word;
}


class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }    

    public void insert(String word){
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(currNode.children[ch - 'a'] == null){
                currNode.children[ch - 'a'] = new TrieNode();
            }
            currNode = currNode.children[ch - 'a'];
        }

        currNode.word = word; //marking the ending of a word
    }

}


class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();

        for(String word : words){
            trie.insert(word); //building trie map
        }

        List<String> foundWords = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col ++){
                dfs(board, trie.root, row, col, foundWords); //trie.root is of type TrieNode
            }
        }

        return foundWords;
    }

    private void dfs(char[][] board, TrieNode currTrieNode, int row, int col, List<String> foundWords){
        if(row < 0 || col < 0 || row == board.length || col == board[0].length){
            return;
        }
        char currChar = board[row][col];

        if(currChar == '#') return;
        if(currTrieNode.children[currChar - 'a'] == null) return; //current trieNode does not have current char in its children
        //Therefore, no sense to proceed.

        board[row][col] = '#';

        currTrieNode = currTrieNode.children[currChar - 'a']; //moving currTrieNode to its valid children
        if(currTrieNode.word != null){ //end of a word has been encountered
            foundWords.add(currTrieNode.word);
            currTrieNode.word = null; //to avoid duplicate words being added to the foundWords list
        } 

        dfs(board, currTrieNode, row + 1, col, foundWords);
        dfs(board, currTrieNode, row - 1, col, foundWords);
        dfs(board, currTrieNode, row, col - 1, foundWords);
        dfs(board, currTrieNode, row, col + 1, foundWords);

        board[row][col] = currChar;
    }





















/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //intuition 1 (with Word Search I approach): GOT TLE
    // //TC: O((m x n)^2 x  x words.length)
    // public List<String> findWords(char[][] board, String[] words) {
    //     int rows = board.length;
    //     int cols = board[0].length;

    //     boolean[][] visitedSet = new boolean[rows][cols];
    //     List<String> foundWords = new ArrayList<>();
    //     for(String word : words){
    //         // if(foundWords.contains(word)) continue;
    //         for(int row = 0; row < rows; row ++){
    //             // if(foundWords.contains(word)) continue;
    //             for(int col = 0; col < cols; col ++){
    //                 if(foundWords.contains(word)) break;
    //                 if(dfs(board, word, 0, row, col, visitedSet)){
    //                     foundWords.add(word);
    //                 }
    //             }
    //         }
    //     }
    //     return foundWords;

    // }

    // private boolean dfs(char[][] board, String word, int wordIdx, int row, int col, boolean[][] visitedSet){
    //     if(row < 0 || col < 0 || row == board.length || col == board[0].length){
    //         return false;
    //     }

    //     if(word.charAt(wordIdx) != board[row][col] || visitedSet[row][col]){
    //         return false;
    //     }

    //     if(wordIdx == word.length() - 1) return true;

    //     visitedSet[row][col] = true;

    //     int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    //     boolean foundWord = false;
    //     for(int[] direction : directions){
    //         int newRow = row + direction[0];
    //         int newCol = col + direction[1];

    //         if(dfs(board, word, wordIdx + 1, newRow, newCol, visitedSet)){
    //             foundWord = true;
    //             break;
    //         }

    //     }

    //     visitedSet[row][col] = false;

    //     return foundWord;

    // } 
}