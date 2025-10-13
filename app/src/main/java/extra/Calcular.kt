package extra

class Calcular(): Producto() {

    var res: Float = 0.0f
    fun calcular(): Float?{
        if (getCantidad() <= getExists()){
            res = getPrecio() * getCantidad()
        }
        else{
            return 0.0f
        }
        return res
    }
}