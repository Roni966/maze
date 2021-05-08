package Server;

import java.io.*;
import java.util.Properties;
public class Configurations {

    private Properties prop;
  // private OutputStream output;
    private static Configurations instance = null;

    public String getGen(){
        String gen="";
        try (InputStream input = new FileInputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
           gen= prop.getProperty("mazeGeneratingAlgorithm");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    return gen;
    }
    public String getSearch(){
        String Search="";
        try (InputStream input = new FileInputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            Search= prop.getProperty("mazeSearchingAlgorithm");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Search;
    }
    public String getPoolSize(){
        String Size="";
        try (InputStream input = new FileInputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            Size= prop.getProperty("threadPoolSize");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Size;
    }
    public static Configurations getInstance() {
        if (Configurations.instance == null) {
            Configurations.instance = new Configurations();
        }

        return Configurations.instance;
    }
    public Configurations() {
        try (OutputStream output = new FileOutputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {

            //Properties prop = new Properties();

            // set the properties value
            prop = new Properties();
            prop.setProperty("threadPoolSize", "3");
            prop.setProperty("mazeGeneratingAlgorithm", "2");
            prop.setProperty("mazeSearchingAlgorithm", "1");

            // save properties to project root folder
            prop.store(output, null);

            //System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }}
    /*
        public static void main(String[] args) {


        try (OutputStream output = new FileOutputStream("C:\\Users\\Owner\\IdeaProjects\\maze\\resources\\config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("threadPoolSize", "0");
            prop.setProperty("mazeGeneratingAlgorithm", "0");
            prop.setProperty("mazeSearchingAlgorithm", "0");

            // save properties to project root folder
            prop.store(output, null);

            //System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}

*/