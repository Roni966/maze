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
        start.setName((String.valueOf(maze.getStartPosition().getRowIndex()+1000)+String.valueOf(maze.getStartPosition().getColumnIndex()+1000)));
        return start;
    }

    @Override
    public AState getGoalState() {

        MazeState end = new MazeState(maze.getGoalPosition());
        end.setName((String.valueOf(maze.getStartPosition().getRowIndex()+1000)+String.valueOf(maze.getStartPosition().getColumnIndex()+1000)));
        return end;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        ArrayList<AState> allStates = new ArrayList<>();
        MazeState m = new MazeState((MazeState) s);
    int x,y=0;
        //up
        if (m.getRow() > 0) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol());
            x=m.getRow()-1;
            x+=1000;
            y=m.getCol();
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }
        //right up
        if (m.getRow() > 0 && m.getCol() < maze.getCols()-1) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol()+1);
            x=m.getRow()-1;
            x+=1000;
            y=m.getCol()+1;
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            //ms.setName(String.valueOf(m.getRow()-1+1000)+String.valueOf(m.getCol())+1+1000);
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
            x=m.getRow();
            x+=1000;
            y=m.getCol()+1;
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            //ms.setName(String.valueOf(m.getRow()+1000)+String.valueOf(m.getCol())+1+1000);
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //right down
        if (m.getRow() < maze.getRows()-1 && m.getCol() < maze.getCols()-1) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol()+1);
            x=m.getRow()+1;
            x+=1000;
            y=m.getCol()+1;
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            //ms.setName(String.valueOf(m.getRow()+1+1000)+String.valueOf(m.getCol()+1+1000));
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
            x=m.getRow()+1;
            x+=1000;
            y=m.getCol();
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            //ms.setName(String.valueOf(m.getRow()+1+1000)+String.valueOf(m.getCol()+1000));
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //left down
        if (m.getRow() < maze.getRows()-1 && m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow()+1,m.getCol()-1);
            x=m.getRow()+1;
            x+=1000;
            y=m.getCol()-1;
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            //ms.setName(String.valueOf(m.getRow()+1+1000)+String.valueOf(m.getCol()-1+1000));
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
            x=m.getRow();
            x+=1000;
            y=m.getCol()-1;
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            // ms.setName(String.valueOf(m.getRow()+1000)+String.valueOf(m.getCol()-1+1000));
            if (maze.getArray()[ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        // left up
        if (m.getRow() > 0 && m.getCol() > 0) {
            MazeState ms = new MazeState(m.getRow()-1,m.getCol()-1);
            x=m.getRow()-1;
            x+=1000;
            y=m.getCol()-1;
            y+=1000;
            ms.setName(String.valueOf(x)+String.valueOf(y));
            //ms.setName(String.valueOf(m.getRow()-1+1000)+String.valueOf(m.getCol()-1+1000));
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
