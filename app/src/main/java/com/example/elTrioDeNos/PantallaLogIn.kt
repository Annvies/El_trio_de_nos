package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.elTrioDeNos.databinding.ActivityPantallaIngresosBinding
import com.example.elTrioDeNos.databinding.ActivityPantallaLogInBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth


class PantallaLogIn : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaLogInBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityPantallaLogInBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        auth = Firebase.auth

        val contexto: Context = this
        binding.signInButton.setOnClickListener {
            val cambioPantallaPrincipal: Intent = Intent(contexto, PantallaPrincipal::class.java)
            startActivity(cambioPantallaPrincipal)
        }
    }

    fun crearUsuario(
        correo: String,
        pass: String
    ){

    }
}