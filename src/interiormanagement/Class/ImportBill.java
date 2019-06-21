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
public class ImportBill {
    public static final String TABLE_NAME = "PHIEUNHAP";
    
    private int sopn;
    private Date ngayNhap;
    private int mancc;

    public ImportBill(int sopn, Date ngayNhap, int mancc) {
        this.sopn = sopn;
        this.ngayNhap = ngayNhap;
        this.mancc = mancc;
    }

    public int getSopn() {
        return sopn;
    }

    public Date getNgayNhap() {
        return ngayNhap;
    }

    public int getMancc() {
        return mancc;
    }
}
