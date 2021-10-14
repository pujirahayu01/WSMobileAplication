package com.example.impintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.submit);//membuat variable btn dan menghubungkan dengan id button submit
        EditText txtnm = findViewById(R.id.et_nama);//membuat variable dan menghubungkan dengan id edit text
        EditText txtnim = findViewById(R.id.et_nim);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // memberikan action pada button
                String nama = txtnm.getText().toString(); // mengambil data yang di inputkan dan di simpan pada variable nama, dan di ubah menjadi string
                String nim = txtnim.getText().toString();

                //membuat objek inten, dengan menentukan asal data dari class apa dan akan di kirim pada kelas mana.
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                intent.putExtra("kirimnama",nama);//berguna untuk mengirimkan data nama kepada secondactivity
                intent.putExtra("kirimnim",nim);
                startActivity(intent); //memulai menjalankan intent
            }
        });
    }
}