package com.example.queue;

import android.util.Log;
import android.widget.Toast;

public class Queue {
    private QueueNode first;
    private QueueNode last;
    private int contador=0;
    private boolean igual=false;

    public Queue() {//por que la primera vez estan vacios -Se inicializa
        first=null;
        last=null;
        //first=last=null;
    }

    public QueueNode getFirst() {
        return first;}
    public QueueNode getLast() {
        return last;}



    public void add(int data){
        QueueNode node=new QueueNode(data);//agrega valores
        QueueNode buscar= first;
        if (node==null){
            Log.i("log","Queue overflow");
        }else {


            if(contador<=8){

                if(first==null){
                    first=node;
                    contador++;
                }else{

                    while (buscar.getNext()!=null){
                        contador++;
                        buscar= buscar.getNext();

                    }



                    last.setNext(node);
                }
                last=node;

            }else {
                Log.i("log","la fila alcanzó su límite, el cliente no puede ser atendido");
            }}
    }

    public void printl(){
        String result="";
        QueueNode aux=first;
        while (aux!=null){ // aux==last.getNext; sign.
            result+=aux+" -> ";
            aux=aux.getNext();
        }
        Log.i("log",""+result);
    }


    public int remove(){

        if (first==null){
            return -1;//no hay elementos
        }else {
            QueueNode aux=first;
            first=first.getNext();//el primero va hacer ahora el enlace que tiene
            if (first==null)
                last = null;
            contador--;

            return aux.getData();

        }}
}
