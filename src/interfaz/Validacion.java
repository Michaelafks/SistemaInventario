package interfaz;

import java.util.Scanner;

public class Validacion {

    private static Scanner sc = new Scanner(System.in);

    public static String leerString(String mensaje) {

        String dato;

        do {
            System.out.print(mensaje);
            dato = sc.nextLine();

            if (dato.trim().isEmpty()) {
                System.out.println("Error: el campo no puede estar vacio.");
            }

        } while (dato.trim().isEmpty());

        return dato;
    }

    public static int leerEnteroEntre(String mensaje, int minimo, int maximo) {

        int numero;

        do {
            System.out.print(mensaje);
            numero = sc.nextInt();
            sc.nextLine();

            if (numero < minimo || numero > maximo) {
                System.out.println("Error: ingrese un numero entre "
                        + minimo + " y " + maximo + ".");
            }

        } while (numero < minimo || numero > maximo);

        return numero;
    }

    public static int leerEnteroNoNegativo(String mensaje) {

        int numero;

        do {
            System.out.print(mensaje);
            numero = sc.nextInt();
            sc.nextLine();

            if (numero < 0) {
                System.out.println("Error: el numero no puede ser negativo.");
            }

        } while (numero < 0);

        return numero;
    }

    public static double leerDoubleNoNegativo(String mensaje) {

        double numero;

        do {
            System.out.print(mensaje);
            numero = sc.nextDouble();
            sc.nextLine();

            if (numero < 0) {
                System.out.println("Error: el numero no puede ser negativo.");
            }

        } while (numero < 0);

        return numero;
    }
}

