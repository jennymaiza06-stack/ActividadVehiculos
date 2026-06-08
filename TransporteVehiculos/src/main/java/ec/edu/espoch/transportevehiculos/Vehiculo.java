
package ec.edu.espoch.transportevehiculos;

import TransporteDao.DaoVehiculo;


public abstract class Vehiculo implements DaoVehiculo {

  private float Velocidad;
  private float Tiempo;
  private float Eficiencia;

    public Vehiculo() {
    }

    public Vehiculo(float Velocidad, float Tiempo, float Eficiencia) {
        this.Velocidad = Velocidad;
        this.Tiempo = Tiempo;
        this.Eficiencia = Eficiencia;
    }

  
    public double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(float Velocidad) {
        this.Velocidad = Velocidad;
    }

    public double getTiempo() {
        return Tiempo;
    }

    public void setTiempo(float Tiempo) {
        this.Tiempo = Tiempo;
    }

    public double getEficiencia() {
        return Eficiencia;
    }

    public void setEficiencia(float Eficiencia) {
        this.Eficiencia = Eficiencia;
    }
  
  
    // Sobrecarga de métodos
    public double calcularDistancia(float velocidad) {
        return velocidad * 1;
    }

    public double calcularDistancia(float velocidad, float tiempo) {
        return velocidad * tiempo;
    }

    public double calcularDistancia(float velocidad, float tiempo, float eficiencia) {
        return velocidad * tiempo * eficiencia;
    }

    // Método abstracto
    public abstract void transportar();
}
