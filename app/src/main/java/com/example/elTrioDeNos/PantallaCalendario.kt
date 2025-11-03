package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaCalendarioBinding

class PantallaCalendario : AppCompatActivity() {

    companion object{
        const val FECHA_ENVIADA = "fechaSelec"
    }

    private lateinit var binding: ActivityPantallaCalendarioBinding
    private var fecha: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaCalendarioBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val contexto: Context = this

        binding.datePicker.setOnDateChangedListener { _, year, month, day ->
            val dia = if (day < 10) "0$day" else "$day"
            val mes = if (month + 1 < 10) "0${month + 1}" else "${month + 1}"
            fecha = "$dia/$mes/$year"
        }

        binding.btnSelecionarFecha.setOnClickListener {
            if(fecha.isEmpty()){
                Toast.makeText(contexto,"Por favor seleccione una fecha", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(contexto,fecha, Toast.LENGTH_SHORT).show()
                val cambioCategorias: Intent = Intent(contexto, PantallaCategoria::class.java)
                cambioCategorias.putExtra(FECHA_ENVIADA, fecha)
                startActivity(cambioCategorias)
            }
        }
    }
}