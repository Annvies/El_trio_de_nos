package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaPrincipalBinding

class PantallaPrincipal : AppCompatActivity() {


    private lateinit var binding: ActivityPantallaPrincipalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaPrincipalBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val contexto: Context = this

        binding.anadirIngresoBoton.setOnClickListener {
            val cambioAIngresos: Intent = Intent(contexto, PantallaIngresos::class.java)
            startActivity(cambioAIngresos)
        }

        binding.botonLupa.setOnClickListener {
            val cambioACalendario: Intent = Intent(contexto, PantallaCalendario::class.java)
            startActivity(cambioACalendario)
        }
    }
}