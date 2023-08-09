class Solution {
    public String mergeAlternately(String word1, String word2) {
StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < word1.length() || i < word2.length()) {
            if (i < word1.length()) {
                result.append(word1.charAt(i));
            }
            if (i < word2.length()) {
                result.append(word2.charAt(i));
            }
            i++;
        }
        return result.toString();        
        // String merged = "";



        // int len = Math.max(word1.length(), word2.length());

        // for(int i = 0; i < len; i++){
        //     merged = merged + (i >= word1.length() ? "" : word1.charAt(i)) + (i >= word2.length() ? "" : word2.charAt(i));
        // }

        // return merged;
    }
}