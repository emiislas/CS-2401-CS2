

public class Sudoku {

    // A 9-by-9 array representing a Sudoku board. A 0 means the square has
    // not been assigned yet.
    private int[][] board;
    
    /**
     * Precondition: board is a 9-by-9 array with only the numbers 0-9 as values.
     */ 
    public Sudoku(int[][] board) {
        this.board = board;
    }
    
    
    // THIS IS THE ONLY METHOD YOU NEED TO MODIFY
    public boolean solve() throws InterruptedException {
        // -- COMMENT OUT THESE LINES WHEN YOU'RE READY TO SOLVE THE ACTUAL SUDOKU BOARD --
        printBoard();
        Thread.sleep(100);
        // ---------------
        if (!isBoardValid()){
            return false;
        }
        if (isBoardValid() && isBoardFull()){
            return true;
        }
        int n = 0;
        int j = 0;
        for (int row = 0; row < board.length; row++){
            for(int col = 0; col < board[0].length; col++){
                if (board[row][col] == 0){
                    n = row;
                    j = col;
                    break;
                        
                    }
                }
            }
        for (int i = 1; i < 10; i++){
            board[n][j] = i;
            if (solve()){
                return true;
            }
        }
        
        board[n][j] = 0;
        return false;
    }
    
    // YOU DO NOT NEED TO MODIFY ANY CODE BELOW THIS.
    
    public void printBoard() {
        String boardString = "";
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    boardString += ".";
                } else {
                    boardString += board[r][c];
                }
            }
            boardString += "\n";
        }
        System.out.println(boardString);
    }
    
    public boolean isBoardFull() {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /**
     * Returns whether or not the Sudoku board is valid. Each row, column, or
     * 3-by-3 subsquare is valid if it contains the numbers 1-9 exactly once
     * with any number of unassigned squares.
     */
    public boolean isBoardValid() {
        boolean isValid = true;
        for (int r = 0; r < 9; r++) {
            if (!isRowValid(r)) {
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if (!isColumnValid(c)) {
                return false;
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!isSquareValid(i)) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * Returns true if and only if row r is a valid Sudoku row.
     * Precondition: row is in the range [0, 9).
     */
    public boolean isRowValid(int row) {
        return isNumberSetValid(board[row]);
    }
    
    /**
     * Returns true if and only if column c is a valid Sudoku column.
     * Precondition: column is in the range [0, 9).
     */
    public boolean isColumnValid(int column) {
        int[] columnNumbers = new int[9];
        for (int i = 0; i < columnNumbers.length; i++) {
            columnNumbers[i] = board[i][column];
        }
        return isNumberSetValid(columnNumbers);
    }
    
    /**
     * Returns true if and only if 3-by-3 subsquare containing the entry at row, column
     * is a valid Sudoku subsquare.
     * Precondition: squareIndex is in the range [0, 9).
     */
    public boolean isSquareValid(int squareIndex) {
        int startR = 3 * (squareIndex / 3);
        int startC = 3 * (squareIndex % 3);
        int[] subsquareNumbers = new int[9];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                subsquareNumbers[3*r + c] = board[startR + r][startC + c];
            }
        }
        return isNumberSetValid(subsquareNumbers);
    }
    
    /**
     * Returns whether the input set could constitute a valid row, column, or subsquare.
     */
    public static boolean isNumberSetValid(int[] set) {
        boolean[] allNumbers = new boolean[10];
        for (int i = 0; i < set.length; i++) {
            int value = set[i];
            if (value != 0) {
                if (allNumbers[value]) {
                    return false;
                }
                allNumbers[value] = true;
            }
        }
        return true;
    }
    
    public int[][] getBoard() {
        return board;
    }
}