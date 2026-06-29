package ec.edu.espoch.proyectointegrador.Model.objects;


public class Funcion {

    private String nombre;
    private String tipoFuncion;
    private String expresion;
    private Termino[] terminos;
    private int indice;

    // Constructor vacío
    public Funcion() {
    }

    // Constructor con parámetros
    public Funcion(String nombre, String expresion) {
        this.nombre = nombre;
        this.expresion = expresion;
        this.terminos = new Termino[10];
        this.indice = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoFuncion() {
        return tipoFuncion;
    }

    public void setTipoFuncion(String tipoFuncion) {
        this.tipoFuncion = tipoFuncion;
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    public Termino[] getTerminos() {
        return terminos;
    }

    public int getIndice() {
        return indice;
    }

    public void agregarTermino(Termino termino) {
        if (indice < terminos.length) {
            terminos[indice] = termino;
            indice++;
        }
    }

}