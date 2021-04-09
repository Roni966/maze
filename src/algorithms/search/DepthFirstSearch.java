package algorithms.search;

import java.util.Iterator;

public class DepthFirstSearch extends ASearchingAlgorithm {

    Solution last;

    @Override
    public Solution solve(ISearchable s) {
        if(s.getStartState()==null||s.getGoalState()==null){
            return null;
        }
        AState start = s.getStartState();
        boolean visited[] = new boolean[1000000000];

        start.setCost(1);
        return DFS(s, start, visited, null);
    }

   private Solution DFS(ISearchable s, AState state, boolean[] arr, AState prev) {

        arr[state.hashCode()]=true;
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
            if(!arr[n.hashCode()]){
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
