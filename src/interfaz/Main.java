
package interfaz;

import modelo.Producto;
import modelo.ProductoPerecedero;
import modelo.ProductoNoPerecedero;
import negocio.Inventario;


public class Main {

    public static Inventario inventario = new Inventario();

    public static void main(String[] args) {

        int opc;

        do {
            menu();

            opc = Validacion.leerEnteroEntre(
                    "Ingrese una opcion: ", 1, 7);

            switch (opc) {

                case 1: {
                    ingresarProducto();
                } break;

                case 2: {
                    mostrarProductos();
                } break;

                case 3: {
                    buscarProducto();
                } break;

                case 4: {
                    actualizarCantidad();
                } break;

                case 5: {
                    eliminarProducto();
                } break;

                case 6: {
                    calcularValorInventario();
                } break;

                case 7: {
                    System.out.println("Gracias por utilizar el sistema de inventario.");
                } break;
            }

        } while (opc != 7);
    }

    public static void menu() {

        System.out.println("\n********** SISTEMA DE INVENTARIO **********");
        System.out.println("1. Ingresar producto");
        System.out.println("2. Mostrar productos");
        System.out.println("3. Buscar producto");
        System.out.println("4. Actualizar cantidad");
        System.out.println("5. Eliminar producto");
        System.out.println("6. Calcular valor del inventario");
        System.out.println("7. Salir");
    }

    public static void ingresarProducto() {

        System.out.println("\n******* INGRESO DE PRODUCTO *******");

        int tipo = Validacion.leerEnteroEntre(
                "Tipo de producto (1. Perecedero / 2. No perecedero): ", 1, 2);

        String codigo = Validacion.leerString(
                "Ingrese el codigo:");

        String nombre = Validacion.leerString(
                "Ingrese el nombre:");

        String categoria = Validacion.leerString(
                "Ingrese la categoria:");

        int cantidad = Validacion.leerEnteroNoNegativo(
                "Ingrese la cantidad:");

        double precio = Validacion.leerDoubleNoNegativo(
                "Ingrese el precio de venta:");

        double costo = Validacion.leerDoubleNoNegativo(
                "Ingrese el costo de compra:");

        Producto nuevo;

        if (tipo == 1) {

            String fechaCaducidad = Validacion.leerString(
                    "Ingrese la fecha de caducidad:");

            nuevo = new ProductoPerecedero(
                    codigo, nombre, categoria,
                    cantidad, precio, costo, fechaCaducidad);

        } else {

            nuevo = new ProductoNoPerecedero(
                    codigo, nombre, categoria,
                    cantidad, precio, costo);
        }

        boolean agregado = inventario.agregarProducto(nuevo);

        if (agregado) {
            System.out.println("El producto se ha agregado con exito.");
        } else {
            System.out.println("No fue posible agregar el producto.");
            System.out.println("Verifique que el codigo no exista y que haya espacio.");
        }
    }

    public static void mostrarProductos() {

        System.out.println("\n******* LISTA DE PRODUCTOS *******");

        inventario.mostrarProductos();
    }

    public static void buscarProducto() {

        System.out.println("\n******* BUSCAR PRODUCTO *******");

        String codigo = Validacion.leerString(
                "Ingrese el codigo del producto:");

        Producto encontrado = inventario.buscarProducto(codigo);

        if (encontrado != null) {
            encontrado.mostrarInformacion();
        } else {
            System.out.println("No se encontro el producto.");
        }
    }

    public static void actualizarCantidad() {

        System.out.println("\n******* ACTUALIZAR CANTIDAD *******");

        String codigo = Validacion.leerString(
                "Ingrese el codigo del producto:");

        int cantidad = Validacion.leerEnteroNoNegativo(
                "Ingrese la nueva cantidad:");

        boolean actualizado = inventario.actualizarProducto(
                codigo, cantidad);

        if (actualizado) {
            System.out.println("La cantidad se actualizo con exito.");
        } else {
            System.out.println("No fue posible actualizar la cantidad.");
        }
    }

    public static void eliminarProducto() {

        System.out.println("\n******* ELIMINAR PRODUCTO *******");

        String codigo = Validacion.leerString(
                "Ingrese el codigo del producto:");

        boolean eliminado = inventario.eliminarProducto(codigo);

        if (eliminado) {
            System.out.println("El producto se elimino con exito.");
        } else {
            System.out.println("No fue posible eliminar el producto.");
        }
    }

    public static void calcularValorInventario() {

        System.out.println("\n******* VALOR DEL INVENTARIO *******");

        double valor = inventario.calcularValorInventario();

        System.out.println("El valor total del inventario es: $" + valor);
    }
}

