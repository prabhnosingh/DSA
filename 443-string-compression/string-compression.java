class Solution {
    public int compress(char[] chars) {
   
        //  int indexAns = 0, index = 0;
        // while(index < chars.length){
        //     char currentChar = chars[index];
        //     int count = 0;
        //     while(index < chars.length && chars[index] == currentChar){
        //         index++;
        //         count++;
        //     }
        //     chars[indexAns++] = currentChar;
        //     if(count != 1)
        //         for(char c : Integer.toString(count).toCharArray()) 
        //             chars[indexAns++] = c;
        // }
        // return indexAns;
   
//************************************************************************************* */   
     // beats 15 %     
        if(chars.length == 1) return 1;
        String s = "";
        int idx = 0;
        
        int len = chars.length;

        int ans = 0;
        for(int i = 0; i < len; i ++){
            if(i < len - 1 && chars[i] == chars[i + 1]){
                s += chars[i];
                
                 int count = 1;
                while(i < len - 1 && chars[i] == chars[i + 1]){
                    count ++; 
                    i ++;                  
                }
          
                s += count;
                for(char ch : s.toCharArray()){
                    chars[idx ++] = ch;
            
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