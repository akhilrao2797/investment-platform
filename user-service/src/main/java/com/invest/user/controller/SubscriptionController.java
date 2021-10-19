package com.invest.user.controller;

import com.invest.user.model.Analyst;
import com.invest.user.model.Subscription;
import com.invest.user.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/user-sub/v1")
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("/subscription/{subscriptionId}")
    public ResponseEntity<Subscription> getSubscriptionDetails(@PathVariable long subscriptionId){
        return ResponseEntity.ok(subscriptionService.getSubscriptionInfo(subscriptionId));
    }

    @GetMapping("/subscription")
    public ResponseEntity<Subscription> getSubscriptionDetailsByUser(@RequestParam String userId){
        return ResponseEntity.ok(subscriptionService.getSubscriptionByTraderId(userId));
    }

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> addSubscription(@RequestParam String traderId,
                                                        @RequestParam String analystId){
        Subscription subscription = subscriptionService.addSubscription(traderId, analystId);
        return ResponseEntity.ok(subscription);
    }

    @DeleteMapping("/subscription/{subscriptionId}")
    public ResponseEntity deleteSubscription(@PathVariable long subscriptionId,
                                                        @RequestParam String traderId,
                                                        @RequestParam String analystId){
        subscriptionService.deleteSubscription(subscriptionId, traderId, analystId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/subscription/{subscriptionId}/analysts")
    public ResponseEntity<Set<Analyst>> getAnalystDetailsBySubscriptionId(@PathVariable long subscriptionId){
        Subscription subscription = subscriptionService.getSubscriptionInfo(subscriptionId);
        Set<Analyst> analysts = (subscription != null) ? subscription.getAnalystList() : new HashSet<>();
        return ResponseEntity.ok(analysts);
    }
}
