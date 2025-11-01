package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaGastosCtegoriaBinding
import com.example.elTrioDeNos.databinding.ActivityPantallaIngresosBinding

class PantallaGastosCtegoria : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaGastosCtegoriaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaGastosCtegoriaBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val contexto: Context = this

        binding.DeudasBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","deudas")
            startActivity(cambioAgregarGasto)
        }
        binding.comidaBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","comida")
            startActivity(cambioAgregarGasto)
        }
        binding.EntrenimientoBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","entretenimiento")
            startActivity(cambioAgregarGasto)
        }
        binding.TransporteBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","transporte")
            startActivity(cambioAgregarGasto)
        }
        binding.MercadoBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","mercado")
            startActivity(cambioAgregarGasto)
        }
        binding.mantenimientoBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","mantenimiento")
            startActivity(cambioAgregarGasto)
        }
        binding.ropaBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","ropa")
            startActivity(cambioAgregarGasto)
        }
        binding.estudiosBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","estudios")
            startActivity(cambioAgregarGasto)
        }
        binding.makeupBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","makeup")
            startActivity(cambioAgregarGasto)
        }
        binding.SaludBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","salud")
            startActivity(cambioAgregarGasto)
        }
        binding.RegalosBoton.setOnClickListener {
            val cambioAgregarGasto: Intent = Intent(contexto, PantallaAgregarGasto::class.java)
            cambioAgregarGasto.putExtra("categoria","regalos")
            startActivity(cambioAgregarGasto)
        }

    }
}