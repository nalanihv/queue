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
        centro=contador/2;
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

                       Log.i("log","posterioir "+posterior);
                       Log.i("log","auxiliar  "+aux);
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
        Log.i("log","contador : "+contador);
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

    public void serch(int buscar){
        int bajo=0,alto=contador,auxCont=0;
        QueueNode aux=first;
        QueueNode nodeSerch= new QueueNode(buscar);
        QueueNode valorCentro=null;

        while (bajo<=alto ){
            centro=(bajo+alto)/2;
            Log.i("log","centro poscion : "+centro);


        while (aux!=null){
            auxCont++;
            Log.i("log","contador auxiliar : "+auxCont);
            Log.i("log"," auxiliar : "+aux);

            if (auxCont==centro){
                valorCentro=aux;
                Log.i("log","entro a centro ");
                Log.i("log","su valor:   "+valorCentro);
                break;

                //si centro es mayor que bajo o alto, depende si se resetean las variables, tomar en cuenta eso

            }
            aux=aux.getNext();
        }
           // auxCont=0;
                if (nodeSerch.getData()==valorCentro.getData()){
                    Log.i("log", "posicion del dato encontrado  "+centro);
                    break;
                }


                else if (nodeSerch.getData()<valorCentro.getData())
                    alto=centro-1; //checar estos

                else
                    bajo=centro+1;

            Log.i("log","alto"+alto+"  y bajo  "+bajo);
            }

    }
}
