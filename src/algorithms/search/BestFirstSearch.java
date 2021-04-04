package algorithms.search;
import algorithms.mazeGenerators.Position;

import java.io.*;
import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {

    public Solution solve(ISearchable s) {
        AState start = s.getStartState();
        start.setCost(0);
        PriorityQueue<AState> queue= new PriorityQueue<>();
        queue.add(start);
        ArrayList<AState> visited = new ArrayList<>();
        visited.add(start);
        AState prev = null;
        while (queue.size() != 0) {
            AState temp = queue.poll();
            if (temp.equals(s.getGoalState())){
                //temp.setCameFrom(prev);
                Solution sol=new Solution(temp);
                return  sol;
            }
            Iterator<AState> i = s.getAllSuccessors(temp).listIterator();
            numNodes++;
            while (i.hasNext()) {
                AState n = i.next();
                //if (n.getCameFrom() == null) {
                // n.setCameFrom(temp);
                // }
                if (!visited.contains(n)) {
                    n.setCameFrom(temp);
                    prev = temp;
                    visited.add(n);
                    queue.add(n);
                }
                else if (n.getCost()- temp.getCost()<n.getCost()){
                    if(!queue.contains(n)) {
                        queue.add(n);
                    }
                    n.setCameFrom(temp.getCameFrom());
                }
            }
            // prev = temp;
        }
        return null;
    }

    @Override
    public int getNumberOfNodesEvaluated() {
        return numNodes;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
