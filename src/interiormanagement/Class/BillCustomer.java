/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement.Class;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class BillCustomer {
    public static final String TABLE_NAME = "HOADON";
    
    private int id;
    private Date exportDate;
    private String idEmployee;
    private int idCustomer;

    public BillCustomer(int id, Date exportDate, String idEmployee, int idCustomer) {
        this.id = id;
        this.exportDate = exportDate;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
    }

    public int getId() {
        return id;
    }

    public Date getExportDate() {
        return exportDate;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer;
    }
    
    
}
