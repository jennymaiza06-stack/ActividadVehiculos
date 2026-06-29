package ec.edu.espoch.proyectointegrador.Model.daointerface;

import ec.edu.espoch.proyectointegrador.Model.objects.Historial;
import ec.edu.espoch.proyectointegrador.Model.objects.Limite;


public interface DaoLimite {
 
    public double calcularLimite(Limite limite);
    public void guardarHistorial(Historial historial);
    public Historial[] getHistorial();
    public void print();
 
}