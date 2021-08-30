package com.salehi.programming_challenge__1.model.entity;

import java.sql.Date;

public class Service {

    private Long id;
    private String name;
    private Long price;
    private int peak;
    private String startDate;
    private String endDate;
    private boolean active;

    public Long getId() {
        return id;
    }

    public Service setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Service setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPrice() {
        return price;
    }

    public Service setPrice(Long price) {
        this.price = price;
        return this;
    }

    public int getPeak() {
        return peak;
    }

    public Service setPeak(int peak) {
        this.peak = peak;
        return this;
    }

    public String getStartDate() {
        return startDate;
    }

    public Service setStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    public String getEndDate() {
        return endDate;
    }

    public Service setEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    public boolean isActive() {
        return active;
    }

    public Service setActive(boolean active) {
        this.active = active;
        return this;
    }
}
