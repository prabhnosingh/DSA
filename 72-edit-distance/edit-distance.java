class Solution {
    //Solving on 13 Dec 2025:

    //intuition 1 (DP: bottom up tabulation)
        //if(word1.charAt(i - 1) == word2.charAt(j - 1)) then dp[i][j] = dp[i - 1][j - 1] as latest
            //char will not require any additional ops for conversion.
            //if latest chars from both word1 and word2 were not added, then how many min ops were
                //required to convert word1 till i-1 to word2 till j-1
            //Proper Reason: "if the last characters already match, you don’t need any operation for
                //them — just rely on the previous prefixes."

        //if(word1.charAt(i - 1) != word2.charAt(j - 1)) then:
            //we have three options to go with:
                //1. replace the character in word1, in which case the subproblem that we will be left with
                    //is min number of ops to convert remaning prefix from both the strings word1 and word2, i.e.
                    //dp[i-1][j-1]
                //2. delete the character in word1, in which case the subproblem that we will be left with 
                    //is min number of ops to convert the remaining word1 string to word2 string till j, i.e.
                    //dp[i-1][j]
                //3. insert the character in word1, in which case the subproblem that we will be left with is min
                    //number of ops to convert the current word1 to relatively reduced word2 string till j, i.e.
                    //dp[i][j-1]. This is true because word1 length will increase by 1 and that recent insertion 
                    //will match with the current char of word2, so this becomes like word1.charAt(i+1-1) == word2.charAt(j-1)
                    //This is equal to dp[i][j-1]

            //now we choose the minimum of these three operations at each step and add 1 to compensate the original ops
            //Recurrence relation comes to be: dp[i][j] = 1 + Math.min(dp[i-1][j-1]replace + dp[i-1][j]delete +
                //dp[i][j-1]insert)

        //Base case:
            //if word1.length == 0 and word2.length == 0 then dp[0][0] = 0 as there is no operation is required
            //if word1.length == 0 and word2 is non empty, then we will require the word2.length ops to match 
                //both the strings. This will inlude inserting characters to word1 => fill first row with col 
                //numbers
            //if word2.length == 0 and word1 is non empty, then we will require the word1.length ops to match
                //both the strings. This will include deleting the characters from word1 => fill first col with
                //row numbers 
    public int minDistance(String word1, String word2) {
        //dp[i][j] represents the minimum number of operations required to convert word1 till i length
            //so that it matches word2 till j length
        //Our answer will be at dp[word1.length()][word2.length()]
        //Therefore, we need a 2D dp array of size word1.length()+1 x word2.length+1

        int rows = word1.length() + 1;
        int cols = word2.length() + 1;

        int[][] dp = new int[rows][cols];

        //base case
        dp[0][0] = 0;

        for(int j = 1; j < cols; j ++){
            dp[0][j] = j;
        }
        for(int i = 1; i < rows; i ++){
            dp[i][0] = i;
        }


        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                
                char ch1 = word1.charAt(i - 1);
                char ch2 = word2.charAt(j - 1);
                
                if(ch1 == ch2){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else{
                    int replaceOp = dp[i - 1][j - 1];
                    int deleteOp = dp[i - 1][j];
                    int insertOp = dp[i][j - 1];

                    dp[i][j] = 1 + Math.min(Math.min(replaceOp, deleteOp), insertOp);
                }
            }
        }

        return dp[rows - 1][cols - 1];

    }
}