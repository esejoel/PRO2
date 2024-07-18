
/**
 * Producto class object.
 * 
 * @author (ese.joel) 
 * @version (V 0.01)
 */
public class Producto
{
    public int stock;
    public double precio;
    public String codProducto, nombre, descripcion, medida;

    /**
     * Constructor-1 for objects of class Cliente
     */
    public Producto()
    {
        this.codProducto= "";
        this.nombre= "";
        this.descripcion= "";
        this.precio= 0.0;
        this.stock= 0;
        this.medida= "";
    }

    /**
     * Constructor-2 for objects of class Cliente
     * 
     * @param  <codProducto> de tipo String
     * @param  <nombre> de tipo String
     * @param  <descripcion> de tipo String
     * @param  <precio> de tipo double
     * @param  <stock> de tipo int
     * @param  <medida> de tipo String
    */
    public Producto(String codProducto, String nombre, String descripcion, double precio, int stock, String medida)
    {
        this.codProducto= codProducto;
        this.nombre= nombre;
        this.descripcion= descripcion;
        this.precio= precio;
        this.stock= stock;
        this.medida= medida;
    }
    
    public String toString() {
        return "Producto{" +
                "codProducto='" + codProducto + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", medida='" + medida + '\'' +
                '}';
    }
    
    //SETTERS
    /**
     * Metodo setCodProducto
     * 
     * @param  <codProducto> de tipo String
     * @return  void 
     */
    public void setCodProducto(String codProducto)
    {
        this.codProducto= codProducto;
    }   
    
    /**
     * Metodo setNombre
     * 
     * @param  <nombre> de tipo String
     * @return  void 
     */
    public void setNombre(String nombre)
    {
        this.nombre= nombre;
    }
    
    /**
     * Metodo setDescripcion
     * 
     * @param  <descripcion> de tipo String
     * @return  void 
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }
    
    /**
     * Metodo setPrecio
     * 
     * @param  <precio> de tipo double
     * @return  void 
     */
    public void setPrecio(double precio)
    {
        this.precio = precio;
    }
    
    /**
     * Metodo setStock
     * 
     * @param  <stock> de tipo int
     * @return  void 
     */
    public void setStock(int stock)
    {
        this.stock = stock;
    }
    
    /**
     * Metodo setMedida
     * 
     * @param  <medida> de tipo String
     * @return  void 
     */
    public void setMedida(String medida)
    {
        this.medida = medida;
    }
    //GETTERS 
    /**
     * Metodo getCodProducto
     * 
     * @return  String
     */
    public String getCodProducto()
    {
        return this.codProducto;
    }
    
    /**
     * Metodo getNombre* 
     * @return  String
     */
    public String getNombre()
    {
        return this.nombre;
    }
    
    /**
     * Metodo getDescripcion
     * 
     * @return String
     */
    public String getDescripcion()
    {
        return this.descripcion;
    }
    
    /**
     * Metodo getPrecio
     * 
     * @return double
     */
    public double getPrecio()
    {
        return this.precio;
    }
    
    /**
     * Metodo getStock
     * 
     * @return int
     */
    public int getStock()
    {
        return this.stock;
    }
    
    /**
     * Metodo getMedida
     * 
     * @return String
     */
    public String getMedida()
    {
        return this.medida;
    }
}