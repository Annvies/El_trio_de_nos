package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.PantallaPrincipal.Companion.ID_GASTOS
import com.example.elTrioDeNos.databinding.ActivityPantallaAgregarGastoBinding
import com.example.elTrioDeNos.dataClases.Gasto
import kotlinx.serialization.json.Json
class PantallaAgregarGasto : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaAgregarGastoBinding

    private lateinit var sharedPreferences: SharedPreferences

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

//        val stringClase = intent.getStringExtra(ID_GASTOS) ?: ""
//        val GastoUno: Gasto? = if (!stringClase.isEmpty()) {
//            Json.decodeFromString<Gasto>(stringClase)
//        } else {
//            null
//        }

         fun guardarDataClass(gastos: Gasto) {
            val asdfgh: String = Json.encodeToString(gastos)
            val editor = sharedPreferences.edit()
            editor.putString("añadir", asdfgh)
            editor.apply()
        }
        binding.btnAgregarGasto.setOnClickListener {
            val montoTexto = binding.editarTexto1.text.toString()
            val notaTexto =binding.editarTexto2.text.toString()
            val montoDouble: Double = montoTexto.toDoubleOrNull() ?: 0.0

            val nuevoGasto = Gasto(
                monto = montoDouble,
                nota = notaTexto,
                fecha = System.currentTimeMillis().toString()

            )
            guardarDataClass(nuevoGasto)
        }




        val contexto: Context = this

        binding.btnAgregarGasto.setOnClickListener {
            val volverPatallaPrincipal: Intent = Intent(contexto, PantallaPrincipal::class.java)
            startActivity(volverPatallaPrincipal)
        }
    }
}