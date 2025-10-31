package com.example.elTrioDeNos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elTrioDeNos.GastosRecyclerAdapter.GastosViewHolder
import com.example.elTrioDeNos.dataClases.Gasto
import com.example.elTrioDeNos.dataClases.Ingreso
import com.example.elTrioDeNos.databinding.TarjetasGastosBinding
import com.example.elTrioDeNos.databinding.TarjetasIngresosBinding

class IngresosRecyclerAdapter:
        RecyclerView.Adapter<IngresosRecyclerAdapter.IngresosViewHolder>() {

        private val dataCards = mutableListOf<Ingreso>()
        private var context: Context? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngresosViewHolder {
            context = parent.context
            return IngresosViewHolder(
                TarjetasIngresosBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
        override fun onBindViewHolder(holder: IngresosViewHolder, position: Int) {
            holder.binding(dataCards[position])
        }

        override fun getItemCount(): Int = dataCards.size

        // Donde hacer la logica
        inner class IngresosViewHolder(private val binding: TarjetasIngresosBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun binding(data: Ingreso) {
                binding.precio.text = "$ " + data.monto.toString()
                binding.nota.text = data.nota
                binding.fecha.text = data.fecha.toString()
            }
        }

        fun addDataCards(list: List<Ingreso>) {
            dataCards.clear()
            dataCards.addAll(list)
        }
        }