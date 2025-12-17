class Solution {
    //Solving on 13 Dec 2025:

    //intuition 1 (DP: Bottom Up Tabulation soultion: DP on strings / DP on prefixes of string pattern)
        //Recurrence relation: While traversing the dp matrix we have two scenarios
            //1. The current character of word1 matches with the current character of word2. In this case
                //we do not need to perform any operation, therefore we take the minimum ops required if 
                //these matching characters were not added. => dp[i-1][j-1]
            
            //2. The current character of word1 does not match with the current character of word2. In this 
                //case we have three choices: Replace, Delete, or Insert
                
                //i. Replace: If we replace the current char from word1 to match with the current char from
                    //word2, we use 1 operation. Now in the state after replacing, we have both our current 
                    //chars matching. Therefore, we can take the min ops required if these matching chars
                    //were not added. => 1 + dp[i-1][j-1]
                
                //ii. Delete: If we delete the current mismatching char from word1, we will be left with word1 
                    //shorter by 1 length. This leaves us with the subproblem of finding min ops required
                    //to convert word1 of new length(i-1) to word2 of unchanged length. => 1 + dp[i-1][j]
                    
                //iii. Insert: We insert a matching character similar to current char of word2 into word1. Now
                    //we have our word1 length increased by 1 while word2 remains as it is. Now we also have 
                    //current chars of both the strings matching. This leaves us with the subproblem of finding
                    //min ops required to covert word1 to word2 if these matching chars were not added. 
                    //=> 1 + dp[i+1 - 1][j-1] => 1 + dp[i][j-1]  

                //we take the operation which is minimum 

        //Base cases:
            //Given an empty word1 and empty word2 strings, we need 0 ops to match them
            //Given an empty word1 and non-empty word2 strings, we need word2.length() ops to convert word1 to
                //word2, i.e. by inserting word2 chars into word1.
            //Given an empty word2 and non-empty word1 strings, we need word1.length() ops to convert word1 to 
                //word2, i.e. by deleting all word1 chars.

    public int minDistance(String word1, String word2) {
        //dp[i][j] represents minimum ops required to convert word1 till length i to word2 till length j
        //dp[word1.length()][word2.length()] will represent minimum ops required to convert word1 to word2
        //Therefore, we need a 2D matrix of size word1.length()+1 x word2.length()+1

        int rows = word1.length() + 1;
        int cols = word2.length() + 1;

        int[][] dp = new int[rows][cols];

        //Base cases:

        dp[0][0] = 0;

        //filling first row (word1 is empty string)
        for(int j = 1; j < cols; j ++){
            dp[0][j] = j;
        }

        //filling first col (word2 is empty string)
        for(int i = 1; i < rows; i ++){
            dp[i][0] = i;
        }


        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else{
                    int replaceOp = 1 + dp[i-1][j-1];
                    int deleteOp = 1 + dp[i-1][j];
                    int insertOp = 1 + dp[i][j-1];

                    dp[i][j] = Math.min(Math.min(replaceOp, deleteOp), insertOp);
                }
            }
        }

        return dp[rows-1][cols-1];
        

    }































//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 13 Dec 2025:

//     //intuition 1 (DP: Bottom up tabulation: DP on String/DP on prefixes of string pattern)
        
//         //Base case:
//             //if word1 is empty string, then we need word2.length() operations to make word1 equal to word2 by
//                 //adding the characters of word2 in word1, therefore, fill first row with length of word2
//             //if word2 is empty string, then we need word1.length() operations to make word1 equal to word2 by
//                 //deleting the characters of word1, therefore, fill first col with length of word1
        
//         //Recurrence relation:
//         //if(w1.currChar == w2.currChar) then dp[i][j] = dp[i-1][j-1]
//             //reaon: if both the current chars match, then the subproblem is reduced to finding min
//                 //operations required to convert word1 - currChar1 to word2 - currChar2
//         //if(w1.currChar != w2.currChar) then we have three options:
//             //1.Replace: If we replace the current chars so that they become equal, it is 1 operation cost
//                 //and now the subproblem reduces to finding min ops requrired to covert word1-currChar to
//                 //word2-currChar => dp[i][j] = 1 + dp[i-1][j-1]
            
//             //2.Delete: We can simply delete the current char from word1 in the hope that this will make word1
//                 //equal to word2. This will cost 1 operation. Now after reducing word1 length by 1, the subproblem
//                 //reduces to finding min ops required to covert word1-currChar to word2. => dp[i][j] = 1 + dp[i-1][j]
            
//             //3.Insert: We can also insert one character in word1 that is matching with currChar of word2, so that
//                 //both currChars become equal. Now after inserting a char in word1, the length of word1 becomes i + 1.
//                 //Now as both the currChars of word1 and word2 are same, the subproblem reduces to finding the min
//                 //ops required to convert word1-currChar1 to word2-currChar2 => dp[i][j] = 1 + dp[i + 1 - 1][j - 1] 
//                 //dp[i][j] = 1 + dp[i][j-1]  

//             //Other explanation of insert: Inserting a character in word1 makes the last char of word1 match with word2,
//                 //leaving us with the subproblem of finding minOps to convert word1's initial length to word2 - currChar2.
//                 //i, j-1
//             //"Insert: Inserting a character into word1 makes it match word2[j-1].After that, we only need to convert
//                 //word1[0..i-1] to word2[0..j-2], which is dp[i][j-1]."
            
