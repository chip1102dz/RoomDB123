package com.example.roomdb;


import java.io.Serializable;

//@Entity (tableName = "User123")
public class User implements Serializable {

    //@PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phone;
    private String ngaysinh;
    private String chucvu;
    private String tinhnguyen;

    public User(String name, String phone, String ngaysinh, String chucvu, String tinhnguyen) {
        this.name = name;
        this.phone = phone;
        this.ngaysinh = ngaysinh;
        this.chucvu = chucvu;
        this.tinhnguyen = tinhnguyen;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getTinhnguyen() {
        return tinhnguyen;
    }

    public void setTinhnguyen(String tinhnguyen) {
        this.tinhnguyen = tinhnguyen;
    }
}
