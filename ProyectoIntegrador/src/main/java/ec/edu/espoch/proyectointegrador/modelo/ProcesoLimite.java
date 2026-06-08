package ec.edu.espoch.proyectointegrador.modelo;

// Genera el procedimiento paso a paso del calculo del limite
public class ProcesoLimite {

    private String pasos;
    private double resultadoFinal;

    public ProcesoLimite() {
        this.pasos = "";
        this.resultadoFinal = 0;
    }

    public String getPasos() {
        return this.pasos;
    }

    public double getResultadoFinal() {
        return this.resultadoFinal;
    }

    // Genera el procedimiento completo para calcular el limite de f(x) cuando x tiende al valor dado
    public String generarProcedimiento(String nombre, double x) {

        String f = normalizarFuncion(nombre);
        String texto = "";

        // PASO 1: Sustitucion directa
        texto = texto + "  Funcion: f(x) = " + f + "\n";
        texto = texto + "  Calcular: lim f(x) cuando x -> " + x + "\n\n";
        texto = texto + "  PASO 1: Sustitucion directa\n";
        texto = texto + "  Se reemplaza x por " + x + " en la funcion:\n\n";

        boolean esFraccion = detectarFraccion(f);

        if (esFraccion) {

            // Separar en numerador y denominador
            String[] partes = separarFraccion(f);
            String exprNum = partes[0];
            String exprDen = partes[1];

            texto = texto + "  Numerador  :  " + exprNum + "\n";
            texto = texto + "  Denominador:  " + exprDen + "\n\n";

            double valorNum = 0;
            double valorDen = 0;
            boolean errorDominio = false;
            String mensajeError = "";

            // Evaluar numerador
            try {
                Funcion fNum = new Funcion(exprNum);
                valorNum = fNum.evaluar(x);
            } catch (Exception e) {
                errorDominio = true;
                mensajeError = e.getMessage();
            }

            // Evaluar denominador
            try {
                Funcion fDen = new Funcion(exprDen);
                valorDen = fDen.evaluar(x);
            } catch (Exception e) {
                errorDominio = true;
                mensajeError = e.getMessage();
            }

            if (errorDominio) {
                texto = texto + "  ERROR: Valor fuera del dominio\n";
                texto = texto + "  " + mensajeError + "\n";
                this.resultadoFinal = Double.NaN;
                this.pasos = texto;
                return this.pasos;
            }

            // Mostrar la sustitución con los valores reales
            texto = texto + "  Sustituyendo x = " + x + ":\n";
            texto = texto + "  Numerador   -> " + exprNum.replace("x", "(" + x + ")") + " = " + valorNum + "\n";
            texto = texto + "  Denominador -> " + exprDen.replace("x", "(" + x + ")") + " = " + valorDen + "\n\n";

            if (Math.abs(valorNum) < 0.0001 && Math.abs(valorDen) < 0.0001) {

                // Indeterminacion 0/0
                texto = texto + "  Resultado: " + valorNum + " / " + valorDen + " = 0/0\n";
                texto = texto + "  -> Indeterminacion (0/0) detectada\n\n";
                texto = texto + "  PASO 2: Identificacion del metodo\n";
                texto = texto + "  Resultado 0/0 => Se aplica FACTORIZACION\n\n";
                texto = texto + "  PASO 3: Factorizacion\n\n";
                texto = texto + obtenerFactorizacion(f);
                texto = texto + "\n  PASO 4: Simplificacion algebraica\n\n";
                texto = texto + obtenerSimplificacion(f);
                texto = texto + "\n  PASO 5: Evaluacion final\n\n";
                texto = texto + obtenerEvaluacionFinal(f, x);
                this.resultadoFinal = calcularResultadoIndeterminacion(f, x);

            } else if (Math.abs(valorDen) < 0.0001) {

                // Division por cero sin indeterminacion
                texto = texto + "  Resultado: " + valorNum + " / 0\n";
                texto = texto + "  -> Division por cero: el limite no existe en x = " + x + "\n";
                this.resultadoFinal = Double.NaN;

            } else {

                // Sustitucion directa exitosa
                double res = valorNum / valorDen;
                texto = texto + "  Resultado: " + valorNum + " / " + valorDen + " = " + res + "\n\n";
                texto = texto + "  -> Sustitucion directa exitosa.\n";
                texto = texto + "  lim f(x) cuando x -> " + x + "  =  " + res + "\n";
                this.resultadoFinal = res;
            }

        } else {

            // Funcion simple: sustitución directa
            try {
                Funcion fObj = new Funcion(f);
                double res = fObj.evaluar(x);

                // Mostrar claramente el reemplazo de x
                texto = texto + "  f(" + x + ") = " + f.replace("x", "(" + x + ")") + "\n";
                texto = texto + "  f(" + x + ") = " + res + "\n\n";
                texto = texto + "  -> Sustitucion directa exitosa.\n";
                texto = texto + "  lim f(x) cuando x -> " + x + "  =  " + res + "\n";
                this.resultadoFinal = res;

            } catch (Exception e) {
                String msg = e.getMessage();
                if (msg != null && msg.contains("dominio")) {
                    texto = texto + "  ERROR: Valor fuera del dominio\n";
                } else {
                    texto = texto + "  ERROR: No se pudo evaluar la funcion\n";
                }
                texto = texto + "  " + msg + "\n";
                this.resultadoFinal = Double.NaN;
            }
        }

        this.pasos = texto;
        return this.pasos;
    }

