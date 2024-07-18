
/**
 * Cliente class object.
 * 
 * @author (ese.joel) 
 * @version (V 0.01)
 */
public class Cliente
{
    public int ci;
    public String nombre, apellido, direccion, telefono, correo;

    /**
     * Constructor-1 for objects of class Cliente
     */
    public Cliente()
    {
        this.ci= 0;
        this.nombre= "";
        this .apellido= "";
        this.direccion= "";
        this.telefono= "";
        this.correo= "";
    }

    /**
     * Constructor-2 for objects of class Cliente
     * 
     * @param  <ci> de tipo int
     * @param  <nombre> de tipo String
     * @param  <apellido> de tipo String
     * @param  <direccion> de tipo String
     * @param  <telefono> de tipo String
     * @param  <correo> de tipo String
    */
    public Cliente(int ci, String nombre, String apellido, String direccion, String telefono, String correo)
    {
        this.ci= ci;
        this.nombre= nombre;
        this .apellido= apellido;
        this.direccion= direccion;
        this.telefono= telefono;
        this.correo= correo;
    }
    
    public Cliente(int ci)
    {
        this.ci= ci;
    }
    
    //SETTERS
    /**
     * Metodo setCi
     * 
     * @param  <ci> de tipo int
     * @return  void 
     */
    public void setCi(int ci)
    {
        this.ci= ci;
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
     * Metodo setApellido
     * 
     * @param  <apellido> de tipo String
     * @return  void 
     */
    public void setApellido(String apellido)
    {
        this.apellido= apellido;
    }
    
    /**
     * Metodo setDireccion
     * 
     * @param  <direccion> de tipo String
     * @return  void 
     */
    public void setDireccion(String direccion)
    {
        this.direccion= direccion;
    }
    
    /**
     * Metodo setTelefono
     * 
     * @param  <telefono> de tipo String
     * @return  void 
     */
    public void setTelefono(String telefono)
    {
        this.telefono= telefono;
    }
    
    /**
     * Metodo setCorreo
     * 
     * @param  <correo> de tipo String
     * @return  void 
     */
    public void setCorreo(String correo)
    {
        this.correo= correo;
    }
    //GETTERS 
    /**
     * Metodo getCi
     * 
     * @return  int
     */
    public int getCi()
    {
        return this.ci;
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
     * Metodo getApellido
     * 
     * @return  Strring
     */
    public String getApellido()
    {
        return this.apellido;
    }
    
    /**
     * Metodo getDireccion
     * 
     * @return  Strring
     */
    public String getDireccion()
    {
        return this.direccion;
    }
    
    /**
     * Metodo getTelefono* 
     * @return  Strring
     */
    public String getTelefono()
    {
        return this.telefono;
    }
    
    /**
     * Metodo getCorreo* 
     * @return  Strring
     */
    public String getCorreo()
    {
        return this.correo;
    }
}
