class Solution {
    //Solving on 28 Dec 2025:

    //intuition 2(brainstorming): 
        //It is a DP on grids / DP on strings pattern problem.
        //We need "every character of s3 to be consumed in order while choosing from s1 or s2 at each step"
        //"So we need to know how many chars we've used from s1 and s2 together, not independently" (like
            //in intuition 1)

    //intuiton 2: (2D DP: DP on grids pattern("prefix-consumption DP"): Parent problem: Unique paths)
       
            
        //Recurrence relation:
            //To reach i, j cell we have two ways:
                //i. from top, by considering pervious character from s1
                    //In this case we verify if previous state dp[i-1][j] was true and if currChar of 
                        //s1 (s1.charAt(i-1)) matches with currChar of s3 (s3.charAt(i+j-1))
                    //=> dp[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)
                    //Rationale: This works because if previous state is true than that means that given
                        //first i-1 chars from s1 and first j chars from s2, we can form first i-1+j chars
                        //of s3 and now if ith char (not index) from s1 matches with i+j char(not index) of
                        //s3, then current char from s1 is a valid choice to move forward with. This also
                        //satisfies our dp condition of "given first i chars from s1 and first j chars from 
                        //s2, can we form first i+j chars from s3"

                //ii. from left, by considering preivous character from s2
                    //In this case we verify if previous state dp[i][j-1] was true and if currChar of
                        //s2 (s2.charAt(j-1)) matches with currChar of s3 (s3.charAt(i+j-1))
                    //=> dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)
                    //Rationale: This works because if previous state is true than that means that given
                        //first i chars from s1 and first j-1 chars from s2, we can form first i+j-1 chars
                        //of s3 and now if jth char (not index) from s2 matches with i+j char(not index) of
                        //s3, then current char from s2 is a valid choice to move forward with. This also
                        //satisfies our dp condition of "given first i chars from s1 and first j chars from
                        //s2, can we form first i+j chars from s3"
                
                //Now we can reach i,j from either top or left so we take OR of these two scenarios
        
        //Base cases:
            //dp[0][0] = True => given first 0 chars of s1 and first 0 chars of s2 we can form first 0 chars of s3

            //Given 0 chars of s1, the dp state completely depends on s2 chars. Therefore for i=0, any j starting
                //from 1, dp[i][j] depends on previous dp state (dp[i][j-1]) and s3.charAt(j) == s2.charAt(j) => first row
                //As the chars from s2 should match as it is with s3 from left to right
            
            //Given 0 chars of s2, the dp state completely depends on s1 chars. Therefore for j=0, any i starting
                //from 1, dp[i][j] depends on previous dp state (dp[i-1][j]) and s3.charAt(i) == s1.charAt(i) => first col
                //As the chars from s1 should match as it is with s3 from top to bottom

            //If s1.length() + s2.length() != s3.length() => return false

      public boolean isInterleave(String s1, String s2, String s3) {
        //dp[i][j] represents if we can create first i+j chars of s3 with first i chars from s1 and first
            //j chars from s2.
        //dp[s1.length()][s2.length()] will represent if we can create s1.length()+s2.length() chars of s3 from
            //full s1 and s2 strings
        //Therefore we need a 2D dp matrix of size s1.length()+1 x s2.length()+1

        if(s1.length() + s2.length() != s3.length()) return false;


        int rows = s1.length() + 1;
        int cols = s2.length() + 1;

        boolean[][] dp = new boolean[rows][cols];

        //base cases
        dp[0][0] = true;
        
        //filling first row
        for(int j = 1; j < cols; j ++){
            int i = 0;
            dp[i][j] = dp[i][j-1] && (s2.charAt(j-1) == s3.charAt(j-1));
        }

        //filling first col
        for(int i = 1; i < rows; i ++){
            int j = 0; 
            dp[i][j] = dp[i-1][j] && (s1.charAt(i-1) == s3.charAt(i-1));
        }

        for(int i = 1; i < rows; i ++){
            for(int j = 1; j < cols; j ++){
                char currS3Char = s3.charAt(i+j-1);
                char currS1Char = s1.charAt(i-1);
                char currS2Char = s2.charAt(j-1);

                //considering currS1Char
                boolean top = dp[i-1][j] && currS1Char == currS3Char;

                //considering currS2Char
                boolean left = dp[i][j-1] && currS2Char == currS3Char;

                dp[i][j] = top || left;

            }
        }

        return dp[rows-1][cols-1];


    }























//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 28 Dec 2025:


