package com.salehi.programming_challenge__1.model.entity;

public class Users {

    private Long id;
    private String username;
    private String password;
    private Long credit;
    private Long role_id;

    public Long getId() {
        return id;
    }

    public Users setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Users setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Users setPassword(String password) {
        this.password = password;
        return this;
    }

    public Long getCredit() {
        return credit;
    }

    public Users setCredit(Long credit) {
        this.credit = credit;
        return this;
    }

    public Long getRole_id() {
        return role_id;
    }

    public Users setRole_id(Long role_id) {
        this.role_id = role_id;
        return this;
    }
}
