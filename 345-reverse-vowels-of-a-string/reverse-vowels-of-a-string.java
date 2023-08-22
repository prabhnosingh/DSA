class Solution {
    public String reverseVowels(String s) {
        
       if(s == null && s.length() == 0){
           return s;
       }

       String vowels = "aieouAIEOU";

       char[] chars = s.toCharArray();

       int start = 0;
       int end = s.length() - 1;

       while(start < end){

           while(start < end && !vowels.contains(chars[start]+ "")){
               start ++;
           }

           while(start < end && !vowels.contains(chars[end]+ "")){
               end --;
           }

           char temp = chars[end];
           chars[end] = chars[start];

           chars[start] = temp;

           start ++;
           end --;
       }
       return new String(chars);
    }
} 