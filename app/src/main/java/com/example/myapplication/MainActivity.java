package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createDB();
        inserturunadi();
    }

    private void createDB()


    {
        database = this.openOrCreateDatabase("Urun", MODE_PRIVATE, null);
        String TABLO = "CREATE TABLE IF NOT EXISTS urunler(id INTEGER PRIMARY KEY," +
                "urunadi TEXT," +
                "fiyat INTEGER," +
                "adet INTEGER)";
        database.execSQL(TABLO);
    }

    private void inserturunadi()

    {
        String SORGU="INSERT INTO urunler(urunadi,fiyat,adet) VALUES(?,?,?)";
        SQLiteStatement results=database.compileStatement(SORGU);
        results.bindString(1,"Araba");
        results.bindLong(2,1000);
        results.bindLong(3,10);
        results.execute();



    }
}

