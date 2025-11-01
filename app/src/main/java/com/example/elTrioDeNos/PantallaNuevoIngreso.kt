package com.example.elTrioDeNos

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.dataClases.Ingreso
import com.example.elTrioDeNos.databinding.ActivityPantallaNuevoIngresoBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class PantallaNuevoIngreso : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaNuevoIngresoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaNuevoIngresoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.agregarIngreso.setOnClickListener {
            guardarIngreso()
        }
    }

    private fun guardarIngreso() {
        val montoTexto = binding.etMonto.text.toString().trim()
        val nota = binding.etNota.text.toString().trim()

        // Validación básica
        if (montoTexto.isEmpty()) {
            Toast.makeText(this, "Por favor, ingresa un monto.", Toast.LENGTH_SHORT).show()
            return
        }

        val monto = montoTexto.toDoubleOrNull()
        if (monto == null || monto <= 0) {
            Toast.makeText(this, "Monto inválido.", Toast.LENGTH_SHORT).show()
            return
        }

        // Crear fecha actual
        val fecha = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())

        // Crear objeto Ingreso
        val nuevoIngreso = Ingreso(
            monto = monto,
            nota = nota,
            fecha = fecha
        )

        // Guardar en SharedPreferences usando DatosManager
        DatosManager.guardarIngreso(this, nuevoIngreso)

        Toast.makeText(this, "Ingreso registrado correctamente.", Toast.LENGTH_SHORT).show()

        val intent = Intent(this, PantallaIngresos::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        finish()
    }
}