    // //Did not work, wrong pattern identified


    // //intuition 1(brainstorming): 
    //     //Looks like DP on strings, subsequence pattern, LCS
    //     //Check if s3 contains Longest common subsequence equal to s2 and s1 both, if yes return true

    // //intuiton 1: (2D DP: DP on strings (pattern): Parent problem LCS)
    //     //For s3 to be made of s1 and s2, following condition must hold true:
    //         //LCS(s3, s1) = s1.length()
    //         //LCS(s3, s2) = s2.length()
    //     //This approach fails in scenario where both of the above conditions are true independently and not together
    //     //Meaning we need to remove the chars from s3 after each string matching and find the LCS on remaining 
    //         //s3 with other string. -> This does not work as the order of same characters can be different in different
    //         //strings 
    //     //=> Can we solve this by building LCS along the way instead? -> But anyway we will have to delete the chars
    //         //from the s3 string
        
    //     //=> We have to build all possible strings from s1 and s2 and see if one of them matches with s3
   

    //     //Base case:
    //         //if s3.length() != s1.length() + s2.length(), return false
            
    //     //LCS logic:
    //         //Recurrence relation:
    //             //If any two chars matches, the subproblem reduces to finding the length of common subsequence
    //                 //if these two chars were not added => 1 (for matching chars) + dp[i-1][j-1]
    //             //If two chars do not match, the subproblem reduces to finding the length of common subsequence
    //                 //if either of the charas were not added and selecting the scenario where subsequence length
    //                 //is max
    //                 //=> max(dp[i-1][j], dp[i][j-1])
    //         //Base case:
    //             //for any empty string, LCS will be 0, irrespective of the length of other string
    //             //Therefore, fill first row and first col as 0s

    // public boolean isInterleave(String s1, String s2, String s3) {
    //     //dp[i][j] represents length of longest common subsequence given i length of string 1 and j length of string 2
    //     //dp[s1.length()][s2.length()] will represent the length of LCS given full s1 string and full s2 string
    //     //Therefore, we will require, a 2D DP matrix of size s1.length()+1 x s2.length()+1 

    //     if(s1.length() + s2.length() != s3.length()) return false;
    //     if(s3.length() == 0) return true;

    //     //finding LCS(s3,s1)
    //     int rows = s3.length()+1;
    //     int cols = s1.length()+1;

    //     int[][] dp = new int[rows][cols];

    //     //base case
    //     //filling first row
    //     for(int j = 0; j < cols; j ++){
    //         int i = 0;
    //         dp[i][j] = 0;
    //     }

    //     //filling first col
    //     for(int i = 0; i < rows; i ++){
    //         int j = 0;
    //         dp[i][j] = 0;
    //     }

    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
    //             if(s3.charAt(i-1) == s1.charAt(j-1)){
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    //             }
    //         }
    //     }

    //     if(dp[rows-1][cols-1] != s1.length()){
    //         return false;
    //     }   
        
    //     StringBuilder sb = new StringBuilder(s3);
    //     for(int i = 0; i < s1.length(); i ++){
    //         char currChar = s1.charAt(i);
    //         int idxOfFirstCurrCharInSb = sb.indexOf(currChar + ""); //sb.indexOf takes string input
    //         sb.deleteCharAt(idxOfFirstCurrCharInSb); 
    //     }
    //     s3 = sb.toString();
    //     System.out.println(s3);
    //     // System.out.println(s3);

    //     //finding LCS(s3, s2)
    //     rows = s3.length()+1;
    //     cols = s2.length()+1;
    //     //reinitializing dp matrix
    //     dp = new int[rows][cols];

    //     //base cases
    //     //fillilng first row
    //     for(int j = 0; j < cols; j ++){
    //         int i = 0;
    //         dp[i][j] = 0;
    //     }

    //     //filling first col
    //     for(int i = 0; i < rows; i ++){
    //         int j = 0;
    //         dp[i][j] = 0;
    //     }

    //     for(int i = 1; i < rows; i ++){
    //         for(int j = 1; j < cols; j ++){
    //             if(s3.charAt(i-1) == s2.charAt(j-1)){
    //                 dp[i][j] = 1 + dp[i-1][j-1];
    //             }
    //             else{
    //                 dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
    //             }
    //         }
    //     }

    //     if(dp[rows-1][cols-1] != s2.length()){
    //         return false;
    //     }

    //     return true;

    
    // }
}