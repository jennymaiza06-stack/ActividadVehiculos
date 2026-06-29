package ec.edu.espoch.proyectointegrador.Model.daointerface;

import ec.edu.espoch.proyectointegrador.Model.objects.Funcion;


public interface DaoFuncion {

    public void identificarTipo(Funcion funcion);

    public boolean agregar(Funcion funcion);

    public double evaluar(Funcion funcion, double x);  // ← cambia

    public void print();
}