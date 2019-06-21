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
public class DetailBillCustomer {
    public static final String TABLE_NAME = "CTHOADON";
    
    private int idBillCustomer;
    private int idProduct;
    private int cost;
    private int amount;

    public DetailBillCustomer(int idBillCustomer, int idProduct, int cost, int amount) {
        this.idBillCustomer = idBillCustomer;
        this.idProduct = idProduct;
        this.cost = cost;
        this.amount = amount;
    }

    public void setIdBillCustomer(int idBillCustomer) {
        this.idBillCustomer = idBillCustomer;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getIdBillCustomer() {
        return idBillCustomer;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getCost() {
        return cost;
    }

    public int getAmount() {
        return amount;
    }
    
}
