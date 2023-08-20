class Solution {
    public int romanToInt(String s) {
        
        int num = 0;
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){

// I
                case 'I':
                if(i+1 != s.length() && s.charAt(i + 1) == 'V'){
                    num += 4;
                    i ++;
                }
                else if(i+1 != s.length() && s.charAt(i + 1) == 'X'){
                    num += 9;
                    i ++;
                }
                else{
                    num += 1;
                }
                break;
// X
                case 'X':
                 if(i+1 != s.length() && s.charAt(i + 1) == 'L'){
                    num += 40;
                    i ++;
                }
                else if(i+1 != s.length() && s.charAt(i + 1) == 'C'){
                    num += 90;
                    i ++;
                }
                else{
                    num += 10;
                }
                break;

// C            
                case 'C':
                 if(i+1 != s.length() && s.charAt(i + 1) == 'D'){
                    num += 400;
                    i ++;
                }
                else if(i+1 != s.length() && s.charAt(i + 1) == 'M'){
                    num += 900;
                    i ++;
                }
                else{
                    num += 100;
                }
                break;

                case 'V':
                num += 5;
                break;

                case 'L':
                num += 50;
                break;

                case 'D':
                num += 500;
                break;

                case 'M':
                num += 1000;
                break;
            }
        }

        return num;
    }
}