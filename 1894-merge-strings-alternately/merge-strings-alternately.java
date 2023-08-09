class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int n = word1.length();
        int m = word2.length();

        int i = 0;
        while(i < n && i < m){

            result.append(word1.charAt(i)).append(word2.charAt(i));
            i++;

        }

        result.append(word1.substring(i, n)).append(word2.substring(i, m));

        return result.toString();
//******************************************************************************************************* */              
        // String merged = "";



        // int len = Math.max(word1.length(), word2.length());

        // for(int i = 0; i < len; i++){
        //     merged = merged + (i >= word1.length() ? "" : word1.charAt(i)) + (i >= word2.length() ? "" : word2.charAt(i));
        // }

        // return merged;
    }
}