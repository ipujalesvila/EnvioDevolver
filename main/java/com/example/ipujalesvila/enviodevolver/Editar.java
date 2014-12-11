package com.example.ipujalesvila.enviodevolver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ipujalesvila.enviodevolver.R;

import java.util.ArrayList;

public class Editar extends Activity {
    ArrayList<Persona> Agenda = new ArrayList<Persona>();
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        Intent intento = getIntent();
        EditText nombre = (EditText)findViewById(R.id.editNombre);
        EditText telf = (EditText)findViewById(R.id.editTelf);
        pos= intento.getExtras().getInt("Posicion");
        Agenda = (ArrayList<Persona>)intento.getSerializableExtra("agend");

        nombre.setText(Agenda.get(pos).getNombre().toString());
        telf.setText(Agenda.get(pos).getTelefono().toString());

        Button edit =(Button)findViewById(R.id.buttonAdd);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView nombre = (TextView)findViewById(R.id.textPrueba);

                String newNome =((EditText) findViewById(R.id.editNombre)).getText().toString();
                String newTelf =((EditText) findViewById(R.id.editTelf)).getText().toString();

                nombre.setText(newNome.toString()+"  "+newTelf.toString());

                Agenda.get(pos).setNombre(newNome.toString());
                Agenda.get(pos).setTelefono(newTelf.toString());

                Intent intento2 = new Intent(Editar.this, VerLista.class);
                intento2.putExtra("agend",Agenda);
                setResult(RESULT_OK, intento2);
                finish();

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.editar, menu);
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
