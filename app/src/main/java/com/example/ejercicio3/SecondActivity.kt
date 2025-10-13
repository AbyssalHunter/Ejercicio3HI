package com.example.ejercicio3
import extra.Producto
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import extra.Calcular

class SecondActivity : AppCompatActivity() {

    private lateinit var botonCalcular: Button
    private lateinit var botonMostrar: Button
    private lateinit var botonRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        botonCalcular = findViewById(R.id.button2)
        botonMostrar = findViewById(R.id.button3)
        botonRegresar = findViewById(R.id.button4)

        botonCalcular.setOnClickListener {
            Calcular()
            Toast.makeText(applicationContext, "Se realizo el calculo", Toast.LENGTH_SHORT).show()
        }

        botonMostrar.setOnClickListener {
            mostrar()
        }

        botonRegresar.setOnClickListener {
            regresarAMain()
        }

    }

    private fun mostrar(){
        val dintent =  Intent(this, ThirdActivity::class.java)
        startActivity(dintent)
    }
    private fun regresarAMain() {
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        startActivity(intent)
        finish()
    }
}