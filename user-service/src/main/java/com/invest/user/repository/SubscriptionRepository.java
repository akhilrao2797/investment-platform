package com.invest.user.repository;

import com.invest.user.model.Subscription;
import com.invest.user.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("Select s from Subscription s " +
            "where s.customer in (select n from Customer n where n.userId = ?1)")
    List<Subscription> findByUserId(String userId);

    Optional<Subscription> findByTrader(Trader trader);
}
