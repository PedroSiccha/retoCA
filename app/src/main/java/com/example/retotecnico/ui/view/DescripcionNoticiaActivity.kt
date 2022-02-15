package com.example.retotecnico.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import com.example.retotecnico.databinding.ActivityDescripcionNoticiaBinding
import com.example.retotecnico.util.Constantes

class DescripcionNoticiaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDescripcionNoticiaBinding
    val isLoading = MutableLiveData<Boolean>()
    var autor: String = ""
    var fecha: String = ""
    var titulo: String = ""
    var descripcion: String = ""
    val cnt = Constantes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDescripcionNoticiaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onCreate()

        binding.btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) }

    }

    private fun onCreate() {
        isLoading.postValue(true)
        autor = intent.getStringExtra(cnt.AUTOR).toString()
        fecha = intent.getStringExtra(cnt.FECHA).toString()
        titulo = intent.getStringExtra(cnt.TITULO).toString()
        descripcion = intent.getStringExtra(cnt.DESCRIPCION).toString()

        binding.tvAutor.setText(autor)
        binding.tvTitulo.setText(titulo)
        binding.tvDescipcion.setText(descripcion)
        binding.tvFecha.setText(fecha)

        isLoading.postValue(false)
    }
}