package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaAgregarGastoBinding
import com.example.elTrioDeNos.dataClases.Gasto
import kotlinx.serialization.json.Json
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

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
        val contexto: Context = this

        val categoriaSeleccionada = intent.getStringExtra("categoria")

        binding.btnAgregarGasto.setOnClickListener {
            guardarGasto(categoriaSeleccionada)
            val volverPatallaPrincipal: Intent = Intent(contexto, PantallaPrincipal::class.java)
            startActivity(volverPatallaPrincipal)
        }
    }

    private fun guardarGasto(categoria: String?) {
        val montoTexto = binding.montoGastado.text.toString().trim()
        val nota = binding.nota.text.toString().trim()

        if (montoTexto.isEmpty()) {
            Toast.makeText(this, "Por favor ingresa un monto.", Toast.LENGTH_SHORT).show()
            return
        }

        val monto = montoTexto.toDoubleOrNull()
        if (monto == null || monto <= 0) {
            Toast.makeText(this, "Monto inválido.", Toast.LENGTH_SHORT).show()
            return
        }

        val fecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

        val nuevoGasto = Gasto(
            categoria = categoria ?: "Sin categoría",
            monto = monto,
            nota = nota,
            fecha = fecha
        )

        DatosManager.guardarGasto(this, nuevoGasto)

        Toast.makeText(this, "Gasto registrado correctamente.", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, PantallaPrincipal::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}