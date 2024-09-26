class Solution {
    public int minChanges(String s) {
        // int len = s.length();
        char[] ch = s.toCharArray();
        int count = 0;
        for(int i = 1; i < ch.length; i += 2){
            if(ch[i] != ch[i - 1]){
                count ++;
            }
        }
        return count;
    }
}