//             //choose the minimum of all three ops at each step
//     public int minDistance(String word1, String word2) {
//         //dp[i][j] represents minimum number of operations required to convert word1 till length i to 
//             //word2 till length j
//         //dp[word1.length()][word2.length()] will represent minimum number of operations required to 
//             //convert word1 to word2
//         //Therefore, we need a 2D matrix of size word1.length()+1 x word2.length()+1

//         int rows = word1.length() + 1;
//         int cols = word2.length() + 1;
        
//         int[][] dp = new int[rows][cols];

//         //base cases
//         //filling first row
//         for(int j = 0; j < cols; j ++){
//             dp[0][j] = j;
//         }

//         //filling first col
//         for(int i = 0; i < rows; i ++){
//             dp[i][0] = i;
//         }

//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(word1.charAt(i - 1) == word2.charAt(j - 1)){
//                     dp[i][j] = dp[i - 1][j - 1];
//                 }
//                 else{
//                     int replaceOp = 1 + dp[i - 1][j - 1];
//                     int deleteOp = 1 + dp[i - 1][j];
//                     int insertOp = 1 + dp[i][j - 1];

//                     dp[i][j] = Math.min(Math.min(replaceOp, deleteOp), insertOp);
//                 }
//             }
//         }
//         return dp[rows - 1][cols - 1];


//     }































// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 13 Dec 2025:

    // //intuition 1 (DP: bottom up tabulation)
    //     //if(word1.charAt(i - 1) == word2.charAt(j - 1)) then dp[i][j] = dp[i - 1][j - 1] as latest
    //         //char will not require any additional ops for conversion.
    //         //Reason: if latest chars from both word1 and word2 were not added, then how many min ops were
    //             //required to convert word1 till i-1 to word2 till j-1
    //         //Proper Reason: "if the last characters already match, you don’t need any operation for
    //             //them — just rely on the previous prefixes."

    //     //if(word1.charAt(i - 1) != word2.charAt(j - 1)) then:
    //         //we have three options to go with:
    //             //1. replace the character in word1, in which case the subproblem that we will be left with
    //                 //is min number of ops to convert remaning prefix from both the strings word1 and word2, i.e.
    //                 //dp[i-1][j-1]
    //             //2. delete the character in word1, in which case the subproblem that we will be left with 
    //                 //is min number of ops to convert the remaining word1 string to word2 string till j, i.e.
    //                 //dp[i-1][j]
    //             //3. insert the character in word1, in which case the subproblem that we will be left with is min
    //                 //number of ops to convert the current word1 to relatively reduced word2 string till j-1, i.e.
    //                 //dp[i][j-1]. This is true because word1 length will increase by 1 and that recent insertion 
    //                 //will match with the current char of word2, so this becomes like word1.charAt(i+1-1) == word2.charAt(j-1)
    //                 //Now we are left with word2 chars till j-2 index (j - 1 in dp array) and original str till i-1 index (i in dp array)
    //                 //This is equal to dp[i][j-1]

    //         //now we choose the minimum of these three operations at each step and add 1 to compensate the new operation
    //         //Recurrence relation comes to be: dp[i][j] = 1 + Math.min(dp[i-1][j-1]replace, dp[i-1][j]delete,
    //             //dp[i][j-1]insert)

    //     //Base case:
    //         //if word1.length == 0 and word2.length == 0 then dp[0][0] = 0 as there is no operation is required
    //         //if word1.length == 0 and word2 is non empty, then we will require the word2.length ops to match 
    //             //both the strings. This will inlude inserting characters to word1 => fill first row with col 
    //             //numbers
    //         //if word2.length == 0 and word1 is non empty, then we will require the word1.length ops to match
    //             //both the strings. This will include deleting the characters from word1 => fill first col with
    //             //row numbers 
    // public int minDistance(String word1, String word2) {
    //     //dp[i][j] represents the minimum number of operations required to convert word1 till i length
    //         //so that it matches word2 till j length
    //     //Our answer will be at dp[word1.length()][word2.length()]
    //     //Therefore, we need a 2D dp array of size word1.length()+1 x word2.length+1

    //     int rows = word1.length() + 1;
    //     int cols = word2.length() + 1;

    //     int[][] dp = new int[rows][cols];

    //     //base case
    //     dp[0][0] = 0;

    //     for(int j = 1; j < cols; j ++){
    //         dp[0][j] = j;
    //     }
    //     for(int i = 1; i < rows; i ++){
    //         dp[i][0] = i;
    //     }


    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
                
    //             char ch1 = word1.charAt(i - 1);
    //             char ch2 = word2.charAt(j - 1);
                
    //             if(ch1 == ch2){
    //                 dp[i][j] = dp[i - 1][j - 1];
    //             }
    //             else{
    //                 int replaceOp = dp[i - 1][j - 1];
    //                 int deleteOp = dp[i - 1][j];
    //                 int insertOp = dp[i][j - 1];

    //                 dp[i][j] = 1 + Math.min(Math.min(replaceOp, deleteOp), insertOp);
    //             }
    //         }
    //     }

    //     return dp[rows - 1][cols - 1];

    // }
}