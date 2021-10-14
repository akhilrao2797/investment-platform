package com.invest.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;

@Entity
public class Trader extends Person {

    @JsonIgnore
    boolean paidUser;

    public boolean isPaidUser() {
        return paidUser;
    }

    public void setPaidUser(boolean paidUser) {
        this.paidUser = paidUser;
    }
}
