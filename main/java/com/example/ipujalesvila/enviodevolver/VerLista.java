package com.example.ipujalesvila.enviodevolver;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ipujalesvila.enviodevolver.R;

import java.io.Serializable;
import java.util.ArrayList;

public class VerLista extends ListActivity implements Serializable {

    ArrayList <Persona> Agenda = new ArrayList<Persona>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        Intent intento = getIntent();

        Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");

        String nombres[]= new String[Agenda.size()];
        for (int i=0;i< Agenda.size();i++){
            nombres[i] = Agenda.get(i).getNombre().toString();
        }

        setListAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,nombres));
    }

    public void onListItemClick(ListView parent,View v,int position,long id){

                Persona persona = Agenda.get(position);
                Intent intento = new Intent(VerLista.this, Editar.class);
                intento.putExtra("agend",Agenda);
                intento.putExtra("Posicion",position);
                startActivityForResult(intento, 1);
                finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Agenda = (ArrayList<Persona>)data.getSerializableExtra("agend");
        Intent intento2 = new Intent(VerLista.this, Enviar.class);
        intento2.putExtra("agend",Agenda);
        setResult(RESULT_OK, intento2);


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
