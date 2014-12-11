package com.example.ipujalesvila.enviodevolver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class Enviar extends Activity implements Serializable {
    ArrayList<Persona> Agenda = new ArrayList<Persona>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperson);

        Button btnañadir = (Button) findViewById(R.id.buttonAdd);
        Button btnverList = (Button) findViewById(R.id.buttonVerList);
        Button btnborrar = (Button) findViewById(R.id.buttonBorrar);
        final EditText edtnombre = (EditText) findViewById(R.id.editNombre);
        final EditText edttelefono = (EditText) findViewById(R.id.editTelf);


        btnañadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ("".equals(edtnombre.getText().toString().trim())) {
                    CharSequence msg = getResources().getString(R.string.toastName);
                    showToast(getResources().getString(R.string.toastName));
                    return;
                }

                if ("".equals(edttelefono.getText().toString().trim())) {
                    CharSequence msg = getResources().getString(R.string.toastTelefono);
                    showToast(getResources().getString(R.string.toastTelefono));
                    return;
                }

                if (edtnombre.getText() != null && edttelefono.getText() != null) {
                    Agenda.add(new Persona(edtnombre.getText().toString(), edttelefono.getText().toString()));
                    CharSequence msg = getResources().getString(R.string.toastAdd);
                    showToast(getResources().getString(R.string.toastAdd));
                    return;
                }

            }
        });

        btnverList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(Enviar.this, VerLista.class);
                intento.putExtra("agend", Agenda);
                startActivityForResult(intento, 1);

            }
        });

        btnborrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intento = new Intent(Enviar.this, Borrar.class);
                intento.putExtra("agend", Agenda);
                startActivityForResult(intento, 1);

            }


        });

        showToast(Integer.toString(Agenda.size()));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Agenda = (ArrayList<Persona>) data.getSerializableExtra("agend");
        final EditText edtnombre = (EditText) findViewById(R.id.editNombre);
        final EditText edttelefono = (EditText) findViewById(R.id.editTelf);
        onCreate(Bundle.EMPTY);
        edtnombre.setText("");
        edttelefono.setText("");

    }

    protected void showToast(String msg) {
        Context contexto = getApplicationContext();
        int duracion = Toast.LENGTH_LONG;
        Toast tostada = Toast.makeText(contexto, msg, duracion);
        tostada.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.enviar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
