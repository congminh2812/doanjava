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
public class Employee {
    public static final String TABLE_NAME = "NHANVIEN";
    
    private String idEmployee;
    private String name;
    private int gender;
    private String phone;
    private String address;
    private byte[] image;
    private Date dateWork;
    private String pass;
    private int salary;
    private int authority;

    public Employee(String idEmployee, String name, int gender, String phone, String address, byte[] image, Date dateWork, String pass, int salary, int authority) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.dateWork = dateWork;
        this.pass = pass;
        this.salary = salary;
        this.authority = authority;
    }

    public static String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public byte[] getImage() {
        return image;
    }

    public Date getDateWork() {
        return dateWork;
    }

    public String getPass() {
        return pass;
    }

    public int getSalary() {
        return salary;
    }

    public int getAuthority() {
        return authority;
    }

   
    
}
