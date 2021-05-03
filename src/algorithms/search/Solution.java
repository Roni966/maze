package algorithms.search;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Solution extends AState implements Serializable {

    private AState state;
    private ArrayList<AState> x;
    private int y=1;

    Solution(AState state) {
        this.state = state;
        this.x = new ArrayList<>();
        AState temp = this.state;
        while (temp.getCameFrom() != null) {
            x.add(temp);
            y++;
            temp = temp.getCameFrom();
        }
        x.add(temp);
    }

    public AState getState() {
        return state;
    }

    public ArrayList<AState> getSolutionPath() {
        AState temp = this.state;
        ArrayList<AState> lst = new ArrayList<>();
        while (temp.getCameFrom() != null) {
            lst.add(temp);
            temp = temp.getCameFrom();
        }
        lst.add(temp);
        Collections.reverse(lst);
        return x;
    }

    @Override
    public String toString() {
        return "" + y;
    }
}
