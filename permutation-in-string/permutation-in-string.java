class Solution {


    public static String sortString(String input){
        char[] tempArray = input.toCharArray();

        Arrays.sort(tempArray);

        return new String(tempArray);
    }
    public boolean checkInclusion(String s1, String s2) {

        String sortS1 = sortString(s1);

        int winLen = s1.length();

        int beg =0;
        int end = winLen;

        while(end <= s2.length()){
            String sortWin = sortString(s2.substring(beg,end));
            beg++;
            end++;
            if(sortWin.equals(sortS1)){
                return true;
            }
            
        }

        return false;
   }
}