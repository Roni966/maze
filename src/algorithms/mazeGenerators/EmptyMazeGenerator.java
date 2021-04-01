package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int rows, int cols) {
        Maze new_maze = new Maze(rows, cols);
        int[][] new_array = new int[rows][cols];
        int i,j;
        for(i=0; i<rows; i++){
            for(j=0; j<cols; j++){
                new_array[i][j] = 0;
            }
        }
        new_maze.setStartPosition(new Position(0,0));
        new_maze.setGoalPosition(new Position(rows-1,cols-1));
        new_maze.setArray(new_array);
        return new_maze;
    }
}