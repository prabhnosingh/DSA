class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {   

        if(ransomNote.length() > magazine.length()) return false;
        int[] count = new int[26];

        for(char c : magazine.toCharArray()){
            count[c - 'a']++;
        }

        for(char c : ransomNote.toCharArray()){
            if(count[c - 'a'] == 0) return false;
            count[c - 'a']--;
        }

        return true;










//**************************************************************************** */

        // int[] count = new int[26];

        // for(int i = 0; i < magazine.length(); i ++){
        //     char cm = magazine.charAt(i);

        //     count[cm - 'a']++;
        // }

        // for(int j = 0; j < ransomNote.length(); j ++){
        //     char cr = ransomNote.charAt(j);

        //     if(count[cr - 'a'] > 0){
        //         count[cr - 'a']--;
        //     }
        //     else{
        //         return false;
        //     }

        // }
        // return true;












// **************************************************************************
        // char[] mag = magazine.toCharArray();
        // char[] ran = ransomNote.toCharArray();

        // HashMap<Character, Integer> map = new HashMap<>();

        // for(char m : mag){
        //     map.put(m, map.getOrDefault(m, 0)+1);
        // }

        // int i = 0;
        // // for(Map.Entry<Character, Integer> ent : map.entrySet()){
        // //     if(ran[i] <= ent.get)
        // // }
        // for(char r : ran){

        //     if(map.get(r) ==  null ){
        //         return false;
        //     }
        //     else if(map.get(r) > 0){
        //         map.put(r, map.get(r)-1);
        //     }

        //     else if(map.get(r) <= 0){
        //         return false;
        //     }
        // }
        // return true;

    }
}