    // Convierte notacion sin asterisco
    private String normalizarFuncion(String nombre) {
        String f = nombre.replace(" ", "");
        String res = "";
        for (int i = 0; i < f.length(); i++) {
            char actual = f.charAt(i);
            if (actual == 'x' && i > 0) {
                char anterior = f.charAt(i - 1);
                if (anterior >= '0' && anterior <= '9') {
                    res = res + "*";
                }
            }
            res = res + actual;
        }
        return res;
    }

    // Detecta si la funcion tiene la forma numerador/denominador
    private boolean detectarFraccion(String f) {
        int nivel = 0;
        for (int i = 0; i < f.length(); i++) {
            char c = f.charAt(i);
            if (c == '(')           { nivel = nivel + 1; }
            else if (c == ')')      { nivel = nivel - 1; }
            else if (c == '/' && nivel == 0) { return true; }
        }
        return false;
    }

    // Separa la funcion en [numerador, denominador]
    private String[] separarFraccion(String f) {
        String[] resultado = new String[2];
        int nivel = 0;
        for (int i = 0; i < f.length(); i++) {
            char c = f.charAt(i);
            if (c == '(')           { nivel = nivel + 1; }
            else if (c == ')')      { nivel = nivel - 1; }
            else if (c == '/' && nivel == 0) {
                resultado[0] = f.substring(0, i);
                resultado[1] = f.substring(i + 1);
                return resultado;
            }
        }
        resultado[0] = f;
        resultado[1] = "1";
        return resultado;
    }

