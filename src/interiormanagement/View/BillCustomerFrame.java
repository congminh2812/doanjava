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
import static interiormanagement.View.ImportProductFrame.TABLE_NAME;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author ASUS
 */
public class BillCustomerFrame extends javax.swing.JFrame {
    public final Color GREEN_LIGHT = new Color(95, 212, 197);
    private final String[] titlesBillCustomer = {"Số Hóa Đơn","Ngày Xuất","Khách Hàng"};
    private final String[] titlesProduct = {"STT","Tên Sản Phẩm","Giá Bán (VND)","Số Lượng","Thành Tiền (VND)"};
    
    private ProcessDatabase process; 
    private Employee employee;
    
    private DefaultTableModel modelBill;
    private DefaultTableModel modelProduct;
    
    
    private ArrayList<Customer> listCustomer;
    private ArrayList<Product> listProduct;
    private ArrayList<BillCustomer> listBillCustomer;
    private ArrayList<DetailBillCustomer> listDetailBillCustomer;
    private ArrayList<DetailBillCustomer> listNewDetailBillCustomer;
    private Customer customer;
    
    private boolean addOrUpdate = false; // false : add , true : update
    private boolean checkCustomer = false; //false : not exist, true: exist
    
    private int index;
    /**
     * Creates new form EnterProductFrame
     */
    public BillCustomerFrame(Employee employee) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Quản lý cửa hàng nội thất DreamHouse");
        
        // set icon jframe
        ContentProvider.Logo(this);
        
        process = ContentProvider.process;
        this.employee = employee;
        
        modelBill = (DefaultTableModel) billCustomerTable.getModel();
        modelProduct = (DefaultTableModel) productTable.getModel();
        modelBill.setColumnIdentifiers(titlesBillCustomer);
        modelProduct.setColumnIdentifiers(titlesProduct);
        
        setSelectedLabel(true, false, false);
        setLabelEnable(false, false);
        updateButton.setVisible(false);
        
        listCustomer = new ArrayList<>();
        listProduct = new ArrayList<>();
        listBillCustomer = new ArrayList<>();
        listDetailBillCustomer = new ArrayList<>();
        listNewDetailBillCustomer = new ArrayList<>();
        
        assignListProduct();
        assignListCustomer();
        for(Product product: listProduct){
            cbProduct.addItem(product.getTensp());
        }
        
        ShowBillCustomer();
        
