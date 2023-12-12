class Solution {
    public int equalPairs(int[][] grid) {
        
        int n = grid[0].length;
        int count = 0;
       
        HashMap<ArrayList<Integer>, Integer> map  = new HashMap<>();

        for(int i = 0; i < n; i ++){
            ArrayList<Integer> arr = new ArrayList<>();
         

            for(int j = 0; j < n; j ++){
                arr.add(grid[i][j]);
              
            }

            map.put(arr, map.getOrDefault(arr, 0) + 1);
                 
            
          
        }

        for(int i = 0; i < n; i ++){
            ArrayList<Integer> arr2 = new ArrayList<>();

             for(int j = 0; j < n; j ++){
                arr2.add(grid[j][i]);
              
            }

            if(map.containsKey(arr2)){
                count += map.get(arr2);
            }
        }
        // return equal == n ? count + equal - 1 : count;
        return count;
    }
}