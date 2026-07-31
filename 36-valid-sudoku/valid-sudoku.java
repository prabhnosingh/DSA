class Solution {

    //re-solving: 13 Oct 2025
    //intuition 1 (hashSets): //Have 3 hashmaps with keys as rows, cols and squares and values as a hashSet. Traverse each row 
    //and keep adding elements to the hashset  
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
        HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
        HashMap<List<Integer>, HashSet<Character>> squareMap = new HashMap<>();

        for(int row = 0; row < 9; row ++){
            for(int col = 0; col < 9; col ++){
                char currChar = board[row][col];
                if(currChar == '.') continue;

                if(!rowMap.containsKey(row)){
                    rowMap.put(row, new HashSet<>());
                }
                if(!rowMap.get(row).add(currChar)){
                    return false;   
                }

                if(!colMap.containsKey(col)){
                    colMap.put(col, new HashSet<>());
                }
                if(!colMap.get(col).add(currChar)){
                    return false;
                }

                int sRow = row / 3;
                int sCol = col / 3;
                List<Integer> currSquare = new ArrayList<>(Arrays.asList(sRow, sCol));
                if(!squareMap.containsKey(currSquare)){
                    squareMap.put(currSquare, new HashSet<>());
                }
                if(!squareMap.get(currSquare).add(currChar)){
                    return false;
                }
            }

        }
        return true;

    }
}