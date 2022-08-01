package com.example.stockbackend.stocks;

import java.util.ArrayList;

import lombok.Setter;
import lombok.Getter;

/**
 * Stock class that will contain the information needed from the stock.
 * 
 * String name: name of the stock
 * double high: max value of the stock.
 * double low: Lowest value of the stock.
 * double timeForAlgorithm: Time it took for the data to be sorted.
 * 
 * ArrayList<Double> stockHighs: A list of the Highest values of a particular stock since its opening.
 * ArrayList<Double> stockLows: A list of the lowest values of a particular stock since its opening.
 */
public class Stock {
    
    @Getter @Setter private String name;
    @Getter @Setter private double high = 0.0;
    @Getter @Setter private double low = 0.0;
    @Getter @Setter private double timeForAlgorithm;

    @Getter @Setter private ArrayList<Double> stockHighs;
    @Getter @Setter private ArrayList<Double> stockLows;

    public Stock(String name, ArrayList<Double> highs, ArrayList<Double> lows) {
        this.name = name;
        this.stockHighs = highs;
        this.stockLows = lows;
    }

}
