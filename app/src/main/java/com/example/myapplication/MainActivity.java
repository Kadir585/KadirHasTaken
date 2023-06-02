package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        createDB();

    }

    private void createDB() {
        database = this.openOrCreateDatabase("urun", MODE_PRIVATE, null);
        String TABLO = "CRETA TABLE IF NOT EXIST urunler(id INTEGAR PRIMARY KEY," +
                "urunAdi TEXT," +
                "fiyat DOUBLE," +
                "adet INTAGER)" +
                database.execSQL(TABLO);

    }
    public void
    }
}
