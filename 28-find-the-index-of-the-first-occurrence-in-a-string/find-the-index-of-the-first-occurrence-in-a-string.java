class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length() > haystack.length()) return -1;
        
      
        for(int j = 0; j < haystack.length(); j ++){

            String s = "";
            if(haystack.charAt(j) == needle.charAt(0)){
                if(haystack.length() - j < needle.length()) return -1;
                for(int i = j; i < j + needle.length(); i ++){
                    s += haystack.charAt(i);
                }
                if(s.equals(needle)){
                    return j;
                }
                
            }
            // start = 0;
             
            
            
        }
        return -1;
    }
}