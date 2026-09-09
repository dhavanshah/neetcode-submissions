class Solution {
    public boolean isValidSudoku(char[][] board) {

        //use hashset to keep track of row
        //use hash set to keep track of column
        //use hashset to keep track of squares
        //declare 3 maps Map<Integer, Set<Character>>
        //key is the row/column index and value
        //is actual number, the key for squares
        //has to be row/3,column/3 so as to divide
        //the 3x3 grids into groups like
        //0,1,2-> 0 | 3,4,5 -> 1. | 4,5,6->2
        //and so on....

        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r=0; r<9; r++) {

            for(int c=0; c<9; c++) {

                if(board[r][c] == '.') {
                    continue;
                }

                String sqKey = (r/3) + "," + (c/3);

                if(rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) 
                || columns.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) 
                || squares.computeIfAbsent(sqKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                columns.get(c).add(board[r][c]);
                squares.get(sqKey).add(board[r][c]);
            }
        }
        return true;
        
    }
}
