package com.invest.user.repository;

import com.invest.user.model.Subscription;
import com.invest.user.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("Select s from Subscription s " +
            "where s.trader in (select n from Trader n where n.traderId = ?1)")
    Optional<Subscription> findByTraderId(String traderId);

    Optional<Subscription> findByTrader(Trader trader);
}
