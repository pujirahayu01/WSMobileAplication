package com.example.impintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

TextView tvnama,tvnim; // sebagai penampung data dari main activity

Button btnweb; // mendeklarasikan button untuk menuju link




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       tvnama =findViewById(R.id.tv_nama); //membuat variable yg di buat berisi id dari textview
       tvnim = findViewById(R.id.tv_nim);
    //explicit intent
       Intent terima = getIntent();//mendapatkan data intent/ data yang di kirim

       String terimanama = terima.getStringExtra("kirimnama"); // mendapatkan data yang di kirim oleh activity main
        String terimanim = terima.getStringExtra("kirimnim");

        //implicit intent
        tvnama.setText(terimanama);//menampilkan data yang di terima ke variable yg di buat
        tvnim.setText(terimanim);

        btnweb = findViewById(R.id.goto_link);//membuat variable button berisi id button


        btnweb.setOnClickListener(new View.OnClickListener() { // memberi action pada button
            @Override
            public void onClick(View view) {


                String url = "https://www.instagram.com/buildwithangga/"; // mengambil data dari edit text link dan di simpan ke variable string
                Intent bukawebsite = new Intent(Intent.ACTION_VIEW); // membuat objek intent
                bukawebsite.setData(Uri.parse(url));//melakukan parsing alamat website yg disimpan di variable string agar di kenali oleh android
                startActivity(bukawebsite);// kode untuk memulai intent
            }
        });
    }
}