package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.PantallaCalendario.Companion.FECHA_ENVIADA
import com.example.elTrioDeNos.databinding.ActivityPantallaCategoriaBinding

class PantallaCategoria : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaCategoriaBinding

    companion object {
        const val EXTRA_FECHA = "fechaSeleccionada"
        const val EXTRA_CATEGORIA = "categoriaSeleccionada"
    }

    val contexto: Context = this

    private var fecha: String? = null

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
        fecha = intent.getStringExtra(FECHA_ENVIADA)

        binding.btnCatGeneral.setOnClickListener {
            resultado("general")
        }
        binding.btnCatComida.setOnClickListener {
            resultado("comida")
        }
        binding.btnCatEntretenimiento.setOnClickListener {
            resultado("entretenimiento")
        }
        binding.btnCatTransporte.setOnClickListener {
            resultado("transporte")
        }
        binding.btnCatMercado.setOnClickListener {
            resultado("mercado")
        }
        binding.btnCatMantenimiento.setOnClickListener {
            resultado("mantenimiento")
        }
        binding.btnCatRopa.setOnClickListener {
            resultado("ropa")
        }
        binding.btnCatEstudios.setOnClickListener {
            resultado("estudios")
        }
        binding.btnCatMakeup.setOnClickListener {
            resultado("makeup")
        }
        binding.btnCatSalud.setOnClickListener {
            resultado("salud")
        }
        binding.btnCatRegalos.setOnClickListener {
            resultado("regalos")
        }
        binding.btnCatDeudas.setOnClickListener {
            resultado("deudas")
        }
    }

    fun resultado(categoria: String){
        val cambioResultado: Intent = Intent(contexto, PantallaResultados::class.java)
        cambioResultado.putExtra(EXTRA_FECHA, fecha)
        cambioResultado.putExtra(EXTRA_CATEGORIA, categoria)
        startActivity(cambioResultado)
    }


}