package com.example.uaspcs_0573;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRiwayat, btnAkanDatang, btnFavorit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRiwayat = findViewById(R.id.btnRiwayat);
        btnAkanDatang = findViewById(R.id.btnAkanDatang);
        btnFavorit = findViewById(R.id.btnFavorit);

        final SQLiteDatabase mydatabase = openOrCreateDatabase("database_0573",MODE_PRIVATE,null);
        mydatabase.execSQL("CREATE TABLE IF NOT EXISTS Favorit(idevent VARCHAR, namaevent VARCHAR, liga VARCHAR, venue VARCHAR, waktu VARCHAR, hasil VARCHAR, image VARCHAR);");

        btnRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RiwayatScreen.class);
                startActivity(intent);
            }
        });

        btnAkanDatang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AkanDatangScreen.class);
                startActivity(intent);
            }
        });

        btnFavorit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FavoritScreen.class);
                startActivity(intent);
            }
        });
    }
}
