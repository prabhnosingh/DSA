class Solution {
        //Solving on 21 Feb 2026
    

    //intuition 3: 3D DP : DP on grids  
        //
        //base case:
            //last row's each cell can be reached by both robots 

        //recurrence relation: going from rows-1 row towards 0 row
            //each state i, j1, j2 depends on previous 3 x 3 = 9 states
                //dp[i+1][j1-1][j2-1] 
                //dp[i+1][j1-1][j2+0]
                //dp[i+1][j1-1][j2+1]

                //dp[i+1][j1+0][j2-1] 
                //dp[i+1][j1+0][j2+0]
                //dp[i+1][j1+0][j2+1]
                
                //dp[i+1][j1+1][j2-1]
                //dp[i+1][j1+1][j2+0]
                //dp[i+1][j1+1][j2-1]

            //We will choose maximum out of these


    public int cherryPickup(int[][] grid) {
        //dp[i][j1][j2] will represent max number of combined cherries picked by R1 and 
            //R2 after starting from row i and R1 at col j1 and R2 at col j2
        //dp[0][0][cols-1] will represent max number of cherries picked by R1 and R2 
            //after starting from row 0 and R1 at col 0 and R2 at col cols-1
        
        //Therefore, we need a 3D dp of size rows x cols x cols

        int rows = grid.length;
        int cols = grid[0].length;

        int[][][] dp = new int[rows][cols][cols];

        //base case
        for(int j1 = 0; j1 < cols; j1 ++){
            for(int j2 = 0; j2 < cols; j2 ++){
                int i = rows - 1;
                if(j1 == j2){
                    dp[i][j1][j2] = grid[i][j1]; //R1 and R2 at same cols, hence only 1 can pick
                        //cherries
                }
                else{   
                    dp[i][j1][j2] = grid[i][j1] + grid[i][j2]; //R1 and R2 at two different cols
                }
            }
        }

        for(int i = rows-2; i >= 0; i --){
            for(int j1 = 0; j1 < cols; j1 ++){
                for(int j2 = 0; j2 < cols; j2 ++){
                    
                    dp[i][j1][j2] = 0;

                    int currentState = 0;

                    if(j1 == j2){ 
                        currentState = grid[i][j1]; //only consider cherries once
                    }
                    else{
                        currentState = grid[i][j1] + grid[i][j2];
                    }

                    for(int k1 = -1; k1 <= 1; k1 ++){
                        for(int k2 = -1; k2 <= 1; k2 ++){
                            if(j1+k1 < 0 || j1+k1 >= cols || j2+k2 < 0 || j2+k2 >= cols) continue;
                            dp[i][j1][j2] = Math.max(dp[i][j1][j2], 
                            currentState //current state
                            + dp[i+1][j1+k1][j2+k2]); //previous state
                        }
                    }
                    //

                }
            }
        }

        return dp[0][0][cols-1];

    }

///////////////////////////////////////////////////////////////////////////////////////////////


    //intuition 2: Recursion
        //We will consider max(all paths by R1 + all paths by R2) 
        //1.Express everything in terms of (i1,j2) for R1 and (i2,j2) for R2 and write base cases
            //If we have a fixed starting point and variable ending point, start recursion from
                //starting point f(0,0,0,m-1) == f(i1,j1,i2,j2)
            
            //Given that both the robots move downwards to next row one step at a time 
                //simultaneously, both of them will reach the bottom row at the same time.
            //And based on this we can say that i1 == i2 at all times => f(i,j1,i,j2)    

            //Base case:
                //if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) making sure paths remain inside the
                    //side boundaries of grid
                
                //if(i==n -1)

        //2. Explore all the paths 
            // 
        //3. Find maximum sum

    // public int cherryPickup(int[][] grid) {
        
    // }    

        
///////////////////////////////////////////////////////////////////////////////////////////////

    //intuition 1: 2D DP : DP on grids
        //We will build a 2D DP matrix bottom up - left right and our final answer
            //will be dp[0][0] + dp[0][cols-1]
        //Each dp state will depend on below 3 cells (i+1,j-1), (i+1,j), (i+1,j+1)
        //The main issue to resolve is to handle cells where alice and bob can both 
            //land. We need to make sure that each of the shared cell is used exactly once.
        //We can handle the special case by first finding all the shared cells (diagonally
            //downwards) and then somehow marking it as used if any of the dp state uses it
            //in its calculation.
        //By this way bob will always have first preference over the shared chocolates
        //This will not work as expected as there could be a scenario when giving preference    
            //to alice for the shared chocolates would have resulted in optimal solution.

    // public int cherryPickup(int[][] grid) {
        
    // }
}