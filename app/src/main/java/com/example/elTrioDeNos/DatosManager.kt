package com.example.elTrioDeNos

import android.content.Context
import com.example.elTrioDeNos.dataClases.Gasto
import com.example.elTrioDeNos.dataClases.Ingreso
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DatosManager {
    private const val PREF_NAME = "mis_datos"
    private const val CLAVE_INGRESOS = "ingresos"
    private const val CLAVE_SALDO = "saldo"
    private const val CLAVE_GASTOS = "gastos"

    private val gson = Gson()

    ////////////////////////////////INGRESOS////////////////////////////////////////////////////////

    fun guardarIngreso(context: Context, ingreso: Ingreso) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val listaActual = obtenerIngresos(context).toMutableList()
        listaActual.add(0, ingreso) // lo agregamos al inicio

        val json = gson.toJson(listaActual)
        prefs.edit()
            .putString(CLAVE_INGRESOS, json)
            .putFloat(CLAVE_SALDO, (obtenerSaldo(context) + ingreso.monto).toFloat())
            .apply()
    }

    fun obtenerIngresos(context: Context): List<Ingreso> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(CLAVE_INGRESOS, null)
        val type = object : TypeToken<List<Ingreso>>() {}.type
        if(json != null){
            return Gson().fromJson(json, type)
        } else {
            return emptyList()
        }
        //return if (json != null) Gson().fromJson(json, type) else emptyList()
    }

    /////////////////////////////////////SALDO/////////////////////////////////////////////////

    fun obtenerSaldo(context: Context): Double {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(CLAVE_SALDO, 0f).toDouble()
    }

    fun guardarSaldo(context: Context, saldo: Double) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().putFloat(CLAVE_SALDO, saldo.toFloat()).apply()
    }

    /////////////////////////////////////GASTOS/////////////////////////////////////////////////////

    fun guardarGasto(context: Context, gasto: Gasto) {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val listaActual = obtenerGastos(context).toMutableList()
        listaActual.add(0,gasto)

        val json = gson.toJson(listaActual)
        prefs.edit().putString(CLAVE_GASTOS, json).putFloat(CLAVE_SALDO,(obtenerSaldo(context) - gasto.monto).toFloat()).apply()
    }

    fun obtenerGastos(context: Context): List<Gasto> {
        val prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(CLAVE_GASTOS, null)
        val type = object : TypeToken<List<Gasto>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }

    ////////////////////////////////////////BUSQUEDA////////////////////////////////////////////////

    fun buscarGastos(context: Context, fecha: String, categoria: String): List<Gasto> {
        val gastos: List<Gasto> = obtenerGastos(context)

        if (categoria.lowercase() == "general") {
            return gastos.filter { it.fecha == fecha }
        } else {
            return gastos.filter { it.fecha == fecha && it.categoria.lowercase() == categoria.lowercase() }
        }
    }
}