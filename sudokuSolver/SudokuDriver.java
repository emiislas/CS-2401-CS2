
public class SudokuDriver {
    
    public static void main(String[] args) throws InterruptedException {
        
        // This is a simple Sudoku puzzle, just for debugging.
        /*int[][] almostDoneBoard = 
            {{0, 0, 0, 0, 0, 0, 0, 0, 0},
             {0, 0, 0, 0, 0, 0, 0, 0, 0},
             {1, 9, 8, 3, 4, 2, 5, 6, 7},
             {8, 5, 9, 7, 6, 1, 4, 2, 3},
             {4, 2, 6, 8, 5, 3, 7, 9, 1},
             {7, 1, 3, 9, 2, 4, 8, 5, 6},
             {9, 6, 1, 5, 3, 7, 2, 8, 4},
             {2, 8, 7, 4, 1, 9, 6, 3, 5},
             {3, 4, 5, 2, 8, 6, 1, 7, 9}};
        Sudoku almostDoneSudoku = new Sudoku(almostDoneBoard);
        almostDoneSudoku.solve();
        almostDoneSudoku.printBoard();*/
        
        // This is an actual Sudoku puzzle, that actual people actually try to solve.
        // It may have a different solution than the board above.
        // The board above has several solutions, this board only has one.
        int[][] board =
            {{0, 0, 7, 8, 0, 0, 9, 0, 0},
             {0, 9, 6, 0, 0, 0, 1, 2, 0},
             {2, 0, 0, 0, 0, 0, 5, 0, 0},
             {4, 1, 0, 0, 0, 0, 6, 0, 0},
             {9, 0, 8, 0, 1, 0, 0, 3, 4},
             {0, 6, 3, 4, 9, 2, 8, 1, 0},
             {0, 0, 0, 9, 4, 0, 0, 5, 0},
             {8, 0, 1, 0, 7, 0, 4, 6, 0},
             {5, 4, 0, 0, 3, 1, 2, 8, 0}};
        Sudoku sudoku = new Sudoku(board);
        sudoku.solve();
        sudoku.printBoard();
    }
}