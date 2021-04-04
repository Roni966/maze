package algorithms.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    @Override
    public Solution solve(ISearchable s) {
        AState start = s.getStartState();
        start.setCost(1);
        LinkedList<AState> queue = new LinkedList<>();
        queue.add(start);
        ArrayList<AState> visited = new ArrayList<>();
        visited.add(start);
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
                if (!visited.contains(n)) {
                    n.setCameFrom(temp);
                    visited.add(n);
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
