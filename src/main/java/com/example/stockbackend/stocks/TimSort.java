package com.example.stockbackend.stocks;

import java.util.ArrayList;

public class TimSort {
    //insertion sort function
    public void insertionSort(Double[] arr, int l, int r)
    {
        for (int i = l + 1; i <= r; i++)
        {
            Double key = arr[i];
            int j = i - 1;


            while (j >= l && arr[j] > key)
            {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
 
    //function that merges the arrays sorted by insertion sort
    // l - left, m - middle, r - right 
    //From Module 6 Slides on Sorting 
    public void merge(Double[] arr, int l, int m, int r)
    {
        //Two subarrays - left and right sides 
        int n1 = m - l + 1;
        int n2 = r - m;
        Double[] X = new Double[n1];
        Double[] Y = new Double[n2];

        for (int i = 0; i < n1; i++)
        {
            X[i] = arr[l + i];
        }
        for (int j = 0; j < n2; j++)
        {
            Y[j] = arr[m + 1 + j];
        }

        //combining left and right arrays
        int i, j, k;
        i = 0;
        j = 0;
        k = l;
 
        while (i < n1 && j < n2)
        {
            if (X[i] <= Y[j])
            {
                arr[k] = X[i];
                i++;
            }
            else 
            {
                arr[k] = Y[j];
                j++;
            }
            k++;
        }
 
        while (i < n1)
        {
            arr[k] = X[i];
            k++;
            i++;
        }
        while (j < n2)
        {
            arr[k] = Y[j];
            k++;
            j++;
        }
    }
//timsort function
    public void timSort(Double[] arr, int n)
    {
        //find minimum runsize and use insertion sort to order subarrays

        int r = 0;
        int m = arr.length;
        while (m >= 32)
        {
            r |= (m & 1);
            m >>= 1;
        }
        int minrun = m + r;

        //sorting the subarrays
        //referenced from source on timsort 
        for (int i = 0; i < n; i += minrun)
        {
            insertionSort(arr, i, Math.min((i + 64 - 1), (n - 1)));
        }

        //going through subarrays and merging them together
        //k represents the size of the subarrays
        int k = minrun;
        while(k < n)
         {
            for(int left = 0; left < n; left += 2 * k)
            {
                int mid = Math.min((n-1),(left + k -1));
                int right = Math.min((left + 2 * k - 1), (n-1));
                merge(arr,left,mid,right);
            }
            k = 2 * k; 
         }

    }

    public ArrayList<Double> callTim(ArrayList<Double> list)
    {
         Double[] arr = new Double[list.size()];

         for (int i = 0; i < list.size(); i++)
         {
            arr[i] = list.get(i);
         }

         timSort(arr,arr.length);

         for (int i = 0; i < arr.length; i++)
         {
            list.set(i,arr[i]);
         }

         return list;

         //System.out.println("Max value is " + arr[arr.length - 1] + "  Min value is " + arr[0]);
    }
}
