import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;



class executeCommands1 extends Thread{
    public void run(){
        try {
            
            FileReader file = new FileReader(normalExecution.fileName1);
            int fileReadValue, currentWriteValue = 0;
            String readLine = null;
            while ((fileReadValue = file.read()) != -1) {    
                if((char) fileReadValue == 'R') {
                    // do nothing
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;  
                    currentWriteValue = fileReadValue;
                    normalExecution.latestWriteValue = currentWriteValue;
                    normalExecution.X = normalExecution.latestWriteValue;

                } else{
                    int temp=normalExecution.latestWriteValue;
                    Thread.sleep(1000);
                    //System.out.println("Thread 1 : " + normalExecution.X + " " + temp);
                    if (normalExecution.X != temp) {
                        normalExecution.count++;
                        System.out.println(normalExecution.count);
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
            
            FileReader file = new FileReader(normalExecution.fileName2);
            int fileReadValue, currentWriteValue = 0;
            String readLine = null;
            while ((fileReadValue = file.read()) != -1) {    
                if((char) fileReadValue == 'R') {
                    // do nothing
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;  
                    currentWriteValue = fileReadValue;
                    normalExecution.latestWriteValue = currentWriteValue;
                    normalExecution.X = normalExecution.latestWriteValue;

                } else{
                    int temp=normalExecution.latestWriteValue;
                    Thread.sleep(1000);
                    //System.out.println("Thread 2 : " + normalExecution.X + " " + temp);
                    if (normalExecution.X != temp) {
                        normalExecution.count++;
                        System.out.println(normalExecution.count);
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
            
            FileReader file = new FileReader(normalExecution.fileName3);
            int fileReadValue, currentWriteValue = 0;
            String readLine = null;
            while ((fileReadValue = file.read()) != -1) {    
                if((char) fileReadValue == 'R') {
                    // do nothing
                } 
                if((char) fileReadValue == 'W') { 
                    fileReadValue = file.read() - 48;  
                    currentWriteValue = fileReadValue;
                    normalExecution.latestWriteValue = currentWriteValue;
                    normalExecution.X = normalExecution.latestWriteValue;

                } else{
                    int temp=normalExecution.latestWriteValue;
                    Thread.sleep(1000);
                    //System.out.println("Thread 3 : " + normalExecution.X + " " + temp);
                    if (normalExecution.X != temp) {
                        normalExecution.count++;
                        System.out.println("Thread 3 : " + normalExecution.X + " " + temp);
                        System.out.println(normalExecution.count);
                    }
                }
                Thread.sleep(100);
            }   
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}

public class normalExecution {
    
    public static String fileName1 = "majorWriteWorkload1.txt";
    public static String fileName2 = "majorWriteWorkload2.txt";
    public static String fileName3 = "majorWriteWorkload3.txt";
    public static int latestWriteValue = 0;
    public static int X = 0;
    public static int count = 0;

    public static void main(String[] args) {
        executeCommands1 executor1 = new executeCommands1();
        executeCommands2 executor2 = new executeCommands2();
        executeCommands3 executor3 = new executeCommands3();
        executor1.start();
        executor2.start();
        executor3.start();
        System.out.println(count);
     }
}



