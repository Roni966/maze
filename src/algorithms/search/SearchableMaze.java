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

        if (m.getRow() < maze.getRows()) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol());
            allStates.add(ms);

        }
        if (m.getCol() < maze.getCols()) {
            MazeState ms = new MazeState(m.getRow(),m.getCol()+1);
            allStates.add(ms);
        }
        if (m.getRow() > 0) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol());
            allStates.add(ms);

        }
        if (m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow(),m.getCol()-1);
            allStates.add(ms);

        }
        if (m.getRow() > 0 && m.getCol() < maze.getCols()) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol()+1);
            allStates.add(ms);

        }
        if (m.getRow() < maze.getRows() && m.getCol() < maze.getCols()) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol()+1);
            allStates.add(ms);

        }
        if (m.getRow() < maze.getRows() && m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol()-1);
            allStates.add(ms);
        }
        if (m.getRow() > 0 && m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol()-1);
            allStates.add(ms);

        }

        return allStates;
    }
}
