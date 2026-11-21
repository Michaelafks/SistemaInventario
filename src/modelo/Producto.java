package modelo;

public class Producto {

    private String codigo;
    private String nombre;
    private String categoria;
    private int cantidad;
    private double precio;
    private double costo;

    public Producto(String codigo, String nombre, String categoria, int cantidad, double precio, double costo) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.precio = precio;
        this.costo = costo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void mostrarInformacion() {
        System.out.println("Código: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Categoría: " + categoria);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: $" + precio);
        System.out.println("Costo: $" + costo);
    }

    public void actualizarCantidad(int nuevaCantidad) {
        if (nuevaCantidad >= 0) {
            cantidad = nuevaCantidad;
            System.out.println("Cantidad actualizada correctamente.");
        } else {
            System.out.println("Error: la cantidad no puede ser negativa.");
        }
    }
}
