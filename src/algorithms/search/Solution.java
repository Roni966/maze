package algorithms.search;

import java.util.ArrayList;
import java.util.Collections;

public class Solution extends AState{

    private AState state;

    Solution(AState state) {
        this.state = state;

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
        return lst;
    }
}
