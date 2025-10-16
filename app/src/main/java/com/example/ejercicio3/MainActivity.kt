package com.example.ejercicio3
import android.content.Intent
import extra.Producto
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputMarca: EditText
    private lateinit var inputPrecio: EditText
    private lateinit var inputCantidad: EditText
    private lateinit var botonAsignar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        inputMarca = findViewById(R.id.editTextText)
        inputPrecio = findViewById(R.id.editTextNumberDecimal)
        inputCantidad = findViewById(R.id.editTextNumber)
        botonAsignar = findViewById(R.id.button)

        botonAsignar.setOnClickListener {
            btnAsignarClick()
        }
    }

    fun onClickListener(): Producto {
        val nombre = inputMarca.text.toString()
        val precio = inputPrecio.text.toString().toFloatOrNull() ?: 0.0f
        val cantidad = inputCantidad.text.toString().toIntOrNull() ?: 0
        val producto = Producto()

        if (nombre.isEmpty() || precio == 0.0f || cantidad == 0) {
            Toast.makeText(applicationContext, "Rellena todos los campos correctamente", Toast.LENGTH_SHORT).show()
        } else {
            producto.setNombre(nombre)
            producto.setPrecio(precio)
            producto.setCantidad(cantidad)
        }

        return producto
    }

    fun btnAsignarClick(){
        val producto = onClickListener()
        if (producto.getNombre().isNotEmpty() && producto.getPrecio() > 0f && producto.getCantidad() > 0) {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("nombre", producto.getNombre())
            intent.putExtra("precio", producto.getPrecio())
            intent.putExtra("cantidad", producto.getCantidad())
            startActivity(intent)
        }
    }
}