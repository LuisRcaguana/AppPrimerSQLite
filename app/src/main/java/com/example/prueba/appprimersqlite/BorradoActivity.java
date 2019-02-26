package com.example.prueba.appprimersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.appprimersqlite.db.ContactosDatasource;
import com.example.prueba.appprimersqlite.model.Contacto;

public class BorradoActivity extends AppCompatActivity {

    EditText idB;
    EditText nombreB;
    EditText emailB;
    Button btnBuscarB;
    Button btnBorrarb;
    Button AtrasB;

    ContactosDatasource cds;
    Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrado);

        idB = findViewById(R.id.introidBorr);
        nombreB =  findViewById(R.id.NombreBorr);
        emailB = findViewById(R.id.emailBo);
        btnBuscarB =  findViewById(R.id.BuscarBorr);
        btnBorrarb=  findViewById(R.id.btnBorrar1);
        AtrasB =  findViewById(R.id.BtnCancelarB);

        cds = new ContactosDatasource(this);


    }

    public  void  buscarB(View v){

        String id = idB.getText().toString().trim();

        if(id.isEmpty()) {
            Toast.makeText(this, "Debe meter id",

                    Toast.LENGTH_LONG).show();

        }else {
            contacto = cds.consultarContacto(Integer.parseInt(id));

            if(contacto != null ){
                idB.setEnabled(false);
                btnBuscarB.setEnabled(false);


               btnBorrarb.setEnabled(true);

                nombreB.setText(contacto.getName());
                emailB.setText(contacto.getEmail());

            }else{

                Toast.makeText(this, "No se a encontrado el ID introducido",
                        Toast.LENGTH_LONG).show();
            }

        }
            }


    public  void borrarB(View v){

        cds.borrarContacto(contacto.getId());

            Toast.makeText(this, "se ha eleminado el contacto",
                    Toast.LENGTH_LONG).show();

            idB.setText("");
            nombreB.setText("");
            emailB.setText("");

            idB.setEnabled(true);
            nombreB.setEnabled(false);
            emailB.setEnabled(false);
            btnBorrarb.setEnabled(false);

        }


    public  void atrarB(View v){
        finish();

    }



}
