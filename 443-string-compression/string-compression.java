class Solution {
    public int compress(char[] chars) {
        
        if(chars.length == 1) return 1;
        String s = "";
        int idx = 0;
        

        int ans = 0;
        for(int i = 0; i < chars.length; i ++){
            if(i < chars.length - 1 && chars[i] == chars[i + 1]){
                s += chars[i];
                
                 int count = 1;
                while(i < chars.length - 1 && chars[i] == chars[i + 1]){
                    count ++; 
                    i ++;                  
                }
          
                s += count;
                for(char ch : s.toCharArray()){
                    chars[idx] = ch;
                    idx = idx + 1;
                   ans ++;
                }
                s = "";
               
            }
            else{
                chars[idx ++] = chars[i];
                ans ++;
            
            }
         
        }

               

        return ans;
    }
}