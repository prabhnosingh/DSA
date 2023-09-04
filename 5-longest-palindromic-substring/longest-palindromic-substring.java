class Solution {
    public String longestPalindrome(String s) {

    int maxLen = 0;
    int start = 0, end = 0;

    for(int i = 0; i < s.length(); i ++){
        int left = i - 1;
        while(i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)){
             i ++;
        }
         
        int right = i + 1;

        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left --;
            right ++;
        }

        if(right - left > maxLen){
            maxLen = right - left;
            start = left + 1;
            end = right;
        }
    }
    return s.substring(start, end);
        

//************************************************************************* */

//  // beats 5 %
    // public boolean isPali(String str){
//         int start = 0;
//         int end = str.length() - 1;
//         while(start < end){
//             if(str.charAt(start) != str.charAt(end)){
//                 return false;
//             }
//             start ++;
//             end --;
//         }

//         return true;

//     }
//     public String longestPalindrome(String s) {
        
//         if(s.length() == 1){
//             return s;
//         }
//         int sIdx = 0;
//         int eIdx = 0;
//         int maxLen = 0;
//         String maxStr = s.charAt(0) + "";
//        for(int i = 0; i < s.length(); i ++){
//            for(int j = i + 1; j < s.length(); j ++){
//                if(isPali(s.substring(i, j + 1))){
//                    if((j - i) > maxLen){
//                        maxStr = s.substring(i, j + 1);
//                        maxLen = j - i;
//                    }
//                }
//            }
//        }
//        return maxStr;

    }
}