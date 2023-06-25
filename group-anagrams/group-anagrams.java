class Solution {


    public List<List<String>> groupAnagrams(String[] strs) {
    
    HashMap<String, ArrayList<String>> map = new HashMap<>();

    for(String str: strs){

      char[] chars = str.toCharArray();
      Arrays.sort(chars);
      String sortStr = String.valueOf(chars);

      if(!map.containsKey(sortStr)){
        map.put(sortStr, new ArrayList<>());
      }

      map.get(sortStr).add(str);



    }
    return new ArrayList<>(map.values());

}
}






















