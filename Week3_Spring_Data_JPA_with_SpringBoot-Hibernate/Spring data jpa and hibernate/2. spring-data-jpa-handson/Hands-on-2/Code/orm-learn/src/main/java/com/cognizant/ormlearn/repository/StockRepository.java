package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.math.BigDecimal;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    // 1. Get all stock details of Facebook in September 2019
    List<Stock> findByCodeAndDateBetween(String code, LocalDate start, LocalDate end);

    // 2. Get all Google stock details where closing price > 1250
    List<Stock> findByCodeAndCloseGreaterThan(String code, BigDecimal price);

    // 3. Get top 3 stocks with highest volume
    List<Stock> findTop3ByOrderByVolumeDesc();

    // 4. Get 3 dates when Netflix stocks were lowest
    List<Stock> findTop3ByCodeOrderByCloseAsc(String code);
}
