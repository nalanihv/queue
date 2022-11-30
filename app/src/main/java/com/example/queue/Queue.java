package com.example.queue;

import android.util.Log;
//el ultimo dato ingresado es quien tiene el enlace nulo

public class Queue {
    private QueueNode first;
    private QueueNode last;
    private  int contador;
    private int centro;


    public Queue() {
        first=null;
        last=null;
    }

    public QueueNode getFirst() {
        return first;}

    public void setFirst(QueueNode first) {
        this.first = first;
    }

    public QueueNode getLast() {
        return last;}

    public void add(int data){
        QueueNode node = new QueueNode( data );
        QueueNode aux= first;

        if( node == null )
            Log.i("log"," over flow");

        else{

            if( first == null ){
                first = node;
                last = node;
            }
            else{

                if (node.getData()>=last.getData()){ //si dato ingresado mayor al ultimo de la fila
                    last.setNext(node);
                    last=node;

                }
               else if (node.getData()<=aux.getData()){ //si es menor

                   node.setNext(first); //el enlace del dato ingresado es el primero
                    setFirst(node);

               }
               else {

                    QueueNode posterior= getFirst().getNext();

                   while (aux!=null){
                       if (node.getData()<=posterior.getData()) {
                           node.setNext(posterior);
                           aux.setNext(node);
                           break;
                       }

                       posterior=posterior.getNext();
                       aux=aux.getNext();

                       Log.i("log","posterioir "+posterior);
                       Log.i("log","auxiliar  "+aux);
                }
            }
            contador++;
        }
    }}

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
            return aux.getData();
        }}

    public int serch(){
        return 0;
    }
}
