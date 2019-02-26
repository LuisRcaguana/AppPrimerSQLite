package com.example.prueba.appprimersqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prueba.appprimersqlite.db.ContactosDatasource;
import com.example.prueba.appprimersqlite.model.Contacto;

public class ModificacionActivity extends AppCompatActivity {


    EditText idM ;
    EditText NombreM;
    EditText emilM;
    Button bntBuscarM;
    Button bntGuardarM;
    Button bntCancdlarM;

    ContactosDatasource cds;
    Contacto contacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificacion);

        idM = findViewById(R.id.introidBorr);
        NombreM = findViewById(R.id.edtContactoMo);
        emilM = findViewById(R.id.edtEmileMO);
        bntBuscarM = findViewById(R.id.BntBuscar);
         bntGuardarM = findViewById(R.id.btnBorrar1);
        bntCancdlarM = findViewById(R.id.BtnCancelarM);


        cds = new ContactosDatasource(this);


    }

    public  void  buscarM(View v){

        String id = idM.getText().toString().trim();

        if(id.isEmpty()) {
            Toast.makeText(this, "Debe meter id",

                    Toast.LENGTH_LONG).show();

        }else {
            contacto = cds.consultarContacto(Integer.parseInt(id));

                if(contacto != null ){
                    idM.setEnabled(false);
                    bntBuscarM.setEnabled(false);
                    NombreM.setEnabled(true);
                    emilM.setEnabled(true);

                    bntGuardarM.setEnabled(true);

                    NombreM.setText(contacto.getName());
                    emilM.setText(contacto.getEmail());

                }else{

                    Toast.makeText(this, "No se a encontrado el ID introducido",
                            Toast.LENGTH_LONG).show();
                }

        }
    }


    public  void Modificar(View v){

        String nombre = NombreM.getText().toString().trim();
        String email = emilM.getText().toString().trim();

        if (nombre.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Debes introducir los datos",
                    Toast.LENGTH_LONG).show();

        } else {

            contacto.setName(nombre);
            contacto.setEmail(email);
             cds.modificarContacto(contacto);

            Toast.makeText(this, "se a realizado la modificacion",
                    Toast.LENGTH_LONG).show();

             idM.setText("");
             NombreM.setText("");
             emilM.setText("");

             idM.setEnabled(true);
             bntBuscarM.setEnabled(true);
            NombreM.setEnabled(false);
            emilM.setEnabled(false);
            bntGuardarM.setEnabled(false);






        }

    }
    public  void atrar(View v){
        finish();

    }




}
