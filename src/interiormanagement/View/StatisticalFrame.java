/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement.View;

import interiormanagement.Class.BillCustomer;
import interiormanagement.Class.Customer;
import interiormanagement.Class.DetailBill;
import interiormanagement.Class.DetailBillCustomer;
import interiormanagement.Class.Employee;
import interiormanagement.Class.ImportBill;
import interiormanagement.Class.Product;
import interiormanagement.Class.Supplier;
import interiormanagement.ContentProvider;
import interiormanagement.Controller.ProcessDatabase;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class StatisticalFrame extends javax.swing.JFrame {
    private final String[] months = {"Tất Cả","1","2","3","4","5","6","7","8","9","10","11","12"};
    private final String[] titlesSaleBill = {"Số Hóa Đơn","Nhân Viên","Ngày Xuất","Khách Hàng","Thành Tiền (VNĐ)"};
    private final String[] titlesSaleProduct = {"Sản Phẩm","Số Lượng Đã Bán"};
    private final String[] titlesImportBill = {"Số Phiếu Nhập","Ngày Nhập","Nhà Cung Cấp","Thành Tiền (VNĐ)"};
    private final String[] titlesImportProduct = {"Sản Phẩm","Số Lượng Đã Nhập"};
    
    private DefaultTableModel modelImportProduct,modelImportBill;
    private DefaultTableModel modelSaleProduct,modelSaleBill;
    private ProcessDatabase process;
    
    
    private ArrayList<Product> listProduct;
    private ArrayList<Employee> listEmployee;
    private ArrayList<Customer> listCustomer;
    private ArrayList<BillCustomer> listBillCustomer;
    private ArrayList<DetailBillCustomer> listDetailBillCustomer;


    private ArrayList<Supplier> listSupplier;    
    private ArrayList<ImportBill> listImportBill;
    private ArrayList<DetailBill> listDetailBill;
    
    private long totalSale;
    private long totalImport;
    /**
     * Creates new form StatisticalFrame
     */
    public StatisticalFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý cửa hàng nội thất DreamHouse");
        // set icon jframe
        ContentProvider.Logo(this);
        
        for(String s : months){
            cbMonthImport.addItem(s);
            cbMonthSale.addItem(s);
        }
        

        importBillTable.setDefaultEditor(Object.class, null);
        importProductTable.setDefaultEditor(Object.class, null);
        sellProductTable.setDefaultEditor(Object.class, null);
        saleBillTable.setDefaultEditor(Object.class, null);
        
        modelImportBill = (DefaultTableModel) importBillTable.getModel();
        modelImportProduct = (DefaultTableModel) importProductTable.getModel();
        modelSaleProduct = (DefaultTableModel) sellProductTable.getModel();
        modelSaleBill = (DefaultTableModel) saleBillTable.getModel();
        
        modelImportBill.setColumnIdentifiers(titlesImportBill);
        modelImportProduct.setColumnIdentifiers(titlesImportProduct);
        modelSaleProduct.setColumnIdentifiers(titlesSaleProduct);
        modelSaleBill.setColumnIdentifiers(titlesSaleBill);
        
        
        process = ContentProvider.process;
        listProduct = new ArrayList<>();
        listEmployee = new ArrayList<>();
        listCustomer = new ArrayList<>();
        listBillCustomer = new ArrayList<>();
        listDetailBillCustomer = new ArrayList<>();
        
        listDetailBill = new ArrayList<>();
        listImportBill = new ArrayList<>();
        listSupplier = new ArrayList<>();
        
        // GET DATA
        getListProduct();
        getListEmployee();
        getListCustomer();
        getListBillCustomer();
        getListDetailBillCustomer();
        
        getListImportBill();
        getListDetailtBill();
        getListSupplier();
        
        //add year into cbYear sale
        cbYearSale.addItem("Tất Cả");
        for(Integer year : getYearInBill()){
            cbYearSale.addItem(year+"");
        }
        
        cbYearImport.addItem("Tất Cả");
        for(Integer year : getYearImportInBill()){
            cbYearImport.addItem(year+"");
        }
        
        // set value total by 0
        totalImport = 0; 
        totalSale = 0;
        
        // show information salebill
        showInfoSaleBill("Tất Cả", "Tất Cả");
        showInfoImportBill("Tất Cả", "Tất Cả");
        showProductSale();
        showProductImport();
        
        setEventComboBox();
        
    }

    private void setEventComboBox(){
        cbMonthSale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                showInfoSaleBill((String)cbMonthSale.getSelectedItem(), (String)cbYearSale.getSelectedItem());
            }
        });
        cbYearSale.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                showInfoSaleBill((String)cbMonthSale.getSelectedItem(), (String)cbYearSale.getSelectedItem());
            }
        });
        
        cbMonthImport.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                showInfoImportBill((String)cbMonthImport.getSelectedItem(), (String)cbYearImport.getSelectedItem());
            }
        });
        cbYearImport.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                showInfoImportBill((String)cbMonthImport.getSelectedItem(), (String)cbYearImport.getSelectedItem());
            }
        });
    }
    private void getListProduct(){
        ResultSet result = ContentProvider.getList(Product.TABLE_NAME);
        try {
            while(result.next()){
                listProduct.add(new Product(
                        result.getInt("MASP"),
                        result.getString("TENSP"),
                        result.getString("DVTINH"),
                        result.getInt("GIABAN"),
                        result.getInt("SOLUONG"),
                        result.getInt("MALOAI")
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        
        process.CloseConnect();
        }
    }
    
    private void getListSupplier(){
        ResultSet rs = ContentProvider.getList(Supplier.TABLE_NAME);
            try {
                while (rs.next()) {
                    listSupplier.add(new Supplier(rs.getInt("MANCC"),
                            rs.getString("TENNCC"),
                            rs.getString("DIACHI"),
                            rs.getString("SDT"),
                            rs.getString("EMAIL"),
                            rs.getString("FAX")
                          ));
                }
            } catch (SQLException ex) {
                Logger.getLogger(StatisticalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        process.CloseConnect();
    }
    
    private void getListImportBill(){
       ResultSet result = ContentProvider.getList(ImportBill.TABLE_NAME);
        try {
            while(result.next()){
                 listImportBill.add(new ImportBill(result.getInt("SOPN"), result.getDate("NGAYNHAP"), result.getInt("MANCC")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void getListDetailtBill(){
       ResultSet result = ContentProvider.getList(DetailBill.TABLE_NAME);
        try {
            while (result.next()) {
                listDetailBill.add(new DetailBill(result.getInt("SOPN"),
                        result.getInt("MASP"),
                        result.getInt("DONGIA"),
                        result.getInt("SOLUONG"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    private void getListEmployee(){
        ResultSet rs = ContentProvider.getList(Employee.TABLE_NAME);
        try {
            while (rs.next()) {
                listEmployee.add(new Employee(rs.getString("MANV"),
                        rs.getString("TENNV"),
                        rs.getInt("PHAI"),
                        rs.getString("SDT"),
                        rs.getString("DIACHINV"),
                        null,
                        null,
                        null,
                        rs.getInt("LUONG"),
                        rs.getInt("QUYENHAN")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        process.CloseConnect();
    }
    
    private void getListCustomer(){
        ResultSet result = ContentProvider.getList(Customer.TABLE_NAME);
        try {
            while(result.next()){
                listCustomer.add(new Customer(result.getInt("MAKH"), 
                        result.getString("TENKH"), 
                        result.getString("SDT"),
                        result.getString("DIACHIKH"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        process.CloseConnect();
    }
    
    private void getListBillCustomer(){
        ResultSet result = ContentProvider.getList(BillCustomer.TABLE_NAME);
            try {
                while(result.next()){
                     listBillCustomer.add(new BillCustomer(result.getInt("SOHD"), 
                             result.getDate("NGAYXUAT"), 
                             result.getString("MANV"), 
                             result.getInt("MAKH")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        process.CloseConnect();
    }
    
    private void getListDetailBillCustomer(){
        ResultSet rs = ContentProvider.getList(DetailBillCustomer.TABLE_NAME);
            try {
                while(rs.next()){
                    listDetailBillCustomer.add(new DetailBillCustomer(rs.getInt("SOHD"), 
                            rs.getInt("MASP"), 
                            rs.getInt("DONGIA"), 
                            rs.getInt("SOLUONG")));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BillCustomerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        process.CloseConnect();
    }
    
    private Set<Integer> getYearInBill(){
        Set<Integer> years = new HashSet<Integer>() ;
        for(BillCustomer bill : listBillCustomer){
            years.add(bill.getExportDate().getYear() + 1900);
        }
        
        return years;
    }
    
    private Set<Integer> getYearImportInBill(){
        Set<Integer> years = new HashSet<Integer>() ;
        for(ImportBill bill : listImportBill){
            years.add(bill.getNgayNhap().getYear() + 1900);
        }
        
        return years;
    }
    
    private void showInfoSaleBill(String month,String year){
        modelSaleBill.setRowCount(0);
        totalSale = 0;
        for(BillCustomer bill : listBillCustomer){
            int y = bill.getExportDate().getYear() + 1900;  
            int mon = bill.getExportDate().getMonth() + 1;      
            
            if (month.equals("Tất Cả")) {
                if (year.equals("Tất Cả")) {
                    addRowTableSale(bill);
                }else{
                    if (year.equals(y+"")) {
                        addRowTableSale(bill);
                    }
                }
            }
            
            if (month.equals(mon+"")) {
                if (year.equals("Tất Cả")) {
                    addRowTableSale(bill);
                }else{
                    if (year.equals(y+"")) {
                        addRowTableSale(bill);
                    }
                }
            }
        }
        lblTotalSale.setText(ContentProvider.numberFormat.format(totalSale) + " VNĐ");
    }
    
    private void showInfoImportBill(String month,String year){
        modelImportBill.setRowCount(0);
        totalImport = 0;
        for(ImportBill bill : listImportBill){
            int y = bill.getNgayNhap().getYear() + 1900;  
            int mon = bill.getNgayNhap().getMonth() + 1;      
            
            if (month.equals("Tất Cả")) {
                if (year.equals("Tất Cả")) {
                    addRowTableImport(bill);
                }else{
                    if (year.equals(y+"")) {
                        addRowTableImport(bill);
                    }
                }
            }
            
            if (month.equals(mon+"")) {
                if (year.equals("Tất Cả")) {
                    addRowTableImport(bill);
                }else{
                    if (year.equals(y+"")) {
                        addRowTableImport(bill);
                    }
                }
            }
        }
        
        lblTotalImport.setText(ContentProvider.numberFormat.format(totalImport) + " VNĐ");
    }
    
    private void showProductSale(){
        modelSaleProduct.setRowCount(0);
        ArrayList<Product> listProductSold = new ArrayList<>();
        
        for(Product product : listProduct){
            int totalAmount = 0;
            for(DetailBillCustomer detail : listDetailBillCustomer){
                if (product.getMasp() == detail.getIdProduct()) {
                    totalAmount += detail.getAmount();
                }
            }
            listProductSold.add(new Product(product.getMasp(),
                    product.getTensp(),
                    product.getDvt(), 
                    product.getGiaBan(), 
                    totalAmount,
                    product.getLoaisp()));
        }
        
        AddRowProductSale(listProductSold);
    }
    
    private void showProductImport(){
        modelImportProduct.setRowCount(0);
        ArrayList<Product> listProductImport = new ArrayList<>();
        
        for(Product product : listProduct){
            int totalAmount = 0;
            for(DetailBill detail : listDetailBill){
                if (product.getMasp() == detail.getMasp()) {
                    totalAmount += detail.getSoluong();
                }
            }
            listProductImport.add(new Product(product.getMasp(),
                    product.getTensp(),
                    product.getDvt(), 
                    product.getGiaBan(), 
                    totalAmount,
                    product.getLoaisp()));
        }
        
        AddRowProductImport(listProductImport);
    }
    
    private void AddRowProductSale(ArrayList<Product> listProductSold){
        for(int i = 0; i < listProductSold.size() ;i++){
            modelSaleProduct.addRow(new Object[] {
                listProductSold.get(i).getTensp(),
                listProductSold.get(i).getAmount(),
            });
        }
    }
    
    private void AddRowProductImport(ArrayList<Product> listProductImport){
        for(int i = 0; i < listProductImport.size() ;i++){
            modelImportProduct.addRow(new Object[] {
                listProductImport.get(i).getTensp(),
                listProductImport.get(i).getAmount(),
            });
        }
    }
    
    private void addRowTableSale(BillCustomer bill){
        modelSaleBill.addRow(new Object[] {
            bill.getId(),
            getNameEmployee(bill.getIdEmployee()),
            bill.getExportDate(),
            getNameCustomer(bill.getIdCustomer()),
            ContentProvider.numberFormat.format(getTotalValue(bill.getId()))
        });
        totalSale += getTotalValue(bill.getId());
    }
    
    private void addRowTableImport(ImportBill bill){
        modelImportBill.addRow(new Object[] {
            bill.getSopn(),
            getNameSupplier(bill.getMancc()),
            bill.getNgayNhap(),
            ContentProvider.numberFormat.format(getTotalValueImport(bill.getSopn()))
        });
        totalImport += getTotalValueImport(bill.getSopn());
    }
    
    private String getNameCustomer(int idCustomer){
        for(Customer cus : listCustomer){
            if (idCustomer == cus.getId()) {
                return cus.getName();
            }
        }
        return null;
    }
    
    private String getNameSupplier(int idSupplier){
        for(Supplier sp : listSupplier){
            if (idSupplier == sp.getMancc()) {
                return sp.getTenncc();
            }
        }
        return null;
    }
    
    private String getNameEmployee(String idEmployee){
        for(Employee emp : listEmployee){
                if (idEmployee.equals(emp.getIdEmployee())) {
                    return emp.getName();
                }
            }
        return null;
    }
    
    private long getTotalValue(int numberBill){
        long total = 0;
        for(DetailBillCustomer detail : listDetailBillCustomer){
            if (detail.getIdBillCustomer() == numberBill) {
                total+= detail.getAmount() * detail.getCost();
            }
        }
        return total;
    }
    
    private long getTotalValueImport(int numberBill){
        long total = 0;
        for(DetailBill detail : listDetailBill){
            if (detail.getSopn()== numberBill) {
                total+= detail.getSoluong()* detail.getDongia();
            }
        }
        return total;
    }
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        middlePanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        lblTotalImport = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        importProductTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        importBillTable = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbMonthImport = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbYearImport = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblTotalSale = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        sellProductTable = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        saleBillTable = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        cbMonthSale = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbYearSale = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        topPanel.setPreferredSize(new java.awt.Dimension(958, 101));
        topPanel.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ");
        jLabel1.setOpaque(true);
        topPanel.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        middlePanel.setBackground(new java.awt.Color(255, 255, 255));
        middlePanel.setLayout(new javax.swing.BoxLayout(middlePanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 562));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel3.setPreferredSize(new java.awt.Dimension(1121, 50));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setBackground(new java.awt.Color(95, 212, 197));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Phiếu Nhập Hàng");
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel6.setOpaque(true);
        jPanel4.add(jLabel6);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setBackground(new java.awt.Color(95, 212, 197));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Hóa Đơn Bán Hàng");
        jLabel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jLabel7.setOpaque(true);
        jPanel5.add(jLabel7);

        jPanel3.add(jPanel5);

        jPanel2.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(779, 50));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Tổng Giá Trị");

        lblTotalImport.setBackground(new java.awt.Color(255, 255, 255));
        lblTotalImport.setForeground(new java.awt.Color(255, 51, 51));
        lblTotalImport.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalImport.setText("Giá Trị");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalImport, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lblTotalImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel10, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("        SỐ LƯỢNG SẢN PHẨM ĐÃ NHẬP");

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        importProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(importProductTable);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        importBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(importBillTable);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tháng");
        jPanel14.add(jLabel10);
        jPanel14.add(cbMonthImport);

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Năm");
        jPanel14.add(jLabel11);
        jPanel14.add(cbYearImport);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel13, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(551, 50));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Tổng Giá Trị");

        lblTotalSale.setForeground(new java.awt.Color(255, 51, 51));
        lblTotalSale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotalSale.setText("Giá Trị");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalSale, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                    .addComponent(lblTotalSale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel9, java.awt.BorderLayout.PAGE_END);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("        SỐ LƯỢNG SẢN PHẨM ĐÃ BÁN");

        sellProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(sellProductTable);

        saleBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(saleBillTable);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tháng");
        jPanel17.add(jLabel15);
        jPanel17.add(cbMonthSale);

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Năm");
        jPanel17.add(jLabel20);
        jPanel17.add(cbYearSale);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE))
        );

        jPanel8.add(jPanel16, java.awt.BorderLayout.CENTER);

        jPanel6.add(jPanel8);

        jPanel2.add(jPanel6, java.awt.BorderLayout.CENTER);

        middlePanel.add(jPanel2);

        getContentPane().add(middlePanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatisticalFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StatisticalFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbMonthImport;
    private javax.swing.JComboBox<String> cbMonthSale;
    private javax.swing.JComboBox<String> cbYearImport;
    private javax.swing.JComboBox<String> cbYearSale;
    private javax.swing.JTable importBillTable;
    private javax.swing.JTable importProductTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblTotalImport;
    private javax.swing.JLabel lblTotalSale;
    private javax.swing.JPanel middlePanel;
    private javax.swing.JTable saleBillTable;
    private javax.swing.JTable sellProductTable;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
