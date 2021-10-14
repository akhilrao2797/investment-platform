package com.invest.user.service;

import com.invest.user.model.Subscription;
import com.invest.user.model.Trader;
import com.invest.user.repository.SubscriptionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;
    private Logger LOG = LoggerFactory.getLogger(SubscriptionService.class);

//    public Subscription createSubscription(Payment payment){
//        LOG.debug("Entered SubscriptionService.createSubscription");
//        Subscription subscription = getSubscriptionByUser(payment.getCustomer());
//        if(subscription == null) {
//            subscription = new Subscription();
//            subscription.setTrader(payment.getCustomer());
//            subscription.setAnalystList(Lists.newArrayList(payment.getAnalyst()));
//
//        }
//        else {
//            subscription.getAnalystList().add(payment.getAnalyst());
//        }
//        subscription = subscriptionRepository.save(subscription);
//        LOG.debug("Exited SubscriptionService.createSubscription");
//        return subscription;
//    }

    public Subscription getSubscriptionInfo(long id){
        LOG.debug("Entered SubscriptionService.getSubscriptionInfo");
        Optional<Subscription> subscription = subscriptionRepository.findById(id);
        if(!subscription.isPresent()){
            return null;
        }
        LOG.debug("Exited SubscriptionService.getSubscriptionInfo");
        return subscription.get();
    }

    public Subscription getSubscriptionByUser(Trader trader){
        LOG.debug("Entered SubscriptionService.getSubscriptionByUser");
        Optional<Subscription> subscription = subscriptionRepository.findByTrader(trader);
        if(!subscription.isPresent()){
            return null;
        }
        LOG.debug("Exited SubscriptionService.getSubscriptionByUser");
        return subscription.get();
    }
}
