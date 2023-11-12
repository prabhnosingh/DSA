class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();

        boolean[] counts1 = new boolean[2001];
        boolean[] counts2 = new boolean[2001];

        for(int num : nums1){
            counts1[num + 1000] = true;
        }
        for(int num : nums2){
            counts2[num + 1000] = true;
            if(!counts1[num + 1000]){
                ans2.add(num);
                counts1[num + 1000] = true;
            }
        }

        for(int num : nums1){
            if(!counts2[num + 1000]){
                ans1.add(num);
                counts2[num + 1000] = true;
            }
        }

        answer.add(ans1);
        answer.add(ans2);
        return answer;
///////////////////////////////////////////////////////////////
     // beats 99 %   
    //    List<List<Integer>> answer = new ArrayList<>();
    //    int[] counts1 = new int[2001];
    //    int[] counts2 = new int[2001];
       
    //     for(int num : nums1){
    //         counts1[num + 1000] ++;
    //     }
    //     for(int num : nums2){
    //         counts2[num + 1000] ++;
    //     }

    //     List<Integer> ans1 = new ArrayList<>();
    //     List<Integer> ans2 = new ArrayList<>();
    //     for(int i = 0; i < counts1.length; i ++){
    //         if(counts1[i] != 0 && counts2[i] == 0){
    //             ans1.add(i - 1000);
    //         }
    //         if(counts2[i] != 0 && counts1[i] == 0){
    //             ans2.add(i - 1000);
    //         }

    //     }

    //     answer.add(ans1);
    //     answer.add(ans2);
    //     return answer;

///////////////////////////////////////////////////////////       
       // beats 37.50%
        // List<List<Integer>> answer = new ArrayList<>();

        // List<Integer> ans1 = new ArrayList<>();
        // List<Integer> ans2 = new ArrayList<>();

        // HashMap<Integer, Integer> map1 = new HashMap<>();
        // HashMap<Integer, Integer> map2 = new HashMap<>();

        // for(int num : nums1){
        //     map1.put(num, map1.getOrDefault(num, 0) + 1);

        // }
        // for(int num : nums2){
        //     map2.put(num, map2.getOrDefault(num, 0) + 1);

        // }
        
        // for(int num : nums1){
        //     if(!map2.containsKey(num)){
        //         if(map1.get(num) >= 1){
        //             ans1.add(num);
        //             map1.put(num, 0);
        //         }
        //     }
        // }
        // for(int num : nums2){
        //     if(!map1.containsKey(num)){
        //         if(map2.get(num) >= 1){
        //             ans2.add(num);
        //             map2.put(num, 0);
        //         }
        //     }
        // }

        // answer.add(ans1);
        // answer.add(ans2);
        // return answer;
    }
}