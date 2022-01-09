package com.example.crud_mobile;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolderSaya> {

    private Context context;
    private ArrayList film_id, film_judul, film_sutradara, film_genre, film_tahunrilis;

    FilmAdapter(
            Context context,
            ArrayList film_id,
            ArrayList film_judul,
            ArrayList film_sutradara,
            ArrayList film_genre,
            ArrayList film_tahunrilis
    ){
        this.context    = context;
        this.film_id    = film_id;
        this.film_judul = film_judul;
        this.film_sutradara = film_sutradara;
        this.film_genre   = film_genre;
        this.film_tahunrilis   = film_tahunrilis;

    }

    @NonNull
    @Override
    public ViewHolderSaya onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflaterKita = LayoutInflater.from(context);
        View viewSaya = inflaterKita.inflate(R.layout.sitiamaliyah8020180240, parent, false);
        return new ViewHolderSaya(viewSaya);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSaya holder, @SuppressLint("RecyclerView") int position) {
        holder.txt_id_film.setText(String.valueOf(film_id.get(position)));
        holder.txt_judul_film.setText(String.valueOf(film_judul.get(position)));
        holder.txt_film_sutradara.setText(String.valueOf(film_sutradara.get(position)));
        holder.txt_film_genre.setText(String.valueOf(film_genre.get(position)));
        holder.txt_film_tahunrilis.setText(String.valueOf(film_tahunrilis.get(position)));
        holder.layoutUtama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentKita = new Intent(context, UbahFilmActivity.class);
                intentKita.putExtra("id", String.valueOf(film_id.get(position)));
                intentKita.putExtra("judul", String.valueOf(film_judul.get(position)));
                intentKita.putExtra("sutradara", String.valueOf(film_sutradara.get(position)));
                intentKita.putExtra("genre", String.valueOf(film_genre.get(position)));
                intentKita.putExtra("tahunrilis", String.valueOf(film_tahunrilis.get(position)));

                context.startActivity(intentKita);
            }
        });
    }

    public int getItemCount() {
        return film_id.size();
    }

    public class ViewHolderSaya extends RecyclerView.ViewHolder {

        TextView txt_id_film, txt_judul_film, txt_film_sutradara, txt_film_genre, txt_film_tahunrilis;
        LinearLayout layoutUtama;

        public ViewHolderSaya(@NonNull View itemView) {
            super(itemView);

            txt_id_film         = itemView.findViewById(R.id.txt_film_id);
            txt_judul_film      = itemView.findViewById(R.id.txt_film_judul);
            txt_film_sutradara  = itemView.findViewById(R.id.txt_film_sutradara);
            txt_film_genre        = itemView.findViewById(R.id.txt_film_genre);
            txt_film_tahunrilis        = itemView.findViewById(R.id.txt_film_tahunrilis);
            layoutUtama         = itemView.findViewById(R.id.layout_utama);
        }
    }
}
