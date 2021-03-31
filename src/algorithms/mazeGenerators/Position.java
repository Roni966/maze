package algorithms.mazeGenerators;

public class Position {

    private int row;
    private int col;
    private int visited;

    Position(int row, int col){
        this.row = row;
        this.col = col;
        this.visited = 0;
    }

    public int getRowIndex(){
        return row;
    }

    public int getColumnIndex() {
        return col;
    }

    public int getVisited(){
        return visited;
    }

    public void setVisited() {
        visited = 1;
    }
}
