class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s.length() == 0 || s == null){
            return 0;
        }

        int maxLength = 0;
        int[] charIndex = new int[128];

        for(int end = 0, start = 0; end < s.length(); end++){
            char currentChar = s.charAt(end);

            start = Math.max(start, charIndex[currentChar]);

            maxLength = Math.max(maxLength, end - start + 1);
            charIndex[currentChar] = end + 1;
        }

        return maxLength;


//*********************************************************************** */        
       
       //beats 81.90 % 
        // Set<Character>set = new HashSet<>();
        // int maxLength = 0;
        // int fast = 0;
        // int slow = 0;
        // while(fast < s.length()){
        //     if(!set.contains(s.charAt(fast))){

        //         set.add(s.charAt(fast++));
        //         maxLength = Math.max(maxLength, set.size());
        //     }
        //     else{
        //         set.remove(s.charAt(slow++));
        //     }
        // }
        // return maxLength;
    }
}