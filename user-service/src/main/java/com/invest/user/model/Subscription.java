package com.invest.user.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long subscriptionId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Trader trader;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Analyst> analystList;

    public Subscription(){
        this.analystList = new HashSet();
    }

    public long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Set<Analyst> getAnalystList() {
        return analystList;
    }

    public void setAnalystList(Set<Analyst> analystList) {
        this.analystList = analystList;
    }
}
