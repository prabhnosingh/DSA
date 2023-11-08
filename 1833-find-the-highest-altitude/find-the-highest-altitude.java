class Solution {
    public int largestAltitude(int[] gain) {
        int alt = 0;
        int f = 0;
        int s = 0;

        for(int i = 0; i < gain.length; i ++){
    
           s = f + gain[i];
           f = s;

           alt = Math.max(s, alt);

        }
        return alt;
    }
}