package espoch.edu.ec.yasuni.data;

import espoch.edu.ec.yasuni.access.DeviceDAO;
import espoch.edu.ec.yasuni.objects.CommunicationDevice;

public class DeviceDAOArray implements DeviceDAO {
    private CommunicationDevice[] devices;
    private int count;

    public DeviceDAOArray(int capacity) {
        devices = new CommunicationDevice[capacity];
        count = 0;
    }

    @Override
    public boolean save(CommunicationDevice device) {
        if (count < devices.length) {
            devices[count++] = device;
            return true;
        }
        return false;
    }

    @Override
    public CommunicationDevice findByCode(String code) {
        for (int i = 0; i < count; i++) {
            if (devices[i].getCode().equalsIgnoreCase(code)) {
                return devices[i];
            }
        }
        return null;
    }

    @Override
    public CommunicationDevice[] findAll() {
        CommunicationDevice[] activeDevices = new CommunicationDevice[count];
        System.arraycopy(devices, 0, activeDevices, 0, count);
        return activeDevices;
    }
}
