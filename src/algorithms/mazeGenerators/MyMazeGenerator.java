package algorithms.mazeGenerators;

public class MyMazeGenerator extends AMazeGenerator {

    @Override
    public Maze generate(int rows, int cols) {
        Maze newMaze = new Maze(rows, cols);
        int[][] newArray = new int[rows][cols];
        int i, j;
        for (i = 0; i < rows; i++) {
            for (j = 0; j < cols; j++) {
                newArray[i][j] = 1;
            }
        }
        newMaze.setArray(newArray);
        Position startPosition = newMaze.getStartPosition();
        return newMaze;
    }
}