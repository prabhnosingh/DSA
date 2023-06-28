class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character>set = new HashSet<>();
        int maxLength = 0;
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            if(!set.contains(s.charAt(fast))){

                set.add(s.charAt(fast++));
                maxLength = Math.max(maxLength, set.size());
            }
            else{
                set.remove(s.charAt(slow++));
            }
        }
        return maxLength;
    }
}