    // Retorna el texto de la factorizacion para cada funcion conocida
    private String obtenerFactorizacion(String f) {
        switch (f) {
            case "(x^2-4)/(x-2)":
                return "  x^2 - 4 = (x - 2)(x + 2)\n  f(x) = (x - 2)(x + 2) / (x - 2)\n";
            case "(x^2-1)/(x-1)":
                return "  x^2 - 1 = (x - 1)(x + 1)\n  f(x) = (x - 1)(x + 1) / (x - 1)\n";
            case "(x^2-9)/(x-3)":
                return "  x^2 - 9 = (x - 3)(x + 3)\n  f(x) = (x - 3)(x + 3) / (x - 3)\n";
            case "(x^2-16)/(x-4)":
                return "  x^2 - 16 = (x - 4)(x + 4)\n  f(x) = (x - 4)(x + 4) / (x - 4)\n";
            case "(x^2-25)/(x-5)":
                return "  x^2 - 25 = (x - 5)(x + 5)\n  f(x) = (x - 5)(x + 5) / (x - 5)\n";
            case "(x^3-8)/(x-2)":
                return "  x^3 - 8 = (x - 2)(x^2 + 2x + 4)  [diferencia de cubos]\n"
                     + "  f(x) = (x - 2)(x^2 + 2x + 4) / (x - 2)\n";
            case "(x^3-27)/(x-3)":
                return "  x^3 - 27 = (x - 3)(x^2 + 3x + 9)  [diferencia de cubos]\n"
                     + "  f(x) = (x - 3)(x^2 + 3x + 9) / (x - 3)\n";
            case "(x^3-1)/(x-1)":
                return "  x^3 - 1 = (x - 1)(x^2 + x + 1)  [diferencia de cubos]\n"
                     + "  f(x) = (x - 1)(x^2 + x + 1) / (x - 1)\n";
            case "(x^2+3*x)/(x)":
            case "(x^2+3x)/(x)":
                return "  x^2 + 3x = x(x + 3)  [factor comun x]\n"
                     + "  f(x) = x(x + 3) / x\n";
            case "(2*x^2+4*x)/(x)":
            case "(2x^2+4x)/(x)":
                return "  2x^2 + 4x = 2x(x + 2)  [factor comun 2x]\n"
                     + "  f(x) = 2x(x + 2) / x\n";
            case "(x^2-5*x+6)/(x-2)":
            case "(x^2-5x+6)/(x-2)":
                return "  x^2 - 5x + 6 = (x - 2)(x - 3)\n"
                     + "  f(x) = (x - 2)(x - 3) / (x - 2)\n";
            case "(x^2+x-2)/(x-1)":
                return "  x^2 + x - 2 = (x - 1)(x + 2)\n"
                     + "  f(x) = (x - 1)(x + 2) / (x - 1)\n";
            default:
                return "  Se aplica factorizacion algebraica.\n";
        }
    }

    // Retorna el texto de la simplificacion
    private String obtenerSimplificacion(String f) {
        switch (f) {
            case "(x^2-4)/(x-2)":    return "  Se cancela (x - 2):\n  f(x) = (x + 2)   con x != 2\n";
            case "(x^2-1)/(x-1)":    return "  Se cancela (x - 1):\n  f(x) = (x + 1)   con x != 1\n";
            case "(x^2-9)/(x-3)":    return "  Se cancela (x - 3):\n  f(x) = (x + 3)   con x != 3\n";
            case "(x^2-16)/(x-4)":   return "  Se cancela (x - 4):\n  f(x) = (x + 4)   con x != 4\n";
            case "(x^2-25)/(x-5)":   return "  Se cancela (x - 5):\n  f(x) = (x + 5)   con x != 5\n";
            case "(x^3-8)/(x-2)":    return "  Se cancela (x - 2):\n  f(x) = x^2 + 2x + 4   con x != 2\n";
            case "(x^3-27)/(x-3)":   return "  Se cancela (x - 3):\n  f(x) = x^2 + 3x + 9   con x != 3\n";
            case "(x^3-1)/(x-1)":    return "  Se cancela (x - 1):\n  f(x) = x^2 + x + 1   con x != 1\n";
            case "(x^2+3*x)/(x)":
            case "(x^2+3x)/(x)":     return "  Se cancela x:\n  f(x) = (x + 3)   con x != 0\n";
            case "(2*x^2+4*x)/(x)":
            case "(2x^2+4x)/(x)":    return "  Se cancela x:\n  f(x) = 2(x + 2)   con x != 0\n";
            case "(x^2-5*x+6)/(x-2)":
            case "(x^2-5x+6)/(x-2)": return "  Se cancela (x - 2):\n  f(x) = (x - 3)   con x != 2\n";
            case "(x^2+x-2)/(x-1)":  return "  Se cancela (x - 1):\n  f(x) = (x + 2)   con x != 1\n";
            default:                  return "  Se simplifica la expresion.\n";
        }
    }

