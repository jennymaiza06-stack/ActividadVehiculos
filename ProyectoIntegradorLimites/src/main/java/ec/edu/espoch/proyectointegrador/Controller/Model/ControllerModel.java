package ec.edu.espoch.proyectointegrador.Controller.Model;

import ec.edu.espoch.proyectointegrador.Controller.Interfaces.Vista;
import ec.edu.espoch.proyectointegrador.Model.daointerface.DaoFuncion;
import ec.edu.espoch.proyectointegrador.Model.daointerface.DaoLimite;
import ec.edu.espoch.proyectointegrador.Model.datasource.Funciones;
import ec.edu.espoch.proyectointegrador.Model.datasource.Limites;
import ec.edu.espoch.proyectointegrador.Model.objects.Funcion;
import ec.edu.espoch.proyectointegrador.Model.objects.Historial;
import ec.edu.espoch.proyectointegrador.Model.objects.Limite;
import ec.edu.espoch.proyectointegrador.Model.objects.ProcesoLimite;

import java.time.LocalDate;

public class ControllerModel {

    private Vista vista;
    private DaoFuncion daoFuncion;
    private DaoLimite daoLimite;
    private Funcion ultimaFuncion;
    private double ultimoValorX;
    private double ultimoResultado;

    public ControllerModel(Vista vista) {
        this.vista = vista;
        this.daoFuncion = new Funciones();
        this.daoLimite = new Limites();
    }

    public void calcularLimite() {
        String expresion = vista.getExpresion();
        String textoX = vista.getValorX();

        // Campo vacio
        if (expresion.isEmpty() || textoX.isEmpty()) {
            vista.mostrarResultado("Campo vacío");
            return;
        }

        // Valor de x invalido (ej. una letra)
        double valorX;
        try {
            valorX = Double.parseDouble(textoX);
        } catch (NumberFormatException e) {
            vista.mostrarResultado("Ingrese valores validos");
            return;
        }

        try {
            Funcion funcion = new Funcion("f", expresion);
            daoFuncion.agregar(funcion);
            daoFuncion.identificarTipo(funcion);
            Limite limite = new Limite(funcion, valorX, "");
            double resultado = daoLimite.calcularLimite(limite);
            ProcesoLimite proceso = new ProcesoLimite();
            String texto = proceso.generarProcedimiento(limite, resultado);
            vista.mostrarResultado(texto);
            String fecha = LocalDate.now().toString();
            Historial historial = new Historial(expresion, resultado, limite.getAproximacion(), fecha);
            daoLimite.guardarHistorial(historial);
            ultimaFuncion = funcion;
            ultimoValorX = valorX;
            ultimoResultado = resultado;
            graficarLimite();
        } catch (Exception e) {
            e.printStackTrace();
            vista.mostrarError();
        }
    }

    public void verHistorial() {
        Historial[] historiales = daoLimite.getHistorial();
        vista.mostrarHistorial(historiales);
    }

    public void graficarLimite() {
        if (ultimaFuncion == null) {
            return;
        }

        double centro = ultimoValorX;
        double desde = centro - 5;
        double hasta = centro + 5;
        double paso = 0.2;

        int maximo = (int) ((hasta - desde) / paso) + 2;
        double[] tempX = new double[maximo];
        double[] tempY = new double[maximo];
        int contador = 0;

        double x = desde;
        while (x <= hasta) {
            try {
                double y = daoFuncion.evaluar(ultimaFuncion, x);
                if (!Double.isNaN(y) && !Double.isInfinite(y)) {
                    tempX[contador] = x;
                    tempY[contador] = y;
                    contador++;
                }
            } catch (Exception e) {
                // punto invalido (fuera de dominio), se salta
            }
            x += paso;
        }

        double[] valoresX = new double[contador];
        double[] valoresY = new double[contador];
        for (int i = 0; i < contador; i++) {
            valoresX[i] = tempX[i];
            valoresY[i] = tempY[i];
        }

        vista.mostrarGrafica(valoresX, valoresY, ultimoValorX, ultimoResultado);
    }
}