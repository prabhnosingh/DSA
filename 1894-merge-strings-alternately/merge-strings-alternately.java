class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        String merged = "";

        // int p1 = 0;
        // int p2 = 0;

        // while(p1 < word1.length || p2 < word.length){
        //     if(p1 )
        // }

        int len = Math.max(word1.length(), word2.length());

        for(int i = 0; i < len; i++){
            merged = merged + (i >= word1.length() ? "" : word1.charAt(i)) + (i >= word2.length() ? "" : word2.charAt(i));
        }

        return merged;
    }
}