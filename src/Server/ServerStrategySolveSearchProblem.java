package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

public class ServerStrategySolveSearchProblem implements IServerStrategy {

    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            //String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            //Path path = Paths.get(fileName);
            //Files.write(path, strToBytes);
            String gen="";
            Configurations S=Configurations.getInstance();
            gen= S.getSearch();
//            try (InputStream input = new FileInputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {
//
//                Properties prop = new Properties();
//
//                // load a properties file
//                prop.load(input);
//
//                // get the property value and print it out
//                 gen= prop.getProperty("mazeSearchingAlgorithm");
//
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }

            Maze M = (Maze)fromClient.readObject();
            SearchableMaze searchableMaze = new SearchableMaze(M);
            Solution solution = null;
            if(gen.equals("0")){
               solution =  new BreadthFirstSearch().solve(searchableMaze);
                }
            else if(gen.equals("1")) {
                solution =  new DepthFirstSearch().solve(searchableMaze);
                System.out.println("Depth");
            }
            else if(gen.equals("2")) {
                solution =  new BestFirstSearch().solve(searchableMaze);
                System.out.println("Best");
            }
            System.out.println(String.format("Solution steps: %s", solution));

            toClient.writeObject(solution);
            toClient.flush();
            fromClient.close();
            toClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
