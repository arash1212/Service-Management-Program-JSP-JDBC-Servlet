package com.salehi.programming_challenge__1.model.entity;

public class Service_vaset {
    private Long user_id;
    private Long service_id;

    public Long getUser_id() {
        return user_id;
    }

    public Service_vaset setUser_id(Long user_id) {
        this.user_id = user_id;
        return this;
    }

    public Long getService_id() {
        return service_id;
    }

    public Service_vaset setService_id(Long service_id) {
        this.service_id = service_id;
        return this;
    }
}
