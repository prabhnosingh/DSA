class Solution {
    public boolean isSubsequence(String s, String t) {

        if(s.isEmpty()) return true;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        
        int idx = 0;
        for(char c : tChar){
            if(sChar[idx] == c){
                idx ++;
            }

            if(idx == sChar.length) return true;
        }
        return false;
//************************************************************** */
      //beats 90%  
        // if(s.length() == 0) return true;
        // int idx = 0;
        // boolean ans = false;
   
        // for(int i = 0; i < t.length(); i ++){
 
           
        //     if(t.charAt(i) == s.charAt(idx)){
        //         idx ++;
               
        //     }
            
        //      if(idx == s.length()) {
        //         ans = true;
        //         break;
        //     }
        // }

        // return ans;
        
    }
}