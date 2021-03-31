package algorithms.search;

public abstract class AState {

    private AState cameFrom;

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return false;
    }

    public void setCameFrom(AState s) {
        this.cameFrom = s;
    }
}
