import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


// Generate the random workload of read and write on a database 

public class generateWorkloads {

    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("testWorkload.txt");
            int i; 
            while ((i=file.read()) != -1) 
            System.out.print((char) i); 
        } catch (Exception e) {
           e.printStackTrace();
        }
     }
  }



