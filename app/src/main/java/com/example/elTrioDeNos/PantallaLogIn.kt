package com.example.elTrioDeNos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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

    val contexto: Context = this

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


        binding.btnCrearCuenta.setOnClickListener {
            val correo = binding.emailEdittext.text.toString()
            val pass = binding.passwordEdittext.text.toString()

            if ((!correo.equals("")) && (!pass.equals(""))){
                crearCuenta(correo, pass)
            } else {
                Toast.makeText(
                    baseContext,
                    "Debe ingresar Correo y contraseña",
                    Toast.LENGTH_SHORT,
                ).show()
            }

        }
        binding.btnLogIn.setOnClickListener {
            val correo = binding.emailEdittext.text.toString()
            val pass = binding.passwordEdittext.text.toString()

            if ((!correo.equals("")) && (!pass.equals(""))){
                loginValidation(correo, pass)
            } else {
                Toast.makeText(
                    baseContext,
                    "Debe ingresar Correo y contraseña",
                    Toast.LENGTH_SHORT,
                ).show()
            }
        }

    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if (currentUser != null) {
            cambioDePantalla()
        }
    }

    fun crearCuenta(
        correo: String,
        pass: String
    ){
        auth.createUserWithEmailAndPassword(correo, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Almacenar datos
                } else {
                    Toast.makeText(
                        this,
                        "No se pudo crear tu cuentita bro",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }

    fun loginValidation(
        correo: String,
        pass: String
    ){
        auth.signInWithEmailAndPassword(correo, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful){
                    cambioDePantalla()
                } else {
                    Toast.makeText(
                        this,
                        "no pudimos loguear ese usuario y contraseña",
                        Toast.LENGTH_LONG,
                    ).show()
                }
            }
    }

    fun cambioDePantalla(){
        val cambioPantallaPrincipal: Intent = Intent(contexto, PantallaPrincipal::class.java)
        startActivity(cambioPantallaPrincipal)
    }


}