package com.invest.platform.entity;

import com.invest.lib.config.NotNullAndNotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long investmentId;
    @NotNullAndNotEmpty
    String analyst;
    @NotNullAndNotEmpty
    String stock;
    @NotNullAndNotEmpty
    String stockReferenceId;
    float buyPrice;
    float sellPrice;
    LocalDateTime dateOfIssue;
    @Enumerated(EnumType.STRING)
    InvestmentType investmentType;

    public long getInvestmentId() {
        return investmentId;
    }

    public void setInvestmentId(long investmentId) {
        this.investmentId = investmentId;
    }

    public void setDateOfIssue() {
        this.dateOfIssue = LocalDateTime.now();
    }

    public String getAnalyst() {
        return analyst;
    }

    public void setAnalyst(String analyst) {
        this.analyst = analyst;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getStockReferenceId() {
        return stockReferenceId;
    }

    public void setStockReferenceId(String stockReferenceId) {
        this.stockReferenceId = stockReferenceId;
    }

    public float getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(float buyPrice) {
        this.buyPrice = buyPrice;
    }

    public float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public LocalDateTime getDateOfIssue() {
        return dateOfIssue;
    }

    public InvestmentType getInvestmentType() {
        return investmentType;
    }

    public void setInvestmentType(InvestmentType investmentType) {
        this.investmentType = investmentType;
    }
}
