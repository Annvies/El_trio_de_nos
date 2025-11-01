package com.example.elTrioDeNos.dataClases
import kotlinx.serialization.Serializable
//import java.util.Date
@Serializable
data class Gasto(
    val monto: Double,
    val fecha: String,
    val nota: String
)
