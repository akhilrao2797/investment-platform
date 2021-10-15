package com.invest.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Trader extends Person {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    String traderId;

    @JsonIgnore
    boolean paidUser;

    public boolean isPaidUser() {
        return paidUser;
    }

    public void setPaidUser(boolean paidUser) {
        this.paidUser = paidUser;
    }

    public String getTraderId() {
        return traderId;
    }

    public void setTraderId(String traderId) {
        this.traderId = traderId;
    }
}
