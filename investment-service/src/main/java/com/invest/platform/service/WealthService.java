package com.invest.platform.service;

import com.invest.platform.entity.Investment;
import com.invest.platform.entity.InvestmentType;
import com.invest.platform.model.Analyst;
import com.invest.platform.utils.InvestmentFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class WealthService {

    private InvestmentFactory investmentFactory;
    private RestTemplate restTemplate;
    private Logger LOG;

    @Autowired
    WealthService(InvestmentFactory investmentFactory, RestTemplate restTemplate){
        this.investmentFactory = investmentFactory;
        this.restTemplate = restTemplate;
        LOG = LoggerFactory.getLogger(WealthService.class);
    }

    public Investment addInvestmentInfo(Investment investment) throws Exception {
        LOG.debug("Entered InvestmentService.addInvestmentInfo");

        try {
            String analystURL = "http://USER-SERVICE/user-sub/v1/user('" + investment.getAnalyst() + "')?type=ANALYST";
            Analyst analyst = restTemplate
                    .getForObject(analystURL, Analyst.class);
        } catch(Exception ex){
            throw new Exception(ex);
        }

        investment = investmentFactory.insertData(investment);
        if(Long.valueOf(investment.getInvestmentId()) == null){
            throw new NoSuchElementException();
        }
        LOG.debug("Exited InvestmentService.addInvestmentInfo");
        return investment;
    }

    public void deleteInvestmentInfo(long id, InvestmentType type) {
        LOG.debug("Entered InvestmentService.deleteInvestmentInfo");
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        jpaRepository.deleteById(id);
        LOG.debug("Exited InvestmentService.deleteInvestmentInfo");
    }

    public Investment updateInvestmentInfo(int id,
                                           InvestmentType type,
                                           Optional<Float> buyPrice,
                                           Optional<Float> sellPrice) {

        LOG.debug("Entered InvestmentService.updateInvestmentInfo");
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        Investment investment = getInvestmentInfo(id, type);
        if(buyPrice.isPresent())
            investment.setBuyPrice(buyPrice.get());
        if(sellPrice.isPresent())
            investment.setSellPrice(sellPrice.get());
        LOG.debug("Exited InvestmentService.updateInvestmentInfo");
        return (Investment) jpaRepository.save(investment);
    }

    public Investment getInvestmentInfo(long id, InvestmentType type) {
        LOG.debug("Entered InvestmentService.getInvestmentInfo");
        JpaRepository jpaRepository = investmentFactory.getInvestmentRepository(type);
        Investment investment = (Investment) jpaRepository
                .findById(id)
                .get();
        LOG.debug("Exited InvestmentService.getInvestmentInfo");
        return Optional.of(investment).isPresent() ? investment : null;
    }

    public void parseAndAddInvestmentInfo(MultipartFile file) {

    }
}
