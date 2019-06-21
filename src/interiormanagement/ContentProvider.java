/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement;

import interiormanagement.Class.Product;
import interiormanagement.Controller.ProcessDatabase;
import interiormanagement.View.EmployeeFrame;
import interiormanagement.View.ProductFrame;
import interiormanagement.View.TypeProductFrame;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class ContentProvider {
    public static ProcessDatabase process = new ProcessDatabase();
    public static NumberFormat numberFormat = NumberFormat.getInstance(); 
    
    
    public static void Logo(JFrame frame){
        URL Url = frame.getClass().getResource("/interiormanagement/Images/icon5.png");
        try {
           Image image = ImageIO.read(Url).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
           frame.setIconImage(image);
        } catch (IOException ex) {
            Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static ResultSet getList(String tableName){
        if (process.Connect()) {
            return process.getListData(tableName);
        }
        return null;
    }
    
    public static ResultSet getInfoProductFromDetailBill(int idProduct){
        if (process.Connect()) {
            return process.getInfoProductFromDetailBill(idProduct);
        }
        return null;
    }
    
    public static boolean UpdateProduct(Product product){
         if (process.Connect()) {
             return process.UpdateProduct(product);
        }
        return false;
    }
    public static boolean validEmail(String email) {
        return email.matches("[a-zA-Z0-9._-][a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}");
    }
    
}
   

