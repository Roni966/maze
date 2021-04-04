package algorithms.search;

import java.util.ArrayList;
import java.util.Iterator;

public class DepthFirstSearch extends ASearchingAlgorithm {

    Solution last;

    @Override
    public Solution solve(ISearchable s) {
        ArrayList<AState> visited = new ArrayList<>();
        AState start = s.getStartState();
        start.setCost(1);
        return DFS(s, start, visited, null);
    }

    private Solution DFS(ISearchable s, AState state, ArrayList<AState> arr, AState prev) {
        arr.add(state);
        if (state.equals(s.getGoalState())) {
            state.setCameFrom(prev);
             last=new Solution(state);

        }
        Iterator<AState> i = s.getAllSuccessors(state).listIterator();
        numNodes++;
        while (i.hasNext()) {
            AState n = i.next();
            if (n.getCameFrom() == null) {
                n.setCameFrom(state);
            }
            if (!arr.contains(n)) {
                DFS(s, n, arr, state);
            }
        }

        return last;
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
