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
        int rowsM = rows % 255;
        int rowsD = rows / 255;
        for (int i = 0; i < 4; i++) {
            if (i < rowsD) {
                byteArray[i] = (byte) 255;
            } else if (i == rowsD) {
                byteArray[i] = (byte) rowsM;
            } else {
                byteArray[i] = 0;
            }
        }
        // cols 4-7
        int colsM = cols % 255;
        int colsD = cols / 255;
        for (int i = 4; i < 8; i++) {
            int j = i - 4;
            if (j < colsD) {
                byteArray[i] = (byte) 255;
            } else if (j == colsD) {
                byteArray[i] = (byte) colsM;
            } else {
                byteArray[i] = 0;
            }
        }
        //Start Position 8-15
        int startRowM = startPosition.getRowIndex() % 255;
        int startRowD = startPosition.getRowIndex() / 255;
        int startColM = startPosition.getColumnIndex() % 255;
        int startColD = startPosition.getColumnIndex() / 255;
        for (int i = 8; i < 16; i++) {
            int j = i - 8;
            int k = i -12;
            if (i < 12) {
                if (j < startRowD) {
                    byteArray[i] = (byte) 255;
                } else if (j == startRowD) {
                    byteArray[i] = (byte) startRowM;
                } else {
                    byteArray[i] = 0;
                }
            } else {
                if (k < startColD) {
                    byteArray[i] = (byte) 255;
                } else if (k == startColD) {
                    byteArray[i] = (byte) startColM;
                } else {
                    byteArray[i] = 0;
                }
            }
        }
        //End Position 16-23
        int endRowM = endPotision.getRowIndex() % 255;
        int endRowD = endPotision.getRowIndex() / 255;
        int endColM = endPotision.getColumnIndex() % 255;
        int endColD = endPotision.getColumnIndex() / 255;
        for (int i = 16; i < 24; i++) {
            int j = i - 16;
            int k = i - 20;
            if (i < 20) {
                if (j < endRowD) {
                    byteArray[i] = (byte) 255;
                } else if (j == endRowD) {
                    byteArray[i] = (byte) endRowM;
                } else {
                    byteArray[i] = 0;
                }
            } else {
                if (k < endColD) {
                    byteArray[i] = (byte) 255;
                } else if (k == endColD) {
                    byteArray[i] = (byte) endColM;
                } else {
                    byteArray[i] = 0;
                }
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
        int y = 0;
        int startX = 0, startY = 0, endX = 0, endY = 0;
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
                x = x + (b[i] & 0xFF);
            }
            if (i > 8 && i < 16) {
                if (i < 12) {
                    x = x + (b[i] & 0xFF);
                }
                else {
                    y = y + (b[i] & 0xFF);
                }
            }
            if (i == 16) {
                startX = x;
                startY = y;
                x = 0;
                y = 0;
                x = x + (b[i] & 0xFF);
            }
            if (i > 16) {
                if (i < 20) {
                    x = x + (b[i] & 0xFF);
                }
                else {
                    y = y + (b[i] & 0xFF);
                }
            }
            if (i == 23) {
                endX = x;
                endY = y;
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
        this.setStartPosition(new Position(startX,startY));
        this.setGoalPosition(new Position(endX,endY));
    }
}
