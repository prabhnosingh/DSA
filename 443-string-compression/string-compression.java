class Solution {
    public int compress(char[] chars) {
   
    if(chars.length == 0){
        return 0;
    }
    int idx = 0;
    int count = 1;

    for(int i = 1; i < chars.length; i ++){
        if(chars[i - 1] == chars[i]){
            count ++;
        }
        else{
           
                chars[idx ++] = chars[i - 1];
           
            if(count > 1){
                for(char c : Integer.toString(count).toCharArray()){
                    chars[idx ++] = c;
                }
            }
            count = 1;
        }
    }

    chars[idx ++] = chars[chars.length - 1];

    if(count != 1){
        for(char c : Integer.toString(count).toCharArray()){
            chars[idx ++] = c;
        }
    }

    return idx;








   
//************************************************************************************* */   
     // beats 15 %     
        // if(chars.length == 1) return 1;
        // String s = "";
        // int idx = 0;
        
        // int len = chars.length;

        // int ans = 0;
        // for(int i = 0; i < len; i ++){
        //     if(i < len - 1 && chars[i] == chars[i + 1]){
        //         s += chars[i];
                
        //          int count = 1;
        //         while(i < len - 1 && chars[i] == chars[i + 1]){
        //             count ++; 
        //             i ++;                  
        //         }
          
        //         s += count;
        //         for(char ch : s.toCharArray()){
        //             chars[idx ++] = ch;
            
        //            ans ++;
        //         }
        //         s = "";
               
        //     }
        //     else{
        //         chars[idx ++] = chars[i];
        //         ans ++;
            
        //     }
         
        // }

               

        // return ans;
///////////////////////////////////
    //     if (chars == null || chars.length == 0) {
    //     return 0;
    // }

    // int writeIdx = 0;
    // int count = 1;

    // for (int i = 1; i < chars.length; i++) {
    //     if (chars[i] == chars[i - 1]) {
    //         count++;
    //     } else {
    //         chars[writeIdx++] = chars[i - 1];
    //         if (count > 1) {
    //             for (char c : Integer.toString(count).toCharArray()) {
    //                 chars[writeIdx++] = c;
    //             }
    //         }
    //         count = 1;
    //     }
    // }

    // chars[writeIdx++] = chars[chars.length - 1];
    // if (count > 1) {
    //     for (char c : Integer.toString(count).toCharArray()) {
    //         chars[writeIdx++] = c;
    //     }
    // }

    // return writeIdx;
    }
}