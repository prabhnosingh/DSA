class Solution {
    public int findSum(int num){
        int s = 0;
        while(num != 0){
            int digit = num % 10;
            s += (digit*digit);
            num = num / 10;
        }
            return s;
    } 
    public boolean isHappy(int n) {

        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
       
        
        if(n == 1){
            return true;
        }
       

        while(true){
           if(set.contains(findSum(n))){
               return false;
           }
            sum = findSum(n);
            if(sum == 1){
                return true;
            }
         
            if(!set.contains(sum)){
                set.add(sum);
         
            }
    
            
            n = sum;
        }

        
    }
}