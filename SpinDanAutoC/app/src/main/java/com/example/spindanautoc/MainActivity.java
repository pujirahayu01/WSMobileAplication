package com.example.spindanautoc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

//membuat sebuah class main activity dengan modifier public agar dapat di akses dengan mudah
//class main ini adalah clas turunan dari appcompat activity
public class MainActivity extends AppCompatActivity {

    //mempunyai modifier private di lengkapi dengan method final yang artinya, value dalam method ini tidak dapat di ubah nilainya
    private static final String[] Tempat = new String[]{
            //value dari method
      "Jember","Surabaya", "Probolinggo","Nganjuk","Tuban", "Sidoarjo" , "Pasuruan", "Malang" , "Solo"
    };
    //variable spinner
Spinner spinner;
//variable button
Button butn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Auto Complate ini
        //mendeklarasikan autocomplete yaitu edittext dan kita sambungkan dengan id dari autocomplete yang kita buat dalam file XML
        AutoCompleteTextView editText = findViewById(R.id.actv);

        //ArrayAdapter berfungsi untuk mengatur konten yang akan ditmpilkan pada View
        //ArrayAdapter menerima data dari ArrayList, lalu menampilkannya pada Auto compatetext atau recycleView
        //tempat adalah nama method final yang berisi value tempat
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Tempat);
        //setAdapter berfungsi untuk menampilkan value pada variable editText
        editText.setAdapter(adapter1);


        //spinner
        //mendeklarasikan spinner dengan menggubungkan id dari spinner yang telah di buat dalam file XML
        Spinner spinner = findViewById(R.id.spinner);

        //pada baris ini menghubungkan atau memanggil nama string array yang di buat pada file string.xml yaitu negara
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.negara, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //setadapter berfungsi untuk menampilkan value dari variable spinner dan di lengkapi dengan parameter adapter.
        spinner.setAdapter(adapter);

        //melakukan set listener untuk mengetahui saat sebuah item dipilih/di klik
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {



            @Override
            // membuat sebuah method on item selected ketika suatu aitem di pilih
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                //memunculkan toast + value Spinner yang dipilih (diambil dari parent) dengan menggunakan parent.get
                Toast.makeText(parent.getContext(), " Negara Anda : " + parent.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            //method ketika tidak ada item yang di pilih
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    //coding button
        //mendeklarasikan button dengan menggubungkan id dari button yang telah di buat dalam file XML
        Button butn = findViewById(R.id.btn);

        //membuat action ketika button di click
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //memunculkan sebuah toast /aksi, nanti ketika button di click maka akan memunculkan kata data berhasil di input.
                Toast toast = Toast.makeText(view.getContext(),"Data Berhasil Di Input",Toast.LENGTH_SHORT);
                //menampilkan kata dalam toast
                toast.show();

            }
        });



    }

}