class Solution {

    //Solving on 14 Dec 2025:

    //intuition 1 (DP : 2D : Bottom-up Tabulation Solution : DP on strings pattern / DP on prefixes of strings)
        //Recurrence relation: 
            //We have two scenarios:
                //1. When current char from text1 == current char from text2. In this case we increase our LCS
                    //count by 1 and add it to dp state where both of the current chars were not added (dp[i-1][j-1])
                    //This gives dp[i][j] = 1 + dp[i-1][j-1]
                //2. When the current char from text1 != current char from text2. In this case we take max of two cases:
                    //i. What if current char from text1 was not added, resulting in i-1 length of text1? What will be the 
                        //dp state in that case? => dp[i-1][j]
                    //ii. What if current char from text2 was not added, resulting in j-1 length of text2? What will be
                        //the dp state in that case? => dp[i][j-1]
                    //This gives dp[i][j] = Math.max(dp[i-1][j] + dp[i][j-1])

        //Base cases:
            //Given empty text1, the LCS is 0, therefore, fill the first row with 0
            //Given empty text2, the LCS is 0, therefore, fill the first col with 0
   

    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j] represents LCS between text1 till i length and text2 till j length
        //dp[tex1.length()][text2.length()] will represent LCS between text1 and text2
        //Therefore, we need a 2D matrix of size text1.length()+1 x text2.length()+1

        int rows = text1.length() + 1;
        int cols = text2.length() + 1;

        int[][] dp = new int[rows][cols];

        //filling base cases
        
        dp[0][0] = 0;

        //filling first row
        for(int j = 1; j < cols; j ++){
            dp[0][j] = 0;
        }

        //filling first col
        for(int i = 1; i < rows; i ++){
            dp[i][0] = 0;
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

            }
        }

        return dp[rows-1][cols-1];


    }






























////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     //Solving on 14 Dec 2025:

//     //intuition 1 (DP : 2D: Bottom-Up Tabulation Solution: DP on strings pattern / DP on prefixes of strings)
//         //Base cases:
//             //Fill first row with 0: This is true as given 0 length of text1, the 
//                 //only possible LCS is an empty string and hence, 0
//             //Fill the first col with 0: This is true as given 0 length of text2, the
//                 //only possible LCS is an empty string and hence, 0
//         //Recurrence relation:
//             //If current character from both the strings matches, then the subproblem reduces
//                 //to finding LCS from both of the remaining strings after not considering
//                 //the matching character. => dp[i][j] = 1 + dp[i-1][j-1]
//             //If current character from both the strings does not match, then we have two scenarios:
//                 //1. Skip the current character from text1 and look for LCS in remaining text1 (reduced by 1) with original text2
//                 //2. Skip the current character from text2 and look for LCS in remaining text2 (reduced by 1) with original text1
//                 //And then take the max out of these two as we need LCS
//             //=> dp[i][j] = Math.max(dp[i-1][j](reducing text1 length), dp[i][j-1](reducing text2 length))

//     public int longestCommonSubsequence(String text1, String text2) {
//         //dp[i][j] represents longest common subsequence till i length of text1
//             //and j length of text2
//         //dp[text1.length()][text2.length()] will represent LCS for both the strings
//         //Therefore, we need a 2D matrix of size text1.length()+1 x text2.length()+1

//         int rows = text1.length() + 1;
//         int cols = text2.length() + 1;

//         int[][] dp = new int[rows][cols];


//         //base cases
//         //filling first row
//         for(int j = 0; j < cols; j ++){
//             dp[0][j] = 0;
//         }

//         //filling first col
//         for(int i = 0; i < rows; i ++){
//             dp[i][0] = 0;
//         }


//         for(int i = 1; i < rows; i ++){
//             for(int j = 1; j < cols; j ++){
//                 if(text1.charAt(i - 1) == text2.charAt(j - 1)){
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 }
//                 else{
//                     dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }

//         return dp[rows - 1][cols - 1];


    
//     }






























// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 11 Dec 2025:

    // //intuition 1 (DP : 2D: Bottom-Up Tabulation Solution):
    //     //We can have a 2D matrix to store longest subsequence's length till now in each cell
        
    //     //Base case: 
    //         //Set the extra row/col to 0
    //     //Recurrence relation:
    //         //if text1[i-1] == text2[j-1] => add 1 to the previous diagnol cell in dp (dp[i-1][j-1]) 
    //             //doing this in order to avoid any duplicate summations. As adding to diagonal ensures that
    //                 //there was some character, other than current one, that was matched. 
    //             //Reson: If one character gets matched, then we are left with i-1 length of text1 and j-1 length 
    //                 //of text2 to compare
    //         //else dp[i][j] = max(top + left)
    //             //top and left are being considered because we need to make sure if any of the previous
    //                 //addition to the length have resulted in an increase of longest subsequence's length,
    //                 //and consider the max.


    // public int longestCommonSubsequence(String text1, String text2) {
    //     //dp[i][j] represents the longest common subsequence between two strings till i length of text1 
    //         //and j length of text2
    //     //Assuming length of text1 is tLen1 and length of text2 is tLen2, to find longest common subsequence 
    //         //between both these strings, we need a dp matrix of tLen1+1 x tLen2+1 size

    //     int rows = text1.length();
    //     int cols = text2.length();

    //     int[][] dp = new int[rows + 1][cols + 1];

    //     for(int j = 0; j < cols + 1; j ++){
    //         dp[0][j] = 0;
    //     }

    //     for(int i = 0; i < rows + 1; i ++){
    //         dp[i][0] = 0;
    //     }

    //     for(int i = 1; i < rows + 1; i ++){
    //         for(int j = 1; j < cols + 1; j ++){
    //             int match = text1.charAt(i - 1) == text2.charAt(j - 1) ? 1 : 0;
    //             // if(i == 1 && j == 1){
    //             //     dp[1][1] = match;
    //             //     continue;
    //             // }
    //             if(match == 1){
    //                 dp[i][j] = match + dp[i - 1][j - 1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); 
    //             }
    //         }
    //     }

    //     return dp[rows][cols];
    
    // }
}