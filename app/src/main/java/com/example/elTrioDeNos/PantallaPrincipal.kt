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

    companion object{
    val ID_GASTOS = "id_gasto"

    }

    private lateinit var binding: ActivityPantallaPrincipalBinding
    val  adapter by lazy { GastosRecyclerAdapter() }

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

        val longitudPass = intent.getIntExtra("password_length", 0)

        /////////////////bindeo con el recycleView////////////////////////////

        val nuevaLista =mutableListOf<Gasto>()
        nuevaLista.add(Gasto(2.50, fecha = Date().toString(),"pilfrut"))

        nuevaLista.add(Gasto(1.00, Date().toString(), "grosso"))

        nuevaLista.add(Gasto(17.00, Date().toString(), "grosso"))

        adapter.addDataCards(nuevaLista)

        binding.recyclePantallaPrincipal.layoutManager = GridLayoutManager(contexto,1)

        binding.recyclePantallaPrincipal.adapter = adapter

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
            cambioPantallaMenu.putExtra("pasword_lenght", longitudPass)
            startActivity(cambioPantallaMenu)
        }

        binding.btnBuscar.setOnClickListener {
            val cambioCalendario: Intent = Intent(contexto, PantallaCalendario::class.java)
            startActivity(cambioCalendario)
        }


    }
}