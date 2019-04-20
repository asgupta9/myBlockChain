import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Random;


// Generate the random workload of read and write on a database variable 

public class generateWorkloads {

    private static int STATEMENT_COUNT = 10000;
    public static void main(String[] args) {

        generateMajorReadWorkload();        //Generate Major Read workload
        generateMajorWriteWorkload();          //Generate Major Write workload
        generateequalReadWriteWorkload();      //Generate equal Read and write workload
       
    }

    private static void generateMajorReadWorkload(){
        try {
            FileWriter file = new FileWriter("majorReadWorkload3.txt");
            Random number = new Random();
              
            for(int i = 0; i<STATEMENT_COUNT; i++){
                int randomNumber = number.nextInt(100);
                if(randomNumber <= 10) {
                    // generate check statementrandomNumberInRange
                    file.write("C\n");

                }else if(randomNumber<=30){
                    // generate write statement
                    file.write("W"+Integer.toString(number.nextInt(10))+"\n");
                }else{
                    //generate read statement
                    file.write("R\n");
                }
            } 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private static void generateMajorWriteWorkload(){
        try {
            FileWriter file = new FileWriter("majorWriteWorkload3.txt");
            Random number = new Random();
              
            for(int i = 0; i<STATEMENT_COUNT; i++){
                int randomNumber = number.nextInt(100);
                if(randomNumber <= 10) {
                    // generate check statementrandomNumberInRange
                    file.write("C\n");

                }else if(randomNumber<=80){
                    // generate write statement
                    file.write("W"+Integer.toString(number.nextInt(10))+"\n");
                }else{
                    //generate read statement
                    file.write("R\n");
                }
            } 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }

    private static void generateequalReadWriteWorkload(){
        try {
            FileWriter file = new FileWriter("equalReadWriteWorkload3.txt");
            Random number = new Random();
              
            for(int i = 0; i<STATEMENT_COUNT; i++){
                int randomNumber = number.nextInt(100);
                if(randomNumber <= 10) {
                    // generate check statementrandomNumberInRange
                    file.write("C\n");

                }else if(randomNumber<=55){
                    // generate write statement
                    file.write("W"+Integer.toString(number.nextInt(10))+"\n");
                }else{
                    //generate read statement
                    file.write("R\n");
                }
            } 
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
  }



