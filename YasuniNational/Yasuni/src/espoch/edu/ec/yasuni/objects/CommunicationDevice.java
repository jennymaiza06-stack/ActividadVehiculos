package espoch.edu.ec.yasuni.objects;

public class CommunicationDevice {
    private String code;
    private String description;
    private boolean available;

    public CommunicationDevice(String code, String description, boolean available) {
        this.code = code;
        this.description = description;
        this.available = available;
    }

    public String getCode() { return code; }
    public String getDescription() { return description; }
    public boolean isAvailable() { return available; }

    public void setCode(String code) { this.code = code; }
    public void setDescription(String description) { this.description = description; }
    public void setAvailable(boolean available) { this.available = available; }
}
