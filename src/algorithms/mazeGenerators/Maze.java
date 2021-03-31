package algorithms.mazeGenerators;

public class Maze {

    private int array[][];
    private int rows;
    private int cols;
    private Position startPosition;
    private Position endPotision;

    Maze(int rows, int cols){
        this.array = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Position getStartPosition(){
        return startPosition;
    }

    public Position getEndPotision(){
        return endPotision;
    }

    public void print(){
        for (int i=0; i<rows; i++){
            System.out.print("{");
            for (int j=0; j<cols; j++){
                System.out.print(" " + array[i][j]);
            }
            System.out.println(" }");
        }
    }
}
