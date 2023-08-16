class Solution {
    public int kthFactor(int n, int k) {

        for(int i = 1; i < Math.sqrt(n); i++){
            if(n % i == 0 && --k == 0){
                return i;
            }
        }
        for(int i = (int)(Math.sqrt(n)); i >= 1; --i){
            if(n % (n / i) == 0 && --k == 0){
                return n / i;
            }
        }

        return -1;

//********************************************************8 */
     //beats 100% but O(n) time complexity   
        // int count = 0;
        // for(int i = 1; i <= n; i ++){
        //     if(n % i == 0){
        //         count ++;
        //     }
        //     if(count == k){
        //         return i;
        //     }
        // }
        // return -1;
    }
} 