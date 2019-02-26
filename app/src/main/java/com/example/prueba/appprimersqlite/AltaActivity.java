package com.example.prueba.appprimersqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.appprimersqlite.db.ContactosDatasource;
import com.example.prueba.appprimersqlite.model.Contacto;

public class AltaActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etEmail;
    ContactosDatasource cds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        etNombre = findViewById(R.id.etNombreA);
        etEmail = findViewById(R.id.etEmailA);

        cds = new ContactosDatasource(this);
    }

    public void guardar(View v) {
        String nombre = etNombre.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (nombre.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Debes introducir los datos",
                    Toast.LENGTH_LONG).show();

        } else {
            Contacto c = new Contacto(nombre, email);
            long id = cds.insertarContacto(c);

            if (id != -1) {
                Toast.makeText(this, "La insercion se ha hecho bien",
                        Toast.LENGTH_LONG).show();
                c.setId((int)id);
                etNombre.setText("");
                etEmail.setText("");

            } else {
                Toast.makeText(this, "La insercon no se a podido relizar",
                        Toast.LENGTH_LONG).show();
            }
        }

    }
    public void cancelar(View v) {
        finish();

    }
}
