package com.example.crud_mobile

import android.content.Intent
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    val film_id: ArrayList<String>      = arrayListOf()
    val film_judul: ArrayList<String>   = arrayListOf()
    val film_sutradara: ArrayList<String> = arrayListOf()
    val film_genre: ArrayList<String> = arrayListOf()
    val film_tahunrilis: ArrayList<String> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnTambah = findViewById<FloatingActionButton>(R.id.float_add)
        btnTambah.setOnClickListener {
            val intentKita = Intent(this, TambahFilmActivity::class.java)
            startActivity(intentKita)
        }
        simpanDataDiArray()
        val filmAdapter = FilmAdapter(this,film_id,film_judul,film_sutradara,film_genre,film_tahunrilis)
        val rv_films = findViewById<RecyclerView>(R.id.rv_films)
        rv_films.adapter = filmAdapter
        rv_films.layoutManager = LinearLayoutManager(this)
        rv_films.itemAnimator = DefaultItemAnimator()
    }
    fun simpanDataDiArray(){
        val dbSaya            = MyDBHelper(this)
        val dataSaya: Cursor = dbSaya.BacaSemuaData()

        if(dataSaya.count == 0){
            Toast.makeText(this,"Data Tidak Ada!", Toast.LENGTH_SHORT).show()
        }
        else{
            while (dataSaya.moveToNext()){
                film_id.add(dataSaya.getString(0))
                film_judul.add(dataSaya.getString(1))
                film_sutradara.add(dataSaya.getString(2))
                film_genre.add(dataSaya.getString(3))
                film_tahunrilis.add(dataSaya.getString(4))
            }
        }
    }
}