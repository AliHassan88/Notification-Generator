package com.kravia.notificationgenerator.debtor;

import javax.persistence.*;

@Entity
@Table(name = "Debtor")
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    Boolean defaulterStatus;

    public Debtor() {
    }

    public Debtor(String name, String address, Boolean defaulterStatus) {
        this.name = name;
        this.address = address;
        this.defaulterStatus = defaulterStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getDefaulterStatus() {
        return defaulterStatus;
    }

    public void setDefaulterStatus(Boolean defaulterStatus) {
        this.defaulterStatus = defaulterStatus;
    }
}
