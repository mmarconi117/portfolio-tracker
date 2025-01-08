package com.example.portfoliotracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.portfoliotracker.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    // Additional query methods can be defined here if needed.
    // Example: Find a stock by its ticker symbol
    Stock findByTicker(String ticker);
}
