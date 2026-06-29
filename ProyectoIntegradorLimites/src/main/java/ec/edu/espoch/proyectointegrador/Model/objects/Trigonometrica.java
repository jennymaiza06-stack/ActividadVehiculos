package ec.edu.espoch.proyectointegrador.Model.objects;


public class Trigonometrica extends Expresion {

    //Atributos
    private String tipo;
    private Expresion subExpresion;

    //Constructor
    public Trigonometrica(String tipo, Expresion subExpresion) {
        this.tipo = tipo;
        this.subExpresion = subExpresion;
    }

    //Metodos
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Expresion getSubExpresion() {
        return subExpresion;
    }

    public void setSubExpresion(Expresion subExpresion) {
        this.subExpresion = subExpresion;
    }

    @Override
    public double evaluar(double x) {
        double argumento = subExpresion.evaluar(x);
        switch (tipo) {
            case "sin": return Math.sin(argumento);
            case "cos": return Math.cos(argumento);
            case "tan": return Math.tan(argumento);
            default:    return 0;
        }
    }

    @Override
    public String identificarTipo() {
        return "Trigonométrica";
    }
}
