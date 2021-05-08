package Server;

import IO.MyCompressorOutputStream;
import IO.MyDecompressorInputStream;
import algorithms.mazeGenerators.EmptyMazeGenerator;
import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.mazeGenerators.SimpleMazeGenerator;
import algorithms.search.BreadthFirstSearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

public class ServerStrategyGenerateMaze implements IServerStrategy{
    @Override
    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ByteArrayOutputStream b=new ByteArrayOutputStream();
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
         //   MyDecompressorInputStream fromClient = new MyDecompressorInputStream(inFromClient);
          // MyCompressorOutputStream toClient = new MyCompressorOutputStream(outToClient);
             MyCompressorOutputStream compress = new MyCompressorOutputStream(b);

            int[] dimensions= (int[]) fromClient.readObject();
            System.out.println(dimensions[0]);
            System.out.println(dimensions[1]);
            String gen="";
            Configurations S=Configurations.getInstance();
            gen= S.getGen();

//            try (InputStream input = new FileInputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {
//
//                Properties prop = new Properties();
//
//                // load a properties file
//                prop.load(input);
//
//                // get the property value and print it out
//                gen= prop.getProperty("mazeGeneratingAlgorithm");
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }

            if(gen.equals("0")){
                EmptyMazeGenerator MMG= new EmptyMazeGenerator();
                Maze M= MMG.generate(dimensions[0],dimensions[1]);
                byte[] ByteMaze=M.toByteArray();
                compress.write(ByteMaze);
                System.out.println("empty");
            }
            else if(gen.equals("1")) {
                SimpleMazeGenerator MMG= new SimpleMazeGenerator();
                Maze M= MMG.generate(dimensions[0],dimensions[1]);
                byte[] ByteMaze=M.toByteArray();
                compress.write(ByteMaze);
                System.out.println("Simple");

            }
            else if(gen.equals("2")) {
                MyMazeGenerator MMG= new MyMazeGenerator();
                Maze M= MMG.generate(dimensions[0],dimensions[1]);
                byte[] ByteMaze=M.toByteArray();
                compress.write(ByteMaze);
                System.out.println("MyMaze");
            }
          //  MyMazeGenerator MMG= new MyMazeGenerator();

            toClient.writeObject(b.toByteArray());
           // toClient.write(M.toByteArray());
           toClient.flush();
            fromClient.close();
            toClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
