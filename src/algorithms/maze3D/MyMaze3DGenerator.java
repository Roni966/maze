package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;
import algorithms.mazeGenerators.SimpleMazeGenerator;

import java.util.ArrayList;
import java.util.Random;

public class MyMaze3DGenerator extends AMaze3DGenerator {


    public Maze3D generate(int depth, int row, int column) {


        Maze3D newMaze = new Maze3D(depth,row, column);
        int[][][] newArray = new int[depth][row][column];
        boolean[][][] grid = new boolean[depth][row][column];
        ArrayList<int[]> walls = new ArrayList<>();
        Random random = new Random();
        int d,r,c;
       /* if(rows==2 && cols==2){
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

        */
        d=0;
        r = 0;
        c = 0;
        newMaze.setStartPosition(new Position3D(0,0,0));
        walls.add(new int[]{d,r, c,d ,r, c});
        while (walls.isEmpty() == false){
            int[] rand = walls.remove( random.nextInt( walls.size() ) );
            d= rand[3];
            r = rand[4];
            c = rand[5];
            if (grid[d][r][c] == false) {
                grid[rand[0]][rand[1]][rand[2]] = grid[d][r][c] = true;
                if (r >= 2 && grid[d][r-2][c] == false) // 2 up
                    walls.add( new int[]{d,r-1,c,d,r-2,c} );
                if ( c >= 2 && grid[d][r][c-2] == false ) // 2 left
                    walls.add( new int[]{d,r,c-1,d,r,c-2} );
                if ( r < row-2 && grid[d][r+2][c] == false ) // 2 down
                    walls.add( new int[]{d,r+1,c,d,r+2,c} );
                if ( c < column-2 && grid[d][r][c+2] == false ) // 2 right
                    walls.add( new int[]{d,r,c+1,d,r,c+2} );
                if ( d < depth-2 && grid[d+2][r][c] == false ) // 2 depth up
                    walls.add( new int[]{d+1,r,c,d+2,r,c} );
                if ( d >=2 && grid[d-2][r][c] == false ) // 2 depth down
                    walls.add( new int[]{d-1,r,c,d-2,r,c} );
            }
        }
        for (int g=0; g<column; g++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (grid[g][i][j] == true) {
                        newArray[g][i][j] = 0;
                    } else {
                        newArray[g][i][j] = 1;
                    }
                }
            }
        }
        if (newArray[depth-1][row-1][column-1] == 0) {
            newMaze.setGoalPosition(new Position3D(depth-1,row - 1, column - 1));
        }
        else {
            newMaze.setGoalPosition(new Position3D(depth-1,row - 2, column- 1));
        }
        newMaze.setMap(newArray);
        return newMaze;
    }
}

