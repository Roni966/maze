package algorithms.search;

public abstract class AState implements Comparable<AState> {

    private String name;
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
        }
        return 0;
    }

    public boolean equals(Object o) {
        if(((AState) o).getName()==this.getName()){
            return true;
        }
        return false;
    }

    public void setCameFrom(AState s) {
        this.cameFrom = s;
    }

    public AState getCameFrom() {
        return this.cameFrom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(name);
    }
}
