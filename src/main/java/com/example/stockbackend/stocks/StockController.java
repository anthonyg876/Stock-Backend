package com.example.stockbackend.stocks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "stocks")
public class StockController {
    
    @Autowired
    private StockService stockService;

    @GetMapping(value="/{stockName}")
    public ResponseEntity<?> getStock(@PathVariable String stockName) {

        return ResponseEntity.status(HttpStatus.OK).body(stockService.getStock(stockName));
    }

}
