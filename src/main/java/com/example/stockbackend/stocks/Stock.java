package com.example.stockbackend.stocks;

import java.util.ArrayList;

import lombok.Setter;
import lombok.Getter;

public class Stock {
    
    @Getter @Setter private String name;
    @Getter @Setter private double high = 0.0;
    @Getter @Setter private double low = 0.0;

    @Getter @Setter private ArrayList<Double> stockHighs;
    @Getter @Setter private ArrayList<Double> stockLows;

    public Stock(String name, ArrayList<Double> highs, ArrayList<Double> lows) {
        this.name = name;
        this.stockHighs = highs;
        this.stockLows = lows;
    }

}
