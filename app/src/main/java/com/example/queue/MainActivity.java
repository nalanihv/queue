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
    private Button btGuardar;
    private Button btQuitar;
    private Button btMostrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsuario=findViewById(R.id.etUsuario);
        btGuardar=findViewById(R.id.btGuardar);
        btMostrar=findViewById(R.id.btMostrar);
        btQuitar=findViewById(R.id.btQuitar);

        queue= new Queue();
        queue.add(2);
        queue.printl();
        queue.remove();

        btGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input=etUsuario.getText().toString().trim();

                if( input.equals("") )
                    Toast.makeText(getApplicationContext(),"ingresa un dato", Toast.LENGTH_SHORT).show();
                else{
                    int aux=Integer.parseInt(input);
                    queue.add(aux);//se supone que aqui agrega
                    Log.i("log",aux+"");
                    queue.printl();
                    etUsuario.setText("");
                }

            }
        });
        btQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}