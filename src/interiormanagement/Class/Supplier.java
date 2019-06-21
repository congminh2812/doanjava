/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interiormanagement.Class;

/**
 *
 * @author ASUS
 */
public class Supplier {
    public static final String TABLE_NAME = "NHACC";
    private int mancc;
    private String tenncc;
    private String diachincc;
    private String sdt;
    private String email;
    private String fax;

    public Supplier(int mancc, String tenncc, String diachincc, String sdt, String email, String fax) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.diachincc = diachincc;
        this.sdt = sdt;
        this.email = email;
        this.fax = fax;
    }

    public void setMancc(int mancc) {
        this.mancc = mancc;
    }

    
    public int getMancc() {
        return mancc;
    }

    public String getTenncc() {
        return tenncc;
    }

    public String getDiachincc() {
        return diachincc;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }
}
