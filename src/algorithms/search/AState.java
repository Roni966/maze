package algorithms.search;

public abstract class AState implements Comparable<AState> {


    private AState cameFrom;
    private int cost;


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    public int compareTo(AState o) {

        if (this.getCost()>=o.getCost()){
            return 1;
        }return 0;

    }

    public boolean equals(Object o) {
        return false;
    }


    public void setCameFrom(AState s) {
        this.cameFrom = s;
    }

    public AState getCameFrom() {
        return this.cameFrom;
    }



    @Override
    public String toString() {
        return null;
    }
}
