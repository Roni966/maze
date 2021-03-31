package algorithms.mazeGenerators;

import java.util.Random;

public class SimpleMazeGenerator extends AMazeGenerator{

    @Override
    public Maze generate(int rows, int cols) {
        int a = 0;
        int b = 1;
        int randomOfTwo;
        Maze new_maze = new Maze(rows, cols);
        int[][] new_array = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(j == 0){
                    new_array[i][j] = 0;
                }
                else{
                    randomOfTwo = new Random().nextBoolean() ? a : b;
                    new_array[i][j] = randomOfTwo;
                }
                if(i == rows-1){
                    new_array[i][j] = 0;
                }
            }
        }
        new_maze.setArray(new_array);
        return new_maze;
    }
}
