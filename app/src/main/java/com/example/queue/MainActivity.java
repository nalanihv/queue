package com.example.queue;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private  Queue queue;
    private EditText etUsuario;
    private Button btAgregar;
    private Button btBuscar;
    private Button btMostrar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario=findViewById(R.id.etUsuario);
        btAgregar=findViewById(R.id.btGuardar);
        btMostrar=findViewById(R.id.btMostrar);
        btBuscar=findViewById(R.id.btQuitar);
        Queue queue= new Queue();
        //BinarySerch objeto= new BinarySerch();



        btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=etUsuario.getText().toString().trim();

                if( input.equals("") )
                    Toast.makeText(getApplicationContext(),"ingresa un dato", Toast.LENGTH_SHORT).show();
                else{
                    int aux=Integer.parseInt(input);
                    queue.add(aux);
                    Log.i("log","dato Ingresado: "+aux);
                    etUsuario.setText("");
                }
            }
        });


        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = etUsuario.getText().toString().trim();

                if (input.equals(""))
                    Toast.makeText(getApplicationContext(), "ingrese un valor a buscar", Toast.LENGTH_SHORT).show();
                else {
                    int aux=Integer.parseInt(input);
                    Log.i("log","Dato a buscar "+aux);
                    Log.i("log","Posicion del dato "+queue.serch(aux));
                }
            }
        });



        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("log","fila actual:  ");
                queue.printl();
            }
        });
    }




}