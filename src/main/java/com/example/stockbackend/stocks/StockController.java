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
    
    //Injects the stockService class so that it does not need be instantiated into the class.
    @Autowired
    private StockService stockService;

    @GetMapping(value="/{stockName}/{algorithm}")
    public ResponseEntity<?> getStock(@PathVariable String stockName, @PathVariable String algorithm) {
        //Getting the stock.
        Stock stock = stockService.getStock(stockName);

        //Choose which sort to use.
        if (algorithm.equals("HeapSort")) {
            // Use HeapSort for the algorithm
            stockService.sortWithHeap(stock);
            stock.setHigh(stock.getStockHighs().get(stock.getStockHighs().size() - 1));
            stock.setLow(stock.getStockLows().get(0));
        }
        else if (algorithm.equals("TimSort")) {
            // Use Tim Sort for the sorting of the stocks.
            stockService.timSort(stock);
            stock.setHigh(stock.getStockHighs().get(stock.getStockHighs().size() - 1));
            stock.setLow(stock.getStockLows().get(0));
            
        }
        return ResponseEntity.status(HttpStatus.OK).body(stock);
    }

}
