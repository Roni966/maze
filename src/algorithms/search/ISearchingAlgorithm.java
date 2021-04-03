package algorithms.search;

public interface ISearchingAlgorithm {

    AState search(ISearchable s);
    int getNumberOfVisitedNodes();
    String getName();

}
