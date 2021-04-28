package algorithms.mazeGenerators;

public class Maze {

    private int array[][];
    private int rows;
    private int cols;
    private Position startPosition;
    private Position endPotision;

    Maze(int rows, int cols) {
        this.array = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public Maze(int[][] map, int rows, int cols) {
        this.array = map;
        this.rows = rows;
        this.cols = cols;
    }


    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public Position getStartPosition() {
        if (startPosition == null) {
            return null;
        }
        return startPosition;
    }


    public void setStartPosition(Position p) {
        if (this.array[p.getRowIndex()][p.getColumnIndex()] != 0) {
            startPosition = null;
        } else {
            startPosition = p;
        }
    }

    public Position getGoalPosition() {
        if (endPotision == null) {
            return null;
        }
        return endPotision;
    }

    public void setGoalPosition(Position p) {
        if (this.array[p.getRowIndex()][p.getColumnIndex()] != 0)
            startPosition = null;
        else {
            endPotision = p;
        }
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            System.out.print("{");
            for (int j = 0; j < cols; j++) {
                if (i == getStartPosition().getRowIndex() && j == getStartPosition().getColumnIndex()) {
                    System.out.print(" S");
                } else if (i == getGoalPosition().getRowIndex() && j == getGoalPosition().getColumnIndex()) {
                    System.out.print(" E");
                } else {
                    System.out.print(" " + array[i][j]);
                }
            }
            System.out.println(" }");
        }
    }

    public byte[] toByteArray() {
        byte[] byteArray = new byte[(rows * cols) + 24];
        //rows 0-3
        int a = rows % 255;
        int b = rows / 255;
        for (int i = 0; i < 4; i++) {
            if (i < b) {
                byteArray[i] = (byte) 255;
            } else if (i == b) {
                byteArray[i] = (byte) a;
            } else {
                byteArray[i] = 0;
            }
        }
        // cols 4-7
        int c = cols % 255;
        int d = cols / 255;

        for (int i = 4; i < 8; i++) {
            int j = i - 4;
            if (j < d) {
                byteArray[i] = (byte) 255;
            } else if (j == d) {
                byteArray[i] = (byte) c;
            } else {
                byteArray[i] = 0;
            }
        }
        //
        int e = startPosition.getRowIndex() % 255;
        int f = startPosition.getRowIndex() / 255;
        for (int i = 9; i < 12; i++) {
            int j = i - 4;
            if (j < d) {
                byteArray[i] = (byte) 255;
            } else if (j == d) {
                byteArray[i] = (byte) c;
            } else {
                byteArray[i] = 0;
            }
        }


        int counter = 24;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                byteArray[counter] = (byte) this.array[i][j];
                counter++;
            }
        }
        return byteArray;
    }

    public Maze(byte[] b) {
        //  Maze Parameters
        int x = 0;
        int rows = 0;
        for (int i = 0; i < 24; i++) {
            if (i < 4) {
                x = x + (b[i] & 0xFF);
            }
            if (i == 4) {
                this.rows = x;
                x = 0;
                x = x + (b[i] & 0xFF);
            }
            if (i > 4 && i < 8) {
                x = x + (b[i] & 0xFF);
            }
            if (i == 8) {
                this.cols = x;
                x = 0;

            }

        }
        int[][] a = new int[this.rows][this.cols];
        // actual Maze
        int r = -1;
        int c = 0;
        for (int i = 24; i < b.length; i++) {
            if (c % cols == 0) {
                c = 0;
                r++;
            }
            a[r][c] = b[i] & 0xFF;
            c++;

        }
        this.array = new int[this.rows][cols];
        this.array=a;
        this.setStartPosition(new Position(0,0));
        this.setGoalPosition(new Position(2,2));

    }
}
