class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        char[] mag = magazine.toCharArray();
        char[] ran = ransomNote.toCharArray();

        HashMap<Character, Integer> map = new HashMap<>();

        for(char m : mag){
            map.put(m, map.getOrDefault(m, 0)+1);
        }

        int i = 0;
        // for(Map.Entry<Character, Integer> ent : map.entrySet()){
        //     if(ran[i] <= ent.get)
        // }
        for(char r : ran){

            if(map.get(r) ==  null ){
                return false;
            }
            else if(map.get(r) > 0){
                map.put(r, map.get(r)-1);
            }

            else{
                return false;
            }
        }
        return true;

    }
}