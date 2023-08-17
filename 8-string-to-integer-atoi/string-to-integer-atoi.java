class Solution {
    public int myAtoi(String s) {
        
        char[] c = s.toCharArray();
        String num = "";
        boolean sign = false;

        boolean pos = true;
        int idx = 0;
        boolean foundDigit = false;
        for(char ch : c){
            if(idx == 0 && ch == '-' || ch == '+'){
                if(sign) break;
                sign = true;
                idx ++;
                if(ch == '-'){
                    pos = false;
                }
                 
            }
          
          
           else if(idx == 0 && ch == ' '){
                
                continue;
            }
            else if(!foundDigit && ch == '0'){
                idx ++;
                continue;
            }

            else if( ch == '.' || ch <= 122 && ch >= 97 ){
                break;
            }
            else if(idx != 0  && ch == '+' || ch == '-' || ch == ' '){
             break;
            }
            else{
                num += ch;
                idx ++;
                foundDigit = true;
                // number = true;
            }
        }
        if(num == "") return 0;
        if(num.length() > 10){
            return pos ? (int)Math.pow(2, 31) : (int)-(Math.pow(2, 31));
        }
        long n = pos ? Long.parseLong(num) : -Long.parseLong(num);
        // long n = Long.parseLong(num);
        if(n > (Math.pow(2, 31) - 1)){
            return (int)(Math.pow(2, 31) - 1);
        }
        else if(n < -(Math.pow(2, 31))){
            return (int)-(Math.pow(2, 31));
        }
        return (int)n;
    }
}