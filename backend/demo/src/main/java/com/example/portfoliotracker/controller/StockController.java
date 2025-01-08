package com.example.portfoliotracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.portfoliotracker.model.Stock;
import com.example.portfoliotracker.service.StockService;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // Add a new stock to the portfolio
    @PostMapping
    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
        Stock createdStock = stockService.addStock(stock);
        return new ResponseEntity<>(createdStock, HttpStatus.CREATED);
    }

    // Update an existing stock in the portfolio
    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@PathVariable Long id, @RequestBody Stock stockDetails) {
        Stock updatedStock = stockService.updateStock(id, stockDetails);
        if (updatedStock != null) {
            return new ResponseEntity<>(updatedStock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a stock from the portfolio
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Get all stocks in the portfolio
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks = stockService.getAllStocks();
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }

    // Get a stock by ticker symbol
    @GetMapping("/ticker/{ticker}")
    public ResponseEntity<Stock> getStockByTicker(@PathVariable String ticker) {
        Stock stock = stockService.getStockByTicker(ticker);
        if (stock != null) {
            return new ResponseEntity<>(stock, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
