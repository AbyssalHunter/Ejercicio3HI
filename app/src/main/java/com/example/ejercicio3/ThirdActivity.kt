package com.example.ejercicio3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ThirdActivity : AppCompatActivity() {

    private lateinit var textMarca: TextView
    private lateinit var textPrecio: TextView
    private lateinit var textCantidad: TextView
    private lateinit var textTotal: TextView
    private lateinit var botonMostrar: Button
    private lateinit var botonRegresar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        textMarca = findViewById(R.id.editTextText3)
        textPrecio = findViewById(R.id.editTextText4)
        textCantidad = findViewById(R.id.editTextText5)
        textTotal = findViewById(R.id.editTextText2)
        botonMostrar = findViewById(R.id.button5)
        botonRegresar = findViewById(R.id.button6)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        botonMostrar.setOnClickListener {
            mostrarDatos()
        }

        botonRegresar.setOnClickListener {
            regresarAMain()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        regresarAMain()
        return true
    }

    private fun mostrarDatos() {
        val marca = intent.getStringExtra("Marca")
        val precio = intent.getFloatExtra("Precio", 0f)
        val cantidad = intent.getIntExtra("Cantidad", 0)
        val total = intent.getFloatExtra("Total", 0f)

        textMarca.text = marca
        textPrecio.text = "$${"%.2f".format(precio)}"
        textCantidad.text = cantidad.toString()
        textTotal.text = "Total: $${"%.2f".format(total)}"
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