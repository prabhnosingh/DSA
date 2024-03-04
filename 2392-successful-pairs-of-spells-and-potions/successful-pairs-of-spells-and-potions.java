class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        int maxP = 0;
        for (int p : potions) {
            maxP = Math.max(maxP, p);
        }

        int[] suf = new int[maxP + 1];
        
        for (int p : potions){
            suf[p]++;
        }
        
        for (int i = suf.length - 2; i >= 0; i--) {
            // every cell contains number of potions (where value) higher then current index
            suf[i] += suf[i + 1];
        }
        
        for (int i = 0; i < spells.length; i++) {
            // long v = (success + spells[i] - 1 ) / spells[i]; 
            //above statement is same as below
            // Potion * Spell = Success -> Potion = Success / Spell
            double v = Math.ceil((double)success / spells[i]);
            
            spells[i] = v > maxP ? 0 : suf[(int)v];
        }
        return spells;
    }
}

        //////////////////////////////////////////////////////////////////////////////////////
        // beats 83.59 %
        // Arrays.sort(potions);
        // int[] pairs = new int[spells.length];
        // int idx = 0;
        // for(int spell : spells){
        //     int left = 0;
        //     int right = potions.length - 1;

        //     while(left <= right){
        //         int mid = left + (right - left) / 2;

        //         long prod = (long) spell * potions[mid];

        //         if(prod >= success){
        //             right = mid - 1;
        //         }
        //         else{
        //             left = mid + 1;
        //         }


        //     }

        //     int count = potions.length - left;

        //     pairs[idx ++] = count;


        // }
        // return pairs;




        
//////////////////////////////////////////////////////////////////////////////////
        // TLE
        // Arrays.sort(potions);
        // int[] pairs = new int[spells.length];
        // int idx = 0;
        // for(int spell : spells){
            
        //     long prod = 0;
        //     int start = 0;
        //     int end = potions.length;
        //     int mid = start + (end - start)/2;


        //     int last_suc_idx = 0; 
            
        //     prod = (long) spell * potions[mid];
        //     if(prod >= success){
        //         while(prod >= success && mid > 0){
        //             last_suc_idx = mid;
        //             mid --;
        //             prod = (long) spell * potions[mid];
        //         }
        //         if(mid == 0 && prod >= success){
        //             last_suc_idx = mid;
        //         }
        //     }
        //     else if(prod < success){
        //         while(prod < success && mid < potions.length - 1){
        //             mid ++;
        //              prod = (long) spell * potions[mid];
        //         }
        //         if(mid == potions.length - 1){
        //             if(prod >= success) last_suc_idx = mid; 
        //             else last_suc_idx = potions.length;
        //         }
        //         else{
        //             last_suc_idx = mid;
        //         }
        //     }
     
        //     intcount = potions.length - last_suc_idx;

        //     pairs[idx ++] = count;
        // }
        // return pairs;














      ///////////////////////////////////////////////////////////////////////////  
      // TLE
        // Arrays.sort(potions);
        // int[] pairs = new int[spells.length];
        // int idx = 0;
        // for(int spell : spells){
        //     int count = 0;
        
        //     for(int j = 0; j < potions.length; j ++){
        //         long prod = (long) spell * potions[j];
        //         if(prod >= success){
        //             count ++;
        //         }
        //     }
        //     pairs[idx ++] = count;
        // }
        // return pairs;
//     }
// }