        billCustomerTable.setDefaultEditor(Object.class, null);
        billCustomerTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (billCustomerTable.getSelectedRow() > -1) {
                    index = billCustomerTable.getSelectedRow();
                    for(Customer cs : listCustomer){
                        if (cs.getId() == listBillCustomer.get(index).getIdCustomer()) {
                            customer = cs;
                        }
                    }
                    setLabelEnable(true,true);
                }
            }
        });
        
        productTable.setDefaultEditor(Object.class, null);
        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = productTable.getSelectedRow();
                if (index > -1) {
                    cbProduct.setSelectedItem(modelProduct.getValueAt(index, 1));
                    updateButton.setEnabled(true);
                    deleteButton.setEnabled(true);
                    tfAmount.setText(listDetailBillCustomer.get(index).getAmount()+"");
                }
            }
        });
        
        tfSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                SearchData();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                SearchData();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        maspTextField1 = new javax.swing.JTextField();
        sopnTextField1 = new javax.swing.JTextField();
        dongiaTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        soluongTextField1 = new javax.swing.JTextField();
        themSPButton1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        tennccTextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        diachinccTextField1 = new javax.swing.JTextField();
        sdtTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        emailTextField1 = new javax.swing.JTextField();
        faxTextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        topPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        listLabel = new javax.swing.JLabel();
        addLabel = new javax.swing.JLabel();
        updateLabel = new javax.swing.JLabel();
        deleteLabel = new javax.swing.JLabel();
        rightPanel = new javax.swing.JPanel();
        listPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfSearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billCustomerTable = new javax.swing.JTable();
        addPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTotalValue = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbProduct = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        tfAmount = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfNameCustomer = new javax.swing.JTextField();
        checkButton = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("Số Phiếu Nhập");

        jLabel5.setText("Mã Sản Phẩm");

        maspTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maspTextField1ActionPerformed(evt);
            }
        });

        sopnTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sopnTextField1KeyTyped(evt);
            }
        });

        dongiaTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dongiaTextField1KeyTyped(evt);
            }
        });

        jLabel9.setText("Đơn Giá");

        jLabel14.setText("Số Lượng");

        soluongTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                soluongTextField1KeyTyped(evt);
            }
        });

        themSPButton1.setText("Thêm Sản Phẩm");
        themSPButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                themSPButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(56, 56, 56)
                        .addComponent(soluongTextField1))
                    .addComponent(themSPButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dongiaTextField1)
                            .addComponent(sopnTextField1)
                            .addComponent(maspTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(sopnTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(maspTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(dongiaTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(soluongTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(themSPButton1)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setText("Tên Nhà Cung Cấp");

        jLabel17.setText("Địa Chỉ NCC");

        sdtTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                sdtTextField1KeyTyped(evt);
            }
        });

        jLabel18.setText("SĐT");

        jLabel19.setText("Email");

        faxTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faxTextField1ActionPerformed(evt);
            }
        });

        jLabel20.setText("Fax");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(emailTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(sdtTextField1)
                    .addComponent(diachinccTextField1)
                    .addComponent(tennccTextField1)
                    .addComponent(faxTextField1))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel16))
                    .addComponent(tennccTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel17))
                    .addComponent(diachinccTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel18))
                    .addComponent(sdtTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel19))
                    .addComponent(emailTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel20))
                    .addComponent(faxTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(102, Short.MAX_VALUE))
        );

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setText("Làm Mới");

        jButton2.setText("Chấp Nhận");

        jButton3.setText("Quay Lại");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(0, 153, 153));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("HÓA ĐƠN KHÁCH HÀNG");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

        leftPanel.setBackground(new java.awt.Color(95, 212, 197));
        leftPanel.setPreferredSize(new java.awt.Dimension(200, 690));

        listLabel.setBackground(new java.awt.Color(95, 212, 197));
        listLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        listLabel.setForeground(new java.awt.Color(47, 55, 67));
        listLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        listLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interiormanagement/Images/list_icon.png"))); // NOI18N
        listLabel.setText("DANH SÁCH");
        listLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        listLabel.setOpaque(true);
        listLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                listLabelMousePressed(evt);
            }
        });

        addLabel.setBackground(new java.awt.Color(95, 212, 197));
        addLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addLabel.setForeground(new java.awt.Color(47, 55, 67));
        addLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        addLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interiormanagement/Images/add_icon.png"))); // NOI18N
        addLabel.setText("Thêm");
        addLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addLabel.setOpaque(true);
        addLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                addLabelMousePressed(evt);
            }
        });

        updateLabel.setBackground(new java.awt.Color(95, 212, 197));
        updateLabel.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        updateLabel.setForeground(new java.awt.Color(47, 55, 67));
        updateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        updateLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interiormanagement/Images/edit_icon.png"))); // NOI18N
        updateLabel.setText("Cập nhật / Chi Tiết");
        updateLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateLabel.setOpaque(true);
        updateLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                updateLabelMousePressed(evt);
            }
        });

        deleteLabel.setBackground(new java.awt.Color(95, 212, 197));
        deleteLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        deleteLabel.setForeground(new java.awt.Color(47, 55, 67));
        deleteLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        deleteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/interiormanagement/Images/cancel_icon.png"))); // NOI18N
        deleteLabel.setText("Xóa");
        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteLabel.setOpaque(true);
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
            .addComponent(addLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addComponent(updateLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(listLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );

        getContentPane().add(leftPanel, java.awt.BorderLayout.LINE_START);

        rightPanel.setLayout(new java.awt.CardLayout());

        listPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(782, 50));

        jLabel2.setText("Tìm Kiếm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(413, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        listPanel.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(15, 640));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        listPanel.add(jPanel4, java.awt.BorderLayout.LINE_END);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(15, 640));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );

        listPanel.add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        billCustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(billCustomerTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );

        listPanel.add(jPanel5, java.awt.BorderLayout.CENTER);

        rightPanel.add(listPanel, "card2");

        addPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setPreferredSize(new java.awt.Dimension(758, 50));

        jLabel3.setText("Tổng Giá Trị");

        lblTotalValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalValue.setText("Tổng Giá Trị");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalValue, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lblTotalValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel10);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setPreferredSize(new java.awt.Dimension(758, 50));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0));
        jPanel12.add(jLabel10);

        acceptButton.setText("CHẤP NHẬN");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });
        jPanel12.add(acceptButton);

        jPanel6.add(jPanel12);

        jPanel1.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(400, 147));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(500, 45));
        jPanel16.setLayout(new java.awt.GridLayout(1, 2));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Sản Phẩm");
        jLabel7.setOpaque(true);
        jPanel16.add(jLabel7);
        jPanel16.add(cbProduct);

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(150, 44));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Số Lượng");
        jLabel11.setOpaque(true);
        jPanel17.add(jLabel11);

        tfAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfAmountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAmountKeyTyped(evt);
            }
        });
        jPanel17.add(tfAmount);

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        updateButton.setText("Cập Nhật");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel18.add(updateButton);

        addButton.setText("Thêm ");
        addButton.setPreferredSize(new java.awt.Dimension(127, 44));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel18.add(addButton);

        deleteButton.setText("XÓA");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel18.add(deleteButton);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.add(jPanel15);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(450, 147));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(500, 45));
        jPanel20.setLayout(new java.awt.GridLayout(1, 0, 2, 0));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Khách");
        jPanel20.add(jLabel6);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Hàng");
        jLabel21.setOpaque(true);
        jPanel20.add(jLabel21);

        tfNameCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNameCustomerKeyTyped(evt);
            }
        });
        jPanel20.add(tfNameCustomer);

        checkButton.setText("Kiểm Tra");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        jPanel20.add(checkButton);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(367, 44));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Địa Chỉ KH");
        jLabel22.setOpaque(true);
        jPanel21.add(jLabel22);

        tfAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAddressKeyTyped(evt);
            }
        });
        jPanel21.add(tfAddress);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setPreferredSize(new java.awt.Dimension(145, 44));
        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("SĐT");
        jLabel23.setOpaque(true);
        jPanel22.add(jLabel23);

        tfPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPhoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPhoneKeyTyped(evt);
            }
        });
        jPanel22.add(tfPhone);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel14.add(jPanel19);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(productTable);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 769, Short.MAX_VALUE)
            .addComponent(jScrollPane3)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel13, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        rightPanel.add(addPanel, "card3");

        getContentPane().add(rightPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void maspTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maspTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maspTextField1ActionPerformed

    private void sopnTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sopnTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_sopnTextField1KeyTyped

    private void dongiaTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dongiaTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_dongiaTextField1KeyTyped

    private void soluongTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_soluongTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_soluongTextField1KeyTyped

    private void themSPButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_themSPButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_themSPButton1ActionPerformed

    private void sdtTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sdtTextField1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_sdtTextField1KeyTyped

    private void faxTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faxTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_faxTextField1ActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
         if (!validateProduct()) {
            if (CheckProductInEnterTable()) {
                JOptionPane.showMessageDialog(rootPane, "Sản Phẩm đã được thêm vào rồi nhé!");
            }else{
                int idProduct = 0;
                int cost = 0;
                boolean check = false;
                for(Product product : listProduct){
                    String nameProduct = (String) cbProduct.getSelectedItem();
                    if (nameProduct.equals(product.getTensp())) {
                        idProduct = product.getMasp();
                        cost = product.getGiaBan();
                        if (product.getAmount() > Integer.parseInt(tfAmount.getText())) {
                            check = true;
                        }
                    }
                }
                if (check) {
                    DetailBillCustomer detail = new DetailBillCustomer(0, idProduct, 
                        cost, 
                        Integer.parseInt(tfAmount.getText()));
                    
                    if (addOrUpdate) {
                        detail.setIdBillCustomer(listBillCustomer.get(index).getId());
                        listNewDetailBillCustomer.add(detail);
                    }
                    
                    listDetailBillCustomer.add(detail);
                    AddRowDetailBillCustomer(listDetailBillCustomer);
                }else
                    JOptionPane.showMessageDialog(rootPane, "Sản Phẩm đã tồn tại hoặc hết hàng . Hãy nhập hàng vào nhé!");
            }
        }else
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số liệu !");
    }//GEN-LAST:event_addButtonActionPerformed

    private void tfPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPhoneKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || (c == KeyEvent.VK_V && c == KeyEvent.VK_CONTROL))
                || c== KeyEvent.VK_DELETE || tfPhone.getText().length() > 11)
            evt.consume();
    }//GEN-LAST:event_tfPhoneKeyTyped

    private void listLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listLabelMousePressed
        setPanelVisible(true,false);
        setSelectedLabel(true, false, false);
        ShowBillCustomer();
    }//GEN-LAST:event_listLabelMousePressed

    private void addLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMousePressed
        resetInfo();
        setPanelVisible(false,true);
        setSelectedLabel(false, true, false);
        
        updateButton.setVisible(false);
        checkButton.setEnabled(true);
        checkButton.setEnabled(true);
        addOrUpdate = false;
    }//GEN-LAST:event_addLabelMousePressed

    private void updateLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateLabelMousePressed
        if (billCustomerTable.getSelectedRow() > -1) {
            setSelectedLabel(false, false, true);
            ShowInfoBill();
            addOrUpdate = true;
            listNewDetailBillCustomer.clear();
            
            deleteButton.setEnabled(false);
            updateButton.setVisible(true);
            updateButton.setEnabled(false);
            checkButton.setEnabled(false);
            cbProduct.setEnabled(true);
            tfAmount.setText("");
        }
    }//GEN-LAST:event_updateLabelMousePressed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int position = productTable.getSelectedRow();
        int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                String[] columns = new String[2];
                columns[0] = "SOHD";
                columns[1] = "MASP";
                DeleteOneDetail(DetailBillCustomer.TABLE_NAME,columns,listBillCustomer.get(index).getId(),listDetailBillCustomer.get(position).getIdProduct());
                listDetailBillCustomer.remove(position);
                removeSelectedFromTable(productTable);
                AddRowDetailBillCustomer(listDetailBillCustomer);
            }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int index = productTable.getSelectedRow();
        if (index > -1) {
            DetailBillCustomer detail = listDetailBillCustomer.get(index);
            detail.setAmount(Integer.parseInt(tfAmount.getText()));
            listDetailBillCustomer.set(index, detail);
            AddRowDetailBillCustomer(listDetailBillCustomer);
            
            updateButton.setEnabled(false);
            productTable.clearSelection();
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if (!validateCustomer()) {
            if (!addOrUpdate) {
                AcceptAdd();
            }else
                AcceptUpdate();
        }else
             JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ thông tin!");
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void deleteLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMousePressed
        int index = billCustomerTable.getSelectedRow();
        if (index > -1) {
            int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                assignDetailBillCustomer();
                
                for(DetailBillCustomer detail : listDetailBillCustomer){
                    String[] columns = new String[2];
                    columns[0] = "SOHD";
                    columns[1] = "MASP";
                    DeleteOneDetail(DetailBillCustomer.TABLE_NAME,columns,detail.getIdBillCustomer(),detail.getIdProduct());
                }
                
                DeleteBillCustomer(String.valueOf(listBillCustomer.get(index).getId()));
                
                int check = 0;
                for(BillCustomer importBill : listBillCustomer){
                   if (listBillCustomer.get(index).getIdCustomer()== importBill.getIdCustomer()) {
                       check += 1;
                   }
               }
                if (check == 1) {
                    DeleteCustomer(String.valueOf(listBillCustomer.get(index).getIdCustomer()));
                }

                listBillCustomer.remove(index);
                assignListCustomer();
                JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công!");
                ShowBillCustomer();
                process.CloseConnect();
            }
        }
    }//GEN-LAST:event_deleteLabelMousePressed

    private void tfNameCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameCustomerKeyTyped
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_DELETE || tfNameCustomer.getText().length() > 80)
            evt.consume();
    }//GEN-LAST:event_tfNameCustomerKeyTyped

    private void tfAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressKeyTyped
        char c = evt.getKeyChar();
        if(c == KeyEvent.VK_DELETE || tfAddress.getText().length() > 80)
            evt.consume();
    }//GEN-LAST:event_tfAddressKeyTyped

    private void tfAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAmountKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE ) || c== KeyEvent.VK_DELETE || tfAmount.getText().length() > 2)
            evt.consume();
    }//GEN-LAST:event_tfAmountKeyTyped

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        checkCustomer = false;
        for(Customer customer : listCustomer){
            if (tfNameCustomer.getText().toLowerCase().equals(customer.getName().toLowerCase())) {
                tfPhone.setText(customer.getPhone());
                tfAddress.setText(customer.getAddress());
                checkCustomer = true;
            }
        }
        if (!checkCustomer) {
            JOptionPane.showMessageDialog(rootPane, "Khách hàng không tồn tại!");
            tfAddress.setText("");
            tfPhone.setText("");
        }
    }//GEN-LAST:event_checkButtonActionPerformed

    private void tfPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPhoneKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            evt.consume();
        }
    }//GEN-LAST:event_tfPhoneKeyPressed

    private void tfAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAmountKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            evt.consume();
        }
    }//GEN-LAST:event_tfAmountKeyPressed

    private void SearchData(){
        ArrayList<BillCustomer> searchList = new ArrayList<>();
        for(BillCustomer billCustomer : listBillCustomer){
            if (String.valueOf(billCustomer.getExportDate()).contains(tfSearch.getText()) || 
                    getOneCustomer(billCustomer.getIdCustomer()).getName().toLowerCase().contains(tfSearch.getText())) {
                searchList.add(billCustomer);
            }
        }
        
        if(tfSearch.getText().equals("")){
            searchList = listBillCustomer;
        }
        
         modelBill.setRowCount(0);
         AddRowBillCustomer(searchList);
    }
    
    private void AcceptAdd(){
        int id = 0;
        Customer customer = null;
        for(Customer cs : listCustomer){
            if (cs.getName().toLowerCase().equals(tfNameCustomer.getText().toLowerCase())) {
                customer = cs;
                id = cs.getId();
            }
        }
        Customer cs = new Customer(0,
                tfNameCustomer.getText(), 
                tfPhone.getText(),
                tfAddress.getText());
        
      
        if (!checkCustomer) {
            if (InsertCustomer(cs)) {
                id = getNewCustomer().getId();
                AddSuccessfully(id);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Thông tin bạn nhập quá dài!");
            }
           
            
        }else{
            customer.setId(id);
            if (UpdateCustomer(cs)) {
                AddSuccessfully(id);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Thông tin bạn sửa quá dài!");
            }
        }
        process.CloseConnect();
        
       
    }
    
    private void AddSuccessfully(int id){
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        
        InsertBillCustomer(date, employee.getIdEmployee(), id);
        process.CloseConnect();

        int numberBill = getNewBillCustomer().getId();
        
        for(DetailBillCustomer detail : listDetailBillCustomer){
            detail.setIdBillCustomer(numberBill);
            InsertDetailBillCustomer(detail);
        }
        process.CloseConnect();

        JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công!");
        assignListCustomer();
        
        ShowBillCustomer();
        setSelectedLabel(true, false, false);
    }
    
    private void AcceptUpdate(){
        boolean check = false;
        int id = 0;
        
        for(Customer cs : listCustomer){
            if (cs.getName().toLowerCase().equals(tfNameCustomer.getText().toLowerCase())) {
                check = true;
                id = cs.getId();
            }
        }
       
        Customer cus = new Customer(listBillCustomer.get(index).getIdCustomer(),
                tfNameCustomer.getText(), 
                tfPhone.getText(),
                tfAddress.getText());
        
        for(DetailBillCustomer detail : listNewDetailBillCustomer){
            InsertDetailBillCustomer(detail);
        }
        
        if (check) {
            UpdateBillCustomer(listBillCustomer.get(index).getId(),id);
            cus.setId(id);
           
            if (! UpdateCustomer(cus)) {
                JOptionPane.showMessageDialog(rootPane, "Khách hàng không sửa được do thông tin quá dài!");
            }
        }else
            if (! UpdateCustomer(cus)) {
                JOptionPane.showMessageDialog(rootPane, "Khách hàng không sửa được do thông tin quá dài!");
            }
        
        int numberBill = listBillCustomer.get(index).getId();
        for(DetailBillCustomer detail : listDetailBillCustomer){
            detail.setIdBillCustomer(numberBill);
            UpdateDetailBillCustomer(detail);
        }
        process.CloseConnect();

        JOptionPane.showMessageDialog(rootPane, "Cập Nhật Thành Công!");
        
        ShowBillCustomer();
        setSelectedLabel(true, false, false);
    }
    
    public void removeSelectedFromTable(JTable from){
        int[] rows = from.getSelectedRows();
        DefaultTableModel tm= (DefaultTableModel) from.getModel();

        while(rows.length>0)
        {
            tm.removeRow(from.convertRowIndexToModel(rows[0]));
            rows = from.getSelectedRows();
        }
        from.clearSelection();
    }
    
    private boolean CheckProductInEnterTable(){
        int idProduct = getIdProduct();
        
        for(DetailBillCustomer detail : listDetailBillCustomer){
            if (detail.getIdProduct()== idProduct) {
                return true;
            }
        }
        
        return false;
    }
     
    private int getIdProduct(){
        for(Product product : listProduct){
                String nameProduct = (String) cbProduct.getSelectedItem();
                if (nameProduct.equals(product.getTensp())) {
                    return product.getMasp();
                }
            }
        return 0;
    }
    
    private void ShowInfoBill(){
        modelBill.setRowCount(0);
        assignDetailBillCustomer();

        tfNameCustomer.setText(customer.getName());
        tfAddress.setText(customer.getAddress());
        tfPhone.setText(customer.getPhone());

        AddRowDetailBillCustomer(listDetailBillCustomer);
        process.CloseConnect();
    }
     
    private void ShowBillCustomer(){
        modelBill.setRowCount(0);
        listBillCustomer.clear();

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
       AddRowBillCustomer(listBillCustomer);
       process.CloseConnect();
    }
    
    private void AddRowBillCustomer(ArrayList<BillCustomer> list){
        for(BillCustomer billCustomer : list){
            customer = getOneCustomer(billCustomer.getIdCustomer());
            modelBill.addRow(new Object[]{
                billCustomer.getId(),
                billCustomer.getExportDate(),
                customer.getName()
            });
            process.CloseConnect();
        }
    }
     
    private void AddRowDetailBillCustomer(ArrayList<DetailBillCustomer> list){
        modelProduct.setRowCount(0);
        int stt = 1;
        long total = 0L;

        for(DetailBillCustomer detail : list){
            String nameProduct = "";
            for(Product product : listProduct){
                if (detail.getIdProduct()== product.getMasp()) {
                    nameProduct = product.getTensp();
                }
            }
            modelProduct.addRow(new Object[]{
                stt,
                nameProduct,
                ContentProvider.numberFormat.format(detail.getCost()),
                ContentProvider.numberFormat.format(detail.getAmount()),
                ContentProvider.numberFormat.format((long)detail.getCost() * (long)detail.getAmount())
            });
            stt++;
            total += (long)detail.getCost() * (long)detail.getAmount();
        }

        lblTotalValue.setText(ContentProvider.numberFormat.format(total) + " VND");
    }
