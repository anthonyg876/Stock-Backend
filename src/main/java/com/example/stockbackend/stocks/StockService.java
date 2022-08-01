package com.example.stockbackend.stocks;

import com.example.stockbackend.stocks.MinHeap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StockService {

    List<Double> list = new ArrayList<>();

    Map<String, Stock>  stocks = new HashMap<>();

    public Stock getStock(String stockName) {
        Scanner sc;

        //Capitalize the name
        stockName = stockName.toUpperCase();
        // Check to see if stock currently exists
        if (stocks.get(stockName) != null) {
            return stocks.get(stockName);
        }

        //Check to see if the stock even exists
        String nameOfFile = stockName + ".csv";
        try {
            sc = new Scanner(new File("Stocks/" + nameOfFile));
            sc.useDelimiter(",");
        // while ()
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            System.out.println("Could not find a stock with the given name.");
            e.printStackTrace();
            return null;
        }

        //Skip through the first line.
        int firstLine = 0;

        String date;
        double open;
        double high;
        double low;
        ArrayList<Double> highs = new ArrayList<>();
        ArrayList<Double> lows = new ArrayList<>();
         
        while (sc.hasNext()) {
            //Skip the header line
            if (firstLine == 0) {
                sc.nextLine();
                firstLine++;
                continue;
            }
            date = sc.next();
            open = sc.nextDouble();
            high = sc.nextDouble();
            low = sc.nextDouble();
            
            // Adding the values to the lists that will be inserted into the stock class.
            highs.add(high);
            lows.add(low);

            sc.nextLine();

        }
        // System.out.println("Got to here2");
        //Create the new stock
        Stock newStock = new Stock(stockName, highs, lows);
        
        //Add this stock to the hashmap
        stocks.put(newStock.getName(), newStock);
        
        return newStock;

    }

    public void sortWithHeap(Stock stock) {
        Long time = System.currentTimeMillis();
        MinHeap minHeap = new MinHeap();
        stock.setStockHighs(minHeap.minHeapSort(stock.getStockHighs()));
        stock.setStockLows(minHeap.minHeapSort(stock.getStockLows()));

        Long endTime = System.currentTimeMillis();
        Long totalTime = (endTime - time);
        stock.setTimeForAlgorithm(totalTime);
    }

    // Andrea's task
    public void timSort(Stock stock) {
        //Measure how much time it took to execute.
        Long time = System.currentTimeMillis();
        
        TimSort tim = new TimSort();
        stock.setStockHighs(tim.callTim(stock.getStockHighs()));
        stock.setStockLows(tim.callTim(stock.getStockLows()));

        Long endTime = System.currentTimeMillis();
        Long totalTime = (endTime - time);
        stock.setTimeForAlgorithm(totalTime);

    }
}