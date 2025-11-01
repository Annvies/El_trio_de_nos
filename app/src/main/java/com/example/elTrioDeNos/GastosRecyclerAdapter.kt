package com.example.elTrioDeNos

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.elTrioDeNos.dataClases.Gasto
import com.example.elTrioDeNos.databinding.TarjetasGastosBinding


class GastosRecyclerAdapter:
        RecyclerView.Adapter<GastosRecyclerAdapter.GastosViewHolder>() {

        private val dataCards = mutableListOf<Gasto>()
        private var context: Context? = null

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastosViewHolder {
                context = parent.context
                return GastosViewHolder(
                        TarjetasGastosBinding.inflate(
                                LayoutInflater.from(parent.context),
                                parent,
                                false
                        )
                )
        }
        override fun onBindViewHolder(holder: GastosViewHolder, position: Int) {
                holder.binding(dataCards[position])
        }

        override fun getItemCount(): Int = dataCards.size

        // Donde hacer la logica
        inner class GastosViewHolder(private val binding: TarjetasGastosBinding) :
                RecyclerView.ViewHolder(binding.root) {
                fun binding(data: Gasto) {
                        binding.categoria.text = data.categoria
                        binding.precio.text = "$ ${data.monto}"
                        binding.nota.text = data.nota
                        binding.fecha.text = data.fecha
                }
        }

        fun addDataCards(list: List<Gasto>) {
                dataCards.clear()
                dataCards.addAll(list)
                notifyDataSetChanged()
        }


}

