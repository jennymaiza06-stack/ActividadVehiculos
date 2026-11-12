package espoch.edu.ec.yasuni;

import espoch.edu.ec.yasuni.access.DeviceDAO;
import espoch.edu.ec.yasuni.access.GuideDAO;
import espoch.edu.ec.yasuni.access.TourDAO;
import espoch.edu.ec.yasuni.data.DeviceDAOArray;
import espoch.edu.ec.yasuni.data.GuideDAOArray;
import espoch.edu.ec.yasuni.data.TourDAOArray;
import espoch.edu.ec.yasuni.objects.CommunicationDevice;
import espoch.edu.ec.yasuni.objects.Guide;
import espoch.edu.ec.yasuni.objects.InterpretiveTour;
import espoch.edu.ec.yasuni.objects.OrderCriterion;
import espoch.edu.ec.yasuni.objects.RegularTour;
import espoch.edu.ec.yasuni.objects.Tour;
import espoch.edu.ec.yasuni.objects.Trail;

public class Main {
    public static void main(String[] args) {
        // Inicializar DAOs con arreglos en memoria
        TourDAO tourDAO = new TourDAOArray(10);
        DeviceDAO deviceDAO = new DeviceDAOArray(10);
        GuideDAO guideDAO = new GuideDAOArray(10);

        // 1. Crear tours y senderos
        RegularTour tour1 = new RegularTour("T01", "Ruta Cuyabeno");
        tour1.addTrail(new Trail("Sendero Primario", 3.5, 45));
        tour1.addTrail(new Trail("Sendero Pantano", 2.0, 30));
        tourDAO.save(tour1);

        InterpretiveTour tour2 = new InterpretiveTour("T02", "Sendero Botanico Yasuni", 40);
        tour2.addTrail(new Trail("Selva Adentro", 5.0, 60));
        tourDAO.save(tour2);

        // 2. Registrar dispositivos y guias
        deviceDAO.save(new CommunicationDevice("DEV01", "Radio Satelital A", true));
        deviceDAO.save(new CommunicationDevice("DEV02", "Radio Satelital B", true));
        guideDAO.save(new Guide("1500123456", "Carlos Perez", true));
        guideDAO.save(new Guide("1500654321", "Maria Gomez", true));

        // 3. Inicializar Planificador
        TourPlanner planner = new TourPlanner(tourDAO, deviceDAO, guideDAO);

        // 4. Probar asignacion de recursos
        planner.assignResources("T01", "DEV01", "1500123456");
        // Intentar asignar recurso ya ocupado (debe rechazarse)
        planner.assignResources("T02", "DEV01", "1500654321");

        // 5. Probar ordenamiento por distancia
        System.out.println("\n--- Tours ordenados por Distancia ---");
        planner.setCriterion(OrderCriterion.DISTANCE);
        for (Tour t : planner.orderTours()) {
            t.print();
        }

        // 6. Probar ordenamiento por duracion
        System.out.println("\n--- Tours ordenados por Duracion ---");
        planner.setCriterion(OrderCriterion.DURATION);
        for (Tour t : planner.orderTours()) {
            t.print();
        }

        // 7. Probar cierre de sendero
        System.out.println("\n--- Cierre de Sendero ---");
        planner.closeTrail(tour1, "Sendero Pantano");
        tour1.print();
    }
}
