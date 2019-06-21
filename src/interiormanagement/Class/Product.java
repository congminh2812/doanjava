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
public class Product {
    public static final String TABLE_NAME = "SANPHAM";
    
    private int masp;
    private String tensp;
    private String dvt;
    private int giaBan;
    private int amount;
    private int loaisp;

    public Product(int masp, String tensp, String dvt, int giaBan, int amount, int loaisp) {
        this.masp = masp;
        this.tensp = tensp;
        this.dvt = dvt;
        this.giaBan = giaBan;
        this.amount = amount;
        this.loaisp = loaisp;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setLoaisp(int loaisp) {
        this.loaisp = loaisp;
    }

    public int getMasp() {
        return masp;
    }

    public String getTensp() {
        return tensp;
    }

    public String getDvt() {
        return dvt;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public int getAmount() {
        return amount;
    }

    public int getLoaisp() {
        return loaisp;
    }

   

    
}
