package ec.edu.espoch.proyectointegrador.Model.objects;


public class Historial {

    private String descripcion;
    private double resultado;
    private String aproximacion;
    private String fecha;

    //Constructor
    public Historial(String descripcion, double resultado, String aproximacion, String fecha) {
        this.descripcion = descripcion;
        this.resultado = resultado;
        this.aproximacion = aproximacion;
        this.fecha = fecha;
    }

    //Metodos
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public String getAproximacion() {
        return aproximacion;
    }

    public void setAproximacion(String aproximacion) {
        this.aproximacion = aproximacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}