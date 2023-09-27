class Solution {
    public int maxVowels(String s, int k) {
       
        int start = 0;
        String vowels = "aeiou";
        int maxCount = 0;
        int end = k;
        int count = 0;
        for(int i = 0; i < k; i ++){
            if(vowels.contains(String.valueOf(s.charAt(i)))){
                count ++;
            }
        }
        maxCount = count;

        while(end < s.length()){
            if(vowels.contains(String.valueOf(s.charAt(start)))){
                count --;
               
            }
            if(vowels.contains(String.valueOf(s.charAt(end)))){
                count ++;
                
            }
            maxCount = Math.max(maxCount, count);
             start ++;
             end ++;
        }

           
        return maxCount;

//****************************************************************************** */       
       //time limit exceeded
        // int len = s.length();
        // String vowels = "aeiou";
        // int maxCount = 0; 
        // for(int i = 0; i < len; i ++){
        //     int start = i;
        //     int count = 0;
        //     while(i + k <= len && start < i + k){
        //         if(vowels.contains(String.valueOf(s.charAt(start)))){
        //             count ++;
        //         }

        //         start ++;
        //     }
        //     maxCount = Math.max(maxCount, count);


        // }
        // return maxCount;
    }
}