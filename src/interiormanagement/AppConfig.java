/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class AppConfig {
    public static String HOST_NAME = "";
    public static String POST = "";
    public static String INSTANCE_NAME = "";  
    public static String DATABASE_NAME = "";
    public static String USERNAME = "";
    public static String PASSWORD = "";
    
     public static void readFile() throws IOException{
       //Make sure you use \\ instead of \
        ArrayList<String> configList = new ArrayList<>();
        String filePath = "AppConfig.txt";
        Reader reader;
        BufferedReader bufferedReader = null;
        try {
                //Opening the file
                reader = new FileReader(filePath);
                bufferedReader = new BufferedReader(reader);

                //Reading the file
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                        configList.add(currentLine);
                }
        } catch (FileNotFoundException e) {
                System.out.println("The file " + filePath + "is not found !");
                e.printStackTrace();
        } catch (IOException e) {
                System.out.println("Problem occurs when reading file !");
                e.printStackTrace();
        } finally {
                //Closing the file
                if (bufferedReader != null) {
                        try {
                                bufferedReader.close();
                        } catch (IOException e) {
                                System.out.println("Problem occurs when closing file !");
                                e.printStackTrace();
                        }
                }
        }
        if (configList.size() > 0) {
              HOST_NAME = configList.get(0);
                POST = configList.get(1);
                INSTANCE_NAME = configList.get(2);
                DATABASE_NAME = configList.get(3);
        }

        if (configList.size() > 4) {
            USERNAME = configList.get(4);
            PASSWORD = configList.get(5);
        }
    }
}
