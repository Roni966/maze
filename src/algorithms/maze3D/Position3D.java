package algorithms.maze3D;

import algorithms.mazeGenerators.Position;

public class Position3D {

    private int depth;
    private int row;
    private int column;


    public Position3D(int depth,int row, int column) {
        this.depth=depth;
        this.row=row;
        this.column=column;

    }
    public int getRowIndex() {
        return row;
    }

    public int getColumnIndex() {
        return column;
    }

    public int getDepthIndex() {
        return depth;
    }
}
