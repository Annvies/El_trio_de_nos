package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
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

        val user = FirebaseAuth.getInstance().currentUser
        val correoUser = user?.email

        val passActual = intent.getIntExtra("password_lenght", 0)
        val passLenght = "*".repeat(passActual)

        binding.userMail.setText(correoUser)

        binding.btnGuardarContra.setOnClickListener {

        }

        binding.btnCerrarSesion.setOnClickListener {
            auth.signOut()
            val cambioLogIn: Intent = Intent(contexto, PantallaLogIn::class.java)
            startActivity(cambioLogIn)
        }
    }
}