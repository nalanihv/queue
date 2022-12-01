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
        centro=0;
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
        contador++;

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

                }
            }

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
        Log.i("log","Cantidad de datos : "+contador);
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

    public int serch(int buscar){

        int inf=0, sup =contador,auxCont=0;

        QueueNode nodeSerch= new QueueNode(buscar);
        QueueNode valorCentro = new QueueNode( centro );
        QueueNode aux=first;

        while (inf<= sup){

            centro=((inf+ sup)/2);

        while (aux!=null){

            auxCont++;
          //  Log.i("log","valor auxiliar antes de comparar "+auxCont);
            //Log.i("log","valor de auxiliar de dato  "+aux.getData());
            if (auxCont==centro){
                valorCentro.setData(aux.getData());
               // Log.i("log","valor centro "+valorCentro);
                aux=aux.getNext();
                //valorCentro.setData(aux.getData());
                break;
            }
            aux=aux.getNext();
        }
         //no se esta cambiando el dato del centro
            //ahora centro es mayor por uno, qn save pq

                if (nodeSerch.getData()==valorCentro.getData()){
                    return centro;
                }
                else if (nodeSerch.getData()<valorCentro.getData()){
                    sup =centro-1;
                    auxCont=0;
                    aux=first;
                }
                else
                    inf=centro+1;
            }
        return -1;
    }
}
