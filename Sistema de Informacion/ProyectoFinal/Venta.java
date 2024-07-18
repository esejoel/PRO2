
/**
 * Venta class object.
 * 
 * @author (ese.joel) 
 * @version (V 0.01)
 */
public class Venta
{
    public int codVenta, cantidad;
    public double total;
    public String fecha, producto, cliente;

    /**
     * Constructor-1 for objects of class Venta
     */
    public Venta()
    {
        this.codVenta= 0;
        this.fecha= "";
        this.cliente= "";
        this.cantidad= 0;
        this.producto= "";
        this.total= 0.0;
    }

    /**
     * Constructor-2 for objects of class Venta
     * 
     * @param  <codVenta> de tipo int
     * @param  <fecha> de tipo String
     * @param  <cliente> de tipo String
     * @param  <cantidad> de tipo int
     * @param  <producto> de tipo String
     * @param  <total> de tipo double
    */
    public Venta(int codVenta, String fecha, String cliente, int cantidad, String producto, double total)
    {
        this.codVenta= codVenta;
        this.fecha= fecha;
        this.cliente= cliente;
        this.cantidad= cantidad;
        this.producto= producto;
        this.total= total;
    }
    //SETTERS
    /**
     * Metodo setCodVenta
     * 
     * @param  <codVenta> de tipo int
     * @return  void 
     */
    public void setCodVenta(int codVenta)
    {
        this.codVenta= codVenta;
    }   
    
    /**
     * Metodo setFecha
     * 
     * @param  <fecha> de tipo String
     * @return  void 
     */
    public void setFecha(String fecha)
    {
        this.fecha = fecha;
    }
    
    /**
     * Metodo setCliente
     * 
     * @param  <cliente> de tipo String
     * @return  void 
     */
    public void setCliente(String cliente)
    {
        this.cliente = cliente;
    }
    
    /**
     * Metodo setCantidad
     * 
     * @param  <cantidad> de tipo int
     * @return  void 
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }
    
    /**
     * Metodo setProducto
     * 
     * @param  <producto> de tipo String
     * @return  void 
     */
    public void setProducto(String producto)
    {
        this.producto = producto;
    }
    
    /**
     * Metodo setTotal
     * 
     * @param  <total> de tipo double
     * @return  void 
     */
    public void setTotal(double total)
    {
        this.total = total;
    }
    //GETTERS
    /**
     * Metodo getCodVenta
     * 
     * @return  int
     */
    public int getCodVenta()
    {
        return this.codVenta;
    }
    
    /**
     * Metodo getFecha
     * 
     * @return String
     */
    public String getFecha()
    {
        return this.fecha;
    }
    
    /**
     * Metodo getCliente
     * 
     * @return String
     */
    public String getCliente()
    {
        return this.cliente;
    }
    
    /**
     * Metodo getCantidad
     * 
     * @return int
     */
    public int getCantidad()
    {
        return this.cantidad;
    }
    
    /**
     * Metodo getProducto
     * 
     * @return String
     */
    public String getProducto()
    {
        return this.producto;
    }
    
    /**
     * Metodo getTotal
     * 
     * @return double
     */
    public double getTotal()
    {
        return this.total;
    }
}