//     
    // GET DATA
    private void assignListProduct(){
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
        }
        process.CloseConnect();
    }
    
    private void assignListCustomer(){
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
    
    private void assignDetailBillCustomer(){
        listDetailBillCustomer.clear();
        ResultSet rs = getDetailBillCustomer(listBillCustomer.get(index).getId());
        
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

    }
    
    private Customer getOneCustomer(int idCustomer){
         if (process.Connect()) {
            return process.getOneCustomer(idCustomer);
        }
        return null;
    }
    
    private ResultSet getDetailBillCustomer(int numberBill){
        if (process.Connect()) {
            return process.getDetailBillCustomer(numberBill);
        }
        return null;
    }
    
    private Customer getNewCustomer(){
         if (process.Connect()) {
             return process.getNewCustomer();
        }
        return null;
    }
    
    private BillCustomer getNewBillCustomer(){
         if (process.Connect()) {
             return process.getNewBillCustomer();
        }
        return null;
    }
    
    // INSERT
    private boolean InsertCustomer(Customer customer){
        if (process.Connect()) {
             return process.InsertCustomer(customer);
        }
        return false;
    }
    
    private boolean InsertBillCustomer(Date dateImport,String idEmployee,int idCustomer){
        if (process.Connect()) {
             return process.InsertBillCustomer(dateImport,idEmployee,idCustomer);
        }
        return false;
    }
    
    private boolean InsertDetailBillCustomer(DetailBillCustomer detail){
        if (process.Connect()) {
             return process.InsertDetailBillCustomer(detail);
        }
        return false;
    }
    
    // UPDATE
    private boolean UpdateCustomer(Customer customer){
        if (process.Connect()) {
             return process.UpdateCustomer(customer);
        }
        return false;
    }
    
    private boolean UpdateBillCustomer(int numberBill,int idCustomer){
        if (process.Connect()) {
             return process.UpdateBillCustomer(numberBill,idCustomer);
        }
        return false;
    }
    
    private boolean UpdateDetailBillCustomer(DetailBillCustomer detail){
        if (process.Connect()) {
             return process.UpdateDetailBillCustomer(detail);
        }
        return false;
    }
    
     // DELETE 
    private boolean DeleteBillCustomer(String numberBill){
        if (process.Connect()) {
             return process.DeleteData("HOADON","SOHD",numberBill);
        }
        return false;
    }
    
    private boolean DeleteCustomer(String idCustomer){
        if (process.Connect()) {
             return process.DeleteData("KHACHHANG","MAKH",idCustomer);
        }
        return false;
    }
    
    private boolean DeleteDetailBillCustomer(String numberBill){
        if (process.Connect()) {
             return process.DeleteData("CTHOADON","SOHD",numberBill);
        }
        return false;
    }
    
    private boolean DeleteOneDetail(String tableName,String[] columns,int numberBill,int idProduct){
        if (process.Connect()) {
             return process.DeleteOneDetail(tableName,columns,numberBill,idProduct);
        }
        return false;
    }
    
    // SET SUITABLE INTERFACE 
    private void setLabelEnable(boolean update,boolean delete){
        updateLabel.setEnabled(update);
        deleteLabel.setEnabled(delete);
    }
    
    private void setPanelVisible(boolean isList,boolean isAdd){
        listPanel.setVisible(isList);
        addPanel.setVisible(isAdd);
    }
    
    private void setSelectedLabel(boolean selectedListLabel,boolean selectedAddLabel,boolean selectedUpdateLabel){
        if (selectedListLabel) {
            listLabel.setBackground(Color.WHITE);
            addLabel.setBackground(GREEN_LIGHT);
            updateLabel.setBackground(GREEN_LIGHT);
            setPanelVisible(true, false);
            setLabelEnable(false,false);
            billCustomerTable.clearSelection();
        }
        if (selectedAddLabel) {
            listLabel.setBackground(GREEN_LIGHT);
            addLabel.setBackground(Color.WHITE);
            updateLabel.setBackground(GREEN_LIGHT);
            setPanelVisible(false, true);
            setLabelEnable(false,false);

        }
        if (selectedUpdateLabel) {
            listLabel.setBackground(GREEN_LIGHT);
            addLabel.setBackground(GREEN_LIGHT);
            updateLabel.setBackground(Color.WHITE);
            setPanelVisible(false, true);
            setLabelEnable(true,false);
        }
        
    }
    
    // RESET INFORMATION
    private void resetInfo(){
        modelProduct.setRowCount(0);
        listDetailBillCustomer.clear();
        tfAddress.setText("");
        tfAmount.setText("");
        tfNameCustomer.setText("");
        tfPhone.setText("");
        lblTotalValue.setText("");
    }
    
     // VALIDATE INFORMATION
    private boolean validateProduct(){
        if (tfAmount.getText().equals("")) {
            return true;
        }
        return false;
    }
    
    private boolean validateCustomer(){
        if (tfAddress.getText().equals("") || tfNameCustomer.getText().equals("") ||
            tfPhone.getText().equals("") || listDetailBillCustomer.size() < 1
                ) {
            return true;
        }
        return false;
    }
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
            java.util.logging.Logger.getLogger(BillCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillCustomerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new BillCustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JPanel addPanel;
    private javax.swing.JTable billCustomerTable;
    private javax.swing.JComboBox<String> cbProduct;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JTextField diachinccTextField1;
    private javax.swing.JTextField dongiaTextField1;
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JTextField faxTextField1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblTotalValue;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel listLabel;
    private javax.swing.JPanel listPanel;
    private javax.swing.JTextField maspTextField1;
    private javax.swing.JTable productTable;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField sdtTextField1;
    private javax.swing.JTextField soluongTextField1;
    private javax.swing.JTextField sopnTextField1;
    private javax.swing.JTextField tennccTextField1;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfAmount;
    private javax.swing.JTextField tfNameCustomer;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JButton themSPButton1;
    private javax.swing.JPanel topPanel;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
