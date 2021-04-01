package algorithms.search;

import algorithms.mazeGenerators.Maze;

import java.util.ArrayList;

public class SearchableMaze implements ISearchable {

    Maze maze;

    SearchableMaze(Maze maze) {
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
        MazeState m = new MazeState(s);
//        if (m.getRow() < maze.getRows()) {
//            allStates.add(maze.getArray()[m.getRow()+1][m.getCol()]);
//        }
//        if (m.getCol() < maze.getCols()) {
//            allStates.add(maze.getArray()[m.getRow()][m.getCol()+1]);
//        }
//        if (m.getRow() > 0) {
//            allStates.add(maze.getArray()[m.getRow()-1][m.getCol()]);
//        }
//        if (m.getCol() > 0) {
//            allStates.add(maze.getArray()[m.getRow()][m.getCol()-1]);
//        }
//        if (m.getRow() > 0 && m.getCol() < maze.getCols()) {
//            allStates.add(maze.getArray()[m.getRow()-1][m.getCol()+1]);
//        }
//        if (m.getRow() < maze.getRows() && m.getCol() < maze.getCols()) {
//            allStates.add(maze.getArray()[m.getRow()+1][m.getCol()+1]);
//        }
//        if (m.getRow() < maze.getRows() && m.getCol() > 0) {
//            allStates.add(maze.getArray()[m.getRow()+1][m.getCol()-1]);
//        }
//        if (m.getRow() > 0 && m.getCol() > 0) {
//            allStates.add(maze.getArray()[m.getRow()-1][m.getCol()-1]);
//        }
        return allStates;
    }
}
