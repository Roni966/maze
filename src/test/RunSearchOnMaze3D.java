package test;


import algorithms.search.*;
import algorithms.maze3D.*;

import java.util.ArrayList;


public class RunSearchOnMaze3D {
    public static void main(String[] args) {
        IMaze3DGenerator mg = new MyMaze3DGenerator();
        Maze3D maze = mg.generate(299, 299,299);
        SearchableMaze3D searchableMaze = new SearchableMaze3D(maze);

        solveProblem(searchableMaze, new BreadthFirstSearch());
        solveProblem(searchableMaze, new DepthFirstSearch()) ;
        solveProblem(searchableMaze, new BestFirstSearch());
    }
    private static void solveProblem(ISearchable domain, ISearchingAlgorithm searcher) {
//Solve a searching problem with a searcher
        Solution solution = searcher.solve(domain);
        System.out.println(String.format("'%s' algorithm - nodes evaluated: %s", searcher.getName(), searcher.getNumberOfNodesEvaluated()));
//Printing Solution Path
        System.out.println("Solution path:");
        ArrayList<AState> solutionPath = solution.getSolutionPath();
        for (int i = 0; i < solutionPath.size(); i++) {
            System.out.println(String.format("%s. %s",i,solutionPath.get(i)));
        }
    }
}
