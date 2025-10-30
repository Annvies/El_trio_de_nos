package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaCategoriaBinding

class PantallaCategoria : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaCategoriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaCategoriaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val contexto: Context = this
        binding.btnCategoriaBus1.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus2.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus3.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus4.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus5.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus6.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus7.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus8.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus9.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus10.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus11.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }
        binding.btnCategoriaBus12.setOnClickListener {
            val cambioPantallaResultados: Intent = Intent(contexto, PantallaResultados::class.java)
            startActivity(cambioPantallaResultados)
        }

    }
}