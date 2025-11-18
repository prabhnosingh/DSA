
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//using a hashmap (beats 20%)


class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd = false;
}

class Trie {
   
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(currNode.children[ch - 'a'] == null){
                currNode.children[ch - 'a'] = new TrieNode();

            }
            currNode = currNode.children[ch - 'a'];
        }

        currNode.isWordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode currNode = root;
        for(char ch : word.toCharArray()){
            if(currNode.children[ch - 'a'] == null){
                return false;
            }
            currNode = currNode.children[ch - 'a'];
        }

        return currNode.isWordEnd;
       
    }
    
    public boolean startsWith(String prefix) {
       TrieNode currNode = root;
       for(char ch : prefix.toCharArray()){
            if(currNode.children[ch - 'a'] == null){
                return false;
            }
            currNode = currNode.children[ch - 'a'];
       }
       return true;
    }
}

























////////////////////////////////////////////////////////////////////////////////////////////

//intuition 1: using hashset
// class Trie {
//     HashSet<String> set;

//     public Trie() {
//         set = new HashSet<>();
//     }
    
//     public void insert(String word) {
//         set.add(word);
//     }
    
//     public boolean search(String word) {
//         if(set.contains(word)){
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
    
//     public boolean startsWith(String prefix) {
//         for(String s : set){
//             if(s.startsWith(prefix)){
//                 return true;
//             }
//         }
//         return false;
//     }
// }

////////////////////////////////////////////////////////////////////////

//using an array of length 26 and of type 'TrieNode' (beats 80%)
// class TrieNode{
//     TrieNode[] children = new TrieNode[26]; //array of type TrieNode of length 26
//     boolean endOfWord = false;
// }
// class Trie {
//     private TrieNode root;

//     public Trie() {
//         root = new TrieNode();
//     }
    
//     public void insert(String word) {
//        TrieNode curr = root;
//        for(char ch : word.toCharArray()){
//             int i = ch - 'a'; //i will be 0 if c is 'a'
//             if(curr.children[i] == null){ //if any of the character is missing from the curr.children, then initialize that index 
//             //with an empty TrieNode
//                 curr.children[i] = new TrieNode();
//             }
//             curr = curr.children[i]; //move curr to the next character if it exists
//        }

//        curr.endOfWord = true; //curr is an object of TrieNode and here we are updating its member variable
//     }
    
//     public boolean search(String word) {
//         TrieNode curr = root; //start from root
//         for(char ch : word.toCharArray()){
//             if(curr.children[ch - 'a'] == null){ //return if any ch is not found in curr.children
//                 return false;
//             }
//             curr = curr.children[ch - 'a']; //move curr to children representing the ch
//         }
//         return curr.endOfWord; //return true if curr object (character) represents the end of the word

//     }
    
//     public boolean startsWith(String prefix) {
//        TrieNode curr = root;
//        for(char ch : prefix.toCharArray()){
//             if(curr.children[ch - 'a'] == null){
//                 return false;
//             }

//             curr = curr.children[ch - 'a'];
//        }

//        return true; //return true if every character is in prefix is present
//     }
// }

///////////////////////////////////////////////////////////////////////////////////////////

// //using a hashmap (beats 20%)

// class TrieNode{
//     HashMap<Character, TrieNode> children = new HashMap<>();
//     // TrieNode[] children = new TrieNode[26]; //array of type TrieNode of length 26
//     boolean endOfWord = false;
// }
// class Trie {
//     private TrieNode root;

//     public Trie() {
//         root = new TrieNode();
//     }
    
//     public void insert(String word) {
//        TrieNode curr = root;
//        for(char ch : word.toCharArray()){
//             if(!curr.children.containsKey(ch)){
//                 curr.children.put(ch, new TrieNode());
//             }
//             curr = curr.children.get(ch);
//        }

//        curr.endOfWord = true; //curr is an object of TrieNode and here we are updating its member variable
//     }
    
//     public boolean search(String word) {
//         TrieNode curr = root; //start from root
//         for(char ch : word.toCharArray()){
//             if(!curr.children.containsKey(ch)){
//                 return false;
//             }
//             curr = curr.children.get(ch);
//         }
//         return curr.endOfWord; //return true if curr object (character) represents the end of the word

//     }
    
//     public boolean startsWith(String prefix) {
//        TrieNode curr = root;
//        for(char ch : prefix.toCharArray()){
//             if(!curr.children.containsKey(ch)){
//                 return false;
//             }
//             curr = curr.children.get(ch);
//        }

//        return true; //return true if every character is in prefix is present
//     }
// }

