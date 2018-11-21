package com.example.hector.di5;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPersonas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPersonas = (ListView) findViewById(R.id.listViewPersonas);
        String[] personas = {"Omar", "Cristobal", "Oscar", "Tomas", "Rosa", "Claudio", "Manel", "Aitor", "Carles", "Belen", "Hector", "Jesus", "Pepe", "Marc"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personas);
        listViewPersonas.setAdapter(adaptador);
        registerForContextMenu(listViewPersonas);
    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        if(v.getId() == R.id.listViewPersonas){

            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
            menu.setHeaderTitle(listViewPersonas.getAdapter().getItem(info.position).toString());

        }
        super.onCreateContextMenu(menu, v, menuInfo);

    }


    @Override
    public boolean onContextItemSelected(MenuItem item)

    {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId())
        {

            case R.id.mostrar:
                Toast.makeText(getApplicationContext(),listViewPersonas.getAdapter().getItem(info.position).toString()+" : Opción mostrar", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.eliminar:
                Toast.makeText(getApplicationContext(),listViewPersonas.getAdapter().getItem(info.position).toString()+" : Opción eliminar", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return super.onContextItemSelected(item);

        }

    }




}