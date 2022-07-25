package com.example.stockbackend.stocks;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class stockService {

    List<Stock> stocks;

    public double getHigh(String stockName, Boolean highOrLow) {

        //Check to make sure the stock name is capitalized
        stockName.toUpperCase();


        return 0.0;

    }

    // Andrea's task
    public void timSort() {
        
    }


    
}
