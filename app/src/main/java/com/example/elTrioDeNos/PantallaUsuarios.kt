package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaUsuariosBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class PantallaUsuarios : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaUsuariosBinding

    private lateinit var auth: FirebaseAuth

    val contexto: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaUsuariosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = Firebase.auth

        val userPalCorreo = FirebaseAuth.getInstance().currentUser
        val correoUser = userPalCorreo?.email

        binding.userMail.setText(correoUser)

        binding.btnGuardarContra.setOnClickListener {
            val nuevaPass: String = binding.editTextNuevaPass.text.toString()

            if(nuevaPass.isEmpty()){
                Toast.makeText(this, "Ingresa una nueva contraseña", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(nuevaPass.length < 6){
                Toast.makeText(this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
                val user = auth.currentUser
                user?.updatePassword(nuevaPass)
                    ?.addOnCompleteListener { task ->
                        if(task.isSuccessful){
                            Toast.makeText(this, "Contraseña actualizada correctamente", Toast.LENGTH_SHORT).show()
                            binding.editTextNuevaPass.text.clear()
                        } else {
                            Toast.makeText(this, "Error al actualizar la contraseña", Toast.LENGTH_SHORT).show()
                        }
                    } ?: run {
                    Toast.makeText(this, "No hay usuario autenticado", Toast.LENGTH_SHORT).show()
                }

        }

        binding.btnCerrarSesion.setOnClickListener {
            auth.signOut()
            val cambioLogIn: Intent = Intent(contexto, PantallaLogIn::class.java)
            cambioLogIn.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK

            startActivity(cambioLogIn)
            finish()
        }
    }
}