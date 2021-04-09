package algorithms.maze3D;

import algorithms.search.AState;

public class Maze3DState extends AState {

    Position3D p;
    private boolean visited;

    Maze3DState(Position3D p) {
        this.p = p;
    }

    Maze3DState(int depth, int row,int col) {
        this.p = new Position3D(depth,row,col);
    }

    Maze3DState(Maze3DState s) {
        this.p = (s.p);
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getDepth(){
        return  p.getDepthIndex();
    }

    public int getRow(){
        return p.getRowIndex();
    }

    public int getCol(){
        return  p.getColumnIndex();
    }

    public boolean equals(Object s) {
        Maze3DState state = (Maze3DState) s;
        if (this.getDepth()== state.getDepth()&& this.getRow() == state.getRow() && this.getCol() == state.getCol()) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" +p.getDepthIndex() + "," + p.getRowIndex() + "," + p.getColumnIndex() + "}";
    }
}
