package algorithms.search;

public interface ISearchingAlgorithm {

    AState solve(ISearchable s);
    int getNumberOfNodesEvaluated();
    String getName();

}
