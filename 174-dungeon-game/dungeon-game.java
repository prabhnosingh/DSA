class Solution {
    
    //Re-Solving on 23 Dec 2025:

    //intuition 1: (2D DP: DP on grids pattern: Answer at 0,0) 
        //We will build our answer from bottom to top. Minimum health required to survive after reaching princess
            //cell will be 1.
        
        //Recurrence relation:
            //If a cell have a positive value, then only additional health required is
                //min(right, down) - currCellVal and if currCellVal is greater than min(right, down),
                //then the knight only need 1 health (because he cannot have 0 health) to reach bottom 
                //right from current cell
            //=>dp[i] = Math.max(1, Math.min(right, down) - currCellVal)
            
            //If a cell have a negative value, then apart from abs(currCellVal), the knight need min(left, right)
                //to reach bottom right cell from current cell. 
            //=>dp[i] = Math.min(right, down) + currCellVal

            //if currCellVal is negative, the negative sign in Math.max(1, Math.min(right, down) - currCellVal), will
                //automatically become positive. So we can just use 1 equation for both the scenarios. 
        //Base cases:  
            //for last row the knight can only move left to right, therefore dp[i][j] = Math.max(1, right - currCellVal)
            //for last row the knight can only move top to down, therefore dp[i][j] = Math.max(1, down - currCellVal) 

    public int calculateMinimumHP(int[][] dungeon) {
        //dp[i][j] represents minimum health required to reach bottom right cell from i,j while only travelling down
            //and right.
        //dp[0][0] will represent minimum health required to reach bottom right cell from 0,0 cell while only travelling
            //down and right
        //Therefore, we need a 2D matrix of size dungeon.length x dungeon[0].length 

        int rows = dungeon.length;
        int cols = dungeon[0].length;

        int[][] dp = new int[rows][cols];

        //base cases
        dp[rows-1][cols-1] = dungeon[rows-1][cols-1] < 0 ? (1 - dungeon[rows-1][cols-1]) : 1;

        //filling last row 
        for(int j = cols - 2; j >= 0; j --){
            dp[rows-1][j] = Math.max(1, dp[rows-1][j+1] - dungeon[rows-1][j]);
        }

        //filling last col
        for(int i = rows - 2; i >= 0; i --){
            dp[i][cols-1] = Math.max(1, dp[i+1][cols-1] - dungeon[i][cols-1]);
        }


        for(int i = rows - 2; i >= 0; i --){
            for(int j = cols - 2; j >= 0; j --){
                dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
            }
        }

        return dp[0][0];

    

    }





























    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // //Solving on 20 Dec 2025:

    // //intuition 2 (Cleaning intuition 1): (DP on grids pattern: Solution at 0,0):

    //     //Base case:    
    //         //Starting from bottom right, the minimum health required to reach bottom right depends on the value of 
    //             //dungeon[rows-1][cols-1]:
    //                 //if it is negative, we need 1 + absValue
    //                 //if it is positive, we only need 1 (as health cannot go below 1 or else the kight will die)

    //         //In last col, knight can only travel in down direction. 
    //         //For dungeon[rows-2][cols-1]:
    //             //if the cell have a positive value greater than equal the dp[rows-1][cols-1], then simply put 1 for that
    //                 //dp cell
    //             //else simpy subtract the current dungeon cell value from the previous dp value and store it in current 
    //                 //dp value
           
    //             //if(dungeon[i][j] > 0 && dungeon[i][j] >= dp[i+1][j]) then dp[i][j] = 1;
    //             //else dp[i][j] = dp[i+1][j] - dungeon[i][j]
            
    //         //In last row, knight can only travel in right direction
    //         //Starting from bottom right towards left:
    //             //if(dungeon[i][j] > 0 && dungeon[i][j] >= dp[i][j+1]) then dp[i][j] = 1;
    //             //else dp[i][j] = dp[i][j+1] - dungeon[i][j]

    //     //Recurrence relation:
    //         //For any cell, apart from last row and last col, kinght have two options, either to move down
    //             //or move right.
    //         //Now for any cell i,j there are two cases:
    //             //1. Either the cell value is negative:                    
    //                 //In this case dp[i][j] = abs(dungeon[i][j]) + Math.min(down dp cell, right dp cell):
    //                     //Rationale: knight needs atleast abs(dungeon[i][j]) health to have 0 health as
    //                         // as soon as he lands on i,j. After landing, knight is supposed to move right or 
    //                         //down, for which he needs either health of down dp cell or right dp cell. We
    //                         //choose the minimum of these two.
    
                
    //             //2. Or, the cell value is positive
    //                 //In this case we have two further scenarios:
    //                     //i. if dungeon[i][j] >= min(down dp cell, right dp cell) then dp[i][j] = 1
    //                         //Rationale: Knight only needs 1 health (because he cannot have 0 health)
    //                             //to move foward. As soon as he lands on i,j he will get more health
    //                             //to travel either down or right (whichever is min).
                        
    //                     //ii. if dungeon[i][j] < min(down dp cell, right dp cell), then 
    //                         //dp[i][j] = min(down dp cell, right dp cell) - dungeon[i][j]
    //                         //Rationale: Kinght only needs this much health because as soon as he lands
    //                             //on dungeon[i][j] he will get addtional points to match with min of either
    //                             //down or right cell. 
            
    
    // public int calculateMinimumHP(int[][] dungeon) {
    //     //dp[i][j] represents minimum health requried to reach bottom right from i, j while only travelling down and right
    //     //dp[0][0] will represent minimum health required to reach bottom right from 0, 0 while only travelling down and right
    //     //Therefore, we need a 2D matrix of size dungeon.length x dungeon[0].length

    //     int rows = dungeon.length;
    //     int cols = dungeon[0].length;

    //     int[][] dp = new int[rows][cols];

    //     //Base cases:

    //     //bottom right cell
    //     dp[rows-1][cols-1] = Math.max(1, 1 - dungeon[rows-1][cols-1]);

    //     //last row
    //     for(int j = cols - 2; j >= 0; j --){
    //         dp[rows-1][j] = Math.max(1, dp[rows-1][j+1] - dungeon[rows-1][j]);
    //     }

    //     //last col
    //     for(int i = rows - 2; i >= 0; i --){
    //         dp[i][cols-1] = Math.max(1, dp[i+1][cols-1] - dungeon[i][cols-1]);
    //     }

    //     for(int i = rows - 2; i >= 0; i --){
    //         for(int j = cols - 2; j >= 0; j --){
    //             //"The knight must enter each cell with enough health so that AFTER applying the cell value, his 
    //                 //health is >= 1 and sufficient for the next cell."
    //             dp[i][j] = Math.max(1, Math.min(dp[i+1][j], dp[i][j+1]) - dungeon[i][j]);
    //             //if Math.min(down, right) - dungeon[i][j] is positive then that means the knight will need additional intial 
    //                 //health to reach the i,j cell. => in this case intial health required is min(down, right) - dungeon[i][j]
    //             //if Math.min(down, right) - dungeon[i][j] is negative then that means the knight will have abundance of health
    //                 //and does not need any additional initial health to reach i,j cell. => in this case intial health
    //                 //required is minimum possible ("1")
    //         }
    //     }
      

    //     return dp[0][0];

    // }












    // //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // //Solving on 18 Dec 2025:

    // //intuition 1: (DP on grids pattern: Solution at 0,0) 

    //     //Base case:    
    //         //Starting from bottom right, the minimum health required to reach bottom right depends on the value of 
    //             //dungeon[rows-1][cols-1]:
    //                 //if it is negative, we need 1 + absValue
    //                 //if it is positive, we only need 1 (as health cannot go below 1 or else the kight will die)

    //         //In last col, knight can only travel in down direction. 
    //         //For dungeon[rows-2][cols-1]:
    //             //if the cell have a positive value greater than equal the dp[rows-1][cols-1], then simply put 1 for that
    //                 //dp cell
    //             //else simpy subtract the current dungeon cell value from the previous dp value and store it in current 
    //                 //dp value
           
    //             //if(dungeon[i][j] > 0 && dungeon[i][j] >= dp[i+1][j]) then dp[i][j] = 1;
    //             //else dp[i][j] = dp[i+1][j] - dungeon[i][j]
            
    //         //In last row, knight can only travel in right direction
    //         //Starting from bottom right towards left:
    //             //if(dungeon[i][j] > 0 && dungeon[i][j] >= dp[i][j+1]) then dp[i][j] = 1;
    //             //else dp[i][j] = dp[i][j+1] - dungeon[i][j]

    //     //Recurrence relation:
    //         //For any cell, apart from last row and last col, kinght have two options, either to move down
    //             //or move right.
    //         //Now for any cell i,j there are two cases:
    //             //1. Either the cell value is negative:                    
    //                 //In this case dp[i][j] = abs(dungeon[i][j]) + Math.min(down dp cell, right dp cell):
    //                     //Rationale: knight needs atleast abs(dungeon[i][j]) health to have 0 health as
    //                         // as soon as he lands on i,j. After landing, knight is supposed to move right or 
    //                         //down, for which he needs either health of down dp cell or right dp cell. We
    //                         //choose the minimum of these two.
    
                
    //             //2. Or, the cell value is positive
    //                 //In this case we have two further scenarios:
    //                     //i. if dungeon[i][j] >= min(down dp cell, right dp cell) then dp[i][j] = 1
    //                         //Rationale: Knight only needs 1 health (because he cannot have 0 health)
    //                             //to move foward. As soon as he lands on i,j he will get more health
    //                             //to travel either down or right (whichever is min).
                        
    //                     //ii. if dungeon[i][j] < min(down dp cell, right dp cell), then 
    //                         //dp[i][j] = min(down dp cell, right dp cell) - dungeon[i][j]
    //                         //Rationale: Kinght only needs this much health because as soon as he lands
    //                             //on dungeon[i][j] he will get addtional points to match with min of either
    //                             //down or right cell. 
            
    
    // public int calculateMinimumHP(int[][] dungeon) {
    //     //dp[i][j] represents minimum health requried to reach bottom right from i, j while only travelling down and right
    //     //dp[0][0] will represent minimum health required to reach bottom right from 0, 0 whil only travelling down and right
    //     //Therefore, we need a 2D matrix of size dungeon.length x dungeon[0].length

    //     int rows = dungeon.length;
    //     int cols = dungeon[0].length;

    //     int[][] dp = new int[rows][cols];

    //     //Base cases:

    //     //bottom right cell
    //     if(dungeon[rows-1][cols-1] < 0){
    //         dp[rows-1][cols-1] = Math.abs(dungeon[rows-1][cols-1]) + 1;
    //     }
    //     else{
    //         dp[rows-1][cols-1] = 1;
    //     }

    //     //last row
    //     for(int j = cols - 2; j >= 0; j --){
    //         if(dungeon[rows-1][j] > 0 && dungeon[rows-1][j] >= dp[rows-1][j+1]){
    //             dp[rows-1][j] = 1; 
    //         }
    //         else{
    //             dp[rows-1][j] = dp[rows-1][j+1] - dungeon[rows-1][j];
    //         }
    //     }

    //     //last col
    //     for(int i = rows - 2; i >= 0; i --){
    //         int j = cols - 1;
    //         if(dungeon[i][j] > 0 && dungeon[i][j] >= dp[i+1][j]){
    //             dp[i][j] = 1;
    //         }
    //         else{
    //             dp[i][j] = dp[i+1][j] - dungeon[i][j];
    //         }
    //     }

    //     for(int i = rows - 2; i >= 0; i --){
    //         for(int j = cols - 2; j >= 0; j --){
    //             int cellVal = Math.abs(dungeon[i][j]);
    //             int nextMinVal = Math.min(dp[i+1][j], dp[i][j+1]);
    //             // if(dungeon[i][j] < 0){
    //             //     // dp[i][j] = cellVal + (cellVal < nextMinVal ? (nextMinVal - cellVal) : 1);
    //             //     if(cellVal < nextMinVal){
    //             //         // dp[i][j] = cellVal + (nextMinVal - cellVal);
    //             //         dp[i][j] = cellVal + nextMinVal;
    //             //     }
    //             //     else if(cellVal >= nextMinVal){
    //             //         // dp[i][j] = cellVal + 1; //exactly cellVal health to survive and atleast 1 more health to move forward
    //             //         dp[i][j] = cellVal + nextMinVal; 
    //             //     }
    //             //     ///loook into this -> do we need to add 1 or 0
    //             // }
    //             if(dungeon[i][j] < 0){
    //                     dp[i][j] = cellVal + nextMinVal; 
    //             }
    //             else{ //dungeon cell value is positive
    //                 if(dungeon[i][j] >= nextMinVal){
    //                     dp[i][j] = 1;
    //                 }
    //                 else if(dungeon[i][j] < nextMinVal){
    //                     dp[i][j] = nextMinVal - dungeon[i][j];
    //                 }
    //             }
    //         }
    //     }
    //     // for(int i = 0; i < rows; i ++){
    //     //     for(int j = 0; j < cols; j ++){
    //     //         System.out.print(dp[i][j] + ", ");
    //     //     }
    //     //     System.out.println();
    //     // }


    //     return dp[0][0];

    // }


}
