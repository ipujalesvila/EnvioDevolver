package com.example.ipujalesvila.enviodevolver;

import android.app.Activity;
import android.content.Context;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

import com.example.ipujalesvila.enviodevolver.R;

public class Borrar extends ListActivity implements Serializable {

    ArrayList<Persona> Agenda = new ArrayList<Persona>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        Intent intento = getIntent();

        Agenda = (ArrayList<Persona>) intento.getSerializableExtra("agend");

        String nombres[] = new String[Agenda.size()];
        for (int i = 0; i < Agenda.size(); i++) {
            nombres[i] = Agenda.get(i).getNombre().toString();
        }

        setListAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, nombres));


        Button btnVolver = (Button) findViewById(R.id.buttonVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento2 = new Intent(Borrar.this, Enviar.class);
                intento2.putExtra("agend", Agenda);
                setResult(RESULT_OK, intento2);
                finish();
            }

        });
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {

        Agenda.remove(position);
        onCreate(Bundle.EMPTY); //llama a si mismo para "recargar la pagina"

        Intent intento2 = new Intent(Borrar.this, Enviar.class);
        intento2.putExtra("agend", Agenda);
        setResult(RESULT_OK, intento2);
        finish();

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
        getMenuInflater().inflate(R.menu.ver_lista, menu);
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
