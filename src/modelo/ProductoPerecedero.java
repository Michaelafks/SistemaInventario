package modelo;

public class ProductoPerecedero extends Producto {

    private String fechaCaducidad;

    public ProductoPerecedero(String codigo, String nombre,
                              String categoria, int cantidad,
                              double precio, double costo,
                              String fechaCaducidad) {

        super(codigo, nombre, categoria, cantidad, precio, costo);

        this.fechaCaducidad = fechaCaducidad;
    }

    public String getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(String fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();

        System.out.println("Fecha de caducidad: " + fechaCaducidad);
    }
}
