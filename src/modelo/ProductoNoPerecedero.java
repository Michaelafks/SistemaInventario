package modelo;

public class ProductoNoPerecedero extends Producto{

    public ProductoNoPerecedero(String codigo, String nombre, String categoria, int cantidad,
                                double precio, double costo) {

        super(codigo, nombre, categoria, cantidad, precio, costo);
    }

    // Mostrar información
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();

        System.out.println("Tipo: Producto no perecedero");
    }
}
