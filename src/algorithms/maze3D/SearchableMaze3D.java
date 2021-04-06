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
        start.setName((String.valueOf(maze.getStartPosition().getDepthIndex()+500)+String.valueOf(maze.getStartPosition().getRowIndex()+500)+String.valueOf(maze.getStartPosition().getColumnIndex()+500)));
        return start;
    }

    @Override
    public AState getGoalState() {
        Maze3DState end = new Maze3DState(maze.getGoalPosition());
        end.setName((String.valueOf(maze.getStartPosition().getDepthIndex()+500)+String.valueOf(maze.getStartPosition().getRowIndex()+500)+String.valueOf(maze.getStartPosition().getColumnIndex()+500)));

        return end;
    }

    @Override
    public ArrayList<AState> getAllSuccessors(AState s) {
        ArrayList<AState> allStates = new ArrayList<>();
        Maze3DState m = new Maze3DState((Maze3DState) s);
        int w,x,y=0;
        //up
        if (m.getRow() > 0) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow()-1,m.getCol());
            w=m.getDepth();
            w+=500;
            x=m.getRow()-1;
            x+=500;
            y=m.getCol();
            y+=500;
            ms.setName(String.valueOf(w)+String.valueOf(x)+String.valueOf(y));

            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }


        //right
        if (m.getCol() < maze.getCols()-1) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow(),m.getCol()+1);
            w=m.getDepth();
            w+=500;
            x=m.getRow();
            x+=500;
            y=m.getCol()+1;
            y+=500;
            ms.setName(String.valueOf(w)+String.valueOf(x)+String.valueOf(y));
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //down
        if (m.getRow() < maze.getRows()-1) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow()+1,m.getCol());
            w=m.getDepth();
            w+=500;
            x=m.getRow()+1;
            x+=500;
            y=m.getCol();
            y+=500;
            ms.setName(String.valueOf(w)+String.valueOf(x)+String.valueOf(y));
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        //left
        if (m.getCol() > 0) {
            Maze3DState ms = new Maze3DState(m.getDepth(),m.getRow(),m.getCol()-1);
            w=m.getDepth();
            w+=500;
            x=m.getRow();
            x+=500;
            y=m.getCol()-1;
            y+=500;
            ms.setName(String.valueOf(w)+String.valueOf(x)+String.valueOf(y));
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        // depth down
        if (m.getDepth() > 0) {
            Maze3DState ms = new Maze3DState(m.getDepth()-1,m.getRow(),m.getCol());
            w=m.getDepth()-1;
            w+=500;
            x=m.getRow();
            x+=500;
            y=m.getCol();
            y+=500;
            ms.setName(String.valueOf(w)+String.valueOf(x)+String.valueOf(y));
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }
        // depth up
        if (m.getDepth() < maze.getDepth()-1) {
            Maze3DState ms = new Maze3DState(m.getDepth()+1,m.getRow(),m.getCol());
            w=m.getDepth()+1;
            w+=500;
            x=m.getRow();
            x+=500;
            y=m.getCol();
            y+=500;
            ms.setName(String.valueOf(w)+String.valueOf(x)+String.valueOf(y));
            if (maze.getMap()[ms.getDepth()][ms.getRow()][ms.getCol()] == 0) {
                ms.setCost(s.getCost()+10);
                allStates.add(ms);
            }
        }

        return allStates;
    }
}
