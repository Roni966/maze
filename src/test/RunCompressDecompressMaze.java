package test;
import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.*;

import java.io.*;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class RunCompressDecompressMaze {
    public static void main(String[] args) {

        //IMazeGenerator mazeGenerator= new SimpleMazeGenerator();
        //int x=0;

        //Maze maze = mazeGenerator.generate(3/*rows*/, 3/*columns*/);
        /*
        byte[] b= maze.toByteArray();
        for(int i=0; i<b.length;i++){
            System.out.println(b[i]);
            x=x+(b[i]&0xFF);
    }
        Maze M=new Maze(b);
        M.print();
        System.out.println(x);
*/

        //String mazeFileName = "savedMaze.maze";
        String mazeFileName = "savedMaze.txt";

        AMazeGenerator mazeGenerator = new MyMazeGenerator();
        Maze maze = mazeGenerator.generate(3, 3); //Generate new maze
        try {
// save maze to a file
            OutputStream out = new MyCompressorOutputStream(new
                    FileOutputStream(mazeFileName));
            out.write(maze.toByteArray());
          //  byte[] b= new byte[] {(byte)0x00,(byte)0x01,(byte)0x01};
           // out.write();
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte savedMazeBytes[] = new byte[0];
       try {
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
}