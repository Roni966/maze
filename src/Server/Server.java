package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
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
        Configurations S=Configurations.getInstance();
        String gen= S.getPoolSize();
        this.threadPool = Executors.newFixedThreadPool(Integer.parseInt(gen));
    }

    public void runServer(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(listeningIntervalMS);

           while (!stop) {
                try {
                    Socket clientSocket = serverSocket.accept();

                    threadPool.execute(() -> {
                        handleClient(clientSocket);

                    });
                } catch (SocketTimeoutException e){
                    System.out.println("Socket timeout");
                }
            }
            serverSocket.close();
            threadPool.shutdownNow();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket clientSocket) {
        try {
            strategy.ServerStrategy(clientSocket.getInputStream(), clientSocket.getOutputStream());
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

