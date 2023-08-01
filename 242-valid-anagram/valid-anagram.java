class Solution {
    public boolean isAnagram(String s, String t) {

    int[] arr = new int[26];

    for(int i = 0; i < s.length(); i++){

        arr[s.charAt(i) - 'a']++;
    }

    for(int i = 0; i < t.length(); i++) arr[t.charAt(i) - 'a']--;

    for(int i : arr) if(i != 0) return false;

    return true;












    // char[] cs = s.toCharArray();
    // char[] ts = t.toCharArray();

    // Arrays.sort(cs);
    // Arrays.sort(ts);

    // if(Arrays.equals(cs,ts)){
    //     return true;
    // }
    // return false;






















    //  if(s.length()!=t.length()) return false;
    //  HashMap<Character, Integer> map1 = new HashMap<>();
    //  HashMap<Character, Integer> map2 = new HashMap<>();

    //  for(int i=0; i<s.length(); i++){
    //    if(map1.containsKey(s.charAt(i))){
    //      int count= map1.get(s.charAt(i));
    //      map1.put(s.charAt(i), count+1); //increase the counter with increasing number of repetions
    //                                      // of the characters of the string
    //    }

    //    else{
    //      map1.put(s.charAt(i),1);
    //    }
    //  }

    //  for(int i=0; i<t.length(); i++){
    //    if(map2.containsKey(t.charAt(i))){
    //      int count= map2.get(t.charAt(i));
    //      map2.put(t.charAt(i), count+1);
    //    }

    //    else{
    //      map2.put(t.charAt(i),1);
    //    }
    //  }

    //  for(char k: map1.keySet()){//set creates a collection of unique elements out of keys (characters in this case)
    //    if(!map1.get(k).equals(map2.get(k))) return false;
    //  }
    //  return true;

    }
}