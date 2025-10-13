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

    private var mostrarFlag: Boolean = false


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
            val nombre = intent.getStringExtra("nombre")
            val precio = intent.getFloatExtra("precio", 0f)
            val cantidad = intent.getIntExtra("cantidad", 0)

            val calcular = Calcular()
            calcular.setNombre(nombre ?: "")
            calcular.setPrecio(precio)
            calcular.setCantidad(cantidad)

            val resultado = calcular.calcular()

            if (resultado != null && resultado > 0f) {
                Toast.makeText(applicationContext, "Se realizo el cálculo, proceda a mostrar datos", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Cantidad excede las existencias", Toast.LENGTH_SHORT).show()
            }
            mostrarFlag = true
        }

        botonMostrar.setOnClickListener {
            if (mostrarFlag == false){
                Toast.makeText(applicationContext, "Primero calcula los datos", Toast.LENGTH_SHORT).show()
            }
            else{
                mostrar()
            }
        }

        botonRegresar.setOnClickListener {
            regresarAMain()
        }
    }

    private fun mostrar(){
        val dintent = Intent(this, ThirdActivity::class.java)

        dintent.putExtra("nombre", intent.getStringExtra("nombre"))
        dintent.putExtra("precio", intent.getFloatExtra("precio", 0f))
        dintent.putExtra("cantidad", intent.getIntExtra("cantidad", 0))

        startActivity(dintent)
    }

    private fun regresarAMain() {
        finish()
    }
}