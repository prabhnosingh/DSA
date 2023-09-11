class Solution {
    public int sum(int n){
            int s = 0;
            if(n / 10 == 0){
                return n;
            }
            while(n / 10 != 0){
                s += n % 10;
                n = n / 10; 
            }
            s += n;
            return s;
        }

    public int addDigits(int num) {
        int ans = 0;
        while(true){
            ans = sum(num);
            if(ans / 10 == 0){
                return ans;
            }
            num = ans;
        }
        
    }
}