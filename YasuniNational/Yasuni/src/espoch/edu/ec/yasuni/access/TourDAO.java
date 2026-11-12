package espoch.edu.ec.yasuni.access;

import espoch.edu.ec.yasuni.objects.Tour;

public interface TourDAO {
    boolean save(Tour tour);
    Tour findByCode(String code);
    Tour[] findAll();
}
