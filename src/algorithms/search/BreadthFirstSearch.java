package algorithms.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    @Override
    public AState solve(ISearchable s) {
        AState start = s.getStartState();
        start.setCost(1);
        LinkedList<AState> queue = new LinkedList<>();
        queue.add(start);
        ArrayList<AState> visited = new ArrayList<>();
        visited.add(start);
        AState prev = null;
        while (queue.size() != 0) {
            AState temp = queue.poll();
            if (temp.equals(s.getGoalState())){
                //temp.setCameFrom(prev);
                return temp;
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
