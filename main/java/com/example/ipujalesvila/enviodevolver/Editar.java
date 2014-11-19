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

public class Editar extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        EditText nombre = (EditText)findViewById(R.id.editNombre);
        EditText telf = (EditText)findViewById(R.id.editTelf);

        Intent intento = getIntent();
        final int pos= intento.getExtras().getInt("Posicion");
        nombre.setText(intento.getExtras().getString("NombrePersona"));
        telf.setText(intento.getExtras().getString("TelfPersona"));

        Button edit =(Button)findViewById(R.id.buttonAdd);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNome =((TextView) findViewById(R.id.editNombre)).getText().toString();
                String newTelf =((TextView) findViewById(R.id.editTelf)).getText().toString();

                Intent intento2 = new Intent(Editar.this, Enviar.class);
                intento2.putExtra("NewName",newNome);
                intento2.putExtra("NewPhone",newTelf);
                intento2.putExtra("NewPos", pos);
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
