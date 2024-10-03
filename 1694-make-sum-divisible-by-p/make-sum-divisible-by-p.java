class Solution {
    public int minSubarray(int[] nums, int p) {
        
        int n = nums.length;
        double sum = 0;
        for(int num : nums){
            sum += num;
        }

        if(sum % p == 0.0){
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        // sum = sum % p;
        int reqMod = (int)(sum % p);
        int len = n;
        int currMod = 0;

        for(int idx = 0; idx < n; idx ++){
            if(len == 1){
                return 1;
            }

            currMod = (nums[idx] + currMod) % p;
            map.put(currMod, idx);

            if(reqMod == currMod){
                len = Math.min(idx + 1, len);
            }

            if(map.get((currMod + p - reqMod) % p) != null){
                len = Math.min(len, idx - map.get((currMod + p - reqMod) % p));
            }
        }

        if(len == n){
            return -1;
        }
        return len;

    }


}

