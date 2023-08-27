class Solution {
    public String reverseWords(String s) {

        char[] sArr = s.toCharArray();
        char ans[] = new char[s.length()];
        
        int start = s.length() - 1;
        int end = 0;
        int idx = 0;
        while(start >= 0 && sArr[start] == ' '){
            start --;
        }

      while(start >=0){
        
        end = start;
        while(start >= 0 && sArr[start] != ' '){
            start --;
        }

        for(int j = start + 1; j <= end; j ++){

            ans[idx ++] = sArr[j];
        }
        while(start >= 0 && sArr[start] == ' '){
            start --;
        }
        if(start >=0) {
            ans[idx ++] = ' ';
        }
    }

        return new String(ans, 0, idx);



//********************************************************************** */       
        //beats 72%

        // String[] words = s.trim().split("\\s+");
        // StringBuilder ans = new StringBuilder();

        // int idx = 0;
        // for(int i = words.length - 1; i >=0; i --){

        //     ans.append(words[i]);
        //     if(i > 0){
        //         ans.append(" ");
        //     }
        // }
        // return ans.toString();

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