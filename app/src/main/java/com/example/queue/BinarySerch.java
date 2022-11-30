package com.example.queue;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySerch {
    private int arreglo[]= new int[10];
    private int numBuscar=5;
    private int center;
    private int inferior=0;
    private  int superior= 9;





    public int busqueda(){

        while (inferior<=superior){
            center=(superior+inferior)/2;

            if (arreglo[center]==numBuscar){
                Log.i("log", "el numero"+numBuscar+" se encuentra en la posicion "+center);
            }else if(numBuscar<arreglo[center]){
                superior=center-1;
            }else {
                inferior=center+1;
            }
        }
        return center;
    }
}
