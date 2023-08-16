class Solution {
    public int partitionString(String s) {
        
        // HashMap<Character, String>
        HashSet<Character> set = new HashSet<>();

        // int[] chars = new int[26];
        int count = 1;
        // int max = 0;
        
        for(char c : s.toCharArray()){
                if(!set.contains(c)){
                    set.add(c);
                }
                else{
                    set.clear();
                    set.add(c);
                    count ++;
                }
             
        }
        return count;
    }
}