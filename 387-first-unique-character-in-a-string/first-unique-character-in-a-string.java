class Solution {
    public int firstUniqChar(String s) {

        // int[] count = new int[26];

        // for(char c : s.toCharArray()){

        // }

        
//**************************************************************************** */
       HashMap<Character, Integer> map = new HashMap<>();

          char[] ch = s.toCharArray();
       for(char c : ch){
           map.put(c, map.getOrDefault(c, 0) + 1);
       } 

        int idx = 0;
       for(char c: ch){
           if(map.get(c) == 1){
               return idx;
           }
           idx ++;
       }
       return -1;
    }
}