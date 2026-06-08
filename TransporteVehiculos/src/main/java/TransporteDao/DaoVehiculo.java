package TransporteDao;

public interface DaoVehiculo {

public float calcularDistancia(float velocidad);
    
public float calcularDistancia(float velocidad, float tiempo);
     
public float calcularDistancia(float velocidad, float tiempo, float eficiencia);
      
public abstract void transportar();
}
