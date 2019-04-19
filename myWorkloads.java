import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;


// server read using post and get

public class myWorkloads {
    private static String urlRead = "http://localhost:3000/read";
    private static String urlWrite = "http://localhost:3000/write/";
    private static String readLine = null;

    
    
    public static void main(String[] args) {
        try {
            URL url;
            FileReader file = new FileReader("testWorkload.txt");
            int fileReadValue, currentWriteValue = 0, latestWriteValue = 0; 
            HttpURLConnection conection;

            while ((fileReadValue = file.read()) != -1) {
                // System.out.println("fileReadValur :" + fileReadValue + " "+ (char) fileReadValue);
                if((char) fileReadValue == 'R') {
                    url = new URL(urlRead);
                    conection = (HttpURLConnection) url.openConnection();
                    conection.setRequestMethod("GET");
                    int responseCode = conection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(
                            new InputStreamReader(conection.getInputStream()));
                
                        StringBuffer response = new StringBuffer();
                
                        while ((readLine = in.readLine()) != null) {
                            response.append(readLine);
                        } in .close();

                        System.out.println("JSON String Result " + response.toString());                
                    }
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;
                    latestWriteValue = fileReadValue;  
                    currentWriteValue = latestWriteValue;
                    url = new URL(urlWrite + Integer.toString(currentWriteValue));

                    
                    conection = (HttpURLConnection) url.openConnection();
                    conection.setRequestMethod("GET");
                    // conection.setRequestProperty("valueToWrite", Integer.toString(currentWriteValue));
                    int responseCode = conection.getResponseCode();
                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        BufferedReader in = new BufferedReader(
                            new InputStreamReader(conection.getInputStream()));
                
                        StringBuffer response = new StringBuffer();
                
                        while ((readLine = in.readLine()) != null) {
                            response.append(readLine);
                        } in .close();

                        System.out.println("JSON String Result " + response.toString());                
                    }
                    // System.out.println("current " + latestWriteValue + " " + currentWriteValue);

                } else{
                    // do nothing

                }
                
                
            }
        } catch (Exception e) {
           e.printStackTrace();
        }
     }
  }



