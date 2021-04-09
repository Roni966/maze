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
    public Maze(int[][] map,int rows, int cols){
        this.array = map;
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
        if(startPosition==null)
        {
            return null;
        }
        return startPosition;
    }


    public void setStartPosition(Position p){
        if(this.array[p.getRowIndex()][p.getColumnIndex()]!=0) {
            startPosition = null;
        }
            else {
        startPosition = p;
    }
    }

    public Position getGoalPosition() {
        if(endPotision==null)
        {
            return null;
        }
        return endPotision;
    }

    public void setGoalPosition(Position p){
        if(this.array[p.getRowIndex()][p.getColumnIndex()]!=0)
            startPosition=null;
        else{
            endPotision = p;}
    }

    public void print(){
        for (int i=0; i<rows; i++){
            System.out.print("{");
            for (int j=0; j<cols; j++){
                if (i == getStartPosition().getRowIndex() && j == getStartPosition().getColumnIndex()) {
                    System.out.print(" S");
                }
                else if (i == getGoalPosition().getRowIndex() && j == getGoalPosition().getColumnIndex()) {
                    System.out.print(" E");
                }
                else {
                    System.out.print(" " + array[i][j]);
                }
            }
            System.out.println(" }");
        }
    }
}
