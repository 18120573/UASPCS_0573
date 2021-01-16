package com.example.uaspcs_0573;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.uaspcs_0573.Adapter.FavoritAdapter;
import com.example.uaspcs_0573.Models.Favorit;

import java.util.ArrayList;

public class FavoritScreen extends AppCompatActivity {


    ArrayList<Favorit> arrayFavorit = new ArrayList<Favorit>();
    RecyclerView rcFavorit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("database_0573",android.content.Context.MODE_PRIVATE,null);

        Cursor res =  mydatabase.rawQuery( "SELECT * FROM favorit", null );

        res.moveToFirst();

        rcFavorit = findViewById(R.id.rcFavorit);

        while(res.isAfterLast() == false){
            String matchid = res.getString(0);
            String namaevent = res.getString(1);
            String liga = res.getString(2);
            String venue = res.getString(3);
            String waktu = res.getString(4);
            String hasil = res.getString(5);
            String image = res.getString(6);
            System.out.println(namaevent);
            arrayFavorit.add(new Favorit(matchid,image,namaevent, "-","-","-"));
            res.moveToNext();
        }

        FavoritAdapter fAdapter = new FavoritAdapter(getApplicationContext(),arrayFavorit);

        rcFavorit.setAdapter(fAdapter);
        rcFavorit.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }
}
