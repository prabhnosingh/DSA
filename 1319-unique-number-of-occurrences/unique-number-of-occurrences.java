class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);

        }
        int occ = 0;
        HashSet<Integer> set1 = new HashSet<>();
          for(int n : map.keySet()){
               occ = map.get(n);
              if(set1.contains(occ)){
                  return false;
              }
              else{
                  
              set1.add(occ);
              }
        }
        return true;
    }
}