package com.example.recycleviewdatamovies;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MoviesRecycleViewAdapter extends RecyclerView.Adapter<MoviesRecycleViewAdapter.MovieViewHolder> {
    ArrayList<Movies> arrayListMovies;
    public MoviesRecycleViewAdapter(ArrayList<Movies> arrayListMovies){
        this.arrayListMovies= arrayListMovies;
    }

    @NonNull
    @Override
    public MoviesRecycleViewAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //mengambil data/layout dari item.xml
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesRecycleViewAdapter.MovieViewHolder holder, int position) {
        //membuat sebuah konstanta
        final Movies movies = arrayListMovies.get(position);//untuk mendapatkan index dari data yang ada pada array list.
        holder.imageView.setImageResource(movies.getImage());
        holder.textViewTitle.setText(movies.getTitle());
        holder.textViewRating.setText(String.valueOf(movies.getRating()));
        holder.textViewReleaseDate.setText(movies.getReleasedate());
        //membuat action yang ketika di clik maka akan mengeluarkan deskripsinya
        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // fungsinya melempar nilai menggunakan inten agar dapat ditangkap oleh detail movie
                Intent intent = new Intent(holder.itemView.getContext(), DetailMovieActivity.class);
                intent.putExtra("Movies",movies);
                //akan menjalankan perpindahan activity dari main activity ke detail movie activity
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //untuk mendapatkan jumlah data perlu menerapkan fungsi di bawah ini.
        return arrayListMovies.size();
    }
//class movie view adalah class turunan dari class recycleview
    public class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle, textViewRating, textViewReleaseDate;
        ImageView imageView;
        public MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            //mendeskripsikan textview dengan memanggil id dari textview
            textViewTitle = itemView.findViewById(R.id.tvTitle);
            textViewRating = itemView.findViewById(R.id.tvRating);
            textViewReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
