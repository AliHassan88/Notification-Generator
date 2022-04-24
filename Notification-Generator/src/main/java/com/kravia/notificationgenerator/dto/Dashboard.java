package com.kravia.notificationgenerator.dto;

public class Dashboard {
    private String address;
    private Integer count;
    private String status;

    public Dashboard() {
    }

    public Dashboard(String address, Integer count, String status) {
        this.address = address;
        this.count = count;
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
