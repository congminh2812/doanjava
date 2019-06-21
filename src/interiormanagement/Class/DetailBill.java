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
public class DetailBill {
    public static final String TABLE_NAME = "CTPHIEUNHAP";
    
    private int sopn;
    private int masp;
    private int dongia;
    private int soluong;

    public DetailBill(int sopn, int masp, int dongia, int soluong) {
        this.sopn = sopn;
        this.masp = masp;
        this.dongia = dongia;
        this.soluong = soluong;
    }

    public void setMasp(int masp) {
        this.masp = masp;
    }

    public void setDongia(int dongia) {
        this.dongia = dongia;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getSopn() {
        return sopn;
    }

    public void setSopn(int sopn) {
        this.sopn = sopn;
    }
    
    public int getMasp() {
        return masp;
    }

    public int getDongia() {
        return dongia;
    }

    public int getSoluong() {
        return soluong;
    }
    
    
}
