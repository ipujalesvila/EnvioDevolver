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

import java.util.ArrayList;


public class Enviar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addperson);

        Button btnañadir = (Button) findViewById(R.id.buttonAdd);
        Button btneditar = (Button) findViewById(R.id.buttonEditPers);
        final EditText edtnombre = (EditText) findViewById(R.id.editNombre);
        final EditText edttelefono = (EditText) findViewById(R.id.editTelf);
        final EditText edtpers = (EditText) findViewById(R.id.editPers);
        final ArrayList<Persona> Agenda = new ArrayList<Persona>();


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

        btneditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i = 0; i < Agenda.size(); i++) {
                    String busc = Agenda.get(i).getNombre();
                    String nom = edtpers.getText().toString();
                    if (nom.equalsIgnoreCase(busc)) {
                        String[] persona = null;
                        Intent intento = new Intent(Enviar.this, Editar.class);
                        intento.putExtra("NombrePersona", Agenda.get(i).getNombre().toString());
                        intento.putExtra("TelfPersona", Agenda.get(i).getTelefono().toString());
                        startActivity(intento);
                        break;
                    }
                }

            }
        });


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
