class Solution {

    //Solving on 18 Aug 2026

    //intuition 1: 
        //Topic: Graphs
        //Pattern: Topological Sorting
        //Sub-pattern:

        //Since a Directed Acyclic Graph is involved (or else return "") we can
            //apply Kahn's algo here

        //Building Adj list:
            //We are only given words string array and all the words are lexicographically
                //sorted. That means that we can build the graph edges by finding first
                //non-matching characters of adjacent words.
        //Then we add 0 inDegree nodes to the queue and poll them one by one while reducing
            //inDegree of their child nodes along the way and enqueuing child nodes to the 
            //queue if inDegree becomes 0
       
    public String alienOrder(String[] words) {
        
        List<List<Character>> adjList = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int[] inDegree = new int[26];
        boolean[] charPresentInDict = new boolean[26];
        StringBuilder alienDictSb = new StringBuilder();
        int uniqueChars = 0;

        //initializing charPresentInDict
        for(String word : words){
            for(char ch : word.toCharArray()){
                if(!charPresentInDict[ch - 'a']){
                    charPresentInDict[ch - 'a'] = true;
                    uniqueChars += 1;
                }
            } 
        }

        //initializing adjList
        for(int i = 0; i < 26; i ++){
            adjList.add(new ArrayList<>()); //1 arrayList for each character in 26 alphabets
        }

        //building adjList and inDegree
        for(int k = 0; k < words.length - 1; k ++){
            String word1 = words[k];
            String word2 = words[k + 1];

            int word1Len = word1.length();
            int word2Len = word2.length();

            int i = 0;
            int j = 0;

            //finding first mismatching character
            while(i < word1Len && j < word2Len){
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(j);

                //building an edge
                if(ch1 != ch2){
                    adjList.get(ch1 - 'a').add(ch2);
                    inDegree[ch2 - 'a'] += 1;
                    break; //only the first mismatching character is useful as per the
                        //definition of lexicographical sorting
                }

                i += 1;
                j += 1;

                if(j == word2.length() && i != word1.length()){ //meaning word2, second in order is
                    //fully parsed without finding any mismatching character, means first j chars are
                    //same in word1 and word2. This indicates word2 is prefix of word1 but second in 
                    //order, whereas it should have been first in order. Therefore the dict is invaid,
                    //and return ""
                    return "";
                }
            }
        }

        //equeing characters with 0 inDegree
        //in the test case words = ["abc","ab"] the current code is giving output "abc" but
            //is expected to give ""
        //this is happening because we are enqueing 0 indegree characters that are present in the
            //dict. But in this caes these characters don't even have an edge. So we can add a 
            //condition to check adjList.get(i).size() > 0
        //but now this is failing ["z","z"] 
            //we need to have a check while constructing adjList
        for(int i = 0; i < 26; i ++){
            if(charPresentInDict[i] && inDegree[i] == 0){ 
                //character there in dict and have 0 inDegree and have a valid edge
                queue.offer(i);
            }
        }

        //running BFS 
        while(!queue.isEmpty()){
            int currElm = queue.poll();
            char currChar = (char) (currElm + 'a');
            
            alienDictSb.append(currChar);

            //processing connected characters to currChar
            for(char connectingChar : adjList.get(currElm)){
                inDegree[connectingChar - 'a'] -= 1;

                if(inDegree[connectingChar - 'a'] == 0) queue.offer(connectingChar - 'a');
            }
        }

        return uniqueChars != alienDictSb.length() ? "" : new String(alienDictSb);


    }


























///////////////////////////////////////////////////////////////////////////////////////////
    // //intuition 1: 
    //     //Topic: Graphs
    //     //Pattern: Topological Sorting
    //     //Sub-pattern:

    //     //Looks like we need to return topological sort order of the alien dictionary where
    //         //each smaller letter should be coming before each bigger letter.

    //     //Using Kahn's aglo
    //         //build adj list using each word in words
    //             //take adjacent words and find first non-matching character in that pair
    //                 //and build an edge out of it
    //         //use a queue to process indgeree 0 alphabets 
    //         //build an answer string along the way while polling alphabets from the
    //             //queue
    //         //at last check if the string's length is equal to total unique alphabets
    //             //in words
    // public String alienOrder(String[] words) {
        
    //     int[] uniqueChars = new int[26];        

    //     List<List<Character>> adjList = new ArrayList<>();
    //     int[] inDegree = new int[26];
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     StringBuilder dictSb = new StringBuilder();
    //     int uniqueCharsCount = 0;

    //     //initializing adjList
    //     for(int i = 0; i < 26; i ++){
    //         adjList.add(new ArrayList<>());
    //     }


    //     //building adjList, inDegree and uniqueChars
    //     for(String word : words){
    //         for(int i = 0; i < word.length() - 1; i ++){
    //             char currChar = word.charAt(i);
    //             char nextChar = word.charAt(i+1);

    //             if(currChar == nextChar) continue;
    //             if(adjList.get(currChar - 'a').contains(nextChar)) continue; //skipping the 
    //                 //edge building if there is already an edge

    //             adjList.get(currChar - 'a').add(nextChar);

    //             inDegree[nextChar - 'a'] += 1;


    //             if(uniqueChars[currChar - 'a'] == 0){
    //                 uniqueChars[currChar - 'a'] += 1;
    //                 uniqueCharsCount += 1;
    //             }
    //             if(uniqueChars[nextChar - 'a'] == 0){
    //                 uniqueChars[nextChar - 'a'] += 1;
    //                 uniqueCharsCount += 1;

    //             }
    //         }
    //     }

    //     //euqueing indegree == 0 and uniqueChars[i] > 0 characters to the queue
    //     //we check uniqueChars[i] > 0 to avoid enqueueing all the 26 english alphabets
    //         //that might not be there in the alien dict
    //     HashSet<Character> alreadyInQueue = new HashSet<>();
    //     for(String word : words){
    //         for(char ch : word.toCharArray()){
    //             if(!alreadyInQueue.contains(ch) && inDegree[ch - 'a'] == 0){
    //                 queue.offer(ch - 'a');
    //                 alreadyInQueue.add(ch);
    //             }
    //         }
    //     }

    //     while(!queue.isEmpty()){
    //         int currNode = queue.poll();

    //         dictSb.append((char) (currNode + 'a'));

    //         for(char connectedChar : adjList.get(currNode)){
    //             inDegree[connectedChar - 'a'] -= 1;

    //             if(inDegree[connectedChar - 'a'] == 0) queue.offer(connectedChar - 'a');
    //         }

    //     }

    //     System.out.println( new String(dictSb));
    //     //unique chars count vs dictSb.length()
    //     return uniqueCharsCount == dictSb.length() ? new String(dictSb) : "";
        


    // }
}