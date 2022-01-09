package com.example.crud_mobile

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class UbahFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_film)

        val actionBar =supportActionBar
        if (intent.hasExtra("judul")) {
            actionBar?.title = intent.getStringExtra("judul")
        }

        val btnUbah = findViewById<Button>(R.id.btn_ubah)

        getIntentData()

        btnUbah.setOnClickListener {
            val dbKita = MyDBHelper(this)

            val idFilm = intent.getStringExtra("id")
            val judulFilm = findViewById<EditText>(R.id.txt_judul).text.toString()
            val sutradaraFilm = findViewById<EditText>(R.id.txt_sutradara).text.toString()
            val genreFilm = findViewById<EditText>(R.id.txt_genre).text.toString()
            val tahunrilisFilm = findViewById<EditText>(R.id.txt_tahunrilis).text.toString()

            dbKita.ubahFilm(idFilm, judulFilm, sutradaraFilm, genreFilm, tahunrilisFilm)
        }
        val  btnHapus = findViewById<Button>(R.id.btnHapus)
        btnHapus.setOnClickListener {
            dialogKonfirmasi()
        }
    }
    fun getIntentData() {
        if (
            intent.hasExtra("id") &&
            intent.hasExtra("judul") &&
            intent.hasExtra("sutradara") &&
            intent.hasExtra("genre") &&
            intent.hasExtra("tahunrilis")
        ){

            val idfilm          = intent.getStringExtra("id")
            val judulfilm       = intent.getStringExtra("judul")
            val sutradarafilm   = intent.getStringExtra("sutradara")
            val genrefilm       = intent.getStringExtra("genre")
            val tahunrilis      = intent.getStringExtra("tahunrilis")

            val txtjudul = findViewById<EditText>(R.id.txt_judul)
            val txtsutradara = findViewById<EditText>(R.id.txt_sutradara)
            val txtgenre = findViewById<EditText>(R.id.txt_genre)
            val txttahunrilis = findViewById<EditText>(R.id.txt_tahunrilis)

            txtjudul.setText(judulfilm)
            txtsutradara.setText(sutradarafilm)
            txtgenre.setText(genrefilm)
            txttahunrilis.setText(tahunrilis)
        } else{
            Toast.makeText(this,"Tidak Ada Data !", Toast.LENGTH_SHORT).show()
        }
    }
    fun dialogKonfirmasi(){
        val idFilm  = intent.getStringExtra("id")
        val judulFilm = intent.getStringExtra("judul")

        val alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Delete " + judulFilm + " ?")
        alertDialog.setMessage("Apakah anda yakin menghapus " + judulFilm + " ?")

        alertDialog.setPositiveButton("iya", DialogInterface.OnClickListener{dialog, which ->
            val dbKita = MyDBHelper(this)
            dbKita.hapusFilm(idFilm)
            startActivity(Intent(this, MainActivity::class.java))
        })
        alertDialog.setNegativeButton("Tidak", DialogInterface.OnClickListener { dialog, which ->  })
        alertDialog.create().show()
    }

}