// YOU DO NOT NEED TO MODIFY THIS FILE.

public class Location {
    
    private int row;
    private int col;
    private boolean isOpen;
    private boolean visited;
    private Location previousLocation;
    
    public Location(int row, int col, boolean isOpen) {
        this.row = row;
        this.col = col;
        this.isOpen = isOpen;
        this.visited = false;
        this.previousLocation = null;
    }
    
    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public boolean isOpen() {
        return isOpen;
    }
    
    public boolean isVisited() {
        return visited;
    }
    
    public void markAsVisited() {
        this.visited = true;
    }
    
    public Location getPreviousLocation() {
        return previousLocation;
    }
    
    public void setPreviousLocation(Location prev) {
        this.previousLocation = prev;
    }
    
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}