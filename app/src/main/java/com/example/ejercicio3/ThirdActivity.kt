package com.example.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {

    private lateinit var editTextMarca: TextView
    private lateinit var editTextPrecio: TextView
    private lateinit var editTextCantidad: TextView
    private lateinit var editTextTotal: TextView
    private lateinit var botonMostrar: Button
    private lateinit var botonRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        // FIX: Changed from R.id.second to R.id.third
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.third)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editTextMarca = findViewById(R.id.nombreT)
        editTextPrecio = findViewById(R.id.precioT)
        editTextCantidad = findViewById(R.id.cantidadT)
        editTextTotal = findViewById(R.id.totalT)
        botonMostrar = findViewById(R.id.button5)
        botonRegresar = findViewById(R.id.button6)

        botonMostrar.setOnClickListener {
            mostrarDatos()
        }

        botonRegresar.setOnClickListener {
            regresarAMain()
        }
    }

    private fun mostrarDatos() {
        // FIX: Use correct key names that match what was passed from SecondActivity
        val nombre = intent.getStringExtra("nombre") ?: ""
        val precio = intent.getFloatExtra("precio", 0f)
        val cantidad = intent.getIntExtra("cantidad", 0)

        // Calculate total
        val total = precio * cantidad

        editTextMarca.setText(nombre)
        editTextPrecio.setText(precio.toString())
        editTextCantidad.setText(cantidad.toString())
        editTextTotal.setText(total.toString())
    }

    private fun regresarAMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}