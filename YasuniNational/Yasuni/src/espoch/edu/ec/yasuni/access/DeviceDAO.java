package espoch.edu.ec.yasuni.access;

import espoch.edu.ec.yasuni.objects.CommunicationDevice;

public interface DeviceDAO {
    boolean save(CommunicationDevice device);
    CommunicationDevice findByCode(String code);
    CommunicationDevice[] findAll();
}
