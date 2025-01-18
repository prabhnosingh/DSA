class Solution {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> positiveDiagnols = new HashSet<>();
    HashSet<Integer> negativeDiagnols = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        
        char[][] board = new char[n][n];
        for(char[] row : board){
            Arrays.fill(row, '.');
        }

        dfs(0, n, board);
       
        return res;
            
    }

    private void dfs(int row, int n, char[][] board){
        if(row == n){
            List<String> copy = new ArrayList<>();
            for(char[] r : board){
                copy.add(new String(r));
            }
            res.add(copy);
            return;
        }

        
        // for loop for placing queen in a row
        for(int col = 0; col < n; col ++){
            if(cols.contains(col) || positiveDiagnols.contains(row + col) || negativeDiagnols.contains(row - col)){
                continue;
            }

            cols.add(col);
            positiveDiagnols.add(row + col);
            negativeDiagnols.add(row - col);
            board[row][col] = 'Q';

            dfs(row + 1, n, board);

            cols.remove(col);
            positiveDiagnols.remove(row + col);
            negativeDiagnols.remove(row - col);
            board[row][col] = '.';

             
        }


    }
}