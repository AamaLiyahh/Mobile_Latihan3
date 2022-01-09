package com.example.crud_mobile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TambahFilmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_film)

        val txtJudul = findViewById<EditText>(R.id.txtJudul)
        val txtSutradaraa = findViewById<EditText>(R.id.txtSutradara)
        val txtGenree = findViewById<EditText>(R.id.txtGenre)
        val txtTahunRiliss = findViewById<EditText>(R.id.txtTahunRilis)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)

        btnSimpan.setOnClickListener {
            val dbSaya = MyDBHelper(this)
            dbSaya.tambahFilm(
                txtJudul.text.toString().trim(),
                txtSutradaraa.text.toString().trim(),
                txtGenree.text.toString().trim(),
                Integer.valueOf(txtTahunRiliss.text.toString().trim())
            )
        }

    }
}