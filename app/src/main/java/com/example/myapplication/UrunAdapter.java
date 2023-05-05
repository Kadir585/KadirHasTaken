package com.example.myapplication;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintSet;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UrunAdapter extends ArrayAdapter<Urun> {
    ArrayList<Urun> urunler;
    Context context;

    public UrunAdapter(@NonNull Context context, ArrayList<Urun> urunler) {
        super(context, 0, urunler);
        this.context = context;
        this.urunler = urunler;

    }

    @Override
    public int getCount() {
        return urunler.size();
    }

    @Override
    public Urun getItem(int i) {
        return urunler.get(i);

    }

    @Override
    public long getItemId(int i) {
        return urunler.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView satirUrunAdi;
        TextView satirUrunFiyati;
        TextView satirUrunAdet;
        ImageView satirUrunResmi;

        Urun urun = urunler.get(i);
        if (view == null){
            view= LayoutInflater.from(context).inflate(R.layout.activity_uyg3,null);

        }
        satirUrunAdi=view.findViewById(R.id.textView4);
        satirUrunFiyati=view.findViewById(R.id.textView5);
        satirUrunAdet=view.findViewById(R.id.textView6);
        satirUrunResmi=view.findViewById(R.id.imageView);

        satirUrunAdi.setText(urun.getUrunAdi());
        satirUrunFiyati.setText(String.format("%.02f",urun.getFiyat())+"TL");
        satirUrunAdet.setText(urun.getAdet()+"");
        satirUrunResmi.setImageResource(urun.getResim());
        return view;


    }
}












