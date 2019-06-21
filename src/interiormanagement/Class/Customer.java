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
public class Customer {
    public static final String TABLE_NAME = "KHACHHANG";
    private int id;
    private String name;
    private String phone;
    private String address;

    public Customer(int id, String name, String phone, String address) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
    
}
