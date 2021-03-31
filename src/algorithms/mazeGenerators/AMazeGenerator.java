package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator{

    @Override
    public long measureAlgorithmTimeMillis(int rows, int cols) {
        long start_time = System.currentTimeMillis();
        generate(rows, cols);
        long end_time = System.currentTimeMillis();
        return (end_time - start_time);
    }
}
