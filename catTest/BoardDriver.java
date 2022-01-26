public class BoardDriver {
    public static void main(String[] args) throws InterruptedException {
        
        // Change the input parameters if you'd like to see different cat and mouse simulations.
        Board board = new Board(5, 3);
        
        while (true) {
            printCharArray(board.getDisplayArray());
            board.step();
            Thread.sleep(300);
        }
    }
    
    private static void printCharArray(char[][] displayArray) {
        String rowString = "";
        for (int r = 0; r < displayArray.length; r++) {
            for (int c = 0; c < displayArray[0].length; c++) {
                rowString += displayArray[r][c];
            }
            rowString += "\n";
        }
        
        System.out.println(rowString);
    }
}