package Server;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private int port;
    private int listeningIntervalMS;
    private IServerStrategy strategy;
    private boolean stop;
    private ExecutorService threadPool;

    public Server(int port, int listeningIntervalMS, IServerStrategy strategy) {
        this.port = port;
        this.listeningIntervalMS = listeningIntervalMS;
        this.strategy = strategy;
        String gen="";
       /* try (InputStream input = new FileInputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            gen= prop.getProperty("mazeSearchingAlgorithm");

        } catch (IOException ex) {
            ex.printStackTrace();
        }*/
        Configurations S=Configurations.getInstance();
        gen= S.getPoolSize();
        this.threadPool = Executors.newFixedThreadPool(Integer.valueOf(gen) );

       // this.threadPool = Executors.newFixedThreadPool(3);

    }

    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);
            System.out.println("Starting server at port = " + port);

           while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("Client accepted: " + clientSocket.toString());

                   // handleClient(clientSocket);
                    threadPool.execute(() -> {
                        handleClient(clientSocket);

                    });




//                    try {
//                        strategy.applyStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
//                        clientSocket.close();
//                    } catch (IOException e){
//                        e.printStackTrace();
//                    }
                } catch (SocketTimeoutException e){
                    System.out.println("Socket timeout");
                }
            }
            serverSocket.close();
            //threadPool.shutdown(); // do not allow any new tasks into the thread pool (not doing anything to the current tasks and running threads)
            threadPool.shutdownNow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
            System.out.println("Done handling client: " + clientSocket.toString());
            clientSocket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(() -> {
            runServer();
        }).start();
    }

    public void stop(){
        stop = true;
    }
}

