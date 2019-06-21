/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement.Controller;

import interiormanagement.AppConfig;
import interiormanagement.Class.BillCustomer;
import interiormanagement.Class.Customer;
import interiormanagement.Class.DetailBill;
import interiormanagement.Class.DetailBillCustomer;
import interiormanagement.Class.Employee;
import interiormanagement.Class.ImportBill;
import interiormanagement.Class.Product;
import interiormanagement.Class.Supplier;
import interiormanagement.Class.TypeProduct;
import static interiormanagement.ContentProvider.process;
import interiormanagement.Model.Database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ProcessDatabase {
     private Database db = new Database();
    
     // connect database
    public boolean Connect(){
       String hostName = AppConfig.HOST_NAME;
       String post = AppConfig.POST;
       String sqlInstance = AppConfig.INSTANCE_NAME;
       String databaseName = AppConfig.DATABASE_NAME;
       String userName = AppConfig.USERNAME;
       String password = AppConfig.PASSWORD;
       
       String connectURL;
        if (userName.length() > 0 && userName != " ") {
            //jdbc:sqlserver://localhost\LAPTOP-7GT1QA9M\SQLEXPRESS:1433;databaseName=InteriorManagement;
            connectURL = "jdbc:sqlserver://"+hostName+ "\\" + sqlInstance + ":" + post + ";databaseName="+databaseName+";"; 
        }else
           // jdbc:sqlserver://localhost\LAPTOP-7GT1QA9M\SQLEXPRESS:1433;databaseName=InteriorManagement;integratedSecurity=true;
            connectURL = "jdbc:sqlserver://"+hostName + "\\"+sqlInstance + ":" + post + ";databaseName="+databaseName+";integratedSecurity=true;";
       
       return db.Connect(connectURL,userName,password);
    }
    
    // close database
    public void CloseConnect(){
        db.CloseConnect();
    }
    
    public boolean CheckFromDetailBill(int idProduct){
       String sql = "SELECT * FROM CTPHIEUNHAP WHERE MASP = ?";
        return db.CheckFromDetailBill(sql,idProduct);
    }
    
    public boolean CheckFromDetailBillCustomer(int idProduct){
        String sql = "SELECT * FROM CTHOADON WHERE MASP = ?";
        return db.CheckFromDetailBillCustomer(sql,idProduct);
    }
    
    public boolean ChangePassword(String maNV,String matKhau){
        String sql = "UPDATE NHANVIEN SET MATKHAU = ? WHERE MANV = ?";
        return db.ChangePassword(sql,maNV,matKhau);
    }
    
    // Get Data from Table
    public Employee getOneEmployee(String maNV){
        String sql = "SELECT * FROM NHANVIEN WHERE MANV = ?";
        return db.getOneEmployee(sql, maNV);
    }
    
    public Supplier getOneSupplier(int maNCC){
        String sql = "SELECT * FROM NHACC WHERE MANCC = ?";
        return db.getOneSupplier(sql, maNCC);
    }
    
    public Customer getOneCustomer(int idCustomer){
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH = ?";
        return db.getOneCustomer(sql, idCustomer);
    }
    
    public ImportBill getNewImportBill(){
        String sql = "SELECT TOP 1 * FROM PHIEUNHAP ORDER BY SOPN DESC";
        return db.getNewImportBill(sql);
    }
    
    public Supplier getNewSupplier(){
        String sql = "SELECT TOP 1 * FROM NHACC ORDER BY MANCC DESC";
        return db.getNewSupplier(sql);
    }
    
    public Customer getNewCustomer(){
        String sql = "SELECT TOP 1 * FROM KHACHHANG ORDER BY MAKH DESC";
        return db.getNewCustomer(sql);
    }
    
    public BillCustomer getNewBillCustomer(){
        String sql = "SELECT TOP 1 * FROM HOADON ORDER BY SOHD DESC";
        return db.getNewBillCustomer(sql);
    }
    
    public ArrayList<DetailBill> getDetailBill(int numberBill){
        String sql = "SELECT * FROM CTPHIEUNHAP WHERE SOPN = ?";
        return db.getDetailBill(sql, numberBill);
    }
    
    public ResultSet getListData(String tableName){
        String sql = "SELECT * FROM "+tableName;
        return db.getListData(sql);
    }
    
    public ResultSet getDetailBillCustomer(int numberBill){
        String sql = "SELECT * FROM CTHOADON WHERE SOHD = ?";
        return db.getDetailBillCustomer(sql,numberBill);
    }
    
     public ResultSet getInfoProductFromDetailBill(int idProduct){
        String sql = "SELECT * FROM CTPHIEUNHAP WHERE MASP = ?";
        return db.getInfoProductFromDetailBill(sql, idProduct);
    }
    
    // Insert Data
    public boolean InsertNhanVien(Employee employee){
        String sql = "INSERT NHANVIEN VALUES(?,?,?,?,?,?,?,?,?,?)";
        return db.InsertNhanVien(sql ,employee);
    }
    
    public boolean InsertType(String nameType){
       String sql = "INSERT LOAISP (TENLOAI) VALUES(?)";
        return db.InsertType(sql ,nameType);
    }
    
    public boolean InsertProduct(String nameType,String unit,int cost,int idType){
        String sql = "INSERT SANPHAM VALUES(?,?,?,?,?)";
        return db.InsertProduct(sql ,nameType,unit,cost,idType);
    }
    
    public boolean InsertSupplier(Supplier sp){
       String sql = "INSERT NHACC VALUES(?,?,?,?,?)";
        return db.InsertSupplier(sql ,sp);
    }
    
    public boolean InsertImportBill(java.util.Date dateImport,int idSupplier){
       String sql = "INSERT PHIEUNHAP VALUES(?,?)";
        return db.InsertImportBill(sql ,dateImport,idSupplier);
    }
    
    public boolean InsertDetailBill(DetailBill detail){
       String sql = "INSERT CTPHIEUNHAP VALUES(?,?,?,?)";
        return db.InsertDetailBill(sql ,detail);
    }
    
    public boolean InsertCustomer(Customer customer){
        String sql = "INSERT KHACHHANG VALUES(?,?,?)";
        return db.InsertCustomer(sql ,customer);
    }
    
    public boolean InsertBillCustomer(java.util.Date dateImport,String idEmployee,int idCustomer){
        String sql = "INSERT HOADON VALUES(?,?,?)";
        return db.InsertBillCustomer(sql ,dateImport,idEmployee,idCustomer);
    }
    
    public boolean InsertDetailBillCustomer(DetailBillCustomer detail){
        String sql = "INSERT CTHOADON VALUES(?,?,?,?)";
        return db.InsertDetailBillCustomer(sql ,detail);
    }
    
    // Update Data
    public boolean UpdateEmployee(Employee employee){
        String sql = "UPDATE NHANVIEN SET TENNV = ?,PHAI = ?,SDT = ?,DIACHINV = ?,HINH = ?, MATKHAU = ?,LUONG = ?,QUYENHAN = ? WHERE MANV = ?";
        return db.UpdateEmployee(sql ,employee);
    }
    public boolean UpdateType(int maLoai,String tenLoai){
     String sql = "UPDATE LOAISP SET TENLOAI = ? WHERE MALOAI = ?";
        return db.UpdateType(sql ,maLoai,tenLoai);
    }
    public boolean UpdateProduct(Product product){
        String sql = "UPDATE SANPHAM SET TENSP = ?,DVTINH = ?,GIABAN = ?,MALOAI = ? WHERE MASP = ?";
        return db.UpdateProduct(sql ,product);
    }
    public boolean UpdateSupplier(Supplier sp){
        String sql = "UPDATE NHACC SET TENNCC = ?,DIACHI = ?,SDT = ?,EMAIL = ?,FAX = ? WHERE MANCC = ?";
        return db.UpdateSupplier(sql ,sp);
    }
    public boolean UpdateImportBill(int numberBill,int idSupplier){
        String sql = "UPDATE PHIEUNHAP SET MANCC = ? WHERE SOPN = ?";
        return db.UpdateImportBill(sql ,numberBill,idSupplier);
    }
    public boolean UpdateDetailBill(DetailBill detail){
        String sql = "UPDATE CTPHIEUNHAP SET DONGIA = ?,SOLUONG = ? WHERE SOPN = ? AND MASP = ?";
        return db.UpdateDetailBill(sql ,detail);
    }
    public boolean UpdateCustomer(Customer customer){
        String sql = "UPDATE KHACHHANG SET TENKH = ?,SDT = ?,DIACHIKH = ? WHERE MAKH = ?";
        return db.UpdateCustomer(sql ,customer);
    }
    public boolean UpdateBillCustomer(int numberBill,int idCustomer){
        String sql = "UPDATE HOADON SET MAKH = ? WHERE SOHD = ?";
        return db.UpdateBillCustomer(sql ,numberBill,idCustomer);
    }
    public boolean UpdateDetailBillCustomer(DetailBillCustomer detail){
        String sql = "UPDATE CTHOADON SET SOLUONG = ? WHERE SOHD = ? AND MASP = ?";
        return db.UpdateDetailBillCustomer(sql ,detail);
    }
      
    // Delete Data
    public boolean DeleteData(String tblName,String column,String id){
        String sql = "DELETE FROM "+tblName+" WHERE "+column+" = ?";
        return db.DeleteData(sql,id);
    }
    public boolean DeleteOneDetail(String tableName,String[] columns,int numberBill,int idProduct){
        String sql = "DELETE FROM "+tableName+" WHERE "+columns[0]+"= ? AND "+columns[1]+" = ?";
        return db.DeleteOneDetail(sql,numberBill,idProduct);
    }
}



