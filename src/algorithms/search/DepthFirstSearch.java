package algorithms.search;

import java.util.ArrayList;
import java.util.Iterator;

public class DepthFirstSearch implements ISearchingAlgorithm{

    private int numNodes = 0;

    @Override
    public AState search(ISearchable s) {
        ArrayList<AState> visited = new ArrayList<>();
        AState start = s.getStartState();
        return DFS(s, start, visited);
    }

    private AState DFS(ISearchable s, AState state, ArrayList<AState> arr) {
        arr.add(state);
        if (state.equals(s.getGoalState())) {
            return s.getGoalState();
        }
        Iterator<AState> i = s.getAllSuccessors(state).listIterator();
        while (i.hasNext()) {
            AState n = i.next();
            n.setCameFrom(state);
            if (!arr.contains(n)) {
                numNodes++;
                DFS(s, n, arr);
            }
        }
        return null;
    }

    @Override
    public int getNumberOfVisitedNodes() {
        return numNodes;
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }


}
