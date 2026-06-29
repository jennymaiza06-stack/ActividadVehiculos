package ec.edu.espoch.proyectointegrador.Model.objects;


public class Logaritmo extends Expresion {

    //Atributos
    private String tipo;
    private Expresion subExpresion;
    
    
    //Constructor

    public Logaritmo(String tipo, Expresion subExpresion) {
        this.tipo = tipo;
        this.subExpresion = subExpresion;
    }
    
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Expresion getSubExpresion() {
        return subExpresion;
    }

    //Metodos
    public void setSubExpresion(Expresion subExpresion) {    
        this.subExpresion = subExpresion;
    }

  @Override
    public double evaluar(double x) {
        double argumento = subExpresion.evaluar(x);
        switch (tipo) {
            case "ln":  return Math.log(argumento);
            case "log": return Math.log10(argumento);
            default:    return 0;
        }
    }

    @Override
    public String identificarTipo() {
        return "Logarítmo";
    }
}