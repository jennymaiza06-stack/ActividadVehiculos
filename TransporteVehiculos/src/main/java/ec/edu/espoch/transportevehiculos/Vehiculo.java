
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

  
    public float getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(float Velocidad) {
        this.Velocidad = Velocidad;
    }

    public float getTiempo() {
        return Tiempo;
    }

    public void setTiempo(float Tiempo) {
        this.Tiempo = Tiempo;
    }

    public float getEficiencia() {
        return Eficiencia;
    }

    public void setEficiencia(float Eficiencia) {
        this.Eficiencia = Eficiencia;
    }
  
  
    // Sobrecarga de métodos
  @Override
    public float calcularDistancia(float velocidad) {
        return velocidad * 1;
    }

  @Override
    public float calcularDistancia(float velocidad, float tiempo) {
        return velocidad * tiempo;
    }

  @Override
    public float calcularDistancia(float velocidad, float tiempo, float eficiencia) {
        return velocidad * tiempo * eficiencia;
    }

    // Método abstracto
  @Override
    public abstract void transportar();
}
