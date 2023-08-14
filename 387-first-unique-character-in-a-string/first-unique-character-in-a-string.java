class Solution {
    public int firstUniqChar(String s) {

       HashMap<Character, Integer> map = new HashMap<>();

       for(char c : s.toCharArray()){
           map.put(c, map.getOrDefault(c, 0) + 1);
       } 

        int idx = 0;
       for(char c: s.toCharArray()){
           if(map.get(c) == 1){
               return idx;
           }
           idx ++;
       }
       return -1;
    }
}