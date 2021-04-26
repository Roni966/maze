package test;
import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.AMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class RunCompressDecompressMaze {
    public static void main(String[] args) {
        BigInteger b= BigInteger.valueOf(1000);
        System.out.println(b.toByteArray());

        /*
        String str = "byte array size example";
        byte array[] = str.getBytes();
        for(int i=0;i<23;i++){
        System.out.println("Size of byte Array : "+array[i]);

            }
            /*
         */
        /*
        String mazeFileName = "savedMaze.maze";
        AMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(100, 100); //Generate new maze
        try {
// save maze to a file
            OutputStream out = new MyCompressorOutputStream(new
                    FileOutputStream(mazeFileName));
            //out.write(maze.toByteArray());
            byte[] b= new byte[] {(byte)0x00,(byte)0x01,(byte)0x01};
            out.write(b);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte savedMazeBytes[] = new byte[0];*/
       /* try {
//read maze from file
            InputStream in = new MyDecompressorInputStream(new
                    FileInputStream(mazeFileName));
            savedMazeBytes = new byte[maze.toByteArray().length];
            in.read(savedMazeBytes);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Maze loadedMaze = new Maze(savedMazeBytes);
        boolean areMazesEquals =
                Arrays.equals(loadedMaze.toByteArray(),maze.toByteArray());
        System.out.println(String.format("Mazes equal: %s",areMazesEquals));
//maze should be equal to loadedMaze
    }
}*/}}