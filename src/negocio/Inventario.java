package negocio;

import modelo.Producto;

public class Inventario {

    private Producto[] productos;
    private int cantidadProductos;

    public Inventario() {
        productos = new Producto[100];
        cantidadProductos = 0;
    }

    public boolean agregarProducto(Producto producto) {

        if (cantidadProductos < productos.length) {

            if (buscarProducto(producto.getCodigo()) == null) {

                productos[cantidadProductos] = producto;
                cantidadProductos++;

                return true;
            }
        }

        return false;
    }

    public Producto buscarProducto(String codigo) {

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {
                return productos[i];
            }
        }

        return null;
    }

    public boolean eliminarProducto(String codigo) {

        for (int i = 0; i < cantidadProductos; i++) {

            if (productos[i].getCodigo().equalsIgnoreCase(codigo)) {

                for (int j = i; j < cantidadProductos - 1; j++) {
                    productos[j] = productos[j + 1];
                }

                productos[cantidadProductos - 1] = null;
                cantidadProductos--;

                return true;
            }
        }

        return false;
    }

    public boolean actualizarProducto(String codigo, int cantidad) {

        Producto producto = buscarProducto(codigo);

        if (producto != null && cantidad >= 0) {
            producto.actualizarCantidad(cantidad);
            return true;
        }

        return false;
    }

    public void mostrarProductos() {

        if (cantidadProductos == 0) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (int i = 0; i < cantidadProductos; i++) {

            System.out.println("\n-------------------------");
            productos[i].mostrarInformacion();
            System.out.println("-------------------------");
        }
    }
