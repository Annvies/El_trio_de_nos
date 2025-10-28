package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaCalendarioBinding
class PantallaCalendario : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaCalendarioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPantallaCalendarioBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        setContentView(R.layout.activity_pantalla_calendario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val contexto: Context = this

        binding.buttonSetDate.setOnClickListener {
            val cambioPantallaCategoria: Intent = Intent(contexto, PantallaCategoria::class.java)
            startActivity(cambioPantallaCategoria)
        }
    }
}