package com.example.listvi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView ls;
    //membuat sebuah objek listview

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    ls = (ListView) findViewById(R.id.listView);//memanggil listview dengan id dari activity_main.xml

    //nama adapter ini adalah instasiasi sebuah objek dari array adapter, dan memanggil nama dari string array yaitu namamenu dari file string.xml.
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Namamenu, android.R.layout.simple_list_item_1);

        ls.setAdapter(adapter);//menetapkan sebuah adapter dan berfungsi untuk menampilkan data

    ls.setOnItemClickListener(new AdapterView.OnItemClickListener () {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
            //berfungsi untuk menampilkan sebuah aksi sesuai keinginan ketika di clik

            String Namamenu = ((TextView)view).getText().toString();
        Toast.makeText(getApplicationContext(),"Clicked"+Namamenu, Toast.LENGTH_SHORT).show();
        //membuat sebuah aksi yang ketika nama menu di clik akan memunculkan nama menu itu sendiri.dan akan di tampilkan pada fungsi show()
        }



    });
    }
}
