package ec.edu.espoch.proyectointegrador.modelo;

// Representa una funcion matematica con nombre, tipo y constante
public class Funcion {

    private String nombre;
    private String tipoFuncion;
    private double constante;

    public Funcion() {
    }

    // Crea la funcion y detecta su tipo
    public Funcion(String nom) {
        this.nombre = nom;
        this.tipoFuncion = "";
        this.constante = 0;
        this.identificarTipo();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoFuncion() {
        return this.tipoFuncion;
    }

    public void setTipoFuncion(String tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    public double getConstante() {
        return this.constante;
    }

    public void setConstante(double constante) {
        this.constante = constante;
    }

    // Identifica el tipo de funcion y valida si el sistema la reconoce.
    // Asigna "DESCONOCIDA" si no esta en la lista
    public void identificarTipo() {

        if (this.nombre == null || this.nombre.trim().isEmpty()) {
            this.tipoFuncion = "DESCONOCIDA";
            return;
        }

        String f = normalizarFuncion(this.nombre);

        // Logaritmo de base n: log_2(x), log_5(x), etc.
        if (f.startsWith("log_")) {
            if (f.contains("(") && f.contains(")")) {
                int posGuion  = f.indexOf("_");
                int posParent = f.indexOf("(");
                if (posParent > posGuion + 1) {
                    String baseStr = f.substring(posGuion + 1, posParent);
                    try {
                        int base = Integer.parseInt(baseStr);
                        if (base >= 2) {
                            this.tipoFuncion = "LOGARITMICA";
                            return;
                        }
                    } catch (NumberFormatException e) {
        // base no valida
                    }
                }
            }
            this.tipoFuncion = "DESCONOCIDA";
            return;
        }

        // Arreglo con todas las funciones que el sistema puede resolver
        String[] funcionesValidas = {
            "x^2-4",  "x^2+4",  "x^2-1",  "x^2-9",  "x^2-16", "x^2-25",
            "x^3",    "x^3-8",  "x^3-27", "x^3-1",
            "2*x+3",  "2*x-3",  "3*x+1",  "5*x-1",
            "3*x^2",  "2*x^2", 
            "x^2+2*x","x^2-2*x","x^2+3*x","x^2-3*x",
            "3*x^2-5*x+1","x^2+x-2","x^2-5*x+6","2*x^2+4*x",
            "(x^2-4)/(x-2)",   "(x^2-1)/(x-1)",   "(x^2-9)/(x-3)",
            "(x^2-16)/(x-4)",  "(x^2-25)/(x-5)",
            "(x^3-8)/(x-2)",   "(x^3-27)/(x-3)",  "(x^3-1)/(x-1)",
            "(x^2+3*x)/(x)",   "(x^2+3x)/(x)",
            "(2*x^2+4*x)/(x)", "(2x^2+4x)/(x)",
            "(x^2-5*x+6)/(x-2)","(x^2-5x+6)/(x-2)",
            "(x^2+x-2)/(x-1)",
            "sqrt(x)",
            "sin(x)", "cos(x)", "tan(x)",
            "ln(x)",  "log(x)"
        };

        // Recorrer el arreglo para buscar la funcion
        for (int i = 0; i < funcionesValidas.length; i++) {
            if (funcionesValidas[i].equals(f)) {
                // Asignar el tipo segun la funcion encontrada
                if (f.equals("ln(x)") || f.equals("log(x)")) {
                    this.tipoFuncion = "LOGARITMICA";
                } else if (f.equals("sin(x)") || f.equals("cos(x)") || f.equals("tan(x)")) {
                    this.tipoFuncion = "TRIGONOMETRICA";
                } else if (f.equals("sqrt(x)")) {
                    this.tipoFuncion = "IRRACIONAL";
                } else if (f.contains("/")) {
                    this.tipoFuncion = "RACIONAL";
                    this.constante = 0;
                } else {
                    this.tipoFuncion = "POLINOMICA";
                    // Extraer la constante del inicio si existe
                    if (f.length() > 0 && f.charAt(0) >= '1' && f.charAt(0) <= '9') {
                        this.constante = f.charAt(0) - '0';
                    } else {
                        this.constante = 1;
                    }
                }
                return;
            }
        }

        this.tipoFuncion = "DESCONOCIDA";
    }

    // Evalua la funcion en el valor x dado
    public double evaluar(double x) {

        String f = normalizarFuncion(this.nombre);

        // Logaritmo de base n
        if (f.startsWith("log_")) {
            int posGuion  = f.indexOf("_");
            int posParent = f.indexOf("(");
            if (posGuion >= 0 && posParent > posGuion) {
                int base = Integer.parseInt(f.substring(posGuion + 1, posParent));
                if (x <= 0) {
                    throw new ArithmeticException(
                        "Valor fuera del dominio: log_" + base + " requiere x > 0");
                }
                return Math.log(x) / Math.log(base);
            }
        }

        // Evaluar segun la funcion correspondiente
        switch (f) {
            
            case "x^2-4":           return (x * x) - 4;
            case "x^2+4":           return (x * x) + 4;
            case "x^2-1":           return (x * x) - 1;
            case "x^2-9":           return (x * x) - 9;
            case "x^2-16":          return (x * x) - 16;
            case "x^2-25":          return (x * x) - 25;
            case "x^3":             return x * x * x;
            case "x^3-8":           return (x * x * x) - 8;
            case "x^3-27":          return (x * x * x) - 27;
            case "x^3-1":           return (x * x * x) - 1;
            case "2*x+3":           return (2 * x) + 3;
            case "2*x-3":           return (2 * x) - 3;
            case "3*x+1":           return (3 * x) + 1;
            case "5*x-1":           return (5 * x) - 1;
            case "3*x^2":           return 3 * (x * x);
            case "2*x^2":           return 2 * (x * x);
            case "x^2+2*x":         return (x * x) + (2 * x);
            case "x^2-2*x":         return (x * x) - (2 * x);
            case "x^2+3*x":         return (x * x) + (3 * x);
            case "x^2-3*x":         return (x * x) - (3 * x);
            case "3*x^2-5*x+1":     return (3 * x * x) - (5 * x) + 1;
            case "x^2+x-2":         return (x * x) + x - 2;
            case "x^2-5*x+6":       return (x * x) - (5 * x) + 6;
            case "2*x^2+4*x":       return (2 * x * x) + (4 * x);

            case "(x^2-4)/(x-2)": {
                double den = x - 2;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) - 4) / den;
            }
            case "(x^2-1)/(x-1)": {
                double den = x - 1;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) - 1) / den;
            }
            case "(x^2-9)/(x-3)": {
                double den = x - 3;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) - 9) / den;
            }
            case "(x^2-16)/(x-4)": {
                double den = x - 4;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) - 16) / den;
            }
            case "(x^2-25)/(x-5)": {
                double den = x - 5;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) - 25) / den;
            }
            case "(x^3-8)/(x-2)": {
                double den = x - 2;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x * x) - 8) / den;
            }
            case "(x^3-27)/(x-3)": {
                double den = x - 3;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x * x) - 27) / den;
            }
            case "(x^3-1)/(x-1)": {
                double den = x - 1;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x * x) - 1) / den;
            }
            case "(x^2+3*x)/(x)":
            case "(x^2+3x)/(x)": {
                if (Math.abs(x) < 0.0001) throw new ArithmeticException("Division por cero");
                return ((x * x) + (3 * x)) / x;
            }
            case "(2*x^2+4*x)/(x)":
            case "(2x^2+4x)/(x)": {
                if (Math.abs(x) < 0.0001) throw new ArithmeticException("Division por cero");
                return (2 * (x * x) + (4 * x)) / x;
            }
            case "(x^2-5*x+6)/(x-2)":
            case "(x^2-5x+6)/(x-2)": {
                double den = x - 2;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) - (5 * x) + 6) / den;
            }
            case "(x^2+x-2)/(x-1)": {
                double den = x - 1;
                if (Math.abs(den) < 0.0001) throw new ArithmeticException("Indeterminacion (0/0)");
                return ((x * x) + x - 2) / den;
            }

            case "sqrt(x)": {
                if (x < 0) throw new ArithmeticException(
                    "Valor fuera del dominio: sqrt requiere x >= 0");
                return Math.sqrt(x);
            }

            case "sin(x)": return Math.sin(x);
            case "cos(x)": return Math.cos(x);
            case "tan(x)": {
                double cos = Math.cos(x);
                if (Math.abs(cos) < 0.0001) throw new ArithmeticException(
                    "Valor fuera del dominio: tan(x) no esta definida aqui");
                return Math.tan(x);
            }

            case "ln(x)": {
                if (x <= 0) throw new ArithmeticException(
                    "Valor fuera del dominio: ln requiere x > 0");
                return Math.log(x);
            }
            case "log(x)": {
                if (x <= 0) throw new ArithmeticException(
                    "Valor fuera del dominio: log requiere x > 0");
                return Math.log10(x);
            }

            default:
                throw new ArithmeticException("Funcion no reconocida: " + f);
        }
    }

    // Convierte notacion sin asterisco a notacion estandar
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
}
