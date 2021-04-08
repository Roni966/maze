package algorithms.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    @Override
    public Solution solve(ISearchable s) {
        if(s.getStartState()==null||s.getGoalState()==null){
            return null;
        }
        AState start = s.getStartState();
        start.setCost(1);
        LinkedList<AState> queue = new LinkedList<>();

      //  ArrayList<AState> visited = new ArrayList<>();
        //visited.add(start);
        boolean visited[] = new boolean[1000000000];
        visited[start.hashCode()]=true;
        queue.add(start);
        while (queue.size() != 0) {
            AState temp = queue.poll();
            if (temp.equals(s.getGoalState())){
                Solution sol=new Solution(temp);
                return  sol;
            }
            Iterator<AState> i = s.getAllSuccessors(temp).listIterator();
            numNodes++;
            while (i.hasNext()) {
                AState n = i.next();

                //if (!visited.contains(n)) {
                  if(!visited[n.hashCode()]){
                    n.setCameFrom(temp);
                   // visited.add(n);
                    visited[n.hashCode()] = true;
                    queue.add(n);
                }
            }
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
