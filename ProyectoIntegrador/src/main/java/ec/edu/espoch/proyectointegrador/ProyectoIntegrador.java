package ec.edu.espoch.proyectointegrador;

import ec.edu.espoch.proyectointegrador.dao.GestorLimites;
import ec.edu.espoch.proyectointegrador.modelo.Funcion;
import ec.edu.espoch.proyectointegrador.modelo.Limite;
import ec.edu.espoch.proyectointegrador.modelo.ProcesoLimite;
import java.util.Scanner;

public class ProyectoIntegrador {

    public static void main(String[] args) {

        // Leer datos desde consola
        Scanner leer = new Scanner(System.in);
        GestorLimites gestor = new GestorLimites();
        int opcion = 0;

        System.out.println("--------------------------------------------");
        System.out.println(" CALCULADORA DE LIMUTES  ");
        System.out.println("-------------------------------------------");

        // Repetir el menu hasta que el usuario elija salir
        while (opcion != 3) {

            System.out.println("\n------------------------------------------");
            System.out.println("  MENU PRINCIPAL");
            System.out.println("------------------------------------------");
            System.out.println("  1. Calcular limite de una funcion");
            System.out.println("  2. Ver historial de resultados");
            System.out.println("  3. Salir");
            System.out.println("------------------------------------------");
            System.out.print("  Seleccione una opcion: ");

            try {
                opcion = Integer.parseInt(leer.nextLine().trim());
            } catch (Exception e) {
                opcion = 0;
            }

            switch (opcion) {
                case 1:
                    calcularLimite(leer, gestor);
                    break;
                case 2:
                    verHistorial(gestor);
                    break;
                case 3:
                    System.out.println("\n  Hasta luego.");
                    break;
                default:
                    System.out.println("\n  Opcion invalida. Ingrese 1, 2 o 3.");
                    break;
            }
        }

        leer.close();
    }

    // Pide la funcion y el valor de x, calcula el limite y muestra el resultado
    private static void calcularLimite(Scanner leer, GestorLimites gestor) {

        System.out.println("\n------------------------------------------");
        System.out.println("  CALCULAR LIMITE");
        System.out.println("------------------------------------------");
        System.out.println("  Funciones disponibles:");
        System.out.println("  Polinomicas : x^2-4 | x^3 | 3*x^2 | x^2+2*x | 2*x+3");
        System.out.println("  Racionales  : (x^2-4)/(x-2) | (x^3-8)/(x-2) | (x^2+3*x)/(x)");
        System.out.println("  Irracional  : sqrt(x)");
        System.out.println("  Trigon.     : sin(x) | cos(x) | tan(x)");
        System.out.println("  Logaritmica : ln(x) | log(x) | log_5(x)");
        System.out.println("------------------------------------------");

        // Leer la funcion
        System.out.print("  Ingrese la funcion f(x): ");
        String textoFuncion = leer.nextLine().trim();

        if (textoFuncion.isEmpty()) {
            System.out.println("  Error: debe ingresar una funcion.");
            return;
        }

        // Validar que la funcion sea reconocida
        if (!esFuncionValida(textoFuncion)) {
            System.out.println("  La funcion \"" + textoFuncion + "\" no es reconocida.");
            System.out.println("  Recuerde usar * para multiplicar. Ejemplo: 3*x^2");
            return;
        }

        // Leer el valor de x
        System.out.print("  Ingrese el valor de x al que tiende: ");
        String textoX = leer.nextLine().trim();

        if (textoX.isEmpty()) {
            System.out.println("  Error: debe ingresar el valor de x.");
            return;
        }

        if (!esNumero(textoX)) {
            System.out.println("  \"" + textoX + "\" no es un numero valido.");
            return;
        }

        
        double x = Double.parseDouble(textoX);

        // Generar y mostrar el procedimiento paso a paso
        ProcesoLimite proceso = new ProcesoLimite();
        String procedimiento = proceso.generarProcedimiento(textoFuncion, x);

        System.out.println("\n---------------------------------------");
        System.out.println("  PROCEDIMIENTO");
        System.out.println("------------------------------------------");
        System.out.println(procedimiento);

        // Calcular mediante el DAO
        Funcion f = new Funcion(textoFuncion);
        Limite limite = new Limite(f, x);

        try {
            gestor.calcularLimite(limite);
        } catch (Exception e) {
            // La indeterminacion ya se manejo en ProcesoLimite
        }

        // Guardar en historial y mostrar resultado
        double rf = proceso.getResultadoFinal();
        gestor.guardarHistorial(rf);

        System.out.println("--------------------------------");
        if (Double.isNaN(rf)) {
            System.out.println("  RESULTADO: No definido (ver procedimiento)");
        } else {
            System.out.println("  RESULTADO FINAL: " + rf);
        }
        System.out.println("--------------------------------");
        System.out.println("  Calculos en historial: " + gestor.getCantidadGuardados());
    }

    // Muestra todos los resultados guardados en el historial
    private static void verHistorial(GestorLimites gestor) {

        System.out.println("\n------------------------------------------");
        System.out.println("  HISTORIAL DE RESULTADOS");
        System.out.println("------------------------------------------");

        int cantidad = gestor.getCantidadGuardados();

        if (cantidad == 0) {
            System.out.println("  No hay resultados guardados aun.");
        } else {
            double[] historial = gestor.getHistorial();
            for (int i = 0; i < cantidad; i++) {
                System.out.println("  Calculo " + (i + 1) + ": " + historial[i]);
            }
        }

        System.out.println("------------------------------------------");
    }

    // Verifica si el texto ingresado es un numero valido
    private static boolean esNumero(String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Crea un objeto Funcion temporal para verificar si es reconocida
    private static boolean esFuncionValida(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return false;
        }
        Funcion temporal = new Funcion(texto);
        return !temporal.getTipoFuncion().equals("DESCONOCIDA");
    }
}
