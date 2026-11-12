package espoch.edu.ec.yasuni.access;

import espoch.edu.ec.yasuni.objects.Guide;

public interface GuideDAO {
    boolean save(Guide guide);
    Guide findByNationalId(String nationalId);
    Guide[] findAll();
}
