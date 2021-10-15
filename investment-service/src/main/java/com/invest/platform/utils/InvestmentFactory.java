package com.invest.platform.utils;

import com.invest.platform.entity.Investment;
import com.invest.platform.entity.InvestmentType;
import com.invest.platform.entity.LongTermInvestment;
import com.invest.platform.entity.ShortTermInvestment;
import com.invest.platform.repository.LtiRepository;
import com.invest.platform.repository.StiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Component
public class InvestmentFactory {

    LtiRepository ltiRepository;
    StiRepository stiRepository;

    @Autowired
    public InvestmentFactory(LtiRepository ltiRepository,
                             StiRepository stiRepository){
        this.ltiRepository = ltiRepository;
        this.stiRepository = stiRepository;
    }

    public JpaRepository<Investment, String> getInvestmentRepository(InvestmentType type){
        JpaRepository jpaRepository = null;
        switch(type){
            case SHORT_TERM_INVESTMENT: jpaRepository = stiRepository; break;
            case LONG_TERM_INVESTMENT: jpaRepository = ltiRepository; break;
            default: throw new NoSuchElementException("Invalid investment category");
        }
        return jpaRepository;
    }

    public Investment insertData(Investment investment){
        InvestmentType investmentType = investment.getInvestmentType();
        JpaRepository<Investment, String> jpaRepository = getInvestmentRepository(investmentType);
        switch(investmentType){
            case LONG_TERM_INVESTMENT: LongTermInvestment longTermInvestment = new LongTermInvestment();
                longTermInvestment.getInvestmentObjectFromValue(investment);
                investment = (LongTermInvestment) jpaRepository.save(longTermInvestment);
                break;

            case SHORT_TERM_INVESTMENT: ShortTermInvestment shortTermInvestment = new ShortTermInvestment();
                shortTermInvestment.getInvestmentObjectFromValue(investment);
                investment = (ShortTermInvestment) jpaRepository.save(shortTermInvestment);
                break;
            default: throw new NoSuchElementException("Invalid investment category");
        }
        return investment;
    }
}
