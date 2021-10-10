package com.invest.platform.repository;

import com.invest.platform.models.LongTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LtiRepository extends JpaRepository<LongTermInvestment, String> {
}
