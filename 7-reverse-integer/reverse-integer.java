class Solution {
    public int reverse(int x) {
        
        boolean neg = false;
        if(x < 0){
            neg = true;
        }
        int finalNum = 0;

        while(x != 0){

             if(finalNum > 214748364  || finalNum < -214748364){
                     return 0;
                 }
            int lastDig = x % 10;
            
            // finalNum += lastDig;
            finalNum = finalNum*10 + lastDig;

            x = x / 10;

        }

        // finalNum = finalNum/10;

       

        return finalNum;
    }
}