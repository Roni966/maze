package algorithms.search;

import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    Position p;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }



    MazeState(Position p) {
//        if(p==null){
//            return null;
//        }
        this.p = p;
    }
    MazeState(int row,int col) {
        this.p = new Position(row,col);
    }

    MazeState(MazeState s) {
        this.p = (s.p);
    }

    public int getRow(){
        return p.getRowIndex();
    }

    public int getCol(){
        return p.getColumnIndex();
    }

    public boolean equals(Object s) {
        MazeState state = (MazeState) s;
       if (this.getRow() == state.getRow() && this.getCol() == state.getCol() ) {

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "{" + p.getRowIndex() + "," + p.getColumnIndex() + "}";
    }

}
