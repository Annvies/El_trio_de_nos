package com.example.elTrioDeNos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaCategoriaBinding
import com.example.elTrioDeNos.databinding.ActivityPantallaResultadosBinding

class PantallaResultados : AppCompatActivity() {
    private lateinit var binding: ActivityPantallaResultadosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPantallaResultadosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_pantalla_resultados)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}