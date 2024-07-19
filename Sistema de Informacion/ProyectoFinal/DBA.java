
public class DBA
{
    // CLIENTE
    public static void setCliente(Cliente c)
    {
        Cliente cdb= new Cliente();

        cdb.ci = c.ci > 0 ? c.ci : 0;
        cdb.nombre = !c.nombre.equalsIgnoreCase("")?c.nombre:"Sin nombre";
        cdb.apellido= !c.apellido.equalsIgnoreCase("")?c.apellido:"Sin apellido";
        cdb.direccion= !c.direccion.equalsIgnoreCase("")?c.direccion:"Sin direccion";
        cdb.telefono= !c.telefono.equalsIgnoreCase("")?c.telefono:"Sin telefono";
        cdb.correo= !c.correo.equalsIgnoreCase("")?c.correo:"Sin correo";
        DB.registrarCliente(cdb);
    }
    
    public static void getUltCliente()
    {
        Cliente uc = DB.mostrarUltCliente();
        getCliente(uc);
    }
    
    public static Cliente getClientePos(int pos) {
        if (pos <= DB.ic) {
                return DB.clientePos(pos - 1);
        } else {
            System.out.println("ERROR: Registro no encontrado.");
            return null;
        }
    }
    
    public static Cliente getClientePorCi(int ci) {
        for (int i = 0; i < DB.ic; i++) {
            if (DB.cliente[i].getCi() == ci) {
                return DB.cliente[i];
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }
    
    public static boolean updateCliente(int oldCi, Cliente c) {
        for (int i = 0; i < DB.ic; i++) {
            if (DB.cliente[i].getCi() == oldCi) {
                DB.cliente[i] = c;
                return true;
            }
        }
        return false; // Retorna false si no se encuentra el cliente
    }
    
    public static boolean deleteCliente(int ci) {
        return DB.deleteCliente(ci);
    }
    
    // Método para obtener el tamaño de la lista de clientes en DB
    public static int getSizeCliente() {
        return DB.ic;
    }
    
    public static void getCliente(Cliente c)
    {
        System.out.println("\n===============================");
        System.out.println("CI: "+c.ci);
        System.out.println("Nombre: "+c.nombre);
        System.out.println("Apellido: "+c.apellido);
        System.out.println("Direccion: "+c.direccion);
        System.out.println("Telefono: "+c.telefono);
        System.out.println("Correo: "+c.correo);
    }
    
    // PERSONAL
    
    public static void setPersonal(Personal p)
    {
        Personal pdb= new Personal();

        pdb.ci = p.ci > 0 ? p.ci : 0;
        pdb.nombre = !p.nombre.equalsIgnoreCase("")?p.nombre:"Sin nombre";
        pdb.apellido= !p.apellido.equalsIgnoreCase("")?p.apellido:"Sin apellido";
        pdb.puesto= !p.puesto.equalsIgnoreCase("")?p.puesto:"Sin puesto";
        pdb.telefono= !p.telefono.equalsIgnoreCase("")?p.telefono:"Sin telefono";
        pdb.correo= !p.correo.equalsIgnoreCase("")?p.correo:"Sin correo";
        DB.registrarPersonal(pdb);
    }
    
    public static void getUltPersonal()
    {
        Personal up = DB.mostrarUltPersonal();
        getPersonal(up);
    }
    
    public static Personal getPersonalPos(int pos) {
        if (pos <= DB.ip) {
                return DB.personalPos(pos - 1);
        } else {
            System.out.println("ERROR: Registro no encontrado.");
            return null;
        }
    }
    
    public static Personal getPersonalPorCi(int ci) {
        for (int i = 0; i < DB.ip; i++) {
            if (DB.personal[i].getCi() == ci) {
                return DB.personal[i];
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }
    
    public static boolean updatePersonal(int oldCi, Personal p) {
        for (int i = 0; i < DB.ip; i++) {
            if (DB.personal[i].getCi() == oldCi) {
                DB.personal[i] = p;
                return true;
            }
        }
        return false; // Retorna false si no se encuentra el producto
    }
    
    public static boolean deletePersonal(int ciPersonal) {
        return DB.deletePersonal(ciPersonal);
    }
    
    public static int getSizePersonal() {
        return DB.ip;
    }
    
    public static void getPersonal(Personal p)
    {
        System.out.println("\n===============================");
        System.out.println("CI: "+p.ci);
        System.out.println("Nombre: "+p.nombre);
        System.out.println("Apellido: "+p.apellido);
        System.out.println("Puesto: "+p.puesto);
        System.out.println("Telefono: "+p.telefono);
        System.out.println("Correo: "+p.correo);
    }
    
    public static boolean existePersonal(Personal p){
        boolean res= false;
        for(int i=0; i<DB.ip; i++){
            if(p.getNombre().equals(DB.personal[i].getNombre()) && p.getCi()==(DB.personal[i].getCi()))
                res= true;
        }
        return res;
    }

    // PRODUCTO
    
    public static void setProducto(Producto pr)
    {
        Producto prdb= new Producto();

        prdb.codProducto= !pr.codProducto.equalsIgnoreCase("")?pr.codProducto:"Sin Codido de Producto";
        prdb.nombre= !pr.nombre.equalsIgnoreCase("")?pr.nombre:"Sin nombre";
        prdb.descripcion= !pr.descripcion.equalsIgnoreCase("")?pr.descripcion:"Sin descripcion";
        prdb.precio = pr.precio> 0 ? pr.precio: 0;
        prdb.stock= pr.stock> 0 ? pr.stock: 0;
        prdb.medida= !pr.medida.equalsIgnoreCase("")?pr.medida:"Sin medida";
        DB.registrarProducto(prdb);
    }
    
    public static void getUltProducto()
    {
        Producto upr = DB.mostrarUltProducto();
        getProducto(upr);
    }
    
    public static Producto getProductoPos(int pos) {
        if (pos <= DB.ipr) {
                return DB.productoPos(pos - 1);
        } else {
            System.out.println("ERROR: Registro no encontrado.");
            return null;
        }
    }
    
    public static Producto getProductoPorCod(String codProducto) {
        for (int i = 0; i < DB.ipr; i++) {
            if (DB.producto[i].getCodProducto().equals(codProducto)) {
                return DB.producto[i];
            }
        }
        return null; // Retorna null si no se encuentra el cliente
    }
    
    public static boolean updateProducto(String oldCod, Producto p) {
        for (int i = 0; i < DB.ipr; i++) {
            if (DB.producto[i].getCodProducto().equals(oldCod)) {
                DB.producto[i] = p;
                return true;
            }
        }
        return false; // Retorna false si no se encuentra el producto
    }
    
    public static boolean deleteProducto(String codProducto) {
        return DB.deleteProducto(codProducto);
    }
    
    public static int getSizeProducto() {
        return DB.ipr;
    }
    
    public static void getProducto(Producto pr)
    {
        System.out.println("\n===============================");
        System.out.println("Cod. Producto: "+pr.codProducto);
        System.out.println("Nombre: "+pr.nombre);
        System.out.println("Descripcion: "+pr.descripcion);
        System.out.println("Precio: "+pr.precio);
        System.out.println("Stock: "+pr.stock);
        System.out.println("Medida: "+pr.medida);
    }
    
    // VENTA

    public static void setVenta(Venta v)
    {
        Venta vdb= new Venta();

        vdb.codVenta = v.codVenta > 0 ? v.codVenta : 0;
        vdb.fecha= !v.fecha.equalsIgnoreCase("")?v.fecha:"Sin fecha";
        vdb.cliente= !v.cliente.equalsIgnoreCase("")?v.cliente:"Sin cliente";
        vdb.cantidad= v.cantidad> 0 ? v.cantidad: 0;
        vdb.producto= !v.producto.equalsIgnoreCase("")?v.producto:"Sin producto";
        vdb.total= v.total> 0 ? v.total: 0;
        DB.registrarVenta(vdb);
    }
    
    public static void getUltVenta()
    {
        Venta uv = DB.mostrarUltVenta();
        getVenta(uv);
    }
    
    public static Venta getVentaPos(int pos) {
        if (pos <= DB.iv) {
                return DB.ventaPos(pos - 1);
        } else {
            System.out.println("ERROR: Registro no encontrado.");
            return null;
        }
    }
    
    public static Venta getVentaPorCod(int cod) {
        for (int i = 0; i < DB.iv; i++) {
            if (DB.venta[i].getCodVenta() == cod) {
                return DB.venta[i];
            }
        }
        return null;
    }
    
    public static boolean updateVenta(int oldCod, Venta v) {
        for (int i = 0; i < DB.iv; i++) {
            if (DB.venta[i].getCodVenta() == oldCod) {
                DB.venta[i] = v;
                return true;
            }
        }
        System.out.println("Venta con código " + oldCod + " no encontrada.");
        return false; // Retorna false si no se encuentra la venta
    }
    
    public static boolean deleteVenta(int codVenta) {
        return DB.deleteVenta(codVenta);
    }
    
    public static int getSizeVenta() {
        return DB.iv;
    }
    
    public static void getVenta(Venta v)
    {
        System.out.println("\n===============================");
        System.out.println("Cod. Venta: "+v.codVenta);
        System.out.println("Fecha: "+v.fecha);
        System.out.println("Cliente: "+v.cliente);
        System.out.println("Cantidad: "+v.cantidad);
        System.out.println("Producto: "+v.producto);
        System.out.println("Total: "+v.total);
    }
}