class Solution {
    public int reverse(int x) {
        
        boolean neg = false;
        if(x < 0){
            neg = true;
        }
        long finalNum = 0;

        while(x != 0){
            int lastDig = x % 10;

            // finalNum += lastDig;
            finalNum = finalNum*10 + lastDig;

            x = x / 10;

        }

        // finalNum = finalNum/10;

        if(finalNum > Integer.MAX_VALUE || finalNum < Integer.MIN_VALUE){
            return 0;
        }

        return (int)(finalNum);
    }
}