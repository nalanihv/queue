package com.example.queue;

import android.util.Log;


public class Queue {
    private QueueNode first;
    private QueueNode last;
    private int contador=0;
    private boolean igual;

    public Queue() {//por que la primera vez estan vacios -Se inicializa
        first=null;
        last=null;
        //first=last=null;
    }

    public QueueNode getFirst() {
        return first;}
    //public QueueNode getLast() {
       // return last;}

    public void add(int data){
        QueueNode node=new QueueNode(data);//agrega valores
        QueueNode buscar= first;
        igual=false;

        if (node==null){
            Log.i("log","Queue overflow");
        }else {
            if(contador<=8){
                if(first==null){
                    first=node;
                    contador++;
                    last=node;
                }else{
                    while (buscar.getNext()!=null){
                        if (buscar.getData()==node.getData()){
                            Log.i("log","dato repetido");
                            igual=true;
                            break ;
                        }
                        buscar= buscar.getNext();
                    }
                    if (igual!=true){
                       Log.i("log","entro por igual false");
                        contador++;
                        last.setNext(node);
                        last=node;
                    }
                }
            }else {
                Log.i("log","la fila alcanzó su límite, el cliente no puede ser atendido");
            }}
    }


    public void printl(){
        String result="";
        QueueNode aux=first;
        while (aux!=null){
            result+=aux+" -> ";
            aux=aux.getNext();
        }
        Log.i("log",""+result);
    }




    public int remove(){

        if (first==null){
            return -1;
        }else {
            QueueNode aux=first;
            first=first.getNext();
            if (first==null)
                last = null;
            contador--;
            return aux.getData();
        }}
}
