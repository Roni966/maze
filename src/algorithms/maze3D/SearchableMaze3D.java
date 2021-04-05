package algorithms.maze3D;

import algorithms.mazeGenerators.Maze;
import algorithms.search.AState;
import algorithms.search.ISearchable;
import algorithms.search.MazeState;

import java.util.ArrayList;

public class SearchableMaze3D implements ISearchable {

    Maze3D maze;

    public SearchableMaze3D(Maze3D maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        Maze3DState start = new Maze3DState(maze.getStartPosition());
        return start;
    }

    @Override
    public AState getGoalState() {
        Maze3DState end = new Maze3DState(maze.getGoalPosition());
        return end;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        ArrayList<AState> allStates = new ArrayList<>();
        Maze3DState m = new Maze3DState((Maze3DState) s);

        //up
        if (m.getRow() > 0) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow()-1,m.getCol());
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }


        //right
        if (m.getCol() < maze.getCols()-1) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow(),m.getCol()+1);
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //down
        if (m.getRow() < maze.getRows()-1) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow()+1,m.getCol());
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //left
        if (m.getCol() > 0) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow(),m.getCol()-1);
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        // depth down
        if (m.getDepth() > 0) {
            Maze3DState ms = new Maze3DState(m.getDepth()-1,m.getRow(),m.getCol());
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }
        // depth up
        if (m.getDepth() < maze.getDepth()-1) {
            Maze3DState ms = new Maze3DState(m.getDepth()+1,m.getRow(),m.getCol());
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        return allStates;
    }
}
