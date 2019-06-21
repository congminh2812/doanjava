/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement.Model;

import interiormanagement.Class.BillCustomer;
import interiormanagement.Class.Customer;
import interiormanagement.Class.DetailBill;
import interiormanagement.Class.DetailBillCustomer;
import interiormanagement.Class.Employee;
import interiormanagement.Class.ImportBill;
import interiormanagement.Class.Product;
import interiormanagement.Class.Supplier;
import interiormanagement.Class.TypeProduct;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class Database {
    private Connection connect;
    // Connect SQLServer
    // Use library SQLJDBC
    private Connection getConnection(String url,String username,String password){
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             // Cấu trúc URL 
            String connectURL  = url;
            if(username == " " || password == " "){
                username = "";
                password = "";
            }
            connect = DriverManager.getConnection(connectURL,username,password);
            return connect;
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return null;
    }
    
    public boolean Connect(String url,String username,String password){
        if (getConnection(url,username,password) != null) {
            return true;
        }
        return false;
    }
    
    public void CloseConnect(){
         try {
             connect.close();
         } catch (SQLException ex) {
             Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public boolean CheckFromDetailBill(String sql,int idProduct){
       PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setInt(1,idProduct);
            ResultSet rs  = statement.executeQuery();
            if (rs.next()) {
                return true;
            }
         } catch (SQLException ex) {
             System.out.println(ex.toString());
         }
         return false;
    }
    
    public boolean CheckFromDetailBillCustomer(String sql,int idProduct){
         PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setInt(1,idProduct);
            ResultSet rs  = statement.executeQuery();
            if (rs.next()) {
                 return true;
            }
         } catch (SQLException ex) {
             System.out.println(ex.toString());
         }
         return false;
    }
    
    public boolean ChangePassword(String sql,String maNV,String password){
        PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setString(1,password);
            statement.setString(2,maNV);
            int check = statement.executeUpdate();
             if (check == 1) {
                  return true;
             }
         } catch (SQLException ex) {
             System.out.println(ex.toString());
         }
         return false;
    }
    
    // Get Data Table NHANVIEN
    public Employee getOneEmployee(String sql,String maNV){
        Employee emp = null;
        PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setString(1, maNV);
            ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                 emp = new Employee(maNV,
                         rs.getString("TENNV"), 
                         rs.getInt("PHAI"),
                         rs.getString("SDT"),
                         rs.getString("DIACHINV"), 
                         rs.getBytes("HINH"), 
                         rs.getDate("NGAYVAOLAM"), 
                         rs.getString("MATKHAU"),
                         rs.getInt("LUONG"),
                         rs.getInt("QUYENHAN"));
             }
         } catch (SQLException ex) {
            emp = null;
         }
        return emp;
    }
    
    public Supplier getOneSupplier(String sql,int maNCC){
        Supplier sp = null;
        PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setInt(1, maNCC);
            ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                 sp = new Supplier(
                         rs.getInt("MANCC"), 
                         rs.getString("TENNCC"),
                         rs.getString("DIACHI"),
                         rs.getString("SDT"), 
                         rs.getString("EMAIL"), 
                         rs.getString("FAX")
                        );
             }
         } catch (SQLException ex) {
             sp = null;
         }
        return sp;
    }
    
    public Customer getOneCustomer(String sql,int idCustomer){
        Customer customer = null;
        PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setInt(1, idCustomer);
            ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                 customer = new Customer(rs.getInt("MAKH"), rs.getString("TENKH"), rs.getString("SDT"), rs.getString("DIACHIKH"));
             }
         } catch (SQLException ex) {
             customer = null;
         }
        return customer;
    }
    
    public ImportBill getNewImportBill(String sql){
        ImportBill importBill = null;
        Statement st;
         try {
            st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             if (rs.next()) {
                 importBill = new ImportBill(
                         rs.getInt("SOPN"), 
                         rs.getDate("NGAYNHAP"),
                         rs.getInt("MANCC")
                        );
             }
         } catch (SQLException ex) {
             importBill = null;
         }
        return importBill;
    }
    
    public Supplier getNewSupplier(String sql){
        Supplier sp = null;
        Statement st;
        try {
            st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                sp = new Supplier(
                        rs.getInt("MANCC"), 
                        rs.getString("TENNCC"),
                        rs.getString("DIACHI"),
                        rs.getString("SDT"),
                        rs.getString("EMAIL"),
                        rs.getString("FAX")
                        );
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sp;
    }
    
    public Customer getNewCustomer(String sql){
        Customer cs = null;
        Statement st;
        try {
            st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cs = new Customer(
                        rs.getInt("MAKH"), 
                        rs.getString("TENKH"),
                        rs.getString("SDT"),
                        rs.getString("DIACHIKH")
                        );
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cs;
    }
    
    public ArrayList<DetailBill> getDetailBill(String sql,int numberBill){
        ArrayList<DetailBill> details = new ArrayList<>();
        PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setInt(1, numberBill);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                 details.add(new DetailBill(rs.getInt("SOPN"), 
                         rs.getInt("MASP"),
                         rs.getInt("DONGIA"),
                         rs.getInt("SOLUONG"))
                 );
             }
         } catch (SQLException ex) {
             details = null;
         }
        return details;
    }
    
     public BillCustomer getNewBillCustomer(String sql){
        BillCustomer bill = null;
        Statement st;
         try {
            st = connect.createStatement();
            ResultSet rs = st.executeQuery(sql);
             if (rs.next()) {
                 bill = new BillCustomer(
                         rs.getInt("SOHD"), 
                         rs.getDate("NGAYXUAT"),
                         rs.getString("MANV"),
                         rs.getInt("MAKH")
                        );
             }
         } catch (SQLException ex) {
             bill = null;
         }
        return bill;
    }
     
    public ResultSet getListData(String sql){
        ResultSet rs = null;
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             rs = statement.executeQuery();
             
         } catch (SQLException ex) {
            return rs;
         }
         return rs;
    }
    
    public ResultSet getInfoProductFromDetailBill(String sql,int idProduct){
        ResultSet rs = null;
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1, idProduct);
             rs = statement.executeQuery();
             
         } catch (SQLException ex) {
            return rs;
         }
         return rs;
    }
    
    public ResultSet getDetailBillCustomer(String sql,int numberBill){
        ResultSet rs = null;
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1, numberBill);
             rs = statement.executeQuery();
             
         } catch (SQLException ex) {
            return rs;
         }
         return rs;
    }
    
    // INSERT DATA 
    public boolean InsertNhanVien(String sql,Employee employee){
        Date date = new Date(employee.getDateWork().getTime());
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setString(1,employee.getIdEmployee());
             statement.setString(2,employee.getName());
             statement.setInt(3,employee.getGender());
             statement.setString(4,employee.getPhone());
             statement.setString(5,employee.getAddress());
             statement.setBytes(6,employee.getImage());
             statement.setDate(7,date);
             statement.setString(8,employee.getPass());
             statement.setInt(9,employee.getSalary());
             statement.setInt(10,employee.getAuthority());
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
    
    public boolean InsertType(String sql,String tenLoai){
         try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setString(1,tenLoai);
            int check = statement.executeUpdate();
            if (check == 1 ) {
                 return true;
            }
         } catch (SQLException ex) {
             return false;
         }
        return false;
    }
     
    public boolean InsertProduct(String sql,String nameType,String unit,int cost,int idType){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setString(1,nameType);
             statement.setString(2,unit);
             statement.setInt(3,cost);
             statement.setInt(4,0);
             statement.setInt(5,idType);
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
     
    public boolean InsertSupplier(String sql,Supplier sp){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setString(1,sp.getTenncc());
             statement.setString(2,sp.getDiachincc());
             statement.setString(3,sp.getSdt());
             statement.setString(4,sp.getEmail());
             statement.setString(5,sp.getFax());
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    public boolean InsertImportBill(String sql,java.util.Date dateImport,int idSupplier){
        Date date = new Date(dateImport.getTime());
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setDate(1,date);
             statement.setInt(2,idSupplier);
     
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
    
    public boolean InsertDetailBill(String sql,DetailBill detail){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1,detail.getSopn());
             statement.setInt(2,detail.getMasp());
             statement.setInt(3,detail.getSoluong());
             statement.setInt(4,detail.getDongia());
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
    
    public boolean InsertCustomer(String sql,Customer customer){
       try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setString(1,customer.getName());
             statement.setString(2,customer.getPhone());
             statement.setString(3,customer.getAddress());
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
    
    public boolean InsertBillCustomer(String sql,java.util.Date dateImport,String idEmployee,int idCustomer){
        Date date = new Date(dateImport.getTime());
        
        try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setDate(1,date);
             statement.setString(2,idEmployee);
             statement.setInt(3,idCustomer);
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
    
    public boolean InsertDetailBillCustomer(String sql,DetailBillCustomer detail){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1,detail.getIdBillCustomer());
             statement.setInt(2,detail.getIdProduct());
             statement.setInt(3,detail.getCost());
             statement.setInt(4,detail.getAmount());
             
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
     
     // UPDATE DATA
    public boolean UpdateEmployee(String sql,Employee employee){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setString(9,employee.getIdEmployee());
             statement.setString(1,employee.getName());
             statement.setInt(2,employee.getGender());
             statement.setString(3,employee.getPhone());
             statement.setString(4,employee.getAddress());
             statement.setBytes(5,employee.getImage());
             statement.setString(6,employee.getPass());
             statement.setInt(7,employee.getSalary());
             statement.setInt(8,employee.getAuthority());
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
       
    public boolean UpdateType(String sql,int maLoai,String tenLoai){
        PreparedStatement statement;
         try {
             statement = connect.prepareStatement(sql);
             statement.setString(1,tenLoai);
             statement.setInt(2,maLoai);
              int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
          return false;    
    }
    
    public boolean UpdateProduct(String sql,Product product){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(5,product.getMasp());
             statement.setString(1,product.getTensp());
             statement.setString(2,product.getDvt());
             statement.setInt(3,product.getGiaBan());
             statement.setInt(4,product.getLoaisp());
      
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            return false;
         }
         return false;
    }
    
    public boolean UpdateSupplier(String sql,Supplier sp){
         try {
            PreparedStatement statement = connect.prepareStatement(sql);
            statement.setInt(6,sp.getMancc());
            statement.setString(1,sp.getTenncc());
            statement.setString(2,sp.getDiachincc());
            statement.setString(3,sp.getSdt());
            statement.setString(4,sp.getEmail());
            statement.setString(5,sp.getFax());

            int check = statement.executeUpdate();
            if (check == 1 ) {
                return true;
            }
        } catch (SQLException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
        
    public boolean UpdateImportBill(String sql,int numberBill,int idSupplier){
        try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1,idSupplier);
             statement.setInt(2,numberBill);

             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    public boolean UpdateDetailBill(String sql,DetailBill detail){
        try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1,detail.getDongia());
             statement.setInt(2,detail.getSoluong());
             statement.setInt(3,detail.getSopn());
             statement.setInt(4,detail.getMasp());
      
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    public boolean UpdateCustomer(String sql,Customer customer){
         try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(4,customer.getId());
             statement.setString(1,customer.getName());
             statement.setString(2,customer.getPhone());
             statement.setString(3,customer.getAddress());
      
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
        
    public boolean UpdateBillCustomer(String sql,int numberBill,int idCustomer){
        try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1,idCustomer);
             statement.setInt(2,numberBill);

             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    public boolean UpdateDetailBillCustomer(String sql,DetailBillCustomer detail){
        try {
             PreparedStatement statement = connect.prepareStatement(sql);
             statement.setInt(1,detail.getAmount());
             statement.setInt(2,detail.getIdBillCustomer());
             statement.setInt(3,detail.getIdProduct());
      
             int check = statement.executeUpdate();
             if (check == 1 ) {
                 return true;
             }
         } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    // DELETE DATA
    public boolean DeleteData(String sql,String id){
         PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setString(1,id);
            int rs = statement.executeUpdate();
             if (rs == 1) {
                 return true;
             }
         } catch (SQLException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
    public boolean DeleteOneDetail(String sql,int numberBill,int idProduct){
         PreparedStatement statement;
         try {
            statement = connect.prepareStatement(sql);
            statement.setInt(1,numberBill);
            statement.setInt(2,idProduct);
            
            int rs = statement.executeUpdate();
             if (rs == 1) {
                 return true;
             }
         } catch (SQLException ex) {
           Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
         }
         return false;
    }
    
}
