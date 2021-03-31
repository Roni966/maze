package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.Position;

public class MazeState extends AState{

    Position p;

    MazeState(Position p) {
        this.p = p;
    }

    MazeState(AState s) {
        this.p = ((MazeState) s).p;
    }

    public int getRow(){
        return p.getRowIndex();
    }

    public int getCol(){
        return p.getColumnIndex();
    }
}
