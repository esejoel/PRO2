public class DB
{
    public static Cliente[] cliente= new Cliente[100];
    public static int ic= 0;
    
    public static Personal[] personal= new Personal[100];
    public static int ip= 0;
    
    public static Producto[] producto= new Producto[100];
    public static int ipr= 0;
    
    public static Venta[] venta= new Venta[100];
    public static int iv= 0;
    
    //REGISTRAR Y MOSTRAR CLIENTE
    public static void registrarCliente(Cliente cn)
    {
            cliente[ic]= cn;
            System.out.println("Registrando venta en posicion " + iv + ": " + cn.getCi());
            ic++;
    }
    
     public static Cliente mostrarUltCliente()
    {
        return cliente[ic-1];
    }
    
    public static Cliente clientePos(int pos)
    {
        return cliente[pos];
    }
    
    public static boolean deleteCliente(int ci) {
        for (int i = 0; i < DB.ic; i++) {
            if (DB.cliente[i].getCi() == ci) {
                for (int j = i; j < DB.ic - 1; j++) {
                    DB.cliente[j] = DB.cliente[j + 1];
                }
                DB.cliente[DB.ic - 1] = null;
                DB.ic--;
                return true;
            }
        }
        return false;
    }
    
    //REGISTRAR Y MOSTRAR PERSONAL
    
    public static void registrarPersonal(Personal np)
    {
            personal[ip]= np;
            ip++;
    }
    
     public static Personal mostrarUltPersonal()
    {
        return personal[ip-1];
    }
    
    public static Personal personalPos(int pos)
    {
        return personal[pos];
    }
    
    public static boolean deletePersonal(int ciPersonal) {
        for (int i = 0; i < DB.ip; i++) {
            if (DB.personal[i].getCi()== ciPersonal) {
                for (int j = i; j < DB.ip - 1; j++) {
                    DB.personal[j] = DB.personal[j + 1];
                }
                DB.personal[DB.ip - 1] = null;
                DB.ip--;
                return true;
            }
        }
        return false;
    }
    
    //REGISTRAR Y MOSTRAR PRODUCTO
    
    public static void registrarProducto(Producto prn)
    {
            producto[ipr]= prn;
            ipr++;
    }
    
     public static Producto mostrarUltProducto()
    {
        return producto[ipr-1];
    }
    
    public static Producto productoPos(int pos)
    {
        return producto[pos];
    }
    
    public static boolean deleteProducto(String codProducto) {
        for (int i = 0; i < ipr; i++) {
            if (producto[i].getCodProducto().equals(codProducto)) {
                // Desplazar elementos para llenar el espacio vacío
                for (int j = i; j < ipr - 1; j++) {
                    producto[j] = producto[j + 1];
                }
                producto[--ipr] = null; // Decrementar el contador y limpiar la última posición
                return true; // Producto eliminado
            }
        }
        return false; // Producto no encontrado
    }
    
    //REGISTRAR Y MOSTRAR VENTA
    
    public static void registrarVenta(Venta vn)
    {
            venta[iv]= vn;
            iv++;
    }
    
    public static Venta mostrarUltVenta()
    {
        return venta[iv-1];
    }
    
    public static Venta ventaPos(int pos)
    {
        return venta[pos];
    }
    
    public static boolean deleteVenta(int codVenta) {
        for (int i = 0; i < DB.iv; i++) {
            if (DB.venta[i].getCodVenta() == codVenta) {
                for (int j = i; j < DB.iv - 1; j++) {
                    DB.venta[j] = DB.venta[j + 1];
                }
                DB.venta[DB.iv - 1] = null;
                DB.iv--;
                return true;
            }
        }
        return false;
    }
}
