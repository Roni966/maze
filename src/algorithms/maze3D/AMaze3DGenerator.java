package algorithms.maze3D;

public class AMaze3DGenerator implements IMaze3DGenerator{
    @Override
    public Maze3D generate(int depth, int row, int column) {
        return null;
    }

    @Override
    public long measureAlgorithmTimeMillis(int depth, int row, int column) {
        long start_time = System.currentTimeMillis();
        generate(depth, row, column);
        long end_time = System.currentTimeMillis();
        return (end_time - start_time);
    }

}
