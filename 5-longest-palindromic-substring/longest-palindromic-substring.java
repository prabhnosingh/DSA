class Solution {
    public boolean isPali(String str){

        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start ++;
            end --;
        }

        return true;

    }
    public String longestPalindrome(String s) {
        
        if(s.length() == 1){
            return s;
        }
        int sIdx = 0;
        int eIdx = 0;
        int maxLen = 0;
        String maxStr = s.charAt(0) + "";
       for(int i = 0; i < s.length(); i ++){
           for(int j = i + 1; j < s.length(); j ++){
               if(isPali(s.substring(i, j + 1))){
                   if((j - i) > maxLen){
                       maxStr = s.substring(i, j + 1);
                       maxLen = j - i;
                   }
               }
           }
       }
       return maxStr;

    }
}