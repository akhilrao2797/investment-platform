package com.invest.user.service;

import com.invest.user.model.Analyst;
import com.invest.user.model.Subscription;
import com.invest.user.model.Trader;
import com.invest.user.repository.AnalystRepository;
import com.invest.user.repository.SubscriptionRepository;
import com.invest.user.repository.TraderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;
    private TraderRepository traderRepository;
    private AnalystRepository analystRepository;
    private Logger LOG = LoggerFactory.getLogger(SubscriptionService.class);

    @Autowired
    private SubscriptionService(TraderRepository traderRepository,
                                AnalystRepository analystRepository,
                                SubscriptionRepository subscriptionRepository){
        this.traderRepository = traderRepository;
        this.analystRepository = analystRepository;
        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscription getSubscriptionInfo(long id){
        LOG.debug("Entered SubscriptionService.getSubscriptionInfo");
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(!subscription.isPresent()){
            return null;
        }
        LOG.debug("Exited SubscriptionService.getSubscriptionInfo");
        return subscription.get();
    }

    public Subscription getSubscriptionByTrader(Trader trader){
        LOG.debug("Entered SubscriptionService.getSubscriptionByTrader");
        Optional<Subscription> subscription = subscriptionRepository.findByTrader(trader);
        if(!subscription.isPresent()){
            return null;
        }
        LOG.debug("Exited SubscriptionService.getSubscriptionByTrader");
        return subscription.get();
    }

    public Subscription getSubscriptionByTraderId(String traderId){
        LOG.debug("Entered SubscriptionService.getSubscriptionByTraderId");
        Optional<Subscription> subscription = subscriptionRepository.findByTraderId(traderId);
        if(!subscription.isPresent()){
            return null;
        }
        LOG.debug("Exited SubscriptionService.getSubscriptionByTraderId");
        return subscription.get();
    }

    public Subscription addSubscription(String traderId, String analystId) {
        LOG.debug("Entered SubscriptionService.addSubscription");

        Optional<Trader> optionalTrader = traderRepository.findById(traderId);
        if(!optionalTrader.isPresent())
            return null;
        Optional<Analyst> optionalAnalyst = analystRepository.findById(analystId);
        if(!optionalAnalyst.isPresent())
            return null;

        Trader trader = optionalTrader.get();
        Analyst analyst = optionalAnalyst.get();
        Optional<Subscription> optionalSubscription = subscriptionRepository
                .findByTrader(optionalTrader.get());
        Subscription subscription = optionalSubscription.isPresent() ?
                optionalSubscription.get() : new Subscription();
        subscription.setTrader(trader);
        subscription.getAnalystList().add(analyst);

        subscription = subscriptionRepository.save(subscription);

        LOG.debug("Entered SubscriptionService.addSubscription");
        return subscription;
    }

    public void deleteSubscription(long subscriptionId, String traderId, String analystId) {
        Optional<Subscription> optionalSubscription = subscriptionRepository
                .findById(subscriptionId);
        if(!optionalSubscription.isPresent())
            return;

        Subscription subscription = optionalSubscription.get();
        if(!subscription.getTrader().getTraderId().equals(traderId))
            return;

        subscription.getAnalystList().remove(analystId);
        subscriptionRepository.save(subscription);
    }
}
