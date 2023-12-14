class Solution {
    public int equalPairs(int[][] grid) {

        int n = grid.length;
        HashMap<Integer, Integer> map = new HashMap<>();


        for(int i = 0; i < n; i ++){
            int hash = 0;

            for(int j = 0; j < n; j ++){
                hash = grid[i][j] + (hash * 13);

            }
            map.put(hash, map.getOrDefault(hash, 0) + 1);
            
        }
        int count = 0;

        for(int i = 0; i < n; i ++){
            int hash = 0;

            for(int j = 0; j < n; j ++){
                hash = grid[j][i] + (hash * 13);

            }

            count += map.getOrDefault(hash, 0);

        }

        return count;















////////////////////////////////////////////////////////////////////////////
      // beats 90 %
        // int n = grid[0].length;
        // int count = 0;
       
        // HashMap<ArrayList<Integer>, Integer> map  = new HashMap<>();

        // for(int i = 0; i < n; i ++){
        //     ArrayList<Integer> arr = new ArrayList<>();
         

        //     for(int j = 0; j < n; j ++){
        //         arr.add(grid[i][j]);
              
        //     }

        //     map.put(arr, map.getOrDefault(arr, 0) + 1);
                 
            
          
        // }

        // for(int i = 0; i < n; i ++){
        //     ArrayList<Integer> arr2 = new ArrayList<>();

        //      for(int j = 0; j < n; j ++){
        //         arr2.add(grid[j][i]);
              
        //     }

        //     if(map.containsKey(arr2)){
        //         count += map.get(arr2);
        //     }
        // }
        // // return equal == n ? count + equal - 1 : count;
        // return count;
    }
}