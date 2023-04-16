package com.eitsistemas.coordenadas;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaCoordenadas extends AppCompatActivity {
    DatabaseHelper miDB;
    ListView listac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_coordenadas);
        listac =  (ListView)findViewById(R.id.txtlista);
        miDB = new DatabaseHelper(this);

        ArrayList<String>listado = new ArrayList<>();
        Cursor data = miDB.getListaContenidos();
        if(data.getCount()== 0){
            Toast.makeText(this,"No hay lista que mostrar",Toast.LENGTH_LONG).show();
        }else{
            while (data.moveToNext()){
                listado.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1,listado);
                listac.setAdapter(listAdapter);

            }
        }
    }


}