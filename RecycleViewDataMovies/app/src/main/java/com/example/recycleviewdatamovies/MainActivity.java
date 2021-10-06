package com.example.recycleviewdatamovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MoviesRecycleViewAdapter adapter;
    ArrayList<Movies> objMovies = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        objMovies.add(new Movies("The Suicide Squad","Action, Adventure, Comedy", "James Gunn",7.3 ,"Supervillains Harley Quinn, Bloodsport, Peacemaker and a collection of nutty cons at Belle Reve prison join the super-secret, super-shady Task Force X as they are dropped off at the remote, enemy-infused island of Corto Maltese." , "6 Agustus 2021" , R.mipmap.ic_launcher));
        objMovies.add(new Movies("Black Widow","Action, Adventure","Cate Shortland" , 6.8 ,"Natasha Romanoff confronts the darker parts of her ledger when a dangerous conspiracy with ties to her past arises." ,"8 July 2014",R.drawable.blackwdw));
        objMovies.add(new Movies("Jumanji" , "Action, Adventure, Comedy", "Jake Kasdan" , 6.9 , "Four teenagers are sucked into a magical video game, and the only way they can escape is to work together to finish the game." ,"4 December 2019." , R.drawable.jumanji));

        adapter = new MoviesRecycleViewAdapter(objMovies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
}