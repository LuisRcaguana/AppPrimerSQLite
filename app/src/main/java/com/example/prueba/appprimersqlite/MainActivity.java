package com.example.prueba.appprimersqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public  void registrar(View v){
        Intent i = new Intent(this, AltaActivity.class);
        startActivity(i);

    }
    public  void consultar(View v){
        Intent c = new Intent(this, ConsultaActivity.class);
        startActivity(c);

    }
    public  void modifica(View v){
        Intent c = new Intent(this, ModificacionActivity.class);
        startActivity(c);

    }
    public  void borrar(View v){
        Intent c = new Intent(this, BorradoActivity.class);
        startActivity(c);

    }
}
