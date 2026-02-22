class Solution {

    //Solving on 21 Feb 2026
    //intuition 2: Math + Strings
        //Find the sum of factorials of digits
        //Then sort the sum string and n string, and see if both of these are equal

        //
    public boolean isDigitorialPermutation(int n) {

        int sum = 0;

        int n2 = n;
        while(n2 != 0){
            int digit = n2 % 10;

            sum += factorial(digit);

            n2 = n2 / 10;
        }

        // if(sum == n) return true;
        
        String sumString = sum + "";

        String numString = n + "";

        char[] sumArray = sumString.toCharArray();
        Arrays.sort(sumArray);

        char[] numArray = numString.toCharArray();
        Arrays.sort(numArray);

        String sortedSumString = new String(sumArray);
        String sortedNumString = new String(numArray);

        // System.out.println(sortedSumString);
        // System.out.println(sortedNumString);

        return(sortedSumString.equals(sortedNumString));      
                
    }



    private int factorial (int num){
        if(num == 1 || num == 0) return 1;

        return num * factorial(num-1);
    }




////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 21 Feb 2026
//     //intuition 1: Backtracking (Permutations) + Math
//         //Find the sum of factorials of digits
//         //Then run backtracking to find permutations and see if any
//             //permutation lead to a number that is equal to the sum

//         //
//     public boolean isDigitorialPermutation(int n) {

//         int sum = 0;

//         int n2 = n;
//         while(n2 != 0){
//             int digit = n2 % 10;

//             sum += factorial(digit);

//             n2 = n2 / 10;
//         }

//         if(sum == n) return true;
        
//         String sumString = sum + "";

//         String numString = n + "";

//         if(sumString.length() != numString.length()) return false; //needed for conditions
//             //like 13 == 13 in case of 133. As currComb.length() == sum.length() leads to 
//             //true in permutate function

//             // 133
//             // 13
        
//         return permutate(sumString, new StringBuilder(), numString, 
//                          new boolean[numString.length()]);        
                
//     }

//     //133
// //currComb = '13'
//     private boolean permutate (String sum, StringBuilder currComb, String num,
//                                boolean[] visited){
//         if(currComb.length() > 0 && currComb.charAt(0) == '0') return false;
//         if(currComb.length() == sum.length()){
//             if(sum.equals(currComb.toString())) return true;
//             return false;
//         }

//         boolean validPermutation = false; 

//         for(int i = 0; i < num.length(); i ++){ //0 - 2 
//             if(visited[i]) continue;
            
//             currComb.append(num.charAt(i));
//             visited[i] = true; //o idx -> '1'
            
//             validPermutation = validPermutation || permutate(sum, currComb, num, visited);
//             if(validPermutation) break;

//             visited[i] = false;
//             currComb.deleteCharAt(currComb.length() - 1); //removing last char
//         }

//         return validPermutation;
//     }
    

//     private int factorial (int num){
//         if(num == 1 || num == 0) return 1;

//         return num * factorial(num-1);
//     }
}