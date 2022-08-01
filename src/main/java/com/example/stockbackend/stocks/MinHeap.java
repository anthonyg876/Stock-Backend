package com.example.stockbackend.stocks;
import java.util.List;
import java.util.ArrayList;

// Cory's implementation of a min heap that uses doubles.
//passed in array of doubles
//return sorted List or arrayList

public class MinHeap {

    public ArrayList<Double> minHeapSort(ArrayList<Double> heapList){
        for(int i = heapList.size() / 2 - 1; i >= 0; i--){
            heapList = heapify(heapList, heapList.size(), i);
        }

        for(int i = heapList.size() - 1; i > 0; i--){  //fix
            double saver = heapList.get(0);
            heapList.set(0, heapList.get(i));
            heapList.set(i, saver);

            heapList = heapify(heapList, i, 0);
        }

        return heapList;
    }

    ArrayList<Double> heapify(ArrayList<Double> heapList, int l, int i){
        int right = 2 * i + 2, left = 2 * i + 1, root = i;

        if(right < l && heapList.get(right) > heapList.get(root)){
            root = right;
        }

        if(left < l && heapList.get(left) > heapList.get(root)){
            root = left;
        }

        if(root != i){
            double saver = heapList.get(i);
            heapList.set(i, heapList.get(root));
            heapList.set(root, saver);

            heapList = heapify(heapList, l, root);
        }

        return heapList;
    }
}