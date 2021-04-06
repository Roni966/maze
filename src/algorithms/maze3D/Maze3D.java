package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {

    private int map[][][];
    private int depth;
    private int rows;
    private int cols;


    private Position3D startPosition;
    private Position3D goalPosition;

    Maze3D(int depth,int rows, int cols){

        this.map = new int[depth][rows][cols];
        this.depth=depth;
        this.rows = rows;
        this.cols = cols;
    }


    public int[][][] getMap() {
        return map;
    }

    public void setMap(int[][][] array) {
        this.map = array;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
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

    public Position3D getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Position3D startPosition) {
        this.startPosition = startPosition;
    }

    public Position3D getGoalPosition() {
        return goalPosition;
    }

    public void setGoalPosition(Position3D endPosition) {
        this.goalPosition = endPosition;
    }

    public void print(){
        System.out.print("{\n");
        for (int g=0; g<rows; g++){

        for (int i=0; i<rows; i++){
            System.out.print("{");
            for (int j=0; j<cols; j++){
                if (g== getStartPosition().getDepthIndex()&& i == getStartPosition().getRowIndex() && j == getStartPosition().getColumnIndex()) {
                    System.out.print(" S");
                }
                else if (g== getGoalPosition().getDepthIndex()&& i == getGoalPosition().getRowIndex() && j == getGoalPosition().getColumnIndex()) {
                    System.out.print(" E");
                }
                else {
                    System.out.print(" " + map[g][i][j]);
                }
            }
            System.out.println(" }");
        }
            System.out.println("------------");
    }
        System.out.println("}");
    }
}
