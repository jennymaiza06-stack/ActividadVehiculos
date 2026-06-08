package TransporteDao;

public interface DaoVehiculo {

public double calcularDistancia(float velocidad);
    
public double calcularDistancia(float velocidad, float tiempo);
     
public double calcularDistancia(float velocidad, float tiempo, float eficiencia);
      
public abstract void transportar();
}
