package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elTrioDeNos.dataClases.Gasto
import com.example.elTrioDeNos.databinding.ActivityPantallaPrincipalBinding
import java.util.Date
import kotlin.collections.listOf

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

        /////////////////bindeo con el recycleView////////////////////////////

        val nuevaLista =mutableListOf<Gasto>()
        nuevaLista.add(Gasto(2.50, fecha = Date(),"pilfrut"))

        nuevaLista.add(Gasto(1.00, Date(), "grosso"))

        //adapter.addDataCards(nuevaLista) // TO DO

        binding.recyclePantallaPrincipal.layoutManager = GridLayoutManager(contexto,2)

        //binding.recyclePantallaPrincipal.adapter = adapter //TO DO

        ////////////////////////////////////////////////////////////////////////

        binding.anadirIngresoBoton.setOnClickListener {
            val cambioAIngresos: Intent = Intent(contexto, PantallaIngresos::class.java)
            startActivity(cambioAIngresos)
        }

        binding.anadirGastoBoton.setOnClickListener {
            val cambioPantallaGastosCat: Intent = Intent(contexto, PantallaGastosCtegoria::class.java)
            startActivity(cambioPantallaGastosCat)
        }

        binding.menuBoton.setOnClickListener {
            val cambioPantallaMenu: Intent = Intent(contexto, PantallaMenu::class.java)
            startActivity(cambioPantallaMenu)
        }

        binding.btnBuscar.setOnClickListener {
            val cambioCalendario: Intent = Intent(contexto, PantallaCalendario::class.java)
            startActivity(cambioCalendario)
        }


    }
}