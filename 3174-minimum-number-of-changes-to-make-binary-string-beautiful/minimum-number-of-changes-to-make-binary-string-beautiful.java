class Solution {
    public int minChanges(String s) {
        int len = s.length();

        if(len == 1){
            return 0;
        }

        if(len == 2){
            if(s.charAt(0) !=  s.charAt(1)){
                return 1;
            }
            else{
                return 0;
            }
        }

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