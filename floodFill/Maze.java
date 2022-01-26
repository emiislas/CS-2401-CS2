import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    
    Location[][] grid;
    
    public Maze(char[][] charMaze) {
        // You need to write this constructor.
        
        this.grid = new Location[charMaze.length][charMaze[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(charMaze[i][j] == '.'){
                    grid[i][j] = new Location(i, j , true);
                }
                else{
                    grid[i][j] = new Location(i, j , false);
                }
            }
        }
    }
    
    // YOU DO NOT NEED TO MODIFY THIS METHOD, and you do not need to use it.
    // It is just here to allow me to write helpful tests for your code.
    public Location[][] getGrid() {
        return grid;
    }
    
    public LinkedList<Location> shortestPath(int startRow, int startCol, int endRow, int endCol) {
        // You need to write this method.
        Queue<Location> myQueue = new LinkedList<Location>();
        Location start = grid[startRow][startCol];
        start.markAsVisited();
        myQueue.add(start);
        while(!myQueue.isEmpty()){
            Location tempTrash = myQueue.remove();
            if(tempTrash.getRow() == endRow && tempTrash.getCol() == endCol){
                return backtracePath(tempTrash);
            }
            
            LinkedList<Location> unvisitedList = getUnvisitedOpenNeighbors(tempTrash);
                
                for(int i = 0; i < unvisitedList.size(); i++){
                    Location neighbors = unvisitedList.get(i);
                    neighbors.markAsVisited();
                    neighbors.setPreviousLocation(tempTrash);
                    myQueue.add(neighbors);
                }
        }

        return new LinkedList<Location>();
    }
    
    public LinkedList<Location> getUnvisitedOpenNeighbors(Location current) {
        // You need to write this method.
        LinkedList<Location> guon = new LinkedList<Location>();
        
        if (current.getRow() > 0){
            Location upNeighbor = grid[current.getRow()-1][current.getCol()];
            if(!upNeighbor.isVisited() && upNeighbor.isOpen()){
                guon.add(upNeighbor);
            }
        }
        if (current.getCol() > 0){
            Location leftNeighbor = grid[current.getRow()][current.getCol()-1];
            if(!leftNeighbor.isVisited() && leftNeighbor.isOpen()){
                guon.add(leftNeighbor);
            }
        }
        if (current.getRow() < grid.length-1){
            Location belowNeighbor = grid[current.getRow()+1][current.getCol()];
            if(!belowNeighbor.isVisited() && belowNeighbor.isOpen()){
                guon.add(belowNeighbor);
            }
        }
        if (current.getCol() < grid[0].length-1){
            Location rightNeighbor = grid[current.getRow()][current.getCol()+1];
            if(!rightNeighbor.isVisited() && rightNeighbor.isOpen()){
                guon.add(rightNeighbor);
            }
        }

        return guon;
    }
    
    public static LinkedList<Location> backtracePath(Location goal) {
        // You need to write this method.
        LinkedList<Location> bp = new LinkedList<Location>();
        Location temp = goal;
        while(temp.getPreviousLocation() != null){
            bp.add(0, temp);
            temp = temp.getPreviousLocation();
        }
        bp.add(0, temp);
        
        return bp;
    }
    
}