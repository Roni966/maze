package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public abstract class AState {

    private AState cameFrom;

    public boolean equals(Object o) {
        return false;
    }

    public void setCameFrom(AState s) {
        this.cameFrom = s;
    }

    public AState getCameFrom() {
        return this.cameFrom;
    }

    public ArrayList<AState> getSolutionPath() {
        AState temp = this;
        ArrayList<AState> lst = new ArrayList<>();
        while (temp.getCameFrom() != null) {
            lst.add(temp);
            temp = temp.getCameFrom();
        }
        lst.add(temp);
        Collections.reverse(lst);
        return lst;
    }

    @Override
    public String toString() {
        return null;
    }
}
