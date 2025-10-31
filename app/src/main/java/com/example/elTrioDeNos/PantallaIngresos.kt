package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.elTrioDeNos.dataClases.Ingreso
import com.example.elTrioDeNos.databinding.ActivityPantallaIngresosBinding
import java.util.Date

class PantallaIngresos : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaIngresosBinding
    val adapter by lazy { IngresosRecyclerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaIngresosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val contexto: Context = this

        //////////////////bindeo con recycleView////////////////////////////////////

        val nuevaLista = mutableListOf<Ingreso>()
        nuevaLista.add(Ingreso(400.0, "mesada", Date()))

        nuevaLista.add(Ingreso(50.0, "deuda", Date()))

        nuevaLista.add(Ingreso(2.50, "chamba", Date()))

        adapter.addDataCards(nuevaLista)

        binding.recyclePantallaIngresos.layoutManager = GridLayoutManager(contexto, 1)

        binding.recyclePantallaIngresos.adapter = adapter

        /////////////////////////////////////////////////////////////////////////









        binding.btnAnadirIngreso.setOnClickListener {
            val cambioNuevoIngreso: Intent = Intent(contexto, PantallaNuevoIngreso::class.java)
            startActivity(cambioNuevoIngreso)
        }

    }
}