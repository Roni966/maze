package Server;

import algorithms.mazeGenerators.Maze;
import algorithms.search.*;

import java.io.*;

public class ServerStrategySolveSearchProblem implements IServerStrategy {

    public void ServerStrategy(InputStream inFromClient, OutputStream outToClient) {
      /*  try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            Configurations S = Configurations.getInstance();
            String gen = S.getSearch();
            Maze M = (Maze) fromClient.readObject();
            SearchableMaze searchableMaze = new SearchableMaze(M);
            Solution solution = null;
            System.setProperty("java.io.tmpdir","C:\\eyal\\advanced programming\\Mazes");
            String tempDirectoryPath = System.getProperty("java.io.tmpdir");
            int hash = M.toString().hashCode();
            String file = tempDirectoryPath + hash;
            File f = new File(file);
            if (f.exists()) {
                ObjectInputStream load = new ObjectInputStream(new FileInputStream(file));
                toClient.writeObject(load.readObject());
                toClient.flush();
                fromClient.close();
                toClient.close();
                load.close();
            } else {
                if (gen.equals("0")) {
                    solution = new BreadthFirstSearch().solve(searchableMaze);
                } else if (gen.equals("1")) {
                    solution = new DepthFirstSearch().solve(searchableMaze);
                } else if (gen.equals("2")) {
                    solution = new BestFirstSearch().solve(searchableMaze);
                }
                toClient.writeObject(solution);
                toClient.flush();
                ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(file));
                save.close();
                fromClient.close();
                toClient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try {
            ObjectInputStream fromClient = new ObjectInputStream(inFromClient);
            ObjectOutputStream toClient = new ObjectOutputStream(outToClient);
            Configurations S=Configurations.getInstance();
            String gen= S.getSearch();
            Maze M = (Maze)fromClient.readObject();
            SearchableMaze searchableMaze = new SearchableMaze(M);
            Solution solution = null;
            if (gen.equals("0")){
               solution =  new BreadthFirstSearch().solve(searchableMaze);
                }
            else if (gen.equals("1")) {
                solution =  new DepthFirstSearch().solve(searchableMaze);

            }
            else if (gen.equals("2")) {
                solution =  new BestFirstSearch().solve(searchableMaze);
            }
           // System.out.println(String.format("Solution steps: %s", solution));
            toClient.writeObject(solution);
            toClient.flush();
            fromClient.close();
            toClient.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
