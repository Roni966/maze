package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Maze3D {

    private int map[][][];
    private int depth;
    private int rows;
    private int cols;


    private Position3D startPosition;
    private Position3D endPotision;



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

    public Position3D getEndPotision() {
        return endPotision;
    }

    public void setEndPotision(Position3D endPotision) {
        this.endPotision = endPotision;
    }


}
