package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class Uyg3 extends AppCompatActivity {
    SQLiteDatabase database;

    Urun urun;
    ArrayList<Urun> urunler;
    ListView listView;
    UrunAdapter urunAdapter;

    Button btnKaydet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        urunler = new ArrayList<>();
        listView = findViewById(R.id.listView);
        urunAdapter = new UrunAdapter(Uyg3.this, urunler);
        btnKaydet = findViewById(R.id.button2);
        listView.setAdapter(urunAdapter);

        getAllurunler();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Intent i = new Intent(Uyg3.this, UrunDetay.class);
                i.putExtra("id", urunler.get(position).getId());
                startActivity(i);
            }
        });
    }

    public void btnYeniKayitEkleClick(View view) {

        Intent i = new Intent(Uyg3.this, UrunKayit.class);
        i.putExtra("mod", "ekle");
        startActivity(i);
    }

    private void getAllurunler() {
        database = this.openOrCreateDatabase("urun", MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("SELECT * FROM urunler", null);
        int KolonId = cursor.getColumnIndex("id");
        int KolonUrunadi = cursor.getColumnIndex("urunadi");
        int KolonFiyat = cursor.getColumnIndex("fiyat");
        int KolonAdet = cursor.getColumnIndex("adet");

        while (cursor.moveToNext()) {
            ;
            int id = cursor.getInt(KolonId);
            String urunadi = cursor.getString(KolonUrunadi);
            double fiyat = cursor.getDouble(KolonFiyat);
            long adet = cursor.getLong(KolonAdet);

            urun = new Urun(id, urunadi, fiyat, adet, R.drawable.resim_yok);
            urunler.add(urun);


        }
        cursor.close();
    }
}




