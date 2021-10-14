package com.invest.user.model;

import com.invest.lib.config.NotNullAndNotEmpty;

import javax.persistence.Entity;

@Entity
public class Analyst extends Person {

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
