class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> answer = new ArrayList<>();

        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int num : nums1){
            map1.put(num, map1.getOrDefault(num, 0) + 1);

        }
        for(int num : nums2){
            map2.put(num, map2.getOrDefault(num, 0) + 1);

        }
        
        for(int num : nums1){
            if(!map2.containsKey(num)){
                if(map1.get(num) >= 1){
                    ans1.add(num);
                    map1.put(num, 0);
                }
            }
        }
        for(int num : nums2){
            if(!map1.containsKey(num)){
                if(map2.get(num) >= 1){
                    ans2.add(num);
                    map2.put(num, 0);
                }
            }
        }

        answer.add(ans1);
        answer.add(ans2);
        return answer;
    }
}