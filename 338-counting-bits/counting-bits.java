class Solution {

public int countingOnes(int m){
    int ones = 0;

    while(m != 0){
        if(m % 2 > 0){
            ones ++;
        }
        m = m / 2;
        
    }
    return ones;
}

public int[] countBits(int n) {

int[] ans = new int[n + 1];

      
        for(int i = 0; i < n + 1; i ++){
            ans[i] = countingOnes(i);
        }
        return ans;


//////////////////////////////////////////////////////
    // beats 28.62 %
    //   public int countingOnes(int m){
    //         int ones = 0;
    //         for(int i = 31; i >= 0; i --){
    //             if((m & (1 << i)) >= 1){
    //                 ones ++;
    //             }
    //         }
    //         return ones;
    //     }
    // public int[] countBits(int n) {
    
    //     int[] ans = new int[n + 1];

      
    //     for(int i = 0; i < n + 1; i ++){
    //         ans[i] = countingOnes(i);
    //     }

    //     return ans;
    }
}