package Server;

import IO.MyCompressorOutputStream;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;

import java.io.*;

public class ServerStrategyGenerateMaze implements IServerStrategy{

    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ByteArrayOutputStream b=new ByteArrayOutputStream();
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            MyCompressorOutputStream compress = new MyCompressorOutputStream(b);
            int[] dimensions= (int[]) fromClient.readObject();
            System.out.println(dimensions[0]);
            System.out.println(dimensions[1]);
            Configurations S=Configurations.getInstance();
            String gen= S.getGen();
            if (gen.equals("0")){
                EmptyMazeGenerator MMG= new EmptyMazeGenerator();
                Maze M= MMG.generate(dimensions[0],dimensions[1]);
                byte[] ByteMaze=M.toByteArray();
                compress.write(ByteMaze);
            }
            else if (gen.equals("1")) {
                SimpleMazeGenerator MMG= new SimpleMazeGenerator();
                Maze M= MMG.generate(dimensions[0],dimensions[1]);
                byte[] ByteMaze=M.toByteArray();
                compress.write(ByteMaze);

            }
            else if (gen.equals("2")) {
                MyMazeGenerator MMG= new MyMazeGenerator();
                Maze M= MMG.generate(dimensions[0],dimensions[1]);
                byte[] ByteMaze=M.toByteArray();
                compress.write(ByteMaze);
            }
            toClient.writeObject(b.toByteArray());
            toClient.flush();
            fromClient.close();
            toClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
