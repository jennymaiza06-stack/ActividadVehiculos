package espoch.edu.ec.yasuni;

import espoch.edu.ec.yasuni.access.DeviceDAO;
import espoch.edu.ec.yasuni.access.GuideDAO;
import espoch.edu.ec.yasuni.access.TourDAO;
import espoch.edu.ec.yasuni.objects.CommunicationDevice;
import espoch.edu.ec.yasuni.objects.Guide;
import espoch.edu.ec.yasuni.objects.OrderCriterion;
import espoch.edu.ec.yasuni.objects.Tour;
import espoch.edu.ec.yasuni.objects.Trail;
import java.util.Scanner;

public class TourPlanner {
    private TourDAO tourDAO;
    private DeviceDAO deviceDAO;
    private GuideDAO guideDAO;
    private OrderCriterion criterion;
    private Scanner keyboard;

    public TourPlanner(TourDAO tourDAO, DeviceDAO deviceDAO, GuideDAO guideDAO) {
        this.tourDAO = tourDAO;
        this.deviceDAO = deviceDAO;
        this.guideDAO = guideDAO;
        this.criterion = OrderCriterion.DISTANCE;
        this.keyboard = new Scanner(System.in);
    }

    public OrderCriterion getCriterion() {
        return criterion;
    }

    public void setCriterion(OrderCriterion criterion) {
        this.criterion = criterion;
    }

    public boolean assignResources(String tourCode, String deviceCode, String guideId) {
        Tour tour = tourDAO.findByCode(tourCode);
        CommunicationDevice device = deviceDAO.findByCode(deviceCode);
        Guide guide = guideDAO.findByNationalId(guideId);

        if (tour != null && device != null && guide != null) {
            if (device.isAvailable() && guide.isAvailable()) {
                tour.setDevice(device);
                tour.setGuide(guide);
                device.setAvailable(false);
                guide.setAvailable(false);
                System.out.println("Asignacion exitosa para el tour: " + tour.getName());
                return true;
            }
        }
        System.out.println("Asignacion rechazada: Recursos no disponibles o datos incorrectos.");
        return false;
    }

    public double simulateDifficulty(double currentFactor) {
        System.out.print("Ingrese el porcentaje de incremento (ej: 10 para 10%): ");
        double percentage = keyboard.nextDouble();
        return currentFactor * (1.0 + (percentage / 100.0));
    }

    public boolean closeTrail(Tour tour, String trailName) {
        Trail trail = tour.findTrail(trailName);
        if (trail != null) {
            trail.setEnabled(false);
            System.out.println("Sendero '" + trailName + "' deshabilitado correctamente.");
            return true;
        }
        System.out.println("Sendero no encontrado.");
        return false;
    }

    public Tour[] orderTours() {
        Tour[] tours = tourDAO.findAll();
        for (int i = 0; i < tours.length - 1; i++) {
            for (int j = 0; j < tours.length - i - 1; j++) {
                boolean condition = false;
                if (criterion == OrderCriterion.DISTANCE) {
                    condition = tours[j].getTotalDistance() > tours[j + 1].getTotalDistance();
                } else {
                    condition = tours[j].getTotalDuration() > tours[j + 1].getTotalDuration();
                }

                if (condition) {
                    Tour temp = tours[j];
                    tours[j] = tours[j + 1];
                    tours[j + 1] = temp;
                }
            }
        }
        return tours;
    }
}
