
public class Mouse {

    private int row;
    private int col;
    private boolean isEaten;
    
    /**
     * Sets row and col based on the inputs. Sets isEaten to false.
     */
    public Mouse(int r, int c) {
        this.row = r;
        this.col = c;
        this.isEaten = false;
    }
    
    /**
     * If the Mouse has not been eaten, move in a random direction (up, down, left, or right).
     * If its random move would take it out-of-bounds, it bumps into the wall and doesn't move.
     */
    public void move() {
        int randomMove = (int) (Math.random() * 4);
        if (!isEaten) {
            if (randomMove == 0 && row > 0) {
                row--;
            } else if (randomMove == 1 && row < Board.BOARD_SIZE - 1) {
                row++;
            } else if (randomMove == 2 && col > 0) {
                col--;
            } else if (randomMove == 3 && col < Board.BOARD_SIZE - 1) {
                col++;
            }
        }
    }
    
    // Returns the Mouse's row.
    public int getRow() {
        return row;
    }
    
    // Returns the Mouses column.
    public int getCol() {
        return col;
    }
    
    // Returns whether or not the Mouse has been eaten.
    public boolean isEaten() {
        return isEaten;
    }
    
    // Marks this Mouse as eaten.
    public void beEaten() {
        isEaten = true;
    }
}