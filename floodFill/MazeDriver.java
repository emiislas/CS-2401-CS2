import java.util.LinkedList;

public class MazeDriver {
    
    public static void main(String[] args) throws InterruptedException {
        
        char[][] charMaze = {
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','X','.'},
            {'.','.','.','X','X','X','X','X','X','.'},
            {'.','.','.','X','.','X','.','X','X','.'},
            {'.','.','.','X','.','X','.','.','X','.'},
            {'.','.','X','X','.','X','X','.','X','.'},
            {'.','.','X','X','.','.','.','.','X','.'},
            {'.','.','X','X','.','X','.','.','X','.'},
            {'.','.','.','X','X','X','X','.','X','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
        };
        
    /*    Maze maze = new Maze(charMaze);
        LinkedList<Location> path = maze.shortestPath(1, 6, 3, 4);
        System.out.println(path);
        
        animatePath(charMaze, path);*/
        
        // Here are some more maze options for you to try it out on.
        // Feel free to modify these and create different ones, as well.
        char[][] emptyCharMaze = {
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
        };
     /*   Maze maze = new Maze(emptyCharMaze);
        LinkedList<Location> path = maze.shortestPath(1, 6, 8, 8);
        System.out.println(path);
        
        animatePath(emptyCharMaze, path);*/
        
        
        char[][] charMaze2 = {
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'X','X','X','X','X','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','X','X','X','X','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','X','X','X','X','X','X','.'},
            {'.','.','.','.','.','X','.','.','.','.'},
            {'.','.','.','.','.','.','.','.','.','.'},
            {'.','.','.','X','.','.','.','.','.','.'},
        };
        Maze maze = new Maze(charMaze2);
        LinkedList<Location> path = maze.shortestPath(1, 6, 7, 4);
        System.out.println(path);
        
        animatePath(charMaze2, path);
    }
    
    
    // YOU DO NOT NEED TO MODIFY THIS METHOD.
    private static void animatePath(char[][] maze, LinkedList<Location> path) throws InterruptedException {
        for (int i = 0; i < path.size(); i++) {
            Location l = path.get(i);
            char oldChar = maze[l.getRow()][l.getCol()];
            maze[l.getRow()][l.getCol()] = 'O';
            
            printCharArray(maze);
            maze[l.getRow()][l.getCol()] = oldChar;
            Thread.sleep(500);
        }
    }
    
    // YOU DO NOT NEED TO MODIFY THIS METHOD.
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