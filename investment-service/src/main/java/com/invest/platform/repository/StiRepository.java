package com.invest.platform.repository;

import com.invest.platform.models.ShortTermInvestment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StiRepository extends JpaRepository<ShortTermInvestment, String> {
}
