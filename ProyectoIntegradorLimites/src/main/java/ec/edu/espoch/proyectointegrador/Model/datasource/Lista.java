package ec.edu.espoch.proyectointegrador.Model.datasource;

import ec.edu.espoch.proyectointegrador.Model.objects.Historial;

public class Lista {

    private Historial[] datos;
    private int indice;

    //Constructor
    public Lista() {
        this.datos = new Historial[50];
        this.indice = 0;
    }

    //Metodos
    public void agregar(Historial h) {
        if (indice < datos.length) {
            datos[indice] = h;
            indice++;
        }
    }

    public Historial obtener(int posicion) {
        return datos[posicion];
    }

    public Historial[] getDatos() {
        return datos;
    }

    public int getTamanio() {
        return indice;
    }

    public boolean estaVacia() {
        return indice == 0;
    }
}