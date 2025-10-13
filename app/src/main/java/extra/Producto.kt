package extra

open class Producto {
    private var nombre: String
    private var precio: Float
    private var exist: Int
    private var cantidad: Int
    private var total: Float
    init {
        nombre = ""
        precio = 0f
        exist = 50
        cantidad = 0
        total = 0f
    }

    fun setNombre(nombre: String){
        this.nombre = nombre
    }

    fun setExist(exist: Int){
        this.exist = exist
    }

    fun setPrecio(precio: Float){
        this.precio = precio
    }

    fun setCantidad(cantidad: Int){
        this.cantidad = cantidad
    }

    fun getNombre(): String{
        return nombre
    }

    fun getExists(): Int{
        return exist
    }

    fun getPrecio(): Float{
        return precio
    }

    fun getCantidad(): Int{
        return cantidad
    }

}