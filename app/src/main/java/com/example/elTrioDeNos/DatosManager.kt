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

    fun guardarIngreso(contextPasado: Context, ingreso: Ingreso) {
        val prefs = contextPasado.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val listaActual = obtenerIngresos(contextPasado).toMutableList()
        listaActual.add(0,ingreso)

        val json = gson.toJson(listaActual)
        prefs.edit()
            .putString(CLAVE_INGRESOS, json)
            .putFloat(CLAVE_SALDO, (obtenerSaldo(contextPasado) + ingreso.monto).toFloat())
            .apply()
    }

    fun obtenerIngresos(contextPasado: Context): List<Ingreso> {
        val prefs = contextPasado.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(CLAVE_INGRESOS, null)
        val type = object : TypeToken<List<Ingreso>>() {}.type
        if(json != null){
            return Gson().fromJson(json, type)
        } else {
            return emptyList()
        }
    }

    /////////////////////////////////////SALDO/////////////////////////////////////////////////

    fun obtenerSaldo(contextPasado: Context): Double {
        val prefs = contextPasado.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return prefs.getFloat(CLAVE_SALDO, 0f).toDouble()
    }

    fun guardarSaldo(contextPasado: Context, saldo: Double) {
        val prefs = contextPasado.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        prefs.edit().putFloat(CLAVE_SALDO, saldo.toFloat()).apply()
    }

    /////////////////////////////////////GASTOS/////////////////////////////////////////////////////

    fun guardarGasto(contextPasado: Context, gasto: Gasto) {
        val prefs = contextPasado.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

        val listaActual = obtenerGastos(contextPasado).toMutableList()
        listaActual.add(0,gasto)

        val json = gson.toJson(listaActual)
        prefs.edit().putString(CLAVE_GASTOS, json).putFloat(CLAVE_SALDO,(obtenerSaldo(contextPasado) - gasto.monto).toFloat()).apply()
    }

    fun obtenerGastos(contextPasado: Context): List<Gasto> {
        val prefs = contextPasado.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val json = prefs.getString(CLAVE_GASTOS, null)
        val type = object : TypeToken<List<Gasto>>() {}.type
        return gson.fromJson(json, type) ?: emptyList()
    }

    ////////////////////////////////////////BUSQUEDA////////////////////////////////////////////////

    fun buscarGastos(contextPasado: Context, fecha: String, categoria: String): List<Gasto> {
        val resultados = mutableListOf<Gasto>()
        for (gasto in obtenerGastos(contextPasado)) {
            if (gasto.fecha == fecha && (categoria == "general" || gasto.categoria == categoria)) {
                resultados.add(gasto)
            }
        }
        return resultados
    }
}