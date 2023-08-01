class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] exist = new boolean[1001];

        for(int i = 0; i < nums1.length; i++){
           exist[nums1[i]] = true;
        }

        int idx = 0;
        int[] result = new int[Math.min(nums1.length, nums2.length)];
        for(int i = 0; i < nums2.length; i++){
            if(exist[nums2[i]]){
            result[idx++] = nums2[i];
            exist[nums2[i]] = false;                
            }

        }

            return Arrays.copyOfRange(result, 0, idx);













        // HashSet<Integer> set = new HashSet<>();
        // ArrayList<Integer> arr = new ArrayList<>();
        // for(int i = 0; i < nums1.length; i++){
        //     set.add(nums1[i]);
        // }

        // for(int j = 0; j < nums2.length; j++){
        //     if(set.contains(nums2[j])){
        //         arr.add(nums2[j]);
        //         set.remove(nums2[j]);
        //     }
        // }

        // int[] arrFin = new int[arr.size()];
        // for(int k = 0; k < arr.size(); k++){
        //     arrFin[k] = arr.get(k);
        // }
       
        // return arrFin;

        
    }
}