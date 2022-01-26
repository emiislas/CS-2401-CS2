
public class Cat {
    
    private int row;
    private int col;
    private int appetite;
    private int numMiceEaten;
    
    /** 
    * Sets row, col, and appetite based on the inputs.
    * Sets numMiceEaten to 0.
    */
    public Cat(int r, int c, int a) {
        this.row = r;
        this.col = c;
        this.appetite = a;
        this.numMiceEaten = 0;
    }
    
    /**
    * If the cat has already filled its appetite or all the mice have already been eaten, do nothing.
    * Chooses one not-yet-eaten Mouse from the input array as the target and moves towards that Mouse.
    * The cat is allowed to move up, down, left, right, or diagonally one space.
    * After the move, eat any mice that are at the cat's location.
    */
    public void chaseMice(Mouse[] mice) {
        Mouse target = null;
        if(appetite > numMiceEaten){
            for(int i = 0; i < mice.length; i++){
                if(!mice[i].isEaten()){
                    target = mice[i];
                }
            }
        }
        if(target == null){
            return;    
        }
        if(row > target.getRow()){
            row--;
        }
        else if(row < target.getRow()){
            row ++;
        }
        if(col > target.getCol()){
            col --;
        }
        else if(col < target.getCol()){
            col ++;
        }
        for(int i = 0; i < mice.length; i++){
            if(mice[i].getRow() == row && mice[i].getCol() == col){
                mice[i].beEaten();
                numMiceEaten++;
            }
        }
    }//endCHASE
    
    // Returns the cat's row.
    public int getRow() {
        return row;
    }
    
    // Returns the cat's column.
    public int getCol() {
        return col;
    }
}