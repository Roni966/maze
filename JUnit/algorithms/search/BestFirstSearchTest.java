package algorithms.search;

import algorithms.mazeGenerators.IMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {

    @Test
    void solve() {
        IMazeGenerator mg = new MyMazeGenerator();
        Maze maze = mg.generate(30, 30);
        SearchableMaze searchableMaze = new SearchableMaze(maze);
        BestFirstSearch best = new BestFirstSearch();
        Solution solution = best.solve(null);
        //assertEquals(solution.getState().,maze.setGoalPosition(););
    }

    @Test
    void getNumberOfNodesEvaluated() {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals(0,best.getNumberOfNodesEvaluated());
    }

    @Test
     void getName()  {
        BestFirstSearch best = new BestFirstSearch();
        assertEquals("BestFirstSearch",best.getName());
    }
}