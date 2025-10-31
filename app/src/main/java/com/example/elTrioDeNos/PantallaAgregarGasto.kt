package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaAgregarGastoBinding

class PantallaAgregarGasto : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaAgregarGastoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaAgregarGastoBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val contexto: Context = this

        binding.btnAgregarGasto.setOnClickListener {
            val volverPatallaPrincipal: Intent = Intent(contexto, PantallaPrincipal::class.java)
            startActivity(volverPatallaPrincipal)
        }
    }
}