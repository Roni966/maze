package algorithms.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch implements ISearchingAlgorithm {

    @Override
    public AState search(ISearchable s) {
        AState start = s.getStartState();
        LinkedList<AState> queue = new LinkedList<AState>();
        queue.add(start);
        ArrayList<AState> visited = new ArrayList<AState>();
        visited.add(start);
        while (queue.size() != 0) {
            AState temp = queue.poll();
            if (temp.equals(s.getGoalState())){
                return s.getGoalState();
            }
            Iterator<AState> i = s.getAllSuccessors(temp).listIterator();
            while (i.hasNext()) {
                AState n = i.next();
                n.setCameFrom(temp);
                if (!visited.contains(n)) {
                    visited.add(n);
                    queue.add(n);
                }
            }
        }
        return null;
    }

    @Override
    public int getNumberOfVisitedNodes() {
        return 0;
    }
}
