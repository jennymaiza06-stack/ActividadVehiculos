package espoch.edu.ec.yasuni.data;

import espoch.edu.ec.yasuni.access.GuideDAO;
import espoch.edu.ec.yasuni.objects.Guide;

public class GuideDAOArray implements GuideDAO {
    private Guide[] guides;
    private int count;

    public GuideDAOArray(int capacity) {
        guides = new Guide[capacity];
        count = 0;
    }

    @Override
    public boolean save(Guide guide) {
        if (count < guides.length) {
            guides[count++] = guide;
            return true;
        }
        return false;
    }

    @Override
    public Guide findByNationalId(String nationalId) {
        for (int i = 0; i < count; i++) {
            if (guides[i].getNationalId().equalsIgnoreCase(nationalId)) {
                return guides[i];
            }
        }
        return null;
    }

    @Override
    public Guide[] findAll() {
        Guide[] activeGuides = new Guide[count];
        System.arraycopy(guides, 0, activeGuides, 0, count);
        return activeGuides;
    }
}
