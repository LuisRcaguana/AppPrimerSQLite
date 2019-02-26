package com.example.prueba.appprimersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.prueba.appprimersqlite.db.ContactosDatasource;
import com.example.prueba.appprimersqlite.model.Contacto;
import com.example.prueba.appprimersqlite.recycler.ContactoAdaptador;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {

    RecyclerView rv;
    ContactoAdaptador adaptador;
    LinearLayoutManager llm;
    ArrayList<Contacto> datos;
    ContactosDatasource cds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        rv = findViewById(R.id.rvContactos);

        cds = new ContactosDatasource(this);
        datos = cds.consultarContactos();

        if (datos.isEmpty()) {
            Toast.makeText(this, "No se han encontrado contactos",
                    Toast.LENGTH_LONG).show();
        } else {
            adaptador = new ContactoAdaptador(datos);
            llm = new LinearLayoutManager(this);

            rv.setLayoutManager(llm);
            rv.setAdapter(adaptador);
        }

    }
    public void cancelar(View v) {
        finish();

    }
}
