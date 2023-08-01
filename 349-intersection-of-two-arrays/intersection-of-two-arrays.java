class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }

        for(int j = 0; j < nums2.length; j++){
            if(set.contains(nums2[j])){
                arr.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }

        int[] arrFin = new int[arr.size()];
        for(int k = 0; k < arr.size(); k++){
            arrFin[k] = arr.get(k);
        }
       
        return arrFin;

        
    }
}