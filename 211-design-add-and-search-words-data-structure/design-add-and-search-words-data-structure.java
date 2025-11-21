

//Re-solving on 21 Nov 2025:

//intuition 1: Implement a Trie. For every dot in search word, move the pointer to the next.
//Make children array of 27 size and when adding the word to trieNode, fill 26'th index with some
//random node. This will help in moving forward if we ever receive a dot in the search word.

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean wordEnds = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(currNode.children[ch - 'a'] == null){ //the character does not exist in children.
            //In this case add the character to currNode's children
                currNode.children[ch - 'a'] = new TrieNode();
            }
            // currNode.children[26] = new TrieNode(); //for dot in search word
            currNode = currNode.children[ch - 'a'];
        }

        currNode.wordEnds = true;
    }
    
    public boolean search(String word) {
        return dfsSearchHelper(word, 0, root);
    }

    public boolean dfsSearchHelper(String word, int idx, TrieNode currNode){
        

        for(int i = idx; i < word.length(); i ++){
            char currChar = word.charAt(i);
            
            if(currChar == '.'){
                for(TrieNode child : currNode.children){
                    if(child != null && dfsSearchHelper(word, i + 1, child)){ //checking if current child have the word
                    //after i + 1
                        return true;
                    }
                }
                return false;
            }

            else{ //normal search functionality of TrieNode
                if(currNode.children[currChar - 'a'] == null){
                    return false;
                }

                currNode = currNode.children[currChar - 'a'];
            }
        }

        return currNode.wordEnds;
    }
}





























///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// //intuition 1: implement TrieNode class. In search, while looking for the 'word', continue if there is a dot and the current
// //children also have any character in it. Make sure that endOfWord is considered.
// //can a linkedList be used in search function for skipping the current element if we encounter . in the word. -> no because 
// //in a linked list we cannot then reuse he existing characters
// class TrieNode{
//     TrieNode[] children =  new TrieNode[26];
//     boolean endOfWord = false;
// }

// class WordDictionary {

//     TrieNode root;

//     public WordDictionary() {
//         root = new TrieNode();
//     }
    
//     public void addWord(String word) {
//         TrieNode curr = root;
//         for(char ch : word.toCharArray()){
//             if(curr.children[ch - 'a'] == null){
//                 curr.children[ch - 'a'] = new TrieNode();
//             }
//             curr = curr.children[ch - 'a']; //shifting over to the character ch
//         }
//         curr.endOfWord = true;
//     }
    
//     public boolean search(String word) {
//        return dfsSearch(word, 0, root);
//     }


//     public boolean dfsSearch(String word, int idx, TrieNode root){
        
//         // if(root == null){
//         //     return false;
//         // }
//         TrieNode curr = root;

//         for(int i = idx; i < word.length(); i ++){
//             char ch = word.charAt(i);
//             if(ch == '.'){
//                 for(TrieNode child : curr.children){ //brute forcing over each possible combination available from "curr" 
//                     //curr.children is the array of type TrieNode. child will be a single TrieNode
//                     if(child != null && dfsSearch(word, i + 1, child)){ //passing i + 1 to skip the character at 'i' 
//                     //in the next recursive call
//                     //child != null is to avoid passing any null in dfsSearch function. This null comes from the intialization of 
//                     //'children' Trie array of 26 length and not all indices being filled out, i.e. not all 26 alphabets present 
//                     //in the 'words' adding till now
//                         return true;
//                     }
//                 }
//                 return false;
//             }
//             else{
//                 if(curr.children[ch - 'a'] == null){
//                     return false;
//                 }
//                 curr = curr.children[ch - 'a'];
//             }
           
//         }
//         return curr.endOfWord; //true will be returned only if after traversing the for loop we encounter a curr.endOfWord = true 
//     }
// }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */