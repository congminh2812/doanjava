/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement.View;

import interiormanagement.Class.DetailBill;
import interiormanagement.Class.DetailBillCustomer;
import interiormanagement.Class.Employee;
import interiormanagement.Class.ImportBill;
import interiormanagement.Class.Product;
import interiormanagement.Class.Supplier;
import interiormanagement.ContentProvider;
import interiormanagement.Controller.ProcessDatabase;
import static interiormanagement.View.EmployeeFrame.TABLE_NAME;
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
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;



/**
 *
 * @author ASUS
 */
public class ImportProductFrame extends javax.swing.JFrame {
    public static final String TABLE_NAME = "PHIEUNHAP";
    public final Color GREEN_LIGHT = new Color(95, 212, 197);
    
    private final String[] titlesImportBill = {"Số Phiếu","Ngày Nhập","Nhà Cung Cấp"};
    private final String[] titlesProduct = {"STT","Tên Sản Phẩm","Giá Mua (VND)","Số Lượng","Thành Tiền (VND)"};

    private ProcessDatabase process; 
    
    private ArrayList<Product> listProduct;
    private ArrayList<ImportBill> listImport;
    private ArrayList<DetailBill> listDetail;
    private ArrayList<DetailBill> listNewDetailBill;
    private ArrayList<Supplier> listSupplier;
    
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private boolean addOrUpdate = false; // false : add , true : update
    private boolean checkSupplier = false; //false : not exist, true: exist
    
    private int index;

    /**
     * Creates new form EnterProductFrame
     */
    public ImportProductFrame() {
        initComponents();
        setLocationRelativeTo(null);        
        setTitle("Quản lý cửa hàng nội thất DreamHouse");
        // set icon jframe
        ContentProvider.Logo(this);

        setLabelEnable(false, false);
        setSelectedLabel(true, false, false);
        
        process = ContentProvider.process;
        listProduct = new ArrayList<>();
        listImport = new ArrayList<>();
        listDetail = new ArrayList<>();
        listNewDetailBill = new ArrayList<>();
        listSupplier = new ArrayList<>();
        assignListProduct();
        assignListSupplier();
        
        for(Product product: listProduct){
            cbName.addItem(product.getTensp());
        }
        
        model = (DefaultTableModel) importBillTable.getModel();
        model2 = (DefaultTableModel) importTable.getModel();
        model.setColumnIdentifiers(titlesImportBill);
        model2.setColumnIdentifiers(titlesProduct);
        
        ShowImportBill();
        
        importBillTable.setDefaultEditor(Object.class, null);
        importBillTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (importBillTable.getSelectedRow() > -1) {
                    setLabelEnable(true,true);
                    index = importBillTable.getSelectedRow();
                }
            }
        });
        
        updateButton.setEnabled(false);
        importTable.setDefaultEditor(Object.class, null);
        importTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int index = importTable.getSelectedRow();
                if (index > -1) {
                    cbName.setSelectedItem(model2.getValueAt(index, 1));
                    if (addOrUpdate) {
                        updateButton.setEnabled(true);
                    }
                    deleteButton.setEnabled(true);

                    tfCost.setText(listDetail.get(index).getDongia()+"");
                    tfAmount.setText(listDetail.get(index).getSoluong()+"");
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
        jPanel1 = new javax.swing.JPanel();
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
        importBillTable = new javax.swing.JTable();
        addPanel = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        acceptButton = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbName = new javax.swing.JComboBox<>();
        jPanel19 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfCost = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfAmount = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel24 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        checkButton = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        tfPhone = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        jPanel28 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        tfFax = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        importTable = new javax.swing.JTable();

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
        jLabel1.setText("PHIẾU NHẬP");
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

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
        deleteLabel.setText("Xóa Phiếu");
        deleteLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteLabel.setOpaque(true);
        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteLabelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                deleteLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(updateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addContainerGap(468, Short.MAX_VALUE))
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
                .addContainerGap(465, Short.MAX_VALUE))
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
            .addGap(0, 695, Short.MAX_VALUE)
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
            .addGap(0, 695, Short.MAX_VALUE)
        );

        listPanel.add(jPanel11, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        importBillTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(importBillTable);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 682, Short.MAX_VALUE)
                .addContainerGap())
        );

        listPanel.add(jPanel5, java.awt.BorderLayout.CENTER);

        rightPanel.add(listPanel, "card2");

        addPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel14.setLayout(new java.awt.BorderLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new java.awt.GridLayout(2, 0));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(834, 50));

        jLabel3.setText("Tổng Giá Trị");

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("Số Tiền");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(436, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
            .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel15.add(jPanel13);

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setPreferredSize(new java.awt.Dimension(834, 50));
        jPanel16.setLayout(new java.awt.GridLayout(1, 0, 10, 0));
        jPanel16.add(jLabel12);

        acceptButton.setText("CHẬP NHẬN");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });
        jPanel16.add(acceptButton);

        jPanel15.add(jPanel16);

        jPanel14.add(jPanel15, java.awt.BorderLayout.PAGE_END);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setPreferredSize(new java.awt.Dimension(500, 45));
        jPanel18.setLayout(new java.awt.GridLayout(1, 2));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Tên Sản Phẩm");
        jLabel8.setOpaque(true);
        jPanel18.add(jLabel8);

        jPanel18.add(cbName);

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(187, 44));
        jPanel19.setLayout(new java.awt.GridLayout(1, 0));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Đơn Giá");
        jLabel7.setOpaque(true);
        jPanel19.add(jLabel7);

        tfCost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfCostKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfCostKeyTyped(evt);
            }
        });
        jPanel19.add(tfCost);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setPreferredSize(new java.awt.Dimension(331, 44));
        jPanel20.setLayout(new java.awt.GridLayout(1, 0));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Số Lượng");
        jLabel10.setOpaque(true);
        jPanel20.add(jLabel10);

        tfAmount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfAmountKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAmountKeyTyped(evt);
            }
        });
        jPanel20.add(tfAmount);

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(241, 44));
        jPanel21.setLayout(new java.awt.GridLayout(1, 0));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setOpaque(true);
        jPanel21.add(jLabel15);

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setLayout(new java.awt.GridLayout(1, 0));

        updateButton.setText("Cập Nhật");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        jPanel22.add(updateButton);

        addButton.setText("Thêm ");
        addButton.setPreferredSize(new java.awt.Dimension(127, 44));
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel22.add(addButton);

        deleteButton.setText("XÓA");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel22.add(deleteButton);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
            .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.add(jPanel17);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));
        jPanel23.setPreferredSize(new java.awt.Dimension(450, 249));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setPreferredSize(new java.awt.Dimension(500, 45));
        jPanel24.setLayout(new java.awt.GridLayout(1, 0));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nhà Cung");
        jPanel24.add(jLabel6);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText(" Cấp");
        jLabel21.setOpaque(true);
        jPanel24.add(jLabel21);

        tfName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNameKeyTyped(evt);
            }
        });
        jPanel24.add(tfName);

        checkButton.setText("Kiểm Tra");
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });
        jPanel24.add(checkButton);

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setPreferredSize(new java.awt.Dimension(367, 44));
        jPanel25.setLayout(new java.awt.GridLayout(1, 0));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Địa Chỉ ");
        jLabel22.setOpaque(true);
        jPanel25.add(jLabel22);

        tfAddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAddressKeyTyped(evt);
            }
        });
        jPanel25.add(tfAddress);

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setPreferredSize(new java.awt.Dimension(145, 44));
        jPanel26.setLayout(new java.awt.GridLayout(1, 0));

        jLabel23.setBackground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("SĐT");
        jLabel23.setOpaque(true);
        jPanel26.add(jLabel23);

        tfPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPhoneKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfPhoneKeyTyped(evt);
            }
        });
        jPanel26.add(tfPhone);

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.setPreferredSize(new java.awt.Dimension(374, 44));
        jPanel27.setLayout(new java.awt.GridLayout(1, 0));

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Email");
        jLabel24.setOpaque(true);
        jPanel27.add(jLabel24);

        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEmailKeyTyped(evt);
            }
        });
        jPanel27.add(tfEmail);

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setPreferredSize(new java.awt.Dimension(209, 44));
        jPanel28.setLayout(new java.awt.GridLayout(1, 0));

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Fax");
        jLabel25.setOpaque(true);
        jPanel28.add(jLabel25);

        tfFax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                none(evt);
            }
        });
        tfFax.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfFaxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFaxKeyTyped(evt);
            }
        });
        jPanel28.add(tfFax);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel12.add(jPanel23);

        importTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(importTable);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel14.add(jPanel6, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 821, Short.MAX_VALUE)
                .addContainerGap())
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                for(Product product : listProduct){
                    String nameProduct = (String) cbName.getSelectedItem();
                    if (nameProduct.equals(product.getTensp())) {
                        idProduct = product.getMasp();
                    }
                }
                DetailBill detail = new DetailBill(0, idProduct, 
                        Integer.parseInt(tfCost.getText()), 
                        Integer.parseInt(tfAmount.getText()));

                if (addOrUpdate) {
                    detail.setSopn(listImport.get(importBillTable.getSelectedRow()).getSopn());
                    listNewDetailBill.add(detail);
                }
                
                listDetail.add(detail);
                
                AddRowEnterProduct(listDetail);
            }
        }else
            JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập số liệu !");
        
    }//GEN-LAST:event_addButtonActionPerformed

    private void tfPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPhoneKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE || tfPhone.getText().length() > 11)
            evt.consume();
    }//GEN-LAST:event_tfPhoneKeyTyped

    private void none(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_none
        // TODO add your handling code here:
    }//GEN-LAST:event_none

    private void listLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listLabelMousePressed
       setSelectedLabel(true,false,false);
    }//GEN-LAST:event_listLabelMousePressed

    private void addLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLabelMousePressed
        updateButton.setVisible(false);
        deleteButton.setEnabled(false);
        checkButton.setEnabled(true);
        
        listDetail.clear();  // reset info enterTable
        resetInfo(); // reset info textfield
        setSelectedLabel(false,true,false);
        addOrUpdate = false;
    }//GEN-LAST:event_addLabelMousePressed

    private void updateLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateLabelMousePressed
        if (importBillTable.getSelectedRow() > -1) {
            updateButton.setVisible(true);
            deleteButton.setEnabled(false);
            updateButton.setEnabled(false);
            checkButton.setEnabled(false);
            
            listNewDetailBill.clear();
            setSelectedLabel(false,false,true);
            ShowInfoBill();
            addOrUpdate = true;
        }
    }//GEN-LAST:event_updateLabelMousePressed

    private void deleteLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMousePressed
        int index = importBillTable.getSelectedRow();
        if (index > -1) {
            int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                listDetail.clear();
                listDetail = getDetailBill(listImport.get(index).getSopn());
                
                boolean check = true;
                for(DetailBill detail : listDetail){
                    String[] columns = new String[2];
                    columns[0] = "SOPN";
                    columns[1] = "MASP";
                    if (!DeleteOneDetail(DetailBill.TABLE_NAME,columns,detail.getSopn(),detail.getMasp())) {
                        check = false;
                        break;
                    }

                }
               
                if (check) {
                    DeleteImportBill(String.valueOf(listImport.get(index).getSopn()));
                
                    int check2 = 0;
                    for(ImportBill importBill : listImport){
                       if (listImport.get(index).getMancc() == importBill.getMancc()) {
                           check2 += 1;
                       }
                    }
                    if (!(check2 == 2)) {
                        DeleteSupplier(String.valueOf(listImport.get(index).getMancc()));
                    }

                    JOptionPane.showMessageDialog(rootPane, "Xóa Thành Công!");
                    
                    assignListSupplier();
                    
                    ShowImportBill();
                }else
                    JOptionPane.showMessageDialog(rootPane, "Sản phẩm đã được bán không thể xóa!");
               
                process.CloseConnect();
            }
        }
    }//GEN-LAST:event_deleteLabelMousePressed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int position = importTable.getSelectedRow();
        
        int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không?","Thông báo",JOptionPane.YES_NO_OPTION);
            if (result == 0) {
                String[] columns = new String[2];
                columns[0] = "SOPN";
                columns[1] = "MASP";
                
                if (addOrUpdate) {
                    DeleteOneDetail(DetailBill.TABLE_NAME,columns,listImport.get(index).getSopn(),listDetail.get(position).getMasp());
                }
                
                listDetail.remove(position);
                removeSelectedFromTable(importTable);
                AddRowEnterProduct(listDetail);
                
                deleteButton.setEnabled(false);
                updateButton.setEnabled(false);
                addButton.setEnabled(true);
                cbName.setEnabled(true);
                tfCost.setText("");
                tfAmount.setText("");
            }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed
        if (!validateSupplier()) {
            if (ContentProvider.validEmail(tfEmail.getText())) {
                if (!addOrUpdate) {
                    AcceptAdd();
                }else
                    AcceptUpdate();
            }else
                JOptionPane.showMessageDialog(rootPane, "Email không đúng định dạng !");
        }else
             JOptionPane.showMessageDialog(rootPane, "Bạn chưa nhập đủ thông tin!");
    }//GEN-LAST:event_acceptButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        int index = importTable.getSelectedRow();
        if (index > -1) {
            DetailBill detail = listDetail.get(index);
            detail.setDongia(Integer.parseInt(tfCost.getText()));
            detail.setSoluong(Integer.parseInt(tfAmount.getText()));
            listDetail.set(index, detail);
            AddRowEnterProduct(listDetail);
            
            cbName.setEnabled(true);
            deleteButton.setEnabled(false);
            importTable.clearSelection();
            updateButton.setEnabled(false);
            addButton.setEnabled(true);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void tfFaxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFaxKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE || tfFax.getText().length() > 10)
            evt.consume();
    }//GEN-LAST:event_tfFaxKeyTyped

    private void tfCostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCostKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE) || c== KeyEvent.VK_DELETE || tfCost.getText().length() > 8)
            evt.consume();
    }//GEN-LAST:event_tfCostKeyTyped

    private void tfAmountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAmountKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE ) || c== KeyEvent.VK_DELETE || tfAmount.getText().length() > 3)
            evt.consume();
    }//GEN-LAST:event_tfAmountKeyTyped

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        checkSupplier = false;
        for(Supplier sp : listSupplier){
            if (tfName.getText().toLowerCase().equals(sp.getTenncc().toLowerCase())) {
                tfName.setText(sp.getTenncc());
                tfAddress.setText(sp.getDiachincc());
                tfPhone.setText(sp.getSdt());
                tfEmail.setText(sp.getEmail());
                tfFax.setText(sp.getFax()+"");
                checkSupplier = true;
            }
        }
        if (!checkSupplier) {
            JOptionPane.showMessageDialog(rootPane, "Nhà Cung Cấp không tồn tại!");
            tfAddress.setText("");
            tfEmail.setText("");
            tfPhone.setText("");
            tfFax.setText("");
        }
    }//GEN-LAST:event_checkButtonActionPerformed

    private void tfNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameKeyTyped
        char c = evt.getKeyChar();
        if(tfAmount.getText().length() > 80)
            evt.consume();
    }//GEN-LAST:event_tfNameKeyTyped

    private void tfAddressKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAddressKeyTyped
         char c = evt.getKeyChar();
        if(tfAmount.getText().length() > 80)
            evt.consume();
    }//GEN-LAST:event_tfAddressKeyTyped

    private void tfEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyTyped
        char c = evt.getKeyChar();
        if(tfAmount.getText().length() > 80)
            evt.consume();
    }//GEN-LAST:event_tfEmailKeyTyped

    private void tfCostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCostKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            evt.consume();
        }
    }//GEN-LAST:event_tfCostKeyPressed

    private void tfAmountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAmountKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            evt.consume();
        }
    }//GEN-LAST:event_tfAmountKeyPressed

    private void tfFaxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFaxKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            evt.consume();
        }
    }//GEN-LAST:event_tfFaxKeyPressed

    private void tfPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPhoneKeyPressed
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {
            evt.consume();
        }
    }//GEN-LAST:event_tfPhoneKeyPressed

    private void deleteLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseEntered
        deleteLabel.setBackground(Color.WHITE);
    }//GEN-LAST:event_deleteLabelMouseEntered

    private void deleteLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteLabelMouseExited
        deleteLabel.setBackground(GREEN_LIGHT);
    }//GEN-LAST:event_deleteLabelMouseExited

    private void SearchData(){
        ArrayList<ImportBill> searchList = new ArrayList<>();
        for(ImportBill importBill : listImport){
            if (String.valueOf(importBill.getNgayNhap()).contains(tfSearch.getText()) || 
                    getOneSupplier(importBill.getMancc()).getTenncc().toLowerCase().contains(tfSearch.getText().toLowerCase())) {
                searchList.add(importBill);
            }
        }
        
        if(tfSearch.getText().equals("")){
            searchList = listImport;
        }
        
         model.setRowCount(0);
         AddRowImportBill(searchList);
    }
    
    private boolean CheckProductInEnterTable(){
        int idProduct = getIdProduct();
        
        for(DetailBill detail : listDetail){
            if (detail.getMasp() == idProduct) {
                return true;
            }
        }
        
        return false;
    }
    
    private int getIdProduct(){
        for(Product product : listProduct){
                String nameProduct = (String) cbName.getSelectedItem();
                if (nameProduct.equals(product.getTensp())) {
                    return product.getMasp();
                }
            }
        return 0;
    }
    
    private void AcceptAdd(){
        int id = 0;
        Supplier supplier = null;
        for(Supplier sp : listSupplier){
            if (sp.getTenncc().toLowerCase().equals(tfName.getText().toLowerCase())) {
                supplier = sp;
                id = sp.getMancc();
            }
        }
        supplier = new Supplier(0,
                tfName.getText(), 
                tfAddress.getText(),
                tfPhone.getText(), 
                tfEmail.getText(),
                tfFax.getText());
        
        if (!checkSupplier) {
            if (InsertSupplier(supplier)) {
                id = getNewSupplier().getMancc();
                AddSuccessfully(id);
            }else{
                JOptionPane.showMessageDialog(rootPane, "Thông tin bạn nhập quá dài!");
            }
        }else{
            supplier.setMancc(id);
            if (UpdateSupplier(supplier)) {
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
       
        InsertImportBill(date, id);
        process.CloseConnect();

        int numberBill = getNewImportBill().getSopn();

        for(DetailBill detail : listDetail){
            detail.setSopn(numberBill);
            InsertDetailBill(detail);
        }
        process.CloseConnect();

        JOptionPane.showMessageDialog(rootPane, "Thêm Thành Công!");

        assignListSupplier();
        
        ShowImportBill();
        setSelectedLabel(true, false, false);
    }
    
    private void AcceptUpdate(){
        int index = importBillTable.getSelectedRow();
        
        boolean check = false;
        int id = 0;
        for(Supplier sup : listSupplier){
            if (tfName.getText().toLowerCase().equals(sup.getTenncc().toLowerCase())) {
                check = true;
                id = sup.getMancc();
            }
        }
        Supplier sp = new Supplier(listImport.get(index).getMancc(),
                tfName.getText(), 
                tfAddress.getText(),
                tfPhone.getText(), 
                tfEmail.getText(),
                tfFax.getText());
        
        for(DetailBill detail : listNewDetailBill){
            InsertDetailBill(detail);
        }
        
        if (check) {
            UpdateImportBill(listImport.get(index).getSopn(),id);
            sp.setMancc(id);
            if (!UpdateSupplier(sp)) {
                JOptionPane.showMessageDialog(rootPane, "Nhà cung cấp không sửa được do thông tin quá dài!");
            }
           
        }else
            if (!UpdateSupplier(sp)) {
                JOptionPane.showMessageDialog(rootPane, "Nhà cung cấp không sửa được do thông tin quá dài!");
            }
        
        int numberBill = listImport.get(index).getSopn();
        for(DetailBill detail : listDetail){
            detail.setSopn(numberBill);
            UpdateDetailBill(detail);
        }
        process.CloseConnect();

        JOptionPane.showMessageDialog(rootPane, "Cập Nhật Thành Công!");
        
        ShowImportBill();
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
    
    private void ShowInfoBill(){
        model2.setRowCount(0);
        listDetail.clear();
        listSupplier.clear();
        assignListSupplier();
        
        int index = importBillTable.getSelectedRow();
        listDetail = getDetailBill(listImport.get(index).getSopn());

        Supplier sp = getOneSupplier(listImport.get(index).getMancc());
        tfName.setText(sp.getTenncc());
        tfAddress.setText(sp.getDiachincc());
        tfPhone.setText(sp.getSdt());
        tfEmail.setText(sp.getEmail());
        tfFax.setText(sp.getFax()+"");

        AddRowEnterProduct(listDetail);
        process.CloseConnect();
    }

    private ArrayList<DetailBill> getDetailBill(int numberBill){
        if (process.Connect()) {
            return process.getDetailBill(numberBill);
        }
        return null;
    }

    private void ShowImportBill(){
        model.setRowCount(0);
        listImport.clear();

        ResultSet result = ContentProvider.getList(ImportBill.TABLE_NAME);
        try {
            while(result.next()){
                 listImport.add(new ImportBill(result.getInt("SOPN"), result.getDate("NGAYNHAP"), result.getInt("MANCC")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
       AddRowImportBill(listImport);
       process.CloseConnect();
    }

    private void AddRowImportBill(ArrayList<ImportBill> list){
        for(ImportBill importBill : list){
            Supplier sp = getOneSupplier(importBill.getMancc());
            model.addRow(new Object[]{
                importBill.getSopn(),
                importBill.getNgayNhap(),
                sp.getTenncc()
            });
        }
    }

    private void AddRowEnterProduct(ArrayList<DetailBill> details){
        model2.setRowCount(0);
        int stt = 1;
        long total = 0L;

        for(DetailBill detail : details){
            String nameProduct = "";
            for(Product product : listProduct){
                if (detail.getMasp() == product.getMasp()) {
                    nameProduct = product.getTensp();
                }
            }
            model2.addRow(new Object[]{
                stt,
                nameProduct,
                ContentProvider.numberFormat.format(detail.getDongia()),
                ContentProvider.numberFormat.format(detail.getSoluong()),
                ContentProvider.numberFormat.format((long)detail.getDongia() * (long)detail.getSoluong())
            });
            stt++;
            total += ((long)detail.getDongia() * (long)detail.getSoluong());
        }

        lblTotal.setText(ContentProvider.numberFormat.format(total) + " VND");
    }

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
    
    private void assignListSupplier(){
        listSupplier.clear();
        ResultSet result = ContentProvider.getList(Supplier.TABLE_NAME);
        try {
            while(result.next()){
                listSupplier.add(new Supplier(result.getInt("MANCC"),
                        result.getString("TENNCC"), 
                        result.getString("DIACHI"), 
                        result.getString("SDT"), 
                        result.getString("EMAIL"), 
                        result.getString("FAX"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        process.CloseConnect();
    }
    
    private ImportBill getNewImportBill(){
         if (process.Connect()) {
             return process.getNewImportBill();
        }
        return null;
    }
    
    private Supplier getNewSupplier(){
         if (process.Connect()) {
             return process.getNewSupplier();
        }
        return null;
    }
    
    private Supplier getOneSupplier(int maNCC){
         if (process.Connect()) {
            return process.getOneSupplier(maNCC);
        }
        return null;
    }
    
    
    // INSERT
    private boolean InsertSupplier(Supplier sp){
        if (process.Connect()) {
             return process.InsertSupplier(sp);
        }
        return false;
    }
    
    private boolean InsertImportBill(Date dateImport,int idSupplier){
        if (process.Connect()) {
             return process.InsertImportBill(dateImport,idSupplier);
        }
        return false;
    }
    
    private boolean InsertDetailBill(DetailBill detail){
        if (process.Connect()) {
             return process.InsertDetailBill(detail);
        }
        return false;
    }
    
    // UPDATE
    private boolean UpdateSupplier(Supplier sp){
        if (process.Connect()) {
             return process.UpdateSupplier(sp);
        }
        return false;
    }
    
    private boolean UpdateImportBill(int numberBill,int idSupplier){
        if (process.Connect()) {
             return process.UpdateImportBill(numberBill,idSupplier);
        }
        return false;
    }
    
    private boolean UpdateDetailBill(DetailBill detail){
        if (process.Connect()) {
             return process.UpdateDetailBill(detail);
        }
        return false;
    }
    
    // DELETE 
    private boolean DeleteImportBill(String numberBill){
        if (process.Connect()) {
             return process.DeleteData("PHIEUNHAP","SOPN",numberBill);
        }
        return false;
    }
    
    private boolean DeleteSupplier(String idSupplier){
        if (process.Connect()) {
             return process.DeleteData("NHACC","MANCC",idSupplier);
        }
        return false;
    }
    
    private boolean DeleteDetailBill(String numberBill){
        if (process.Connect()) {
             return process.DeleteData("CTPHIEUNHAP","SOPN",numberBill);
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
    
    private void setPanelVisible(boolean list,boolean add){
        listPanel.setVisible(list);
        addPanel.setVisible(add);
    }
    
    private void setSelectedLabel(boolean selectedListLabel,boolean selectedAddLabel,boolean selectedUpdateLabel){
        if (selectedListLabel) {
            listLabel.setBackground(Color.WHITE);
            addLabel.setBackground(GREEN_LIGHT);
            updateLabel.setBackground(GREEN_LIGHT);
            setPanelVisible(true, false);
            setLabelEnable(false,false);
            importBillTable.clearSelection();
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
        model2.setRowCount(0);
        tfCost.setText("");
        tfAmount.setText("");
        tfAddress.setText("");
        tfEmail.setText("");
        tfPhone.setText("");
        tfFax.setText("");
        tfName.setText("");
        lblTotal.setText("");
    }
    
    // VALIDATE INFORMATION
    private boolean validateProduct(){
        if (tfCost.getText().equals("") || tfAmount.getText().equals("")) {
            return true;
        }
        return false;
    }
    
    private boolean validateSupplier(){
        if (tfName.getText().equals("") || tfAddress.getText().equals("") ||
            tfPhone.getText().equals("") || tfEmail.getText().equals("") || 
            tfFax.getText().equals("") || listDetail.size() < 1
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
            java.util.logging.Logger.getLogger(ImportProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportProductFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportProductFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton addButton;
    private javax.swing.JLabel addLabel;
    private javax.swing.JPanel addPanel;
    private javax.swing.JComboBox<String> cbName;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel deleteLabel;
    private javax.swing.JTextField diachinccTextField1;
    private javax.swing.JTextField dongiaTextField1;
    private javax.swing.JTextField emailTextField1;
    private javax.swing.JTextField faxTextField1;
    private javax.swing.JTable importBillTable;
    private javax.swing.JTable importTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JLabel listLabel;
    private javax.swing.JPanel listPanel;
    private javax.swing.JTextField maspTextField1;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField sdtTextField1;
    private javax.swing.JTextField soluongTextField1;
    private javax.swing.JTextField sopnTextField1;
    private javax.swing.JTextField tennccTextField1;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfAmount;
    private javax.swing.JTextField tfCost;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfFax;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhone;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JButton themSPButton1;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel updateLabel;
    // End of variables declaration//GEN-END:variables
}
