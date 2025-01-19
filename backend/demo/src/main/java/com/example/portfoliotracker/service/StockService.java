package com.example.portfoliotracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.portfoliotracker.model.Stock;
import com.example.portfoliotracker.repository.StockRepository;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }


    public Stock updateStock(Long id, Stock stockDetails) {
        Optional<Stock> stockOptional = stockRepository.findById(id);
        if (stockOptional.isPresent()) {
            Stock stock = stockOptional.get();
            stock.setName(stockDetails.getName());
            stock.setTicker(stockDetails.getTicker());
            stock.setQuantity(stockDetails.getQuantity());
            stock.setBuyPrice(stockDetails.getBuyPrice());
            return stockRepository.save(stock);
        } else {
            // Handle case where the stock is not found
            return null;
        }
    }

    // Delete a stock from the portfolio
    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }

    // Get all stocks in the portfolio
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    // Find a stock by its ticker symbol
    public Stock getStockByTicker(String ticker) {
        return stockRepository.findByTicker(ticker);
    }
}
