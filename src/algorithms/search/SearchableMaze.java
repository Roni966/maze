package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    Maze maze;

    public SearchableMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public AState getStartState() {
        MazeState start = new MazeState(maze.getStartPosition());
        return start;
    }

    @Override
    public AState getGoalState() {
        MazeState end = new MazeState(maze.getGoalPosition());
        return end;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        ArrayList<AState> allStates = new ArrayList<>();
        MazeState m = new MazeState((MazeState) s);

        //up
        if (m.getRow() > 0) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol());
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }
        //right up
        if (m.getRow() > 0 && m.getCol() < maze.getCols()-1) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol()+1);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                if ((maze.getArray()[ms.getRow()+1][ms.getCol()] == 0) || (maze.getArray()[ms.getRow()][ms.getCol()-1] == 0)) {
                    ms.setCost(s.getCost()+15);
                    allStates.add(ms);
                }
            }
        }
        //right
        if (m.getCol() < maze.getCols()-1) {
            MazeState ms = new MazeState(m.getRow(),m.getCol()+1);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //right down
        if (m.getRow() < maze.getRows()-1 && m.getCol() < maze.getCols()-1) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol()+1);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                if ((maze.getArray()[ms.getRow()-1][ms.getCol()] == 0) || (maze.getArray()[ms.getRow()][ms.getCol()-1] == 0)) {
                    ms.setCost(s.getCost()+15);
                    allStates.add(ms);
                }
            }
        }
        //down
        if (m.getRow() < maze.getRows()-1) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol());
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //left down
        if (m.getRow() < maze.getRows()-1 && m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol()-1);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                if ((maze.getArray()[ms.getRow()-1][ms.getCol()] == 0) || (maze.getArray()[ms.getRow()][ms.getCol()+1] == 0)) {
                    ms.setCost(s.getCost()+15);
                    allStates.add(ms);
                }
            }
        }
        //left
        if (m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow(),m.getCol()-1);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        // left up
        if (m.getRow() > 0 && m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol()-1);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                if ((maze.getArray()[ms.getRow()+1][ms.getCol()] == 0) || (maze.getArray()[ms.getRow()][ms.getCol()+1] == 0)) {
                    ms.setCost(s.getCost()+15);
                    allStates.add(ms);
                }
            }
        }
        return allStates;
    }
}
