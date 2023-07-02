class Solution {
    public boolean isPalindrome(String s) {

        String s1= s.toUpperCase();
        String s2="";
        for (int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(c>='0' && c<='9') s2+=c;
             if(c>='A' && c<='Z' && c!=' '){
                s2 += c; 
            
        }
        }
        char[] str = s2.toCharArray();

        
        int start=0;
        int end= str.length-1;
        
      

        boolean f = true;
        while (start<=end){
            
         
            if(str[end]!=str[start]){ 
                return false;
                }
                
            start++;
            end--;
        }
        return f;
    } 
}