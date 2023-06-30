
// class Solution {
// public int characterReplacement(String s, int k) {
// 		Map<Character, Integer> map = new HashMap<>(); 

// 	   int left = 0, maxRepeat = 0, maxWindow = 0;

// 		for(int right = 0; right < s.length(); right++) {
// 			char ch = s.charAt(right);
// 			if(!map.containsKey(ch)) {
// 				map.put(ch, 0);
// 			}
// 			map.put(ch, map.get(ch) + 1);
			
// 			// IMPORTANT: maxRepeat is not the accurate number of dominant character, It is the historical maximum count 
// 			// We do not care about it because unless it gets greater, it won't affect our final max window size.
// 			maxRepeat = Math.max(maxRepeat, map.get(ch));

// 			if(right - left + 1 - maxRepeat > k) {
// 				char remove = s.charAt(left);
// 				map.put(remove, map.get(remove) - 1);
// 				left++;
// 			}
        
//         maxWindow = Math.max(maxWindow, right - left + 1);
//     }
    
//     return maxWindow;
// }
// }
class Solution {
    public int characterReplacement(String s, int k) {

    int beg=0;

    int winLen=1;
    int maxLength=0;
       HashMap<Character, Integer> map= new HashMap<>();


     for( int end=0; end<s.length();end++){

         char ch = s.charAt(end);
          winLen = end - beg + 1;
    
         map.put(ch, map.getOrDefault(ch,0)+1);
            
       int m = Collections.max(map.values());
       int v= winLen -m;

         if(v <= k){
          maxLength = Math.max(maxLength,winLen);        

      }
      else{
         
          
        map.put(s.charAt(beg), map.get(s.charAt(beg))- 1);
         beg++;
      
        

       
      }

          }
    return maxLength;
    }
}
    // while(end<s.length()){
    //      int m=0;
    //      winLen = end - beg + 1;
    //      HashMap<Character, Integer> map= new HashMap<>();
    //     HashSet<Character> set = new HashSet<>();

    //     for(int i=beg; i<=end; i++){

    //        map.put( s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
    //           if(!set.contains(s.charAt(i))){
    //           set.add(s.charAt(i));
    //       }


    //     }
      
 


    //   for(Character c: set){

    //       m = Math.max(m,map.get(c));
    //   }

    //   if((winLen - m) <= k){
    //       maxLength = Math.max(maxLength,winLen);
    //       end++;

    //   }
    //   else{
    //       beg++;
    //   }
        
    // }
