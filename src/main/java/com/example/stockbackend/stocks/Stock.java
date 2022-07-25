package com.example.stockbackend.stocks;

import java.util.List;

import lombok.Setter;
import lombok.Getter;

public class Stock {
    
    @Getter @Setter private String name;
    @Getter @Setter private double high = 0.0;
    @Getter @Setter private double low = 0.0;

    @Getter @Setter private List<Double> stockHighs;
    @Getter @Setter private List<Double> stockLows;

    public Stock(String name, double high, double low) {

    }

    


    
}
