package algorithms.search;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void solve() {

        IMazeGenerator mg = new MyMazeGenerator();
        //Maze maze = mg.generate(30, 30);
        int[][] map = {{0,1,1},{1,1,1},{1,1,0}};
        Maze M=new Maze(map,3,3);
        M.setStartPosition(new Position(0,0));
        M.setGoalPosition(new Position(2,2));
        SearchableMaze searchableMaze = new SearchableMaze(M);
        BestFirstSearch best = new BestFirstSearch();
        Solution solution = best.solve(searchableMaze);
        assertEquals(null,solution);
      //test2
        int[][] map2 = {{1,1,1},{1,1,1},{1,1,1}};
        Maze M2=new Maze(map2,3,3);
        M2.setStartPosition(new Position(0,0));
        M2.setGoalPosition(new Position(2,2));
        SearchableMaze searchableMaze2 = new SearchableMaze(M2);
        BestFirstSearch best2 = new BestFirstSearch();
        Solution solution2 = best2.solve(searchableMaze2);
        assertEquals(null,solution2);

//        test3
        int[][] map3 = {{1,1,1},{1,1,1},{1,1,1}};
        Maze M3=new Maze(map3,3,3);

        SearchableMaze searchableMaze3 = new SearchableMaze(M3);
        BestFirstSearch best3 = new BestFirstSearch();
        Solution solution3 = best3.solve(searchableMaze3);
        assertEquals(null,solution3);
       // test4
        int[][] map4 = {{1,-1,-1},{-1,-1,-1},{-1,-1,0}};
        Maze M4=new Maze(map4,3,3);
        M4.setStartPosition(new Position(0,0));
        M4.setGoalPosition(new Position(2,2));
        SearchableMaze searchableMaze4 = new SearchableMaze(M4);
        BestFirstSearch best4 = new BestFirstSearch();
        Solution solution4 = best4.solve(searchableMaze4);
        assertEquals(null,solution4);
// test5
        IMazeGenerator mg5 = new MyMazeGenerator();
        Maze maze5 = mg5.generate(3, 3);
        maze5.setStartPosition(new Position(0,0));
        maze5.setGoalPosition(new Position(2,2));
        SearchableMaze searchableMaze5 = new SearchableMaze(maze5);
        BestFirstSearch best5 = new BestFirstSearch();
        Solution solution5 = best5.solve(searchableMaze5);
        MazeState MS5= new MazeState(maze5.getGoalPosition());
        assertEquals(MS5,solution5.getState());


    }

    @Test
    void getNumberOfNodesEvaluated() {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals(0,best.getNumberOfNodesEvaluated());
        int[][] map = {{0,1,0},{0,1,0},{0,0,0}};
        Maze M=new Maze(map,3,3);


        M.setStartPosition(new Position(0,0));
        M.setGoalPosition(new Position(2,2));
        SearchableMaze searchableMaze = new SearchableMaze(M);
        BestFirstSearch best2 = new BestFirstSearch();
        Solution solution = best2.solve(searchableMaze);
        assertEquals(4,best2.getNumberOfNodesEvaluated());

        //test 2
        int[][] map2 = {{1,1,1},{1,1,1},{1,1,1}};
        Maze M2=new Maze(map2,3,3);
        M2.setStartPosition(new Position(0,0));
        M2.setGoalPosition(new Position(2,2));
        SearchableMaze searchableMaze2 = new SearchableMaze(M2);
        BestFirstSearch best3 = new BestFirstSearch();
        Solution solution2 = best3.solve(searchableMaze2);
        assertEquals(0,best3.getNumberOfNodesEvaluated());
    }

    @Test
     void getName()  {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals("BestFirstSearch",best.getName());
    }
}