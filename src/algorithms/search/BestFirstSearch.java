package algorithms.search;

import java.util.*;

public class BestFirstSearch extends ASearchingAlgorithm {

    public Solution solve(ISearchable s) {
        if(s.getStartState()==null||s.getGoalState()==null){
            return null;
        }
        AState start = s.getStartState();
        start.setCost(0);
        boolean visited[] = new boolean[1000000000];
        visited[start.hashCode()]=true;
        PriorityQueue<AState> queue= new PriorityQueue<>();
        queue.add(start);
        //ArrayList<AState> visited = new ArrayList<>();
        //visited.add(start);
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
                //if (!visited.contains(n)&&!queue.contains(n)) {
                if(!visited[n.hashCode()]&&!queue.contains(n)){
                    n.setCameFrom(temp);
                    //visited.add(n);
                    visited[n.hashCode()] = true;
                    queue.add(n);
                }
                else if (n.getCost()- temp.getCost()<n.getCost()){
                    /*if(!queue.contains(n)) {
                        queue.add(n);
                    }*/
                    n.setCameFrom(temp.getCameFrom());
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
