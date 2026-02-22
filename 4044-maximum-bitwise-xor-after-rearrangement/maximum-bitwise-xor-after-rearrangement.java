class Solution {

    //Solving on 21 Feb 2026
        //intuition 1: Math : Bits
            //We need to make the MSBs of final number 1 as much as possible

        //Count number of 1s and 0s in t, then see if you can find opposite of 
            //each digit in s from left to right
            
    public String maximumXor(String s, String t) {

        int tOnes = 0;
        int tZeroes = 0;
        for(char ch : t.toCharArray()){
            if(ch == '0') tZeroes += 1;
            if(ch == '1') tOnes += 1;
        }
        StringBuilder finalAns = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch == '0'){
                if(tOnes != 0){
                    finalAns.append('1');
                    tOnes -= 1;
                }
                else{
                    finalAns.append('0');
                    tZeroes -= 1;
                }
            }
            else{ //if ch == 1
                if(tZeroes != 0){
                    finalAns.append('1');
                    tZeroes -= 1;
                }
                else{
                    finalAns.append('0');
                    tOnes -= 1;
                }
            }
        }

        return finalAns.toString();
        
    }
}


//s:101
//t:011
//r:110


