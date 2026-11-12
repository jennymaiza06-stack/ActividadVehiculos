package espoch.edu.ec.yasuni.data;

import espoch.edu.ec.yasuni.access.TourDAO;
import espoch.edu.ec.yasuni.objects.Tour;

public class TourDAOArray implements TourDAO {
    private Tour[] tours;
    private int count;

    public TourDAOArray(int capacity) {
        tours = new Tour[capacity];
        count = 0;
    }

    @Override
    public boolean save(Tour tour) {
        if (count < tours.length) {
            tours[count++] = tour;
            return true;
        }
        return false;
    }

    @Override
    public Tour findByCode(String code) {
        for (int i = 0; i < count; i++) {
            if (tours[i].getCode().equalsIgnoreCase(code)) {
                return tours[i];
            }
        }
        return null;
    }

    @Override
    public Tour[] findAll() {
        Tour[] activeTours = new Tour[count];
        System.arraycopy(tours, 0, activeTours, 0, count);
        return activeTours;
    }
}
