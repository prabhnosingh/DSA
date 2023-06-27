class Solution {
  
  public int[] topKFrequent(int[] nums, int k){
      int[] ans = new int[k];

      int len = nums.length;

      Map<Integer, Integer> map = new HashMap<>();

      for(int i = 0; i<len; i++){
          map.put(nums[i], map.getOrDefault(nums[i],0) + 1);

      }

      PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> (a.getValue() - b.getValue()));

      for(Map.Entry<Integer, Integer> entry : map.entrySet()){

          pq.offer(entry);
          if(pq.size() > k){
              pq.poll();
          }
      }
          int i = 0;

          while(!pq.isEmpty()){
             ans[i++] = pq.poll().getKey();
          }
          return ans;
      
  
    }
}