    // Retorna el texto de la evaluacion final con el valor numerico
    private String obtenerEvaluacionFinal(String f, double x) {
        switch (f) {
            
            case "(x^2-4)/(x-2)":   return "  f(" + x + ") = " + x + " + 2 = " + (x + 2) + "\n";
            case "(x^2-1)/(x-1)":   return "  f(" + x + ") = " + x + " + 1 = " + (x + 1) + "\n";
            case "(x^2-9)/(x-3)":   return "  f(" + x + ") = " + x + " + 3 = " + (x + 3) + "\n";
            case "(x^2-16)/(x-4)":  return "  f(" + x + ") = " + x + " + 4 = " + (x + 4) + "\n";
            case "(x^2-25)/(x-5)":  return "  f(" + x + ") = " + x + " + 5 = " + (x + 5) + "\n";
            case "(x^3-8)/(x-2)": {
                double r = (x * x) + (2 * x) + 4;
                return "  f(" + x + ") = (" + x + ")^2 + 2*(" + x + ") + 4 = " + r + "\n";
            }
            case "(x^3-27)/(x-3)": {
                double r = (x * x) + (3 * x) + 9;
                return "  f(" + x + ") = (" + x + ")^2 + 3*(" + x + ") + 9 = " + r + "\n";
            }
            case "(x^3-1)/(x-1)": {
                double r = (x * x) + x + 1;
                return "  f(" + x + ") = (" + x + ")^2 + " + x + " + 1 = " + r + "\n";
            }
            case "(x^2+3*x)/(x)":
            case "(x^2+3x)/(x)":    return "  f(" + x + ") = " + x + " + 3 = " + (x + 3) + "\n";
            case "(2*x^2+4*x)/(x)":
            case "(2x^2+4x)/(x)": {
                double r = 2 * (x + 2);
                return "  f(" + x + ") = 2*(" + x + " + 2) = " + r + "\n";
            }
            case "(x^2-5*x+6)/(x-2)":
            case "(x^2-5x+6)/(x-2)": return "  f(" + x + ") = " + x + " - 3 = " + (x - 3) + "\n";
            case "(x^2+x-2)/(x-1)":  return "  f(" + x + ") = " + x + " + 2 = " + (x + 2) + "\n";
            default:                  return "  Se evalua en la expresion simplificada.\n";
        }
    }

    // Calcula el resultado numerico del limite tras resolver la indeterminacion
    private double calcularResultadoIndeterminacion(String f, double x) {
        switch (f) {
            case "(x^2-4)/(x-2)":      return x + 2;
            case "(x^2-1)/(x-1)":      return x + 1;
            case "(x^2-9)/(x-3)":      return x + 3;
            case "(x^2-16)/(x-4)":     return x + 4;
            case "(x^2-25)/(x-5)":     return x + 5;
            case "(x^3-8)/(x-2)":      return (x * x) + (2 * x) + 4;
            case "(x^3-27)/(x-3)":     return (x * x) + (3 * x) + 9;
            case "(x^3-1)/(x-1)":      return (x * x) + x + 1;
            case "(x^2+3*x)/(x)":
            case "(x^2+3x)/(x)":       return x + 3;
            case "(2*x^2+4*x)/(x)":
            case "(2x^2+4x)/(x)":      return 2 * (x + 2);
            case "(x^2-5*x+6)/(x-2)":
            case "(x^2-5x+6)/(x-2)":   return x - 3;
            case "(x^2+x-2)/(x-1)":    return x + 2;
            default:                    return Double.NaN;
        }
    }
}