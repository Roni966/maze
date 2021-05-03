package algorithms.mazeGenerators;

import java.util.ArrayList;
import java.util.Random;

public class MyMazeGenerator extends AMazeGenerator  {

    @Override
    public Maze generate(int rows, int cols) {
        Maze newMaze = new Maze(rows, cols);
        int[][] newArray = new int[rows][cols];
        boolean[][] grid = new boolean[rows][cols];
        ArrayList<int[]> walls = new ArrayList<>();
        Random random = new Random();
        int r,c;
        if(rows==2 && cols==2){
            SimpleMazeGenerator maz = new SimpleMazeGenerator();
           return maz.generate(rows, cols);

        }
        else if ((rows%2 != 0 && cols%2 != 0) || (rows%2 == 0 && cols%2 != 0)) {
            r = 0;
            c = 0;
            newMaze.setStartPosition(new Position(0, 0));
            walls.add(new int[]{r, c, r, c});
        }
        else {
            r = 0;
            c = 1;
            newMaze.setStartPosition(new Position(0, 1));
            walls.add(new int[]{r, c, r, c});
        }
        while (walls.isEmpty() == false){
            int[] rand = walls.remove( random.nextInt( walls.size() ) );
            r = rand[2];
            c = rand[3];
            if (grid[r][c] == false) {
                grid[rand[0]][rand[1]] = grid[r][c] = true;
                if (r >= 2 && grid[r-2][c] == false) // 2 up
                    walls.add( new int[]{r-1,c,r-2,c} );
                if ( c >= 2 && grid[r][c-2] == false ) // 2 left
                    walls.add( new int[]{r,c-1,r,c-2} );
                if ( r < rows-2 && grid[r+2][c] == false ) // 2 down
                    walls.add( new int[]{r+1,c,r+2,c} );
                if ( c < cols-2 && grid[r][c+2] == false ) // 2 right
                    walls.add( new int[]{r,c+1,r,c+2} );
            }
        }
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                if (grid[i][j] == true) {
                    newArray[i][j] = 0;
                }
                else {
                    newArray[i][j] = 1;
                }
            }
        }
        if (newArray[rows-1][cols-1] == 0) {
            newMaze.setGoalPosition(new Position(rows - 1, cols - 1));
        }
        else {
            newMaze.setGoalPosition(new Position(rows - 2, cols - 1));
        }
        newMaze.setArray(newArray);
        return newMaze;
    }
}