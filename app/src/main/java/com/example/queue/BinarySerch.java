package com.example.queue;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySerch {
    private int arreglo[]= new int[10];
    private ArrayList<Integer>numbers;
    private int numBuscar;



    public int getNumBuscar() {
        return numBuscar;
    }


    public int busquedaEstatica(int numBuscar, int []arreglo) {
        Arrays.sort(arreglo);
        return Arrays.binarySearch(arreglo, numBuscar);
    }

    public int busqueda(){


        return 0;
    }
}
