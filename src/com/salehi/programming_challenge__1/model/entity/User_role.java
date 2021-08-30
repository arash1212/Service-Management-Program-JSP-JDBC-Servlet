package com.salehi.programming_challenge__1.model.entity;

public class User_role {
    private Long id;
    private String role_name;
    private String address;

    public Long getId() {
        return id;
    }

    public User_role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getRole_name() {
        return role_name;
    }

    public User_role setRole_name(String role_name) {
        this.role_name = role_name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public User_role setAddress(String address) {
        this.address = address;
        return this;
    }
}
