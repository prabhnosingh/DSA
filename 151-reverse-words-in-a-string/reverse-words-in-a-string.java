class Solution {
    public String reverseWords(String s) {
 

        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        int idx = 0;
        for(int i = words.length - 1; i >=0; i --){

            ans.append(words[i]);
            if(i > 0){
                ans.append(" ");
            }
        }
        return ans.toString();

//************************************************************************* */
    //     StringBuilder s1 = new StringBuilder();
      
        

    //     int start = s.length() - 1;
    //     int end = s.length() - 1;
    //         // String s1 = "";
    //     while(start >= 0){

    //         while(start >= 0 && s.charAt(start) == ' '){
    //             start --;
    //         }

    //         if(start < 0) break;
            
    //             end = start;
    //             while(start >= 0 && s.charAt(start) != ' '){
    //                 start --;
    //             }
                
    //             s1.append(s.substring(start + 1, end + 1));
    //             if(start >= 0) s1.append(" ");


                
            
    //     }
    //     return s1.toString();
    }
}