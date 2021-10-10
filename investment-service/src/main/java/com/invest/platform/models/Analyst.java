package com.invest.platform.models;

import com.invest.lib.config.NotNullAndNotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Analyst {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @NotNullAndNotEmpty
    String company;
    boolean statusActive;
    @NotNullAndNotEmpty
    String sebiRegisteredId;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public boolean isStatusActive() {
        return statusActive;
    }

    public void setStatusActive(boolean statusActive) {
        this.statusActive = statusActive;
    }

    public String getSebiRegisteredId() {
        return sebiRegisteredId;
    }

    public void setSebiRegisteredId(String sebiRegisteredId) {
        this.sebiRegisteredId = sebiRegisteredId;
    }
}
