import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;



// server read using POST and GET requests

class executeCommands1 extends Thread{
    public void run(){
        try {
            URL url;
            FileReader file = new FileReader(testWorkloadMajorRead.fileName1);
            int fileReadValue, currentWriteValue = 0;
            String readLine = null;
            HttpURLConnection conection;
            int temp = 0;
            while ((fileReadValue = file.read()) != -1) {
                
                if((char) fileReadValue == 'R') {
                    url = new URL(testWorkloadMajorRead.urlRead + "1");
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;  
                    currentWriteValue = fileReadValue;
                    url = new URL(testWorkloadMajorRead.urlWrite + Integer.toString(currentWriteValue) + "/1");
                    testWorkloadMajorRead.latestWriteValue = fileReadValue;

                } else{
                    url = new URL(testWorkloadMajorRead.urlRead + "1");
                    temp = testWorkloadMajorRead.latestWriteValue;
                }
                conection = (HttpURLConnection) url.openConnection();
                conection.setRequestMethod("GET");
                int responseCode = conection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(conection.getInputStream()));

                    StringBuffer response = new StringBuffer();

                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                        // temp = testWorkloadMajorRead.latestWriteValue;

                    } in .close();
                    if((char) fileReadValue == 'C'){
                        // JSONObject jsonObject = new JSONObject(response.toString());
                        // if(latestWriteValue == Integer.parseInt(jsonObject.getString("value"))){
                        //     System.out.println("SUCCESS");
                        // }else{
                        //     System.out.println("INCONSISTENT");
                        // }
                        System.out.println("Check 1 : " + response.toString() + " " + temp);
                    }              
                }
                Thread.sleep(100);
            }   
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

class executeCommands2 extends Thread{
    public void run(){
        try {
            URL url;
            FileReader file = new FileReader(testWorkloadMajorRead.fileName2);
            int fileReadValue, currentWriteValue = 0;
            String readLine = null;
            int temp = 0;
            HttpURLConnection conection;
            while ((fileReadValue = file.read()) != -1) {
                
                if((char) fileReadValue == 'R') {
                    url = new URL(testWorkloadMajorRead.urlRead + "2");
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;
                    currentWriteValue = fileReadValue;
                    url = new URL(testWorkloadMajorRead.urlWrite + Integer.toString(currentWriteValue) + "/2");
                    testWorkloadMajorRead.latestWriteValue = fileReadValue;

                } else{
                    url = new URL(testWorkloadMajorRead.urlRead + "2");
                    temp = testWorkloadMajorRead.latestWriteValue;
                }
                conection = (HttpURLConnection) url.openConnection();
                conection.setRequestMethod("GET");
                int responseCode = conection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(conection.getInputStream()));

                    StringBuffer response = new StringBuffer();

                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                        // temp = testWorkloadMajorRead.latestWriteValue;

                    } in .close();
                    if((char) fileReadValue == 'C'){
                        // JSONObject jsonObject = new JSONObject(response.toString());
                        // if(latestWriteValue == Integer.parseInt(jsonObject.getString("value"))){
                        //     System.out.println("SUCCESS");
                        // }else{
                        //     System.out.println("INCONSISTENT");
                        // }
                        System.out.println("Check 2 : " + response.toString() + " " + temp);
                    }              
                }
                Thread.sleep(100);
            }   
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

class executeCommands3 extends Thread{
    public void run(){
        try {
            URL url;
            FileReader file = new FileReader(testWorkloadMajorRead.fileName2);
            int fileReadValue, currentWriteValue = 0;
            String readLine = null;
            int temp = 0;
            HttpURLConnection conection;
            while ((fileReadValue = file.read()) != -1) {
                
                if((char) fileReadValue == 'R') {
                    url = new URL(testWorkloadMajorRead.urlRead + "3");
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;
                    currentWriteValue = fileReadValue;
                    url = new URL(testWorkloadMajorRead.urlWrite + Integer.toString(currentWriteValue) + "/3");
                    testWorkloadMajorRead.latestWriteValue = fileReadValue;

                } else{
                    url = new URL(testWorkloadMajorRead.urlRead + "3");
                    temp = testWorkloadMajorRead.latestWriteValue;
                }
                conection = (HttpURLConnection) url.openConnection();
                conection.setRequestMethod("GET");
                int responseCode = conection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new BufferedReader(
                        new InputStreamReader(conection.getInputStream()));

                    StringBuffer response = new StringBuffer();

                    while ((readLine = in.readLine()) != null) {
                        response.append(readLine);
                        // temp = testWorkloadMajorRead.latestWriteValue;

                    } in .close();
                    if((char) fileReadValue == 'C'){
                        // JSONObject jsonObject = new JSONObject(response.toString());
                        // if(latestWriteValue == Integer.parseInt(jsonObject.getString("value"))){
                        //     System.out.println("SUCCESS");
                        // }else{
                        //     System.out.println("INCONSISTENT");
                        // }
                        System.out.println("Check 3 : " + response.toString() + " " + temp);
                    }              
                }
                Thread.sleep(100);
            }   
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

public class testWorkloadMajorRead {
    
    public static String urlRead = "http://localhost:3000/read/";
    public static String urlWrite = "http://localhost:3000/write/";
    public static String fileName1 = "majorWriteWorkload1.txt";
    public static String fileName2 = "majorWriteWorkload2.txt";
    public static String fileName3 = "majorWriteWorkload3.txt";
    public static int latestWriteValue = 0;

    public static void main(String[] args) {
        executeCommands1 executor1 = new executeCommands1();
        executeCommands2 executor2 = new executeCommands2();
        executeCommands3 executor3 = new executeCommands3();
        executor1.start();
        executor2.start();
        executor3.start();
     }
}



