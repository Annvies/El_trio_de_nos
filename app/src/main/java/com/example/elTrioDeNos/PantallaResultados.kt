package com.example.elTrioDeNos

import android.content.Context
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.elTrioDeNos.PantallaCategoria.Companion.EXTRA_CATEGORIA
import com.example.elTrioDeNos.PantallaCategoria.Companion.EXTRA_FECHA
import com.example.elTrioDeNos.databinding.ActivityPantallaCategoriaBinding
import com.example.elTrioDeNos.databinding.ActivityPantallaResultadosBinding

class PantallaResultados : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaResultadosBinding

    private lateinit var adapter: GastosRecyclerAdapter

    val contexto: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPantallaResultadosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fechaDeLaBusqueda: String= intent.getStringExtra(EXTRA_FECHA)?: ""
        val categoria: String = intent.getStringExtra(EXTRA_CATEGORIA) ?: "general"

        adapter = GastosRecyclerAdapter()
        binding.recycleBusqueda.adapter = adapter
        binding.recycleBusqueda.layoutManager = LinearLayoutManager(this)

        val gastosFiltrados = DatosManager.buscarGastos(this, fechaDeLaBusqueda, categoria)
        adapter.addDataCards(gastosFiltrados)

        binding.textFecha.setText(fechaDeLaBusqueda)
        binding.textCategoria.setText(categoria)

    }
}