class Solution {
    public int partitionString(String s) {

        int xr = 0;
        int ans = 1;

        for(char c : s.toCharArray()){
            if((xr & (1 << c)) != 0){
                
                xr = 0;
                ans ++;
            }

            xr ^= (1 << c);
        }
        return ans;




/////////////////////////////////////////////////////////////////////////////       
        //beats 53.77 %
        // // HashMap<Character, String>
        // HashSet<Character> set = new HashSet<>();

        // // int[] chars = new int[26];
        // int count = 1;
        // // int max = 0;
        
        // for(char c : s.toCharArray()){
        //         if(!set.contains(c)){
        //             set.add(c);
        //         }
        //         else{
        //             set.clear();
        //             set.add(c);
        //             count ++;
        //         }
             
        // }
        // return count;
    }
}