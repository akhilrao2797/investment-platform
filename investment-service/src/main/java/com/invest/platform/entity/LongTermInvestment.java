package com.invest.platform.entity;

import javax.persistence.Entity;

@Entity
public class LongTermInvestment extends Investment {

    public LongTermInvestment getInvestmentObjectFromValue(Investment investment){
        this.buyPrice = investment.getBuyPrice();
        this.sellPrice = investment.getSellPrice();
        this.setDateOfIssue();
        this.analyst = investment.getAnalyst();
        this.investmentType = InvestmentType.LONG_TERM_INVESTMENT;
        this.stock = investment.getStock();
        this.stockReferenceId = investment.getStockReferenceId();
        return this;
    }
}
