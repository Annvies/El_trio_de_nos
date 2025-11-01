package com.example.elTrioDeNos.dataClases
import kotlinx.serialization.Serializable
//import java.util.Date
@Serializable
data class Ingreso(
    val monto: Double,
    val nota: String,
    val fecha: String
)
