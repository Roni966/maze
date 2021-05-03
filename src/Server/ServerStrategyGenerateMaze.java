package Server;

import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;

import java.io.*;
import java.util.ArrayList;

public class ServerStrategyGenerateMaze implements IServerStrategy{
    @Override
    public void applyStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            //ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
         //   MyDecompressorInputStream fromClient = new MyDecompressorInputStream(inFromClient);
           MyCompressorOutputStream toClient = new MyCompressorOutputStream(outToClient);

            int[] dimensions= (int[]) fromClient.readObject();
            System.out.println(dimensions[0]);
            System.out.println(dimensions[1]);
            MyMazeGenerator MMG= new MyMazeGenerator();
            Maze M= MMG.generate(dimensions[0],dimensions[1]);
            toClient.write(M.toByteArray());
           toClient.flush();
            fromClient.close();
            toClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
