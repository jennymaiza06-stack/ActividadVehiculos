package ec.edu.espoch.proyectointegrador.Model.objects;

public class ProcesoLimite {

    private String pasos;
    private double resultadoFinal;

    //Constructor
    public ProcesoLimite() {
    }

    //Metodos
    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public double getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(double resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

public String generarProcedimiento(Limite limite, double resultado) {
        String expresionOriginal = limite.getFuncion().getExpresion();
        String tipo = limite.getFuncion().getTipoFuncion();
        double valorX = limite.getValorX();
        String aproximacion = limite.getAproximacion();

        String sustituido = expresionOriginal.toLowerCase().replace("x", "(" + valorX + ")");

        String valorMostrar;
        if (Double.isNaN(resultado) || Double.isInfinite(resultado)) {
            valorMostrar = "no existe";
        } else {
            valorMostrar = "" + resultado;
        }

        // Caso especial: parentesis mal escritos
        if (aproximacion.equals("paréntesis")) {
            String aviso = "Revisa los paréntesis: faltan abrir o cerrar.\n"
                    + "Ejemplo correcto: (x^2-4)/(x-2)\n"
                    + "Resultado = no disponible";
            this.pasos = aviso;
            this.resultadoFinal = resultado;
            return aviso;
        }

        String proceso = "Tipo de función: " + tipo + "\n"
                + "Lim(x->" + valorX + ") " + expresionOriginal + "\n"
                + "Sustituyendo x = " + valorX + ":\n"
                + sustituido + "\n";

        if (aproximacion.equals("indeterminado")) {
            proceso += "Se obtiene una indeterminación (0/0).\n"
                    + "Se resuelve acercandose al punto por la izquierda y la derecha.\n"
                    + "Resultado = " + valorMostrar;
        } else if (aproximacion.equals("no existe")) {
            proceso += "Los límites laterales no coinciden.\n"
                    + "Resultado = " + valorMostrar;
        } else {
            proceso += "Resultado = " + valorMostrar;
        }

        this.pasos = proceso;
        this.resultadoFinal = resultado;
        return proceso;
    }
}
