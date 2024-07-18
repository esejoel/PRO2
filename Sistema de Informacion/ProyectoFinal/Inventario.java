public class Inventario {
    public static void actualizarStockVenta(String nombreProducto, int cantidadVendida) {
        for (int i = 0; i < DB.ipr; i++) {
            Producto prod = DB.productoPos(i);
            if (prod.getNombre().equals(nombreProducto)) {
                int nuevoStock = prod.getStock() - cantidadVendida;
                if (nuevoStock >= 0) {
                    prod.setStock(nuevoStock);
                    System.out.println("Stock actualizado para producto '" + nombreProducto + "'. Nuevo stock: " + nuevoStock);
                } else {
                    System.out.println("No hay suficiente stock disponible para el producto '" + nombreProducto + "'.");
                }
                return; // Termina la búsqueda una vez que se actualiza el stock
            }
        }
        System.out.println("Producto '" + nombreProducto + "' no encontrado en el inventario.");
    }
    
    public static void mostrarInventario() {
        // Imprimir encabezado de la tabla
        System.out.println("+-----------+----------------+----------------+--------+-------+---------+");
        System.out.println("| Código    | Nombre         | Descripción    | Precio | Stock | Medida  |");
        System.out.println("+-----------+----------------+----------------+--------+-------+---------+");

        // Iterar sobre el inventario y mostrar cada producto
        for (int i = 0; i < DB.ipr; i++) {
            Producto prod = DB.productoPos(i);
            System.out.printf("| %-9s| %-15s| %-15s| %-7.2f| %-6d| %-8s|%n",
                    prod.getCodProducto(), prod.getNombre(), prod.getDescripcion(),
                    prod.getPrecio(), prod.getStock(), prod.getMedida());
        }

        // Imprimir línea final de la tabla
        System.out.println("+-----------+----------------+----------------+--------+-------+---------+");
    }
}